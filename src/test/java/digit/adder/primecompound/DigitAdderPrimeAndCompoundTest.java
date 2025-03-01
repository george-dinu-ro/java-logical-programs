package digit.adder.primecompound;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import digit.adder.primecompound.DigitAdderPrimeAndCompound.DigitTypeEnum;

class DigitAdderPrimeAndCompoundTest {

	@ParameterizedTest
	@MethodSource("provideNumbers")
	void givenNumberAndDigitType_thenAddDigitsOfThatTypeOnly(int number, DigitTypeEnum type, int digitsSum) {
        var digitAdder = new DigitAdderPrimeAndCompound();
        
        assertThat(digitAdder.getDigitsSum(number, type))
        	.isEqualTo(digitsSum);
	}

	private static Stream<Arguments> provideNumbers() {
		return Stream.of(
				Arguments.of(6789, DigitTypeEnum.PRIME, 7), 
				Arguments.of(6789, DigitTypeEnum.COMPOUND, 23), 
				Arguments.of(123456789, DigitTypeEnum.PRIME, 17), 
				Arguments.of(123456789, DigitTypeEnum.COMPOUND, 28));
	}

}
