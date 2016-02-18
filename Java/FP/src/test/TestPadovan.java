package test;

import iterables.Secuencias;
import iterables.SucesionPadovan;

public class TestPadovan extends Test {
	public static void main(String[] args) {
		SucesionPadovan p = Secuencias.creaSucesionPadovan(38);
		SucesionPadovan p2 = Secuencias.creaSucesionPadovan(25);
		
		for(Integer elem : p)
			mostrar(elem);
		
		System.out.println();
		
		for(Integer elem : p2)
			mostrar(elem);
		
		System.out.println();
		System.out.println("Numero de iteraciones: ");
		mostrar(SucesionPadovan.getNumeroIteraciones());
		System.out.println("Numero Secuencias Padovan: ");
		mostrar(Secuencias.getNumeroSucesionesPadovan());
	}
}
