package com.team02.groupware.dto;

public class CommentDto {

	
	private String commentWriter;
	private String commentDate;
	private String commentContent;
	private int commentNum;
	
	
	
	
	@Override
	public String toString() {

		return "CommentDto [commentWriter=" + commentWriter + ", commentDate=" + commentDate + ", commentContent="
				+ commentContent + ", commentNum=" + commentNum + "]";
	}
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	public String getCommentWriter() {
		return commentWriter;
	}
	public void setCommentWriter(String commentWriter) {
		this.commentWriter = commentWriter;

	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	
	
}
