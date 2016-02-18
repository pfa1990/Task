package utiles;

import java.util.*;

import foto.*;

public class Fotos {
	public static List<Foto> fotosConCalificacion(List<Foto> l, Double cal) {
		List<Foto> l2 = new ArrayList<Foto>();
		
		for (Foto f:l) {
			if (f.getCalificacion().equals(cal))
				l2.add(f);
		}
		
		return l2;
	}

	public static Foto fotoMasVisitada(List<Foto> l) {
		Foto f = null;
		
		for (Foto elem : l) {
			if (f == null) {
				f = elem;
			} else if (elem.getNumVisitas().compareTo(f.getNumVisitas()) > 0) {
				f = elem;
			}
		}
		
		return f;
	}

	public static Foto fotoMenorVisitada(List<Foto> l) {
		Foto f = null;
		
		for (Foto elem : l) {
			if (f == null) {
				f = elem;
			} else if (elem.getNumVisitas().compareTo(f.getNumVisitas()) < 0) {
				f=elem;
			}
		}
		
		return f;
	}

	public static List<Foto> fotosResolucion(List<Foto> l, Integer[] intervaloAncho,
											 Integer[] intervaloAlto) {
		List<Foto> l2 = new ArrayList<Foto>();
		
		for (Foto f : l) {
			if (f.getAncho() >= intervaloAncho[0] && f.getAncho() <= intervaloAncho[1]
				&& f.getAlto() >= intervaloAlto[0] && f.getAlto() <= intervaloAlto[1])
				l2.add(f);
		}
		
		return l2;
	}

	public static List<Foto> fotosRetocadas(List<Foto> l) {
		List<Foto> l2 = new ArrayList<Foto>();
		
		for (Foto f : l) {
			if (f.getRetocada())
				l2.add(f);
		}
		
		return l2;
	}
}
