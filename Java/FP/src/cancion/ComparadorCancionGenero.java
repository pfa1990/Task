package cancion;

import java.util.Comparator;

public class ComparadorCancionGenero implements Comparator<Cancion> {
	public int compare(Cancion o1, Cancion o2) {
		int r = o1.getGenero().compareTo(o2.getGenero());
		
		if (r == 0)
			r = o1.compareTo(o2);
		
		return r;
	}
}
