package projekt;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class Sumy extends JLabel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Color kolorPoprawny = new Color(135,	206	,235);
	String sumaLiczbString = " ";
	Sumy(int i, int sumaLiczb){
		
		this.setBounds(90 ,i ,70 ,70);
		Font czcionka = new Font("Italic", 0, 24);
		sumaLiczbString = Integer.toString(sumaLiczb);
		this.setFont(czcionka);
		this.setText(sumaLiczbString);
		
	}
	
	public void zmienKolor() {
		
		Font czcionka1 = new Font("Italic", 0, 30);
		this.setForeground(kolorPoprawny);
		//this.setFont(czcionka1);
		//System.out.println("zmieniarka koloru z klasy sumy");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//zmienKolor();
	}
	
}
