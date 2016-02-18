package funciones;

import pelicula.Pelicula;

import com.google.common.base.Function;

public class FuncionPeliculaTituloNacionalidad implements Function<Pelicula, String> {
	public String apply(Pelicula p) {
		return p.getNombre() + " - " + p.getNacionalidad();
	}
}
