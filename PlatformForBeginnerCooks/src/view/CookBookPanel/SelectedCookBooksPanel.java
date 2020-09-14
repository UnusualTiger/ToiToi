package view.CookBookPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import model.CookBook;
import net.miginfocom.swing.MigLayout;

public class SelectedCookBooksPanel {
	private List<CookBook> sortiraniCb;
	
	
	public SelectedCookBooksPanel(List<CookBook> cb) {
		this.sortiraniCb = cb;
	}
	
	public JPanel createSelectedCookBooksPanel() throws IOException {
		JPanel panel = new JPanel(new MigLayout());
		
		JLabel naslov = new JLabel("Search results");
		naslov.setFont(new Font("Serif", Font.PLAIN, 30));
		
		panel.add(naslov, "span, gapleft 200, wrap");
		
		JPanel lista = new JPanel(new MigLayout());
		
		int brojac = 1;
		for(CookBook cb : sortiraniCb) {
			if(brojac == 11) {
				break;
			}
			
			JLabel br = new JLabel(brojac+".");
			br.setFont(new Font("Serif", Font.PLAIN, 20));
			
			lista.add(br, "gapleft 10");
			
			
			BufferedImage img = ImageIO.read(new File(cb.getImage()));
			Image image = img.getScaledInstance(70, 70, Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(image);

			JButton dugmic = new JButton(icon);
			dugmic.setBackground(new Color(204, 204, 255));

			dugmic.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// ovde se poziva funkcija za prikaz celog recepta!
				}
			});

			JLabel naziv = new JLabel(cb.getName());
			naziv.setFont(new Font("Serif", Font.PLAIN, 20));

			lista.add(dugmic, "gapleft 30, gaptop 30");
			lista.add(naziv, "gapleft 50, gaptop 30, gapright 250, wrap");
			brojac++;
			
		}
		
		JScrollPane jsc = new JScrollPane(lista);
		
		panel.add(jsc, "span, gaptop 20, gapleft 20, gapright 20, gapbottom 220, wrap");
		
		Border border2 = BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(153, 11, 255));
		panel.setBorder(border2);
		
		return panel;
	}
}
