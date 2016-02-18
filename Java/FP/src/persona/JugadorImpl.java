package persona;

public class JugadorImpl extends PersonaImpl implements Jugador {

	private String apodo, posicionJuego;
	private Integer dorsal;

	public JugadorImpl() {
		super();
		this.apodo = "";
		this.posicionJuego = "";
		this.dorsal = 0;
	}

	public JugadorImpl(String dni, String nombre, String apellidos,
			Integer edad, Double estatura, Double peso, Genero sexo, 
			String apodo, String posicionJuego, Integer dorsal) {
		super(dni, nombre, apellidos, edad, estatura, peso, sexo);
		this.apodo = apodo;
		this.posicionJuego = posicionJuego;
		this.dorsal = dorsal;
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String a) {
		apodo = a;
	}

	public Integer getDorsal() {
		return dorsal;
	}

	public void setDorsal(Integer d) {
		dorsal = d;
	}

	public String getPosicionJuego() {
		return posicionJuego;
	}

	public void setPosicionJuego(String pJ) {
		posicionJuego = pJ;
	}

	public String toString() {
		return super.toString() + " - Dorsal: " + getDorsal() + ", Apodo: " +
			   getApodo();
	}
}
