package creditcard;

public class CreditCardTypeChecker {

	public static final String INVALID_CREDIT_SCORE = "Invalid credit score";

	public static final int SILVER_THRESHOLD = 400;

	public static final int GOLD_THRESHOLD = 600;

	public static final int PLATINUM_THRESHOLD = 800;

	public static final int MAX_SCORE = 1000;

	public enum CreditCardTypeEnum {
		SILVER, GOLD, PLATINUM
	}

	public CreditCardTypeEnum getCreditCardType(int score) {
		validateScore(score);
		return isSilver(score) 
				? CreditCardTypeEnum.SILVER 
				: getAboveSilver(score);
	}

	private static void validateScore(int score) {
		if (score < SILVER_THRESHOLD || score > MAX_SCORE) {
			throw new IllegalArgumentException(INVALID_CREDIT_SCORE);
		}
	}

	private static boolean isSilver(int score) {
		return (score >= SILVER_THRESHOLD) && (score < GOLD_THRESHOLD);
	}

	private static CreditCardTypeEnum getAboveSilver(int score) {
		return isGold(score) 
				? CreditCardTypeEnum.GOLD 
				: CreditCardTypeEnum.PLATINUM;
	}

	private static boolean isGold(int score) {
		return (score >= GOLD_THRESHOLD) && (score < PLATINUM_THRESHOLD);
	}

}
