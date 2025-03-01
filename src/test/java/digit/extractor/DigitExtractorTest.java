package digit.extractor;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DigitExtractorTest {

	@ParameterizedTest
	@MethodSource("provideNumbers")
	void givenNumber_thenExtractDigits(DigitExtractor digitExtractor, int number, List<Integer> digits) {
		assertThat(digitExtractor.getDigits(number)).isEqualTo(digits);
	}

	private static Stream<Arguments> provideNumbers() {
		return Stream.of(
				Arguments.of(new DivisionDigitExtractor(), 1, List.of(1)),
				Arguments.of(new StringBuilderDigitExtractor(), 1, List.of(1)),
				Arguments.of(new DivisionDigitExtractor(), 11, List.of(1, 1)),
				Arguments.of(new StringBuilderDigitExtractor(), 11, List.of(1, 1)),
				Arguments.of(new DivisionDigitExtractor(), 12345, List.of(5, 4, 3, 2, 1)),
				Arguments.of(new StringBuilderDigitExtractor(), 12345, List.of(5, 4, 3, 2, 1)));
	}

}
