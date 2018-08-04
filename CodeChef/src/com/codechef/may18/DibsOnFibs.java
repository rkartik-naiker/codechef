package com.codechef.may18;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DibsOnFibs
{
	
	public static void main(String arg[])
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			int testCases = Integer.parseInt(br.readLine());
			int m[] = new int[testCases];
			int n[] = new int[testCases];
			long a[][] = new long[testCases][];
			long b[][] = new long[testCases][];
			long result[] = new long[testCases];
			long sum[][] = new long[testCases][];
			long modulo = (long) (Math.pow(10, 9) + 7);
			for (int i = 0; i < testCases; i++)
			{
				result[i] = 0;
				String s[] = br.readLine().split(" ");
				m[i] = Integer.parseInt(s[0]);
				n[i] = Integer.parseInt(s[1]);
				String a_Seq[] = br.readLine().split(" ");
				String b_Seq[] = br.readLine().split(" ");
				
				a[i] = new long[m[i]];
				b[i] = new long[m[i]];
				
				for (int k = 0; k < a_Seq.length; k++)
				{
					a[i][k] = Long.parseLong(a_Seq[k]);
					b[i][k] = Long.parseLong(b_Seq[k]);
				}
				sum[i] = new long[n[i]];
				sum[i][0] = 0;
				
				if (n[i] == 1)
				{
					for (int p = 0; p < m[i]; p++)
					{
						sum[i][0] = ((sum[i][0] % modulo) + ((m[i] % modulo) * (a[i][p] % modulo) % modulo)) % modulo;
					}
				}
				else
				{
					sum[i][1] = 0;
					for (int p = 0; p < m[i]; p++)
					{
						sum[i][0] = ((sum[i][0] % modulo) + ((m[i] % modulo) * (a[i][p] % modulo) % modulo)) % modulo;
						sum[i][1] = ((sum[i][1] % modulo) + ((m[i] % modulo) * (b[i][p] % modulo) % modulo)) % modulo;
					}
				}
				
				for (int p = 2; p < n[i]; p++)
				{
					sum[i][p] = ((sum[i][p - 1] % modulo) + (sum[i][p - 2] % modulo)) % modulo;
					// result[i] += (m[i] * (a[i][p] + b[i][p]) % modulo);
				}
				result[i] = sum[i][n[i] - 1] % modulo;
				
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
	
}
