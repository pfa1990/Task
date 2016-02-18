package test;

import foto.*;

public class TestFoto extends Test {
	public static void main(String[] args) {
		try{
			Foto f = new FotoImpl();
			
			mostrar(f);
		} catch(IllegalArgumentException e) {
			mostrar("Se ha capturado excepción.");
		}
	}
}
