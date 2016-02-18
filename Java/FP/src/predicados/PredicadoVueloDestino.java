package predicados;

import vuelo.Vuelo;

import com.google.common.base.Predicate;

public class PredicadoVueloDestino implements Predicate<Vuelo> {

	private String destino;

	public PredicadoVueloDestino(String destino) {
		this.destino = destino;
	}

	public boolean apply(Vuelo v) {
		return v.getDestino().equals(destino);
	}
}
