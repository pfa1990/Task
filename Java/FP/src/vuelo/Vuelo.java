package vuelo;

import java.util.List;

import persona.Pasajero;
import utiles.Copiable;

import fecha.*;

public interface Vuelo extends Copiable<Vuelo>, Comparable<Vuelo> {
	String getCodVuelo();
	String getDestino();
	Double getPrecio();
	Integer getNumPlazas();
	Integer getNumPasajeros();
	Fecha getFechaSalida();
	Double getRecaudacion();
	Fecha getFechaReserva();
	Integer getPorcentajeOcupacion();
	List<Pasajero> getListaPasajeros();
	void setPrecio(Double p);
	void setNumPasajeros(Integer nP);
	void setFechaSalida(Fecha f);
	void anadePasajero(Pasajero p);
}
