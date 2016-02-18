package utiles;

import java.util.List;

import predicados.PredicadoVentaCodigoProducto;
import predicados.PredicadoVentaFechaAnterior;
import predicados.PredicadoVentaFechaPosterior;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

import fecha.Fecha;
import funciones.FuncionStringVenta;
import funciones.FuncionVentaPrecio;

import almacen.ComparadorVentaFecha;
import almacen.ComparadorVentaImporte;
import almacen.Venta;

public class Ventas {
	public static List<Venta> creaListaVenta(String fichero) {
		return Lists.newArrayList(
					 Iterables.transform(Iterables2.fromFile(fichero),
					 new FuncionStringVenta()
					 )
				);
	}

	public static Iterable<Venta> agrupaVentas(String fV1, String fV2, String fV3) {
		return Iterables.concat(creaListaVenta(fV1), creaListaVenta(fV2),
								creaListaVenta(fV3));
	}

	public static void salvarVentasOrdenadas(String fichero, Iterable<Venta> ventas) {
		Iterables2.saveToFile(
				Ordering.from(
						new ComparadorVentaFecha()).sortedCopy(ventas),
						fichero);
	}

	public static boolean existeProducto(String codProd, Iterable<Venta> ventas) {
		return Iterables.any(ventas, new PredicadoVentaCodigoProducto(codProd));
	}

	public static boolean sonFechasPosteriores(Fecha fecha, Iterable<Venta> ventas) {
		return Iterables.all(ventas, new PredicadoVentaFechaPosterior(fecha));
	}

	public static Iterable<Venta> ventasEntreFechas(Fecha f1, Fecha f2,
													Iterable<Venta> ventas) {
		return Iterables.filter(ventas, Predicates.and(new PredicadoVentaFechaPosterior(f1),
													   new PredicadoVentaFechaAnterior(f2)));
	}

	public static Double sumaVentas(String codProd, Iterable<Venta> ventas) {
		Iterable<Venta> ventasCod = Iterables.filter(
				ventas, new PredicadoVentaCodigoProducto(codProd));
		
		return Iterables2.sum(ventasCod, new FuncionVentaPrecio());
	}

	public static Venta maximaVenta(Iterable<Venta> ventas) {
		return Ordering.from(new ComparadorVentaImporte()).max(ventas);
	}

	/*public static Venta ventaMayor(Iterable<Venta> ventas, Double importe) {
		return Iterables.find(ventas, new PredicadoVentaImporteMayor(importe));
	}*/
}
