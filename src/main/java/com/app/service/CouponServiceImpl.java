package com.app.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Coupon;
import com.app.repo.CouponRepository;
@Service
@Transactional
public class CouponServiceImpl implements IServiceCoupon {
    @Autowired
    CouponRepository couponRepository;

   
//	@Transactional
	public void createCoupon(Coupon coupon) {
		// TODO Auto-generated method stub
		 couponRepository.save(coupon);
	}


//	@Transactional
	public Coupon findId(Integer cid) {
		// TODO Auto-generated method stub
		  Optional<Coupon> c= couponRepository.findById(cid);
		  Coupon cc=c.get();
		  return cc;
	}

	public Coupon findByCode(String code) {
		
		Optional<Coupon> cc= couponRepository.findByCode(code);
		if(cc.isPresent()) {
			return cc.get();
		}
		
		 
		
		return null;
		
	}
	
}