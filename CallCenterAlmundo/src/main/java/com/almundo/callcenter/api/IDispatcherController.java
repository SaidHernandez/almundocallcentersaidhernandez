package com.almundo.callcenter.api;
/**
 * Contrato de la API para realizar las llamadas. 
 * @author said.hernandez
 */
public interface IDispatcherController {
	
	/**
	 * Operación encargada de gestioanar las llamadas
	 * @param numero
	 * @return
	 */
	public String dispatchCall(Integer numero); 

}
