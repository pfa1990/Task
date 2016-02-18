package vuelo;

import java.util.Comparator;

public class ComparadorVueloPrecio implements Comparator<Vuelo> {
	public int compare(Vuelo o1, Vuelo o2) {
		int r = o1.getPrecio().compareTo(o2.getPrecio());
		
		if (r == 0) 
			r = o1.compareTo(o2);
		
		return r;
	}
}
