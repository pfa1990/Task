package iterables;

public class Secuencias {

	private static Integer numeroSecuencias = 0;
	private static Integer numeroSucesionesPadovan = 0;

	public static Integer getNumeroSecuencias() {
		return numeroSecuencias;
	}

	public static SecuenciaDigitos creaSecuenciaDigitos(Integer numero) {
		numeroSecuencias++;
		return new SecuenciaDigitos(numero);
	}

	public static SecuenciaPrimos creaSecuenciaPrimos(Integer fin) {
		numeroSecuencias++;
		return new SecuenciaPrimos(fin);
	}

	public static CadenaIterableBidireccional creaCadenaIterable(String cadena) {
		numeroSecuencias++;
		return new CadenaIterableBidireccional(cadena);
	}

	public static CadenaIterableBidireccional
				  creaCadenaIterableInversa(String cadena) {
		CadenaIterableBidireccional sec = new CadenaIterableBidireccional(cadena);
		
		sec.setTipoRecorrido(TipoRecorrido.INVERSO);
		numeroSecuencias++;
		
		return sec;
	}

	public static SucesionPadovan creaSucesionPadovan(Integer fin) {
		SucesionPadovan suc = new SucesionPadovan(fin);
		
		numeroSucesionesPadovan++;
		
		return suc;
	}

	public static SucesionPadovan creaSucesionPadovan(String cadena) {
		SucesionPadovan suc = new SucesionPadovan(cadena);
		
		numeroSucesionesPadovan++;
		
		return suc;
	}

	public static Integer getNumeroSucesionesPadovan() {
		return numeroSucesionesPadovan;
	}
}
