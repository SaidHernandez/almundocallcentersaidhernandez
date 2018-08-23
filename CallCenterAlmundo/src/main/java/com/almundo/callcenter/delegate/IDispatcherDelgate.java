package com.almundo.callcenter.delegate;

import javax.ejb.Local;

/**
 * Contrado donde se declaran los metodos del delegate. 
 * 
 * @author said.hernandez
 *
 */
@Local
public interface IDispatcherDelgate {
	 /**
	  *  Encargado de llamar al servicio para procesar la llamada. 
	  * @param numero
	  * @return estado de la llamada
	  */
	public String dispatchCall(Integer numero);

}
