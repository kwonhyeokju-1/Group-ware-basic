package com.team02.groupware.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team02.groupware.dto.BoardDto;
import com.team02.groupware.dto.CommentDto;
import com.team02.groupware.dto.PagingDto;
import com.team02.groupware.dto.SearchDto;
import com.team02.groupware.service.BoardService;



@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	
	
	// 게시판 리스트 화면
	@GetMapping("/boardList")
	public String boardList(Model model, BoardDto bDto, PagingDto pDto, SearchDto sDto ) {
		
		
		Map<String, Object> boardMap = new HashMap<String, Object>();
		
		System.out.println(" 컨트롤러 진입시기 boardDto.toString() : "+bDto.toString() );
		System.out.println(" 컨트롤러 진입시기 PagingDto.toString() : "+pDto.toString() );
		System.out.println(" 컨트롤러 진입시기 searchDto.toString() : "+sDto.toString() );
		boardMap = boardService.getBoardList(bDto, pDto, sDto);
		System.out.println("");
		System.out.println(" 컨트롤러에서 겟보드리스트 후 : "+boardMap.toString());
		model.addAttribute("boardList", boardMap.get("boardList"));
		model.addAttribute("pagingDto", boardMap.get("pagingDto"));
		model.addAttribute("searchDto", boardMap.get("searchDto"));
		model.addAttribute("departList", boardMap.get("departList"));
		model.addAttribute("boardNoticeList", boardMap.get("boardNoticeList"));
		System.out.println(" 컨트롤러에서 겟보드리스트 후 보드리스트 : "+boardMap.get("boardList"));
		System.out.println(" 컨트롤러에서 겟보드리스트 후 페이징dto: "+boardMap.get("pagingDto"));
		System.out.println(" 컨트롤러에서 겟보드리스트 후 서치dto: "+boardMap.get("searchDto"));
		System.out.println(" 컨트롤러에서 겟보드리스트 후 디파트리스트: "+boardMap.get("departList"));
		System.out.println(" 컨트롤러에서 겟보드리스트 후 보드노티스리스트: "+boardMap.get("boardNoticeList"));
		return "board/boardList";
	}
	
	// 게시판 글쓰기 Form
	@GetMapping("/boardWriteForm")
	public String boardWriteForm(Model model ) {
		
		Map<String, Object> boardMap = new HashMap<String, Object>();
		boardMap = boardService.getDepartList();
		model.addAttribute("departList", boardMap.get("departList"));
		
		return "board/boardWriteForm";
	}
	// 게시글 등록
	@PostMapping("/boardInsert")
	public String boardWrite(Model model, BoardDto bDto, @RequestParam("file") MultipartFile[] file, RedirectAttributes redirectA ) throws IOException {
		
		System.out.println("보드인서트 비디티오 확인 : "+bDto.toString());
		Map<String, Object> boardMap = new HashMap<String, Object>();
		
		boardMap = boardService.boardInsert(bDto);
		
		System.out.println("*****게시글등록 테스트 파일 렝쓰 : " + file[0].isEmpty());
		
		int fileLength = file.length;
		int fileEmptyCount = 0;
		
		for(int i=0; i < file.length; i++) {
			if(file[i].isEmpty() == true) fileEmptyCount++;
		}
		if(fileLength != fileEmptyCount) {
			boardService.boardFileInsert(boardMap, file);
		}
		

		redirectA.addAttribute("boardNum", boardMap.get("boardNum"));
		
		return "redirect:/boardDetailView";
	}
	
	// 게시글 상세보기
	@GetMapping("/boardDetailView")
	public String BoardDetailView(Model model, BoardDto bDto, PagingDto pDto, SearchDto sDto, @RequestParam(value="boardNum", required = false) Object boardNum) {
		
		if(boardNum != null) System.out.println("test:" + boardNum.toString());
		System.out.println("보드디테일뷰 bDto 투스트링 : "+bDto.toString());
		
		Map<String, Object> boardMap = new HashMap<String, Object>();
		boardMap = boardService.selectBoardDetailView(bDto);
		System.out.println("보드디테일뷰 컨트롤러 보드리스트 : " + boardMap.get("boardList"));
		
		model.addAttribute("boardList", boardMap.get("boardList"));
		model.addAttribute("commentList", boardMap.get("commentList"));
		model.addAttribute("boardAttachFileList", boardMap.get("boardAttachFileList"));
		model.addAttribute("pagingDto", pDto);
		model.addAttribute("searchDto", sDto);
		
		return "board/boardDetailView";
	}
	
	// 파일 다운로드
	@GetMapping("/board/file")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@RequestParam("fileName") String fileName,
												@RequestParam("fileOriginalName") String fileOriginalName) throws MalformedURLException, UnsupportedEncodingException {
		System.out.println("****컨트롤러 파일 다운로드****");
		System.out.println("오리지날 파일네임 : " + fileOriginalName);
		
		// 서비스로 fileName 전달해서 파일정보 받아오기
		Resource file = boardService.boardFileDownload(fileName);
		String fileIncodingName = new String(fileOriginalName.getBytes("UTF-8"), "ISO-8859-1");
		
		// 브라우저에 파일 전달
		ResponseEntity<Resource> re = ResponseEntity.ok().header(
				HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileIncodingName + "\""
		).body(file);
		return re;
	}
	
	// 게시글 수정 폼
	@GetMapping("/boardUpdateForm")
	public String boardUpdateForm(Model model, BoardDto bDto, PagingDto pDto, SearchDto sDto) {
		
		Map<String, Object> boardMap = new HashMap<String, Object>();
		Map<String, Object> boardMap2 = new HashMap<String, Object>();
		
		boardMap = boardService.getDepartList();
		boardMap2 = boardService.selectBoardUpdateForm(bDto);
		
		model.addAttribute("departList", boardMap.get("departList"));
		model.addAttribute("boardList", boardMap2.get("boardList"));
		model.addAttribute("boardFileList", boardMap2.get("boardFileList"));
		model.addAttribute("pagingDto", pDto);
		model.addAttribute("searchDto", sDto);
		
		System.out.println("***컨트롤러 게시글 수정폼 보드파일리스트 체크 *** : " + boardMap2.get("boardFileList"));
		
		return "board/boardUpdateForm";
	}
	
	// 게시글 수정
	@PostMapping("/boardUpdate")
	public String boardUpdate(Model model, BoardDto bDto, PagingDto pDto, SearchDto sDto, 
			@RequestParam("file") MultipartFile[] file, 
			@RequestParam(value="fileDeleteNum", required=false) String[] fileDeleteNum,
			@RequestParam(value="boardFileNum", required=false) String[] boardFileNum,
			RedirectAttributes redirectA) throws IOException {
		
		System.out.println("보드업데이트 :" + bDto.toString());
		System.out.println("보드업데이트 :" + pDto.toString());
		System.out.println("보드업데이트 :" + sDto.toString());
		
		//System.out.println("파일딜리트넘 이즈엠티" + fileDeleteNum.isEmpty());
		
		boardService.updateBoard(bDto);
		
		Map<String, Object> boardMap = new HashMap<String, Object>();
		boardMap.put("boardNum", bDto.getBoardNum());
		
		
		System.out.println("보드업데이트 파일 렝쓰 : " + file.length);
		
		// 파일 업로드시
		int fileLength = file.length;
		int fileEmptyCount = 0;
		
		for(int i=0; i < file.length; i++) {
			System.out.println("보드업데이트 위치 테스트1");
			if(file[i].isEmpty() == true) fileEmptyCount++;
		}
		if(fileLength != fileEmptyCount) {
			System.out.println("보드업데이트 위치 테스트2");
			boardService.boardFileInsert(boardMap, file);
		}
		
		System.out.println("보드업데이트 위치 테스트3");
		
		if(fileDeleteNum == null) System.out.println("널널");
		// 파일 제거시
		if(fileDeleteNum != null) {
			System.out.println("보드업데이트 위치 테스트4");
			
			int integerFileDeleteNum = 0;
			
			for(int i=0; i < fileDeleteNum.length; i++) {
				
				integerFileDeleteNum = Integer.parseInt(fileDeleteNum[i]);
				
				boardService.boardFileDelete(integerFileDeleteNum);	// 파일 삭제
			}
			
			boardService.boardFileCheck(bDto);	// 파일 삭제 후 게시글 파일 유무  업데이트
			
			
		}
		
		System.out.println("보드업데이트 위치 테스트5");
		
		
		redirectA.addAttribute("boardNum", bDto.getBoardNum());
		redirectA.addAttribute("selectPage", pDto.getSelectPage());
		redirectA.addAttribute("viewNum", pDto.getViewNum());
		redirectA.addAttribute("boardCategory", sDto.getSearchBoardCategory());
		redirectA.addAttribute("isSearchCheck", sDto.getIsSearchCheck());
		redirectA.addAttribute("searchBy", sDto.getSearchBy());
		redirectA.addAttribute("searchDate", sDto.getSearchDate());
		redirectA.addAttribute("searchInput", sDto.getSearchInput());
	
		return "redirect:/boardDetailView";
	}
	
	// 게시글 삭제
	@GetMapping("/boardDelete")
	public String boardDelete(Model model, BoardDto bDto, PagingDto pDto, SearchDto sDto, RedirectAttributes redirectA) throws IOException {
		
		System.out.println("boardDelete bDto :  " + bDto);
		System.out.println("boardDelete pDto :  " + pDto);
		System.out.println("boardDelete sDto :  " + sDto);
		
		boardService.deleteBoard(bDto);
		
		redirectA.addAttribute("selectPage", pDto.getSelectPage());
		redirectA.addAttribute("viewNum", pDto.getViewNum());
		redirectA.addAttribute("boardCategory", sDto.getBoardCategory());
		redirectA.addAttribute("isSearchCheck", sDto.getIsSearchCheck());
		redirectA.addAttribute("searchBy", sDto.getSearchBy());
		redirectA.addAttribute("searchDate", sDto.getSearchDate());
		redirectA.addAttribute("searchInput", sDto.getSearchInput());
		
		return "redirect:/boardList";
	}
	
	// 댓글 입력
	@PostMapping("/commentInsert")
	public @ResponseBody Map<String, Object> ajaxResponse(Model model, BoardDto bDto, CommentDto cDto) {
		
		Map<String, Object> boardMap = new HashMap<String, Object>();
		System.out.println(bDto.getBoardNum());
		System.out.println(cDto.getCommentContent());
		
		boardMap = boardService.commentInsert(bDto, cDto);
		
		return boardMap;
	}
	
	// 댓글 수정
	@PostMapping("/commentUpdate")
	public @ResponseBody Map<String, Object> commentUpdate(Model model, CommentDto cDto) {
		Map<String, Object> boardMap = new HashMap<String, Object>();
		System.out.println("커멘트업데이트 cDto : " + cDto);
		
		boardService.commentUpdate(cDto);
		boardMap.put("commentDto", cDto);
		return boardMap;
	}
	
	// 댓글 삭제
	@PostMapping("/commentDelete")
	public @ResponseBody Map<String, Object> commentDelete(Model model, BoardDto bDto, CommentDto cDto) {
		
		Map<String, Object> boardMap = new HashMap<String, Object>();
		System.out.println(bDto.getBoardNum());
		System.out.println(cDto.getCommentNum());
		boardMap.put("boardDto", bDto);
		boardMap.put("commentDto", cDto);
		boardService.commentDelete(bDto, cDto);
		
		return boardMap;
	}
	

}
