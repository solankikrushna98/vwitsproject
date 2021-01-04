package com.vwits.model.javabean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="answer")
public class Answer {
	
	@Id
	@Column(name="ansid")
	private String ansid;
	
	@Column(name="studentid")
	private int studentid;
	
	@Column(name="queid")
	private int queid;
	
	@Column(name="expected")
	private String expected;

	@Column(name="actual")
	private String actual;
	
	public Answer() {
		// TODO Auto-generated constructor stub
	}

	public Answer(int studentid, String ansid, int queid, String expected, String actual) {
		super();
		this.studentid = studentid;
		this.ansid = ansid;
		this.queid = queid;
		this.expected = expected;
		this.actual = actual;
	}

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public String getAnsid() {
		return ansid;
	}

	public void setAnsid(String ansid) {
		this.ansid = ansid;
	}
	
	public int getQueid() {
		return queid;
	}

	public void setQueid(int queid) {
		this.queid = queid;
	}

	public String getExpected() {
		return expected;
	}

	public void setExpected(String expected) {
		this.expected = expected;
	}

	public String getActual() {
		return actual;
	}

	public void setActual(String actual) {
		this.actual = actual;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ansid == null) ? 0 : ansid.hashCode());
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
		Answer other = (Answer) obj;
		if (ansid == null) {
			if (other.ansid != null)
				return false;
		} else if (!ansid.equals(other.ansid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[ansid=" + ansid + ", studentid=" + studentid + ", queid=" + queid + ", expected=" + expected
				+ ", actual=" + actual + "]\n";
	}
}
