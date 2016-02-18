package funciones;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

import predicados.PredicadoVueloDestino;
import vuelo.Vuelo;

public class FuncionVueloDestinoPredicado implements Function<String, Predicate<Vuelo>>{
	public Predicate<Vuelo> apply(String destino) {
		return new PredicadoVueloDestino(destino);
	}
}
