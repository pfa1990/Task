package groenlandia;

import java.util.SortedSet;

public interface ClimaGroenlandia {
	void cargaFichero(String nombreFichero);
	Integer temperaturaMinima();
	String municipioConMayorDiferenciaTemperaturas();
	SortedSet<String> municipiosBajo(Integer temp);
}
