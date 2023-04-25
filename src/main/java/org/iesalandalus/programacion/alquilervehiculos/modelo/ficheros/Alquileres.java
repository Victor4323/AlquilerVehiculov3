package org.iesalandalus.programacion.alquilervehiculos.modelo.ficheros;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.negocio.IAlquileres;
public class Alquileres implements IAlquileres {
private File FICHERO_ALQUILERES;
private DateTimeFormatter FORMATO_FECHA;
private String RAIZ;
private String ALQUILER;
private String CLIENTE;
private String VEHICULO;
private String FECHA_ALQUILER;
private String FECHA_DEVOLUCION;

	     List<Alquiler> coleccionAlquileres;

	    public Alquileres() {
	        this.coleccionAlquileres = new ArrayList<>();
	    }

	    @Override
		public List<Alquiler> get() {
	        return new ArrayList<>(this.coleccionAlquileres);
	    }

	    @Override
		public List<Alquiler> get(Vehiculo vehiculo) {
	        List<Alquiler> alquileresTurismo = new ArrayList<>();
	        for (Alquiler alquiler : this.coleccionAlquileres) {
	            if (alquiler.getVehiculo().equals(vehiculo)) {
	                alquileresTurismo.add(alquiler);
	            }
	        }
	        return alquileresTurismo;
	    }

	    @Override
		public List<Alquiler> get(Cliente cliente) {
	        List<Alquiler> alquileresCliente = new ArrayList<>();
	        for (Alquiler alquiler : this.coleccionAlquileres) {
	            if (alquiler.getCliente().equals(cliente)) {
	                alquileresCliente.add(alquiler);
	            }
	        }
	        return alquileresCliente;
	    }

	    @Override
		public int getCantidad() {
	        return this.coleccionAlquileres.size();
	    }

	    @Override
		public boolean comprobarAlquiler(Alquiler alquiler) {
	        if (alquiler == null || coleccionAlquileres.contains(alquiler)) {
	            return false;
	        }
	        for (Alquiler a : coleccionAlquileres) {
	            if (a.getCliente().equals(alquiler.getCliente()) && a.getFechaDevolucion() == null) {
	                return false;
	            }
	            if (a.getTurismo().equals(alquiler.getTurismo()) && a.getFechaDevolucion() == null) {
	                return false;
	            }
	            if (a.getCliente().equals(alquiler.getCliente()) && a.getTurismo().equals(alquiler.getTurismo())
	                    && a.getFechaAlquiler().isBefore(alquiler.getFechaDevolucion())
	                    && (a.getFechaDevolucion() == null || a.getFechaDevolucion().isAfter(alquiler.getFechaAlquiler()))) {
	                return false;
	            }
	        }
	        return true;
	    }

	    @Override
		public void insertar(Alquiler alquiler) throws Exception {
	        if (!comprobarAlquiler(alquiler)) {
	            coleccionAlquileres.add(alquiler);
	        }else {
	        	throw new Exception("ERROR: No se puede insertar el alquiler");
	        }

	    }
	    

	    @Override
		public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException {
	        if (alquiler == null) {
	            throw new NullPointerException("ERROR: No se puede devolver un alquiler nulo.");
	        }

	        if (buscar(alquiler) == null) {
	            throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual.");
	        }
	        alquiler.devolver(fechaDevolucion);
	    }
	    private getAlquilerAbierto (Cliente cliente,) {
	    	
	    }
	    @Override
		public Alquiler buscar(Alquiler alquiler) {
	        if (alquiler == null) {
	        	throw new NullPointerException("ERROR: No se puede buscar un alquiler nulo.");
	        	}
	        	int indice = coleccionAlquileres.indexOf(alquiler);
	     
	        return (indice == -1) ? null : coleccionAlquileres.get(indice);
	    }
	    @Override
		public void borrar(Alquiler alquiler) throws OperationNotSupportedException {
	    	if(alquiler == null) {
	    		throw new NullPointerException("ERROR: No se puede devolver un alquiler nulo.");
	    	}
	    	if (buscar(alquiler) == null) {
	    		throw new OperationNotSupportedException("ERROR; No exisiste ningún alquiler igual.");
	    	}
	    	coleccionAlquileres.remove(alquiler);
	    }
	    }
	