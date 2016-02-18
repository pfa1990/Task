package pelicula;

public class PeliculaImplAlMenosGenero extends PeliculaImpl implements Pelicula {

	private static Boolean uno = false;

	public PeliculaImplAlMenosGenero() {
		super();
	}

	public PeliculaImplAlMenosGenero(String cad) {
		super(cad);
	}

	public PeliculaImplAlMenosGenero(String nombre, String nacionalidad,
									 Genero genero, Double presupuesto,
									 Integer año) {
		super(nombre, nacionalidad, genero, presupuesto, año);
		
		if (genero.equals(Genero.TERROR))
			uno = true;
	}

	public static Boolean alMenosUno() {
		return uno;
	}

	public Pelicula clone() {
		Pelicula copia = super.clone();
		
		if (copia.getGenero().equals(Genero.TERROR))
			uno = true;
		
		return copia;
	}
}
