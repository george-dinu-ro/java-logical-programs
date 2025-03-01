package digit.adder.multipleof3;

import java.util.List;

public class DigitAdderMultipleOf3 {

	public int getDigitsSum(int number) {
		return String.valueOf(number).chars()
				.map(Character::getNumericValue)
				.filter(DigitAdderMultipleOf3::isMultipleOf3)
				.sum();
	}

	private static boolean isMultipleOf3(int digit) {
		return List.of(3, 6, 9).contains(digit);
	}

}
