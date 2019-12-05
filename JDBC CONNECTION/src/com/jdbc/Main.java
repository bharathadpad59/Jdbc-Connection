package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
	
	public static void main(String[] args){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","SYSTEM","password");
			
			String query="select NAME, id, skills, YEAR_OF_PASSOUT, NATIVE_PLACE, FAVSUBJECT from studds where ID = 456";
			Statement stmt = con.createStatement();
			stmt.executeQuery(query);
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) 
			{
				System.out.println(rs.getString("NAME"));
			}
			stmt.close();
			con.close();
		  
		}catch(Exception e){
			System.out.println(e);
		}  
		
	}

}
