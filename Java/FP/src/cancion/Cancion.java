package cancion;

import utiles.Copiable;

public interface Cancion extends Copiable<Cancion>, Comparable<Cancion> {
	String getNombre();
	String getInterprete();
	Integer getDuracion();
	Integer getAnio();
	Genero getGenero();
	Integer getNumReprod();
	void setNumReprod(Integer n);
	Double getCalificacion();
	void setCalificacion(Double c);
	Boolean getReproducir();
	void setReproducir(Boolean r);
	String getDuracionMS();
}
