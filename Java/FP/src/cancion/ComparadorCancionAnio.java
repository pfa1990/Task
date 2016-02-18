package cancion;

import java.util.Comparator;

public class ComparadorCancionAnio implements Comparator<Cancion> {
	public int compare(Cancion o1, Cancion o2) {
		int r = o1.getAnio().compareTo(o2.getAnio());
		
		if (r == 0)
			r = o1.compareTo(o2);
		
		return r;
	}
}
