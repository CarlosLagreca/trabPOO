package util;

public class Cpf {
	public static boolean isCpf(long cpf) {
		try {
			String cpfString = Long.toString(cpf);
			if(cpfString.length() == 11)
				return true;
			return false;
		} catch(NullPointerException e) {
			return false;
		}
	}
}
