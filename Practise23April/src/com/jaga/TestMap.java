package com.jaga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TestMap {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<>();
		map.put("jaga", "prasad");
		map.put("jaga1", "prasad3");
		map.put("jaga2", "king");
		map.put("jaga3", "prasad1");
		
		for(Map.Entry<String, String> test: map.entrySet()){
			System.out.println(test.getKey()+"  "+test.getValue());
		}
		
		List<Map.Entry<String, String>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list,new Comparator<Map.Entry<String, String>>() {

			@Override
			public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});
		
		Map<String,String> lm = new LinkedHashMap<>();
		
		for(Map.Entry<String, String> k1: list) {
			System.out.println(k1.getValue());
			lm.put(k1.getKey(), k1.getValue());
		}
		
		
		System.out.println("=========");
		for(Map.Entry<String, String> test: lm.entrySet()){
			System.out.println(test.getKey()+"  "+test.getValue());
		}
	}
}
