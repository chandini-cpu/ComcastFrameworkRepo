package com.comcast.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtilityFile {
	public String getDataFromJsonFile(String key) throws IOException, ParseException {
		FileReader fr=new FileReader("./configAppData/JSon_testdata.json");
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(fr);
		JSONObject map=(JSONObject)obj;//downcasting
		String data=(String)map.get(key);  //we need to downcast the object into String because get() returns the object
		return data;
	
	}

}
