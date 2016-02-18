package persona;

import utiles.Copiable;

public interface Persona extends Copiable<Persona>, Comparable<Persona> {
	String getDNI();
	String getNombre();
	String getApellidos();
	Integer getEdad();
	void setEdad(Integer e);
	Double getEstatura();
	void setEstatura(Double est);
	Double getPeso();
	void setPeso(Double p);
	Genero getSexo();
	Double getIMC();
}
