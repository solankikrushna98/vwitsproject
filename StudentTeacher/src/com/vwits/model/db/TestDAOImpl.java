package com.vwits.model.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vwits.model.javabean.Test;


public class TestDAOImpl implements TestDAO<Test, Integer, String>{
	DatabaseConnection db = new DatabaseConnection();
	PreparedStatement ps = null;
	@Override
	public int save(Test t) {
		int rows = 0;
		TestDAOImpl test = new TestDAOImpl();
		int lastid = test.getLastId();
		ps = db.getPreparedStatement("insert into test values(?,?,?,?,?,?,?)");
		try {
			if(lastid == 0)
				ps.setInt(1, 1);
			else { 
				ps.setInt(1, test.getLastId()+1);
			}
			ps.setString(2, t.getQue());
			ps.setString(3, t.getOptionA());
			ps.setString(4, t.getOptionB());
			ps.setString(5, t.getOptionC());
			ps.setString(6, t.getOptionD());
			ps.setString(7, t.getAns());
			rows = ps.executeUpdate();	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			db.closeConnection();
		}
		return rows;
	}

	@Override
	public List<Test> get(Integer queid) {
		List<Test> list = new ArrayList<Test>();
		ps = db.getPreparedStatement("select * from test where queid="+queid);
		try {
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Test test = new Test(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
				list.add(test);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.closeConnection();
		}
		return list;
	}

	@Override
	public List getAll() {
		List<Test> list = new ArrayList<Test>();
		ps = db.getPreparedStatement("select * from test");
		try {
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Test test = new Test(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
				list.add(test);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeConnection();
		}
		return list;
	}

	@Override
	public int update(String opA, String opB, String opC, String opD, String ans, Integer queid) {
		int rows = 0;
		ps = db.getPreparedStatement("update test set optionA = ?, optionB = ?, optionC = ?, optionD = ?, ans = ? where queid = ?");
		try {
			ps.setString(1, opA);
			ps.setString(2, opB);
			ps.setString(3, opC);
			ps.setString(4, opD);
			ps.setString(5, ans);
			ps.setInt(6, queid);
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rows;
	}
	/**
	 * 
	 * @return get last question id from test table
	 */
	public int getLastId() {
		int id = 0;
		Connection conn = db.openConnection();
		Statement st;
		try {
			st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = st.executeQuery("select queid from test");
			
			rs.last();
			id = rs.getInt(1);
			System.out.println(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.closeConnection();
		}
		return id;
	}
	
	
}
