package com.codechef.may18;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DibsTest
{

	
	public static void main(String arg[])
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			int testCases = Integer.parseInt(br.readLine());
			int m[] = new int[testCases];
			int n[] = new int[testCases];
			double a[][] = new double[testCases][];
			double b[][] = new double[testCases][];
			long result[] = new long[testCases];
			double sum[][] = new double[testCases][];
			double modulo = (double) (Math.pow(10, 9) + 7);
			for (int i = 0; i < testCases; i++)
			{
				result[i] = 0;
				String s[] = br.readLine().split(" ");
				m[i] = Integer.parseInt(s[0]);
				n[i] = Integer.parseInt(s[1]);
				String a_Seq[] = br.readLine().split(" ");
				String b_Seq[] = br.readLine().split(" ");
				
				a[i] = new double[m[i]];
				b[i] = new double[m[i]];
				
				for (int k = 0; k < a_Seq.length; k++)
				{
					a[i][k] = Double.parseDouble(a_Seq[k]);
					b[i][k] = Double.parseDouble(b_Seq[k]);
				}
				sum[i] = new double[n[i]];
				sum[i][0] = sum[i][1] = 0;
				for (int p = 0; p < m[i]; p++)
				{
					sum[i][1] += (m[i] * (b[i][p]));// % modulo);
				}
				
				for (int p = 0; p < m[i]; p++)
				{
					sum[i][0] += (m[i] * (a[i][p]));// % modulo);
				}
				
				if (n[i] > 2)
				{
					sum[i][2] = (sum[i][0] + sum[i][1]);// % modulo;
					
					for (int p = 3; p < n[i]; p++)
					{
						sum[i][p] = (sum[i][p - 1] + sum[i][p - 2]);// % modulo;
						// result[i] += (m[i] * (a[i][p] + b[i][p]) % modulo);
					}
				}
				result[i] = (long)(sum[i][n[i] - 1] % modulo);
				
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
