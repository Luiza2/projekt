package projekt;

import java.awt.Font;

import javax.swing.JLabel;

public class Sumy extends JLabel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String sumaLiczbString = " ";
	Sumy(int i, int sumaLiczb){
		
		this.setBounds(90 ,i ,70 ,70);
		Font czcionka = new Font("Italic", 0, 24);
		sumaLiczbString = Integer.toString(sumaLiczb);
		this.setFont(czcionka);
		this.setText(sumaLiczbString);
		
	}
	
}
