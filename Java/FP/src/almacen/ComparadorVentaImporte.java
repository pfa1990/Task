package almacen;

import java.util.Comparator;

public class ComparadorVentaImporte implements Comparator<Venta> {
	public int compare(Venta o1, Venta o2) {
		Double p1 = o1.getPrecioUnidad() * o1.getUnidades();
		Double p2 = o2.getPrecioUnidad() * o2.getUnidades();
		return p1.compareTo(p2);
	}
}
