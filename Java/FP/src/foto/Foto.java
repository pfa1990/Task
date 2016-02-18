package foto;

import fecha.*;
import persona.*;
import utiles.Copiable;

public interface Foto extends Copiable<Foto> {
	String getTitulo();
	Persona getAutor();
	Fecha getFecha();
	FormatoImagen getFormato();
	Integer getAlto();
	Integer getAncho();
	Double getTamano();
	Double getCalificacion();
	void setCalificacion(Double c);
	Boolean getRetocada();
	void setRetocada(Boolean r);
	Integer getNumVisitas();
	void setNumVisitas(Integer nV);
}
