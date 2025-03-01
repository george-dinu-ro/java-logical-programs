package evenodd;

public class EvenAndOdd {

	public static final String NUMBER_MUST_BE_GREATER_THAN_0 = "Number must be greater than 0";

	public enum EvenOddEnum {
		EVEN, ODD;
	}

	public static EvenOddEnum check(int number) {
		if (number <= 0) {
			throw new IllegalArgumentException(NUMBER_MUST_BE_GREATER_THAN_0);
		}

		return (number % 2 == 0) ? EvenOddEnum.EVEN : EvenOddEnum.ODD;
	}

}
