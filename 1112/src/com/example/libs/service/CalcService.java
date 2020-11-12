package com.example.libs.service;

import com.example.libs.model.TelephoneVO;

public class CalcService {

	public void calc(TelephoneVO telephone) {
		switch(telephone.getKind()) {
			case 1: 	telephone.setDefaultFee(6000); break;
			case 2: 	telephone.setDefaultFee(4800); break;
			case 3: 	telephone.setDefaultFee(3000); break;
		}
		int fee = telephone.getQuantity() * 12;
		int tax = (int)((telephone.getDefaultFee() + fee) * 0.1);
		int total = telephone.getDefaultFee() + fee + tax;
		telephone.setFee(fee);
		telephone.setTax(tax);
		telephone.setTotal(total);
	}

}