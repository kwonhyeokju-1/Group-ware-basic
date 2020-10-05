package com.team02.groupware.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team02.groupware.dto.EmployeeDto;
import com.team02.groupware.mapper.EmployeeMapper;

@Service
@Transactional
public class LoginService {
	
	@Autowired
	private EmployeeMapper EmployeeMapper;
	
	public EmployeeDto selectEmployee(EmployeeDto eDto) {
		
		EmployeeDto empDto = EmployeeMapper.selectEmployee(eDto);
		
		return empDto;
	
	}
	
	

}
