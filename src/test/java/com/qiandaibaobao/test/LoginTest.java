package com.qiandaibaobao.test;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class LoginTest{
	
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>()		;
		map.put("1", "23")								;
		JsonObject obj = new JsonObject()				;
		obj.addProperty("12", "13")						;
		System.out.println(obj.toString())				;
		JsonArray a = new JsonArray()					;
		a.add(obj)										;
		for(JsonElement e: a){
			System.out.println(e)						;
		}
		
	}

}
