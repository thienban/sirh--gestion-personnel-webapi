package dev.sgp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.sgp.entite.Collaborateur;
import dev.sgp.repository.CollaborateurRepository;
import dev.sgp.repository.DepartementRepository;

@RestController
@RequestMapping("/collaborateurs")
public class CollaborateurController {
	@Autowired
	private CollaborateurRepository collaRepo;
	
	@Autowired
	private DepartementRepository depRepo;

	/*
	@RequestMapping(method = RequestMethod.GET)
	public List<Collaborateur> listercollaborateurs() {
		return this.collaRepo.findAll();
	}
	*/
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Collaborateur> getCollaborateurByDepart(@RequestParam("departement") Integer depId) {
		if(depId == null) {
			return this.collaRepo.findAll();
		} else {
			return this.collaRepo.findByDepartement(depRepo.findOne(depId));

		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{matricule}")
	public Optional<Collaborateur> getCollaborateurByDepart(@PathVariable String matricule) {
		return this.collaRepo.findByMatricule(matricule);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{matricule}")
	public void updateCollaborateur(@PathVariable String matricule, @RequestBody Collaborateur newcollab) {
		Optional<Collaborateur> oldcollab = this.collaRepo.findByMatricule(matricule);
		newcollab.setId(oldcollab.get().getId());
		collaRepo.save(newcollab);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{matricule}/banque")
	public void getBanque(@PathVariable String matricule, @RequestBody Collaborateur newcollab) {
		Optional<Collaborateur> oldcollab = this.collaRepo.findByMatricule(matricule);
		newcollab.setId(oldcollab.get().getId());
		collaRepo.save(newcollab);
	}
	

		 	

}
