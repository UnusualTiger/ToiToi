package view.HomePanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controller.RecipeController;
import controller.ButtonActions.RecipeImageButtonAction;
import model.Recipe;
import model.User;
import net.miginfocom.swing.MigLayout;
import view.MainFrame;
import view.ProfileWindow.ButtonTabComponent;
import view.ProfileWindow.ProfileWindow;

public class TopUserPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected JPanel userPanel;
	private User user = null;
	protected JButton userLink;
	protected JLabel username;
	protected JLabel points;

	protected JPanel recipePanel;
	private Recipe recipe = null;
	protected JButton recipeLink;
	protected JLabel name;
	protected JLabel likes;

	public TopUserPanel(User user, RecipeController rc) {
		this.user = user;
		this.setLayout(new MigLayout("", "[] 20 []", ""));

		userPanel = new JPanel(new MigLayout());
		userPanel.setBackground(new Color(200, 221, 242));

		JPanel rightPanel = new JPanel(new MigLayout());

		recipePanel = new JPanel(new MigLayout());
		recipePanel.setBackground(new Color(200, 221, 242));

		Image limg = new ImageIcon("./img/two-hearts.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		Image simg = new ImageIcon("./img/star-of-bethlehem.png").getImage().getScaledInstance(20, 20,
				Image.SCALE_SMOOTH);

		ImageIcon like = new ImageIcon(limg);
		ImageIcon star = new ImageIcon(simg);

		Image uimg = new ImageIcon("img/accessibility2.png").getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		Image dimg = new ImageIcon("img/cancel-2.png").getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);

		ImageIcon addIcon = new ImageIcon(dimg);
		ImageIcon userDefault = new ImageIcon(uimg);

		userLink = new JButton(userDefault);
		username = new JLabel("None");
		points = new JLabel("0");

		recipeLink = new JButton(addIcon);
		name = new JLabel("None");
		likes = new JLabel("0");

		if (user != null) {

			if (!user.getImage().equals("")) {
				Image img1 = new ImageIcon(user.getImage()).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
				ImageIcon addIcon1 = new ImageIcon(img1);
				userLink = new JButton(addIcon1);
			}

			username = new JLabel(user.getName());
			points = new JLabel(user.getPoints() + " Points", star, JLabel.RIGHT);

			ArrayList<Recipe> recipes = (ArrayList<Recipe>) user.getRecipe();
			if (recipes.size() > 0) {
				recipes = rc.sortByLikes(recipes);
				recipe = recipes.get(0);
			} else {
				recipe = null;
			}
		}

		if (recipe != null) {
			Image img1 = new ImageIcon(recipe.getImage()).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
			ImageIcon addIcon1 = new ImageIcon(img1);
			recipeLink = new JButton(addIcon1);
			name = new JLabel(recipe.getName());
			likes = new JLabel(recipe.getLikes() + " Points", like, JLabel.RIGHT);
		}

		userLink.setContentAreaFilled(false);
		userLink.setToolTipText("Go to user");
		userLink.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (user != null) {


					System.out.println(user);

					if (MainFrame.getInstance().getAkter() != null
							&& MainFrame.getInstance().getAkter().getUsername() == user.getUsername()) {
						MainFrame.tabbedPane.setSelectedIndex(3);
					} else {
						ProfileWindow pw = new ProfileWindow(user, MainFrame.toiToiController);

						try {
							MainFrame.tabbedPane.add("", pw.createOtherUserProfilePage());

						} catch (IOException e) {
							e.printStackTrace();
						}

						MainFrame.tabbedPane.setTabComponentAt(MainFrame.tabbedPane.getTabCount() - 1,
								new ButtonTabComponent(MainFrame.tabbedPane, user.getName() + " " + user.getSurname()));
					}

				}
			}

		});

		recipeLink.setContentAreaFilled(false);

		recipeLink.setToolTipText("Go to recipe");

		if (recipe != null) {
			RecipeImageButtonAction recAction1 = new RecipeImageButtonAction();
			recAction1.setTabIndex(0);
			recAction1.setRecipe(recipe);
			recipeLink.setMnemonic(KeyEvent.VK_ENTER);
			recipeLink.addActionListener(recAction1);
		}

		JLabel l1 = new JLabel("ToiToi top user!");
		userPanel.add(l1, "wrap");
		userPanel.add(userLink, "wrap");
		userPanel.add(username, "wrap");
		userPanel.add(points);
		userPanel.setBackground(new Color(255, 233, 248));

		add(userPanel);

		JLabel l2 = new JLabel("Top users best recipe!");
		recipePanel.add(l2, "wrap");
		recipePanel.add(recipeLink, "wrap");
		recipePanel.add(name, "wrap");
		recipePanel.add(likes);
		recipePanel.setBackground(new Color(255, 233, 248));

		rightPanel.add(recipePanel);
		add(rightPanel);
		rightPanel.setBackground(new Color(255, 233, 248));

		JTextArea area = new JTextArea(recipe.getDescription());
		area.setPreferredSize(new Dimension(180, 180));
		area.setLineWrap(true);
		area.setBorder(BorderFactory.createLineBorder(new Color(200, 221, 242), 2));
		rightPanel.add(area);
		area.setBackground(new Color(255, 233, 248));
		area.setEditable(false);
		setBackground(new Color(255, 233, 248));
		add(rightPanel);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
