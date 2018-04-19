package net.ddns.petrizoo.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.ddns.petrizoo.models.ShopUser;

/**
 * Session Bean implementation class LoginManager
 * Handles all of the functionality involved in logging in a user.
 */
@Stateless
@LocalBean
public class LoginManager {

    /**
     * Default constructor. 
     */
    public LoginManager() {
        // TODO Auto-generated constructor stub
    }
    
    //Declaration of EntityManager
    @PersistenceContext(unitName="petshop")
	EntityManager em;
    
    public void addUser(String userName, String password) {
    	ShopUser user = new ShopUser();
    	
    	user.setPassword(password);
    	user.setUserName(userName);
    	
    	em.persist(user);
    }

}
