package libro;

import fecha.Fecha;
import persona.Persona;
import utiles.Copiable;

public interface Libro extends Copiable<Libro>, Comparable<Libro> {
	String getISBN();
	void setISBN(String isbn);
	String getTitulo();
	void setTitulo(String t);
	Persona getAutor();
	void setAutor(Persona a);
	Fecha getFechaEdicion();
	void setFechaEdicion(Fecha fE);
	Integer getNumeroPaginas();
	void setNumeroPaginas(Integer nP);
}
