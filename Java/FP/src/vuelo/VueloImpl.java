package vuelo;

import java.util.ArrayList;
import java.util.List;

import persona.Pasajero;
import fecha.*;

public class VueloImpl implements Vuelo {

	private String codVuelo, destino;
	private Double precio;
	private Integer numPlazas, numPasajeros;
	private Fecha fechaSalida, fechaReserva;
	private List<Pasajero> listaPasajeros;

	public VueloImpl() {
		codVuelo = "";
		destino = "";
		precio = 0.0;
		numPlazas = 0;
		numPasajeros = 0;
		fechaSalida = new FechaImpl();
		fechaReserva = new FechaImpl();
		listaPasajeros = new ArrayList<Pasajero>();
	}

	public VueloImpl(String cV,String d, Double p, Integer nPl, Fecha f,
					 Fecha fR, List<Pasajero> lP) {
		if (lP.size() > nPl)
			throw new IllegalArgumentException("No puede haber mas pasajeros "
					+ "que plazas.");
		if (p < 0)
			throw new IllegalArgumentException("El precio no puede ser menor "
					+ "que 0.");
		
		codVuelo = cV;
		destino = d;
		precio = p;
		numPlazas = nPl;
		numPasajeros = lP.size();
		fechaSalida = f;
		fechaReserva = fR;
		listaPasajeros = lP;
	}

	public String getCodVuelo() {
		return codVuelo;
	}

	public String getDestino() {
		return destino;
	}

	public Double getPrecio() {
		return precio;
	}

	public Integer getNumPlazas() {
		return numPlazas;
	}

	public Integer getNumPasajeros() {
		return listaPasajeros.size();
	}

	public Fecha getFechaSalida() {
		return fechaSalida;
	}

	public void setPrecio(Double p) {
		if (p < 0)
			throw new IllegalArgumentException("El precio no puede ser menor "
					+ "que 0.");
		precio = p;
	}

	public void setNumPasajeros(Integer nP) {
		if (nP > numPlazas)
			throw new IllegalArgumentException("No puede haber mas pasajeros "
					+ "que plazas.");
		numPasajeros = nP;
	}

	public Double getRecaudacion() {
		return getPrecio() * getNumPasajeros();
	}

	public String toString() {
		return getCodVuelo() + " - (" + getDestino() + ") - " + getFechaSalida()
			   + "\nLista de Pasajeros:\n" + listaPasajeros.toString();
	}

	public void setFechaSalida(Fecha f) {
		fechaSalida = f;
	}

	public Fecha getFechaReserva() {
		return fechaReserva;
	}

	public Integer getPorcentajeOcupacion() {
		return (numPasajeros * 100) / numPlazas;
	}

	public List<Pasajero> getListaPasajeros() {
		return listaPasajeros;
	}

	public void anadePasajero(Pasajero p) {
		listaPasajeros.add(p);
	}

	public Vuelo clone() {
		Vuelo copia = null;
		
		try{
			copia = (Vuelo)super.clone();
		}
		catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return copia;
	}

	public int hashCode() {
		return codVuelo.hashCode() * 31;
	}

	public boolean equals(Object o) {
		boolean r = false;
		
		if (o instanceof Vuelo) {
			Vuelo v1 = (Vuelo)o;
			r = this.getCodVuelo().equals(v1.getCodVuelo());
		}
		
		return r;
	}

	public int compareTo(Vuelo v) {
		int r = getCodVuelo().compareTo(v.getCodVuelo());
		return r;
	}
}
