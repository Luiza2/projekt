package projekt;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JPanel;



public class Plansza implements MouseListener {

	public static int RZEDY = 7, KOLUMNY = 7;
	Guzik[][] tablica = new Guzik[7][7];
	int startingTiles = 4;
	int licznik = 0;
	public int sumy[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	String wybrane[] = {" "," "," "," "," "," "," "," "," "," "," "," "," "," "," " };
	int wartosciKwadratow [] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	
	Plansza(JPanel panelPlanszy) {
		
		JPanel plansza = new JPanel();
		plansza.setBackground(Color.pink);
		plansza.setSize(420,420);
		plansza.setLocation(240,240);
		plansza.setVisible(true);
		plansza.setLayout(new GridLayout(7,7));
		panelPlanszy.add(plansza);
		
		panelPlanszy.addMouseListener(this);
		
		JPanel menu = new JPanel();
		menu.setBackground(Color.blue);
		menu.setSize(860,160);
		menu.setLocation(20,60);
		menu.setVisible(true);
		panelPlanszy.add(menu);
		
		
		JPanel polePunktow = new JPanel();
		polePunktow.setBackground(Color.blue);
		polePunktow.setSize(200,420);
		polePunktow.setLayout(null);
		polePunktow.setLocation(20,240);
		
		panelPlanszy.add(polePunktow);
			
		polePunktow.setVisible(true);
		
		
		start(plansza,  polePunktow);
	}
	
	
	
	public void sumator( JPanel polePunktow ) {
		// konwersja ze stringow na inty zeby sumowac sobie wartosci
		int sumaLiczb = 0;
		for(int i = 0 ; i < startingTiles; i++)
		{
			wartosciKwadratow[i] = Integer.parseInt(wybrane[i]);
			//System.out.println(wartosciKwadratow[i]); //odkomentowac jesli wydrukowac wylosowane wartosci
			//System.out.println(wybrane[i]);
			sumaLiczb = sumaLiczb + wartosciKwadratow[i];
			
			if(i % 2 == 1) {
				sumy[i] = sumaLiczb;
				System.out.println(sumy[i]);
				Sumy suma = new Sumy(20 * i , sumaLiczb); // wpisuje sumy do uzyskania w panel boczny
				//System.out.println(i);
				polePunktow.add(suma);
				sumaLiczb = 0;
			}
		}
		

	}
	
	//wywoluje rysowanie planszy
	private void start(JPanel plansza, JPanel polePunktow){
		rysujPlansze(plansza);
		
		int licznik = 0;
		
		for(int i = 0 ; i < startingTiles; i++){
			losujWartosci(plansza, licznik);
			licznik++;
		}

			sumator( polePunktow);
	}
	
	//nadaje wartosci buttonom
	public void losujWartosci(JPanel plansza, int licznik) {
		Random random = new Random();
		//boolean notValid = true;
		
		int mozliweWartosci[] = {-9,-8,-7,-6,-5,-4,-3,-2,-1,1,2,3,4,5,6,7,8,9};
		int location = random.nextInt(RZEDY * KOLUMNY);//mozliwe wyskoczenie cyferek
		int row = location / RZEDY;
		int col = location % KOLUMNY;
		int losowa = random.nextInt(9);		
		String wartosc = Integer.toString(mozliweWartosci[losowa]);
		tablica[row][col].setText(wartosc);					
		wybrane[licznik] = wartosc;
		
		
		
	}
	
	public void rysujPlansze(JPanel plansza){
		
	ButtonController controller = new ButtonController();
	
    for(int k=0;k < 7;k++){
            for(int m=0;m < 7;m++){
          
                    tablica[k][m] = new Guzik(controller, k * 7 + m);
                    //tablica[k][m].addMouseListener(this);
                    plansza.add(tablica[k][m]);      
                    //System.out.println(k * 7 + m);
               }
    }
	}
	
	public int sprawdz() {
		int numer = 0;
		for(int k=0;k < 7;k++){
            for(int m=0;m < 7;m++){
                   	if(tablica[k][m].getValue() == wybrane[0]) {
                   		numer = tablica[k][m].podajLokacje();
                   		//tablica[k][m].podajLokacje() = miejsce;
                   		//System.out.println(tablica[k][m].getValue());
                   	}
                   	
               }
		}
		System.out.println(numer);
		return numer;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		int a = e.getX();
		int b = e.getY();
		//System.out.println(a + " " +b);
		
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