package digit.adder.multipleof;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import digit.adder.multipleof.DigitAdderMultipleOf;

class DigitAdderMultipleOfTest {

	@ParameterizedTest
	@MethodSource("provideNumbers")
	void givenNumber_thenAddOnlyMultipleOf3Digits(int number, int multipleOf, int digitsSum) {
		var digitAdder = new DigitAdderMultipleOf();

		assertThat(digitAdder.getDigitsSum(number, multipleOf))
			.isEqualTo(digitsSum);
	}

	private static Stream<Arguments> provideNumbers() {
		return Stream.of(
				Arguments.of(124578, 3, 0), 
				Arguments.of(2357, 3, 3), 
				Arguments.of(6789, 3, 15),
				Arguments.of(123456789, 3, 18));
	}
	
}
