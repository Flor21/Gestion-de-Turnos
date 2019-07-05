package com.gestionturnos.gestion_turnos.gestionturnos.dao;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestionturnos.gestion_turnos.gestionturnos.model.ObraSocial;
import com.gestionturnos.gestion_turnos.gestionturnos.model.Paciente;
import com.gestionturnos.gestion_turnos.gestionturnos.model.Turno;

/**
 * 
 * @author flor
 *
 */
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
	
	Optional<Paciente> findById(Integer idPaciente);

	Optional<Paciente> findByDni(Integer dni);
	
	Set<Paciente> findByObraSocial(ObraSocial obraSocial);

	List<Paciente> findByIdPaciente(Integer idPaciente);

	
}
