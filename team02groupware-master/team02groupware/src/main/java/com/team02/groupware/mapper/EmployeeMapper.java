package com.team02.groupware.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.team02.groupware.dto.EmployeeDto;

@Mapper
public interface EmployeeMapper {
	
	public EmployeeDto selectEmployee(EmployeeDto eDto);
	
}
