package funciones;

import com.google.common.base.Function;

import fecha.Fecha;

public class FuncionFechaDia implements Function<Fecha, Integer> {
	public Integer apply(Fecha f) {
		return f.getDia();
	}
}
