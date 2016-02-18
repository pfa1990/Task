package test;

import polinomioEntero.*;

public class TestPolinomio extends Test {
	public static void main(String[] args) throws GradoNoValidoException {
		Integer v[] = {-9, 0, 0, -6, 0, 7};
		PolinomioEntero pE = new PolinomioEnteroImpl(v);
		
		mostrar(pE);
	}
}
