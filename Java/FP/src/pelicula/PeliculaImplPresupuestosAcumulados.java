package pelicula;

public class PeliculaImplPresupuestosAcumulados extends PeliculaImpl implements Pelicula {

	private static Double presupuestosAcumulados = 0.0;

	public PeliculaImplPresupuestosAcumulados() {
		super();
		presupuestosAcumulados += getPresupuesto();
	}

	public PeliculaImplPresupuestosAcumulados(String cad) {
		super(cad);
		presupuestosAcumulados += getPresupuesto();
	}

	public PeliculaImplPresupuestosAcumulados(String nombre, String nacionalidad,
											  Genero genero, Double presupuesto,
											  Integer año) {
		super(nombre, nacionalidad, genero, presupuesto, año);
		presupuestosAcumulados += getPresupuesto();
	}

	public void setPresupuesto(Double p) {
		super.setPresupuesto(p);
		Double aux = presupuestosAcumulados -= getPresupuesto();
		presupuestosAcumulados += aux + getPresupuesto();
	}

	public static Double valorPresupuestosAcumulados() {
		return presupuestosAcumulados;
	}

	public Pelicula clone() {
		Pelicula copia = super.clone();
		presupuestosAcumulados += getPresupuesto();
		return copia;
	}
}
