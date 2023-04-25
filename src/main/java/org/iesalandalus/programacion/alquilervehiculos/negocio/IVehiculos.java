package org.iesalandalus.programacion.alquilervehiculos.negocio;

import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;

public interface IVehiculos {

	List<Turismo> get();

	int getCantidad();

	void insertar(Turismo turismo) throws OperationNotSupportedException;

	Vehiculo buscar(Vehiculo turismo);

	void borrar(Vehiculo turismo) throws OperationNotSupportedException;

}