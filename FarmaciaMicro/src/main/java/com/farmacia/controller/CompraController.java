package com.farmacia.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.farmacia.model.Compra;
import com.farmacia.service.CompraService;

@RestController
@RequestMapping("/compra")
public class CompraController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CompraService service;
	
	@RequestMapping(value = "/registrar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> guardarCompra(@RequestBody Compra compra){
		logger.info("> save [Compra]");
		
		Integer resultado = 0;
		try {			
			service.create(compra);			
			resultado = 1;
			
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<Integer>(resultado, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("< save [Compra]");
		return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Compra>> getCompra(){
		logger.info("> get [Compra]");
		
		List<Compra> listCompra = new ArrayList();
		try {
			listCompra = service.findAll(); 
			
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<Compra>>(listCompra, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("< get [Compra]");
		return new ResponseEntity<List<Compra>>(listCompra, HttpStatus.OK);
	}

}
