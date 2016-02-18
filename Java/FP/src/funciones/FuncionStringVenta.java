package funciones;

import almacen.Venta;
import almacen.VentaImpl;

import com.google.common.base.Function;

public class FuncionStringVenta implements Function<String, Venta> {
	public Venta apply(String s) {
		return new VentaImpl(s);
	}
}
