package pelicula;

import utiles.Copiable;

public interface Pelicula extends Copiable<Pelicula>, Comparable<Pelicula> {
	String getNombre();
	String getNacionalidad();
	Genero getGenero();
	Double getPresupuesto();
	void setPresupuesto(Double p);
	Integer getAño();
}
