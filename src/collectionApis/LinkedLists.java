package collectionApis;

import java.util.*;

public class LinkedLists {

	public static void main(String[] args) {
		
		List<String> list = new LinkedList<>();
		
		
		list.add("Amar");
		list.add("Amar2");
		list.add("Amar3");
		list.add("Amar4");
		
		list.add(0, "jeet");
		
		list.addFirst("Amar");
		
		System.out.println(list);
	}

}
