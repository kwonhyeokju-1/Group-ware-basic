package com.team02.groupware.dto;



public class PagingDto {
	
	
	private int viewNum = 10;
	private int selectPage = 1;
	private int limitNum = 0;
	
	private int pageFirstNum;
	private int pageLastNum;
	private boolean isPrevBtn;
	private boolean isNextBtn;
	
	private String departList = "전체";
	
	


	@Override
	public String toString() {
		return "PagingDto [viewNum=" + viewNum + ", selectPage=" + selectPage + ", limitNum=" + limitNum
				+ ", pageFirstNum=" + pageFirstNum + ", pageLastNum=" + pageLastNum + ", isPrevBtn=" + isPrevBtn
				+ ", isNextBtn=" + isNextBtn + ", departList=" + departList + "]";
	}

	public String getDepartList() {
		return departList;
	}

	public void setDepartList(String departList) {
		this.departList = departList;
	}

	

	public int getLimitNum() {
		return limitNum;
	}

	public void setLimitNum(int limitNum) {
		this.limitNum = limitNum;
	}

	public int getViewNum() {
		return viewNum;
	}
	
	public void setViewNum(int viewNum) {
		this.viewNum = viewNum;
	}
	
	public int getSelectPage() {
		return selectPage;
	}
	
	public void setSelectPage(int selectPage) {
		this.selectPage = selectPage;
	}
	
	
	public int getPageFirstNum() {
		return pageFirstNum;
	}
	public void setPageFirstNum(int pageFirstNum) {
		this.pageFirstNum = pageFirstNum;
	}
	public int getPageLastNum() {
		return pageLastNum;
	}
	public void setPageLastNum(int pageLastNum) {
		this.pageLastNum = pageLastNum;
	}
	public boolean isPrevBtn() {
		return isPrevBtn;
	}
	public void setPrevBtn(boolean isPrevBtn) {
		this.isPrevBtn = isPrevBtn;
	}
	public boolean isNextBtn() {
		return isNextBtn;
	}
	public void setNextBtn(boolean isNextBtn) {
		this.isNextBtn = isNextBtn;
	}
	
	

}
