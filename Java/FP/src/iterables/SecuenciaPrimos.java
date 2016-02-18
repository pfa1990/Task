package iterables;

import java.util.Iterator;
import java.util.NoSuchElementException;

import utiles.Enteros;

public class SecuenciaPrimos implements Iterable<Integer> {

	private Integer fin;

	public SecuenciaPrimos(Integer n) {
		fin = n;
	}

	public Iterator<Integer> iterator() {
		return new IteradorPrimos();
	}

	private class IteradorPrimos implements Iterator<Integer> {

		private Integer siguiente;

		public IteradorPrimos() {
			siguiente = 1;
		}

		public boolean hasNext() {
			return siguiente.compareTo(fin) <= 0;
		}

		public Integer next() {
			if (!hasNext())
				throw new NoSuchElementException();
			
			Integer aux = siguiente;
			buscaSiguiente();
			
			return aux;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		public void buscaSiguiente() {
			siguiente++;
			
			while (!Enteros.esPrimo(siguiente))
				siguiente++;
		}
	}
}
