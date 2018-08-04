package com.codechef.fibonaccistring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FibonacciString
{
	
	public static void main(String arg[])
	{
		
		Scanner scan = new Scanner(System.in);
		
		try
		{
			int num = scan.nextInt();
			scan.nextLine();
			if (num >= 1 && num <= 10)
			{
				ArrayList<String> stringList = new ArrayList<String>();
				for (int count = 1; count <= num; count++)
				{
					stringList.add(scan.nextLine());
				}
				
				scan.close();
				// String s="Hello";
				
				for (String s : stringList)
				{
					if ((s.length() <= Math.pow(10, 5)) && (hasLowerCase(s)))
					{
						
						if (s.length() < 3)
						{
							// System.out.println("Dynamic");
							continue;
						}
						
						boolean isDynamic = true;
						HashMap<Character, Integer> map = new HashMap<Character, Integer>();
						for (char c : s.toCharArray())
						{
							if (!map.containsKey(c))
							{
								map.put(c, 1);
							}
							else
							{
								int val = map.get(c).intValue();
								map.put(c, val + 1);
							}
						}
						List<Character> mapKeys = new ArrayList<Character>(map.keySet());
						List<Integer> mapValues = new ArrayList<Integer>(map.values());
						Collections.sort(mapValues);
						Collections.sort(mapKeys);
						
						Integer value[] = new Integer[mapValues.size()];
						int k = 0;
						for (int val : mapValues)
						{
							value[k] = val;
							k++;
						}
						for (int i = 2; i < value.length; i++)
						{
							if (value[i] != value[i - 1] + value[i - 2])
							{
								isDynamic = false;
								break;
							}
						}
						if (isDynamic)
							System.out.println("Dynamic");
						else
							System.out.println("Not");
							
					}
					else
						System.out.println("Not");
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			scan.close();
		}
		
	}
	
	static boolean hasLowerCase(String s)
	{
		boolean flag = true;
		for (char c : s.toCharArray())
		{
			if (!Character.isLowerCase(c))
				flag = false;
		}
		return flag;
	}
}
