package com.codechef.june18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Probability
{
	
	public static void main(String arg[])
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			int testCases = Integer.parseInt(br.readLine());
			int n[] = new int[testCases];
			int a[] = new int[testCases];
			int b[] = new int[testCases];
			double prob[] = new double[testCases];
			int elements[][] = new int[testCases][];
			
			for (int i = 0; i < testCases; i++)
			{
				String s[] = br.readLine().split(" ");
				n[i] = Integer.parseInt(s[0]);
				a[i] = Integer.parseInt(s[1]);
				b[i] = Integer.parseInt(s[2]);
				elements[i] = new int[n[i]];
				String s2[] = br.readLine().split(" ");
				
				HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
				
				for (int j = 0; j < s2.length; j++)
				{
					elements[i][j] = Integer.parseInt(s2[j]);
					if (map.get(elements[i][j]) == null)
						map.put(elements[i][j], 1);
					else
						map.put(elements[i][j], map.get(elements[i][j]) + 1);
				}
				
				prob[i] = ((double) map.get(a[i]) / n[i]) * ((double) map.get(b[i]) / n[i]);
				
			}
			for (int i = 0; i < testCases; i++)
			{
				System.out.printf("\n%.10f",prob[i]);
			}
			br.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
