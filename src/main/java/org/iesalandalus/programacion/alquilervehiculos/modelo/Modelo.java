package org.iesalandalus.programacion.alquilervehiculos.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.ficheros.Alquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.ficheros.Clientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.ficheros.Vehiculos;
import org.iesalandalus.programacion.alquilervehiculos.negocio.IAlquileres;
import org.iesalandalus.programacion.alquilervehiculos.negocio.IClientes;
import org.iesalandalus.programacion.alquilervehiculos.negocio.IFuenteDatos;
import org.iesalandalus.programacion.alquilervehiculos.negocio.IVehiculos;

public class Modelo {
	public IClientes clientes;
	public IAlquileres alquileres;
	public IVehiculos vehiculo;
	public IFuenteDatos fuente;

	public Modelo() {
	}

	protected IVehiculos getVehiculo() {
		return vehiculo;
	}

	protected IClientes getClientes() {
		return clientes;
	}

	protected IAlquiler getAlquiler() {
		return alquiler;
	}

	protected IFuenteDatos getFuente() {
		return fuente;
	}

	public void comerzar() {
		clientes = new Clientes();
		turismos = new Vehiculos();
		alquileres = new Alquileres();
	}

	public void terminar() {
		System.out.println("ERROR: El modelo ha finalizado");
	}

	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		clientes.insertar(new Cliente(cliente));
	}

	public void insertar(Vehiculo turismo) throws OperationNotSupportedException {
		turismos.insertar(new Turismo(turismo));
	}

	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede realizar un alquiler nulo.");
		}

		Cliente cliente = buscar(alquiler.getCliente());
		Vehiculo turismo = buscar(alquiler.getTurismo());

		if (cliente == null) {
			throw new OperationNotSupportedException("ERROR: No existe el cliente del alquiler.");
		}

		if (turismo == null) {
			throw new OperationNotSupportedException("ERROR: No existe el turismo del alquiler.");
		}

	}

	public Cliente buscar(Cliente cliente) {
		Cliente clienteBuscado = clientes.buscar(cliente);
		return (clienteBuscado == null) ? null : new Cliente(clienteBuscado);
	}

	public Vehiculo buscar(Vehiculo turismo) {
		Vehiculo turismoBuscado = turismos.buscar(turismo);
		return (turismoBuscado == null) ? null : new Turismo(turismoBuscado);
	}

	public Alquiler buscar(Alquiler alquiler) {
		return new Alquiler(alquileres.buscar(alquiler));
	}

	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
		clientes.modificar(cliente, nombre, telefono);
	}

	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException {
		alquiler = alquileres.buscar(alquiler);

		if (alquiler == null) {
			throw new OperationNotSupportedException("ERROR: No existe el alquiler a devolver.");
		}

		alquiler.devolver(fechaDevolucion);
	}

	public void borrar(Vehiculo turismo) throws OperationNotSupportedException {
		for (Alquiler alquilerAux : alquileres.get(turismo)) {
			borrar(alquilerAux);
		}
		turismos.borrar(turismo);
	}

	public void borrar(Cliente cliente) throws OperationNotSupportedException {
		for (Alquiler alquilerAux : alquileres.get(cliente)) {
			borrar(alquilerAux);
		}
		clientes.borrar(cliente);
	}

	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {
		alquileres.borrar(alquiler);
	}

	public List<Cliente> getClientes() {
		List<Cliente> listaCliente = new ArrayList<>();
		for (Cliente cliente : clientes.get()) {
			listaCliente.add(new Cliente(cliente));
		}
		return listaCliente;
	}

	public List<Turismo> getTurismos() {
		List<Turismo> listaTurismo = new ArrayList<>();
		for (Vehiculo turismo : turismos.get()) {
			listaTurismo.add(new Turismo(turismo));
		}
		return listaTurismo;
	}

	public List<Alquiler> getAlquileres() {
		List<Alquiler> listaAlquiler = new ArrayList<>();
		for (Alquiler alquiler : alquileres.get()) {
			listaAlquiler.add(new Alquiler(alquiler));
		}
		return listaAlquiler;
	}

	public List<Alquiler> getAlquileres(Vehiculo turismo) {
		ArrayList<Alquiler> alquilerArray = new ArrayList<>();
		for (Alquiler alquilerAux : alquileres.get(turismo)) {
			alquilerArray.add(new Alquiler(alquilerAux));
		}
		return alquilerArray;
	}

	public List<Alquiler> getAlquileres(Cliente cliente) {
		ArrayList<Alquiler> alquilerArray = new ArrayList<>();
		for (Alquiler alquilerAux : alquileres.get(cliente)) {
			alquilerArray.add(new Alquiler(alquilerAux));
		}
		return alquilerArray;
	}

}