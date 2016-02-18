package libro;

import persona.Persona;
import persona.PersonaImpl;
import fecha.Fecha;
import fecha.FechaImpl;

public class LibroImpl implements Libro {

	private String isbn, titulo;
	private Persona autor;
	private Fecha fechaEdicion;
	private Integer numeroPaginas;

	public LibroImpl() {
		this.isbn = "";
		this.titulo = "";
		this.autor = new PersonaImpl();
		this.fechaEdicion = new FechaImpl();
		this.numeroPaginas = 0;
	}

	public LibroImpl(String isbn, String titulo, Persona autor,
					 Fecha fechaEdicion, Integer numeroPaginas) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.fechaEdicion = fechaEdicion;
		this.numeroPaginas = numeroPaginas;
	}

	public String getISBN() {
		return isbn;
	}

	public void setISBN(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String t) {
		this.titulo = t;
	}

	public Persona getAutor() {
		return autor;
	}

	public void setAutor(Persona a) {
		this.autor = a;
	}

	public Fecha getFechaEdicion() {
		return fechaEdicion;
	}

	public void setFechaEdicion(Fecha fE) {
		this.fechaEdicion = fE;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(Integer nP) {
		this.numeroPaginas = nP;
	}

	public Libro clone() {
		Libro copia = null;
		
		try{
			copia = (Libro)super.clone();
		}
		catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return copia;
	}

	public int hashCode() {
		return getISBN().hashCode() * 31 + getTitulo().hashCode() * 37 +
			   getFechaEdicion().hashCode() * 41;
	}

	public boolean equals (Object o) {
		boolean r = false;
		
		if (o instanceof Libro) {
			Libro l1 = (Libro)o;
			r = this.getISBN().equals(l1.getISBN())&&
				this.getTitulo().equals(l1.getTitulo())&&
				this.getFechaEdicion().equals(l1.getFechaEdicion());
		}
		
		return r;
	}

	public int compareTo(Libro l) {
		int r = getTitulo().compareTo(l.getTitulo());
		
		if (r == 0) {
			r = getFechaEdicion().compareTo(l.getFechaEdicion());
			if (r == 0)
				r = getISBN().compareTo(l.getISBN());
		}
		
		return r;
	}

	public String toString() {
		return "[" + getISBN() + ", " + getTitulo() + ", " + getFechaEdicion()
			   + "]";
	}
}
