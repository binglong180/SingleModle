package com.niu.single;

import java.io.InputStream;
import java.util.Properties;

public class Factory {
	// 2、私有化对象
	private static Factory factory;
	// 初始化对象
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
	public static class SingleTon{
		private static final Factory FACTORY= new Factory();
	}
	// 3、提供一个公有的访问接口
	// 懒汉模式synchronized使用synchronized实现
	public static  Factory getFactory() {
		factory=SingleTon.FACTORY;
		return factory;
	}
	public static Factory test(){
		return factory;
		
	}
	public String getValue(String key) {
		return properties.getProperty(key);

	}
}
