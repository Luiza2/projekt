package projekt;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;


public class Plansza implements MouseListener {

	public static int RZEDY = 7, KOLUMNY = 7;
	Guzik[][] tablica = new Guzik[7][7];
	int startingTiles = 4;
	int licznik = 0;
	String wybrane[] = {" "," "," "," "," "," "," "," " };
	
	Plansza(JPanel panelPlanszy) {
		JPanel plansza = new JPanel();
		plansza.setBackground(Color.pink);
		plansza.setSize(420,420);
		plansza.setLocation(240,240);
		plansza.setVisible(true);
		plansza.setLayout(new GridLayout(7,7));
		panelPlanszy.add(plansza);
		
		JPanel menu = new JPanel();
		menu.setBackground(Color.blue);
		menu.setSize(860,160);
		menu.setLocation(20,60);
		menu.setVisible(true);
		panelPlanszy.add(menu);
		
		
		
		JPanel polePunktow = new JPanel();
		polePunktow.setBackground(Color.blue);
		polePunktow.setSize(200,420);
		polePunktow.setLocation(20,240);
		polePunktow.setVisible(true);
		panelPlanszy.add(polePunktow);
		
		start(plansza);
	}
	
	private void start(JPanel plansza){
		rysujPlansze(plansza);
		
		int licznik = 0;
		
		for(int i = 0 ; i < startingTiles; i++){
			losujWartosci(plansza, licznik);
			licznik++;
		}
		
			System.out.println(wybrane[0]);
			System.out.println(wybrane[1]);
			System.out.println(wybrane[2]);
			System.out.println(wybrane[3]);
		
	}
	
	public void sumator(String wylosowane) {
		
	}
	
	public void losujWartosci(JPanel plansza, int licznik) {
		Random random = new Random();
		boolean notValid = true;
		
		int mozliweWartosci[] = {-9,-8,-7,-6,-5,-4,-3,-2,-1,1,2,3,4,5,6,7,8,9};
		//while(notValid){
			int location = random.nextInt(RZEDY * KOLUMNY);//mozliwe wyskoczenie cyferek
			int row = location / RZEDY;
			int col = location % KOLUMNY;
			
			int losowa = random.nextInt(17);
			
			String wartosc = Integer.toString(mozliweWartosci[losowa]);
			tablica[row][col].setText(wartosc);
			
			notValid = false;
			wybrane[licznik] = wartosc;
		//}
		
		
	}
	
	public void rysujPlansze(JPanel plansza){
	
    for(int k=0;k < 7;k++){
            for(int m=0;m < 7;m++){
                   
                    tablica[k][m] = new Guzik();
                    // buttons[k][m].setBackground(null);
                    tablica[k][m].addMouseListener(this);
                    // buttons[k][m].setBounds(k*60, m*60, 60, 60);
                    plansza.add(tablica[k][m]);      
                    
               }
    }
	}

	public void czytnikWartosci() {
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
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