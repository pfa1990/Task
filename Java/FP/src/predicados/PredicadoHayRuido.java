package predicados;

import com.google.common.base.Predicate;

public class PredicadoHayRuido implements Predicate<Double> {

	private Double umbral;

	public PredicadoHayRuido(Double umbral) {
		this.umbral = umbral;
	}

	public boolean apply(Double d) {
		return d<-Math.abs(umbral) || d>Math.abs(umbral);
	}
}
