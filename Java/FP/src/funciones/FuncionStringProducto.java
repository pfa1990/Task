package funciones;

import com.google.common.base.Function;

import fp.almacen.Producto;
import fp.almacen.ProductoImpl;

public class FuncionStringProducto implements Function<String, Producto> {
	public Producto apply(String s) {
		return new ProductoImpl(s);
	}
}
