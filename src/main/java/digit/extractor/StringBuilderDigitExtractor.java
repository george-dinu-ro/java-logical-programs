package digit.extractor;

import java.util.List;

public class StringBuilderDigitExtractor implements DigitExtractor {

	@Override
	public List<Integer> getDigits(int number) {
		var string = new StringBuilder().append(number).reverse();
		
		return string.chars()
				.mapToObj(Character::getNumericValue)
				.toList();
	}

}
