package com.codechef.locapril;

import java.util.ArrayList;
import java.util.Scanner;

public class CricketScore
{
	
	public static void main(String arg[])
	{
		Scanner scan = new Scanner(System.in);
		boolean isValidScore = true;
		boolean numConstraint = true;
		boolean runConstraint = true;
		boolean wktConstraint = true;
		
		try
		{
			int num = scan.nextInt();
			
			if ((num > Math.pow(10, 4)) || (num < 1))
			{
				numConstraint = false;
				
			}
			
			// int runs[] = new int[num];
			// int wickets[] = new int[num];
			
			ArrayList<Integer> runs = new ArrayList<Integer>();
			ArrayList<Integer> wickets = new ArrayList<Integer>();
			
			if (numConstraint)
			{
				for (int i = 0; i < num; i++)
				{
					scan.nextLine();
					/*
					 * runs[i] = scan.nextInt(); wickets[i] = scan.nextInt();
					 */
					
					runs.add(i, scan.nextInt());
					wickets.add(i, scan.nextInt());
					
					if ((runs.get(i) > Math.pow(10, 7)) || (runs.get(i) < 0))
					{
						runConstraint = false;
						break;
					}
					
					if ((wickets.get(i) > 10) || (wickets.get(i) < 0))
					{
						wktConstraint = false;
						break;
					}
					if (wickets.get(i) == 10)
					{
						if (num != i + 1)
							numConstraint = false;
						break;
					}
					
				}
				if (runConstraint && wktConstraint)
				{
					for (int i = 0; i < runs.size(); i++)
					{
						if (isValidScore)
						{
							for (int j = i + 1; j < runs.size(); j++)
							{
								if ((runs.get(j) < runs.get(i)) || ((wickets.get(j) < wickets.get(i))))
								{
									isValidScore = false;
									break;
								}
							}
						}
					}
					if (isValidScore && numConstraint && runConstraint && wktConstraint)
						System.out.println("YES");
					else
						System.out.println("NO");
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
