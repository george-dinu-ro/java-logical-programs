package digit.counter.occurence;

import java.util.SortedMap;
import java.util.TreeMap;

public class CounterDigitsOccurrence {

	public SortedMap<Integer, Integer> getDigitsOccurrence(int number) {
		return String.valueOf(number).chars()
				.map(Character::getNumericValue)
				.collect(TreeMap::new, (map, digit) -> map.put(digit, map.getOrDefault(digit, 0) + 1), TreeMap::putAll);
	}

}
