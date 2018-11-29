package projekt;

import java.awt.Font;

import javax.swing.JLabel;

public class Sumy extends JLabel {
	
	String sumaLiczbString = " ";
	Sumy(int i, int sumaLiczb){
		
		//this.i = i;
		this.setBounds(90 ,i ,100 ,100);
		Font czcionka = new Font("Italic", 0, 24);
		sumaLiczbString = Integer.toString(sumaLiczb);
		this.setFont(czcionka);
		this.setText(sumaLiczbString);
	}
	
}
