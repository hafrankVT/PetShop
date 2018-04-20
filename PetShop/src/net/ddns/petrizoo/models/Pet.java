package net.ddns.petrizoo.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

/**
 * Entity implementation class for Entity: Pet
 *
 */
@Entity

public class Pet implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	public Pet() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	private PetType petType;
	
	private Double cost;
	
	private Gender gender;
	
	private boolean fixed;
	
	@Lob
	private byte[] picture;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PetType getPetType() {
		return petType;
	}

	public void setPetType(PetType petType) {
		this.petType = petType;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public boolean isFixed() {
		return fixed;
	}

	public void setFixed(boolean fixed) {
		this.fixed = fixed;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", petType=" + petType + ", cost=" + cost + ", gender=" + gender
				+ ", fixed=" + fixed + "]";
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	
//	private Set<PetSpecies> petSpecies;
   
}
