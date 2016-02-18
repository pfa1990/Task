package encuesta;

import utiles.Copiable;

public interface Encuesta extends Copiable<Encuesta> {
	String getIdentificador();
	Double getSalario();
	void setSalario(Double s);
	Integer getEdad();
	void setEdad(Integer e);
	Character getGenero();
	Integer getDistrito();
	Double relevancia();
}
