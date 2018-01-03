package dev.sgp.listener;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.repository.CollaborateurRepository;
import dev.sgp.repository.DepartementRepository;

@Component
public class ApplicationStartupListener implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	DepartementRepository depRepo;
	@Autowired
	CollaborateurRepository collabRepo;
	
	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {
		Departement dep1 = new Departement();
		dep1.setNom("Informatique");
		depRepo.save(dep1);
		
		Departement dep2 = new Departement();
		dep2.setNom("Comptabilité");
		depRepo.save(dep2);
	

		Collaborateur collab1 = new Collaborateur();
		collab1.setNom("Hilifil");
		collab1.setPrenom("Tommy");
		collab1.setBanque("Société Générale");
		collab1.setBic("SOGEFRPP");
		collab1.setIban("IBAN 2006 3053 3309");
		collab1.setDepartement(dep1);
		collabRepo.save(collab1);
		
		
		Collaborateur collab2 = new Collaborateur();
		collab2.setNom("Adion");
		collab2.setPrenom("Benoit");
		collab2.setBanque("LCL");
		collab2.setBanque("LCL");
		collab2.setBic("LCLFRPP");
		collab2.setIban("IBAN 2006 3053 4452");
		collab2.setDepartement(dep2);
		
		collabRepo.save(collab2);

		return;
	}

}
