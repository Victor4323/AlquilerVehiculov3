package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;

public abstract class Vehiculo {

	private static String ER_MARCA = ("(^[A-Z][a-z]+)|(^[A-Z][a-z]+\s[A-Z][a-z]+)|(^[A-Z]+)|(^[A-Z][a-z]+-[A-Z][a-z]+)|(^[A-Z][a-z]+[A-Z][a-z]+)");
	private static String ER_MATRICULA = "[0-9]{4}[BCDHJQLMNÑPQSRTWVXYZ]{3}";
	private String marca;
	private String modelo;
	private String matricula;

	protected Vehiculo(String marca, String modelo, int plazas, String matricula) {

	}

	protected Vehiculo(Vehiculo vehiculo) {

	}

	public static Vehiculo getVehiculoConMatricula(String matricula) {
		return new Vehiculo();
	}

	public String getMarca() {
		return marca;
	}

	public Vehiculo getVehiculoConMatricula(Vehiculo vehiculo) {
		Vehiculo vehiculocopiado = null;
		if (vehiculo instanceof Vehiculo) {
			return new Vehiculo();
		}
	}

	public static Vehiculo copiar(Vehiculo vehiculo) {

		Vehiculo vehiculoCopiado = null;

		if (vehiculo instanceof Turismo turismo) {

			vehiculoCopiado = new Turismo(turismo);

		}
		if (vehiculo instanceof Autobus autobus) {

			vehiculoCopiado = new Autobus(autobus);

		}
		if (vehiculo instanceof Furgoneta furgoneta) {

			vehiculoCopiado = new Furgoneta(furgoneta);

		}
		return vehiculoCopiado;
	}

	public String getModelo() {
		return modelo;
	}

	public String getMatricula() {
		return matricula;
	}

	public Vehiculo(Turismo turismo) {
		super();
	}

	public Vehiculo(String marca, String modelo, String matricula) {
		setMarca(marca);
		setModelo(modelo);
		setMatricula(matricula);
	}

	private void setMarca(String marca) {
		if (marca == null) {
			throw new NullPointerException("ERROR: La marca no puede ser nula.");
		}
		if (!marca.matches(ER_MARCA)) {
			throw new IllegalArgumentException("ERROR: La marca no tiene un formato válido.");
		}
		this.marca = marca;
	}

	private void setModelo(String modelo) {
		if (modelo == null) {
			throw new NullPointerException("ERROR: El modelo no puede ser nulo.");
		}
		if (modelo.isBlank()) {
			throw new IllegalArgumentException("ERROR: El modelo no puede estar en blanco.");
		}
		this.modelo = modelo;

	}

	private void setMatricula(String matricula) {
		if (matricula == null) {
			throw new NullPointerException("ERROR: La matrícula no puede ser nula.");
		}
		if (!matricula.matches(ER_MATRICULA)) {
			throw new IllegalArgumentException("ERROR: La matrícula no tiene un formato válido.");
		}
		this.matricula = matricula;
	}

	public abstract int getFactorPrecio();

	@Override
	public int hashCode() {
		return Objects.hash(marca, matricula, modelo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Vehiculo))
			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(marca, other.marca) && Objects.equals(matricula, other.matricula)
				&& Objects.equals(modelo, other.modelo);
	}

}