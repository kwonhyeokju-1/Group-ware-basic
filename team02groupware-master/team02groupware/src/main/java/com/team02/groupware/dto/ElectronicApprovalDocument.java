package com.team02.groupware.dto;

/*
 * @file ElectronicApprovalDocument.java
 * @brief 전자결재 관련 DTO
 * @author 김건훈
 */
public class ElectronicApprovalDocument {

	/**
	 * @brief 문서양식 테이블 컬럼별 전역변수
	 * @author 김건훈
	 */
	private String dFormCode; //문서 양식 코드
	private String dSecurityLevel; //보안등급 레벨
	private String dFormTypeCode; //문서 양식 분류 코드
	private String dApprovalFormatCode; //결재양식 포맷 코드
	private String dFormName; //문서 양식 명
	private String dFormAbbreviation; //문서 양식 약칭
	private String dFormDetailExplanation; //문서 양식 상세설명
	private String dSecurityLevelChangeable; //보안등급 변경가능여부
	private String dExpiryDate; //문서 최초 보존연한
	private String dExpiryDateChangeable; //보존연한 변경가능여부
	private String dFormDetailContent; //문서 양식 상세내용
	
	/**
	 * @brief 문서양식 분류 테이블 컬럼별 전역변수
	 * @author 김건훈
	 */
	//문서양식 분류 코드는 문서양식 테이블 컬럼별 전역변수 내 에 있음
	private String dFormType; //문서 양식 분류 명
	
	/**
	 * @brief 전자결재 기본설정 테이블 컬럼별 전역변수
	 * @author 김건훈
	 */
	private String dCompanyCodeUsage; //회사코드 사용 여부
	private String dAbbreviationUsage; //약칭 사용 여부
	private String dUnitNameUsage; //소속 명 사용 여부
	private String dRegisterTimeFormat; //문서 등록 시점 형식
	private String dSerialNumberFormat; //일련 번호 형식
	private String dExpiredDateDelete; //보존 연한 만료 후 삭제 여부
	private String dDecideFirstUsage; //선결재 여부
	private String dDecideInsteadUsage; //대결 여부
	private String dDecideAfterUsage; //후결 여부
	private String dReferTime; //참조 열람 시기 설정
	private String dDraftCancelUsage; //기안 취소 여부
	private String dEaRule; //사내 전자결재 규정
	
	/**
	 * @brief 전자결재 결재양식 포맷 테이블 컬럼별 전역변수
	 * @author 김건훈
	 */
	private String dApprovalFormatDetailContent; //결재양식 포맷 내용
	
	
	/**
	 * @brief 문서양식 테이블 컬럼별 전역변수 getters&setters
	 * @author 김건훈
	 */
	public String getdFormCode() {
		return dFormCode;
	}
	public void setdFormCode(String dFormCode) {
		this.dFormCode = dFormCode;
	}
	public String getdSecurityLevel() {
		return dSecurityLevel;
	}
	public void setdSecurityLevel(String dSecurityLevel) {
		this.dSecurityLevel = dSecurityLevel;
	}
	public String getdFormTypeCode() {
		return dFormTypeCode;
	}
	public void setdFormTypeCode(String dFormTypeCode) {
		this.dFormTypeCode = dFormTypeCode;
	}
	public String getdApprovalFormatCode() {
		return dApprovalFormatCode;
	}
	public void setdApprovalFormatCode(String dApprovalFormatCode) {
		this.dApprovalFormatCode = dApprovalFormatCode;
	}
	public String getdFormName() {
		return dFormName;
	}
	public void setdFormName(String dFormName) {
		this.dFormName = dFormName;
	}
	public String getdFormAbbreviation() {
		return dFormAbbreviation;
	}
	public void setdFormAbbreviation(String dFormAbbreviation) {
		this.dFormAbbreviation = dFormAbbreviation;
	}
	public String getdFormDetailExplanation() {
		return dFormDetailExplanation;
	}
	public void setdFormDetailExplanation(String dFormDetailExplanation) {
		this.dFormDetailExplanation = dFormDetailExplanation;
	}
	public String getdSecurityLevelChangeable() {
		return dSecurityLevelChangeable;
	}
	public void setdSecurityLevelChangeable(String dSecurityLevelChangeable) {
		this.dSecurityLevelChangeable = dSecurityLevelChangeable;
	}
	public String getdExpiryDate() {
		return dExpiryDate;
	}
	public void setdExpiryDate(String dExpiryDate) {
		this.dExpiryDate = dExpiryDate;
	}
	public String getdExpiryDateChangeable() {
		return dExpiryDateChangeable;
	}
	public void setdExpiryDateChangeable(String dExpiryDateChangeable) {
		this.dExpiryDateChangeable = dExpiryDateChangeable;
	}
	public String getdFormDetailContent() {
		return dFormDetailContent;
	}
	public void setdFormDetailContent(String dFormDetailContent) {
		this.dFormDetailContent = dFormDetailContent;
	}
	
	
	/**
	 * @brief 문서양식 분류 테이블 컬럼별 전역변수 getters&setters
	 * @author 김건훈
	 */
	public String getdFormType() {
		return dFormType;
	}
	public void setdFormType(String dFormType) {
		this.dFormType = dFormType;
	}
	
