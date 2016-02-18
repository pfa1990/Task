package segmento;

import punto3D.*;
import utiles.Copiable;

public interface Segmento extends Copiable<Segmento> {
	Punto3D getExtremo1();
	Punto3D getExtremo2();
	void setExtremo1(Punto3D e1);
	void setExtremo2(Punto3D e2);
	Double longitud();
}
