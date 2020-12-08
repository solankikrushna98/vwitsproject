package com.vwits.model.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vwits.model.javabean.Teacher;

public class TeacherDAOImpl implements RecordDAO<Teacher, String> {
	DatabaseConnection db = new DatabaseConnection();
	Statement st = db.getStatement();
	PreparedStatement ps;
	
	@Override
	public int save(Teacher t) {
		int rows = 0;
		Connection conn = db.openConnection();
		TeacherDAOImpl teacher = new TeacherDAOImpl();
		List list = teacher.getDetail(t.getTusername());
		if(list.size() < 1) {
			try {
				PreparedStatement ps = conn.prepareStatement("insert into teacher values(?,?,?,?)");
				ps.setInt(1, t.getTeacherid());
				ps.setString(2, t.getTname());
				ps.setString(3, t.getTusername());
				ps.setString(4, t.getTpassword());
				rows = ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rows;										// Record inserted
		}else {
			return -1;											// Username already exists
		}
		
	}

	@Override
	public List get(String tusername) {
		List list = new ArrayList();
		Connection conn = db.openConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from teacher where tusername = ?");
			ps.setString(1, tusername);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getInt("teacherid"));
				list.add(rs.getString("tname"));
				list.add(rs.getString("tusername"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List getDetail(String tusername) {
		List list = new ArrayList();
		Connection conn = db.openConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from teacher where tusername = ?");
			ps.setString(1, tusername);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getInt("teacherid"));
				list.add(rs.getString("tname"));
				list.add(rs.getString("tusername"));
				list.add(rs.getString("tpassword"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List getAll() {
		List list = new ArrayList();
		Connection conn = db.openConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from teacher");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getInt("teacherid")+ " "+rs.getString("tname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int getLastId() {
		int id = 0;
		Connection conn = db.openConnection();
		Statement st;
		try {
			st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = st.executeQuery("select teacherid from teacher");
			
			rs.last();
			id = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}

	@Override
	public int update(String username, String oldpassword, String newpassword) {
		TeacherDAOImpl teacher = new TeacherDAOImpl();
		List list = teacher.getDetail(username);
		int rows = 0;
		
		if(list.size() < 1) {
			return -1;										// Username does not exist in database  
		}
		else {
			String password = (String) list.get(3);
			System.out.println(password);
			if(!password.equals(oldpassword)) {
				return -2;									// Invalid password for provided username
			}
			else {
				ps = db.getPreparedStatement("update teacher set tpassword = ? where tusername = ?");
				try {
					ps.setString(1, newpassword);
					ps.setString(2, username);
					rows = ps.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					db.closeConnection();
				}
				return 1;								 	// Password Updated
			}
		}
	}
}
