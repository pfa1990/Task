package utiles;

public interface Copiable<T> extends Cloneable {
	T clone();
}