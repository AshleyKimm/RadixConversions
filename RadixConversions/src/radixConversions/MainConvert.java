/**MainConvert 
 * Purpose: Imports and runs the corresponding method based on user input
 * Overall purpose is to convert the radix of the inputed number correspondingly
 * to the user's choice.
 * Author: Ashley Kim
 * Date: September 30, 2020
 * Course: ICS4U1
 */
package radixConversions;

//Allows for scanner and error checking
import java.util.*;

public class MainConvert {

	public static void main(String[] args) {

		// Generates a scanner for user input
		Scanner input = new Scanner(System.in);

		System.out.print("<RADIX CONVERTER>\n");

		// Stores user's decision to continue or not
		boolean stop = false;

		// Loops until the user chooses to stop (when stop == true)
		while (!stop) {

			/*
			 * Checks for InputMismatchException and NumberFormatException When
			 * error detected, it is passed to catch
			 */
			try {
				/*
				 * Since try and catch cannot detect the following error, it
				 * loops the following when the input does not match numbers
				 * from 1 to 6. 
				 * Exits the loop when user inputs the number correctly
				 */
				boolean firstError;
				int typeConv;
				do {
					System.out.println("\nEnter 1:Decimal -> Binary\nEnter 2:Binary -> Decimal\n"
							+ "Enter 3:Decimal -> Hexadecimal\nEnter 4:Hexadecimal -> Decimal\n"
							+ "Enter 5:Binary -> Hexadecimal\nEnter 6:Hexadecimal -> Binary");
					System.out.print("\nEnter a corresponding number for the type of conversion: ");
					// Receives and assigns the inputed value
					typeConv = input.nextInt();
					// Displays following when input does not match given number
					if (typeConv < 1 || typeConv > 6) {
						System.out.println("Please enter numbers from the menu only.");
						// Loops
						firstError = true;
					} else
						// Exits the loop
						firstError = false;

				} while (firstError);

				System.out.println("Enter a number that you would like to convert: ");

				// Receives and assigns the converting number in String variable
				String inputNum = input.nextLine();
				inputNum = input.nextLine();

				/*
				 * Executes the user's choice of radix conversion by calling the
				 * corresponding method from RadixConversions.java class. 
				 * Displays the calculated result with initially inputed number.
				 */
				switch (typeConv) {
				case 1: // Executes decimal to binary conversion
					System.out.print(inputNum + " is " + RadixConversions.decimalToBinary(inputNum)
							+ " when converted from decimal to binary.");
					break;
				case 2: // Executes binary to decimal conversion
					System.out.print(inputNum + " is " + RadixConversions.binaryToDecimal(inputNum)
							+ " when converted from binary to decimal.");
					break;
				case 3: // Executes decimal to Hexadecimal conversion
					System.out.print(inputNum + " is " + RadixConversions.decimalToHexadecimal(inputNum)
							+ " when converted from decimal to hexadecimal.");
					break;
				case 4: // Executes hexadecimal to decimal conversion
					System.out.print(inputNum + " is " + RadixConversions.hexadecimalToDecimal(inputNum)
							+ " when converted from hexadecimal to decimal.");
					break;
				case 5: // Executes binary to Hexadecimal conversion
					System.out.print(inputNum + " is " + RadixConversions.binaryToHexadecimal(inputNum)
							+ " when converted from binary to hexadecimal.");
					break;
				case 6: // Executes hexadecimal to binary conversion
					System.out.print(inputNum + " is " + RadixConversions.hexadecimalToBinary(inputNum)
							+ " when converted from hexadecimal to binary.");
					break;
				}

				/*
				 * Asks the user if they would like to continue. Loops the
				 * following when the input do not match the String. 
				 * Exits the loop when input matches.
				 */
				boolean secondError = false;
				
				do {
					System.out.print("\nWould you like to continue using <RADIX CONVERTER>?\n"
							+ "If yes, enter y. If no, enter n: ");
					
					// Receives and assigns string to the variable
					String yesOrNo = input.nextLine();

					// Resets the value to false when looped
					secondError = false;

					// When "n" inputed, exits the while(!stop) loop
					if (yesOrNo.equals("n")) {
						System.out.println("Goodbye.");

						input.close();
						
						stop = true;
					}
					// When input does not match n or y, executes the following
					if (!yesOrNo.equals("n") && !yesOrNo.equals("y")) {
						// Loops the do-while loop.
						secondError = true;

						System.out.print("\nPlease enter y or n only.");
					}
				} while (secondError);

				// String is displayed when InputMismatchException or
				// NumberFormatException occurs
			} catch (InputMismatchException | NumberFormatException e) {
				System.out.print("Please enter corresponding numbers only. \n(Hit enter)");
				input.nextLine();
			}
		} // while (!stop)
	} // Main method

} // class
