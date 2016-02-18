package punto;

import utiles.Copiable;

public interface Punto extends Copiable<Punto>, Comparable<Punto> {
	Double getX();
	Double getY();
	void setX(Double x1);
	void setY(Double y1);
	Double distanciaAOtroPunto(Punto p2);
}
