package digit.counter.ducknumber;

public class DuckNumberChecker {

	public boolean isDuckNumber(int number) {
		return String.valueOf(number).contains("0");
	}

}
