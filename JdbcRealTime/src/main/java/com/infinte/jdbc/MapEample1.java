package com.infinte.jdbc;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class MapEample1 {
	public static void main(String[] args) {
		Map<Integer,String> data = new Hashtable<Integer,String>();
		data.put(1,"pavani");
		data.put(2,"Ravi");
		data.put(3,"harshit");
		data.put(4,"manju");
		data.put(5,"rahul");
		data.put(6,"salma");
		int key;
		String result;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter key(empno)");
		key = sc.nextInt();
		result = data.getOrDefault(key, "Not found");
		System.out.println(result);
		
	}

}