	/**
	 * @brief 전자결재 기본설정 테이블 컬럼별 전역변수 getters&setters
	 * @author 김건훈
	 */
	public String getdCompanyCodeUsage() {
		return dCompanyCodeUsage;
	}
	public void setdCompanyCodeUsage(String dCompanyCodeUsage) {
		this.dCompanyCodeUsage = dCompanyCodeUsage;
	}
	public String getdAbbreviationUsage() {
		return dAbbreviationUsage;
	}
	public void setdAbbreviationUsage(String dAbbreviationUsage) {
		this.dAbbreviationUsage = dAbbreviationUsage;
	}
	public String getdUnitNameUsage() {
		return dUnitNameUsage;
	}
	public void setdUnitNameUsage(String dUnitNameUsage) {
		this.dUnitNameUsage = dUnitNameUsage;
	}
	public String getdRegisterTimeFormat() {
		return dRegisterTimeFormat;
	}
	public void setdRegisterTimeFormat(String dRegisterTimeFormat) {
		this.dRegisterTimeFormat = dRegisterTimeFormat;
	}
	public String getdSerialNumberFormat() {
		return dSerialNumberFormat;
	}
	public void setdSerialNumberFormat(String dSerialNumberFormat) {
		this.dSerialNumberFormat = dSerialNumberFormat;
	}
	public String getdExpiredDateDelete() {
		return dExpiredDateDelete;
	}
	public void setdExpiredDateDelete(String dExpiredDateDelete) {
		this.dExpiredDateDelete = dExpiredDateDelete;
	}
	public String getdDecideFirstUsage() {
		return dDecideFirstUsage;
	}
	public void setdDecideFirstUsage(String dDecideFirstUsage) {
		this.dDecideFirstUsage = dDecideFirstUsage;
	}
	public String getdDecideInsteadUsage() {
		return dDecideInsteadUsage;
	}
	public void setdDecideInsteadUsage(String dDecideInsteadUsage) {
		this.dDecideInsteadUsage = dDecideInsteadUsage;
	}
	public String getdDecideAfterUsage() {
		return dDecideAfterUsage;
	}
	public void setdDecideAfterUsage(String dDecideAfterUsage) {
		this.dDecideAfterUsage = dDecideAfterUsage;
	}
	public String getdReferTime() {
		return dReferTime;
	}
	public void setdReferTime(String dReferTime) {
		this.dReferTime = dReferTime;
	}
	public String getdDraftCancelUsage() {
		return dDraftCancelUsage;
	}
	public void setdDraftCancelUsage(String dDraftCancelUsage) {
		this.dDraftCancelUsage = dDraftCancelUsage;
	}
	public String getdEaRule() {
		return dEaRule;
	}
	public void setdEaRule(String dEaRule) {
		this.dEaRule = dEaRule;
	}
	
	
	/**
	 * @brief 전자결재 결재양식 포맷 테이블 컬럼별 전역변수 getters&setters
	 * @author 김건훈
	 */
	public String getdApprovalFormatDetailContent() {
		return dApprovalFormatDetailContent;
	}
	public void setdApprovalFormatDetailContent(String dApprovalFormatDetailContent) {
		this.dApprovalFormatDetailContent = dApprovalFormatDetailContent;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ElectronicApprovalDocument [dFormCode=");
		builder.append(dFormCode);
		builder.append(", dSecurityLevel=");
		builder.append(dSecurityLevel);
		builder.append(", dFormTypeCode=");
		builder.append(dFormTypeCode);
		builder.append(", dApprovalFormatCode=");
		builder.append(dApprovalFormatCode);
		builder.append(", dFormName=");
		builder.append(dFormName);
		builder.append(", dFormAbbreviation=");
		builder.append(dFormAbbreviation);
		builder.append(", dFormDetailExplanation=");
		builder.append(dFormDetailExplanation);
		builder.append(", dSecurityLevelChangeable=");
		builder.append(dSecurityLevelChangeable);
		builder.append(", dExpiryDate=");
		builder.append(dExpiryDate);
		builder.append(", dExpiryDateChangeable=");
		builder.append(dExpiryDateChangeable);
		builder.append(", dFormDetailContent=");
		builder.append(dFormDetailContent);
		builder.append(", dFormType=");
		builder.append(dFormType);
		builder.append(", dCompanyCodeUsage=");
		builder.append(dCompanyCodeUsage);
		builder.append(", dAbbreviationUsage=");
		builder.append(dAbbreviationUsage);
		builder.append(", dUnitNameUsage=");
		builder.append(dUnitNameUsage);
		builder.append(", dRegisterTimeFormat=");
		builder.append(dRegisterTimeFormat);
		builder.append(", dSerialNumberFormat=");
		builder.append(dSerialNumberFormat);
		builder.append(", dExpiredDateDelete=");
		builder.append(dExpiredDateDelete);
		builder.append(", dDecideFirstUsage=");
		builder.append(dDecideFirstUsage);
		builder.append(", dDecideInsteadUsage=");
		builder.append(dDecideInsteadUsage);
		builder.append(", dDecideAfterUsage=");
		builder.append(dDecideAfterUsage);
		builder.append(", dReferTime=");
		builder.append(dReferTime);
		builder.append(", dDraftCancelUsage=");
		builder.append(dDraftCancelUsage);
		builder.append(", dEaRule=");
		builder.append(dEaRule);
		builder.append(", dApprovalFormatDetailContent=");
		builder.append(dApprovalFormatDetailContent);
		builder.append("]");
		return builder.toString();
	}

	
	
	
}
