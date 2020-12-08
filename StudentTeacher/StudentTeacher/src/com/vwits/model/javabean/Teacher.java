package com.vwits.model.javabean;

public class Teacher {
	
	private int teacherid;
	private String tname;
	private String tusername;
	private String tpassword;
	
	public Teacher() {
		// TODO Auto-generated constructor stub
	}
	
	public Teacher(int teacherid, String tname, String tusername, String tpassword) {
		
		super();
		this.teacherid = teacherid;
		this.tname = tname;
		this.tusername = tusername;
		this.tpassword = tpassword;
	}

	public final int getTeacherid() {
		return teacherid;
	}

	public final void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}

	public final String getTname() {
		return tname;
	}

	public final void setTname(String tname) {
		this.tname = tname;
	}

	public final String getTusername() {
		return tusername;
	}

	public final void setTusername(String tusername) {
		this.tusername = tusername;
	}

	public final String getTpassword() {
		return tpassword;
	}

	public final void setTpassword(String tpassword) {
		this.tpassword = tpassword;
	}

	@Override
	public String toString() {
		return "Teacher [teacherid=" + teacherid + ", tname=" + tname + ", tusername=" + tusername + ", tpassword="
				+ tpassword + "]";
	}
	
	
}
