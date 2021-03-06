/***********************************************************************
 * Module:  Equipment.java
 * Author:  Teodora Rajnovic, Olivera Mirilovic,Isidora Savic
 * Purpose: Defines the Class CookBook
 ***********************************************************************/

package model;

import java.io.Serializable;

public class Equipment implements Serializable {

	private static final long serialVersionUID = 1L;

	private int equipmentID = -1;

	private String name;

	private String company;

	private String description;

	public Equipment() {
		super();
	}

	public Equipment(int equipmentID, String name, String company, String description) {
		super();
		this.name = name;
		this.company = company;
		this.description = description;
		this.equipmentID = equipmentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getEquipmentID() {
		return equipmentID;
	}

	public void setEquipmentID(int equipmentID) {
		this.equipmentID = equipmentID;
	}

	@Override
	public String toString() {
		return "Equipment [equipmentID=" + equipmentID + ", name=" + name + ", company=" + company + ", description="
				+ description + "]";
	}

}