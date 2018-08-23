package com.almundo.callcenter.delegate;

import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.almundo.callcenter.exepciones.BussinesException;
import com.almundo.callcenter.modelo.Empleado;
import com.almundo.callcenter.service.DispatcherService;

/**
 * Delegate encargado de procesar las transacciones 
 * @author said.hernandez
 *
 */
@Stateless
public class DispatcherDelegateImpl implements IDispatcherDelgate {
	
	/** Logger */
	private static final Logger logger = LoggerFactory.getLogger(DispatcherDelegateImpl.class);
	
	/**Servicio*/
	DispatcherService dispatcherService;
	
	public DispatcherDelegateImpl(){
		
	}
    /*
     * (non-Javadoc)
     * @see com.almundo.callcenter.delegate.IDispatcherDelgate#dispatchCall(java.lang.Integer)
     */
	public String dispatchCall(Integer numero){
		logger.info("Inicio - dispatchCall: # "+numero );
		dispatcherService = DispatcherService.getInstance();
		String mensaje = "";
		try {
			Empleado empleado = dispatcherService.empleadoDisponible();
			empleado.setNumero(numero);
			mensaje = empleado.call();
		} catch (BussinesException be ) {
			logger.error("Se ha presentado el siguiente error de negocio : " + be);
			mensaje = be.getMessage();
		}catch (Exception e) {
			logger.error("Se ha presentado el siguiente error de tecnico : " + e);
			mensaje = "Se ha presentado un error técnico al procesar la petición";
		}
		logger.info("Fin - dispatchCall");
		return mensaje;
	}

}
