package predicados;

import persona.Persona;

import com.google.common.base.Predicate;

public class PredicadoPersonaMayorDe implements Predicate<Persona> {

	private Integer edad;

	public PredicadoPersonaMayorDe(Integer e) {
		edad = e;
	}

	public boolean apply(Persona p) {
		return p.getEdad().compareTo(edad) > 0;
	}
}
