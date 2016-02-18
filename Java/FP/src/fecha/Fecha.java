package fecha;

import utiles.Copiable;

public interface Fecha extends Copiable<Fecha>, Comparable<Fecha> {
	Integer getDia();
	Integer getMes();
	Integer getAnio();
	void setDia(Integer d);
	void setMes(Integer m);
	void setAnio(Integer a);
}
