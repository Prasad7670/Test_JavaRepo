package com.neoquant.dbutil;

import java.sql.Connection;
import java.sql.SQLException;

public class DataBaseConnectionMain {

	public static void main(String[] args) {
		
		try {
			Connection conn=DataBaseConnection.establishedConnection();
			System.out.println("Created Connection Object:"+conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
