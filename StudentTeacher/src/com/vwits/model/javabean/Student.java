package com.vwits.model.javabean;

public class Student {
	
	private int studentid;
	private String name;
	private String username;
	private String password;
	private int result;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(int studentid, String name, String username, String password, int result) {
		super();
		this.studentid = studentid;
		this.name = name;
		this.username = username;
		this.password = password;
		this.setResult(result);
	}

	public final int getStudentid() {
		return studentid;
	}

	public final void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getUsername() {
		return username;
	}

	public final void setUsername(String username) {
		this.username = username;
	}

	public final String getPassword() {
		return password;
	}

	public final void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "studentid=" + studentid + ", name=" + name + ", username=" + username + ", password="
				+ password;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
}
