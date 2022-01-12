package com.th.ws.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.th.ws.demo.model.Employee;
import com.th.ws.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public Employee getEmployeeById(int employeeId) {
		Optional<Employee> empOpt = employeeRepository.findById(employeeId);
		if (empOpt.isPresent())
			return empOpt.get();
		return null;
	}

}
