package predicados;

import pelicula.Pelicula;

import com.google.common.base.Predicate;

public class PredicadoPeliculaPresupuestoMayor implements Predicate<Pelicula> {

	private Double presupuesto;

	public PredicadoPeliculaPresupuestoMayor(Double presupuesto){
		this.presupuesto = presupuesto;
	}

	public boolean apply(Pelicula p) {
		return p.getPresupuesto().compareTo(presupuesto) > 0;
	}
}
