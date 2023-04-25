package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

public class Autobus extends Vehiculo{
private int FACTOR_PLAZAS = 2;
private int plazas;


public Autobus(String marca, String modelo, String matricula, int plazas) {
	super(marca, modelo, matricula);
	this.plazas = plazas;
}
public Autobus(Autobus autobus) {
	super(autobus);

	if (autobus == null) {
		throw new NullPointerException("ERROR: No es posible copiar un autobus nulo.");
	}

	this.FACTOR_PLAZAS = plazas;
}
public int getPlaza() {
	if (plazas > 6 && plazas <= 100) {
		this.plazas = plazas;
	} else {
		throw new IllegalArgumentException("ERROR: Las plazas no son correctas.");
	}
	return FACTOR_PLAZAS;
}

private void setPlaza(int plaza) {
	this.plazas = plaza;
}
@Override
public int getFactorPrecio() {

	return plazas * FACTOR_PLAZAS;
}


@Override
public String toString() {
	return String.format("%s %s (%d plazas) - %s", getMarca(), getModelo(), plazas, getMatricula());
}

}
