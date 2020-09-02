package com.selenium.conccepts;

public class AAA {

	int i;

	private int test() {
		i = 10;
		return i;
	}

	public static void main(String[] args) {
		AAA a = new AAA();
		int j = a.test();
		System.out.println(j);
	}
}
