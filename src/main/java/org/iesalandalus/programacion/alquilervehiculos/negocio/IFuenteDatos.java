package org.iesalandalus.programacion.alquilervehiculos.negocio;

import org.iesalandalus.programacion.alquilervehiculos.modelo.ficheros.Alquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.ficheros.Clientes;

public interface IFuenteDatos {

	Clientes crearClientes(Clientes IClientes);

	Alquileres crearAlquileres(Alquileres IAlquileres);

	Clientes crearVehiculos(Clientes IClientes);

}