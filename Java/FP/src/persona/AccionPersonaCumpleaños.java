package persona;

import com.google.common.base.Function;

public class AccionPersonaCumpleaños implements Function<Persona, Void> {
	public Void apply(Persona p) {
		p.setEdad(p.getEdad() + 1);
		return null;
	}
}
