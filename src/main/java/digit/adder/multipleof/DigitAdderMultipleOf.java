package digit.adder.multipleof;

public class DigitAdderMultipleOf {

	public int getDigitsSum(int number, int multipleOf) {
		return String.valueOf(number).chars()
				.map(Character::getNumericValue)
				.filter(digit -> isMultipleOf(digit, multipleOf))
				.sum();
	}

	private static boolean isMultipleOf(int digit, int multipleOf) {
		return ((digit % multipleOf) == 0);
	}

}
