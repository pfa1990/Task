package persona;

import java.util.Comparator;

public class ComparatorPersonaSexo3 implements Comparator<Persona> {
	public int compare(Persona o1, Persona o2) {
		int r = o1.getSexo().compareTo(o2.getSexo());
		
		if (r == 0)
			r = o1.compareTo(o2);
		
		return r;
	}
}
