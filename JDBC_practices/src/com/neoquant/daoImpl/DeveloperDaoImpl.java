package com.neoquant.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neoquant.dbutil.Constants;
import com.neoquant.dbutil.DataBaseConnection;
import com.neoquant.pojo.Developer;

public class DeveloperDaoImpl implements DeveloperDao{

	private static final String ADD_DEVELOPER = "INSERT into developer(name,gender,language_name,salary,work_type) values(?,?,?,?,?)";
	private static final String UPDATE_DEV = "UPDATE developer set name=?,gender=?,language_name=?,salary=?,work_type=? where id=?";
	private static final String GET_ALL_DEVELOPERS = "SELECT *from developer";
	private static final String DROP_DEVELOPER = "DELETE from developer where id=?";
	
	@Override
	public boolean addDeveloper(Developer dev) {
		Connection conn=null;
		PreparedStatement pre=null;
		int pos=0;
		int result=0;
		boolean saveStatus=false;
		try {
			conn=DataBaseConnection.establishedConnection();
			pre=conn.prepareStatement(ADD_DEVELOPER);
			pre.setString(++pos, dev.getName());
			pre.setString(++pos, dev.getGender());
			pre.setString(++pos, dev.getLanguageName());
			pre.setInt(++pos, dev.getSalary());
			pre.setString(++pos, dev.getWorkType());
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
	public boolean updateDeveloper(Developer dev) {
		Connection conn=null;
		PreparedStatement pre=null;
		int pos=0;
		int result=0;
		boolean saveStatus=false;
		try {
			conn=DataBaseConnection.establishedConnection();
			pre=conn.prepareStatement(UPDATE_DEV);
			pre.setString(++pos, dev.getName());
			pre.setString(++pos, dev.getGender());
			pre.setString(++pos, dev.getLanguageName());
			pre.setInt(++pos, dev.getSalary());
			pre.setString(++pos, dev.getWorkType());
			pre.setInt(++pos, dev.getId());
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
	public List<Developer> getAllDevelopers() {
		List<Developer> developerList=new ArrayList<Developer>();
		
		Connection conn=null;
		PreparedStatement pre=null;
		ResultSet rs=null;
		
		try {
			conn=DataBaseConnection.establishedConnection();
			pre=conn.prepareStatement(GET_ALL_DEVELOPERS);
			rs=pre.executeQuery();
			while(rs.next()) {
				Developer dev=new Developer(rs.getInt(Constants.ID),rs.getString(Constants.NAME),
						rs.getString(Constants.GENDER),rs.getString(Constants.LANGUAGE_NAME),
						rs.getInt(Constants.SALARY),rs.getString(Constants.WORK_TYPE));
				developerList.add(dev);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return developerList;
	}

	@Override
	public boolean deleteDeveloper(int id) {
		Connection conn=null;
		PreparedStatement pre=null;
		int pos=0;
		int result=0;
		boolean saveStatus=false;
		try {
			conn=DataBaseConnection.establishedConnection();
			pre=conn.prepareStatement(DROP_DEVELOPER);
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

}
