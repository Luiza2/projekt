package projekt;

import javax.swing.JFrame;

/**
 * Okno g³ówne gry
 * @author Luiza B³aszczak
 */
public class Gra extends JFrame {

	private static final long serialVersionUID = 1L;
	
	/**
     * Konstruktor klasy s³u¿y do utworzenia okna i rozpoczêcia gry
     * @param szerokosc szerokoœæ okna gry
     * @param wysokosc wysokoœæ okna gry
     */
	public Gra(int szerokosc, int wysokosc){
		
		super("£¹czenie cyferek"); //utworzenie okna
		setSize(szerokosc, wysokosc); //ustawienie wymiarów okna	
		setResizable(false); //nie mo¿na zmieniaæ wymiarów okna
		setLocationRelativeTo(null); //okno wyœrodkuje siê na ekranie
		inicjalizacja(szerokosc, wysokosc); //wywo³anie metody tworzenia interfejsu
		setVisible(true); //okno widoczne
		petlaGry(); //wywo³anie pêtli gry
			
	}
	
	/**
	 * Metoda s³u¿¹ca do tworzenia interfejsu graficznego
	 * @param szerokosc szerokoœæ okna
	 * @param wysokosc wysokoœæ okna
	 */
	public void inicjalizacja(int szerokosc, int wysokosc) {
		 Kontener.zaladujZdjecie();
		 Plansza plansza = new Plansza(szerokosc,wysokosc); //utworzenie obiektu typu plansza
		 add(plansza); //dodanie planszy do okna
	}//koniec inicjalizacja()
	
	/**
	 * Pêtla g³ówna gry
	 */
	public void petlaGry() {
		long timer = System.currentTimeMillis(); //pobranie aktualnego czasu w milisekundach			
		while(true){ //nieskoñczona pêtla programu
			if(System.currentTimeMillis()- timer > 1000){ //jeœli minê³a sekunda
				repaint(); //odœwie¿ ekran
				timer += 1000;
			}
		}
	}//koniec petlaGry()
	
}