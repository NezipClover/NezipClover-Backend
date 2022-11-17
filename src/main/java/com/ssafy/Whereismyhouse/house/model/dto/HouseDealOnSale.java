package com.ssafy.Whereismyhouse.house.model.dto;

public class HouseDealOnSale {
	private int no;
	private int aptCode;
	private String area;
	private String floor;
	private String type;
	private String dealAmount;
	private String rentMoney;
	private String updatedAt;
	private String dealer_email;
	

	
	
	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getAptCode() {
		return aptCode;
	}

	public void setAptCode(int aptCode) {
		this.aptCode = aptCode;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}

	public String getRentMoney() {
		return rentMoney;
	}

	public void setRentMoney(String rentMoney) {
		this.rentMoney = rentMoney;
	}

	public String getDealer_email() {
		return dealer_email;
	}

	public void setDealer_email(String dealer_email) {
		this.dealer_email = dealer_email;
	}

	@Override
	public String toString() {
		return "HouseDealOnSale [no=" + no + ", aptCode=" + aptCode + ", area=" + area + ", floor=" + floor + ", type="
				+ type + ", dealAmount=" + dealAmount + ", rentMoney=" + rentMoney + ", updatedAt=" + updatedAt
				+ ", dealer_email=" + dealer_email + "]";
	}

	

	

}
