package com.niu.single;

import org.junit.Test;

public class MyTest {
	@Test
	public void test() {
		Factory factory = Factory.getFactory();
		String user = factory.getValue("password");
		System.out.println(user);
	}
}
