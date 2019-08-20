package com.app.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Coupon;
import com.app.service.CouponServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/coupon")
public class CouponControllar {
	
	@Autowired
	CouponServiceImpl service;
	
	@PostMapping("/create")
	public String createCoupon(@RequestBody Coupon coupon) {
		service.createCoupon(coupon);
		return "Data Save Sucessfully";
	}
	
	@GetMapping("/one/{cid}")
	public ResponseEntity<?> getOne(@PathVariable Integer cid){
		
		ResponseEntity<?> res=null;
		
		Coupon obs=service.findId(cid);
		System.out.println("############################################"+obs);
		
		if(obs!=null) {
			res=new ResponseEntity<Coupon>(obs,HttpStatus.OK);
		}
		else
		{
			res=new ResponseEntity<String>("Your id is not Exit",HttpStatus.BAD_REQUEST);
		}
		return res;		
	}

	/* @GetMapping(value = "/{cid}")
	    public ResponseEntity<Coupon> getUserById(@PathVariable("cid") Integer cid) {
	        System.out.println("Fetching User with id " + cid);
	        Coupon coupon = service.findId(cid);
	        if (coupon == null) {
	            return new ResponseEntity<Coupon>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<Coupon>(coupon, HttpStatus.OK);
	    }*/

	@GetMapping("/cc/{code}")
	public ResponseEntity<String> findByCode(@PathVariable String code){
		Coupon obs=service.findByCode(code);
		ObjectMapper om =new ObjectMapper();
				String json =null;
				try {
					json = om.writeValueAsString(obs);
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
		ResponseEntity<String>  res=new ResponseEntity<String>(json,HttpStatus.OK);
		
		
/*		System.out.println("############################################"+obs);
	//	return obs;
//		if(obs!=null) {
			return (ResponseEntity<Coupon>) (res=new ResponseEntity<Coupon>(obs,HttpStatus.OK));
//		}
/*		else
		{
			res=new ResponseEntity<String>("Your id is not Exit",HttpStatus.BAD_REQUEST);
		}*/
//		return res;		
//		return null;
		return res;
	}
}
