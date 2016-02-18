package test;

import utiles.Encuestas;
import encuesta.Encuesta;
import encuesta.EncuestaImpl;

public class TestEncuesta extends Test {
	public static void main(String[] args) {
		Encuesta e1 = new EncuestaImpl("sdhjffg-", 1000.0, 15, 'h', 20);
		Encuesta e2 = new EncuestaImpl("sjteedf-", 1000.0, 15, 'm', 20);
		
		Encuesta[] e = new Encuesta[2];
		
		e[0] = e1;
		e[1] = e2;
		
		mostrar(e1);
		mostrar(e2);
		
		for(Encuesta enc : Encuestas.anadeCodigo(e, "skldfhsdj"))
			mostrar(enc);
	}
}
