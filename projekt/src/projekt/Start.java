package projekt;

import javax.swing.JFrame;

public class Start {

	public static void main(String[] args){
				      
		
		Gra gra = new Gra();		
		JFrame okno = new JFrame("Laczenie Cyferek");
		okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okno.setResizable(false);	
		okno.add(gra);
		okno.pack();
		okno.setLocationRelativeTo(null);
		okno.setVisible(true);
		gra.start();
		
	}
	
}