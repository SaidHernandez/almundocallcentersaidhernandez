package com.almundo.callcenter.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.almundo.callcenter.delegate.DispatcherDelegateImpl;
import com.almundo.callcenter.enums.EstadoAtencion;
import com.almundo.callcenter.exepciones.BussinesException;
import com.almundo.callcenter.modelo.Director;
import com.almundo.callcenter.modelo.Empleado;
import com.almundo.callcenter.modelo.Operador;
import com.almundo.callcenter.modelo.Supervisor;

/**
 * Servicio para realizar las llamadas
 * 
 * @author said.hernandez
 *
 */
public class DispatcherService{
	
    /**Instancia unica*/
	private static DispatcherService  dispatcherService; 
	
	/** Logger */
	private static final Logger logger = LoggerFactory.getLogger(DispatcherService.class);
	
	private  final String MENSAJE_BUSSINES = "No existen empleados disponibles";
	
	/**Listado de empleados*/
	List<Empleado> lstEmpleados =  new ArrayList<Empleado>(); 
	
	
	private DispatcherService() {
		super();
		setEmpleados(); 
	}
	
	/** Crear los empleados del callcenter.*/
	private void setEmpleados(){
		logger.info("Inicio - setEmpleados");
		for(int i = 0; i < 5; i++){
			Empleado emp = new Operador("Operador " + i, EstadoAtencion.LIBRE); 
			this.lstEmpleados.add(emp); 
		}
		
		for(int i = 0; i < 2; i++){
			Empleado emp = new Supervisor("Supervisor " + i, EstadoAtencion.LIBRE); 
			this.lstEmpleados.add(emp); 
		}
		
		for(int i = 0; i < 3; i++){
			Empleado emp = new Director("Director " + i, EstadoAtencion.LIBRE); 
			this.lstEmpleados.add(emp); 
		}
		logger.info("Fin - setEmpleados");
	}
	
	/**
	 * Encontrar el ampleado disponble segun la jerarquia espeficiada en el requerimeinto 
	 * 
	 * @return empleado disponible
	 */
	public Empleado empleadoDisponible() throws BussinesException {
		logger.info("Inicio - empleadoDisponible");
		Optional<Empleado> opt = lstEmpleados
				.stream()
				.filter(empl -> (empl.getEstado().equals(EstadoAtencion.LIBRE) && empl instanceof Operador))
				.findFirst();
		if (opt.isPresent()) {
			logger.info("Se encontro el operador: " + opt.get().getNombre() + " estado: " + opt.get().getEstado());
			return opt.get();
		}
	
		opt = lstEmpleados
				.stream()
				.filter(empl -> (empl.getEstado().equals(EstadoAtencion.LIBRE) && empl instanceof Supervisor))
				.findFirst();
		if (opt.isPresent()) {
			logger.info("Se encontro el supervisor: " + opt.get().getNombre() + " estado: " + opt.get().getEstado());
			return opt.get();
		} 
		
		opt = lstEmpleados
				.stream()
				.filter(empl -> (empl.getEstado().equals(EstadoAtencion.LIBRE) && empl instanceof Director))
				.findFirst();
		if (opt.isPresent()) {
			logger.info("Se encontro el director: " + opt.get().getNombre() + " estado: " + opt.get().getEstado());
			return opt.get();
		}else {
			throw new BussinesException(MENSAJE_BUSSINES);
		}
	}
    
    /**
     *  Se obtiene una unica instancia del servcio. 
     * @return
     */
    public static DispatcherService getInstance(){
    	if(dispatcherService == null){
    		dispatcherService =  new DispatcherService();
    	}
    	return dispatcherService; 
    }
    
}
