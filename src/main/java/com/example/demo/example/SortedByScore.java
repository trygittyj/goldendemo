package com.example.demo.example;

import java.util.Comparator;

public class SortedByScore<Object>  implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		
		Student s1=(Student)o1;
		Student s2=(Student)o2;
		if(s1.getScore()>s2.getScore()) {
			return 0;		
		}else {
				return 1;
		}
	}

}
