package iterables;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SecuenciaAleatoria implements Iterable<Integer> {

	private Integer min, max, n;

	public SecuenciaAleatoria(Integer min, Integer max, Integer n) {
		if(min >= max || n < 0)
			throw new IllegalArgumentException();
		
		this.min = min;
		this.max = max;
		this.n = n;
		
	}

	public Iterator<Integer> iterator() {
		return new IteradorSecAlea();
	}

	private class IteradorSecAlea implements Iterator<Integer> {

		private Integer contador = 0;

		public boolean hasNext() {
			return contador.compareTo(n) < 0;
		}

		public Integer next() {
			if (!hasNext())
				throw new NoSuchElementException();

			contador++;
			double a = Math.random();
			a = min + a * (max - min + 1);
			return (int)a;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
