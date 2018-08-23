package com.almundo.callcenter.modelo;

import com.almundo.callcenter.enums.EstadoAtencion;

/**
 * Empleado de tipo operador 
 * 
 * @author said.hernandez
 *
 */
public class Operador extends Empleado {
	
    /**
     * Constructor de la clase
     * @param nombre
     */
	public Operador(String nombre, EstadoAtencion estado) {
		super(nombre, estado);
	}
   
}
