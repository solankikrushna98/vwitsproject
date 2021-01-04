package com.vwits.model.javabean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="teacher")
public class Teacher {
	
	@Id
	@GeneratedValue
	@Column(name="teacherid")
	private int teacherid;
	
	@Column(name="name")
	private String name;
	
	@Column(name="username")
	private String username;
	private String password;
	
	public Teacher() {
		// TODO Auto-generated constructor stub
	}

	public Teacher(int teacherid, String name, String username, String password) {
		super();
		this.teacherid = teacherid;
		this.name = name;
		this.username = username;
		this.password = password;
	}

	public int getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + teacherid;
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
		Teacher other = (Teacher) obj;
		if (teacherid != other.teacherid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Teacher [teacherid=" + teacherid + ", name=" + name + ", username=" + username + ", password="
				+ password + "]";
	}
}	