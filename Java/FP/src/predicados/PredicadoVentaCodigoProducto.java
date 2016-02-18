package predicados;

import almacen.Venta;

import com.google.common.base.Predicate;

public class PredicadoVentaCodigoProducto implements Predicate<Venta> {

	private String codProd;

	public PredicadoVentaCodigoProducto(String codProd) {
		this.codProd = codProd;
	}

	public boolean apply(Venta v) {
		return v.getCodProducto().equals(codProd);
	}
}
