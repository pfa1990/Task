package predicados;

import persona.Persona;

import com.google.common.base.Predicate;

public class PredicadoPersonaMayorEdad implements Predicate<Persona> {

	private Integer edad;

	public PredicadoPersonaMayorEdad(Integer edad) {
		this.edad = edad;
	}

	public boolean apply(Persona p) {
		return p.getEdad().compareTo(edad) >= 0;
	}
}
