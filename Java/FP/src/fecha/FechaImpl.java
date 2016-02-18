package fecha;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Splitter;

public class FechaImpl implements Fecha {

	private Integer dia, mes, anio;
	
	public FechaImpl() {
		dia = 1;
		mes = 1;
		anio = 2000;
	}

	public FechaImpl(Integer d, Integer m, Integer a) {
		if (m <= 0 || m > 12)
			throw new IllegalArgumentException("Un mes no puede tener un valor "
					+ "menor que 0 ó mayor que 12.");
		if (d <= 0 || d > 31)
			throw new IllegalArgumentException("Un dia no puede tener un valor "
					+ "menor que 0 ó mayor que 31.");
		
		dia = d;
		mes = m;
		anio = a;
	}

	public FechaImpl(String cad) {
		Splitter sp = Splitter.on('/').trimResults().omitEmptyStrings();
		List<String> trozos = new ArrayList<String>();
		
		for (String trozo : sp.split(cad))
			trozos.add(trozo);
		
		if (trozos.size() != 3)
			throw new IllegalArgumentException("Formato inválido");
		
		Integer nuevoDia = new Integer(trozos.get(0));
		Integer nuevoMes = new Integer(trozos.get(1));
		Integer nuevoAnyo = new Integer(trozos.get(2));
		
		if (nuevoMes <= 0 || nuevoMes > 12)
			throw new IllegalArgumentException("Un mes no puede tener un valor "
					+ "menor que 0 ó mayor que 12.");
		if (nuevoDia <= 0 || nuevoDia > 31)
			throw new IllegalArgumentException("Un dia no puede tener un valor "
					+ "menor que 0 ó mayor que 31.");
			
		dia = nuevoDia;
		mes = nuevoMes;
		anio = nuevoAnyo;
	}

	public Integer getDia() {
		return dia;
	}

	public Integer getMes() {
		return mes;
	}

	public Integer getAnio() {
		return anio;
	}

	public String toString() {	
		return getDia() + "/" + getMes() + "/" + getAnio();
	}

	public void setDia(Integer d) {
		dia = d;		
	}

	public void setMes(Integer m) {
		mes = m;
	}

	public void setAnio(Integer a) {
		anio = a;
	}

	public Fecha clone() {
		Fecha copia = null;
		
		try{
			copia = (Fecha)super.clone();
		}
		catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return copia;
	}

	public int hashCode() {
		return dia.hashCode() * 31 + mes.hashCode() * 37 + anio.hashCode() * 41;
	}

	public boolean equals(Object o) {
		boolean r = false;
		
		if (o instanceof Fecha) {
			Fecha f1 = (Fecha)o;
			r = this.getDia().equals(f1.getDia()) &&
				this.getMes().equals(f1.getMes()) &&
				this.getAnio().equals(f1.getAnio());
		}
		
		return r;
	}

	public int compareTo(Fecha f) {
		int r = getAnio().compareTo(f.getAnio());
		
		if (r==0) {
			r = getMes().compareTo(f.getMes());
			if (r==0)
				r = getDia().compareTo(f.getDia());
		}
		
		return r;
	}
}
