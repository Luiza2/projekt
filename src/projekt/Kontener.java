package projekt;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * Klasa s�u��ca jako kontener parametr�w, s�u�y do zapisu stanu gry
 * (wej�cie do menu, pauza, restart) oraz do odczytywania parametr�w
 * z pliku (zdj��)
 * @author Luiza B�aszczak
 */
public class Kontener {
	/** Zmienna przechowuj�ca czas do ko�ca gry */
	public static int czasGry;
	/** Obraz t�a gry   */
    public static Image tlo;
    /** Zmienna stanu okre�laj�ca czy jest przerwa w grze   */
    public static boolean pauza=false;
    /** Zmienna stanu okre�laj�ca czy znajdujemy si� w menu g��wnym gry   */
    public static boolean menu = true;
    /** Zmienna stanu okre�laj�ca czy w��czono opis gry i instrukcj�   */
    public static boolean instrukcja = false;
    /** Tablica obiekt�w na planszy - cyferek   */
	public static Image[] cyferki;
	/** Tablica obiektow pierwszego planu - sum w bocznym panelu */
	public static Image[] sumki;
	/** Ilo�� sum do uzyskania = startowe / 2 */ 
	public static int startowe=4;
    /** Obraz ikony menu   */
    public static Image menuObraz;
    /** Obraz strony startowej   */
    public static Image startowaObraz;
    /** Obraz strony z instrukcj�   */
    public static Image instrukcjaObraz;
    /** Obraz strony ko�cowej gry   */
    public static Image koniecObraz;
    /** Obraz ikony pauza   */
    public static Image pauzaObraz;
    /** Obraz ikony restartu */
    public static Image restartObraz;
    /** Obraz zas�onki na pauz� */
    public static Image zaslonaObraz;
    /** Obraz ikony wznowienia gry   */
    public static Image wznowObraz;
    /** Tablica obrazk�w sum kt�re zosta�y poprawnie obliczone*/
    public static Image[] obliczoneSumy;
    /**czy zmienic kolor sumy w panelu po lewej stronie po prawid�owym zsumowaniu cyferek*/
    public static boolean czyZmienic = false;
    
    /**
     * Metoda s�u��ca do za�adowania obrazk�w .png z plik�w
     */
    public static void zaladujZdjecie() {
        
    	
    	//menu podczas gry w pasku g�rnym
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

