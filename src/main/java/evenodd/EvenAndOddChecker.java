package evenodd;

public class EvenAndOddChecker {

	public static final String NUMBER_MUST_BE_GREATER_THAN_0 = "Number must be greater than 0";

	public enum EvenOddEnum {
		EVEN, ODD;
	}

	public EvenOddEnum check(int number) {
		validateNumber(number);
		return (number % 2 == 0) ? EvenOddEnum.EVEN : EvenOddEnum.ODD;
	}

	private static void validateNumber(int number) {
		if (number <= 0) {
			throw new IllegalArgumentException(NUMBER_MUST_BE_GREATER_THAN_0);
		}
	}

}
