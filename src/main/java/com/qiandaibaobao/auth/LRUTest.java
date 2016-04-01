package com.qiandaibaobao.auth;

import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LRUTest<K, V> extends LinkedHashMap<K, V> {
	private final int MAX_CACHE_SIZE;

	public LRUTest(int cacheSize) {
		super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, false);
		MAX_CACHE_SIZE = cacheSize;
	}
	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
		return size() > MAX_CACHE_SIZE;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<K, V> entry:entrySet()){
			sb.append(String.format("%s:%s", entry.getKey(), entry.getValue()));
			sb.append("\r");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
//		LRUTest map = new LRUTest(20);
//		
		final int cacheSize = 3;
		Map<String, String> map = new LinkedHashMap<String, String>((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, false){
			protected boolean removeEldestEntry(Map.Entry<String,String> eldest) {
				return size() > cacheSize;
			};
			@Override
			public String toString() {
				StringBuilder sb = new StringBuilder();
				for(Map.Entry entry:entrySet()){
					sb.append(String.format("%s:%s", entry.getKey(), entry.getValue()));
					sb.append("\r");
				}
				return sb.toString();
			}
		};
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");
		String a = map.get("3");
		System.out.println(map);
		Hashtable ht = new Hashtable();
		ConcurrentHashMap map2 = new ConcurrentHashMap();
				
	}
	

}
