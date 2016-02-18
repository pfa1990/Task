package utiles;

import java.util.Comparator;
import java.util.List;

import com.google.common.collect.Ordering;

import cancion.Cancion;
import cancion.ComparadorCancionAnio;

public class Canciones {
	public static List<Cancion> creaCopiaOrdenadaPorAño (List<Cancion> lista) {
		Comparator<Cancion> cmp = new ComparadorCancionAnio();
		Ordering<Cancion> orden = Ordering.from(cmp);
		
		return orden.sortedCopy(lista);
	}
}
