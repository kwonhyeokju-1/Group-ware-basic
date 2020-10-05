package com.team02.groupware.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.team02.groupware.dto.BoardDto;
import com.team02.groupware.dto.CommentDto;
import com.team02.groupware.dto.PagingDto;
import com.team02.groupware.dto.SearchDto;
import com.team02.groupware.mapper.BoardMapper;

@Service
@Transactional
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Value("${service.file.uploadurl}")
	private String fileUploadPath;
	
	/**
	 * 업로드 폴더 없을 경우 생성
	 */
	@PostConstruct
	public void init() {
		try {
			Files.createDirectories(Paths.get(fileUploadPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 게시글리스트 Select
	public Map<String, Object> getBoardList(BoardDto bDto, PagingDto pDto, SearchDto sDto){
		// default값 설정
		int viewNum;
		int selectPage;
		
		viewNum = pDto.getViewNum();
		selectPage = pDto.getSelectPage();
		
		System.out.println("보드서비스 겟보드 카운트 전");
		
		/* 페이징 로직 시작부분 */
		Map<String, Object> boardMap = new HashMap<String, Object>();
		boardMap.put("boardDto", bDto);
		boardMap.put("searchDto", sDto);
		int boardCount = boardMapper.selectBoardCount(boardMap);
		System.out.println("보드서비스 겟보드 카운트 후");
		System.out.println("보드카운트 : "+ boardCount);
		
		boolean isPrevBtn;			// 이전 버튼 생성 유무 위한 boolean 변수
		boolean isNextBtn;			// 다음 버튼 생성 유무 위한 boolean 변수
		
		int pageFirstNum;			// 현재 페이지의 첫번째 페이징넘버
		int pageLastNum;			// 현재 페이지의 마지막 페이징 넘버
		
		int maxPage = 0;
		
		if(boardCount % viewNum == 0) maxPage = boardCount / viewNum;		// 최대 페이지수 구하기 위한 조건문
		if(boardCount % viewNum != 0) maxPage = boardCount / viewNum + 1;	// 전체 게시글수 / 게시글보기갯수 = 최대 페이지 갯수, else 나머지가 있을경우 +1
		
		
		if(selectPage % 5 == 0) {								// 맨 왼쪽 페이징넘버 구하기 위한 로직
			pageFirstNum = ((selectPage / 5) -1) * 5 + 1;		
		}else {
			pageFirstNum = (selectPage / 5) * 5 + 1;
		}
		
		pageLastNum = pageFirstNum + 4;							// 맨 오른쪽 페이징넘버 구하기 위한 로직
		if(pageLastNum > maxPage) pageLastNum = maxPage;		// 최대 페이지수보다 커지기 않게 제한 걸기
		
		
		if(maxPage <= 5) {						// 현재 선택된 페이지에 따른 이전버튼, 다음버튼 생성 유무 구하기 위한 로직
												// 둘다 false일 경우, maxPage가 5 이하일 경우
			isPrevBtn = false;
			isNextBtn = false;
		}else if(selectPage <= 5) {				// 이전버튼 false, 다음버튼 true인 경우, 선택페이지가 5 이하일 경우
			
			isPrevBtn = false;
			isNextBtn = true;
		}else if(maxPage-pageFirstNum < 5){		// 이전버튼 true, 다음버튼 false일 경우, 최대페이지수가 현재 페이징 첫번째 수와의 차이가 5보다 낮을 경우
			
			isPrevBtn = true;
			isNextBtn = false;
		}else {									// 그외에는 모두 true
			
			isPrevBtn = true;
			isNextBtn = true;
		}
		System.out.println("보드서비스 겟보드리스트 전");

		pDto.setLimitNum((selectPage-1) * viewNum);
		pDto.setSelectPage(selectPage);
		pDto.setViewNum(viewNum);
		
		boardMap.put("pagingDto", pDto);
		System.out.println(boardMap.get("pagingDto").toString());
		System.out.println(boardMap.get("boardDto").toString());
		System.out.println(boardMap.get("searchDto").toString());
		List<BoardDto> boardList = new ArrayList<BoardDto>();
		boardList = boardMapper.selectBoardList(boardMap);
		System.out.println("보드서비스 겟보드리스트 후");
		System.out.println("보드리스트 : " + boardList.toString());
		/* 페이징 값 셋팅 */
		
		pDto.setPageFirstNum(pageFirstNum);
		pDto.setPageLastNum(pageLastNum);
		pDto.setPrevBtn(isPrevBtn);
		pDto.setNextBtn(isNextBtn);
		
		List<String> departList = new ArrayList<String>();
		departList = boardMapper.selectDepartList();
		System.out.println("디파트리스트 투스트링 : "+departList.toString());
		
		List<BoardDto> boardNoticeList = new ArrayList<BoardDto>();
		boardNoticeList = boardMapper.selectBoardNoticeList();
		System.out.println("겟보드 노티스 리스트 : "+boardNoticeList.toString());
		
		
		System.out.println(sDto.getIsSearchCheck()+ "******************검색중*******************");
		if("true".equals(sDto.getIsSearchCheck())) {
			System.out.println("겟서치체크 트루");
			String boardTitle = null;
			String searchWord = sDto.getSearchInput();
			String subSearchWord = null;
			for(BoardDto i : boardList) {
				System.out.println(i.getBoardTitle());
				boardTitle = i.getBoardTitle();
				if(boardTitle.indexOf(searchWord) != -1) {
					
					subSearchWord = boardTitle.substring(boardTitle.indexOf(searchWord), boardTitle.indexOf(searchWord)+searchWord.length());
					
					System.out.println("인덱스오브 : "+boardTitle.indexOf(searchWord));
					System.out.println("문자열 길이 서치워드  : " + searchWord.length());
					System.out.println("섭스트링 : "+ boardTitle.substring(boardTitle.indexOf(searchWord), boardTitle.indexOf(searchWord)+searchWord.length()));
					System.out.println("리플레이스 : " + boardTitle.replace(subSearchWord,"<p id=\"searchWord\">"+subSearchWord+"</p>"));
					i.setBoardSearchWord(boardTitle.replace(subSearchWord,"<em class=\"searchWord\">"+subSearchWord+"</em>"));
				}else {
					i.setBoardSearchWord(boardTitle);
				}
			}
		}
		
		boardMap.put("boardList", boardList);
		boardMap.put("pagingDto", pDto);
		boardMap.put("searchDto", sDto);
		boardMap.put("departList", departList);
		boardMap.put("boardNoticeList", boardNoticeList);
		
		return boardMap;
	}
	
	// 부서목록 select
	public Map<String, Object> getDepartList(){

		List<String> departList = new ArrayList<String>();
		departList = boardMapper.selectDepartList();
		
		Map<String, Object> boardMap = new HashMap<String, Object>();
		
		boardMap.put("departList", departList);

		return boardMap;
	}
	// 게시글 Insert
	public Map<String, Object> boardInsert(BoardDto bDto){

		boardMapper.insertBoard(bDto);
		
		int maxBoardNum = boardMapper.selectMaxBoardNum();
		Map<String, Object> boardMap = new HashMap<String, Object>();
		boardMap.put("boardNum", maxBoardNum);
		
		return boardMap;
	}
	// 게시글 파일 업로드
	public void boardFileInsert(Map<String, Object> boardMap, MultipartFile[] file) throws IOException {
		
		String originalFileName = null;
		String storedFileName = null;
		int fileSize = 0;
		
		List<Map<String,Object>> boardMapList = new ArrayList<Map<String,Object>>();
		int boardNum = (int) boardMap.get("boardNum");
		int listCountNum = -1;
		
		for(int i=0; i < file.length ; i++) {
			
			if(file[i].isEmpty() == true) {
				
				continue;
			}
			
			originalFileName = StringUtils.cleanPath(file[i].getOriginalFilename());	// 원래 파일명
			storedFileName = UUID.randomUUID().toString().replaceAll("-", "");			// 저장용 랜덤스트링 파일명 생성
			storedFileName += originalFileName.substring(originalFileName.lastIndexOf(".")); // 확장자 추가
			fileSize = (int) file[i].getSize();	// 파일 사이즈
			
			InputStream inputStream = file[i].getInputStream();		// 파일 읽을 준비
			Files.copy(inputStream, Paths.get(fileUploadPath).resolve(storedFileName),	// copy(inputStream 객체, 파일 경로, 카피옵션) : 파일 복사해서 쓰기
					StandardCopyOption.REPLACE_EXISTING);			// REPLACE_EXISTING?
			
			boardMap.put("boardNum", boardNum);
			boardMap.put("originalFileName", originalFileName);
			boardMap.put("storedFileName", storedFileName);
			boardMap.put("fileSize", fileSize);
			
			boardMapList.add(boardMap);
			
			listCountNum++;
			
			boardMapper.boardFileInsert(boardMapList.get(listCountNum));
			boardMapper.boardFileCheckUpdate(boardMapList.get(listCountNum));
			
		}
		
		
		
	}
	
	
	
	// 게시글 디테일뷰 Select
	public Map<String, Object> selectBoardDetailView(BoardDto bDto){
		
		Map<String, Object> boardMap = new HashMap<String, Object>();
		List<BoardDto> boardList = new ArrayList<BoardDto>();
		List<CommentDto> commentList = new ArrayList<CommentDto>();
		List<Map<String,Object>> boardAttachFileList = new ArrayList<Map<String,Object>>();
		
		boardMapper.updateBoardViewCount(bDto);
		boardList = boardMapper.selectBoardDetailView(bDto);
		commentList = boardMapper.selectCommentList(bDto);
		boardAttachFileList = boardMapper.selectBoardAttachFile(bDto);
		
		System.out.println("****** 서비스 셀렉트보드디테일뷰 파일 테스트 ************");
		System.out.println(boardAttachFileList.toString());
		
		boardMap.put("boardList", boardList);
		boardMap.put("commentList", commentList);
		boardMap.put("boardAttachFileList", boardAttachFileList);
		System.out.println("보드디테일뷰 보드리스트 : " + boardList.toString());
		System.out.println("보드디테일뷰 코멘트리스트 : " + commentList.toString());
		
		return boardMap;
	}
	
	// 게시글 수정Form
	public Map<String, Object> selectBoardUpdateForm(BoardDto bDto){
		
		Map<String, Object> boardMap = new HashMap<String, Object>();
		List<BoardDto> boardList = new ArrayList<BoardDto>();
		
		boardList = boardMapper.selectBoardDetailView(bDto);
		System.out.println("게시글 수정폼 파일 체크 : " + boardList.get(0).getBoardFileCheck());
		String boardFileCheck = boardList.get(0).getBoardFileCheck();
		
		// 파일이 있을 시
		if("Y".equals(boardFileCheck)) {
			
			List<Map<String,Object>> boardFileList = new ArrayList<Map<String,Object>>();
			boardFileList = boardMapper.selectBoardAttachFile(bDto);
			System.out.println("게시글 수정폼 파일 사이즈 체크 : " + boardFileList);
			
			Number fileSize = 0; 
			String fileUnit = null;
			double doubleFileSize = 0.0;
			int intFileSize = 0;
			
			// 파일 크기 단위 부여
			for(int i=0; i<boardFileList.size(); i++) {
				
				fileSize =  (Number) boardFileList.get(i).get("boardFileSize");
				System.out.println("파일사이즈 추출 : " + fileSize);
				doubleFileSize = fileSize.doubleValue();
			  
				if(doubleFileSize < 1024){ 
					
					intFileSize = (int) doubleFileSize;
					fileUnit = "바이트";
					
					boardFileList.get(i).put("fileSize", intFileSize);
					boardFileList.get(i).put("fileUnit", fileUnit);
					
					continue;
					
				}else if(doubleFileSize < 1048576){
					
					doubleFileSize =  Math.floor((doubleFileSize / 1024)*100)/100;
					fileUnit = "KB";
					
				}else if(doubleFileSize <1.0737e+9){
					
					doubleFileSize =  Math.floor((doubleFileSize / 1048576)*100)/100;
					fileUnit = "MB";
				}
				
				boardFileList.get(i).put("fileUnit", fileUnit);
				boardFileList.get(i).put("fileSize", doubleFileSize);
			
			}

			boardMap.put("boardFileList", boardFileList);
		}
		
		
		boardMap.put("boardList", boardList);
		
		
		return boardMap;

	}
	// 게시글 Update
	public void updateBoard(BoardDto bDto) {
		
		boardMapper.updateBoard(bDto);
		
	}
	// 게시글 Delete
	public void deleteBoard(BoardDto bDto) throws IOException {
		
		List<Map<String, Object>> boardMapList = new ArrayList<Map<String,Object>>();
		
		boardMapList = boardMapper.selectBoardAttachFile(bDto);
		if(boardMapList.size() > 0) {
			
			for(int i = 0; i < boardMapList.size(); i++) {
				
				boardFileDelete((int) boardMapList.get(i).get("boardFileNum"));
			}
		}
		
		boardMapper.deleteBoard(bDto);

	}
	// 댓글 Insert
	public Map<String, Object> commentInsert(BoardDto bDto, CommentDto cDto){
		
		Map<String, Object> boardMap = new HashMap<String, Object>();
		
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");	
		Date time = new Date();	
		String currentTime = format1.format(time);
		
		boardMap.put("commentDto", cDto);
		boardMap.put("currentTime", currentTime);
		boardMap.put("boardDto", bDto);
		boardMap.put("isCommentCount", "true");
		boardMapper.insertComment(boardMap);
		boardMapper.updateCommentCount(boardMap);
		
		int commentNum = boardMapper.selectMaxCommentNum();
		System.out.println("커멘트 인서트 커멘트넘 : " + commentNum);
		boardMap.put("commentNum", commentNum);
		
		return boardMap;
	}
	// 댓글 Update
	public void commentUpdate(CommentDto cDto){
		
		boardMapper.updateComment(cDto);

	}

	// 댓글 Delete
	public void commentDelete(BoardDto bDto, CommentDto cDto) {
		
		boardMapper.deleteComment(cDto);
		boardMapper.deleteCommentCount(bDto);
		
	}

	
	// 파일 다운로드
	public Resource boardFileDownload(String filename) throws MalformedURLException {
		
		// 파일경로 접근
		Path file = Paths.get(fileUploadPath).resolve(filename);	
		
		// 파일 경로 접근하여 파일 정보 전달
		Resource resource = new UrlResource(file.toUri());
		
		//파일이 존재할 경우 리턴
		if (resource.exists() || resource.isReadable()) {
			
			return resource;
		}
		
		return null;
	}
	
	// 게시글 파일 수정
	public void boardFileUpdate(BoardDto bDto, MultipartFile file) throws IOException {
		
		String originalFileName = StringUtils.cleanPath(file.getOriginalFilename());	// 오리지날 파일명
		String storedFileName = UUID.randomUUID().toString().replaceAll("-", "");		// DB에 저장될 파일명 랜덤생성
		storedFileName += originalFileName.substring(originalFileName.lastIndexOf("."));	// 확장자 추가
		int fileSize = (int) file.getSize();	// 파일 사이즈
		
		InputStream inputStream = file.getInputStream();		// 파일 읽을 준비
		Files.copy(inputStream, Paths.get(fileUploadPath).resolve(storedFileName),	// copy(inputStream 객체, 파일 경로, 카피옵션) : 파일 복사해서 쓰기
				StandardCopyOption.REPLACE_EXISTING);			// REPLACE_EXISTING?
		
				
		Map<String, Object> boardMap = new HashMap<String, Object>();
		
		boardMap.put("originalFileName", originalFileName);
		boardMap.put("storedFileName", storedFileName);
		boardMap.put("fileSize", fileSize);
		boardMap.put("boardNum", bDto.getBoardNum());
		
		boardMapper.boardFileInsert(boardMap);
		boardMapper.boardFileCheckUpdate(boardMap);
		
	}
	
	// 게시글 파일 삭제
	public void boardFileDelete(int integerFileDeleteNum) throws IOException {
		
		List<Map<String,Object>> deleteBoardFileList = new ArrayList<Map<String,Object>>();
		
		deleteBoardFileList = boardMapper.selectBoardFileForDelete(integerFileDeleteNum);
		
		System.out.println("보드파일딜리트 딜리트보드파일리스트 : " + deleteBoardFileList.toString());
		
		String boardFileStoredName = null;
		
		for(int i=0; i<deleteBoardFileList.size(); i++) {
			boardFileStoredName = (String) deleteBoardFileList.get(i).get("boardFileStoredName");
			Files.delete(Paths.get(fileUploadPath).resolve(boardFileStoredName));
		}
		
		boardMapper.boardFileDelete(integerFileDeleteNum);
		
	}

	// 게시글 파일 유무 체크
	public void boardFileCheck(BoardDto bDto) {
		boardMapper.boardFileCheck(bDto);
		
	}
	
	
	
	
	
}
