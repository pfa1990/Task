package persona;

import java.util.List;

import foto.Foto;

public interface Fotografo extends Persona {
	String getAgencia();
	List<Foto> getFotos();
	void anadirFoto(Foto f);
}
