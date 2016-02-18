package pelicula;

public class PeliculaImplNumeroInstancias extends PeliculaImpl implements Pelicula {

	private static Integer numeroInstancias = 0;

	public PeliculaImplNumeroInstancias() {
		super();
		numeroInstancias++;
	}

	public PeliculaImplNumeroInstancias(String cad) {
		super(cad);
		numeroInstancias++;
	}

	public PeliculaImplNumeroInstancias(String nombre, String nacionalidad,
										Genero genero, Double presupuesto,
										Integer año) {
		super(nombre, nacionalidad, genero, presupuesto, año);
		numeroInstancias++;
	}

	public static Integer getNumeroInstancias() {
		return numeroInstancias;
	}

	public Pelicula clone() {
		Pelicula copia = super.clone();
		numeroInstancias++;
		return copia;
	}
}
