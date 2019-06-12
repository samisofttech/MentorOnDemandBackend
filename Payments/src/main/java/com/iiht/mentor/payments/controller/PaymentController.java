/**
 * 
 */
package com.iiht.mentor.payments.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.mentor.payments.repositorydao.PaymentRepositoryDao;

@RestController
@RequestMapping("v1/payment")
public class PaymentController {
	
	@Autowired
	PaymentRepositoryDao paymentRepositoryDao;
	
	@GetMapping("/confirmUser")
	public List<PaymentRepositoryDao> makePayment(){
		
		return null; //TODO
	}

}
