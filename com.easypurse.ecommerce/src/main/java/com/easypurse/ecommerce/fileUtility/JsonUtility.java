package com.easypurse.ecommerce.fileUtility;


import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility {
	
	public String getDataFromJson(String key) throws Exception {
		FileReader Rfile = new FileReader("");
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(Rfile);
		JSONObject map = (JSONObject)obj;
		String data = map.get(key).toString();
		return data;
		
		
	}

}
