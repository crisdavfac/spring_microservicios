package com.farmacia.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.farmacia.model.Medicamento;
import com.farmacia.service.MedicamentoService;

@RestController
@RequestMapping("/medicamento")
public class MedicamentoController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MedicamentoService service;  
	
	@RequestMapping(value = "/leer/{nombre}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Medicamento> getMedicamento(@PathVariable("nombre") String nombre){
		logger.info("> getNombre [Medicamento]");
		
		Medicamento medicamento = null;
		try {
			medicamento = service.getMedicamentoByName("%"+nombre+"%");
 
			if (medicamento == null) {
				medicamento = new Medicamento();
			}
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<Medicamento>(medicamento, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("< getNombre [Medicamento]");
		return new ResponseEntity<Medicamento>(medicamento, HttpStatus.OK);
	}
	
	
	
	
	
	
}
