package digit.counter.ducknumber;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DuckNumberCheckerTest {

	@ParameterizedTest
	@MethodSource("provideDuckNumbers")
	void shouldVerifyDuckNumber(int number, boolean isDuckNumber) {
		var duckNumberChecker = new DuckNumberChecker();

		assertThat(duckNumberChecker.isDuckNumber(number)).isEqualTo(isDuckNumber);
	}

	private static Stream<Arguments> provideDuckNumbers() {
		return Stream.of(
				Arguments.of(101, true), 
				Arguments.of(12345, false), 
				Arguments.of(2309, true),
				Arguments.of(23456789, false), 
				Arguments.of(234567890, true));
	}

}
