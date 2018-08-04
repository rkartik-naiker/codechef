

package com.codechef.firsttest;

import java.util.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {
	public static void main(String[] args) throws java.lang.Exception {
		ArrayList<Integer> numList = new ArrayList<Integer>();
		int choice;
		boolean boolVal = false;
		Scanner scan = new Scanner(System.in);

		do {
			int number;
			try {
				System.out.println("Enter a Number from 0 to 99");
				number = scan.nextInt();
				if (number < 100)
					numList.add(number);
				else
					System.out.println("Invalid Number");

				System.out.println("Do you want to continue ? (Press 0 to exit)");
				choice = scan.nextInt();
				if (choice == 0)
					boolVal = false;
				else
					boolVal = true;
			} catch (InputMismatchException e) {
				System.out.println("Invalid Input. Please enter in numeric format");

			}
		} while (boolVal);
		scan.close();
		for (int num : numList) {

			if (num != 42) {
				System.out.println(num);

			} else
				break;
		}

	}
}
