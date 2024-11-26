package com.easypurse.ecommerce.fileUtility;

import java.io.FileInputStream;

import java.util.Properties;

public class FileUtility {
	
	public String getDataFromPropertyFile(String key) throws Exception {
		FileInputStream fis = new FileInputStream("./src/test/resources/configData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String data = prop.getProperty(key);
		System.out.println("data:"+data);
		return data;
		
	}

}