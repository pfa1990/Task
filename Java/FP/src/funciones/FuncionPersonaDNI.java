package funciones;

import persona.Persona;

import com.google.common.base.Function;

public class FuncionPersonaDNI implements Function<Persona, String> {
	public String apply(Persona p) {
		return p.getDNI();
	}
}
