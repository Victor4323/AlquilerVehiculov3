package org.iesalandalus.programacion.alquilervehiculos.negocio;

import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;

public interface IClientes {

	List<Cliente> get();
	
	public void comenzar();
	
	public void terminar();
	
	int getCantidad();

	void insertar(Cliente cliente) throws OperationNotSupportedException;

	Cliente buscar(Cliente cliente);

	void borrar(Cliente cliente) throws OperationNotSupportedException;

	void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException;

}