package utiles;

import java.util.HashSet;
import java.util.Set;

import persona.Persona;

public class Museos {
	public static Set<Persona> repiten(Set<Persona> anterior, Set<Persona> actual) {
		Set<Persona> interseccion = new HashSet<Persona>(anterior);
		
		interseccion.retainAll(actual);
		
		return interseccion;
	}

	public static Set<Persona> todos(Set<Persona> anterior,	Set<Persona> actual) {
		Set<Persona> union = new HashSet<Persona>(anterior);
		
		union.addAll(actual);
		
		return union;
	}

	public static Set<Persona> nuevos(Set<Persona> anterior, Set<Persona> actual) {
		Set<Persona> resta = new HashSet<Persona>(actual);
		
		resta.addAll(anterior);
		
		return resta;
	}

	public static Set<Persona> espanolYOtro(Set<Persona> espanol,
											Set<Persona> ingles,
											Set<Persona> frances) {
		Set<Persona> espIng = new HashSet<Persona>(espanol);
		espIng.retainAll(ingles);
		
		Set<Persona> espFra = new HashSet<Persona>(espanol);
		espFra.retainAll(frances);
		
		espFra.addAll(espIng);
		
		return espFra;
	}

	public static Set<Persona> alMenosDos(Set<Persona> espanol,
										  Set<Persona> ingles,
										  Set<Persona> frances) {
		Set<Persona> ingFra = new HashSet<Persona>(ingles);
		
		ingFra.retainAll(frances);
		ingFra.addAll(espanolYOtro(espanol, ingles, frances));
		
		return ingFra;
	}

	public static Set<Persona> soloUno(Set<Persona> espanol, Set<Persona> ingles,
									   Set<Persona> frances) {
		Set<Persona> uno = new HashSet<Persona>(espanol);
		
		uno.addAll(frances);
		uno.addAll(ingles);
		uno.remove(alMenosDos(espanol, ingles, frances));
		
		return uno;
	}
}
