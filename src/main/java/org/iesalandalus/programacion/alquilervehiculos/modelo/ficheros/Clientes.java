package org.iesalandalus.programacion.alquilervehiculos.modelo.ficheros;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.negocio.IClientes;

public class Clientes implements IClientes {
private File FORMATO_CLIENTES;
private String RAIZ;
private String CLIENTE;
private String NOMBRE;
private String DNI;
private String TELEFONO;

    private List<Cliente> coleccionClientes;

    private Clientes() {
        this.coleccionClientes = new ArrayList<>();
    }

    @Override
	public List<Cliente> get() {
        return new ArrayList<>(this.coleccionClientes);
    }

    @Override
	public int getCantidad() {
        return this.coleccionClientes.size();
    }

    @Override
	public void insertar(Cliente cliente) throws OperationNotSupportedException{
        if (cliente == null) {
            throw new NullPointerException("ERROR: No se puede insertar un cliente nulo.");
        }
        if (cliente != null && !coleccionClientes.contains(cliente)) {
            coleccionClientes.add(cliente);
        }else {
            throw new OperationNotSupportedException("ERROR: Ya existe un cliente con ese DNI.");
        }
    }

    @Override
	public Cliente buscar(Cliente cliente) {
    	if(cliente == null) {
    		throw new NullPointerException("ERROR: No se puede buscar un cliente nulo.");
    	}
        int index = this.coleccionClientes.indexOf(cliente);
        if (index >= 0) {
            return this.coleccionClientes.get(index);
        } else {
            return null;
        }
    }

    @Override
	public void borrar(Cliente cliente) throws OperationNotSupportedException {
        if (cliente==null) {
        	throw new NullPointerException("ERROR: No se puede borrar un cliente nulo.");
        
        }
        if(!coleccionClientes.remove(cliente)) {
        	throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
        }
    }

    @Override
	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
    	if (cliente == null) {
    		throw new NullPointerException("ERROR: No se puede modificar un cliente nulo.");
    	}
        if (this.coleccionClientes.contains(cliente)) {
            if (nombre != null && !nombre.isBlank()) {
                cliente.setNombre(nombre);
            }
            if (telefono != null && !telefono.isBlank()) {
                cliente.setTelefono(telefono);
            }
        } else {
            throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
        }
    }
}