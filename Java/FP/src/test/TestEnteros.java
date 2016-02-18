package test;

import java.util.Arrays;
import java.util.List;

import utiles.Enteros;

public class TestEnteros extends Test {
	public static void main(String[] args) {
		Integer[] miArray = Enteros.iniArray(10);
		mostrar("El contenido del array es " + Arrays.toString(miArray));
		
		List<Integer> miLista = Enteros.primosMenores(3);
		mostrar("El contenido de la lista es " + miLista);
		
		Integer d = Enteros.divisores(8);
		mostrar(d);
		
		Integer sD = Enteros.sumaDivisores(8);
		mostrar(sD);
		
		Integer sP = Enteros.sumaPrimosHasta(8);
		mostrar(sP);
		
		mostrar(Enteros.cuadratica(miLista));
	}
}
