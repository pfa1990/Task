package utiles;

import java.util.ArrayList;
import java.util.List;

import encuesta.Encuesta;
import encuesta.EncuestaImpl;

public class Encuestas {
	public static List<Encuesta> encuestasDistrito(List<Encuesta> lista,
												   Integer distrito) {
		List<Encuesta> r = new ArrayList<Encuesta>();
		
		for (Encuesta e : lista) {
			if (e.getDistrito().equals(distrito))
				r.add(e);
		}
		
		return r;
	}

	public static List<Encuesta>encuestasEdadMayor(List<Encuesta> lista,
												   Integer edad) {
		List<Encuesta> r = new ArrayList<Encuesta>();
		
		for (Encuesta e : lista) {
			if (e.getEdad().compareTo(edad) > 0)
				r.add(e);
		}
		
		return r;
	}

	public static Encuesta[] anadeCodigo(Encuesta[] array, String cod) {
		Encuesta[] r = new Encuesta[array.length];
		Integer cont = 0;
		
		for (Encuesta e : array) {
			r[cont] = new EncuestaImpl(e.getIdentificador().concat(cod),
									   e.getSalario(), e.getEdad(), e.getGenero(),
									   e.getDistrito());
			cont++;
		}
		
		return r;
	}
}
