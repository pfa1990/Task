package utiles;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

import funciones.FuncionPeliculaNacionalidad;
import funciones.FuncionPeliculaTituloNacionalidad;
import pelicula.ComparadorPeliculaAño;
import pelicula.Pelicula;
import pelicula.PeliculaOnline;
import predicados.PredicadoPeliculaNacionalidad;
import predicados.PredicadoPeliculaPresupuestoMayor;

public class Peliculas {
	public static Pelicula masPresupuesto(Set<Pelicula> s) {
		Pelicula res = null;
		
		for (Pelicula p : s) {
			if (p == null || p.getPresupuesto().compareTo(res.getPresupuesto())
				> 0)
				res = p;
		}
		
		return res;
	}

	public static Boolean hayNacionalidad(Set<Pelicula> s, String nac) {
		Boolean res = false;
		
		for (Pelicula p : s) {
			if (p.getNacionalidad().equals(nac)) {
				res = true;
				break;
			}
		}
		
		return res;
	}

	public static Boolean hayNacionalidad_guava(Set<Pelicula> s,
												String nacionalidad) {
		return Iterables.any(s, new PredicadoPeliculaNacionalidad(nacionalidad));
	}

	public static SortedSet<Pelicula> hayNacionalidades(Set<Pelicula> s,
														String nac1, String nac2) {
		return Sets.newTreeSet(Iterables.filter(s,
				Predicates.or(new PredicadoPeliculaNacionalidad(nac1),
							  new PredicadoPeliculaNacionalidad(nac2))));
	}

	public static SortedSet<Pelicula> hayNacionalidadLista(
			Set<Pelicula> s, List<String> nacionalidades) {
		Iterable<Predicate<Pelicula>> predicados = Iterables.transform(nacionalidades, new FuncionPeliculaNacionalidad());		
		Predicate<Pelicula> pred = Predicates.or(predicados);
		
		return Sets.newTreeSet(Iterables.filter(s, pred));
	}

	public static SortedSet<Pelicula> grandesProducciones(List<Pelicula> lista,
														  Double dinero) {
		Comparator<Pelicula> cmp = new ComparadorPeliculaAño();
		SortedSet<Pelicula> res = new TreeSet<Pelicula>(cmp);
		
		for (Pelicula e : lista) {
			if (e.getPresupuesto().compareTo(dinero) > 0)
				res.add(e);
		}
		
		return res;
	}

	public static SortedSet<Pelicula> grandesProducciones_guava(
			List<Pelicula> lista, Double presupuesto) {
		return Sets.newTreeSet(Iterables.filter(lista,
				new PredicadoPeliculaPresupuestoMayor(presupuesto)));
	}

	public static String[] arrayTitulosOrdenado(List<Pelicula> l) {
		String[] res = new String[l.size()];
		
		for (int i = 0; i < l.size(); i++) {
			Pelicula p = l.get(i);
			res[i] = p.getNombre() + " - " + p.getNacionalidad();
		}
		
		Arrays.sort(res);
		
		return res;
	}

	public static String[] arrayTitulosOrdenado_Funcion(List<Pelicula> l) {
		String[] res = new String[l.size()];
		Function<Pelicula, String> func = new FuncionPeliculaTituloNacionalidad();
		
		for (int i = 0; i < l.size(); i++)
			res[i] = func.apply(l.get(i));
		
		Arrays.sort(res);
		
		return res;
	}

	public static Set<Pelicula> candidatas3(Set<Pelicula> s1, Set<Pelicula> s2,
											Set<Pelicula> s3) {
		Set<Pelicula> candidatas = new HashSet<Pelicula>(s1);
		
		candidatas.retainAll(s2);
		candidatas.retainAll(s3);
		
		return candidatas;
	}

	public static String peliculaConMas10(List<PeliculaOnline> peliculas) {
		String res = "";
		int contRes = 0;		
		
		for (PeliculaOnline pO : peliculas) {
			int cont = 0;
			
			for (int i = 0; i < pO.getPuntuaciones().size(); i++) {
				if (pO.getPuntuaciones().get(i).equals(10))
					cont++;
			}
			
			if (contRes < cont) {
				contRes = cont;
				res = pO.getNombre();
			}
		}
		
		return res;
	}
}
