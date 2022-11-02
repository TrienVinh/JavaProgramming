package BUS;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassSupport {

	public static boolean checkText(String text, String regex) {
		return text.matches(regex);
	}

	public static String findString(String text, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		String result = "";
		while (matcher.find()) {
			result = matcher.group(1);
		}
		return result;
	}
}
