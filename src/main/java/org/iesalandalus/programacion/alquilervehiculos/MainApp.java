package org.iesalandalus.programacion.alquilervehiculos;

import org.iesalandalus.programacion.alquilervehiculos.modelo.Modelo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.ModeloCascada;

public class MainApp {

	public static void main(String[] args) {
		Modelo modelo = new ModeloCascada(FactoriaFuenteDatos.FICHEROS);
		Vista vista = FactoriaVista.TEXTO.crear();
		Controlador controlador = new Controlador(modelo, vista);
		controlador.comenzar();
	}

}
