package eu.ensup.gestionetudiant.presentation;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import eu.ensup.gestionetudiant.domaine.Cours;
import eu.ensup.gestionetudiant.domaine.Direction;
import eu.ensup.gestionetudiant.domaine.Enseignant;
import eu.ensup.gestionetudiant.domaine.Etudiant;
import eu.ensup.gestionetudiant.service.DirectionService;

public class Lanceur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DirectionService service = new DirectionService();
	
		Direction direction = new Direction("Moulin", "Jean", "jeanmoulin@gmail.com", "15 rue Jean Jacques Goldman, Paris", 0203040505, "moulin", "jean");
		Etudiant etudiant = new Etudiant("Cerdant", "Marcel", "marcelcerdant@hotmail.com", "678 av. Guy Marchand, Paris", 0102030405, "25 juin 2000");
		Enseignant enseignant = new Enseignant("Robuchon", "Jo�l", "joelrobuchon@yahoo.fr", "13 bd de Ratatouille, Paris", 0102030505, "Math�matiques");
		Cours cours = new Cours("JAVA", 3);
		ArrayList<Cours> listCours = new ArrayList<Cours>();
		listCours.add(cours);
		Etudiant etudiant2 = new Etudiant("Cerdant", "Marcel", "marcelcerdant@hotmail.com", "678 av. Guy Marchand, Paris", 0102030405, "25 juin 2000", listCours);

		
		// 1 : Ouverture unit� de travail JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestion-etu");
		EntityManager em = emf.createEntityManager();
		
		// 2 : Ouverture transaction 
		EntityTransaction tx =  em.getTransaction();
		tx.begin();

		// 4 : Persistance Objet/Relationnel : cr�ation d'un enregistrement en base
		 em.persist(direction);
		 em.persist(etudiant);
		 em.persist(enseignant);
		 em.persist(cours);
		 em.persist(etudiant2);
		
		// 5 : Fermeture transaction 
		 tx.commit();
		
		// 6 : Fermeture unit� de travail JPA 
		em.close();
		emf.close();	
		service.creerEtudiant(etudiant);
	
	}

}
