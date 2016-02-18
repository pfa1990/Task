package equipo;

import java.util.List;

import persona.Persona;

public class EquipoImpl implements Equipo {

	private String nombreEquipo;
	private List<Persona> componentesEquipo;

	public EquipoImpl(String nombreEquipo, List<Persona> componentesEquipo) {
		this.nombreEquipo = nombreEquipo;
		this.componentesEquipo = componentesEquipo;
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nE) {
		this.nombreEquipo = nE;
	}

	public List<Persona> getComponentesEquipo() {
		return componentesEquipo;
	}

	public void setComponentesEquipo(List<Persona> cE) {
		this.componentesEquipo = cE;
	}

	public void anadeComponente(Persona p) {
		componentesEquipo.add(p);
	}

	public String toString() {
		return getComponentesEquipo().toString();
	}

	public Equipo clone() {
		Equipo copia = null;
		
		try{
			copia = (Equipo)super.clone();
		}
		catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return copia;
	}

	public int hashCode() {
		return nombreEquipo.hashCode() * 31 + componentesEquipo.hashCode() * 37;
	}

	public boolean equals(Object o) {
		boolean r = false;
		
		if (o instanceof Equipo) {
			Equipo e1 = (Equipo)o;
			r = this.getNombreEquipo().equals(e1.getNombreEquipo()) &&
				this.getComponentesEquipo().equals(e1.getComponentesEquipo());
		}
		
		return r;	
	}
}
