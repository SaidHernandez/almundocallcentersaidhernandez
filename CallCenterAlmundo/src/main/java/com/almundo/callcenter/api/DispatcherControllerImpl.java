package com.almundo.callcenter.api;

import javax.ejb.EJB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.almundo.callcenter.delegate.IDispatcherDelgate;


@Controller
@RequestMapping("/dispatcher")
public class DispatcherControllerImpl  implements IDispatcherController {
	
	private static final Logger logger = LoggerFactory.getLogger(DispatcherControllerImpl.class);
	
	@EJB
	IDispatcherDelgate dispatcherDelgate;
	

    /*
     * (non-Javadoc)
     * @see com.almundo.callcenter.api.IDispatcherController#dispatchCall(int)
     */
	@Override
	@RequestMapping(value = "/call", method = RequestMethod.GET)
	public String dispatchCall(@RequestParam(value = "numero") Integer numero) {
		logger.info("Inicio - dispatchCall : # " + numero);
		return dispatcherDelgate.dispatchCall(numero);
	}
	
}
