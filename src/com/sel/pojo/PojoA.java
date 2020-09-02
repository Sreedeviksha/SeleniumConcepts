package com.sel.pojo;

import com.selenium.conccepts.Pojo;

public class PojoA {
	
	public static void main(String[] args) {
		Pojo p = new Pojo();
		
		p.setJ(100);
		
		int j = p.getJ();
		System.out.println(j);
		
		System.out.println(Pojo.k);
	
	}
}
