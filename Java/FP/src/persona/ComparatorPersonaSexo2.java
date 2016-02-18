package persona;

import java.util.Comparator;

public class ComparatorPersonaSexo2 implements Comparator<Persona> {
	public int compare(Persona o1, Persona o2) {
		int r = o1.getSexo().compareTo(o2.getSexo());
		
		if (r == 0 && !o1.equals(o2))
			r = 1;
		
		return r;
	}
}
