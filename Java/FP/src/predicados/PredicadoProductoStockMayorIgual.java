package predicados;

import com.google.common.base.Predicate;

import fp.almacen.Producto;

public class PredicadoProductoStockMayorIgual implements Predicate<Producto> {

	private Integer n;

	public PredicadoProductoStockMayorIgual(Integer n) {
		this.n = n;
	}

	public boolean apply(Producto p) {
		return p.getUnidades().compareTo(n) >= 0;
	}
}
