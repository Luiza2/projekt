package projekt;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * Klasa s³u¿¹ca jako kontener parametrów, s³u¿y do zapisu stanu gry
 * (wejœcie do menu, pauza, restart) oraz do odczytywania parametrów
 * z pliku (zdjêæ)
 * @author Luiza B³aszczak
 */
public class Kontener {
	/** Zmienna przechowuj¹ca czas do koñca gry */
	public static int czasGry;
	/** Obraz t³a gry   */
    public static Image tlo;
    /** Zmienna stanu okreœlaj¹ca czy jest przerwa w grze   */
    public static boolean pauza=false;
    /** Zmienna stanu okreœlaj¹ca czy znajdujemy siê w menu g³ównym gry   */
    public static boolean menu = true;
    /** Zmienna stanu okreœlaj¹ca czy w³¹czono opis gry i instrukcjê   */
    public static boolean instrukcja = false;
    /** Tablica obiektów na planszy - cyferek   */
	public static Image[] cyferki;
	/** Tablica obiektow pierwszego planu - sum w bocznym panelu */
	public static Image[] sumki;
	/** Iloœæ sum do uzyskania = startowe / 2 */ 
	public static int startowe=4;
    /** Obraz ikony menu   */
    public static Image menuObraz;
    /** Obraz strony startowej   */
    public static Image startowaObraz;
    /** Obraz strony z instrukcj¹   */
    public static Image instrukcjaObraz;
    /** Obraz strony koñcowej gry   */
    public static Image koniecObraz;
    /** Obraz ikony pauza   */
    public static Image pauzaObraz;
    /** Obraz ikony restartu */
    public static Image restartObraz;
    /** Obraz zas³onki na pauzê */
    public static Image zaslonaObraz;
    /** Obraz ikony wznowienia gry   */
    public static Image wznowObraz;
    /** Tablica obrazków sum które zosta³y poprawnie obliczone*/
    public static Image[] obliczoneSumy;
    /**czy zmienic kolor sumy w panelu po lewej stronie po prawid³owym zsumowaniu cyferek*/
    public static boolean czyZmienic = false;
    
    /**
     * Metoda s³u¿¹ca do za³adowania obrazków .png z plików
     */
    public static void zaladujZdjecie() {
        
    	
    	//menu podczas gry w pasku górnym
        menuObraz=zaladujZdjecie("zdjecia/guzikMenu.png");
        pauzaObraz=zaladujZdjecie("zdjecia/pauzaMenu.png");
        restartObraz=zaladujZdjecie("zdjecia/restartMenu.png");
        wznowObraz=zaladujZdjecie("zdjecia/wznowMenu.png");
        
        tlo = zaladujZdjecie("zdjecia/plansza.png");
        startowaObraz=zaladujZdjecie("zdjecia/startowa.png");
        instrukcjaObraz=zaladujZdjecie("zdjecia/instrukcja.png");
        koniecObraz = zaladujZdjecie("zdjecia/koniec.png");
        zaslonaObraz = zaladujZdjecie("zdjecia/zaslona.png");
        
        //obraz sum po obliczeniu
        obliczoneSumy = new Image[37];
        for(int i = 0 ; i < 37 ; i++) {
        	obliczoneSumy[i] = zaladujZdjecie("zdjecia/zaznaczone/1.png");
        }
        
        //cyfry dodatnie na planszy
        cyferki = new Image[18];
        for( int i = 0 ; i < 9 ; i++)
        {
        	cyferki[i]=zaladujZdjecie("zdjecia/cyferki/" +(i+1)+ ".png");
        }
        
        for(int i = 9 ; i < 18; i++) {
        	cyferki[i]=zaladujZdjecie("zdjecia/cyferki/" +(i-18)+ ".png");
        }
        
        // sumy do uzyskania
        sumki = new Image[37];
        
        for(int i = 0 ; i < 18; i++) {
        	sumki[i]=zaladujZdjecie("zdjecia/sumki/" +(i+1)+ ".png");
        }
        
        for(int i = 18; i < 37; i++) {
        	sumki[i]=zaladujZdjecie("zdjecia/sumki/" +(i-36)+ ".png");
        }
        
    }//koniec zaladujZdjecie()
    
    /**
     * Pobieranie obiektu klasy Image o podanej nazwie
     */
    public static Image zaladujZdjecie(String fileName) {
        return new ImageIcon(fileName).getImage();
    }//koniec zaladujZdjecie()
}

