package vuelo;

import java.util.Comparator;

public class ComparadorVueloFecha implements Comparator<Vuelo> {
	public int compare(Vuelo o1, Vuelo o2) {
		int r = o1.getFechaSalida().compareTo(o2.getFechaSalida());
		
		if (r == 0)
			r = o1.compareTo(o2);
		
		return r;
	}
}
