package utiles;

import java.util.List;

import predicados.PredicadoHayRuido;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class Reales {
	public static Double mediaAritmetica(List<Double> l) {
		Double suma = 0.0;
		
		for (Double elem : l)
			suma += elem;
		
		return suma / l.size();
	}

	public static Double desvEst(List<Double> l) {
		Double media = mediaAritmetica(l);
		Double des = 0.0;
		
		for (Double elem : l)
			des += (elem - media) * (elem - media);
		
		return Math.sqrt(des / (l.size() - 1));
	}

	public static Double maximo(List<Double> l) {
		Double res = null;
		Boolean esPrimero = true;
		
		for (Double elem : l) {
			if (esPrimero) {
				res = elem;
				esPrimero = false;
			} else {
				if (elem.compareTo(res) > 0)
					res = elem;
			}
		}
		
		return res;
	}

	public static Double minimo (List<Double> l) {
		Double res = null;
		Boolean esPrimero = true;
		
		for (Double elem : l) {
			if (esPrimero) {
				res = elem;
				esPrimero = false;
			} else {
				if (elem.compareTo(res) < 0)
					res = elem;
			}
		}
		
		return res;
	}

	public static Boolean hayRuido(List<Double> datos, Double umbral) {
		Boolean ruido = false;
		
		for (Double elem : datos) {
			if (elem.compareTo(umbral) > 0 || elem.compareTo(-umbral) < 0) {
				ruido = true;
				break;
			}
		}
		
		return ruido;
	}

	public static Boolean hayRudio_guava(List<Double> datos, Double umbral) {
		Predicate<Double> pred = new PredicadoHayRuido(umbral);
		Boolean ruido = false;
		
		for (Double elem : datos) {
			if (pred.apply(elem)) {
				ruido = true;
				break;
			}
		}
		
		return ruido;
		
	}

	public static Boolean hayRudio_guava_v2(List<Double> datos, Double umbral) {
		Predicate<Double> pred = new PredicadoHayRuido(umbral);
		
		return Iterables.any(datos, pred);
	}
}
