package fp.almacen;

import java.util.List;

public interface Almacen extends Iterable<Producto> {
	void setRecorreTodos(Boolean rT);
	String getNombre();
	List<Producto> getProductos();
	void setProductos(List<Producto> productos);
}
