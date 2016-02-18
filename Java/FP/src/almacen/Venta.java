package almacen;

import fecha.Fecha;

public interface Venta extends Comparable<Venta> {
	String getCodVenta();
	void setCodVenta(String cod);
	Integer getCodVendedor();
	String getCodCliente();
	String getCodProducto();
	Integer getUnidades();
	Double getPrecioUnidad();
	void setPrecioUnidad(Double p);
	Fecha getFechaVenta();
}
