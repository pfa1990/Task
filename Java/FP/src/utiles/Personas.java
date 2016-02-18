package utiles;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;

import funciones.FuncionPersonaDNI;

import persona.Persona;
import predicados.PredicadoPersonaMayorEdad;
import predicados.PredicadoPersonaRango;

public class Personas {
	public static Double alturaMayor (List<Persona> l) {
		Persona p = null;
		Boolean esPrimero = true;
		
		for (Persona elem : l) {
			if (esPrimero) {
				p = elem;
				esPrimero = false;
			} else {
				if (elem.getEstatura().compareTo(p.getEstatura()) < 0)
					p = elem;
			}
		}
		
		if (p != null)
			return p.getEstatura();
		else
			return null;
	}
	
	public static Boolean todosMayores(Set<Persona> l, Integer edad) {
		Boolean res = true;
		
		for (Persona p : l) {
			if (p.getEdad().compareTo(edad) <= 0) {
				res = false;
				break;
			}
		}
		
		return res;
	}

	public static Boolean TodasMayoresQue(Set<Persona> personas, Integer edad) {
		Predicate<Persona> pred = new PredicadoPersonaMayorEdad(edad);
		
		return Iterables.all(personas,pred);
	}

	public static Double edadMedia(Set<List<Persona>> pers) {
		Double media = 0.0;
		Set<Persona> personas = agrupaATodos(pers);
		
		for (Persona p : personas)
			media += p.getEdad();
		
		return media / personas.size();
	}

	private static Set<Persona> agrupaATodos(Set<List<Persona>> pers) {
		Set<Persona> todas = new HashSet<Persona>();
		
		for (List<Persona> l : pers)
			todas.addAll(l);
		
		return todas;		
	}

	public static List<String> obtenerDNIs(Set<Persona> s) {
		List<String> dnis = new ArrayList<String>();
		
		for (Persona p : s)
			dnis.add(p.getDNI());
		
		return dnis;
	}

	public static SortedMap<String, String> personaDNI(Set<Persona> sp) {
		SortedMap<String, String> m = Maps.newTreeMap();
		
		for (Persona p : sp)
			m.put(p.getApellidos() + ", " + p.getNombre(), p.getDNI());
		
		return m;
	}

	public static String[] dniPersonaRangoEdad(List<Persona> lp, Integer min,
											   Integer max) {
		Iterable<Persona> it = Iterables.filter(lp,
												new PredicadoPersonaRango(min,
																		  max));
		String[] dnis = new String[Iterables.size(it)];
		int i = 0;
		
		for (Persona p : it) {
			dnis[i] = p.getDNI();
			i++;
		}
		
		Iterable<String> it2 = Iterables.transform(it, new FuncionPersonaDNI());
		Iterables.toArray(it2, String.class);
		
		return dnis;
	}

	public static void aplicaAccion(Persona[] personas,
									Function<Persona,Void> func) {
		for (Persona p : personas)
			func.apply(p);
	}

	public static void aplicaAccion(Persona[] personas,
									Function<Persona, Void> func,
									Predicate<Persona> pred) {
		for (Persona p : personas) {
			if (pred.apply(p))
				func.apply(p);
		}
	}
}
