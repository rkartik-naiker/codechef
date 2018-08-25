package com.codechef.aug18;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Probset
{


	public static void main(String arg[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			int testCases = Integer.parseInt(br.readLine());
			int n[] = new int[testCases];
			int m[] = new int[testCases];
			String result[] = new String[testCases];
			for (int i = 0; i < testCases; i++)
			{
				result[i] = "FINE";
				boolean invalid = false, weak = false;
				String s[] = (br.readLine().split(" "));
				n[i] = Integer.parseInt(s[0]);
				m[i] = Integer.parseInt(s[1]);
				
				String str[] = new String[n[i]];
				
				for(int j = 0; j<n[i]; j++)
				{
					str[j] = br.readLine();
				}
				for(int j = 0; j<n[i]; j++)
				{
					if(str[j].contains("correct") && str[j].contains("0"))
						invalid = true;
					if(str[j].contains("wrong") && !str[j].contains("0"))
						weak = true;
				}
				if(invalid)
					result[i] = "INVALID";
				else if(weak)
					result[i] = "WEAK";
			}
			for (int i = 0; i < testCases; i++)
			{
				System.out.println(result[i]);
			}
		} 
		finally
		{
			br.close();

		}
	}


}
