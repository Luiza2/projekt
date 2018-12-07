package projekt;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class Guzik extends JButton implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String wartoscKwadratu= " ";
	//int iloscKlikniec = 0;
	//String wartosc;
	boolean klikniety = false;
	Color kolorPlanszy = new Color(255,	250,	205);
	int num;
	String wszystkie[]= {" "," "," "," "," "," "," "," "," "," "," "};
	private ButtonController controller;
	
	Guzik(ButtonController controller, int num, String wartoscKwadratu){
		this.wartoscKwadratu = wartoscKwadratu;
		
		this.num = num;
		this.setBounds(60,60,10,10);
		this.setBackground(null);
		this.setVisible(true);
		this.addMouseListener(this);
		Font czcionka = new Font("Italic", 0, 24);
		this.setFont(czcionka);
		this.controller = controller;
		
		this.setText(wartoscKwadratu);
		
	}
	
	public int podajLokacje() {
		System.out.println(num);
		return num;
	}
	
	public int getNum() {
		//System.out.println(num);
		return num;
	}
	
	public String podajWartosc() {
		String wartosc = this.getText();
		//System.out.println(wartosc);
		return wartosc;
		
	}

	

	public void zaznaczKlikniecie() {
		String zawartosc = this.podajWartosc();
		//System.out.println("to z zaznaczklikniecie "+zawartosc );
		if(zawartosc != " ") {
		
		if(this.klikniety)return;
		this.klikniety=true;//
		this.setBackground(Color.green);
		//System.out.println("to z Card");
		
			this.klikniety = this.controller.zaznacz(this);//
		}
		
		//if(this.faceUp)this.setIcon(this.faceIcon); 
	}
	
	//jesli kliknieto dwa guziki to odznacza ich klikniecie
	public void odznaczKlikniecie() {
		this.klikniety = false;
		this.setBackground(kolorPlanszy);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		this.zaznaczKlikniecie();
		//this.getValue();
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

