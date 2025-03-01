package digit.adder.primecompound;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class DigitAdderPrimeAndCompound {

	@AllArgsConstructor
	@Getter
	public enum DigitTypeEnum {
		
		PRIME(List.of(2, 3, 5, 7)), 
		COMPOUND(List.of(0, 1, 4, 6, 8, 9));

		private final List<Integer> digits;

		public static boolean isOfType(int digit, DigitTypeEnum type) {
			return type.getDigits().contains(digit);
		}
	}

	public int getDigitsSum(int number, DigitTypeEnum type) {
		return String.valueOf(number).chars()
				.map(Character::getNumericValue)
				.filter(digit -> DigitTypeEnum.isOfType(digit, type))
				.sum();
	}
	
}
