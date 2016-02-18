package pelicula;

import java.util.ArrayList;
import java.util.List;

public class PeliculaImplIterableInstanciasCreadas extends PeliculaImpl implements Pelicula {

	private static List<Pelicula> instancias = new ArrayList<Pelicula>();

	public PeliculaImplIterableInstanciasCreadas() {
		super();
		instancias.add(this);
	}

	public PeliculaImplIterableInstanciasCreadas(String cad) {
		super(cad);
		instancias.add(this);
	}

	public PeliculaImplIterableInstanciasCreadas(String nombre, String nacionalidad,
												 Genero genero, Double presupuesto,
												 Integer año) {
		super(nombre, nacionalidad, genero, presupuesto, año);
		instancias.add(this);
	}

	public static List<Pelicula> getInstancias() {
		return instancias;
	}

	public Pelicula clone() {
		Pelicula copia = super.clone();
		instancias.add(this);
		return copia;
	}
}
