package cancion;

import java.util.Comparator;

public class ComparadorCancionInterprete implements Comparator<Cancion> {
	public int compare(Cancion o1, Cancion o2) {
		int r = o1.getInterprete().compareTo(o2.getInterprete());
		
		if (r == 0)
			r = o1.compareTo(o2);
		
		return r;
	}
}
