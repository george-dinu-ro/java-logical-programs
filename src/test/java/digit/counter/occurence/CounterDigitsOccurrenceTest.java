package digit.counter.occurence;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CounterDigitsOccurrenceTest {

	@ParameterizedTest
	@MethodSource("provideDigitsOccurrence")
	void shouldCountOccurrencesForEachDigit(int number, Map<Integer, Integer> occurrencies) {
		var counter = new CounterDigitsOccurrence();
		
		assertThat(counter.getDigitsOccurrence(number))
			.isEqualTo(occurrencies);
	}
	
	private static Stream<Arguments> provideDigitsOccurrence() {
		return Stream.of(
				Arguments.of(123, Map.of(1, 1, 2, 1, 3, 1)), 
				Arguments.of(112233, Map.of(1, 2, 2, 2, 3, 2)),
				Arguments.of(1234252, Map.of(1, 1, 2, 3, 3, 1, 4, 1, 5, 1)),
				Arguments.of(111222333, Map.of(1, 3, 2, 3, 3, 3)),
				Arguments.of(1234567890, Map.of(0, 1, 1, 1, 2, 1, 3, 1, 4, 1, 5, 1, 6, 1, 7, 1, 8, 1, 9, 1)));
	}
	
}
