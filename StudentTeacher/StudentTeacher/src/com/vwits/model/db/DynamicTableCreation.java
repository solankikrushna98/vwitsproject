package com.vwits.model.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DynamicTableCreation {
	
	
	public static void main(String[] args) {
		
		List parameters = new ArrayList<>();
		List datatypes = new ArrayList<>();
		parameters.add("id");
		parameters.add("name");
		parameters.add("salary");
		
		datatypes.add("int");
		datatypes.add("varchar(20)");
		datatypes.add("int");
		
		DynamicTableCreation dt = new DynamicTableCreation();
		dt.createTable("dynamic", parameters, datatypes);

	}
	
	void createTable(String name, List parameters, List datatypes) {
		DatabaseConnection db = new DatabaseConnection();
		Statement st = db.getStatement();
		String para = "";
		for(int i=0; i<parameters.size(); i++) {
			if(i == parameters.size()-1) {
				para = para.concat(parameters.get(i)+ " "+datatypes.get(i));
			}
			else
				para = para.concat(parameters.get(i)+ " "+datatypes.get(i)+", "); 
		}
		
		PreparedStatement ps = db.getPreparedStatement("create table "+name+ " ("+para+ " )");
		int rows = 0;
		try {
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			db.closeConnection();
		}
		System.out.println(rows);
	}

}
