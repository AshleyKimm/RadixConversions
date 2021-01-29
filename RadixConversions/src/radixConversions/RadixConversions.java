/**RadixConversions 
 * Purpose: Receives inputed value from the main method and
 * performs all the radix conversion calculations that are
 * required for the class MainConvert.java
 * Author: Ashley Kim
 * Date: September 30, 2020
 * Course: ICS4U1
 */
package radixConversions;

public class RadixConversions {

	public static String decimalToBinary(String dec) {
		// Declares String variable to prevent the adding of integers
		String binary = "";
		// Stores remainder of divided input % 2
		int remainder;
		// Converts String value to integer
		int inNum = Integer.valueOf(dec);
		boolean end = false;
		
		while (!end) {
			remainder = inNum % 2;
			inNum = inNum / 2;
			// Stores individual binary integers
			binary += remainder;
			
			// If inNum is no longer divisible, exits the loop
			if (inNum == 0)
				end = true;
		}
		// Creates StringBuilder to reverse the order of characters in binary
		StringBuilder binRev = new StringBuilder(binary);
		binRev.reverse();

		// Converts StringBuilder to String for appropriate return value
		String finBin = binRev.toString();

		return finBin;
	}

	public static int binaryToDecimal(String bin) {
		int decimal = 0;

		// Loop ends when the base exponent is greater than number of chars in binary
		for (int powOf = 0; powOf < bin.length(); powOf++) {
			// powOf becomes the exponent of base Number
			double baseNum = Math.pow(2, bin.length() - 1 - powOf);
			// Converts a character of String value to integer for multiplication
			int binChar = Integer.parseInt(bin.substring(powOf, powOf + 1));

			// Stores and adds the multiplication to previous calculation
			decimal += baseNum * binChar;
		}
		return decimal;
	}

	public static String decimalToHexadecimal(String dec) {
		// Converts and assigns String value of dec to integer
		int intDec = Integer.parseInt(dec);
		// Used for matching int value of index to its hexadecimal character
		String hexEquivalent = "0123456789ABCDEF";
		// Stores individual hexadecimal characters
		String hex = "";
		int remainder;
		boolean end = false;

		while (!end) {
			remainder = intDec % 16;
			intDec = intDec / 16;

			// Adds the hexadecimal character to previously stored value
			hex += hexEquivalent.substring(remainder, remainder + 1);

			// Exits the loop when intDec is no longer divisible
			if (intDec == 0)
				end = true;
		}
		// Creates StringBuilder to reverse the order of characters in hexRev
		StringBuilder hexRev = new StringBuilder(hex);
		hexRev.reverse();
		// Converts StringBuilder to String for proper return format
		hex = hexRev.toString();

		return hex;
	}

	public static int hexadecimalToDecimal(String hex) {
		// Used for matching int value of index to its hexadecimal character
		String hexDigits = "0123456789ABCDEF";
		int dec = 0;
		// Changes all the inputed alphabet characters to upper case to match  hexDigits
		hex = hex.toUpperCase();

		for (int powOf = 0; powOf < hex.length(); powOf++) {
			// Assigns the character at powOf index
			char character = hex.charAt(powOf);
			// Assigns the index number of character
			int digit = hexDigits.indexOf(character);
			// Calculates the base number with exponents
			double baseNum = Math.pow(16, hex.length() - 1 - powOf);

			// Adds the calculation to the previous value
			dec += baseNum * digit;
		}
		return dec;
	}

	public static String binaryToHexadecimal(String binary) {
		// Calls the method to get converted value of decimal from binary
		int dec = binaryToDecimal(binary);
		// Converts the integer value to String for calling method below
		String strDec = String.valueOf(dec);
		// Calls the method to get converted value of hex from decimal
		String hex = decimalToHexadecimal(strDec);

		return hex;
	}

	public static String hexadecimalToBinary(String hex) {
		// Calls the method to get converted value of decimal from hex
		int dec = hexadecimalToDecimal(hex);
		// Converts integer value to String for the method call below
		String strBin = String.valueOf(dec);
		// Calls the method to get converted value of binary from decimal
		String finBin = decimalToBinary(strBin);

		return finBin;
	}
}
