package polinomioEntero;

import java.util.List;

public interface PolinomioEntero extends Copiable<PolinomioEntero> {
	void setCoeficientes(List<Integer> l);
	Integer getGrado();
	Integer getCoeficiente(Integer grado);
	void setCoeficiente(Integer grado, Integer nuevoCoeficiente);
	void anadeCoeficiente(Integer coeficiente);
	void sumaCoeficiente(Integer grado, Integer coeficiente);
	void multiplicaCoeficientes(Integer factor);
	void sumaPolinomio(PolinomioEntero p);
	void derivar();
	Double calculaValor(Double x);
}
