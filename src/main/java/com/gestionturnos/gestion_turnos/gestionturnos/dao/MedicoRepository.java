package com.gestionturnos.gestion_turnos.gestionturnos.dao;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestionturnos.gestion_turnos.gestionturnos.model.Medico;
import com.gestionturnos.gestion_turnos.gestionturnos.model.ObraSocial;

/**
 * 
 * @author flor
 *
 */
@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer>{
	
	Optional<Medico> findById(Integer idMedico);
	
	//Set<Medico> findByObraSociales(ObraSocial obraSociales);
	
	//Set<Medico> findByTurno(Turno turnos);
	
	Optional<Medico> findByMatricula(Integer matricula);

	//Set<Medico> findByEspecialidadAndObraSocial(String especialidad, ObraSocial obraSocial);

	Set<Medico> findByEspecialidad(String especialidad);
		
}
