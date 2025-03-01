package digit.adder.evenodd;

public class DigitAdderEvenAndOdd {

	public enum DigitType {
		EVEN, ODD
	}

	public int getDigitsSum(int num, DigitType type) {
		return String.valueOf(num).chars()
				.filter(digit -> hasType(digit, type))
				.map(Character::getNumericValue)
				.sum();
	}

	private boolean hasType(int digit, DigitType type) {
		return (type == DigitType.EVEN) 
				? (digit % 2 == 0) 
				: (digit % 2 != 0);
	}

}
