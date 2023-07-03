package util;

public class Telefone {
	public static boolean isTelefone(long num) {
		String numString = Long.toString(num);
		if(numString.length() == 8 || numString.length() == 10 || numString.length() == 11) {
			return true;
		}
		return false;
	}
}
