package digit.adder.evenodd;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import digit.adder.evenodd.DigitAdderEvenAndOdd.DigitType;

class DigitAdderEvenAndOddTest {

	@ParameterizedTest
	@MethodSource("provideNumbers")
	void givenNumberAndDigitType_thenAddDigitsOfThatTypeOnly(int number, DigitType type, int digitsSum) {
        var digitAdder = new DigitAdderEvenAndOdd();
        
        assertThat(digitAdder.getDigitsSum(number, type))
        	.isEqualTo(digitsSum);
	}

	private static Stream<Arguments> provideNumbers() {
		return Stream.of(
				Arguments.of(0, DigitType.EVEN, 0), 
				Arguments.of(0, DigitType.ODD, 0), 
				Arguments.of(1, DigitType.EVEN, 0), 
				Arguments.of(1, DigitType.ODD, 1), 
				Arguments.of(2, DigitType.EVEN, 2), 
				Arguments.of(2, DigitType.ODD, 0),
				Arguments.of(13, DigitType.EVEN, 0), 
				Arguments.of(13, DigitType.ODD, 4),
				Arguments.of(24, DigitType.EVEN, 6), 
				Arguments.of(24, DigitType.ODD, 0),
				Arguments.of(12345, DigitType.EVEN, 6), 
				Arguments.of(12345, DigitType.ODD, 9));
	}

}
