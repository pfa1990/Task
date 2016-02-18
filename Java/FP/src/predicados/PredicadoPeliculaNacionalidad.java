package predicados;

import pelicula.Pelicula;

import com.google.common.base.Predicate;

public class PredicadoPeliculaNacionalidad implements Predicate<Pelicula> {

	private String nacionalidad;

	public PredicadoPeliculaNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public boolean apply(Pelicula p) {
		return p.getNacionalidad().equals(nacionalidad);
	}
}
