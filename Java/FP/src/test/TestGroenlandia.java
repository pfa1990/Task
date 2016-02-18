package test;

import java.io.File;

import groenlandia.ClimaGroenlandia;
import groenlandia.ClimaGroenlandiaImpl;

public class TestGroenlandia extends Test {
	
	private static final String SEP = File.separator;
	
	public static void main(String[] args) {
		/*String archivoDatos = "." + SEP + "resources" + SEP
		+ "registrosTemperaturas.txt";*/
		String archivoDatos = "C:" + SEP + "Users" + SEP + "Admin" + SEP +
							  "workspace" + SEP + "Practicas" + SEP + "src" +
							  SEP + "groenlandia" + SEP + "resources" + SEP +
							  "registrosTemperaturas.txt";
		ClimaGroenlandia ecg = new ClimaGroenlandiaImpl();
		
		ecg.cargaFichero(archivoDatos);
		mostrar("Temperatura mínima: " + ecg.temperaturaMinima());
		mostrar("Municipio con mayor diferencia de temperaturas: "
		+ ecg.municipioConMayorDiferenciaTemperaturas());
		
		Integer tempMin = -35;
		
		mostrar("Municipios que han alcanzado menos de " + tempMin
		+ " grados: " + ecg.municipiosBajo(tempMin));
		/*mostrar("Municipios con temperaturas ordenadas " +
		"ascendentemente:\n" + ecg.temperaturasMunicipios());*/
	}
}
