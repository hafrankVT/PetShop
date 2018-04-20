package net.ddns.petrizoo.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import net.ddns.petrizoo.models.ShopUser;

/**
 * Session Bean implementation class LoginManager Handles all of the
 * functionality involved in logging in a user.
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

	// Declaration of EntityManager
	@PersistenceContext(unitName = "petshop")
	EntityManager em;

	public boolean addUser(String userName, String password) {
		// Query the DB for user
		TypedQuery<ShopUser> userQuery = em.createNamedQuery("User.findUserByName", ShopUser.class)
				.setParameter("userName", userName);
		try {
			ShopUser user = userQuery.getSingleResult();
			// If it works, do the rest of this.
			System.out.println("Sorry, user already exists in system.");
			return false;
		} catch (NoResultException e) {
			ShopUser user = new ShopUser();
			user.setPassword(password);
			user.setUserName(userName);
			em.persist(user);
			return true;
		}

	}

	public boolean logOnUser(String userName, String password) {
		// Query the DB for user
		TypedQuery<ShopUser> userQuery = em.createNamedQuery("User.findUserByName", ShopUser.class)
				.setParameter("userName", userName);
		try {
			ShopUser user = userQuery.getSingleResult();
			// If it works, do the rest of this.
			if (password.equals(user.getPassword())) {
				System.out.println("Password matches");
				return true;
			} else {
				System.out.println("Password incorrect");
				return false;
			}
		} catch (NoResultException e) {
			System.out.println("User not found");
			return false;
		}

	}

}
