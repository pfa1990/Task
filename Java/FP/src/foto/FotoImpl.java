package foto;

import persona.*;
import fecha.*;

public class FotoImpl implements Foto {

	private String titulo;
	private Persona autor;
	private Fecha fecha;
	private FormatoImagen formato;
	private Integer alto, ancho, numVisitas;
	private Double tamano, calificacion;
	private Boolean retocada;

	public FotoImpl() {
		this.titulo = "";
		this.autor = new PersonaImpl();
		this.fecha = new FechaImpl();
		this.formato = FormatoImagen.BMP;
		this.alto = 0;
		this.ancho = 0;
		this.numVisitas = 0;
		this.tamano = 0.0;
		this.calificacion = 0.0;
		this.retocada = false;
	}

	public FotoImpl(String titulo, Persona autor, Fecha fecha,
					FormatoImagen formato, Integer alto, Integer ancho,
					Integer numVisitas, Double tamano, Double calificacion,
					Boolean retocada) {
		if (alto < 0 || ancho < 0 || tamano < 0)
			throw new IllegalArgumentException("El alto, el ancho y el tamaño "
					+ "deben ser mayores o iguales que 0.");
		if (calificacion < 0 || calificacion > 10)
			throw new IllegalArgumentException("La calificación debe estar "
					+ "comprendida entre 0 y 10.");
		if (numVisitas < 0)
			throw new IllegalArgumentException("El número de visitas debe ser "
					+ "mayor o igual que 0.");
		
		this.titulo = titulo;
		this.autor = autor;
		this.fecha = fecha;
		this.formato = formato;
		this.alto = alto;
		this.ancho = ancho;
		this.numVisitas = numVisitas;
		this.tamano = tamano;
		this.calificacion = calificacion;
		this.retocada = retocada;
	}

	public String getTitulo() {
		return titulo;
	}

	public Persona getAutor() {
		return autor;
	}

	public Fecha getFecha() {
		return fecha;
	}

	public FormatoImagen getFormato() {
		return formato;
	}

	public Integer getAlto() {
		return alto;
	}

	public Integer getAncho() {
		return ancho;
	}

	public Double getTamano() {
		return tamano;
	}

	public Double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Double c) {
		if (c < 0 || c > 10)
			throw new IllegalArgumentException("La calificación debe estar "
					+ "comprendida entre 0 y 10.");
		calificacion = c;
	}

	public Boolean getRetocada() {
		return retocada;
	}

	public void setRetocada(Boolean r) {
		retocada = r;
	}

	public Integer getNumVisitas() {
		return numVisitas;
	}

	public void setNumVisitas(Integer nV) {
		if (nV < 0)
			throw new IllegalArgumentException("El número de visitas debe ser "
					+ "mayor o igual que 0.");
		numVisitas = nV;
	}

	public String toString() {
		return "[" + getTitulo() + ", " + getAutor() + ", " + getCalificacion()
			   + "]";
	}

	public Foto clone() {
		Foto copia = null;
		
		try{
			copia = (Foto)super.clone();
		}
		catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return copia;
	}

	public int hashCode() {
		return titulo.hashCode() * 31 + autor.hashCode() * 37 +
			   calificacion.hashCode() * 41;
	}

	public boolean equals(Object o) {
		boolean r = false;
		
		if (o instanceof Foto) {
			Foto f1 = (Foto)o;
			r = this.getTitulo().equals(f1.getTitulo()) &&
				this.getAutor().equals(f1.getAutor()) &&
				this.getCalificacion().equals(f1.getCalificacion());
		}
		
		return r;
	}
}
