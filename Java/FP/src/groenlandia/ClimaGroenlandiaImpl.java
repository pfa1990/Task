package groenlandia;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

import utiles.ClimaUtiles;
import utiles.Iterables2;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class ClimaGroenlandiaImpl implements ClimaGroenlandia {

	Map<String, List<Integer>> temperaturasMunicipios; 

	public ClimaGroenlandiaImpl() {
		temperaturasMunicipios = Maps.newHashMap();
	}

	public void cargaFichero(String nombreFichero) {
		for (String linea : Iterables2.fromFile(nombreFichero))
			trataLinea(linea);
	}

	private void trataLinea(String l) {
		String municipio = "";
		List<Integer> temperaturas = Lists.newArrayList();
		boolean esPrimero = true;
		
		for (String valor : Iterables2.fromString(l, ",")) {
			if (esPrimero) {
				municipio = valor;
				esPrimero = false;
			} else {
				temperaturas.add(new Integer(valor));
			}
		}
		
		cargaEnMap(municipio, temperaturas);
	}

	private void cargaEnMap(String m, List<Integer> temps) {
		if (temperaturasMunicipios.containsKey(m))
			temperaturasMunicipios.get(m).addAll(temps);
		else
			temperaturasMunicipios.put(m, temps);
	}

	public Integer temperaturaMinima() {
		List<Integer> todasTemp = Lists.newArrayList();
		
		for (List<Integer> valores : temperaturasMunicipios.values())
			todasTemp.addAll(valores);
		
		return Collections.min(todasTemp);
	}

	public String municipioConMayorDiferenciaTemperaturas() {
		String municipio = null;
		boolean esPrimero = true;
		
		for (String m : temperaturasMunicipios.keySet()) {
			if (esPrimero) {
				municipio = m;
				esPrimero = false;
			} else if (ClimaUtiles.diferenciaMaxima(m, temperaturasMunicipios)
					   > ClimaUtiles.diferenciaMaxima(municipio,
							   						  temperaturasMunicipios)) {
				municipio = m;
			}
		}
		
		return municipio;
	}

	public SortedSet<String> municipiosBajo(Integer temp) {
		Set<String> municipios = Sets.newTreeSet();
		
		for (String m : temperaturasMunicipios.keySet()) {
			if (Collections.min(temperaturasMunicipios.get(m)) < temp)
				municipios.add(m);
		}
		
		return (SortedSet<String>) municipios;
	}
}
