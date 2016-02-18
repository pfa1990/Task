package cancion;

public class CancionImpl implements Cancion {

	private String nombre, interprete;
	private Integer duracion, anio, numRep;
	private Genero genero;
	private Double calificacion;
	private Boolean reproducir;

	public CancionImpl() {
		this.nombre = "";
		this.interprete = "";
		this.duracion = 0;
		this.anio = 0;
		this.numRep = 0;
		this.genero = Genero.DESCONOCIDO;
		this.calificacion = 0.0;
		this.reproducir = false;
	}

	public CancionImpl(String nombre, String interprete, Integer duracion,
			Integer anio, Integer numRep, Genero genero, Double calificacion,
			Boolean reproducir) {
		if (duracion <= 0)
			throw new IllegalArgumentException("La duración debe ser mayor o "
					+ "igual que 0.");
		if (numRep <= 0)
			throw new IllegalArgumentException("El número de reproducciones "
					+ "debe ser mayor o igual que 0.");
		if (calificacion < 0 || calificacion > 10)
			throw new IllegalArgumentException("La calificación debe estar "
					+ "comprendida entre 0 y 10.");
		
		this.nombre = nombre;
		this.interprete = interprete;
		this.duracion = duracion;
		this.anio = anio;
		this.numRep = numRep;
		this.genero = genero;
		this.calificacion = calificacion;
		this.reproducir = reproducir;
	}

	public String getNombre() {
		return nombre;
	}

	public String getInterprete() {
		return interprete;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public Integer getAnio() {
		return anio;
	}

	public Genero getGenero() {
		return genero;
	}

	public Integer getNumReprod() {
		return numRep;
	}

	public void setNumReprod(Integer n) {
		if (n <= 0)
			throw new IllegalArgumentException("El número de reproducciones "
					+ "debe ser mayor o igual que 0.");
		numRep = n;
	}

	public Double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Double c) {
		if (c < 0 || c > 10)
			throw new IllegalArgumentException("La calificación debe estar "
					+ "comprendida entre 0 y 10.");
		calificacion = c;
	}

	public Boolean getReproducir() {
		return reproducir;
	}

	public void setReproducir(Boolean r) {
		reproducir = r;
	}

	public String toString() {
		return "[" + getNombre() + ", " + getInterprete()+ "]";
	}

	public String getDuracionMS() {
		return "(" + String.valueOf(duracion / 60) + ":" +
			   String.valueOf(duracion % 60) + ")";
	}

	public Cancion clone() {
		Cancion copia = null;
		
		try{
			copia = (Cancion)super.clone();
		}
		catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return copia;
	}

	public int hashCode() {
		return nombre.hashCode() * 31 + interprete.hashCode() * 37 +
			   anio.hashCode() * 41;
	}

	public boolean equals(Object o) {
		boolean r = false;
		
		if (o instanceof Cancion) {
			Cancion c1 = (Cancion)o;
			r = this.getNombre().equals(c1.getNombre()) &&
				this.getInterprete().equals(c1.getInterprete()) &&
				this.getAnio().equals(c1.getAnio());	
		}
		
		return r;
		
	}

	public int compareTo(Cancion c) {
		int r = getNombre().compareTo(c.getNombre());
		
		if (r == 0) {
			r = getInterprete().compareTo(c.getInterprete());
			if (r == 0)
				r = getAnio().compareTo(c.getAnio());
		}
		
		return r;
	}
}
