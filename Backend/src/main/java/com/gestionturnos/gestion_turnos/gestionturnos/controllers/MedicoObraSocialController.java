package com.gestionturnos.gestion_turnos.gestionturnos.controllers;

import java.util.ArrayList;
import java.util.List;
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

import com.gestionturnos.gestion_turnos.gestionturnos.dao.MedicoObraSocialRepository;
import com.gestionturnos.gestion_turnos.gestionturnos.dao.MedicoRepository;
import com.gestionturnos.gestion_turnos.gestionturnos.dao.ObraSocialRepository;
import com.gestionturnos.gestion_turnos.gestionturnos.model.MedicoObraSocial;
import com.gestionturnos.gestion_turnos.gestionturnos.model.Medico;
import com.gestionturnos.gestion_turnos.gestionturnos.model.ObraSocial;

/**
 * 
 * @author flor
 *
 */
@RestController
@RequestMapping("/medicoObraSocial")
public class MedicoObraSocialController {

	@Autowired
	private MedicoRepository medicoRepository;

	@Autowired
	private ObraSocialRepository obraSocialRepository;

	@Autowired
	private MedicoObraSocialRepository repository;

	@GetMapping()
	public Page<MedicoObraSocial> getPage(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@GetMapping("/medicos/{idObraSocial}")
	public List<Medico> findByIdObraSocial(@PathVariable String idObraSocial){
		List<MedicoObraSocial> filtradoObraSoc = repository.findByIdObraSocial(idObraSocial);
		List<Medico> Medicos = new ArrayList<>();

		for (MedicoObraSocial i : filtradoObraSoc) {
			var medico = medicoRepository.findById(i.getIdMedico());
			Medicos.add(medico.get());
		}
		return Medicos;

	}

	@GetMapping("/obraSocial/{idMedico}")
	public List<ObraSocial> findByIdMedico(@PathVariable String idMedico){
		List<MedicoObraSocial> filtradoMedico = repository.findByIdMedico(idMedico);
		List<ObraSocial> Obras = new ArrayList<>();
		
		for (MedicoObraSocial i : filtradoMedico) {
			var obra = obraSocialRepository.findById(i.getIdObraSocial());
			Obras.add(obra.get());
		}
		return Obras;
	}

	@PostMapping()
	public ResponseEntity<MedicoObraSocial> create(@Valid @RequestBody MedicoObraSocial createRequest) {
		var medRequest = createRequest.getIdMedico();
		var obraRequest = createRequest.getIdObraSocial();

		var medAlmacenado = medicoRepository.findById(medRequest);
		var obraAlmacenado = obraSocialRepository.findById(obraRequest);

		if (medAlmacenado.isPresent() && obraAlmacenado.isPresent()) {
			return ResponseEntity.ok(repository.save(createRequest));

		}
		return ResponseEntity.notFound().build();
		
	}

	@PutMapping()
	public ResponseEntity<MedicoObraSocial> update(@Valid @RequestBody MedicoObraSocial updateRequest) {
		boolean existsMedico = repository.existsById(updateRequest.getIdMedico());
		boolean existsObra = repository.existsById(updateRequest.getIdObraSocial());
		if (existsMedico && existsObra) {
			return ResponseEntity.ok(repository.save(updateRequest));
		}
		return ResponseEntity.notFound().build();
	}
/*
	@DeleteMapping("/medico/{idMedico}/obraSocial/{idObraSocial}")
	public ResponseEntity<?> delete(@PathVariable Integer idMedico, @PathVariable String idObraSocial) {
		List<MedicoObraSocial> opt = repository.findByIdMedico(idMedico);
		for (MedicoObraSocial i : opt) {
			 if	(i.getIdObraSocial() == idObraSocial){
				 repository.delete((i));
				 return ResponseEntity.ok().build();		
			 }
		}

		return ResponseEntity.notFound().build();
}*/
	
	
}
