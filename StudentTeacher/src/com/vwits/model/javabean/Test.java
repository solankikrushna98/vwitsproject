package com.vwits.model.javabean;

public class Test {
	
	private int queid;
	private String que;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
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

	public final int getQueid() {
		return queid;
	}

	public final void setQueid(int queid) {
		this.queid = queid;
	}

	public final String getQue() {
		return que;
	}

	public final void setQue(String que) {
		this.que = que;
	}

	public final String getOptionA() {
		return optionA;
	}

	public final void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public final String getOptionB() {
		return optionB;
	}

	public final void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public final String getOptionC() {
		return optionC;
	}

	public final void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public final String getOptionD() {
		return optionD;
	}

	public final void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public final String getAns() {
		return ans;
	}

	public final void setAns(String ans) {
		this.ans = ans;
	}

	@Override
	public String toString() {
		return "Question [queid=" + queid + ", que=" + que + ", optionA=" + optionA + ", optionB=" + optionB
				+ ", optionC=" + optionC + ", optionD=" + optionD + ", ans=" + ans + "]";
	}
	
}
