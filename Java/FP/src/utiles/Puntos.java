package utiles;

import punto.*;

public class Puntos {
	public static boolean distanciaValor(Punto p1, Punto p2, Double d){
		boolean r = false;
		
		if (p1.distanciaAOtroPunto(p2) < d)
			r = true;
		
		return r;
	}
}
