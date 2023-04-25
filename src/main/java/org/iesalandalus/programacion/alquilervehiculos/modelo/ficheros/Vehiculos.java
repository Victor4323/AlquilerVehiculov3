package org.iesalandalus.programacion.alquilervehiculos.modelo.ficheros;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.negocio.IVehiculos;

public class Vehiculos implements IVehiculos {
private File FICHERO_VEHICULO;
private String RAIZ;
private String MARCA;
private String MODELO;
private String MATRICULA;
private String CILINDRADA;
private String PLAZAS;
private String PMA;
private String TIPO;
private String TURISMO;
private String AUTOBUS;
private String FURGONETA;

	private List<Turismo> coleccionTurismos;

	public Vehiculos() {
		this.coleccionTurismos = new ArrayList<>();
	}

	@Override
	public List<Turismo> get() {
		return new ArrayList<>(coleccionTurismos);
	}

	@Override
	public int getCantidad() {
		return coleccionTurismos.size();
	}

	@Override
	public void insertar(Turismo turismo) throws OperationNotSupportedException {
		if (turismo == null) {
			throw new NullPointerException("ERROR: No se puede insertar un turismo nulo.");
		}
		if (turismo != null && !coleccionTurismos.contains(turismo)) {
			coleccionTurismos.add(turismo);
		} else {
			throw new OperationNotSupportedException("ERROR: Ya existe un turismo con esa matrícula.");
		}
	}

	@Override
	public Vehiculo buscar(Vehiculo turismo) {
		if (turismo == null) {
			throw new NullPointerException("ERROR: No se puede buscar un turismo nulo.");
		}
		int index = coleccionTurismos.indexOf(turismo);
		if (index != -1) {
			return coleccionTurismos.get(index);
		}
		return null;
	}

	@Override
	public void borrar(Vehiculo turismo) throws OperationNotSupportedException {
		if (turismo == null) {
			throw new NullPointerException("ERROR: No se puede borrar un turismo nulo.");
		}

		if (!coleccionTurismos.contains(turismo)) {
			throw new OperationNotSupportedException("ERROR: No existe ningún turismo con esa matrícula.");
		}
		coleccionTurismos.remove(turismo);
	}
}
