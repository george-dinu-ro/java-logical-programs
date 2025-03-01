package digit.adder.multipleof3;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DigitAdderMultipleOf3Test {

	@ParameterizedTest
	@MethodSource("provideNumbers")
	void givenNumber_thenAddOnlyMultipleOf3Digits(int number, int digitsSum) {
		var digitAdder = new DigitAdderMultipleOf3();

		assertThat(digitAdder.getDigitsSum(number))
			.isEqualTo(digitsSum);
	}

	private static Stream<Arguments> provideNumbers() {
		return Stream.of(
				Arguments.of(124578, 0),
				Arguments.of(2357, 3),
				Arguments.of(6789, 15),
				Arguments.of(123456789, 18));
	}
}
