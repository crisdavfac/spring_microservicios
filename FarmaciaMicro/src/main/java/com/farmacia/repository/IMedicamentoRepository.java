package com.farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.farmacia.model.Medicamento;

 @Repository
public interface IMedicamentoRepository extends JpaRepository<Medicamento, Integer> {
	
	@Query("from medicamento m where upper(m.nombre) like upper(:nombre) ")
	Medicamento getMedicamentoByName(@Param("nombre")String nombre)throws Exception;

}
