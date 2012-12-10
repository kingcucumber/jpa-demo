package com.demo.jpa;

@HelloWorld(name = "helloworldclass")
public class TestBean {
	
	public TestBean(String name){
		this.name = name;
	}

	@HelloWorld("hello")
	private String name;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}

}
