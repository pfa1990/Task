package persona;

import java.util.List;

import foto.Foto;

public class FotografoImpl extends PersonaImpl implements Fotografo {

	private String agencia;
	private List<Foto> fotos;

	public FotografoImpl(String dni, String nombre, String apellidos,
			Integer edad, Double estatura, Double peso, Genero sexo,
			String agencia, List<Foto> fotos) {
		super(dni, nombre, apellidos, edad, estatura, peso, sexo);
		this.agencia = agencia;
		this.fotos = fotos;
	}

	public String getAgencia() {
		return agencia;
	}

	public List<Foto> getFotos() {
		return fotos;
	}

	public void anadirFoto(Foto f) {
		if (!this.equals(f.getAutor()))
			throw new IllegalArgumentException("El autor de la foto debe ser el"
					+ " mismo fotógrafo.");
		else
			fotos.add(f);
	}

	public String toString() {
		return super.toString() + " - "+ getAgencia() + "(" + getFotos().size()
			   + ")";
	}

	public int hashCode() {
		return super.hashCode() + agencia.hashCode() * 31;
	}
}
