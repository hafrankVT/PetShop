package net.ddns.petrizoo.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

/**
 * Entity implementation class for Entity: User
 *
 */
@NamedQuery(name="User.findUserByName", query="SELECT u FROM ShopUser u WHERE u.userName = :userName")
@Entity

public class ShopUser implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	public ShopUser() {
		super();
	}
	

//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Integer id;
	@Id
	private String userName;
	
	private String password;

//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
   
}
