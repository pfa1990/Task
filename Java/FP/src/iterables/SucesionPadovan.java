package iterables;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SucesionPadovan implements Iterable<Integer> {

	private Integer fin;
	private static Integer numeroIteraciones= 0;

	public SucesionPadovan(Integer n) {
		if(n <= 0)
			throw new IllegalArgumentException();
		
		fin = n;
	}

	public SucesionPadovan(String s) {
		fin = new Integer(s);
	}

	public Iterator<Integer> iterator() {
		numeroIteraciones++;
		return new IteradorPadovan();
	}

	public static Integer getNumeroIteraciones() {
		return numeroIteraciones;
	}

	private class IteradorPadovan implements Iterator<Integer> {

		private Integer siguiente = 0;
		private Integer anterior1 = 0;
		private Integer anterior2 = 1;
		private Integer anterior3 = 0;

		public boolean hasNext() {
			return siguiente.compareTo(fin) <= 0;
		}

		public Integer next() {
			if (!hasNext())
				throw new NoSuchElementException();
			
			Integer res = siguiente;
			siguiente = anterior2 + anterior3;
			anterior3 = anterior2;
			anterior2 = anterior1;
			anterior1 = siguiente;
			return res;
		}

		public void remove(){
			throw new UnsupportedOperationException();
		}
	}
}
