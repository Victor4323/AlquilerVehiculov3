package org.iesalandalus.programacion.alquilervehiculos.vista.texto;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;

public class VistaTexto extends Vista {
	public Vista vista;
	public Controlador controlador;

	@Override
	public void comenzar() throws OperationNotSupportedException {
		Accion op = null;

		do {

			Consola.mostrarMenu();

			op = Consola.elegirOpcion();

			ejecutar(op);

		} while (op != Accion.SALIR);

	}

	@Override
	public void terminar() {
		System.out.println("Finalizado");

	}

	public void setControlador(Controlador controlador) {

		if (controlador == null) {

			throw new NullPointerException("El controlador no puede ser nulo");

		}

		this.controlador = controlador;

	}

	void ejecutar(Accion opcion) throws OperationNotSupportedException {

		switch (opcion) {
		case SALIR:
			terminar();
			break;

		
		case INSERTAR_VEHICULO:
			break;

		case INSERTAR_ALQUILER:			
			break;

		case BUSCAR_CLIENTE:		
			break;

		case BUSCAR_VEHICULO:	
			break;

		case BUSCAR_ALQUILER:
			break;

		case MODIFICAR_CLIENTE:
			break;

		case DEVOLVER_ALQUILER_CLIENTE:
			break;

		case DEVOLVER_ALQUILER_VEHICULO:
			break;

		case BORRAR_CLIENTE:
			break;

		case BORRAR_VEHICULO:
			break;

		case BORRAR_ALQUILER:
			break;

		case LISTAR_CLIENTE:
			break;

		case LISTAR_VEHICULO:
			break;

		case LISTAR_ALQUILERES:
			break;

		case LISTAR_ALQUILERES_CLIENTES:
			break;

		case LISTAR_ALQUILERES_VEHICULO:
			break;

		case MOSTRAR_ESTADITICAS_MESUALES:
			break;

		default:
			

		}

	

}
}