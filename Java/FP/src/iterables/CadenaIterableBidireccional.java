package iterables;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CadenaIterableBidireccional implements Iterable<Character> {

	private String cadena;
	private TipoRecorrido tipo;

	public CadenaIterableBidireccional(String palabra) {
		cadena = palabra;
		tipo = TipoRecorrido.NORMAL;
	}

	public void setTipoRecorrido(TipoRecorrido tipo) {
		this.tipo = tipo;
	}

	public Iterator<Character> iterator() {
		Iterator<Character> it = null;
		
		switch (tipo) {
		case NORMAL:
			it = new IteradorCadena();
			break;
		case INVERSO:
			it = new IteradorCadenaInversa();
			break;
		}
		
		return it;
	}

	private class IteradorCadena implements Iterator<Character> {

		private Integer posSig;

		public IteradorCadena() {
			posSig = 0;
		}

		public boolean hasNext() {
			return posSig < cadena.length();
		}

		public Character next() {
			if (!hasNext())
				throw new NoSuchElementException();
			
			Character aux = cadena.charAt(posSig);
			posSig++;
			
			return aux;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	private class IteradorCadenaInversa implements Iterator<Character> {

		private Integer posSig;

		public IteradorCadenaInversa() {
			posSig = cadena.length() - 1;
		}

		public boolean hasNext() {
			return posSig >= 0;
		}

		public Character next() {
			if (!hasNext())
				throw new NoSuchElementException();
			
			Character aux = cadena.charAt(posSig);
			posSig--;
			
			return aux;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
