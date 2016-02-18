package test;

import punto3D.Punto3DImpl;
import segmento.*;

public class TestSegmento extends Test {
	public static void main(String[] args) {
		Segmento s = new SegmentoImpl(new Punto3DImpl(5.0, 2.0, 3.0),
					 new Punto3DImpl(7.0, 5.0, 2.0));
		
		mostrar(s.longitud());
	}
}
