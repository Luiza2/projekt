package projekt;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class Guzik extends JButton implements MouseListener{

	String wartoscKwadratu= " ";
	int iloscKlikniec = 0;
	String wartosc;
	boolean klikniety = false;
	int num;
	String wszystkie[]= {" "," "," "," "," "," "," "," "," "," "," "};
	private ButtonController controller;
	
	Guzik(ButtonController controller, int num){
		this.num = num;
		this.setBounds(60,60,10,10);
		this.setBackground(null);
		this.setVisible(true);
		this.addMouseListener(this);
		this.controller = controller;
		
	}
	
	public int podajLokacje() {
		System.out.println(num);
		return num;
	}
	
	public int getNum() {
		//System.out.println(num);
		return num;
	}
	
	public String getValue() {
		String wartosc = this.getText();
		//System.out.println(wartosc);
		return wartosc;
		
	}

	

	public void zaznaczKlikniecie() {
		if(this.klikniety)return;
		this.klikniety=true;//
		//System.out.println("to z Card");
		this.klikniety = this.controller.turnUp(this);//
		//if(this.faceUp)this.setIcon(this.faceIcon); 
	}
	
	//jesli kliknieto dwa guziki to odznacza ich klikniecie
	public void odznaczKlikniecie() {
		this.klikniety = false;
		//System.out.println("wywolano turnda³n z guzika");
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

