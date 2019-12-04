package com.atguigu.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.sys.dao.EmployeeMapper;
import com.atguigu.sys.entity.Employee;

@Service
public class EmployeeService implements com.atguigu.sys.service.EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;
	
	
	@Override
	public List<Employee> getEmployee() {
		
		return employeeMapper.getEmployee();
	}

}
