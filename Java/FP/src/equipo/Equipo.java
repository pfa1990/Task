package equipo;

import java.util.List;

import persona.Persona;
import utiles.Copiable;

public interface Equipo extends Copiable<Equipo> {
	String getNombreEquipo();
	void setNombreEquipo(String nE);
	List<Persona> getComponentesEquipo();
	void setComponentesEquipo(List<Persona> cE);
	void anadeComponente(Persona p);
}
