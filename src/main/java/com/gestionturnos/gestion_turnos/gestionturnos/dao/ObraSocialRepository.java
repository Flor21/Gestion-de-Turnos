package com.gestionturnos.gestion_turnos.gestionturnos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gestionturnos.gestion_turnos.gestionturnos.model.ObraSocial;
import java.util.Optional;

/**
 * 
 * @author flor
 *
 */
public interface ObraSocialRepository extends JpaRepository<ObraSocial, Integer> {
	
	Optional<ObraSocial> findById(Integer idObraSocial);
	/*
	Set<ObraSocial> findByPaciente(Paciente paciente);
	
	Set<ObraSocial> findByMedico(Medico medico);
*/
}
