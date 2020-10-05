package com.team02.groupware.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team02.groupware.dto.ElectronicApprovalDocument;
import com.team02.groupware.mapper.ElectronicApprovalMapper;

/*
 * @file ElectronicApprovalService.java
 * @brief 전자결재 서비스 로직
 * @author 김건훈
 */

@Service
@Transactional
public class ElectronicApprovalService {
	
	 @Autowired //ElectronicApprovalMapper 의존성 주입
	 private ElectronicApprovalMapper eaMapper;
	 
	 /*
	  * @method insertDocumentForm()
	  * @brief 관리자용 문서 양식 생성 method(문서 양식 코드 최대값으로 insert)
	  * @author 김건훈
	  */
	 public int insertDocumentForm(ElectronicApprovalDocument eaDto) {
		
		 //문서 양식 코드 최대값으로 insert
		 int maxCode = eaMapper.selectEaDocumentFormMaxCode();
		 String maxCodeFormat = "EAF"+String.format("%03d", maxCode+1);
		 eaDto.setdFormCode(maxCodeFormat);
		 
		 //문서양식 insert
		 int result = eaMapper.insertDocumentForm(eaDto);
		 return result;
	 }
	 
	 /*
	  * @method deleteDocumentForm()
	  * @brief 관리자용 문서 양식 삭제 method
	  * @author 김건훈
	  */ 
	 public int deleteDocumentForm(List<String> eaDocumentFormListCodeArr) {
		 int result = eaMapper.deleteDocumentForm(eaDocumentFormListCodeArr);
		 return result;		 
	 }
	 
	 /*
	  * @method updateDocumentForm()
	  * @brief 관리자용 문서 양식 수정 method
	  * @author 김건훈
	  */
	 public int updateDocumentForm(ElectronicApprovalDocument eaDto) {
		 int result = eaMapper.updateDocumentForm(eaDto);
		 return result;		 
	 }
	 
	 /*
	  * @method selectEaDocumentForm()
	  * @brief 양식함관리 페이지 내 문서양식 테이블 조회 method
	  * @author 김건훈
	  */
	 public Map<String, Object> selectEaDocumentForm(Map<String, Object> map){
		
		 Map<String, Object> eaDocumentFormListMap = new HashMap<String,Object>();
		
		 //전체카운트 
		double eaDocumentFormListCount = eaMapper.selectEaDocumentFormCount(map);
	
		//보여줄 행의 갯수
		final int rowPerPage = 10;
		
		//보여줄 첫번째 페이지 번호
		int startPageNum = (int)map.get("startPageNum");
			
		//보여줄 페이지 개수
		int endPageNum = (int)map.get("endPageNum");
		
		//현재페이지번호
		int currentPageNum = (int)map.get("currentPage");
		
		//System.out.println(startPageNum+"<------- 컨트롤러에서 넘어온 start page");
		//System.out.println(endPageNum+"<------- 컨트롤러에서 넘어온 end page");
		//System.out.println(currentPageNum+"<------- 컨트롤러에서 넘어온 current page");

		//페이지 알고리즘
		int startRowPerPage = (currentPageNum-1)*rowPerPage;
			//System.out.println(startRowPerPage +"<------- 시작행");
		Map<String,Object> pageMap = new HashMap<String,Object>();
		
		pageMap.put("startRowPerPage", startRowPerPage);
		pageMap.put("rowPerPage", rowPerPage);
		pageMap.put("sk", map.get("sk"));
		pageMap.put("sv", map.get("sv"));
			
			
			
		//라스트페이지
		int lastPage = (int)Math.ceil(eaDocumentFormListCount/rowPerPage);
		//System.out.println(lastPage+"<-------last page");

		//1-5, 6-10 패턴으로 페이징 작업
		
		//정방향 진행(5단위로 넘어갈때)
		if(currentPageNum>endPageNum) {
			startPageNum+=5;
			endPageNum+=5;
			// 마지막페이지와 마지막행이있는 페이지 일치
			if(endPageNum>lastPage) {
				endPageNum=lastPage;
			}
		}
		
		//역순 진행(5단위로 돌아갈때)
		if(currentPageNum<startPageNum) {
			//마지막페이지가 5단위로 안끝나는경우 강제로 픽스
			endPageNum=startPageNum+4;
			
			startPageNum-=5;
			endPageNum-=5;
		}
		
		//맨 앞으로가기
		if(currentPageNum==1) {
			startPageNum=1;
			//endPageNum=5;
		}
		
		//맨 뒤로가기
		if(currentPageNum>=lastPage) {
			startPageNum=(lastPage-(lastPage%5))+1;
			endPageNum=lastPage;
			if(endPageNum==0) {
				endPageNum=1;
			}
		}
		
		//System.out.println(startPageNum+"<------- 페이징 가공 후 start page");
		//System.out.println(endPageNum+"<------- 페이징 가공 후  end page");
		//System.out.println(lastPage+"<------- 페이징 가공 후  last page");
		
		//양식 수 int로 형변환
		int intEaDocumentFormListCount = (int) eaDocumentFormListCount;
		
		eaDocumentFormListMap.put("eaDocumentFormList", eaMapper.selectEaDocumentForm(pageMap));
		eaDocumentFormListMap.put("eaDocumentFormListCount",intEaDocumentFormListCount);
		eaDocumentFormListMap.put("lastPage",lastPage);
		eaDocumentFormListMap.put("startPageNum",startPageNum);
		eaDocumentFormListMap.put("endPageNum",endPageNum);
		eaDocumentFormListMap.put("currentPageNum",currentPageNum);
		
		return eaDocumentFormListMap;
	 };
	 
