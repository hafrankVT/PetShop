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
@NamedQuery(name = "User.findUserByName", query = "SELECT u FROM ShopUser u WHERE u.userName = :userName")
@Entity

public class ShopUser implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	public ShopUser() {
		super();
	}

	@Id
	private String userName;

	private String password;

	private Double accountBalance;

	// private String firstName;
	//
	// private String lastName;
	//
	// private String address;

	public String getUserName() {
		return userName;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
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
