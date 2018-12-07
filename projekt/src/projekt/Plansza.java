package projekt;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Plansza implements MouseListener {

	public static int RZEDY = 7, KOLUMNY = 7;
	Guzik[][] tablica = new Guzik[7][7];
	int startoweKwadraty = 4;
	//int licznik = 0;
	public static int sumy[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	String wybrane[] = {" "," "," "," "," "," "," "," "," "," "," "," "," "," "," " };
	int wartosciKwadratow [] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	
	
	Plansza(JPanel panelPlanszy) {
		
		Color kolor = new Color(135,	206	,235);
		Color kolorPlanszy = new Color(255,	250,	205);
		
		JPanel plansza = new JPanel();
		plansza.setBackground(kolorPlanszy);
		plansza.setSize(420,420);
		plansza.setLocation(240,240);
		plansza.setVisible(true);
		plansza.setLayout(new GridLayout(7,7));
		panelPlanszy.add(plansza);
		
		panelPlanszy.addMouseListener(this);
		
		JPanel menu = new JPanel();
		menu.setBackground(kolor);
		menu.setSize(710,160);
		menu.setLocation(20,60);
		menu.setLayout(null);
		menu.setVisible(true);
		panelPlanszy.add(menu);
		
	
		
		JButton guzikMenu = new JButton(new ImageIcon("guzikMenu3.png"));
		guzikMenu.setBackground(kolor);
		guzikMenu.setBounds(100, 50, 200, 60);
		menu.add(guzikMenu);
		
		JButton guzikMenu2 = new JButton(new ImageIcon("pauzaMenu.png"));
		guzikMenu2.setBackground(kolor);
		guzikMenu2.setBounds(400, 50, 200, 60);
		menu.add(guzikMenu2);
		
		JPanel polePunktow = new JPanel();
		polePunktow.setBackground(kolor);
		polePunktow.setSize(200,420);
		polePunktow.setLayout(null);
		polePunktow.setLocation(20,240);
		polePunktow.setVisible(true);
		panelPlanszy.add(polePunktow);
		
		Font czcionkaCele = new Font("Italic", 0, 28);
		JLabel cele = new JLabel();
		cele.setVisible(true);
		cele.setBounds(70, 20, 60, 40);
		cele.setText("Cele");
		cele.setFont(czcionkaCele);
		
		
		
		polePunktow.add(cele);
		
		
		
		
		start(plansza,  polePunktow);
	}
	
	
	//sumuje parami wartosci kwadratow i wyswietla je w panelu bocznym
	public void sumator( JPanel polePunktow ) {

		int sumaLiczb = 0;
		for(int i = 0 ; i < startoweKwadraty; i++)
		{
			wartosciKwadratow[i] = Integer.parseInt(wybrane[i]);
			//System.out.println(wartosciKwadratow[i]); //wydrukowac wylosowane wartosci
			//System.out.println(wybrane[i]);
			sumaLiczb = sumaLiczb + wartosciKwadratow[i];
	
			if(i % 2 == 1) {
				sumy[i] = sumaLiczb; //zapelnia elementy tablicy 1,3,5 itd.
				//System.out.println(sumy[i]);
				Sumy suma = new Sumy(20 * i + 30 , sumaLiczb); // wpisuje sumy do uzyskania w panel boczny
				polePunktow.add(suma);
				sumaLiczb = 0;
			}
		}
	}
	
	public static int[] returner() {
		
		System.out.println("wywolano returner z planszy");
		System.out.println(sumy[1]);
		System.out.println(sumy[3]);
		
		return sumy;
		
	}
	
	//wywoluje rysowanie planszy oraz sumowanie parami wylosowanych wartosci kwadratow
	public void start(JPanel plansza, JPanel polePunktow){
		rysujPlansze(plansza);
		
		int licznik = 0;
		
		for(int i = 0 ; i < startoweKwadraty; i++){
			losujWartosci(plansza, licznik);
			licznik++;
		}

			sumator( polePunktow);
	}
	
	//nadaje wartosci guzikom na planszy
	public void losujWartosci(JPanel plansza, int licznik) {
		
		Random random = new Random();
		int mozliweWartosci[] = {-9,-8,-7,-6,-5,-4,-3,-2,-1,1,2,3,4,5,6,7,8,9};
		int lokacja = random.nextInt(RZEDY * KOLUMNY);//mozliwe wyskoczenie cyferek
		int rzad = lokacja / RZEDY;
		int kolumna = lokacja % KOLUMNY;
		int losowa = random.nextInt(18);		
		String wartosc = Integer.toString(mozliweWartosci[losowa]);
		tablica[rzad][kolumna].setText(wartosc);		
		wybrane[licznik] = wartosc;
		
	}
	
	//tworzenie guzikow
	public void rysujPlansze(JPanel plansza){
		
	ButtonController controller = new ButtonController();
    for(int k=0;k < 7;k++){
            for(int m=0;m < 7;m++){
          
                    tablica[k][m] = new Guzik(controller, k * 7 + m, " ");
                    plansza.add(tablica[k][m]);      
                    
               }
    	}
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		int a = e.getX();
		int b = e.getY();
		System.out.println(a + " " +b);
		
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