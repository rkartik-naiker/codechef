package com.codechef.may18;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class XorAgain
{
	public static void main(String arg[])
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			int testCases = Integer.parseInt(br.readLine());
			int num[] = new int[testCases];
			long xor[] = new long[testCases];
			for (int i = 0; i < testCases; i++)
			{
				num[i] = Integer.parseInt(br.readLine());
				String s[] = br.readLine().split(" ");
				xor[i] = 0;
				for (int j = 0; j < num[i]; j++)
				{
					int x = Integer.parseInt(s[j]);
					xor[i] ^= (x+x);
				}
			}
			for (int i = 0; i < testCases; i++)
			{
				System.out.println(xor[i]);
			}
			br.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
