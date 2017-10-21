package com.farmacia.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.farmacia.model.Farmacia;
import com.farmacia.model.Medicamento;
import com.farmacia.service.FarmaciaService;
import com.farmacia.service.MedicamentoService;

@RestController
@RequestMapping("/farmacia")
public class FarmaciaController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private FarmaciaService farmaciaService;
	
	@Autowired
	private MedicamentoService medicamentoService;  
	
	@RequestMapping(value = "/listar/{nombre}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Farmacia>> getFarmaciaByMedicamento(@PathVariable("nombre") String nombreMedicamento){
		logger.info("> get [Farmacia]");
		
		Medicamento medicamento = null;
		List<Farmacia> listFarmacia = new ArrayList();
		try {
			
			medicamento = medicamentoService.getMedicamentoByName("%"+nombreMedicamento+"%");
			if(medicamento != null) {
				
				listFarmacia = farmaciaService.getFarmaciaByIdMedicamento(medicamento.getId());
			} 
			
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<Farmacia>>(listFarmacia, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("< get [Farmacia]");
		return new ResponseEntity<List<Farmacia>>(listFarmacia, HttpStatus.OK);
	}
	
	
}
