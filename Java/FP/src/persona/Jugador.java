package persona;

public interface Jugador extends Persona {
	String getApodo();
	void setApodo(String a);
	Integer getDorsal();
	void setDorsal(Integer d);
	String getPosicionJuego();
	void setPosicionJuego(String pJ);
}
