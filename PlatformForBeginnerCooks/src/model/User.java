/***********************************************************************
 * Module:  User.java
 * Author:  Teodora Rajnovic, Olivera Mirilovic,Isidora Savic
 * Purpose: Defines the Class CookBook
 ***********************************************************************/

package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class User extends Akter implements Serializable {
	/**
	 * 
	 */
	// yyyy-mm-dd
	private static final long serialVersionUID = -6052040809605270549L;

	private Gender gender;

	private LocalDate birthday;

	private String address;

	private String telephone;

	private int points = 0;

	private List<ProductInfo> groceries;

	private List<String> alergies;

	private List<Equipment> equipment;

	private String image = "";

	private ArrayList<Recipe> likedRecipes;

	private ArrayList<Recipe> recipes;

	private ArrayList<CookBook> cookBooks;

	public User() {
		super();
	}

	public User(String name, String surname, String username, String password, String mail, Gender gender,
			LocalDate birthday, String address, String telephone, int points, List<ProductInfo> groceries,
			List<String> alergies, List<Equipment> equipment) {
		super(name, surname, username, password, mail);
		this.birthday = birthday;
		this.address = address;
		this.telephone = telephone;
		this.points = points;
		this.groceries = groceries;
		this.alergies = alergies;
		this.equipment = equipment;
		this.gender = gender;
	}

	public ArrayList<CookBook> getCookBooks() {
		return cookBooks;
	}

	public void setCookBooks(ArrayList<CookBook> cookBooks) {
		this.cookBooks = cookBooks;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String getName() {

		return super.getName();
	}

	@Override
	public void setName(String name) {

		super.setName(name);
	}

	@Override
	public String getSurname() {

		return super.getSurname();
	}

	@Override
	public void setSurname(String surname) {

		super.setSurname(surname);
	}

	@Override
	public String getUsername() {

		return super.getUsername();
	}

	@Override
	public void setUsername(String username) {

		super.setUsername(username);
	}

	@Override
	public String getPassword() {

		return super.getPassword();
	}

	@Override
	public void setPassword(String password) {

		super.setPassword(password);
	}

	@Override
	public String getMail() {

		return super.getMail();
	}

	@Override
	public void setMail(String mail) {

		super.setMail(mail);
	}

	public ArrayList<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(ArrayList<Recipe> recipes) {
		this.recipes = recipes;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public java.util.List<String> getAlergies() {

		if (alergies == null)
			alergies = new java.util.ArrayList<String>();
		return alergies;
	}

	public java.util.Iterator<String> getIteratorAlergies() {

		if (alergies == null)
			alergies = new java.util.ArrayList<String>();
		return alergies.iterator();
	}

	public void setAlergies(java.util.List<String> newAlergies) {

		removeAllAlergies();
		for (Iterator<String> iter = newAlergies.iterator(); iter.hasNext();)
			addAlergies((String) iter.next());
	}

	public void addAlergies(String newProduct) {

		if (newProduct == null)
			return;
		if (this.alergies == null)
			this.alergies = new java.util.ArrayList<String>();
		if (!this.alergies.contains(newProduct))
			this.alergies.add(newProduct);
	}

	public void removeAlergies(String oldAlergy) {
		if (oldAlergy == null)
			return;
		if (this.alergies != null)
			if (this.alergies.contains(oldAlergy))
				this.alergies.remove(oldAlergy);
	}

	public void removeAllAlergies() {
		if (alergies != null)
			alergies.clear();
	}

	public java.util.List<Equipment> getEquipment() {
		if (equipment == null)
			equipment = new java.util.ArrayList<Equipment>();
		return equipment;
	}

	public java.util.Iterator<Equipment> getIteratorEquipment() {
		if (equipment == null)
			equipment = new java.util.ArrayList<Equipment>();
		return equipment.iterator();
	}

	public void setEquipment(java.util.List<Equipment> newEquipment) {
		removeAllEquipment();
		for (Iterator<Equipment> iter = newEquipment.iterator(); iter.hasNext();)
			addEquipment((Equipment) iter.next());
	}

	public void addEquipment(Equipment newEquipment) {
		if (newEquipment == null)
			return;
		if (this.equipment == null)
			this.equipment = new java.util.ArrayList<Equipment>();
		if (!this.equipment.contains(newEquipment))
			this.equipment.add(newEquipment);
	}

	public void removeEquipment(Equipment oldEquipment) {
		if (oldEquipment == null)
			return;
		if (this.equipment != null)
			if (this.equipment.contains(oldEquipment))
				this.equipment.remove(oldEquipment);
	}

	public void removeAllEquipment() {
		if (equipment != null)
			equipment.clear();
	}

	public java.util.List<Recipe> getRecipe() {
		if (recipes == null)
			recipes = new java.util.ArrayList<Recipe>();
		return recipes;
	}

	public java.util.Iterator<Recipe> getIteratorRecipe() {
		if (recipes == null)
			recipes = new java.util.ArrayList<Recipe>();
		return recipes.iterator();
	}

	public void setRecipe(java.util.List<Recipe> newRecipe) {
		removeAllRecipes();
		for (Iterator<Recipe> iter = newRecipe.iterator(); iter.hasNext();)
			addRecipes((Recipe) iter.next());
	}

	public void addRecipes(Recipe newRecipe) {
		if (newRecipe == null)
			return;
		if (this.recipes == null)
			this.recipes = new java.util.ArrayList<Recipe>();
		if (!this.recipes.contains(newRecipe))
			this.recipes.add(newRecipe);
	}

	public void removeRecipes(Recipe oldRecipe) {
		if (oldRecipe == null)
			return;
		if (this.recipes != null)
			if (this.recipes.contains(oldRecipe))
				this.recipes.remove(oldRecipe);
	}

	public void removeAllRecipes() {
		if (recipes != null)
			recipes.clear();
	}

	public java.util.List<ProductInfo> getGrocerie() {
		if (groceries == null)
			groceries = new java.util.ArrayList<ProductInfo>();
		return groceries;
	}

	public java.util.Iterator<ProductInfo> getIteratorGrocerie() {
		if (groceries == null)
			groceries = new java.util.ArrayList<ProductInfo>();
		return groceries.iterator();
	}

	public void setGrocerie(java.util.List<ProductInfo> newGrocerie) {
		removeAllGroceries();
		for (Iterator<ProductInfo> iter = newGrocerie.iterator(); iter.hasNext();)
			addGroceries((ProductInfo) iter.next());
	}

	public void addGroceries(ProductInfo newGrocerie) {
		if (newGrocerie == null)
			return;
		if (this.groceries == null)
			this.groceries = new java.util.ArrayList<ProductInfo>();
		if (!this.groceries.contains(newGrocerie))
			this.groceries.add(newGrocerie);
	}

	public void removeGroceries(ProductInfo oldGrocerie) {
		if (oldGrocerie == null)
			return;
		if (this.groceries != null)
			if (this.groceries.contains(oldGrocerie))
				this.groceries.remove(oldGrocerie);
	}

	public void removeAllGroceries() {
		if (groceries != null)
			groceries.clear();
	}

	@Override
	public String toString() {
		String retval = "User [name=" + name + ", surname=" + surname + ", username=" + username + ", password="
				+ password + ", mail=" + mail + ", birthday=" + birthday + ", address=" + address + ", telephone="
				+ telephone + ", points=" + points + ", groceries=";

		if (groceries != null) {
			for (ProductInfo p : groceries) {
				retval += p.getIngredient().getName() + ", ";
			}
		}

		retval += " alergies=";
		if (alergies != null) {
			for (String p : alergies) {
				retval += p + ", ";
			}
		}

		retval += " equipment=";
		if (equipment != null) {
			for (Equipment e : equipment) {
				retval += e.getEquipmentID() + ", ";
			}
		}
		retval += " recipes=";
		if (recipes != null) {
			for (Recipe e : recipes) {
				retval += e.getRecipeID() + ", ";
			}
		}
		retval += " cookbooks=";
		if (recipes != null) {
			for (CookBook e : cookBooks) {
				retval += e.getName() + ", ";
			}
		}
		retval = retval.substring(0, retval.length() - 2) + "]";

		return retval;
	}

	public ArrayList<Recipe> getLikedRecipes() {
		return likedRecipes;
	}

	public void setLikedRecipes(ArrayList<Recipe> likedRecipes) {
		this.likedRecipes = likedRecipes;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<ProductInfo> getAvailableGroceries() {
		return groceries;
	}

	public void setAvailableGroceries(List<ProductInfo> groceries) {
		this.groceries = groceries;
	}

	public void deleteRecipeById(int recipeId) {
		for (int i = 0; i < getRecipes().size(); i++) {
			if (recipeId == getRecipe().get(i).getRecipeID()) {
				recipes.remove(i);
				break;
			}
		}
	}


	public int calculatePoints() {

		int points = 0;

		for (Recipe r : recipes) {
			points += r.getLikes() * 2;
		}
		for (CookBook cb : cookBooks)
			points += cb.getLikes();
		if (!image.equals(""))
			points += 5;
		setPoints(points);

		return points;


	}

	public void deleteCookBook(String name) {
		for (int i = 0; i < cookBooks.size(); i++) {
			if (cookBooks.get(i).getName().toLowerCase().compareTo(name.toLowerCase()) == 0) {
				cookBooks.remove(i);
				break;
			}
		}
	}
}
