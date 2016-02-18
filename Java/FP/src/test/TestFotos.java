package test;

import java.util.LinkedList;
import java.util.List;

import fecha.*;
import foto.*;

import persona.*;
import utiles.Fotos;

public class TestFotos extends Test {
	public static void main(String[] args) {
		List<Foto> fotos = new LinkedList<Foto>();
		
		Fecha fecha1 = new FechaImpl();
		Fecha fecha2 = new FechaImpl();
		
		Fotografo fotografo1 = new FotografoImpl("15403084-F", "Pedro",
												 "Flores Andújar", 21, 1.75,
												 61.5, Genero.HOMBRE,
												 "agencia3", fotos);
		
		Foto foto1 = new FotoImpl("Sevilla", fotografo1, fecha1,
								  FormatoImagen.BMP, 0, 0, 0, 0.0, 0.0, false);
		Foto foto2 = new FotoImpl("Granada", fotografo1, fecha2,
								  FormatoImagen.GIF, 0, 0, 0, 0.0, 0.0, true);
		Foto foto3 = new FotoImpl("Córdoba", fotografo1, fecha1,
								  FormatoImagen.JPG, 0, 0, 0, 0.0, 0.0, false);
		Foto foto4 = new FotoImpl("Almeria", fotografo1, fecha2,
								  FormatoImagen.BMP, 0, 0, 0, 0.0, 10.0, true);
		
//		fotos.add(foto1);
//		fotos.add(foto2);
//		fotos.add(foto3);
//		fotos.add(foto4);
		
		fotografo1.anadirFoto(foto1);
		fotografo1.anadirFoto(foto2);
		fotografo1.anadirFoto(foto3);
		fotografo1.anadirFoto(foto4);
		
		List<Foto> mejoresFotos = Fotos.fotosConCalificacion(fotos, 10.0);
		mostrar("Hay " + mejoresFotos.size() + " con máxima calificación");
		
		mostrar(Fotos.fotosRetocadas(fotos));
		
		mostrar(fotografo1);
	}
}
