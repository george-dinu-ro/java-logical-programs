package digit.adder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DigitAdderTest {

	@ParameterizedTest
	@MethodSource("provideNumbers")
	void givenNumber_thenAddDigits(DigitAdder digitAdder, int number, int digitsSum) {
		assertThat(digitAdder.getDigitsSum(number))
			.isEqualTo(digitsSum);
	}

	private static Stream<Arguments> provideNumbers() {
		return Stream.of(
				Arguments.of(new DivisionDigitAdder(), 1, 1),
				Arguments.of(new StreamDigitAdder(), 1, 1),
				Arguments.of(new DivisionDigitAdder(), 11, 2),
				Arguments.of(new StreamDigitAdder(), 11, 2),
				Arguments.of(new DivisionDigitAdder(), 12345, 15),
				Arguments.of(new StreamDigitAdder(), 12345, 15));
	}

}
