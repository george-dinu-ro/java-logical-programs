package leapyear;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LeapYearCheckerTest {
	
	@ParameterizedTest
	@ValueSource(ints = { 1600, 2000, 2024, 2400 })
	void givenLeapYear_thenTrue(int year) {
		assertThat(LeapYearChecker.isLeapYear(year)).isTrue();
	}

	@ParameterizedTest
	@ValueSource(ints = { 1700, 1900, 2025, 2300 })
	void givenNonLeapYear_thenFalse(int year) {
		assertThat(LeapYearChecker.isLeapYear(year)).isFalse();
	}

}
