package pelicula;

import java.util.ArrayList;
import java.util.List;

public class PeliculaOnlineImpl extends PeliculaImpl implements PeliculaOnline {

	private String link;
	private List<Integer> puntuaciones;

	public PeliculaOnlineImpl(String nombre, String nacionalidad, Genero genero,
							  Double presupuesto, Integer año, String link) {
		super(nombre, nacionalidad, genero,	presupuesto, año);
		this.link = link;
		this.puntuaciones = new ArrayList<Integer>();
	}

	public String getLink() {
		return link;
	}

	public void setLink(String l) {
		this.link = l;
	}

	public List<Integer> getPuntuaciones() {
		return puntuaciones;
	}

	public Double getPuntuacionMedia() {
		return null;
	}

	public void añadirPuntuacion(Integer p) {
		if (p == null || p < 0 || p > 10)
			throw new IllegalArgumentException("La puntuación no está comprendida"
					+ " entre 0 y 10");
		
		getPuntuaciones().add(p);
	}
}
