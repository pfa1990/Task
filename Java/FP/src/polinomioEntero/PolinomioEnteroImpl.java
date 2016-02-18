package polinomioEntero;

import java.util.ArrayList;
import java.util.List;

public class PolinomioEnteroImpl implements PolinomioEntero {

	private List<Integer> coeficientes;

	public PolinomioEnteroImpl() {
		coeficientes = new ArrayList<Integer>();
		coeficientes.add(0);
	}

	public PolinomioEnteroImpl(Integer[] coefs) {
		coeficientes = new ArrayList<Integer>();
		
		for (Integer c : coefs)
			coeficientes.add(c);
		
		eliminaCeros();
	}

	public void setCoeficientes(List<Integer> l) {
		coeficientes = l;
		eliminaCeros();
	}

	public Integer getGrado() {
		return coeficientes.size() - 1;
	}

	public Integer getCoeficiente(Integer grado) {
		gradoNoValido(grado);
		return coeficientes.get(grado);
	}

	public void setCoeficiente(Integer grado, Integer nuevoCoeficiente) {
		gradoNoValido(grado);
		coeficientes.set(grado, nuevoCoeficiente);
		eliminaCeros();
	}

	public void anadeCoeficiente(Integer coeficiente) {
		if (!coeficiente.equals(0))
			coeficientes.add(coeficiente);
	}

	public void sumaCoeficiente(Integer grado, Integer coeficiente) {
		gradoNoValido(grado);
		setCoeficiente(grado, getCoeficiente(grado)+coeficiente);
	}

	public void multiplicaCoeficientes(Integer factor) {
		for (int i = 0; i <= getGrado(); i++)
			setCoeficiente(i, getCoeficiente(i) * factor);
	}

	public void sumaPolinomio(PolinomioEntero p) {
		for (int i = getGrado() + 1; i <= p.getGrado(); i++)
			anadeCoeficiente(p.getCoeficiente(i));
		
		for (int i = 0; i <= getGrado(); i++)
			sumaCoeficiente(i, p.getCoeficiente(i));
	}

	public void derivar() {
		for (int i = 1; i <= getGrado(); i++) {
			Integer nuevoCoef = getCoeficiente(i) * i;
			setCoeficiente(i - 1, nuevoCoef);
		}
		setCoeficiente(getGrado(), 0);
		//coeficientes.remove((int)getGrado());
	}

	public Double calculaValor(Double x) {
		Double valor = 0.0;
		
		for (int i = 0; i <= getGrado(); i++)
			valor = valor + Math.pow(x, i) * getCoeficiente(i);
		
		return valor;
	}

	private void eliminaCeros() {
		for (int i = coeficientes.size() - 1; i >= 0;  i--) {
			if (getCoeficiente(i) != 0)
				break;
			else
				coeficientes.remove(i);
		}
	}

	private void gradoNoValido(Integer grado) {
		if (grado < 0 || grado > getGrado()) {
			try {
				throw new GradoNoValidoException();
			} catch (GradoNoValidoException e) {
				e.printStackTrace();
			}
		}
	}

	public PolinomioEntero clone() {
		PolinomioEntero copia = null;
		
		try{
			copia = (PolinomioEntero)super.clone();
		}
		catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return copia;
	}

	public int hashCode() {
		return coeficientes.hashCode() * 31;
	}

	public boolean equals(Object o) {
		boolean r = false;
		
		if (o instanceof PolinomioEntero) {
			PolinomioEntero p1 = (PolinomioEntero)o;
			r = this.getGrado().equals(p1.getGrado());
			
			if (r) {
				for (int i = 0; i <= getGrado(); i++) {
					r = this.getCoeficiente(i).equals(p1.getCoeficiente(i));
					if (!r) break;
				}
			}
		}
		
		return r;
	}

	public String toString() {
		String s = "";
		
		for (int i = getGrado(); i >= 1; i--) {
			if (i != 1) {
				if (getCoeficiente(i) < 0 && getCoeficiente(i) != 0) {
					s += getCoeficiente(i) + "x^" + i;
				}
				else if (getCoeficiente(i) > 0) {
					s += " + " + getCoeficiente(i) + "x^" + i;
				}
			} else {
				if (getCoeficiente(i) < 0 && getCoeficiente(i) != 0) {
					s += getCoeficiente(i) + "x";
				}
				else if (getCoeficiente(i) > 0) {
					s += "+" + getCoeficiente(i) + "x";
				}
			}
		}
		
		if (getCoeficiente(0) != 0)
			s += getCoeficiente(0);
		
		return s;
	}
}
