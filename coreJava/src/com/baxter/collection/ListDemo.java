package com.baxter.collection;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		
		list.add("Sourav");
		list.add("Saikat");
		list.add("Saonli");
		
		for(String lt:list)
		{
			System.out.println(lt);
		}

	}

}
