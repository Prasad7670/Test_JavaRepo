package com.neoquant.daoImpl;

import java.util.List;

import com.neoquant.pojo.Employee;

public interface EmployeeDao {

	public boolean addEmployee(Employee emp);
	public boolean updateEmployee(Employee emp);
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(int id);
	public boolean deleteEmployee(int id);
	public Employee getMatchIdAndPassword(int employeeId, String password);
}
