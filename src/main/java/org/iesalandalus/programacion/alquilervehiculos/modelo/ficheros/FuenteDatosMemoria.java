package org.iesalandalus.programacion.alquilervehiculos.modelo.ficheros;

import org.iesalandalus.programacion.alquilervehiculos.negocio.IFuenteDatos;

public class FuenteDatosMemoria implements IFuenteDatos {
	
@Override
public Clientes crearClientes(Clientes IClientes) {
	return IClientes;
	}
	
	@Override
	public Alquileres crearAlquileres(Alquileres IAlquileres) {
		return IAlquileres;
	}
	
	@Override
	public Clientes crearVehiculos(Clientes IClientes) {
		return IClientes;
	}
}
