package projekt;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Start {

	public static void main(String[] args){
		
		Gra gra = new Gra();
		//Menu menu = new Menu();
		
		JFrame okno = new JFrame("Laczenie Cyferek");
		okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okno.setResizable(false);
		okno.add(gra);
		//okno.add(menu);
		okno.pack();
		okno.setLocationRelativeTo(null);
		okno.setVisible(true);
		
		
		
		
		gra.start();
		
	}
	
}