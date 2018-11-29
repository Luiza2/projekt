package projekt;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class Guzik extends JButton implements MouseListener{

	
	
	Guzik(){
		
		this.setBounds(60,60,10,10);
		this.setBackground(null);
		this.setVisible(true);
		this.addMouseListener(this);
		
	}
	
	
	
	public String getValue() {
		String wartosc = this.getText();
		System.out.println(wartosc);
		return wartosc;
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		getValue();
		
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