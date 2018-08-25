package com.codechef.aug18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Eid
{

	public static void main(String arg[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			int testCases = Integer.parseInt(br.readLine());
			int num[] = new int[testCases];
			int ar[][] = new int[testCases][];
			int minDiff[] = new int[testCases];

			for (int i = 0; i < testCases; i++)
			{
				num[i] = Integer.parseInt(br.readLine());
				ar[i] = new int[num[i]];
				String s[] = br.readLine().split(" ");

				for (int j = 0; j < s.length; j++)
				{
					ar[i][j] = Integer.parseInt(s[j]);
				}
				Arrays.parallelSort(ar[i]);
				minDiff[i] = ar[i][1] - ar[i][0];

				for (int k = 1; k < ar[i].length - 1; k++)
				{
					if (minDiff[i] > ar[i][k + 1] - ar[i][k])
						minDiff[i] = ar[i][k + 1] - ar[i][k];
				}

			}
			for (int i = 0; i < testCases; i++)
			{
				System.out.println(minDiff[i]);
			}
		} 
		finally
		{
			br.close();

		}
	}

}
