package predicados;

import vuelo.Vuelo;

import com.google.common.base.Predicate;

public class PredicadoVueloCompleto implements Predicate<Vuelo> {
	public boolean apply(Vuelo v) {
		return v.getPorcentajeOcupacion().equals(100);
	}
}
