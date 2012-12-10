package com.demo.jpa;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Parser {
	public void parse(Object obj, String methodName) {
		Method[] ms = obj.getClass().getMethods();
		for (Method m : ms) {
			if (m.isAnnotationPresent(HelloWorld.class)) {
				HelloWorld hw = m.getAnnotation(HelloWorld.class);
				System.out.println(hw.value());
				try {
					System.out.println(hw.value()+"before....");
					m.invoke(obj, null);
					System.out.println(hw.value()+"after.....");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
