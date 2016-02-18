package funciones;

import almacen.Venta;

import com.google.common.base.Function;

public class FuncionVentaPrecio implements Function<Venta, Double> {
	public Double apply(Venta v) {
		return v.getPrecioUnidad() * v.getUnidades();
	}
}
