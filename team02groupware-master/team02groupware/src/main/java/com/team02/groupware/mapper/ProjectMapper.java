package com.team02.groupware.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.team02.groupware.dto.Project;

@Mapper
public interface ProjectMapper {
	
	//내 업무 차트 데이터 조회
	public Project selectForTaskChart(String userCode);
	
	// 업무 삭제
	public int taskDelete(String taskCode);
	
	//내 업무 상태 완료 수정
	public int taskStatusUpdate(String taskCode);
	
	//내 업무 1개 조회
	public Project selectForTaskUpdate(String taskCode);
	
	// 내업무 조회
	public List<Project> selectMyTask(String userCode);
	
	//업무리스트코드 수정(칸반)
	public int updateTasklistcode();
	
	// 업무 추가
	public int taskInsert(Project project);
	
	// 업무리스트 삭제
	public int tasklistDelete(String tasklistCode);
	
	// 업무상세정보 조회
	public List<Project> getTaskdetail(String projectCode);
	
	// 업무리스트 최근 코드 조회
	public String selectTasklistcode();
	
	//업무리스트추가
	public int tasklistInsert(Project project);
	
	//업무리스트 조회
	public List<Project> selectTasklist(String projectCode);	

	//프로젝트 삭제
	public int projectDelete(String projectCode);
	
	//프로젝트 한개 조회
	public Project selectForProUpdate(String projectCode);
	
	//프로젝트 수정
	public int projectUpdate(Project project);
	
	//프로젝트 추가모달창 사원 조회
	public List<Project> selectForAddEmployee();
	
	
	
	//프로젝트 추가
	public int projectInsert(Project project);
	
	//프로젝트리스트 페이지네이션
	public int getProjectRowCount();	

	//프로젝트 리스트
	public List<Project> getProjectlist(Map<String, Object> map);

	
}
