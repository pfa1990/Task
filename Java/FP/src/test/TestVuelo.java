package test;

import java.util.ArrayList;
import java.util.List;

import persona.*;

import fecha.*;
import vuelo.*;

public class TestVuelo extends Test {
	public static void main(String[] args) {
		try{
			List<Pasajero> lista = new ArrayList<Pasajero>();
			Vuelo v1 = new VueloImpl("IB2349", "Madrid", 50.0, 20,
									 new FechaImpl(1, 1, 2012),
									 new FechaImpl(15, 12, 2011), lista);
			Pasajero p1 = new PasajeroImpl("15403084-F", "Pedro", "Flores Andújar",
					 21, 1.75, 61.5, Genero.HOMBRE, 1, 'A');
			Pasajero p2 = new PasajeroImpl("24967435-S", "Juan", "Alvarez Lopez",
					 21, 1.75, 61.5, Genero.HOMBRE, 2, 'K');
			Pasajero p3 = new PasajeroImpl("33741452-F", "Maria", "Ortiz Saez",
					 21, 1.75, 61.5, Genero.MUJER, 3, 'D');
			
			v1.anadePasajero(p1);
			v1.anadePasajero(p2);
			v1.anadePasajero(p3);
			
			mostrar(v1);
			mostrar(v1.getNumPasajeros());
		} catch (IllegalArgumentException e) {
			mostrar("Se ha capturado excepción.");
		}
	}
}
