package almacen;

import utiles.Iterables2;

import com.google.common.collect.Iterables;

import fecha.Fecha;
import fecha.FechaImpl;

public class VentaImpl implements Venta {

	private String codVenta;
	private String codProducto;
	private String codCliente;
	private Integer codVendedor;
	private Integer unidades;
	private Double precioUnidad;
	private Fecha fechaVenta;

	public VentaImpl(String cv, Integer cvd, String cc,  String cp, Integer u,
					 Double pu, Fecha fv) {
		codVenta = cv;
		codCliente = cc; 
		codProducto = cp;
		codVendedor = cvd;
		unidades = u;
		precioUnidad = pu;
		fechaVenta = fv;
	}

	public VentaImpl(String s) {
		Iterable<String> it = Iterables2.fromString(s, ",");
		
		codVenta = Iterables.get(it, 0);
		codVendedor = new Integer(Iterables.get(it, 1));
		codCliente = Iterables.get(it, 2);
		codProducto = Iterables.get(it, 3);
		unidades = new Integer(Iterables.get(it, 4));
		precioUnidad = new Double(Iterables.get(it, 5));
		fechaVenta = new FechaImpl(Iterables.get(it, 6));
	}

	public String getCodCliente() {
		return codCliente;
	}

	public String getCodProducto() {
		return codProducto;
	}

	public Integer getCodVendedor() {
		return codVendedor;
	}

	public String getCodVenta() {
		return codVenta;
	}

	public void setCodVenta(String cod) {
		codVenta = cod;
	}

	public Double getPrecioUnidad() {
		return precioUnidad;
	}

	public void setPrecioUnidad(Double p) {
		precioUnidad = p;
	}

	public Integer getUnidades() {
		return unidades;
	}

	public Fecha getFechaVenta() {
		return fechaVenta;
	}

	public int compareTo(Venta v) {
		return getCodVenta().compareTo(v.getCodVenta());
	}

	public boolean equals(Object o) {
		boolean result = false;
		
		if (o instanceof Venta)
			result = getCodVenta().equals(((Venta)o).getCodVenta());
		
		return result;
	}

	public int hashCode() {
		return getCodVenta().hashCode();
	}

	public String toString() {
		return getCodVenta() + ", " + getCodVendedor() + ", " + getCodCliente()
			   + ", " + getCodProducto() + ", " + getUnidades() + ", " +
			   getPrecioUnidad() + ", " + getFechaVenta();
	}

	public Venta clone() {
		Venta clon = null;
		
		try {
			clon = (Venta)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return clon;
	}
}
