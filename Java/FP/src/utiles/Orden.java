package utiles;

import java.util.Comparator;

public class Orden {
	public static <T extends Comparable<T>> T min(T o1, T o2) {
		if (o1.compareTo(o2) < 0)
			return o1;
		else
			return o2;
	}

	public static <T> T min(T o1, T o2, Comparator<T> cmp) {
		if (cmp.compare(o1,o2) < 0)
			return o1;
		else
			return o2;
	}

	public static <T extends Comparable<T>> void ordenarMin(T[] array,
		Comparator<T> cmp) {
		T temp;
		int n = array.length;
		
		for (int i = 1; i < n; i++) {
			for (int j = n - 1; j >= i; j--) {
				T min;
				if (cmp == null)
					min = min(array[j], array[j - 1]);
				else
					min = min(array[j], array[j - 1], cmp);
				
				if (min.equals(array[j])) {
					temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
		}
	}

	public static <T extends Comparable<T>> T max(T o1, T o2) {
		if (o1.compareTo(o2) > 0)
			return o1;
		else
			return o2;
	}

	public static <T> T max(T o1, T o2, Comparator<T> cmp) {
		if (cmp.compare(o1,o2) > 0)
			return o1;
		else
			return o2;
	}

	public static <T extends Comparable<T>> void ordenarMax(T[] array,
		Comparator<T> cmp) {
		T temp;
		int n = array.length;
		
		for (int i = 1; i < n; i++) {
			for (int j = n - 1; j >= i; j--) {
				T max;
				if (cmp == null)
					max = max(array[j], array[j - 1]);
				else
					max = max(array[j], array[j - 1], cmp);
				
				if (max.equals(array[j])) {
					temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
		}
	}
}
