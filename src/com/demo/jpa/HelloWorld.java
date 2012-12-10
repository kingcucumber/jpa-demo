package com.demo.jpa;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface HelloWorld {
	public String name() default "hello";
	public String value() default "hello";
	
}
