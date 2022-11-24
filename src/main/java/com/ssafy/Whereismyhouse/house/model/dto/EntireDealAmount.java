package com.ssafy.Whereismyhouse.house.model.dto;

public class EntireDealAmount {
	String dongName, cnt;

	public String getDongName() {
		return dongName;
	}

	public void setDongName(String dongName) {
		this.dongName = dongName;
	}

	public String getCnt() {
		return cnt;
	}

	public void setCnt(String cnt) {
		this.cnt = cnt;
	}

	public EntireDealAmount(String dongName, String cnt) {
		super();
		this.dongName = dongName;
		this.cnt = cnt;
	}
}
