package digit;

import java.util.ArrayList;
import java.util.List;

public class DivisionDigitExtractor implements DigitExtractor {

	@Override
	public List<Integer> getDigits(int number) {
		var digits = new ArrayList<Integer>();

		while (number != 0) {
			digits.add(number % 10);
			number /= 10;
		}

		return digits;
	}

}
