package fp.almacen;

import static com.google.common.base.Preconditions.*;

import com.google.common.collect.Iterables;
import utiles.Iterables2;

public class ProductoImpl implements Producto {

	private String identificador;
	private String nombre;
	private Double precio;
	private Integer unidades;
	private Integer stockMinimo;

	public ProductoImpl(String id, String n, Double p, Integer u, Integer s) {
        identificador = checkNotNull(id, "Identificador nulo.");
        nombre = checkNotNull(n, "Nombre nulo.");
        checkArgument(p > 0.0, "Precio menor o igual a 0.");
        checkArgument(u > 0, "Unidades de producto menor o igual a 0.");
        checkArgument(s >= 0, "Stock menor de 0.");
        precio = checkNotNull(p,"Precio Nulo.");
        unidades = checkNotNull(u,"Num. Unidades Nulo.");
        stockMinimo = checkNotNull(s,"Stock Minimo Nulo.");
	}

	public ProductoImpl(String cad) {
		Iterable<String> trozos = Iterables2.fromString(cad, ",");
		checkArgument(Iterables.size(trozos) == 5, "Formato incorrecto.");
		
		String nuevoId = Iterables.get(trozos, 0);
		String nuevoNombre = Iterables.get(trozos, 1);
		Double nuevoPrecio = new Double(Iterables.get(trozos, 2));
		Integer nuevasUnid = new Integer(Iterables.get(trozos, 3));
		Integer nuevoStock = new Integer(Iterables.get(trozos, 4));
		
		checkArgument(nuevoPrecio > 0.0, "Precio menor o igual a 0.");
        checkArgument(nuevasUnid > 0, "Unidades de producto menor o igual a 0.");
        checkArgument(nuevoStock >= 0, "Stock menor de 0.");
		
		this.identificador = nuevoId;
		this.nombre = nuevoNombre;
		this.precio = nuevoPrecio;
		this.unidades = nuevasUnid;
		this.stockMinimo = nuevoStock;
	}

	public String getIdentificador() {
		return identificador;
	}

	public String getNombre() {
		return nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		checkArgument(precio > 0.0, "Precio menor o igual a 0.");
		this.precio = precio;
	}

	public Integer getUnidades() {
		return unidades;
	}

	public void setUnidades(Integer unidades) {
		checkArgument(unidades > 0, "Unidades de producto menor o igual a 0.");
		this.unidades = unidades;
	}

	public Integer getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(Integer stockMinimo) {
		checkArgument(stockMinimo >= 0, "Stock menor de 0.");
		this.stockMinimo = stockMinimo;
	}

	public int compareTo(Producto p) {
		return getIdentificador().compareTo(p.getIdentificador());
	}

	public int hashCode() {
		return getIdentificador().hashCode();
	}

	public boolean equals(Object o) {
		boolean result = false;
		
		if (o instanceof Producto) {
			Producto p = (Producto)o;
			result = getIdentificador().equals(p.getIdentificador());
		}
		
		return result;
	}

	public String toString() {
		return getIdentificador();
	}
}
