package utiles;

import java.util.*;

public class Enteros {
	public static Integer maximo(Integer a, Integer b, Integer c) {
		Integer r = 0;
		
		if (a > b)
			r = a;
		else
			r = b;
		
		if (c > r)
			r = c;
		
		return r;
	}

	public static Integer factorial(Integer n) {
		if (n < 0)
			throw new IllegalArgumentException("El factorial de un número "
					+ "negativo no se puede calcular.");
		
		Integer r = 1;
		
		for (int i = 1; i <= n; i++)
			r = r * i;
		
		return r;
	}

	public static Integer sumatorio(Integer a, Integer b, Integer c) {
		Integer r = 0;
		
		for (int i = b; i <= c; i++) {
			if (i % a == 0)
				r += i;
		}
		
		return r;
	}

	public static Boolean esPrimo(Integer n) {
		if (n <= 0)
			throw new IllegalArgumentException("El parámetro debe ser mayor que"
					+ " cero.");
		
		Boolean r = true;
		
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				r = false;
				break;
			}
		}
		
		return r;
	}

	public static Integer[] iniArray(Integer tam) {
		Integer[] a = new Integer[tam];
		
		for (int i = 0; i < tam; i++)
			a[i] = i + 1;
		
		return a;
	}

	public static Double sumaElementos(List<Double> l) {
		Double suma = 0.0;
		
		for (Double elem : l)
			suma += elem;
		
		return suma;
	}

	public static Double media(List<Double> l) {
		return sumaElementos(l) / l.size(); 
	}

	public static Integer[] arrayInverso(Integer[] numeros) {
		Integer[] inverso = new Integer[numeros.length];
		
		for (Integer i = 0; i < numeros.length; i++)
			inverso[i] = numeros[numeros.length - 1 - i];
		
		return inverso;
	}

	public static Integer[] arrayInversoPosicionesPares(Integer[] numeros) {
		Integer[] inverso = new Integer[numeros.length];
		
		for (Integer i = 0; i < numeros.length; i++) {
			if (i % 2 == 0)
				inverso[i] = numeros[numeros.length - 1 - i];
		}
		
		return inverso;
	}

	public static List<Double> listaInversa(List<Double> l) {
		List<Double> inversa = new ArrayList<Double>();

		for (Double elem : l)
			inversa.add(0, elem);
		
		return inversa;
	}

	public static List<Integer> primosMenores(Integer n) {
		List<Integer> l = new ArrayList<Integer>();
		
		for (int i = 2; i < n; i++) {
			if (esPrimo(i))
				l.add(i);
		}
		
		return l;
	}

	public static Integer divisores(Integer n) {
		Integer r = 0;
		
		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				r++;
		}
		
		return r;
	}

	public static Integer sumaDivisores(Integer n) {
		Integer r = 0;
		
		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				r = r + i;
		}
		
		return r;
	}

	public static Integer sumaPrimosHasta(Integer n) {
		Integer r = 0;
		
		for (int i = 2; i < n; i++) {
			if (esPrimo(i))
				r = r + i;
		}
		
		return r;
	}

	public static Double cuadratica(List<Integer> numeros) {
		Double resultado = 0.0;
		
		for (Integer i : numeros)
			resultado += Math.pow(i, 2);
		
		return Math.sqrt(resultado / numeros.size());
	}
}
