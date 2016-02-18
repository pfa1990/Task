package predicados;

import com.google.common.base.Predicate;

import fp.almacen.Producto;

public class PredicadoProductoStockMenor implements Predicate<Producto> {

	private Integer n;

	public PredicadoProductoStockMenor(Integer n) {
		this.n = n;
	}

	public boolean apply(Producto p) {
		return p.getUnidades().compareTo(n) < 0;
	}
}
