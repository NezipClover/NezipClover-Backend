package com.ssafy.Whereismyhouse.user.model.dto;

public class Bookmark {
	
	private String dongCode;
	private String sidoName;
	private String gugunName;
	private String dongName;
	
	public Bookmark(String dongCode, String sidoName, String gugunName, String dongName) {
		super();
		this.dongCode = dongCode;
		this.sidoName = sidoName;
		this.gugunName = gugunName;
		this.dongName = dongName;
	}
	
	public String getDongCode() {
		return dongCode;
	}
	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}
	public String getDongName() {
		return dongName;
	}
	public void setDongName(String dongName) {
		this.dongName = dongName;
	}
	public String getSidoName() {
		return sidoName;
	}
	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}
	public String getGugunName() {
		return gugunName;
	}
	public void setGugunName(String gugunName) {
		this.gugunName = gugunName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Bookmark [dongCode=");
		builder.append(dongCode);
		builder.append(", dongName=");
		builder.append(dongName);
		builder.append(", sidoName=");
		builder.append(sidoName);
		builder.append(", gugunName=");
		builder.append(gugunName);
		builder.append("]");
		return builder.toString();
	}

}
