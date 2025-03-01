package creditcard;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import creditcard.CreditCardTypeChecker.CreditCardTypeEnum;

class CreditCardTypeCheckerTest {

	private CreditCardTypeChecker creditCardTypeChecker;

	@BeforeEach
	void init() {
		creditCardTypeChecker = new CreditCardTypeChecker();
	}

	@ParameterizedTest
	@ValueSource(ints = { 0, 399, 1001 })
	void givenInvalidCreditScore_whenGetCreditCardType_thenThrowIllegalArgumentException(int score) {
		var exception = assertThrows(IllegalArgumentException.class,
				() -> creditCardTypeChecker.getCreditCardType(score));

		assertThat(exception.getMessage()).isEqualTo(CreditCardTypeChecker.INVALID_CREDIT_SCORE);
	}

	@ParameterizedTest
	@ValueSource(ints = { CreditCardTypeChecker.SILVER_THRESHOLD, 401, 599 })
	void givenSilverScore_whenGetCreditCardType_thenReturnSilverType(int score) {
		assertThat(creditCardTypeChecker.getCreditCardType(score)).isEqualTo(CreditCardTypeEnum.SILVER);
	}

	@ParameterizedTest
	@ValueSource(ints = { CreditCardTypeChecker.GOLD_THRESHOLD, 601, 799 })
	void givenGoldScore_whenGetCreditCardType_thenReturnGoldType(int score) {
		assertThat(creditCardTypeChecker.getCreditCardType(score)).isEqualTo(CreditCardTypeEnum.GOLD);
	}

	@ParameterizedTest
	@ValueSource(ints = { CreditCardTypeChecker.PLATINUM_THRESHOLD, 801, 999, CreditCardTypeChecker.MAX_SCORE })
	void givenPlatinumScore_whenGetCreditCardType_thenReturnPlatinumType(int score) {
		assertThat(creditCardTypeChecker.getCreditCardType(score)).isEqualTo(CreditCardTypeEnum.PLATINUM);
	}

}
