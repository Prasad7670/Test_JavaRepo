package com.neoquant.pojo;

public class Employee {

	private int id;
	private String name;
	private byte age;
	private String gender;
	private String companyName;
	private String department;
	private String address;
	private int employeeId;
	private String password;
	public Employee() {
		super();
	}
	public Employee(int id, String name, byte age, String gender, String companyName, String department, String address,
			int employeeId, String password) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.companyName = companyName;
		this.department = department;
		this.address = address;
		this.employeeId = employeeId;
		this.password = password;
	}
	public Employee(String name, byte age, String gender, String companyName, String department, String address,
			int employeeId, String password) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.companyName = companyName;
		this.department = department;
		this.address = address;
		this.employeeId = employeeId;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte getAge() {
		return age;
	}
	public void setAge(byte age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", companyName="
				+ companyName + ", department=" + department + ", address=" + address + ", employeeId=" + employeeId
				+ ", password=" + password + "]";
	}
}


/*
create table employee(
id int not null auto_increment,
name varchar(30) not null,
age int not null,
gender varchar(10) not null,
company_name varchar(30) not null,
department varchar(20) not null,
address varchar(30) not null,
primary key(id)
); 
 */