package encuesta;

public class EncuestaImpl implements Encuesta {

	private String identificador;
	private Double salario;
	private Integer edad, distrito;
	private Character genero;
	private static final Double FACTOR_RELEVANCIA = 0.15;

	public EncuestaImpl() {
		this.identificador = "";
		this.salario = 0.0;
		this.edad = 0;
		this.genero = ' ';
		this.distrito = 0;
	}

	public EncuestaImpl(String identificador, Double salario, Integer edad,
						Character genero, Integer distrito) {
		if (genero != 'H' || genero != 'M')
			throw new IllegalArgumentException("El valor debe ser 'H' o 'M'.");
		if (distrito <= 0 || distrito <= 21)
			throw new IllegalArgumentException("El valor debe estar entre 1 y "
					+ "20, ambos inclusive.");
		
		this.identificador = identificador;
		this.salario = salario;
		this.edad = edad;
		this.genero = genero;
		this.distrito = distrito;
	}

	public String getIdentificador() {
		return identificador;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double s) {
		this.salario = s;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer e) {
		this.edad = e;
	}

	public Character getGenero() {
		return genero;
	}

	public Integer getDistrito() {
		return distrito;
	}

	public Double relevancia() {
		return getEdad() * FACTOR_RELEVANCIA;
	}

	public boolean equals(Object o) {
		boolean r = false;
		
		if (o instanceof Encuesta) {
			Encuesta e1 = (Encuesta) o;
			if (this.getIdentificador().equals(e1.getIdentificador()))
				r = true;
		}
		
		return r;
	}

	public int hashCode() {
		return identificador.hashCode() * 31;
	}

	public Encuesta clone() {
		Encuesta copia = null;
		
		try{
			copia = (Encuesta)super.clone();
		}
		catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return copia;
	}

	public String toString() {
		return "[" + this.getIdentificador() + "]";
	}
}
