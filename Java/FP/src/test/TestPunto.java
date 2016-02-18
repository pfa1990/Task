package test;

import java.util.Arrays;

import punto.*;

public class TestPunto extends Test {
	public static void main(String[] args) {
		Punto p1 = new PuntoImpl(2.0, 3.0);
		Punto p2 = new PuntoImpl(3.0, 3.0);
		Punto [] puntos = {new PuntoImpl(2.0, -1.1),
						   new PuntoImpl(-5.5, 2.3),
						   new PuntoImpl(2.0, 0.0),
						   new PuntoImpl(-2.1, 5.5)};
		
		Arrays.sort(puntos);
		
		mostrar(Arrays.toString(puntos));
		mostrar(p1);
		mostrar(p1.distanciaAOtroPunto(p2));
	}
}
