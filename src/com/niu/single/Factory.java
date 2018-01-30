package com.niu.single;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;


public class Factory {
	// 2、私有化对象
	private static Factory factory;
	private Properties properties;

	// 1、私有化构造
	private Factory() {
		String configFile = "database.properties";
		properties = new Properties();
		InputStream is = null;
		try {
			is = Factory.class.getClassLoader().getResourceAsStream(configFile);
			properties.load(is);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 3、提供一个公有的访问接口
	public static Factory getFactory() {
		if (factory == null) {
			factory = new Factory();
		}
		return factory;
	}

	public String getValue(String key) {
		return properties.getProperty(key);

	}
}
