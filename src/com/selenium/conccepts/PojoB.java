package com.selenium.conccepts;

public class PojoB {
	
	
	public static void main(String[] args) {
		Pojo p = new Pojo();
		p.setJ(200);
		int j = p.getJ();
		System.out.println(j);
		
		System.out.println(Pojo.k);
	}

}
