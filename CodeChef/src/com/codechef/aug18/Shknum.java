package com.codechef.aug18;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Shknum
{
	static int log(long x, int base)
	{
		return (int) Math.ceil((Math.log(x) / Math.log(base)));
	}

	public static void main(String arg[])
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			int testCases = Integer.parseInt(br.readLine());
			long num[] = new long[testCases];
			long result[] = new long[testCases];
			// long number[] = new long[testCases];

			for (int i = 0; i < testCases; i++)
			{
				num[i] = Integer.parseInt(br.readLine());
				int x;// , count = 0;
				long cal;// ,numbr=0;
				boolean flag = false;
				x = log(num[i], 2);
				long diff, min = 0;// [] = new long[x * x - x];
				for (int j = x; j >= 1; j--)
				{
					for (int k = j - 1; k >= 0 && k != j; k--)
					{
						cal = (long) (Math.pow(2, j) + Math.pow(2, k));

						if (j == x && k == j-1)
						{
							min = Math.abs(cal - num[i]);
							// numbr = cal;
						} 
						
						else
						{
							diff = Math.abs(cal - num[i]);
							if (diff < min)
							{
								min = diff;
								// numbr = cal;
							}
							else if ((diff > min))// && cal>num[i])||(diff > min && cal>num[i]))
							 {
								if(j!=x)
									flag=true;
								break;
							 }
						}
					}
					if(flag)
						break;
				}
				result[i] = min;
				// number[i]=numbr;
			}
			for (int i = 0; i < testCases; i++)
			{
				System.out.println(result[i]);
				// System.out.println(number[i]);
			}
			br.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
