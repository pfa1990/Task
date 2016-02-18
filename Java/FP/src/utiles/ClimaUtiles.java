package utiles;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ClimaUtiles {
	public static Integer diferenciaMaxima(String municipio, Map<String,
										   List<Integer>> temperaturas) {
		Integer diferencia = 0;
		
		if (temperaturas.containsKey(municipio))
			diferencia = Collections.max(temperaturas.get(municipio)) -
						 Collections.min(temperaturas.get(municipio));
		
		return diferencia;
	}
}
