package controller;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import model.Recipe;


public class RecipeController {
	
	private Recipe recipe;
	private String recipeFile;
	
	public RecipeController() {
		super();
	}
	
	public RecipeController(String file) {
		super();
		this.recipeFile = file;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public String getRecipeFile() {
		return recipeFile;
	}

	public void setRecipeFile(String recipeFile) {
		this.recipeFile = recipeFile;
	}
	
	public void writeRecipes(ArrayList<Recipe> recipeList) throws IOException {
		FileOutputStream fileOut = null;
		ObjectOutputStream objectOut = null;
		try {
			fileOut = new FileOutputStream(recipeFile);
			objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(recipeList);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (objectOut != null)
				objectOut.close();
		}

	}

	@SuppressWarnings("unchecked")
	public ArrayList<Recipe> readRecipes() throws IOException {
		ObjectInputStream objectIn = null;
		ArrayList<Recipe> recipeList = null;
		try {
			FileInputStream fileIn = new FileInputStream(recipeFile);
			objectIn = new ObjectInputStream(fileIn);
			recipeList = (ArrayList<Recipe>) objectIn.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (objectIn != null)
				objectIn.close();
		}
		return recipeList;

	}

	public HashMap<Integer, Recipe> getHashMapRecipe() throws IOException{
		ToiToiController toiToiController = new ToiToiController();
		toiToiController.writteData();
		toiToiController.readData();
				
		//ArrayList<Recipe> recipes = readRecipes();
		HashMap<Integer, Recipe> retval = new HashMap<Integer, Recipe>();
		for (Recipe recipe : toiToiController.getToiToi().getRecipe()) {
			retval.put(recipe.getRecipeID(), recipe);
		}
		return retval;
	}

	
	
}
