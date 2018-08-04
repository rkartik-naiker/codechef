package com.codechef.zcoprac;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class SmartPhone
{
	public static void main(String agr[])
	{
		Scanner scan = new Scanner(System.in);
		try
		{
			long num;
			num = scan.nextLong();
			boolean flag = true;
			// scan.nextLine();
			
			if ((num > 0) && (num <= (5 * Math.pow(10, 5))))
			{
				long budgetList[] = new long[(int) num];
				
				for (int k = 0; k < num; k++)
				{
					budgetList[k] = scan.nextLong();
					if (!(budgetList[k] >= 1 && budgetList[k] <= Math.pow(10, 8)))
						flag = false;
				}
				if (flag)
				{
					long sumList[] = new long[(int) num];
					Arrays.sort(budgetList);
					
					for (int i = 0; i < Array.getLength(budgetList); i++)
					{
						sumList[i] = budgetList[i] * (Array.getLength(budgetList) - i);
					}
					Arrays.sort(sumList);
					System.out.println(sumList[Array.getLength(sumList) - 1]);
					
				}
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
