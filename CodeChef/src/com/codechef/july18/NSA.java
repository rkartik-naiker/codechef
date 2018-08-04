package com.codechef.july18;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NSA
{

	public static void main(String arg[])
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			int testCases = Integer.parseInt(br.readLine());
			String s[] = new String[testCases];
			int count[] = new int[testCases];
			for (int i = 0; i < testCases; i++)
			{
				count[i]=0;
				s[i] = br.readLine();
				char c[] = s[i].toCharArray();
				for(int j =0;j<c.length;j++)
				{
					for(int k = j+1;k<c.length;k++)
					{
						if(c[j]-c[k]<0)
							count[i]++;
					}
				}
				
			}
			for (int i = 0; i < testCases; i++)
			{
				System.out.println(count[i]);
			}
			br.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
