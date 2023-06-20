package javaprograms;

import java.util.HashMap;
import java.util.Set;

public class MapExample {

	
	public static void main(String[] args) {
		
		HashMap<Integer,String> studentMap = new HashMap<Integer,String>();
		studentMap.put(1, "James");
		studentMap.put(2, "James");
		studentMap.put(3, "John");
		studentMap.put(3, "Steve");
		System.out.println(studentMap.size());
		
		String name = studentMap.get(1);
		System.out.println(name);
		
		Set<Integer> keys = studentMap.keySet();
		
		for(Integer key : keys)
		{
			name = studentMap.get(key);
			System.out.println("Key:" + key + "-----------" + "value:" + name);
		}
		
		HashMap<Integer,String> studentMap1 = new HashMap<Integer,String>();
		studentMap1.put(1, "James");
		studentMap1.put(2, "James");
		studentMap1.put(3, "John");
		studentMap1.put(3, "Steve");
		System.out.println(studentMap.size());
		
		System.out.println("Two maps are equal?? " + studentMap.equals(studentMap1));
	}
}
