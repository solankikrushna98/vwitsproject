package com.vwits.model.javabean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue
	@Column(name="studentid")
	private int studentid;
	
	@Column(name="name")
	private String name;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="result")
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
	
	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", name=" + name + ", username=" + username + ", password="
				+ password + ", result=" + result + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + studentid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (studentid != other.studentid)
			return false;
		return true;
	}
	
}
