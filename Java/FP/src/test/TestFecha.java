package test;

import utiles.Fechas;
import fecha.*;

public class TestFecha extends Test {
	public static void main(String[] args) {
		try{
			Fecha f1=new FechaImpl (12,11,2004);
			mostrar(f1);
			
			Fecha f2=new FechaImpl (03,07,1995);
			Fecha f3=new FechaImpl (12,11,2003);
			Fecha f4=new FechaImpl (14,02,2002);
			Fecha f5=new FechaImpl (02,07,1995);
			
			System.out.println(Fechas.fechaAnterior(f2, f1));
			System.out.println(Fechas.fechaAnterior(f3, f1));
			System.out.println(Fechas.fechaAnterior(f5, f2));
			System.out.println(Fechas.fechaAnterior(f1, f4));
			
		} catch (IllegalArgumentException e) {
			mostrar("Se ha capturado excepción.");
		}
	}
}
