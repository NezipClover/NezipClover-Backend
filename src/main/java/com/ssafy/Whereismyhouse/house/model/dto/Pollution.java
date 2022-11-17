package com.ssafy.Whereismyhouse.house.model.dto;

public class Pollution {
	private int no;
	private String name;
	private int dongcode;
	private String dong;
	private int bizcode;
	private String address;
	private double lng;
	private double lat;
	
	public Pollution() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pollution(int no, String name, int dongcode, String dong, int bizcode, String address, double lng,
			double lat) {
		super();
		this.no = no;
		this.name = name;
		this.dongcode = dongcode;
		this.dong = dong;
		this.bizcode = bizcode;
		this.address = address;
		this.lng = lng;
		this.lat = lat;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDongcode() {
		return dongcode;
	}
	public void setDongcode(int dongcode) {
		this.dongcode = dongcode;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public int getBizcode() {
		return bizcode;
	}
	public void setBizcode(int bizcode) {
		this.bizcode = bizcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	@Override
	public String toString() {
		return "Pollution [no=" + no + ", name=" + name + ", dongcode=" + dongcode + ", dong=" + dong + ", bizcode="
				+ bizcode + ", address=" + address + ", lng=" + lng + ", lat=" + lat + "]";
	}
	
}
