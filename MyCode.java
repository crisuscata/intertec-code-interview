package characterscount;

import java.util.HashSet;

public class MyCode {

	private static int getNumberOfDistincts(String str, int n) {
		str = str.substring(1, n - 1);
		HashSet<Character> hashSet = new HashSet<Character>();
		for (int i = 0; i < str.length(); i++) {
			hashSet.add(str.charAt(i));
		}
		return hashSet.size();
	}

	private static String processWordWithSpecialSimbolAndNone(String str) {
		String result = "";

		int indexSymbol = 0;
		boolean existSymbol = false;
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isLetterOrDigit(str.charAt(i))) {
				indexSymbol = i;
				existSymbol = true;
				break;
			}
		}

		if (existSymbol) {
			result = getStringWithoutRepetitionCharacters(str.substring(0, indexSymbol)) + str.substring(indexSymbol);
		} else {
			result = getStringWithoutRepetitionCharacters(str);
		}

		return result;
	}

	private static String getStringWithoutRepetitionCharacters(String str) {
		int n = str.length();
		char first = str.charAt(0);
		char last = str.charAt(n - 1);

		return ((n > 2) ? (first + "" + (getNumberOfDistincts(str, n)) + "" + last) : str);

	}

	public static String wordParser(String input) {
		String[] words = input.split(" ");

		String result = "";
		for (String word : words) {
			result += processWordWithSpecialSimbolAndNone(word) + " ";
		}

		return result.trim();
	}

	public static void main(String[] args) {
		String output = wordParser("Creativity is thinking-up new things. Innovation is doing new things!");
		System.out.println(output);
	}

}
