package pelicula;

import java.util.Comparator;

public class ComparadorPeliculaAño implements Comparator<Pelicula> {
	public int compare(Pelicula p1, Pelicula p2) {
		int res = p1.getAño().compareTo(p2.getAño());
		
		// Imprescindible el desempate para que no colapsen los objetos
		if (res == 0)
			res = p1.compareTo(p2);
		
		return res;
	}
}
