package funciones;

import pelicula.Pelicula;
import predicados.PredicadoPeliculaNacionalidad;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

public class FuncionPeliculaNacionalidad implements Function<String, Predicate<Pelicula>> {
	public Predicate<Pelicula> apply(String nac) {
		return new PredicadoPeliculaNacionalidad(nac);
	}
}
