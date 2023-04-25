package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

public class Turismo extends Vehiculo {
	private int cilindrada;
	private int FACTOR_CILINDRADA;

	public Turismo(String marca, String modelo, String matricula, int cilindrada) {
		super(marca, modelo, matricula);
		this.cilindrada = cilindrada;
	}

	public Turismo(Turismo turismo) {
		super(turismo);
		if (turismo == null) {
			throw new NullPointerException("ERROR: No se puede copiar turismo. ");
		}
		setCilindrada(turismo.cilindrada);
	}


	public int getFactorPrecio() {
		return 0;
	}

	public int getClilindrada() {
		return cilindrada;
	}

	private void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	@Override
	public String toString() {
		return String.format("Turismo cilindrada=%s, FACTOR_CILINDRADA=%s", cilindrada, FACTOR_CILINDRADA);
	}

}