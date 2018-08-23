package com.almundo.callcenter.modelo;

import java.util.Random;
import java.util.concurrent.Callable;

import com.almundo.callcenter.enums.EstadoAtencion;

/**
 * Generalidad de la clase empleados. 
 * @author said.hernandez
 *
 */
public class Empleado  implements Callable<String>{
	
	/** Nombre del empleado. */
	private String nombre; 
	

	/**Estado del empleado*/
	private EstadoAtencion estado; 
	
	private Integer numero; 
	
	private static final int MIN_DURACION_LLAMDA = 5; 
	
	private static final int MAX_DURACION_LLAMDA = 10;
	
	private String mensaje; 


	public Empleado(String nombre, EstadoAtencion estado ) {
		super();
		this.nombre = nombre;
		this.estado = estado; 
	}
	
	@Override
	public String call() throws Exception {
		mensaje = "Atendiendo el numero #" + this.numero + " operador " + this.nombre;
		this.estado = EstadoAtencion.OCAPADO;
		llamadaEnProceso();
		return mensaje;
	} 
	
	/**
	 * 
	 * @param call
	 * @param atendee
	 */
    private void llamadaEnProceso() {
        try {
            Integer duracion = new Random().nextInt((MAX_DURACION_LLAMDA - MIN_DURACION_LLAMDA) + 1) + MAX_DURACION_LLAMDA;
            Thread.sleep(duracion);
            System.out.print("Finalizo la llamada #" + this.numero + " Empleado " + this.nombre + " duracion " + duracion);
            this.estado = EstadoAtencion.LIBRE;
        } catch (InterruptedException e) {
            
        }
    }

	public String getNombre() {
		return nombre;
	}
	

	public EstadoAtencion getEstado() {
		return estado;
	}

	public void setEstado(EstadoAtencion estado) {
		this.estado = estado;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
}
