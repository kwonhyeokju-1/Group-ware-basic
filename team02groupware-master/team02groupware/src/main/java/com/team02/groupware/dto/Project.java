package com.team02.groupware.dto;

import java.util.Date;

public class Project {

	//프로젝트
	private String projectCode;	// 프로젝트코드
	private String employeeCode;	// 사원번호
	private String employeeName;	// 사원이름
	private String projectTitle;	// 프로젝트제목
	private String projectDate;	// 프로젝트작성일
	private String projectDesc;	// 프로젝트설명
	private String projectAccess;	// 프로젝트공개범위
	private String projectStatus;	// 프로젝트상태
	private String projectStart;	// 프로젝트시작일
	private String projectEnd;	// 프로젝트실제완료일
	private String projectDeadline;	// 프로젝트마감일
	
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	public String getProjectDesc() {
		return projectDesc;
	}
	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}
	public String getProjectAccess() {
		return projectAccess;
	}
	public void setProjectAccess(String projectAccess) {
		this.projectAccess = projectAccess;
	}
	public String getProjectStatus() {
		return projectStatus;
	}
	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}
	public String getProjectStart() {
		return projectStart;
	}
	public void setProjectStart(String projectStart) {
		this.projectStart = projectStart;
	}
	public String getProjectEnd() {
		return projectEnd;
	}
	public void setProjectEnd(String projectEnd) {
		this.projectEnd = projectEnd;
	}
	public String getProjectDeadline() {
		return projectDeadline;
	}
	public void setProjectDeadline(String projectDeadline) {
		this.projectDeadline = projectDeadline;
	}
	public String getProjectDate() {
		return projectDate;
	}
	public void setProjectDate(String projectDate) {
		this.projectDate = projectDate;
	}
	
	
	
	//업무리스트 정보
	private String tasklistCode;
	private String tasklistName;
	
	//업무상세정보
	private String taskCode;
	private String taskOrder;
	private String taskTitle;
	private String taskDesc;
	private String taskDate;
	private Date taskDeadline;
	private String taskStart;
	private String taskEnd;
	private String taskStatus;

	public String getTasklistCode() {
		return tasklistCode;
	}
	public void setTasklistCode(String tasklistCode) {
		this.tasklistCode = tasklistCode;
	}
	public String getTasklistName() {
		return tasklistName;
	}
	public void setTasklistName(String tasklistName) {
		this.tasklistName = tasklistName;
	}
	public String getTaskCode() {
		return taskCode;
	}
	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}
	
	public String getTaskOrder() {
		return taskOrder;
	}
	public void setTaskOrder(String taskOrder) {
		this.taskOrder = taskOrder;
	}
	public String getTaskTitle() {
		return taskTitle;
	}
	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}
	public String getTaskDesc() {
		return taskDesc;
	}
	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}
	public String getTaskDate() {
		return taskDate;
	}
	public void setTaskDate(String taskDate) {
		this.taskDate = taskDate;
	}
	public Date getTaskDeadline() {
		return taskDeadline;
	}
	public void setTaskDeadline(Date taskDeadline) {
		this.taskDeadline = taskDeadline;
	}
	public String getTaskStart() {
		return taskStart;
	}
	public void setTaskStart(String taskStart) {
		this.taskStart = taskStart;
	}
	public String getTaskEnd() {
		return taskEnd;
	}
	public void setTaskEnd(String taskEnd) {
		this.taskEnd = taskEnd;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	
	private String taskSum;
	private String taskSuccess;
	private String taskNodeadline;
	private String taskAfterDeadline;
	private String taskPlanning;
	
	
	public String getTaskSum() {
		return taskSum;
	}
	public void setTaskSum(String taskSum) {
		this.taskSum = taskSum;
	}
	public String getTaskSuccess() {
		return taskSuccess;
	}
	public void setTaskSuccess(String taskSuccess) {
		this.taskSuccess = taskSuccess;
	}
	public String getTaskNodeadline() {
		return taskNodeadline;
	}
	public void setTaskNodeadline(String taskNodeadline) {
		this.taskNodeadline = taskNodeadline;
	}
	public String getTaskAfterDeadline() {
		return taskAfterDeadline;
	}
	public void setTaskAfterDeadline(String taskAfterDeadline) {
		this.taskAfterDeadline = taskAfterDeadline;
	}
	public String getTaskPlanning() {
		return taskPlanning;
	}
	public void setTaskPlanning(String taskPlanning) {
		this.taskPlanning = taskPlanning;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Project [projectCode=");
		builder.append(projectCode);
		builder.append(", employeeCode=");
		builder.append(employeeCode);
		builder.append(", employeeName=");
		builder.append(employeeName);
		builder.append(", projectTitle=");
		builder.append(projectTitle);
		builder.append(", projectDate=");
		builder.append(projectDate);
		builder.append(", projectDesc=");
		builder.append(projectDesc);
		builder.append(", projectAccess=");
		builder.append(projectAccess);
		builder.append(", projectStatus=");
		builder.append(projectStatus);
		builder.append(", projectStart=");
		builder.append(projectStart);
		builder.append(", projectEnd=");
		builder.append(projectEnd);
		builder.append(", projectDeadline=");
		builder.append(projectDeadline);
		builder.append(", tasklistCode=");
		builder.append(tasklistCode);
		builder.append(", tasklistName=");
		builder.append(tasklistName);
		builder.append(", taskCode=");
		builder.append(taskCode);
		builder.append(", taskTitle=");
		builder.append(taskTitle);
		builder.append(", taskDesc=");
		builder.append(taskDesc);
		builder.append(", taskDate=");
		builder.append(taskDate);
		builder.append(", taskDeadline=");
		builder.append(taskDeadline);
		builder.append(", taskStart=");
		builder.append(taskStart);
		builder.append(", taskEnd=");
		builder.append(taskEnd);
		builder.append(", taskStatus=");
		builder.append(taskStatus);
		builder.append(", taskSum=");
		builder.append(taskSum);
		builder.append(", taskSuccess=");
		builder.append(taskSuccess);
		builder.append(", taskNodeadline=");
		builder.append(taskNodeadline);
		builder.append(", taskAfterDeadline=");
		builder.append(taskAfterDeadline);
		builder.append(", taskPlanning=");
		builder.append(taskPlanning);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
