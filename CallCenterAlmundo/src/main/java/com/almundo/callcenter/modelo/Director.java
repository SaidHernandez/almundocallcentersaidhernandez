package com.almundo.callcenter.modelo;

import com.almundo.callcenter.enums.EstadoAtencion;

/**
 * Empleado de tipo Director
 * 
 * @author said.hernandez
 */
public class Director extends Empleado {
	

	/**
	 * Constructor de la clase
	 * @param nombre
	 */
	public Director(String nombre, EstadoAtencion estado) {
		super(nombre, estado);
	}

}
