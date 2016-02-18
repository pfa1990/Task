package iterables;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SecuenciaFibonacci implements Iterable<Integer> {

	private Integer fin;

	public SecuenciaFibonacci(Integer n) {
		if (n <= 0)
			throw new IllegalArgumentException();
		
		fin = n;
	}

	public Iterator<Integer> iterator() {
		return new IteradorFibonacci();
	}

	private class IteradorFibonacci implements Iterator<Integer> {

		private Integer siguiente = 1;
		private Integer anterior = 0;

		public boolean hasNext() {
			return siguiente.compareTo(fin) <= 0;
		}

		public Integer next() {
			if (!hasNext())
				throw new NoSuchElementException();
			
			Integer res = siguiente;
			siguiente += anterior;
			anterior = res;
			return res;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
