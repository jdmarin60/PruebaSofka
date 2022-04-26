package com.example.apijuegos.Opcion.Infraestructura.errors;

public class BadRequestAlertException extends Exception {

	public static final String ENTIDAD_NO_ENCONTRADO = "Entidad no encontrado";

	public BadRequestAlertException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	 /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
}
