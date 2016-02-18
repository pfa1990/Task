package utiles;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import persona.Genero;
import persona.Persona;

import libro.Libro;

public class Libros {
	public static List<Libro> buscaPorTitulo(List<Libro> lista, String cadena) {
		List<Libro> res = new ArrayList<Libro>();
		
		for (Libro l : lista) {
			if (l.getTitulo().contains(cadena))
				res.add(l);
		}
		
		return res;
	}

	public static Libro libroMasReciente(List<Libro> lista) {
		Libro res = null;
		
		for (Libro l : lista) {
			if (res == null || l.getFechaEdicion().compareTo(res.getFechaEdicion())
				< 0)
				res = l;
		}
		
		return res;
	}

	public static Double mediaPaginas(Set<Libro> conjunto) {
		Double res = 0.0;
		
		for (Libro l : conjunto)
			res += l.getNumeroPaginas();
		
		return res/conjunto.size();
	}

	public static Set<Libro> librosComunes(Set<Libro> s1, Set<Libro> s2) {
		Set<Libro> comunes = new HashSet<Libro>(s1);
		
		comunes.retainAll(s2);
		
		return comunes;
	}

	public static Set<Libro> ordenaPorAutor(Set<Libro> s1) {
		return null;
	}

	public static List<Persona> autorasLibros(Set<Libro> s1) {
		List<Persona> autoras = new ArrayList<Persona>();
		
		for (Libro l : s1) {
			if (s1 != null && l.getAutor().getSexo().equals(Genero.MUJER))
				autoras.add(l.getAutor());
		}
		
		return autoras;
	}
}
