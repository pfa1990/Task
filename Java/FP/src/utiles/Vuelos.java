package utiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import predicados.PredicadoVueloCompleto;
import predicados.PredicadoVueloDestino;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import fecha.Fecha;
import funciones.FuncionDestinoPredicado;

import vuelo.Vuelo;

public class Vuelos {
	public static Vuelo primerVueloDestino(List<Vuelo> l, String destino) {
		Vuelo primero = null;
		
		for (Vuelo v : l) {
			if (v.getDestino().equals(destino)) {
				primero = v;
				break;
			}
		}
		
		return primero;
	}

	public static Double sumaRecaudacionesVuelosCompletos(List<Vuelo> l) {
		Double suma = 0.0;
		
		for (Vuelo elem : l) {
			if (elem.getNumPlazas().equals(elem.getNumPasajeros()))
				suma += elem.getRecaudacion();
		}
		
		return suma;
	}

	public static List<Vuelo> getVuelosDestino(List<Vuelo> l, String destino) {
		List<Vuelo> res = new ArrayList<Vuelo>();
		
		for (Vuelo v : l) {
			if (v.getDestino().equals(destino))
				res.add(v);
		}
		
		return res;
	}

	public static List<Vuelo> seleccionaDestino(List<Vuelo> vuelos,
												String destino) {
		Predicate<Vuelo> pred = new PredicadoVueloDestino(destino);
		
		return Lists.newArrayList(Iterables.filter(vuelos, pred));
	}

	public static Vuelo vueloConMasPlazasDestino(List<Vuelo> l, String destino) {
		Vuelo v1 = null;
		Boolean esPrimero = true;
		
		for (Vuelo v : l) {
			if (v.getDestino().equals(destino)) {
				if (esPrimero) {
					v1 = v;
					esPrimero = false;
				} else {
					if (v.getNumPlazas().compareTo(v1.getNumPlazas()) > 0)
						v1 = v;
				}
			}
		}
		
		return v1;
	}

	public static Vuelo vueloMasBarato(List<Vuelo> l) {
		Vuelo v1 = null;
		Boolean esPrimero = true;
		
		for (Vuelo v : l) {
			if (esPrimero) {
				v1 = v;
				esPrimero = false;
			} else {
				if (v.getPrecio().compareTo(v1.getPrecio()) < 0)
					v1 = v;
			}
		}
		
		return v1;
	}

	public static Integer vuelosDestinoCompletos(List<Vuelo> l, String destino) {
		Integer cont = 0;
		
		for (Vuelo v : l) {
			if (v.getDestino().equals(destino) &&
				v.getNumPlazas().equals(v.getNumPasajeros()))
				cont++;
		}
		
		return cont;
	}

	public static Integer vuelosCompletosDestino(List<Vuelo> vuelos,
												 String destino) {
		Predicate<Vuelo> pred = Predicates.and(
				new PredicadoVueloDestino(destino),
				new PredicadoVueloCompleto());
		
		return Iterables.size(Iterables.filter(vuelos, pred));
	}

	public static Double recaudacionVuelosDestino(List<Vuelo> l, String destino) {
		Double suma = 0.0;
		
		for (Vuelo v : l) {
			if (v.getDestino().equals(destino))
				suma += v.getRecaudacion();
		}
		
		return suma;
	}

	public static Boolean vuelosDestinoPlazasLibres(List<Vuelo> l, String destino) {
		Boolean r = false;
		
		for (Vuelo v : l) {
			if (v.getDestino().equals(destino) &&
				!v.getNumPlazas().equals(v.getNumPasajeros()))
				r = true;
		}
		
		return r;
	}

	public static Boolean vuelosPlazasLibre(List<Vuelo> vuelos, String destino) {
		Predicate<Vuelo> pred = Predicates.and(new PredicadoVueloDestino(destino),
								Predicates.not(new PredicadoVueloCompleto()));
		
		return Iterables.any(vuelos, pred);
	}

	public static List<Vuelo> vuelosDestinosPlazasLibres(List<Vuelo> vuelos,
														 String destino1,
														 String destino2) {
		Predicate<Vuelo> pred = Predicates.and(Predicates.or(
				new PredicadoVueloDestino(destino1),
				new PredicadoVueloDestino(destino2)),
				Predicates.not(new PredicadoVueloCompleto()));
		
		return Lists.newArrayList(Iterables.filter(vuelos, pred));
	}

	public static List<Vuelo> vuelosListaDestinosPlazasLibres(List<Vuelo> vuelos,
															  List<String> destinos) {
//		List<Predicate<Vuelo>> predicados = Lists.newArrayList();
//		
//		for (String destino : destinos)
//			predicados.add(new PredicadoVueloDestino(destino));
		
		Iterable<Predicate<Vuelo>> predicados = Iterables
				.transform(destinos, new FuncionDestinoPredicado());		
		Predicate<Vuelo> pred = Predicates.or(predicados);
		
		return Lists.newArrayList(Iterables.filter(vuelos, pred));
	}

	public static Map<Fecha, List<String>> destinosPorFecha(List<Vuelo> lv) {
		Map<Fecha, List<String>> m = Maps.newHashMap();
		
		for (Vuelo v : lv) {
			Fecha fecha = v.getFechaSalida();
			String destino = v.getDestino();
			
			if (m.containsKey(fecha)) {
				m.get(fecha).add(destino);
			} else {
				List<String> destinos = Lists.newArrayList();
				destinos.add(destino);
				m.put(fecha, destinos);
			}
		}
		
		return m;
	}
}
