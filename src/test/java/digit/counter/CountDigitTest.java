package digit.counter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CountDigitTest {

	@ParameterizedTest
	@MethodSource("provideNumbers")
	void shouldCountDigits(int number, int digitsNumber) {
		var countDigit = new CountDigit();
		
		assertThat(countDigit.getDigitsCount(number))
			.isEqualTo(digitsNumber);
	}

	private static Stream<Arguments> provideNumbers() {
		return Stream.of(
				Arguments.of(0, 1), 
				Arguments.of(1, 1), 
				Arguments.of(6789, 4), 
				Arguments.of(123456789, 9));
	}
	
}
