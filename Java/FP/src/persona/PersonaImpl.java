package persona;

public class PersonaImpl implements Persona {

	private String dni, nombre, apellidos;
	private Integer edad;
	private Double estatura, peso;
	private Genero sexo;

	public PersonaImpl() {
		this.dni = "";
		this.nombre = "";
		this.apellidos = "";
		this.edad = 0;
		this.estatura = 0.0;
		this.peso = 0.0;
		this.sexo = Genero.HOMBRE;
	}

	public PersonaImpl(String dni, String nombre, String apellidos,
			Integer edad, Double estatura, Double peso, Genero sexo) {
		if (edad < 0)
			throw new IllegalArgumentException("La edad no puede ser menor que "
					+ "0.");
		if (estatura < 0)
			throw new IllegalArgumentException("La estatura no puede ser menor "
					+ "que 0.");
		if (peso < 0)
			throw new IllegalArgumentException("El peso no puede ser menor que "
					+ "0.");

		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.estatura = estatura;
		this.peso = peso;
		this.sexo = sexo;
	}

	public String getDNI() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer e) {
		if (e < 0)
			throw new IllegalArgumentException("La edad no puede ser menor que "
					+ "0.");
		
		edad = e;
	}

	public Double getEstatura() {
		return estatura;
	}

	public void setEstatura(Double est) {
		if (est < 0)
			throw new IllegalArgumentException("La estatura no puede ser menor "
					+ "que 0.");
		
		estatura = est;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double p) {
		if (p < 0)
			throw new IllegalArgumentException("El peso no puede ser menor que "
					+ "0.");
		
		peso = p;
	}

	public Genero getSexo() {
		return sexo;
	}

	public String toString() {
		return getDNI() + " - " + getApellidos() + ", " + getNombre();
	}

	public Double getIMC() {
		return peso / (estatura * estatura);
	}

	public Persona clone() {
		Persona copia = null;
		
		try{
			copia = (Persona) super.clone();
		}
		catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return copia;
	}

	public int hashCode() {
		return dni.hashCode() * 31 + nombre.hashCode() * 37 +
			   apellidos.hashCode() * 41;
	}

	public boolean equals (Object o) {
		boolean r = false;
		
		if (o instanceof Persona) {
			Persona p1 = (Persona)o;
			r = this.getDNI().equals(p1.getDNI())&&
				this.getNombre().equals(p1.getNombre())&&
				this.getApellidos().equals(p1.getApellidos());
		}
		
		return r;
	}

	public int compareTo(Persona p) {
		int r = getApellidos().compareTo(p.getApellidos());
		
		if (r==0) {
			r = getNombre().compareTo(p.getNombre());
			if (r==0)
				r = getDNI().compareTo(p.getDNI());
		}
		
		return r;
	}
}
