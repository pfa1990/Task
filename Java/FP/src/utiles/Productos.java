package utiles;

import java.util.List;
import java.util.Set;

import predicados.PredicadoProductoStockMayorIgual;
import predicados.PredicadoProductoStockMenor;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;

import fp.almacen.Almacen;
import fp.almacen.Producto;
import funciones.AccionProductoUnidades;
import funciones.FuncionProductoPrecio;
import funciones.FuncionStringAlmacen;

public class Productos {
	public static Set<Almacen> cargaAlmacenes(String fichero) {
		Preconditions.checkNotNull(fichero);
		
		return Sets.newHashSet(Iterables.transform(Iterables2.fromFile(fichero),
												   new FuncionStringAlmacen()));
	}

	public static void disminuyeUnidades(List<Producto> productos, Integer unidades,
										 Double porcentaje) {
		Iterables2.modify(
				Iterables.filter(
						productos,
						new PredicadoProductoStockMenor(unidades)
						),
						new AccionProductoUnidades(porcentaje)
				);
	}

	public static List<Double> ordenaProductosPrecio(List<Producto> productos,
													 Integer unidades) {
		Ordering<Double> orden = Ordering.natural().reverse();
		
		return orden.sortedCopy(Iterables.transform(Iterables.filter(
				productos,
				new PredicadoProductoStockMayorIgual(unidades)),
				new FuncionProductoPrecio()));
	}
}
