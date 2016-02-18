package persona;

public class ArbitroImpl extends PersonaImpl implements Arbitro {

	private String posArbitro;

	public ArbitroImpl() {
		super();
		posArbitro = "Principal";
	}

	public ArbitroImpl(String dni, String nombre, String apellidos,
			Integer edad, Double estatura, Double peso, Genero sexo,
			String posArbitro) {
		super(dni, nombre, apellidos, edad, estatura, peso, sexo);
		this.posArbitro = posArbitro;			
	}

	public String getPosicionArbitro() {
		return posArbitro;
	}

	public void setPosicionArbitro(String pA) {
		posArbitro = pA;
	}

	public String toString() {
		return super.toString() + " - Posición Arbitro: " + getPosicionArbitro();
	}
}
