package pelicula;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

public class PeliculaImpl implements Pelicula {

	private String nombre, nacionalidad;
	private Genero genero;
	private Double presupuesto;
	private Integer año;

	public PeliculaImpl() {
		this.nombre = "";
		this.nacionalidad = "";
		this.genero = Genero.INDEFINIDO;
		this.presupuesto = 0.0;
		this.año = 1895;
	}

	public PeliculaImpl(String nombre, String nacionalidad, Genero genero,
						Double presupuesto, Integer año) {
		if (año < 1895)
			throw new IllegalArgumentException("Solo se permiten fechas "
					+ "posteriores a 1894");
		if (presupuesto < 0.0)
			throw new PresupuestoNegativoException("Solo se permiten "
					+ "presupuestos positivos o cero");
		
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.genero = genero;
		this.presupuesto = presupuesto;
		this.año = año;
	}

	public PeliculaImpl(String cad) {
		this();
		Splitter sp = Splitter.on(CharMatcher.anyOf("()"))
					  .trimResults()
					  .omitEmptyStrings();
		List<String> trozos = new ArrayList<String>();
		
		for(String trozo : sp.split(cad))
			trozos.add(trozo);
		
		if (trozos.size() != 2)
			throw new IllegalArgumentException("Formato inválido");
		
		String nuevoNombre = trozos.get(0);
		Integer nuevoAño = new Integer(trozos.get(1));
		
		if (nuevoAño < 1895)
			throw new IllegalArgumentException("Solo se permiten fechas "
					+ "posteriores a 1894");
		
		this.nombre = nuevoNombre;
		this.año = nuevoAño;
		
	}

	public String getNombre() {
		return nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public Genero getGenero() {
		return genero;
	}

	public Double getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(Double p) {
		if (p < 0.0)
			throw new PresupuestoNegativoException("Solo se permiten "
					+ "presupuestos positivos o cero");
		
		this.presupuesto = p;
	}

	public Integer getAño() {
		return año;
	}

	public int hashCode() {
		return nombre.hashCode() * 31 + año.hashCode() * 37;
	}

	public int compareTo(Pelicula p) {
		int r = getNombre().compareTo(p.getNombre());
		
		if (r == 0)
			r = getAño().compareTo(p.getAño());
		
		return r;
	}

	public boolean equals(Object o) {
		boolean r = false;
		
		if (o instanceof Pelicula) {
			Pelicula p1 = (Pelicula) o;
			r = this.getNombre().equals(p1.getNombre()) &&
				this.getAño().equals(p1.getAño());
		}
		
		return r;
	}

	public Pelicula clone() {
		Pelicula copia = null;
		
		try{
			copia = (Pelicula)super.clone();
		}
		catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return copia;
	}

	public String toString() {
		return getNombre() + " (" + getAño() + ")";
	}
}
