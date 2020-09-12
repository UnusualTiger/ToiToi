package view.HomePanel;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicSliderUI.ScrollListener;

import controller.ToiToiController;
import model.Akter;
import model.Recipe;
import model.User;
import net.miginfocom.swing.MigLayout;

public class HomePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected JPanel mainPanel = new JPanel(new MigLayout());
	protected JScrollPane sp = new JScrollPane(mainPanel);

	protected JPanel topRecipes; // recommended

	protected JPanel topUser;

	protected JPanel topCookbook;

	private ToiToiController toiToiController;

	public HomePanel(ToiToiController toiToiController) {

		this.toiToiController = toiToiController;
		this.setLayout(new MigLayout());
		mainPanel.setPreferredSize(new Dimension(690, 700));
		add(sp);
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// ==========TOP LIST RECIPES==============================
		
		ArrayList<Recipe> recipes = (ArrayList<Recipe>) toiToiController.getToiToi().getRecipe();
		recipes = toiToiController.getRecipeController().sortByLikes(recipes);

		topRecipes = new TopRecipesPanel(recipes);

		topRecipes.setBackground(new Color(200, 221, 242));
		mainPanel.add(topRecipes, "wrap");

		// ============= TOP USER================================

		JSeparator sep1 = new JSeparator();
		sep1.setOrientation(SwingConstants.HORIZONTAL);
		sep1.setBackground(Color.pink);
		sep1.setPreferredSize(new Dimension(650, 5));
		mainPanel.add(sep1, "wrap");

		ArrayList<User> users = new ArrayList<User>();
		for (Akter a : toiToiController.getToiToi().getUsers()) {
			if (a instanceof User) {
				User user = (User) a;
				users.add(user);
			}
		}
		User topUSer = toiToiController.getUserController().topUser(users);

		topUser = new TopUserPanel(topUSer, toiToiController.getRecipeController());
		topUser.setPreferredSize(new Dimension(650, 250));
		topUser.setBackground(new Color(255, 233, 248));
		mainPanel.add(topUser, "wrap");

		// =================TOP COOKBOOK===============================
		
		JSeparator sep2 = new JSeparator();
		sep2.setOrientation(SwingConstants.HORIZONTAL);
		sep2.setBackground(Color.pink);
		sep2.setPreferredSize(new Dimension(650, 5));
		mainPanel.add(sep2, "wrap");
		// TODO

	}

}