	 /*
	  * @method selectDocumentFormForDetail()
	  * @brief 관리자용 문서양식 미리보기 위한 1개 정보조회 method
	  * @author 김건훈
	  */ 
	 public ElectronicApprovalDocument selectDocumentFormForDetail(String dFormCode){
		 ElectronicApprovalDocument eaDto = eaMapper.selectDocumentFormForDetail(dFormCode);
		 String dApprovalFormatDetailContent = eaMapper.selectApprovalFormatInDocumentFormForDetail(eaDto.getdApprovalFormatCode());
		 eaDto.setdApprovalFormatDetailContent(dApprovalFormatDetailContent);
		 
		 return eaDto;		 
	 }
	 
	 /*
	  * @method selectEaDocumentFormType()
	  * @brief 양식함관리 페이지 내 분류설정 테이블 조회 method
	  * @author 김건훈
	  */
	 public List<ElectronicApprovalDocument> selectEaDocumentFormType(){
		
		 List<ElectronicApprovalDocument> eaDocumentFormTypeList = eaMapper.selectEaDocumentFormType();
		 return eaDocumentFormTypeList;
	 };
	 
	 /*
	  * @method selectEaDocumentSetting()
	  * @brief 전자결재 기본설정 테이블 조회 method
	  * @author 김건훈
	  */
	 public List<ElectronicApprovalDocument> selectEaDocumentSetting(){
		
		 List<ElectronicApprovalDocument> eaDocumentSetting = eaMapper.selectEaDocumentSetting();
		 return eaDocumentSetting;
	 };
	 
	 
	 /*
	  * @method updateEaRule()
	  * @brief 전자결재 사내 전자결재 규정 UPDATE method
	  * @author 김건훈
	  */
	 public int updateEaRule(String eaRuleVal){
		
		 int result = eaMapper.updateEaRule(eaRuleVal);
		 return result;
	 };
	 
	 /*
	  * @method insertDocumentFormType()
	  * @brief 문서 양식 분류 insert method(문서 분류 코드 최대값 비교, 중복검사 처리 : result=0 중복되는 값 존재 result=1 db에 정상적으로 값 저장)
	  * @author 김건훈
	  */
	 public  Map<String,Object> insertDocumentFormType(ElectronicApprovalDocument eaDto){
		
		 //System.out.println(eaDto.getdFormType()+"<------- 컨트롤러에서 넘어온 문서 분류 val");
		 
		 Map<String,Object> resultMap = new HashMap<String,Object>();
		 
		 //중복검사
		 int result=0;
		 List<ElectronicApprovalDocument> documentFormTypeList = eaMapper.selectEaDocumentFormType();
		 for(int i = 0; i<documentFormTypeList.size(); i++) {
			 //System.out.println(documentFormTypeList.get(i).getdFormType()+"<--------db 에서 뽑아온 문서 양식 분류명");
			 if(documentFormTypeList.get(i).getdFormType().equals(eaDto.getdFormType())) {
				 //System.out.println("이미 중복된 문서양식분류명 존재");
				 resultMap.put("result", result);
				 return resultMap;
			 }
		 }
		 
		 //문서 양식 분류 코드 최대값 구하여 db에 값 저장
		 int maxCode = eaMapper.selectEaDocumentFormTypeMaxCode();
		 //System.out.println(maxCode+"<-------- db 에서 가져온 문서 분류코드 최대값");
		 String maxCodeFormat = "EATY"+String.format("%03d", maxCode+1);
		 //System.out.println(maxCodeFormat+"<-------- 가져온 문서 분류코드 최대값 +1 후 빈자리에 0으로 채워넣은 포맷 적용한 문서 분류코드 최대값");
		 
		 eaDto.setdFormTypeCode(maxCodeFormat);
		 
		 result = eaMapper.insertDocumentFormType(eaDto);
		 resultMap.put("result", result);
		 resultMap.put("formTypeCode", maxCodeFormat);
		 return resultMap;
	 };
	 
