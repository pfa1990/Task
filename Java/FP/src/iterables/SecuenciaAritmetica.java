package iterables;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SecuenciaAritmetica implements Iterable<Double> {

	private Double ini, fin, incr;

	public SecuenciaAritmetica(Double ini, Double fin, Double incr) {
		if((incr > 0 && ini > fin) || (incr < 0 && ini < fin))
			throw new IllegalArgumentException();
			
		this.ini = ini;
		this.fin = fin;
		this.incr = incr;
	}

	public Iterator<Double> iterator() {
		return new IteradorSecArit(ini);
	}

	private class IteradorSecArit implements Iterator<Double> {

		private Double siguiente;

		public IteradorSecArit(Double n) {
			siguiente = n;
		}

		/*public boolean hasNext() {
			return siguiente.compareTo(fin) <= 0;
		}*/

		public boolean hasNext() {
			boolean res = false;
			
			if (incr > 0.0)
				res = siguiente.compareTo(fin) <= 0;
			else
				res = siguiente.compareTo(fin) >= 0;
				
			return res;
		}

		public Double next() {
			if (!hasNext())
				throw new NoSuchElementException();
				
			Double res = siguiente;
			siguiente += incr;
			return res;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
