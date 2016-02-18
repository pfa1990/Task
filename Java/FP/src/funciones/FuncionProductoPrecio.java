package funciones;

import com.google.common.base.Function;

import fp.almacen.Producto;

public class FuncionProductoPrecio implements Function<Producto, Double> {
	public Double apply(Producto p) {
		return p.getPrecio();
	}
}
