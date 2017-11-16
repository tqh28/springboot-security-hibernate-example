package springboot.security.hibernate.example.service;

import java.util.List;

import springboot.security.hibernate.example.model.Employee;


public interface EmployeeService {

	public List<Employee> getAll();
	
	public void insert(Employee e);
}
