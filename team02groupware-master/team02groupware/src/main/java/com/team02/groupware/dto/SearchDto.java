package com.team02.groupware.dto;

public class SearchDto {
	
	private String boardCategory = "전체";
	private String searchWord;
	private String searchBoardCategory;
	
	private String isSearchCheck;
	private String searchBy;
	private String searchDate;
	private String searchInput;
	
	
	
	
	
	@Override
	public String toString() {
		return "SearchDto [boardCategory=" + boardCategory + ", searchWord=" + searchWord + ", searchBoardCategory="
				+ searchBoardCategory + ", isSearchCheck=" + isSearchCheck + ", searchBy=" + searchBy + ", searchDate="
				+ searchDate + ", searchInput=" + searchInput + "]";
	}
	public String getSearchBoardCategory() {
		return searchBoardCategory;
	}
	public void setSearchBoardCategory(String searchBoardCategory) {
		this.searchBoardCategory = searchBoardCategory;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	public String getIsSearchCheck() {
		return isSearchCheck;
	}
	public void setIsSearchCheck(String isSearchCheck) {
		this.isSearchCheck = isSearchCheck;
	}
	public String getBoardCategory() {
		return boardCategory;
	}
	public void setBoardCategory(String boardCategory) {
		this.boardCategory = boardCategory;
	}
	
	public String getSearchBy() {
		return searchBy;
	}
	public void setSearchBy(String searchBy) {
		this.searchBy = searchBy;
	}
	public String getSearchDate() {
		return searchDate;
	}
	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
	}
	public String getSearchInput() {
		return searchInput;
	}
	public void setSearchInput(String searchInput) {
		this.searchInput = searchInput;
	}

}
