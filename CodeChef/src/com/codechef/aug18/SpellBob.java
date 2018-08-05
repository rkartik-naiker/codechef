package com.codechef.aug18;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SpellBob 
{

	public static void main(String arg[])
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			int testCases = Integer.parseInt(br.readLine());
			String s1[] = new String[testCases];
			String s2[] = new String[testCases];
			String result[] = new String[testCases];

			for (int i = 0; i < testCases; i++)
			{
				s1[i] = br.readLine();
				s2[i] = br.readLine();
				
				char c1[] = s1[i].toCharArray();
				char c2[] = s2[i].toCharArray();
				
				int b=0, c=0, com = 0;
				
				result[i]="no";
				
				for(int j = 0; j<=2; j++)
				{
					if((c1[j]=='b'&&c2[j]=='o')||(c2[j]=='b'&&c1[j]=='o'))
						com++;
					else if(c1[j]=='b' || c2[j]=='b')
						b++;
					else if(c1[j]=='o' || c2[j]=='o')
						c++;
				}
				if((com==3)||((com==2)&&(b==1 || c==1))||((com==1)&&((b==1 && c==1)||(b==2 && c==0)))||((com==0)&&(b==2 && c==1)))
					result[i]="yes";
				
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
