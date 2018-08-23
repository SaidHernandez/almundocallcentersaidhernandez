package com.almundo.callcenter.modelo;

import com.almundo.callcenter.enums.EstadoAtencion;

/**
 * Empleado de tipo operador 
 * 
 * @author said.hernandez
 *
 */
public class Supervisor extends Empleado{
	

	public Supervisor(String nombre, EstadoAtencion estado) {
		super(nombre, estado);
	}

}
