package test;

import cancion.*;

public class TestCancion extends Test {
	public static void main(String[] args) {
		try{
			Cancion c1 = new CancionImpl("Nightrain", "GN'R", 250, 1989, 1,
										 Genero.ROCK, 9.5, true);
			
			mostrar(c1);
			mostrar(c1.getDuracionMS());
		} catch (IllegalArgumentException e) {
			mostrar("Se ha capturado excepción." + e);
		}
	}
}
