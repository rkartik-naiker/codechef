package com.codechef.may18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;

public class MinimumDeletions
{
	public static void main(String arg[])
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, Integer> degree = new HashMap<Integer, Integer>();
		try
		{
			int testCases = Integer.parseInt(br.readLine());
			int num[] = new int[testCases];
			int aSeq[][] = new int[testCases][];
			int result[] = new int[testCases];
			for (int i = 0; i < testCases; i++)
			{
				boolean isMinimum;
				num[i] = Integer.parseInt(br.readLine());
				aSeq[i] = new int[num[i]];
				String s[] = br.readLine().split(" ");
				for (int j = 0; j < num[i]; j++)
				{
					aSeq[i][j] = Integer.parseInt(s[j]);
					degree.put(aSeq[i][j], 0);
				}
				result[i] = 0;
				int count = 1;
				isMinimum = makeGraph(num[i], aSeq[i], degree);
				
				if (!isMinimum)
				{
					while ((!isMinimum) && count < num[i]-1)
					{
						int maxElement = aSeq[i][0];
						int loc = 0;
						int maxDegree = degree.get(maxElement);
						for (Entry<Integer, Integer> e : degree.entrySet())
						{
							if (maxDegree < e.getValue())
							{
								maxDegree = e.getValue();
								maxElement = e.getKey();
							}
						}
						
						degree.clear();
						
						for (int j = 0; j < aSeq[i].length; j++)
						{
							if (maxElement == aSeq[i][j])
							{
								loc = j;
								break;
							}
							else
							{
								degree.put(aSeq[i][j], 0);
							}
						}
						for (int j = loc; j < aSeq[i].length - count; j++)
						{
							aSeq[i][j] = aSeq[i][j + 1];
							degree.put(aSeq[i][j], 0);
						}
						
						isMinimum = makeGraph(aSeq[i].length - count, aSeq[i], degree);
						count++;
						
					}
					if ((!isMinimum))
						result[i] = -1;
					else if (isMinimum)
						result[i] = count - 1;
				}
			}
			for (int i = 0; i < testCases; i++)
			{
				System.out.println(result[i]);
			}
			br.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	static int gcd(int div1, int div2)
	{
		while (div1 % div2 != 0)
		{
			int temp = div1 % div2;
			div1 = div2;
			div2 = temp;
		}
		if (div2 != 1)
			return 1;
		else
			return 0;
	}
	
	static boolean makeGraph(int num, int aSeq[], HashMap<Integer, Integer> degree)
	{
		boolean isMinimum = true;
		for (int p = 0; p < num; p++)
		{
			for (int q = 0; q <= p; q++)
			{
				if (p != q)
				{
					int x = gcd(aSeq[p], aSeq[q]);
					if (x == 1)
					{
						isMinimum = false;
						degree.put(aSeq[p], degree.get(aSeq[p]) + 1);
						degree.put(aSeq[q], degree.get(aSeq[q]) + 1);
					}
					
				}
				
			}
		}
		return isMinimum;
	}
}
