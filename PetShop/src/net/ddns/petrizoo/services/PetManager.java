package net.ddns.petrizoo.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
