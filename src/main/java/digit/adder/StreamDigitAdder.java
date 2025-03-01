package digit.adder;

public class StreamDigitAdder implements DigitAdder {

	@Override
	public int getDigitsSum(int num) {
		return String.valueOf(num).chars()
				.map(Character::getNumericValue)
				.sum();
	}

}
