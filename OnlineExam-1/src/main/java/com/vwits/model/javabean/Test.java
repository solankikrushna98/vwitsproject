package com.vwits.model.javabean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Test")
public class Test {
	
	@Id
	@GeneratedValue
	@Column(name="queid")
	private int queid;
	
	@Column(name="que")
	private String que;
	
	@Column(name="optionA")
	private String optionA;
	
	@Column(name="optionB")
	private String optionB;
	
	@Column(name="optionC")
	private String optionC;
	
	@Column(name="optionD")
	private String optionD;
	
	@Column(name="ans")
	private String ans;
	
	public Test() {
		// TODO Auto-generated constructor stub
	}
	
	public Test(int queid, String que, String optionA, String optionB, String optionC, String optionD, String ans) {
		super();
		this.queid = queid;
		this.que = que;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.ans = ans;
	}

	public int getQueid() {
		return queid;
	}

	public void setQueid(int queid) {
		this.queid = queid;
	}

	public String getQue() {
		return que;
	}

	public void setQue(String que) {
		this.que = que;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	@Override
	public String toString() {
		return "[queid=" + queid + ", que=" + que + ", optionA=" + optionA + ", optionB=" + optionB
				+ ", optionC=" + optionC + ", optionD=" + optionD + ", ans=" + ans + "]\n";
	}
	
}
