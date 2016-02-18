package test;

import persona.*;

public class TestPersona extends Test {
	public static void main(String[] args) {
		try{
			Persona per1 = new PersonaImpl("15403084-F", "Pedro", "Flores Andújar",
					 21, 1.75, 61.5, Genero.HOMBRE);
			
			mostrar(per1);
			
			Pasajero pas1 = new PasajeroImpl("15403084-F", "Pedro", "Flores Andújar",
					 21, 1.75, 61.5, Genero.HOMBRE, 1, 'A');
			
			mostrar(pas1);
			
			Jugador jug1 = new JugadorImpl("15403084-F", "Pedro", "Flores Andújar",
					 21, 1.75, 61.5, Genero.HOMBRE, "Flores", "Lateral derecho", 17);
			
			mostrar(jug1);
			
			Arbitro arb1 = new ArbitroImpl("24967435-S", "Juan", "Alvarez Lopez",
					 21, 1.75, 61.5, Genero.HOMBRE, "Cuarto");
			
			mostrar(arb1);
		} catch(IllegalArgumentException e) {
			mostrar("Se ha capturado excepción.");
		}
	}
}
