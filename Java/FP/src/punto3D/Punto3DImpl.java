package punto3D;

public class Punto3DImpl implements Punto3D {

	private Double x;
	private Double y;
	private Double z;

	public Punto3DImpl() {
		x = 0.0;
		y = 0.0;
		z = 0.0;
	}

	public Punto3DImpl(Double x1, Double y1, Double z1) {
		if (x1 == null || y1 == null || z1 == null)
			throw new IllegalArgumentException("Las coordenadas no pueden ser "
					+ "null.");
		
		x = x1;
		y = y1;
		z = z1;
	}

	public Double getX() {
		return x;
	}

	public Double getY() {
		return y;
	}

	public Double getZ() {
		return z;
	}

	public void setX(Double x1) {
		x = x1;
	}

	public void setY(Double y1) {
		y = y1;
	}

	public void setZ(Double z1) {
		z = z1;
	}

	public String toString() {
		return "(" + getX() + ", " + getY() + ", " + getZ() + ")";
	}

	public Double distanciaAOtroPunto3D(Punto3D p2) {
		return Math.sqrt(Math.abs(this.getX()-p2.getX()) +
						 Math.abs(this.getY()-p2.getY()) +
						 Math.abs(this.getZ()-p2.getZ()));
	}

	public Punto3D clone() {
		Punto3D copia = null;
		
		try{
			copia = (Punto3D)super.clone();
		}
		catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return copia;
	}

	public int hashCode() {
		return x.hashCode() * 31 + y.hashCode() * 37 + z.hashCode() * 41;
	}

	public boolean equals(Object o) {
		boolean r = false;
		
		if (o instanceof Punto3D) {
			Punto3D p1 = (Punto3D)o;
			r = this.getX().equals(p1.getX()) &&
				this.getY().equals(p1.getY()) &&
				this.getZ().equals(p1.getZ());
		}
		
		return r;
	}
}
