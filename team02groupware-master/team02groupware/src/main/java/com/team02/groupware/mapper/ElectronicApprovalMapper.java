package com.team02.groupware.mapper;

/*
* @file ElectronicApprovalMapper.java
* @brief 전자결재 mapper interface
* @author 김건훈
*/
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.team02.groupware.dto.ElectronicApprovalDocument;

@Mapper
public interface ElectronicApprovalMapper {
		
	 /*
	  * @method selectEaDocumentForm()
	  * @brief 양식함관리 페이지 내 문서양식 테이블 조회 method
	  * @author 김건훈
	  */
	 public List<ElectronicApprovalDocument> selectEaDocumentForm(Map<String, Object> map);
	 
	 /*
	  * @method selectEaDocumentFormCount()
	  * @brief 양식함관리 페이지 내 문서양식 전체 개수 조회 method
	  * @author 김건훈
	  */
	 public int selectEaDocumentFormCount(Map<String, Object> map);
		
	 /*
	  * @method selectEaDocumentFormType()
	  * @brief 양식함관리 페이지 내 분류설정 테이블 조회 method
	  * @author 김건훈
	  */
	 public List<ElectronicApprovalDocument> selectEaDocumentFormType();
	 
	 /*
	  * @method selectEaDocumentSetting()
	  * @brief 전자결재 기본설정 테이블 조회 method
	  * @author 김건훈
	  */
	 public List<ElectronicApprovalDocument> selectEaDocumentSetting();
	 
	 /*
	  * @method updateEaRule()
	  * @brief 전자결재 사내 전자결재 규정 UPDATE method
	  * @author 김건훈
	  */
	 public int updateEaRule(String eaRuleVal);
	 
	 /*
	  * @method selectEaDocumentFormTypeMaxCode()
	  * @brief 문서 양식 분류 코드 최대값 구하는 method 
	  * @author 김건훈
	  */
	 public int selectEaDocumentFormTypeMaxCode();
	 
	 /*
	  * @method insertDocumentFormType()
	  * @brief 문서 양식 분류 코드 최대값으로 insert method
	  * @author 김건훈
	  */
	 public int insertDocumentFormType(ElectronicApprovalDocument eaDto);
	 
	 /*
	  * @method deleteDocumentFormType()
	  * @brief  문서 양식 분류 delete method
	  * @author 김건훈
	  */
	 public int deleteDocumentFormType(String deleteFormTypeCode);
	 
	 /*
	  * @method selectDocumentFormForDeleteDocumentFormType()
	  * @brief 문서 양식 분류 삭제시 해당 분류를 사용하는 문서 양식 수 조회 method 
	  * @author 김건훈
	  */
	 public int selectDocumentFormForDeleteDocumentFormType(String deleteFormTypeCode);
	 
	 /*
	  * @method updateDocumentFormForDeleteDocumentFormType()
	  * @brief  문서 양식 분류 삭제시 해당 양식 분류를 사용하는 문서 양식 존재 시 문서 양식 분류를 공통 분류로 update method
	  * @author 김건훈
	  */
	 public int updateDocumentFormForDeleteDocumentFormType(String deleteFormTypeCode);
	 
	 /*
	  * @method updateDocumentFormType()
	  * @brief  문서 양식 분류 UPDATE method
	  * @author 김건훈
	  */
	 public int updateDocumentFormType(ElectronicApprovalDocument eaDto);
	 
	 /*
	  * @method insertDocumentForm()
	  * @brief 관리자용 문서 양식 생성 method
	  * @author 김건훈
	  */
	 public int insertDocumentForm(ElectronicApprovalDocument eaDto);
	 
	 /*
	  * @method selectEaDocumentFormMaxCode()
	  * @brief 문서 양식 코드 최대값 구하는 method 
	  * @author 김건훈
	  */
	 public int selectEaDocumentFormMaxCode();
	 
	 /*
	  * @method deleteDocumentForm()
	  * @brief 관리자용 문서 양식 삭제 method
	  * @author 김건훈
	  */
	 public int deleteDocumentForm(List<String> eaDocumentFormListCodeArr);
	 
	 /*
	  * @method selectDocumentFormForDetail()
	  * @brief 관리자용 문서양식 미리보기 위한 1개 정보조회 method
	  * @author 김건훈
	  */
	 public ElectronicApprovalDocument selectDocumentFormForDetail(String dFormCode);


	 /*
	  * @method selectApprovalFormatInDocumentFormForDetail()
	  * @brief 양식함관리 페이지 내 문서양식 미리보기 위한 1개 정보중 포맷양식 조회 method
	  * @author 김건훈
	  */
	 public String selectApprovalFormatInDocumentFormForDetail(String dApprovalFormatCode);
	 
	 /*
	  * @method updateDocumentForm()
	  * @brief 관리자용 문서 양식 수정 method
	  * @author 김건훈
	  */
	 public int updateDocumentForm(ElectronicApprovalDocument eaDto);
	 
	 /*
	  * @method selectDocumentFormTypeForInsertDocumentDraft()
	  * @brief 문서 기안하기 페이지에서 문서 양식 종류 선택시 해당하는 분류들 가져오는 method
	  * @author 김건훈
	  */
	 public List<ElectronicApprovalDocument> selectDocumentFormTypeForInsertDocumentDraft(String dFormTypeCode);
	 
	 }

	
