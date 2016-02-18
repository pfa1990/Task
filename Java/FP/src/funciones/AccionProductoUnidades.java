package funciones;

import com.google.common.base.Function;

import fp.almacen.Producto;

public class AccionProductoUnidades implements Function<Producto, Void> {

	private Double porcentaje;

	public AccionProductoUnidades(Double p) {
		porcentaje = p;
	}

	public Void apply(Producto p) {
		p.setStockMinimo((int)(p.getStockMinimo() - ((p.getStockMinimo() *
						 porcentaje) / 100)));
		return null;
	}
}
