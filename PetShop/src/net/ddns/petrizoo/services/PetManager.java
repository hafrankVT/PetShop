package net.ddns.petrizoo.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import net.ddns.petrizoo.models.Pet;

/**
 * Session Bean implementation class PetManager
 */
@Stateless
@LocalBean
public class PetManager {

	/**
	 * Default constructor.
	 */
	public PetManager() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "petshop")
	EntityManager em;

	public void addPet(Pet p) {
		em.persist(p);
	}

	public Pet getPetById(String idNo) {
		// Query the DB for user
		TypedQuery<Pet> petQuery = em.createNamedQuery("Pet.findPetById", Pet.class)
				.setParameter("id", Integer.parseInt(idNo));
		Pet p = petQuery.getSingleResult();
		return p;
	}
	
	public List<Pet> getPetList() {
		TypedQuery<Pet> pQuery = em.createQuery("SELECT p FROM Pet p", Pet.class);
		List<Pet> petList = pQuery.getResultList();
		
		return petList;
	}

}