	 /*
	  * @method deleteDocumentFormType()
	  * @brief  문서 양식 분류 delete method(문서 양식 분류 삭제시 해당 양식 분류를 사용하는 문서 양식 수 select 및 존재 시 문서 양식 분류를 공통 분류로 update)
	  * @author 김건훈
	  */
	 public int deleteDocumentFormType(String deleteFormTypeCode){
		 int selectForDelete = eaMapper.selectDocumentFormForDeleteDocumentFormType(deleteFormTypeCode);
		 //System.out.println(selectForDelete+"<---삭제하려는 문서 양식 분류 코드를 사용하는 문서 양식 수 조회");
		
		 if(selectForDelete>0) {
			 eaMapper.updateDocumentFormForDeleteDocumentFormType(deleteFormTypeCode);
		 }
		 
		 int deleteResult = eaMapper.deleteDocumentFormType(deleteFormTypeCode);
		 return deleteResult;
	 };
	 
	 /*
	  * @method updateDocumentFormType()
	  * @brief  문서 양식 분류 UPDATE method
	  * @author 김건훈
	  */
	 public int updateDocumentFormType(ElectronicApprovalDocument eaDto){
		 int result = eaMapper.updateDocumentFormType(eaDto);
		 return result;
	 };
	 
	 /*
	  * @method ajaxSetDocumentCodeFormat()
	  * @brief 관리자용 전자결재 기본설정 화면 문서번호 처리 service method
	  * @author 김건훈
	  */	
	 public String ajaxSetDocumentCodeFormat(Map<String,Object> checkRadioMap) {
		 
		//System.out.println(checkRadioMap.toString());
		 
		String companyCode =(String)checkRadioMap.get("companyCode");
		String companyCodeRadioVal =(String)checkRadioMap.get("companyCodeRadioVal");
		String unitRadioVal =(String)checkRadioMap.get("unitRadioVal");
		String registerDateRadioVal =(String)checkRadioMap.get("registerDateRadioVal");
		String serialNumRadioVal =(String)checkRadioMap.get("serialNumRadioVal");
		
		/*
		 * System.out.println(companyCode); 
		 * System.out.println(companyCodeRadioVal);
		 * System.out.println(unitRadioVal); 
		 * System.out.println(registerDateRadioVal);
		 * System.out.println(serialNumRadioVal);
		 */
		String result = "";
		
		//회사코드 사용 여부에 따른 문서번호에 포함 여부
		if(companyCodeRadioVal.equals("A")) {
			result+=companyCode+"-";
		}
		
		//약칭 및 소속 사용 여부에 따른 문서번호에 포함 여부
		if(unitRadioVal.equals("A")) {
			result+="개발-";
		}else if(unitRadioVal.equals("B")) {
			result+="프로젝트사업-";
		}else if(unitRadioVal.equals("C")) {
			result+="개발-프로젝트사업-";
		}
		
		//문서 등록 시점에 따른 문서번호 형식
		  SimpleDateFormat sdf = null;
	      Calendar calender = Calendar.getInstance();
	      String strToday=null;
	 
		if(registerDateRadioVal.equals("A")) {
			sdf = new SimpleDateFormat("yyyyMMdd");
			strToday = sdf.format(calender.getTime());
			result+=(strToday+"-");
		}else if(registerDateRadioVal.equals("B")) {
			sdf = new SimpleDateFormat("yyMMdd");
			strToday = sdf.format(calender.getTime());
			result+=(strToday+"-");
		}else if(registerDateRadioVal.equals("C")) {
			sdf = new SimpleDateFormat("yyyyMM");
			strToday = sdf.format(calender.getTime());
			result+=(strToday+"-");
		}else if(registerDateRadioVal.equals("D")) {
			sdf = new SimpleDateFormat("yyMM");
			strToday = sdf.format(calender.getTime());
			result+=(strToday+"-");
		}else if(registerDateRadioVal.equals("E")) {
			sdf = new SimpleDateFormat("yyyy");
			strToday = sdf.format(calender.getTime());
			result+=(strToday+"-");
		}else if(registerDateRadioVal.equals("F")) {
			sdf = new SimpleDateFormat("yy");
			strToday = sdf.format(calender.getTime());
			result+=(strToday+"-");
		}
		
		//일련 번호 형식에 따른 문서번호 양식
		if(serialNumRadioVal.equals("A")) {
			result+="01";
		}else if(serialNumRadioVal.equals("B")) {
			result+="001";
		}else if(serialNumRadioVal.equals("C")) {
			result+="0001";
		}
		
		//System.out.println("문서 번호 가공 후 결과값------>"+result);
		 return result;
	 };
	 
	 /*
	  * @method selectDocumentFormTypeForInsertDocumentDraft()
	  * @brief 문서 기안하기 페이지에서 문서 양식 종류 선택시 해당하는 분류들 가져오는 method
	  * @author 김건훈
	  */
	 public List<ElectronicApprovalDocument> selectDocumentFormTypeForInsertDocumentDraft(String dFormTypeCode){
		 List<ElectronicApprovalDocument> documentFormList = eaMapper.selectDocumentFormTypeForInsertDocumentDraft(dFormTypeCode);
		 return documentFormList;
	 }
}
