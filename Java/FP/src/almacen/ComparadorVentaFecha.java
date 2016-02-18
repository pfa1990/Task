package almacen;

import java.util.Comparator;

public class ComparadorVentaFecha implements Comparator<Venta> {
	public int compare(Venta o1, Venta o2) {
		return o1.getFechaVenta().compareTo(o2.getFechaVenta());
	}
}
