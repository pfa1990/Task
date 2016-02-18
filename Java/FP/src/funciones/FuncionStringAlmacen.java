package funciones;

import com.google.common.base.Function;

import fp.almacen.Almacen;
import fp.almacen.AlmacenImpl;

public class FuncionStringAlmacen implements Function<String, Almacen> {
	public Almacen apply(String s) {
		return new AlmacenImpl(s);
	}
}
