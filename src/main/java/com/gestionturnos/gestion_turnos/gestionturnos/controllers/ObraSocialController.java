package com.gestionturnos.gestion_turnos.gestionturnos.controllers;

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

import com.gestionturnos.gestion_turnos.gestionturnos.dao.ObraSocialRepository;
import com.gestionturnos.gestion_turnos.gestionturnos.model.ObraSocial;

/**
 * 
 * @author flor
 *
 */
@RestController
@RequestMapping("/obraSocial")
public class ObraSocialController {

	@Autowired
	private ObraSocialRepository repository;
/*	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private MedicoRepository medicoRepository;
	*/
	@GetMapping()
	public Page<ObraSocial> getPage(Pageable pageable) {
		return repository.findAll(pageable);
	}
	
	@GetMapping("/{idObraSocial}")
	public ResponseEntity<ObraSocial> findById(@PathVariable Integer idObraSocial) {
		Optional<ObraSocial> opt = repository.findById(idObraSocial);
		if (opt.isPresent())
			return ResponseEntity.ok(opt.get());
		return ResponseEntity.notFound().build();
	}
	/*
	@GetMapping("/paciente/{idPaciente}")
	public ResponseEntity<Set<ObraSocial>> findByPaciente(@PathVariable Integer idPaciente) {
		Paciente paciente = pacienteRepository.getOne(idPaciente);
		Set<ObraSocial> ret = repository.findByPaciente(paciente);
		return ResponseEntity.ok(ret);
	}
	
	@GetMapping("/medico/{idMedico}")
	public ResponseEntity<Set<ObraSocial>> findByMedico(@PathVariable Integer idMedico) {
		Medico medico = medicoRepository.getOne(idMedico);
		Set<ObraSocial> ret = repository.findByMedico(medico);
		return ResponseEntity.ok(ret);
	}
	*/
	@PostMapping()
	public ResponseEntity<ObraSocial> create(@Valid @RequestBody ObraSocial createRequest) {
		return ResponseEntity.ok(repository.save(createRequest));
	}
	
	@PutMapping()
	public ResponseEntity<ObraSocial> update(@Valid @RequestBody ObraSocial updateRequest) {
		boolean exists = repository.existsById(updateRequest.getIdObraSocial());
		if (exists) {
			return ResponseEntity.ok(repository.save(updateRequest));
		}
		return ResponseEntity.notFound().build();		
	}
	
	@DeleteMapping("/{idObraSocial}")
	public ResponseEntity<ObraSocial> delete(@PathVariable Integer idObraSocial) {
		Optional<ObraSocial> opt = repository.findById(idObraSocial);
		if (opt.isPresent()) {
			repository.delete(opt.get());
			return ResponseEntity.ok().build();			
		}
		return ResponseEntity.notFound().build();
	}
}
