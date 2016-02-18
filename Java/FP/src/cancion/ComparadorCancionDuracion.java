package cancion;

import java.util.Comparator;

public class ComparadorCancionDuracion implements Comparator<Cancion> {
	public int compare(Cancion o1, Cancion o2) {
		int r = o1.getDuracion().compareTo(o2.getDuracion());
		
		if (r == 0)
			r = o1.compareTo(o2);
		
		return r;
	}
}
