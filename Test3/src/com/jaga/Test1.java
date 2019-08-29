package com.jaga;

import java.util.*;

public class Test1 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("jaga");
		list.add("prasad");
		list.add("teeka");
		
		StringBuffer buf = new StringBuffer();
		
		for(int i=0;i<list.size()-1;i++){
			buf.append(list.get(i)+"@#,");
		}
		
		/*
		list.forEach(a->buf.append(a+"@#,"));*/
		
		//buf.s
		buf.append(list.get(list.size()-1));
		
		//buf.
		System.out.println(buf);
	}
}
