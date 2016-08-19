package com.demo.TreeMap;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Guangtao Zhou on 8/9/2016.
 */
public class TestTreeMap {
	public static void main(String[] args) {
		Map<Integer, String> linkageMap = new TreeMap(new Comparator<String>() {
			public int compare(String o1, String o2) {
				if (o1 == null || o2 == null){
					return 0;
				}
				return o1.compareToIgnoreCase(o2);
			}
		});

		linkageMap.put(5432, "HOUSE");
//		linkageMap.put(5433, "REG");
//		linkageMap.put(5434, "SEC");
//		linkageMap.put(5435, "SEQ");
//		linkageMap.put(5436, "SEG");
//		linkageMap.put(5437, "123");
//		linkageMap.put(5438, "22a");
//		linkageMap.put(5439, "aaa");
//		linkageMap.put(5440, "bbb");
//
//		Iterator it = linkageMap.entrySet().iterator();
//		while(it.hasNext()) {
//			Map.Entry entry = (Map.Entry) it.next();
//			System.out.println(entry.getKey() + ", " + entry.getValue());
//		}
	}
}
