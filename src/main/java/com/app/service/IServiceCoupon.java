package com.app.service;



import com.app.model.Coupon;

public interface IServiceCoupon {
	
	public void createCoupon(Coupon coupon);
	public Coupon findId(Integer cid);
}
