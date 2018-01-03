package dev.sgp.listener;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import dev.sgp.entite.BanqueInfo;
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

	/**
	 * This event is executed as late as conceivably possible to indicate that the
	 * application is ready to service requests.
	 */
	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {
		Departement dep1 = new Departement("Informatique");
		Departement dep2 = new Departement("Administration");
		Departement dep3 = new Departement("Ressources Humaines");
		Departement dep4 = new Departement("Comptabilité");
		Departement dep5 = new Departement("Direction");
		List<Departement> departements = new ArrayList<>();
		departements.add(dep1);
		departements.add(dep2);
		departements.add(dep3);
		departements.add(dep4);
		departements.add(dep5);
		depRepo.save(departements);

		BanqueInfo banqueInfo1 = new BanqueInfo();
		banqueInfo1.setBanque("Société Générale");
		banqueInfo1.setBic("SOGEFRPP");
		banqueInfo1.setIban("IBAN 2006 3053 3309");
		Collaborateur collab1 = new Collaborateur("Dupont", "Jean-Jacques");
		collab1.setBanqueInfo(banqueInfo1);
		collab1.setDepartement(dep1);
	
		collabRepo.save(collab1);

		BanqueInfo banqueInfo2 = new BanqueInfo();
		banqueInfo2.setBanque("LCL");
		banqueInfo2.setBic("LCLFRPP");
		banqueInfo2.setIban("IBAN 2006 3053 4452");
		Collaborateur collab2 = new Collaborateur("Ricard", "Daniel");
		collab2.setBanqueInfo(banqueInfo2);
		collab2.setDepartement(dep4);
	
		collabRepo.save(collab2);

		return;
	}

}