package segmento;

import punto3D.*;

public class SegmentoImpl implements Segmento {

	private Punto3D ext1, ext2;

	public SegmentoImpl() {
		this.ext1 = new Punto3DImpl();
		this.ext2 = new Punto3DImpl();
	} 

	public SegmentoImpl(Punto3D ext1, Punto3D ext2) {
		if (ext1 == null || ext2 == null)
			throw new IllegalArgumentException("Los extremos no pueden ser null.");
		
		this.ext1 = ext1;
		this.ext2 = ext2;
	} 

	public Punto3D getExtremo1() {
		return ext1;
	}

	public Punto3D getExtremo2() {
		return ext2;
	}

	public void setExtremo1(Punto3D e1) {
		ext1 = e1;
	}

	public void setExtremo2(Punto3D e2) {
		ext2 = e2;
	}

	public Double longitud() {
		return Math.sqrt(Math.abs(this.ext1.getX()-this.ext2.getX()) +
				 		 Math.abs(this.ext1.getY()-this.ext2.getY()) +
				 		 Math.abs(this.ext1.getZ()-this.ext2.getZ()));
	}

	public String toString() {
		return "[" + getExtremo1() + ", " + getExtremo2() + "]";
	}

	public Segmento clone() {
		Segmento copia = null;
		
		try{
			copia = (Segmento)super.clone();
		}
		catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return copia;
	}

	public int hashCode() {
		return ext1.hashCode() * 31 + ext2.hashCode() * 37;
	}

	public boolean equals(Object o) {
		boolean r = false;
		
		if (o instanceof Segmento) {
			Segmento s1 = (Segmento)o;
			r = this.getExtremo1().equals(s1.getExtremo1()) &&
				this.getExtremo2().equals(s1.getExtremo2());
		}
		
		return r;
	}
}
