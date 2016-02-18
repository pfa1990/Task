package test;

import java.util.List;

import pelicula.Genero;
import pelicula.Pelicula;
import pelicula.PeliculaImpl;
import pelicula.PeliculaImplIterableInstanciasCreadas;
import pelicula.PresupuestoNegativoException;

public class TestPelicula extends Test {
	public static void main(String[] args) {
		Pelicula p1 = new PeliculaImpl("Peli", "Española", Genero.COMEDIA,
									   1500.0, 2012);
		mostrar(p1);
		
		Pelicula p2 = p1.clone();
		mostrar(p1.equals(p2));
		
		Pelicula p3 = p1;
		mostrar((p1.equals(p3) && p1 == p3));
		
//		try{
//			p1.setPresupuesto(-50.0);
//		}
//		catch(PresupuestoNegativoException e){
//			e.printStackTrace();
//		}
		
		PeliculaImplIterableInstanciasCreadas pi1 = new PeliculaImplIterableInstanciasCreadas();
		PeliculaImplIterableInstanciasCreadas pi2 = new PeliculaImplIterableInstanciasCreadas();
		PeliculaImplIterableInstanciasCreadas pi3 = new PeliculaImplIterableInstanciasCreadas();
		PeliculaImplIterableInstanciasCreadas pi4 = new PeliculaImplIterableInstanciasCreadas();
		PeliculaImplIterableInstanciasCreadas pi5 = new PeliculaImplIterableInstanciasCreadas();
		
		List<Pelicula> pelis = PeliculaImplIterableInstanciasCreadas.getInstancias();
		
		System.out.println(pelis);
	}
}
