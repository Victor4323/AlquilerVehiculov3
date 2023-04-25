package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

public class Furgoneta extends Vehiculo {
	private int FACTOR_PMA = 100;
	private int FACTOR_PLAZAS = 1;
	private int pma;
	private int plazas;

	public Furgoneta(String marca, String modelo, int plazas, String matricula) {
		super (marca, modelo,plazas,matricula);
		setPlazas(plazas);
		setPma(pma);
	}

	public Furgoneta (Furgoneta furgoneta) {
	super(furgoneta);
		
	if (furgoneta == null) {
		throw new NullPointerException("ERROR: No es posible copiar una formula nula.");
	}
	pma = (furgoneta.getPma());
	plazas = (furgoneta.getPlazas());
}

	public int getFactorPrecio() {
		return FACTOR_PLAZAS;
	}

	public int getPma() {
		return pma;
	}

	public int getPlazas() {
		return plazas;
	}

	private void setPma(int pma) {
		this.pma = pma;
	}

	private void setPlazas(int plazas) {
		this.plazas = plazas;
	}

}
