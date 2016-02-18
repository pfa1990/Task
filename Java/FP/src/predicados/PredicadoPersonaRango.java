package predicados;

import persona.Persona;

import com.google.common.base.Predicate;

public class PredicadoPersonaRango implements Predicate<Persona> {

	private Integer edadMinima, edadMaxima;

	public PredicadoPersonaRango(Integer min, Integer max) {
		edadMinima = min;
		edadMaxima = max;
	}

	public boolean apply(Persona p) {
		return p.getEdad().compareTo(edadMinima) >= 0 &&
			   p.getEdad().compareTo(edadMaxima) <= 0;
	}
}
