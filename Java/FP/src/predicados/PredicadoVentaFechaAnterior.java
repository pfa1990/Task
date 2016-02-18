package predicados;

import almacen.Venta;

import com.google.common.base.Predicate;

import fecha.Fecha;

public class PredicadoVentaFechaAnterior implements Predicate<Venta> {

	private Fecha fecha;

	public PredicadoVentaFechaAnterior(Fecha fecha) {
		this.fecha = fecha;
	}

	public boolean apply(Venta v) {
		return v.getFechaVenta().compareTo(fecha) <= 0;
	}
}
