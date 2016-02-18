package punto;

public class PuntoImpl implements Punto {

	private Double x;
	private Double y;

	public PuntoImpl() {
		x = 0.0;
		y = 0.0;
	}

	public PuntoImpl(Double x1, Double y1) {
		x = x1;
		y = y1;
	}

	public Double getX() {
		return x;
	}

	public Double getY() {
		return y;
	}

	public void setX(Double x1) {
		x = x1;
	}

	public void setY(Double y1) {
		y = y1;
	}

	public String toString() {
		return "(" + getX() + ", " + getY() + ")";
	}

	public Double distanciaAOtroPunto(Punto p2) {
		return Math.sqrt(Math.abs(this.getX()-p2.getX())+
						 Math.abs(this.getY()-p2.getY()));
	}

	public Punto clone() {
		Punto copia = null;
		
		try{
			copia = (Punto)super.clone();
		}
		catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return copia;
	}

	public int hashCode() {
		return x.hashCode() * 31 + y.hashCode() * 37;
	}

	public boolean equals(Object o) {
		boolean r = false;
		
		if (o instanceof Punto) {
			Punto p1 = (Punto)o;
			r = this.getX().equals(p1.getX()) &&
				this.getY().equals(p1.getY());
		}
		
		return r;
	}

	public int compareTo(Punto p) {
		int r = getX().compareTo(p.getX());
		
		if (r == 0)
			r = getY().compareTo(p.getY());
		
		return r;
	}
}
