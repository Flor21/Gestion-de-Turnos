package com.gestionturnos.gestion_turnos.gestionturnos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import com.gestionturnos.gestion_turnos.gestionturnos.model.MedicoObraSocial;


/**
 * 
 * @author flor
 *
 */

@Repository
public interface MedicoObraSocialRepository extends JpaRepository<MedicoObraSocial, Integer>{
	
	List<MedicoObraSocial> findByIdMedico(Integer idMedico);
	List<MedicoObraSocial> findByIdObraSocial(Integer idObraSocial);
					
}