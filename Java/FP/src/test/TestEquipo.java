package test;

import java.util.ArrayList;
import java.util.List;

import equipo.Equipo;
import equipo.EquipoImpl;

import persona.Arbitro;
import persona.ArbitroImpl;
import persona.Genero;
import persona.Jugador;
import persona.JugadorImpl;
import persona.Persona;

public class TestEquipo extends Test {
	public static void main(String[] args) {
		List<Persona> lista = new ArrayList<Persona>();
		Equipo equipo = new EquipoImpl("Equipo 1", lista);
		
		Jugador jug1 = new JugadorImpl("15403084-F", "Pedro", "Flores Andújar",
				 21, 1.75, 61.5, Genero.HOMBRE, "Flores", "Lateral derecho", 17);
		
		mostrar(jug1);
		
		Arbitro arb1 = new ArbitroImpl("24967435-S", "Juan", "Alvarez Lopez",
				 21, 1.75, 61.5, Genero.HOMBRE, "Cuarto");
		
		mostrar(arb1);
		
		equipo.anadeComponente(jug1);
		
		mostrar(equipo);
	}
}
