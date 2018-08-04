package com.codechef.july18;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Pins
{
	public static void main(String arg[])
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			int testCases = Integer.parseInt(br.readLine());
			int num[] = new int[testCases];
			long p[] = new long[testCases];
			int x[] = new int[testCases];
			int s[][] = new int[testCases][];
			for (int i = 0; i < testCases; i++)
			{
				num[i] = Integer.parseInt(br.readLine());
				p[i] = 1;
				if (num[i] % 2 == 0)
					x[i] = (num[i] - num[i] / 2);
				else
					x[i] = (num[i]) - ((num[i] / 2) + 1);
				s[i]=new int[x[i]];
				
				for(int j = 0; j<x[i];j++)
					s[i][j]=0;
			}
			for (int i = 0; i < testCases; i++)
			{
				System.out.print(p[i] + " 1");
				for(int j = 0; j<x[i];j++)
					System.out.print(s[i][j]);
				System.out.print("\n");
			}
			br.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
