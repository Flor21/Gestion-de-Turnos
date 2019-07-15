package com.gestionturnos.gestion_turnos.gestionturnos.controllers;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionturnos.gestion_turnos.gestionturnos.dao.MedicoRepository;
import com.gestionturnos.gestion_turnos.gestionturnos.dao.PacienteRepository;
import com.gestionturnos.gestion_turnos.gestionturnos.dao.TurnoRepository;
import com.gestionturnos.gestion_turnos.gestionturnos.model.Medico;
import com.gestionturnos.gestion_turnos.gestionturnos.model.Paciente;
import com.gestionturnos.gestion_turnos.gestionturnos.model.Turno;

/**
 * 
 * @author flor
 *
 */
@RestController
@RequestMapping("/turno")
public class TurnoController {
	
	@Autowired
	private TurnoRepository repository;

	@Autowired
	private MedicoRepository medicoRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@GetMapping()
	public Page<Turno> getPage(Pageable pageable) {
		return repository.findAll(pageable);
	}
	
	@GetMapping("/{idTurno}")
	public ResponseEntity<Turno> findById(@PathVariable Integer idTurno) {
		
		Optional<Turno> opt = repository.findById(idTurno);
		if (opt.isPresent())
			return ResponseEntity.ok(opt.get());
		return ResponseEntity.notFound().build();
	}
	
	
	@GetMapping("/turnos/paciente/{idPaciente}")
	public List<Turno> findByPaciente(@PathVariable Integer idPaciente) {
		
		Paciente pac = pacienteRepository.getOne(idPaciente);
		List<Turno> filtradoPaciente = repository.findByPaciente(pac);

		return filtradoPaciente;
	}

	
	@GetMapping("/turnos/medico/{idMedico}")
	public List<Turno> findByMedico(@PathVariable Integer idMedico) {
		Medico medico = medicoRepository.getOne(idMedico);
		List<Turno> filtradoMedico = repository.findByMedico(medico);

		return filtradoMedico;
	}
	
	@PostMapping()
	public ResponseEntity<Turno> create(@Valid @RequestBody Turno createRequest) {
		
		return ResponseEntity.ok(repository.save(createRequest));
			
	}
	
	@PutMapping()
	public ResponseEntity<Turno> update(@Valid @RequestBody Turno updateRequest) {
		boolean exists = repository.existsById(updateRequest.getIdTurno());
		if (exists) {
			return ResponseEntity.ok(repository.save(updateRequest));
		}
		return ResponseEntity.notFound().build();		
	}
	
	@DeleteMapping("/{idTurno}")
	public ResponseEntity<Turno> delete(@PathVariable Integer idTurno) {
		Optional<Turno> opt = repository.findById(idTurno);
		if (opt.isPresent()) {
			repository.delete(opt.get());
			return ResponseEntity.ok().build();			
		}
		return ResponseEntity.notFound().build();
	}
}
