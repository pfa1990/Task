package persona;

public class PasajeroImpl extends PersonaImpl implements Pasajero {

	private Integer numAsiento;
	private Character letraAsiento;

	public PasajeroImpl() {
		super();
		numAsiento = 0;
		letraAsiento = '-';
	}

	public PasajeroImpl(String dni, String nombre, String apellidos,
			Integer edad, Double estatura, Double peso, Genero sexo,
			Integer numAsiento, Character letraAsiento) {
		super(dni, nombre, apellidos, edad, estatura, peso, sexo);
		this.numAsiento = numAsiento;
		this.letraAsiento = letraAsiento;
	}

	public Integer getNumAsiento() {
		return numAsiento;
	}

	public Character getLetraAsiento() {
		return letraAsiento;
	}

	public String toString() {
		return super.toString() + " - Asiento: " + getNumAsiento() + ", Letra: "
			   + getLetraAsiento();
	}
}
