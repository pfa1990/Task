package iterables;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SecuenciaGeometrica implements Iterable<Double> {

	private Double ini, fin, incr;

	public SecuenciaGeometrica(Double ini, Double fin, Double incr) {
		if((incr > 0 && ini > fin) || (incr < 0 && ini < fin))
			throw new IllegalArgumentException();
		
		this.ini = ini;
		this.fin = fin;
		this.incr = incr;
	}

	public Iterator<Double> iterator() {
		return new IteradorSecGeom(ini);
	}

	private class IteradorSecGeom implements Iterator<Double> {

		private Double siguiente;

		public IteradorSecGeom(Double n) {
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
			siguiente = siguiente * incr;
			return res;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
