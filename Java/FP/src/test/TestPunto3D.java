package test;

import punto3D.*;

public class TestPunto3D extends Test {
	public static void main(String[] args) {
		Punto3D p1 = new Punto3DImpl(2.0, 3.0, 5.0);
		Punto3D p2 = new Punto3DImpl(1.0, 4.0, 6.0);
		
		mostrar(p1);
		mostrar(p1.distanciaAOtroPunto3D(p2));
	}
}
