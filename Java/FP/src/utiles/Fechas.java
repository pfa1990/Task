package utiles;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

import fecha.Fecha;

public class Fechas {
	public static Boolean esBisiesto(Fecha f) {
		return f.getAnio() % 400 == 0 || (f.getAnio() % 4 == 0 && f.getAnio() %
			   100 != 0);
	}

	public static Integer diasMes(Fecha f) {
		Integer r = 31;
		
		switch (f.getMes()) {
		case 2:
			if (esBisiesto(f))
				r = 29;
			else
				r = 28;
			
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			r = 30;
			break;
		}
		
		return r;
	}

	public static Integer cuentaDias(Fecha f) {
		Integer r1 = 0;
		
		for (int mes=1; mes <= f.getMes(); mes++) {
			Integer r = 31;
			
			switch (mes) {
			case 2:
				if (esBisiesto(f))
					r = 29;
				else
					r = 28;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				r = 30;
				break;
			}
			
			if (mes == f.getMes())
				r1 += r - (r - f.getDia());
			else
				r1 += r;
		}
		
		return r1;
	}

	public static boolean fechaAnterior(Fecha f1, Fecha f2) {
		boolean r = true;
		
		if (f1.getAnio() > f2.getAnio()) {
			r = false;
		} else if (f1.getMes() > f2.getMes() && f1.getAnio() == f2.getAnio()) {
			r = false;
		} else if (f1.getDia() >= f2.getDia() && f1.getMes() == f2.getMes() &&
				   f1.getAnio() == f2.getAnio()) {
			r = false;
		}
		
		return r;
	}

	public static List<Integer> getDias(Fecha[] fechas) {
		List<Integer> res = Lists.newArrayList();
		
		for (Fecha f : fechas)
			res.add(f.getDia());
		
		return res;
	}

	public static List<Integer> getMeses(Fecha[] fechas) {
		List<Integer> res = Lists.newArrayList();
		
		for (Fecha f : fechas)
			res.add(f.getMes());
		
		return res;
	}

	public static List<Integer> getFuncion(Fecha[] fechas, Function<Fecha,
										   Integer> funcion) {
		List<Integer> res = Lists.newArrayList();
		
		for (Fecha f : fechas)
			res.add(funcion.apply(f));
		
		return res;
	}
}
