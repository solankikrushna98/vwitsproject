package com.vwits.model.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vwits.model.javabean.Student;

public class StudentDAOImpl implements RecordDAO<Student, String> {
	DatabaseConnection db = new DatabaseConnection();
	Statement st = db.getStatement();
	PreparedStatement ps;
	
	@Override
	public int save(Student t) {
		int rows = 0;
		Connection conn = db.openConnection();
		StudentDAOImpl student = new StudentDAOImpl();
		List list = student.getDetail(t.getUsername());
		System.out.println("List size = "+list.size());
		if(list.size() < 1) {
			try {
				PreparedStatement ps = conn.prepareStatement("insert into student values(?,?,?,?,?)");
				ps.setInt(1, t.getStudentid());
				ps.setString(2, t.getName());
				ps.setString(3, t.getUsername());
				ps.setString(4, t.getPassword());
				ps.setInt(5, -1);
				rows = ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.closeConnection();
			}
			return rows;
		}else {
			return -1;
		}
		
	}

	@Override
	public List get(String sname) {
		List list = new ArrayList();
		Connection conn = db.openConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from student where sname = ?");
			ps.setString(1, sname);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getInt("studentid"));
				list.add(rs.getString("sname"));
				list.add(rs.getString("susername"));
				list.add(rs.getString("result"));
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
	public List getDetail(String username) {
		List list = new ArrayList();
		Connection conn = db.openConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from student where susername = ?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getInt("studentid"));
				list.add(rs.getString("sname"));
				list.add(rs.getString("susername"));
				list.add(rs.getString("spassword"));
				list.add(rs.getString("result"));
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
		List<Student> list = new ArrayList();
		Connection conn = db.openConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from student");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Student student = new Student(rs.getInt("studentid"), rs.getString("sname"), rs.getString("susername"), rs.getString("spassword"), rs.getInt("result"));
				list.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.closeConnection();
		}
		return list;
	}

	public int updateCredentials(String username, String password, String name) {
		int rows = 0;
		Connection conn = db.openConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("update student set susername = ?, spassword = ? where sname =?");
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, name);			
			
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.closeConnection();
		}
		return rows;
	}

	public int updateResult(int studentid, int result) {
		int rows = 0;
		Connection conn = db.openConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("update student set result = ? where studentid = ?");
			ps.setInt(1, result);
			ps.setInt(2, studentid);
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.closeConnection();
		}
		return rows;
	}

	public int getLastId() {
		int id = 0;
		Connection conn = db.openConnection();
		Statement st;
		try {
			st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = st.executeQuery("select studentid from student");
			
			rs.last();
			id = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.closeConnection();
		}
		
		return id;
	}

	@Override
	public int update(String username, String oldpassword, String newpassword) {
		StudentDAOImpl student = new StudentDAOImpl();
		List list = student.getDetail(username);
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
				ps = db.getPreparedStatement("update student set spassword = ? where susername = ?");
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
