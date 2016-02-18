package utiles;

public class Cadenas {
	private static Boolean esVocal(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}

	public static Integer cuentaVocales(String cad) {
		String cadMinus = cad.toLowerCase();
		Integer cont = 0;
		
		for(char c : cadMinus.toCharArray()) {
			if (esVocal(c))
				cont++;
		}
		
		return cont;
	}

	public static String invierteCadena(String cad) {
		String result = "";
		
		for (char c : cad.toCharArray())
			result = c+result;
		
		return result;
		
	}

	public static Integer cuentaApariciones(String cad, char c) {
		Integer cont = 0;
		
		for (int i = cad.indexOf(c); i <= cad.lastIndexOf(c); i++) {
			if (cad.charAt(i) == c)
				cont++;
		}
		
		return cont;
	}
}
