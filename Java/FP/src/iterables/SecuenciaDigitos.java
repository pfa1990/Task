package iterables;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SecuenciaDigitos implements Iterable<Integer> {

	private Integer numero;

	public SecuenciaDigitos(Integer n) {
		numero = n;
	}

	public Iterator<Integer> iterator() {
		return new IteradorDigitos();
	}

	private class IteradorDigitos implements Iterator<Integer> {

		private Integer digitos;

		public IteradorDigitos() {
			digitos = numero;
		}

		public boolean hasNext() {
			return digitos != 0;
		}

		public Integer next() {
			if (!hasNext())
				throw new NoSuchElementException();
			
			Integer aux = digitos % 10;
			digitos = digitos / 10;
			
			return aux;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
