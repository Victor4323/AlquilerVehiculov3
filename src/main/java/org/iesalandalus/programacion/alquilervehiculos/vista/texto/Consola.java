package org.iesalandalus.programacion.alquilervehiculos.vista.texto;


	import java.time.LocalDate;
	import java.time.format.DateTimeFormatter;
	import java.time.format.DateTimeParseException;

	import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Autobus;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Furgoneta;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.vista.Opcion;
import org.iesalandalus.programacion.utilidades.Entrada;

	public class Consola {


		private static final String PATRON_FECHA = "31/12/2000";
		private static final String PATRON_MES = "12 2000";
		private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		
		private Consola() {
		}

		public static void mostrarCabecera(String mensaje) {
			System.out.println(mensaje);
			StringBuilder rayas = new StringBuilder();
			for (int i = 0; i < mensaje.length(); i++) {
				rayas.append("-");
			}
			System.out.printf("");
		}

		public static void mostrarMenu() {
			mostrarCabecera("GESTION DE ALQUILERES DE VEHICULOS");
			for (Opcion opcion : Opcion.values()) {
				System.out.println(opcion);
			}
			System.out.println("");
		}
		private static String leerCadena(String mensaje) {
			System.out.print(mensaje);

			return Entrada.cadena();
		}
		private static int leerEntero(String mensaje) {
			System.out.print(mensaje);

			return Entrada.entero();
		}

		private static LocalDate leerFecha(String mensaje) {
			System.out.print(mensaje);

			String fechaCadena = Entrada.cadena();

			return LocalDate.parse(fechaCadena, FORMATO_FECHA);

		}

		public static Accion elegirOpcion() {

			int op;

			do {

				op = leerEntero("Elija su opción:");

			} while (op > 18 || op < 0);

			return Accion.values()[op];
		}

		public static Cliente leerCliente() {

			return new Cliente(leerNombre(), leerCadena("Introduzca el dni:"), leerTelefono());

		}

		public static Cliente leerClienteDni() {

			return Cliente.getClienteConDni(leerCadena("Introduzca el dni:"));

		}

		public static String leerNombre() {

			return leerCadena("Introduzca el nombre: ");

		}

		public static String leerTelefono() {

			return leerCadena("Introduzca el telefono: ");

		}

		public static Vehiculo leerVehiculo() {

			Vehiculo vehiculo = null;

			String tipo = leerCadena("Escriba el tipo de vehiculo: ").toLowerCase();

			if (tipo.equals("turismo")) {

				vehiculo = new Turismo(leerCadena("Introduzca marca:"), leerCadena("Introduzca modelo:"),
						leerEntero("Introduzca cilindrada:"), leerCadena("Introduzca matricula:"));

			}

			if (tipo.equals("autobus")) {

				vehiculo = new Autobus(leerCadena("Introduzca marca:"), leerCadena("Introduzca modelo:"),
						leerEntero("Introduzca plazas:"), leerCadena("Introduzca matricula:"));

			}

			if (tipo.equals("furgoneta")) {

				vehiculo = new Furgoneta(leerCadena("Introduzca marca:"), leerCadena("Introduzca modelo:"),
						leerEntero("Introduzca peso máximo autorizado:"), leerEntero("Introduzca plazas:"),
						leerCadena("Introduzca matricula:"));

			}

			return vehiculo;

		}

		public static Vehiculo leerVehiculoMatricula() {

			return Vehiculo.getVehiculoConMatricula(leerCadena("Introduzca matricula:"));

		}

		public static Alquiler leerAlquiler() {

			return new Alquiler(leerClienteDni(), leerVehiculoMatricula(), leerFecha("Introduzca fecha de alquiler:"));

		}

		public static LocalDate leerFechaDevolucion() {

			return leerFecha("Introduzca fecha de devolución:");

		}

		public static LocalDate leerMes() {

			System.out.print("Introduzca el mes deseado (Formato: 01)");

			String mesCadena = Entrada.cadena();

			

			mesCadena = "01/" + mesCadena + "/2023";

			return LocalDate.parse(mesCadena, FORMATO_FECHA);

		}
	}
	