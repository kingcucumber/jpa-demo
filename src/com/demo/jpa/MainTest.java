package com.demo.jpa;

public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestBean tb = new TestBean("abcde");
	//	System.out.println(tb);
		
		Parser p = new Parser();
		p.parse(tb, "toString");
		
	}
}
