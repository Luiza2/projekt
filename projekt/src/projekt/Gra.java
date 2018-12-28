package projekt;

import javax.swing.JFrame;

/**
 * Okno g��wne gry
 * @author Luiza B�aszczak
 */

public class Gra extends JFrame {

	private static final long serialVersionUID = 1L;
	/**
     * G��wny konstruktor klasy - ustawienie parametr�w i rozpocz�cie akcji
     * @param szerokosc szeroko�� okna gry
     * @param wysokosc wysoko�� okna gry
     * @param calkowityCzas czas gry
     */
	
	public Gra(int szerokosc, int wysokosc){
		
		super("��czenie cyferek"); //wywo�anie konstruktora klasy nadrz�dnej - utworzenie okna
		setSize(szerokosc, wysokosc); //ustawienie wymiar�w okna	
		setResizable(false); //nie mo�na zmienia� wymiar�w okna
		setLocationRelativeTo(null); //okno pojawi si� w centrum ekranu
		inicjalizacja(szerokosc, wysokosc); //wywo�anie metody tworzenia interfejsu
		setVisible(true); //okno widoczne
		petlaGry(); //wywo�anie metody - p�tla animacji gry
			
	}
	
	/**
	 * Metoda s�u��ca do tworzenia interfejsu graficznego
	 * @param szerokosc szeroko�� okna
	 * @param wysokosc wysoko�� okna
	 */
	public void inicjalizacja(int szerokosc, int wysokosc) {
		 Kontener.zaladujZdjecie();
		 Plansza plansza = new Plansza(szerokosc,wysokosc); //utworzenie obiektu typu plansza
		 add(plansza); //dodanie planszy do okna
	}//inicjalizacja()
	
	/**
	 * P�tla g��wna gry
	 * @param timer s�u�y do od�wie�ania ekranu co sekund� i liczenia czasu trwania gry
	 */
	public void petlaGry() {
		long timer = System.currentTimeMillis(); //pobranie aktualnego czasu w milisekundach			
		while(true){ //niesko�czona p�tla programu
			if(System.currentTimeMillis()- timer > 1000){ //je�li min�a sekunda
				repaint(); //od�wie� ekran
				timer += 1000;
			}
		}
	}//petlaGry()
	
}