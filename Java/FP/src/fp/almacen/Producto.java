package fp.almacen;

public interface Producto extends Comparable<Producto> {
	String getIdentificador();
	String getNombre();
	Double getPrecio();
	void setPrecio(Double precio);
	Integer getUnidades();
	void setUnidades(Integer unidades);
	Integer getStockMinimo();
	void setStockMinimo(Integer stockMinimo);
}
