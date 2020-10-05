package com.team02.groupware.dto;

public class BoardDto {
	
	private int boardNum;
	private String boardCategory;
	private String boardTitle;
	private String boardWriter;
	private String boardContentText; 
	private String boardWriteDate;
	private int boardViewCount;
	private int boardCommentCount;
	private String boardFileCheck = "N";
	
	private String boardSearchWord;
	private int boardTimeCheck;
	
	
	
	@Override
	public String toString() {
		return "BoardDto [boardNum=" + boardNum + ", boardCategory=" + boardCategory + ", boardTitle=" + boardTitle
				+ ", boardWriter=" + boardWriter + ", boardContentText=" + boardContentText + ", boardWriteDate="
				+ boardWriteDate + ", boardViewCount=" + boardViewCount + ", boardCommentCount=" + boardCommentCount
				+ ", boardFileCheck=" + boardFileCheck + ", boardSearchWord=" + boardSearchWord + ", boardTimeCheck="
				+ boardTimeCheck + "]";
	}
	public String getBoardFileCheck() {
		return boardFileCheck;
	}
	public void setBoardFileCheck(String boardFileCheck) {
		this.boardFileCheck = boardFileCheck;
	}
	public String getBoardSearchWord() {
		return boardSearchWord;
	}
	public void setBoardSearchWord(String boardSearchWord) {
		this.boardSearchWord = boardSearchWord;
	}
	public int getBoardTimeCheck() {
		return boardTimeCheck;
	}
	public void setBoardTimeCheck(int boardTimeCheck) {
		this.boardTimeCheck = boardTimeCheck;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getBoardCategory() {
		return boardCategory;
	}
	public void setBoardCategory(String boardCategory) {
		this.boardCategory = boardCategory;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardContentText() {
		return boardContentText;
	}
	public void setBoardContentText(String boardContentText) {
		this.boardContentText = boardContentText;
	}
	public String getBoardWriteDate() {
		return boardWriteDate;
	}
	public void setBoardWriteDate(String boardWriteDate) {
		this.boardWriteDate = boardWriteDate;
	}
	public int getBoardViewCount() {
		return boardViewCount;
	}
	public void setBoardViewCount(int boardViewCount) {
		this.boardViewCount = boardViewCount;
	}
	public int getBoardCommentCount() {
		return boardCommentCount;
	}
	public void setBoardCommentCount(int boardCommentCount) {
		this.boardCommentCount = boardCommentCount;
	}
	
	
}
