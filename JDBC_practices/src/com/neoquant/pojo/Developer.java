package com.neoquant.pojo;

public class Developer {

	private int id;
	private String name;
	private String gender;
	private String languageName;
	private int salary;
	private String workType;
	
	public Developer() {
		super();
	}
	public Developer(int id, String name, String gender, String languageName, int salary, String workType) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.languageName = languageName;
		this.salary = salary;
		this.workType = workType;
	}
	public Developer(String name, String gender, String languageName, int salary, String workType) {
		super();
		this.name = name;
		this.gender = gender;
		this.languageName = languageName;
		this.salary = salary;
		this.workType = workType;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLanguageName() {
		return languageName;
	}
	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	@Override
	public String toString() {
		return "Developer [id=" + id + ", name=" + name + ", gender=" + gender + ", languageName=" + languageName
				+ ", salary=" + salary + ", workType=" + workType + "]";
	}
}
