package com.neoquant.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neoquant.dbutil.Constants;
import com.neoquant.dbutil.DataBaseConnection;
import com.neoquant.pojo.Employee;

public class EmployeeDaoImpl implements EmployeeDao{

	private static final String ADD_EMP = "insert into employee(name,age,gender,company_name,department,address,employee_id,password)"
			+ "values(?,?,?,?,?,?,?,?);";
	private static final String UPDATE_EMP = "UPDATE employee set name=?,age=?,gender=?,company_name=?,"
			+ "department=?,address=?,employee_id=?,password=? where id=?";
	private static final String DELETE_EMP = "DELETE from employee where id=?";
	private static final String GET_ALL_EMP = "SELECT *from employee";
	private static final String GET_EMP_BY_ID = "SELECT * from employee where id=?";
	private static final String GET_EMP_ID_PASSWORD = "SELECT *from employee where employee_id=? and password=?";
	
	
	@Override
	public boolean addEmployee(Employee emp) {
		Connection conn=null;
		PreparedStatement pre=null;
		int pos=0;
		int result=0;
		boolean saveStatus=false;
		try {
			conn=DataBaseConnection.establishedConnection();
			pre=conn.prepareStatement(ADD_EMP);
			pre.setString(++pos, emp.getName());
			pre.setInt(++pos, emp.getAge());
			pre.setString(++pos, emp.getGender());
			pre.setString(++pos, emp.getCompanyName());
			pre.setString(++pos, emp.getDepartment());
			pre.setString(++pos, emp.getAddress());
			pre.setInt(++pos, emp.getEmployeeId());
			pre.setString(++pos, emp.getPassword());
			result=pre.executeUpdate();
			if(result>0) {
				saveStatus=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return saveStatus;
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		Connection conn=null;
		PreparedStatement pre=null;
		int pos=0;
		int result=0;
		boolean saveStatus=false;
		try {
			conn=DataBaseConnection.establishedConnection();
			pre=conn.prepareStatement(UPDATE_EMP);
			pre.setString(++pos, emp.getName());
			pre.setInt(++pos, emp.getAge());
			pre.setString(++pos, emp.getGender());
			pre.setString(++pos, emp.getCompanyName());
			pre.setString(++pos, emp.getDepartment());
			pre.setString(++pos, emp.getAddress());
			pre.setInt(++pos, emp.getEmployeeId());
			pre.setString(++pos, emp.getPassword());
			pre.setInt(++pos, emp.getId());
			result=pre.executeUpdate();
			if(result>0) {
				saveStatus=true;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return saveStatus;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList=new ArrayList<Employee>();
		
		Connection conn=null;
		PreparedStatement pre=null;
		ResultSet rs=null;
		try {
			conn=DataBaseConnection.establishedConnection();
			pre=conn.prepareStatement(GET_ALL_EMP);
			rs=pre.executeQuery();
			while(rs.next()) {
				Employee emp=new Employee(rs.getInt(Constants.ID),rs.getString(Constants.NAME),rs.getByte(Constants.AGE),
						rs.getString(Constants.GENDER),rs.getString(Constants.COMPANY_NAME),rs.getString(Constants.DEPARTMENT),
						rs.getString(Constants.ADDRESS),rs.getInt(Constants.EMPLOYEE_ID),rs.getString(Constants.PASSWORD));
				employeeList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeList;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Connection conn=null;
		PreparedStatement pre=null;
		int pos=0;
		ResultSet rs=null;
		Employee emp=null;
		try {
			conn=DataBaseConnection.establishedConnection();
			pre=conn.prepareStatement(GET_EMP_BY_ID);
			pre.setInt(++pos, id);
			rs=pre.executeQuery();
			
			while(rs.next()) {
				emp=new Employee();
				emp.setId(rs.getInt(Constants.ID));
				emp.setName(rs.getString(Constants.NAME));
				emp.setAge(rs.getByte(Constants.AGE));
				emp.setGender(rs.getString(Constants.GENDER));
				emp.setCompanyName(rs.getString(Constants.COMPANY_NAME));
				emp.setDepartment(rs.getString(Constants.DEPARTMENT));
				emp.setAddress(rs.getString(Constants.ADDRESS));
				emp.setEmployeeId(rs.getInt(Constants.EMPLOYEE_ID));
				emp.setPassword(rs.getString(Constants.PASSWORD));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public boolean deleteEmployee(int id) {
		Connection conn=null;
		PreparedStatement pre=null;
		int pos=0;
		int result=0;
		boolean saveStatus=false;
		try {
			conn=DataBaseConnection.establishedConnection();
			pre=conn.prepareStatement(DELETE_EMP);
			pre.setInt(++pos, id);
			result=pre.executeUpdate();
			if(result>0) {
				saveStatus=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return saveStatus;
	}

	@Override
	public Employee getMatchIdAndPassword(int employeeId, String password) {
		Connection conn=null;
		PreparedStatement pre=null;
		int pos=0;
		ResultSet rs=null;
		Employee emp=null;
		try {
			conn=DataBaseConnection.establishedConnection();
			pre=conn.prepareStatement(GET_EMP_ID_PASSWORD);
			pre.setInt(++pos, employeeId);
			pre.setString(++pos, password);
			rs=pre.executeQuery();
			
			while(rs.next()) {
				emp=new Employee();
				System.out.println("inside rs while");
					emp.setId(rs.getInt(Constants.ID));
					emp.setName(rs.getString(Constants.NAME));
					emp.setAge(rs.getByte(Constants.AGE));
					emp.setGender(rs.getString(Constants.GENDER));
					emp.setCompanyName(rs.getString(Constants.COMPANY_NAME));
					emp.setDepartment(rs.getString(Constants.DEPARTMENT));
					emp.setAddress(rs.getString(Constants.ADDRESS));
					emp.setEmployeeId(rs.getInt(Constants.EMPLOYEE_ID));
					emp.setPassword(rs.getString(Constants.PASSWORD));
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return emp;
	}
}
