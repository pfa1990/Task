package test;

import utiles.Cadenas;

public class TestCadenas extends Test {
	public static void main(String[] args) {
		String s = "Prueba cadenas";
		
		mostrar(Cadenas.cuentaVocales(s));
		mostrar(Cadenas.invierteCadena(s));
		mostrar(Cadenas.cuentaApariciones(s, 'e'));
	}
}
