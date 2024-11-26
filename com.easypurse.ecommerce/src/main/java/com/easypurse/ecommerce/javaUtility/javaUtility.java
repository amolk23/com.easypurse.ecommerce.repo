package com.easypurse.ecommerce.javaUtility;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class javaUtility {
	
	public int getRandomNumber() {
		Random random = new Random();
		int randomCount = random.nextInt(1000);
		return randomCount;
	}
	
	public String getCurrentSystem() {
		Date dateObj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String actDate = sdf.format(dateObj);
		return actDate;
	}

}
