package com.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Coupon {
	@Id
	public Integer cid;
	private String code;
	
	private double discAmt;
	private String expDate;
	public Coupon() {
		super();
	}
	
	public Coupon(Integer cid, String code, double discAmt, String expDate) {
		super();
		this.cid = cid;
		this.code = code;
		this.discAmt = discAmt;
		this.expDate = expDate;
	}
	

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getDiscAmt() {
		return discAmt;
	}

	public void setDiscAmt(double discAmt) {
		this.discAmt = discAmt;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	@Override
	public String toString() {
		return "Coupon [cid=" + cid + ", code=" + code + ", discAmt=" + discAmt + ", expDate=" + expDate + "]";
	}
	
	

}
