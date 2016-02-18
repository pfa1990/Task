package fp.almacen;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import funciones.FuncionStringProducto;
import utiles.Iterables2;

public class AlmacenImpl implements Almacen {

	private String nombre;
	private List<Producto> productos;
	private Boolean recorreTodos;

	public AlmacenImpl(String n, List<Producto> lp) {
		this.nombre = checkNotNull(n, "Nombre nulo");
		this.productos = checkNotNull(lp, "Lista nula");
		this.recorreTodos = true;
	}

	public String getNombre() {
		return nombre;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = checkNotNull(productos);
	}

	public void setRecorreTodos(Boolean rT) {
		this.recorreTodos = rT;
	}

	public int hashCode() {
		return getNombre().hashCode();
	}

	public boolean equals(Object o) {
		boolean result = false;
		
		if (o instanceof Almacen) {
			Almacen a = (Almacen)o;
			result = getNombre().equals(a.getNombre());
		}
		
		return result;
	}

	public String toString() {
		return getNombre() + " -- " + getProductos();
	}

	public AlmacenImpl(String nombre, String fichero) {
		this.nombre = nombre;
		this.productos = cargaProductos(fichero);
		this.recorreTodos = true;
	}

	public AlmacenImpl(String cad) {
		Iterable<String> trozos = Iterables2.fromString(cad, ",");
		checkArgument(Iterables.size(trozos) != 2, "Formato incorrecto.");
		
		String nuevoNombre = Iterables.get(trozos, 0);
		List<Producto> nuevosProductos = cargaProductos(Iterables.get(trozos, 1));
		
		this.nombre = nuevoNombre;
		this.productos = nuevosProductos;
	}

	private List<Producto> cargaProductos(String nomFich) {
		return Lists.newArrayList(
				Iterables.transform(
						Iterables2.fromFile(nomFich),
						new FuncionStringProducto()
						)
				);
		
	}

	public Iterator<Producto> iterator() {
		Iterator<Producto> it = null;
		
		if (recorreTodos) {
			it = productos.iterator();
		} else {
			// Iterables.filter(productos, type)
		}
		
		return productos.iterator();
	}
}
