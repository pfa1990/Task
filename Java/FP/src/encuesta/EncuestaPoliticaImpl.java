package encuesta;

public class EncuestaPoliticaImpl extends EncuestaImpl implements EncuestaPolitica {

	private Boolean afiliado;
	private String voto;

	public EncuestaPoliticaImpl(){
		super();
		this.afiliado = false;
		this.voto = "";
	}

	public EncuestaPoliticaImpl(String identificador, Double salario,
								Integer edad, Character genero, Integer distrito,
								Boolean afiliado, String voto){
		super(identificador, salario, edad, genero, distrito);
		this.afiliado = afiliado;
		this.voto = voto;
	}

	public Boolean getAfiliado() {
		return afiliado;
	}

	public String getVoto() {
		return voto;
	}
}
