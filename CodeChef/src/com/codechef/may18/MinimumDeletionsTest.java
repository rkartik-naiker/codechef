package com.codechef.may18;

import java.util.*;

/* Name of the class has to be "Main" only if the class is public. */
class MinimumDeletionsTest
{
	static int gcd(int a, int b)
	{
		if (a < b)
			return gcd(b, a);
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

	public static void main(String[] args) throws java.lang.Exception
	{
		// your code goes here
		int t = 0, n, i, g;
		Scanner sc = new Scanner(System.in);
		if (sc.hasNext())
		{
			t = sc.nextInt();
		}
		while (t > 0)
		{
			n = sc.nextInt();
			int a[] = new int[n];

			for (i = 0; i < n; i++)
			{
				a[i] = sc.nextInt();
			}
			g = a[0];

			for (i = 1; i < n; i++)
			{

				g = gcd(g, a[i]);
			}
			if (g == 1)
				System.out.println(0);
			else
			{
				if (a[0] != 1)
					System.out.println(-1);
				else
					System.out.println(n - 1);
			}
			t--;
		}
		sc.close();
	}
}