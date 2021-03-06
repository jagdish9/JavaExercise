package com.java.dynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class HashTag01 {

	private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {

        // 1. Convert Map to List of Map
        List<Map.Entry<String, Integer>> list =
                new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

        // 2. Sort list with Collections.sort(), provide a custom Comparator
        //    Try switch the o1 o2 position for a different order
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        
     // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        Map<String, Integer> sortedMap = new TreeMap<String, Integer>(String.CASE_INSENSITIVE_ORDER);
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
	}      
	
	private static int frequencyy(List<String> c, String o)
	{
		int freq = 0;
	    for(String e : c) 
	    {
	        if(o == null ? e == null : o.equalsIgnoreCase(e)) 
	        {
	            ++freq;
	        }
	    }
	    return freq;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int M = scan.nextInt();
		int N = scan.nextInt();
		scan.nextLine();
		List<String> ls = new ArrayList<String>();
		String[] str = new String[M];
		for(int i = 0; i < M; i++)
		{
			str[i] = scan.nextLine();
		}
		int len = 0;
		for(int i = 0; i < M; i++)
		{
			String[] spl = str[i].split(" ");
			len = spl.length;
			for(int j = 0; j < len; j++)
			{
				if(spl[j].startsWith("#"))
				{
					ls.add(spl[j]);
				}
			}
		}
		
		Map<String, Integer> map_01 = new HashMap<String, Integer>();
		int value = 0;
		for(String str_01 : ls)
		{ 
			value = frequencyy(ls, str_01);
			map_01.put(str_01, value);
		}
		
	/*	for (Map.Entry<String, Integer> entry : map_01.entrySet())
		{
			System.out.println("Key : " + entry.getKey() + " Value : "
				+ entry.getValue());
		} */
		
		Map<String, Integer> map_02 = sortByValue(map_01);
		Set set_05 = map_02.entrySet();
	    Iterator it_03 = set_05.iterator();
	    int data = 0;
	    Set<String> tset_01 = new HashSet<String>();
	    while(it_03.hasNext())
	    {
	    	Map.Entry<String, Integer> men_02 = (Map.Entry<String, Integer>)it_03.next();
	    	tset_01.add(men_02.getKey());
	    }
	    
	   // System.out.println("Only N values");
	    Iterator it_04 = tset_01.iterator();
	    while(data < N && it_04.hasNext())
	    {
	    	System.out.println(it_04.next());
	    	data++;
	    }
	/*    System.out.println("After Sorting by value");
		for (Map.Entry<String, Integer> entry_01 : map_02.entrySet())
		{
			System.out.println("Key : " + entry_01.getKey() + " Value : "
				+ entry_01.getValue());
		} */
		
     scan.close();
	}
	
}
