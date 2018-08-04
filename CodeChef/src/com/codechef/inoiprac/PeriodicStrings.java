package com.codechef.inoiprac;

import java.util.Scanner;

public class PeriodicStrings
{
	public static void main(String agr[])
	{
		Scanner scan = new Scanner(System.in);
		try
		{
			long n, m;
			long nonPeriodicStrings;
			long totalString;
			long mod;
			int greatestFactor = 1;
			
			n = scan.nextInt();
			m = scan.nextInt();
			
			if ((n > 0) && (n <= 150000) && (m > 1) && (m <= Math.pow(10, 8)))
			{
				totalString = (long)Math.pow(2, n);
				System.out.println(totalString);
				for (int i = 1; i <= (n / 2); i++)
				{
					if (n % i == 0)
						greatestFactor = i;
				}
				
				nonPeriodicStrings = (long)(totalString - Math.pow(2, greatestFactor));
				mod =  nonPeriodicStrings % m;
				System.out.println(nonPeriodicStrings);
				System.out.println(mod);
				
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			scan.close();
		}
	}
}
