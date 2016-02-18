package persona;

import java.util.Comparator;

public class ComparatorPersonaSexo1 implements Comparator<Persona> {
	public int compare(Persona o1, Persona o2) {
		return o1.getSexo().compareTo(o2.getSexo());
	}
}
