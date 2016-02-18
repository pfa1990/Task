package punto3D;

public interface Punto3D {
	Double getX();
	Double getY();
	Double getZ();
	void setX(Double x1);
	void setY(Double y1);
	void setZ(Double z1);
	Double distanciaAOtroPunto3D(Punto3D p2);
}
