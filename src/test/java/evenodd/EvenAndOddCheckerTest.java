package evenodd;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import evenodd.EvenAndOddChecker.EvenOddEnum;

class EvenAndOddCheckerTest {

	private EvenAndOddChecker evenAndOddChecker;

	@BeforeEach
	void init() {
		evenAndOddChecker = new EvenAndOddChecker();
	}

	@ParameterizedTest
	@ValueSource(ints = { -10, 0 })
	void givenInvalidNumber_whenCheck_thenThrowIllegalArgumentException(int number) {
		var exception = assertThrows(IllegalArgumentException.class, () -> evenAndOddChecker.check(number));

		assertThat(exception.getMessage()).isEqualTo(EvenAndOddChecker.NUMBER_MUST_BE_GREATER_THAN_0);
	}

	@ParameterizedTest
	@ValueSource(ints = { 2, 10 })
	void givenEvenNumber_whenCheck_thenReturnEven(int number) {
		assertThat(evenAndOddChecker.check(number)).isEqualTo(EvenOddEnum.EVEN);
	}

	@ParameterizedTest
	@ValueSource(ints = { 1, 11 })
	void givenOddNumber_whenCheck_thenReturnOdd(int number) {
		assertThat(evenAndOddChecker.check(number)).isEqualTo(EvenOddEnum.ODD);
	}

}
