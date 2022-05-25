package com.neoquant.daoImpl;

import java.util.List;

import com.neoquant.pojo.Employee;

public class EmployeeDaoImplMain {

	public static void main(String[] args) {
		
		EmployeeDaoImpl employee=new EmployeeDaoImpl();
		
//		boolean employeeAdd=employee.addEmployee(new Employee("Prasad",(byte)22,"Male","Neoquant sol ptv ltd","Java","Bhandup",103,"prasad");
//		System.out.println("Employee Added Successfully:"+employeeAdd);
		
//		boolean employeeUpdate=employee.updateEmployee(new Employee(2, "Sanchit Bane", (byte)23, "Male", "Tecno-point", "Java", "Bhandup", 102, "Sanchit"));
//		System.out.println("Employee Updated Successfully:"+employeeUpdate);
		
//		boolean employeeDelete=employee.deleteEmployee(2);
//		System.out.println("Employee Deleted Successfully:"+employeeDelete);
		
//		List<Employee> list= employee.getAllEmployees();
//		for (Employee employeeList : list) {
//			System.out.println(employeeList);
//		}
		
//		Employee emp=employee.getEmployeeById(2);
//		System.out.println(emp);
//		
		Employee emp=employee.getMatchIdAndPassword(103, "prasad");
		System.out.println("get match ID and Password:"+emp);
	}
}
