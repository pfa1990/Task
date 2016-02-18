package pelicula;

import java.util.List;

public interface PeliculaOnline extends Pelicula {
	String getLink();
	void setLink(String l);
	List<Integer> getPuntuaciones();
	Double getPuntuacionMedia();
	void añadirPuntuacion(Integer p);
}
