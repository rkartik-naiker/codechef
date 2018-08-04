package com.codechef.may18;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MightyFriend
{
	
	public static void main(String arg[])
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			int testCases = Integer.parseInt(br.readLine());
			int num[] = new int[testCases];
			int swap[] = new int[testCases];
			int motuScore[] = new int[testCases];
			int tomuScore[] = new int[testCases];
			int aSequence[][] = new int[testCases][];
			boolean tomuWins[] = new boolean[testCases];
			String tomu[] = new String[testCases];
			int motuChances[][] = new int[testCases][];
			int tomuChances[][] = new int[testCases][];
			for (int i = 0; i < testCases; i++)
			{
				motuScore[i] = 0;
				tomuScore[i] = 0;
				String s[] = br.readLine().split(" ");
				num[i] = Integer.parseInt(s[0]);
				swap[i] = Integer.parseInt(s[1]);
				String numSeq[] = br.readLine().split(" ");
				
				if (num[i] % 2 == 0)
				{
					motuChances[i] = new int[num[i] / 2];
					tomuChances[i] = new int[num[i] / 2];
				}
				else
				{
					motuChances[i] = new int[(num[i] / 2) + 1];
					tomuChances[i] = new int[num[i] / 2];
				}
				
				aSequence[i] = new int[numSeq.length];
				for (int j = 0, k = 0, r = 0; j < num[i]; j++)
				{
					aSequence[i][j] = Integer.parseInt(numSeq[j]);
					if (j % 2 == 0)
						motuChances[i][k++] = aSequence[i][j];
					else
						tomuChances[i][r++] = aSequence[i][j];
						
				}
				
				int t, m;
				while (swap[i] > 0)
				{
					tomuWins[i] = checkScore(motuChances[i], tomuChances[i]);
					if (!tomuWins[i])
					{
						t = getMaxMin(tomuChances[i], 0);
						m = getMaxMin(motuChances[i], 1);
						int temp = tomuChances[i][t];
						tomuChances[i][t] = motuChances[i][m];
						motuChances[i][m] = temp;
						swap[i]--;
					}
					else
						break;
				}
				tomuWins[i] = checkScore(motuChances[i], tomuChances[i]);
				if (tomuWins[i])
					tomu[i] = "YES";
				else
					tomu[i] = "NO";
			}
			for (int i = 0; i < testCases; i++)
			{
				System.out.println(tomu[i]);
			}
			br.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static boolean checkScore(int motuChances[], int tomuChances[])
	{
		int motuScore = 0;
		int tomuScore = 0;
		for (int k = 0; k < motuChances.length; k++)
			motuScore += motuChances[k];
		for (int k = 0; k < tomuChances.length; k++)
			tomuScore += tomuChances[k];
		// System.out.println("TomuScore = "+tomuScore+" MotuScore =
		// "+motuScore);
		if (tomuScore > motuScore)
			return true;
		else
			return false;
	}
	
	static int getMaxMin(int chances[], int x)
	{
		int element = chances[0];
		int index = 0;
		
		if (x == 0)
		{
			for (int i = 1; i < chances.length; i++)
			{
				if (chances[i] < element)
				{
					element = chances[i];
					index = i;
				}
			}
		}
		else
			for (int i = 1; i < chances.length; i++)
			{
				if (chances[i] > element)
				{
					element = chances[i];
					index = i;
				}
			}
			
		return index;
	}
	
}
