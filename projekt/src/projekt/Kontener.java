package projekt;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * Klasa s�u��ca jako kontener parametr�w, s�u�y do zapisu stanu gry (wej�cie do menu, pauza, restart) i do odczytywania zdj�� z pliku
 * @author Luiza B�aszczak
 */
public class Kontener {
	/** Zmienna przechowuj�ca czas do ko�ca gry */
	public static int czasGry;
	/** Obraz t�a gry   */
    public static Image tlo;
    /** Zmienna stanu okre�laj�ca czy jest przerwa w grze   */
    public static boolean pauza = false;
    /** Zmienna stanu okre�laj�ca czy znajdujemy si� w menu g��wnym gry   */
    public static boolean menu = true;
    /** Zmienna stanu okre�laj�ca czy w��czono instrukcj� gry   */
    public static boolean instrukcja = false;
    /** Tablica obiekt�w na planszy - cyferek   */
	public static Image[] cyferki;
	/** Tablica obiektow - wynik�w w bocznym panelu */
	public static Image[] wyniki;
	/** Ilo�� wynik�w do uzyskania = startowe / 2 */ 
	public static int startowe=4;
    /** Obraz przycisku menu   */
    public static Image menuObraz;
    /** Obraz strony startowej   */
    public static Image startowaObraz;
    /** Obraz strony z instrukcj�   */
    public static Image instrukcjaObraz;
    /** Obraz strony ko�cowej gry   */
    public static Image koniecObraz;
    /** Obraz przycisku pauza   */
    public static Image pauzaObraz;
    /** Obraz przycisku restartu */
    public static Image restartObraz;
    /** Obraz zas�onki planszy podczas pauzy */
    public static Image zaslonaObraz;
    /** Obraz przycisku wznowienia gry   */
    public static Image wznowObraz;
    /** Tablica obrazk�w wynik�w kt�re zosta�y poprawnie obliczone*/
    public static Image[] obliczoneWyniki;
    /** Czy zmienic kolor sumy w panelu po lewej stronie po prawid�owym dodaniu/odj�ciu cyferek*/
    public static boolean czyZmienic = false;
    
    /**
     * Metoda s�u��ca do za�adowania obrazk�w z plik�w
     */
    public static void zaladujZdjecie() {
        
    	//obrazki guzik�w w menu podczas gry w pasku g�rnym
        menuObraz=zaladujZdjecie("zdjecia/guzikMenu.png");
        pauzaObraz=zaladujZdjecie("zdjecia/pauzaMenu.png");
        restartObraz=zaladujZdjecie("zdjecia/restartMenu.png");
        wznowObraz=zaladujZdjecie("zdjecia/wznowMenu.png");
        
        //obrazki pocz�tku, ko�ca, instrukcja, plansza, zas�ona na plansz�
        tlo = zaladujZdjecie("zdjecia/plansza.png");
        startowaObraz=zaladujZdjecie("zdjecia/startowa.png");
        instrukcjaObraz=zaladujZdjecie("zdjecia/instrukcja.png");
        koniecObraz = zaladujZdjecie("zdjecia/koniec.png");
        zaslonaObraz = zaladujZdjecie("zdjecia/zaslona.png");
        
        //obraz wynik�w po obliczeniu
        obliczoneWyniki = new Image[37];
        for(int i = 0 ; i < 37 ; i++) {
        	obliczoneWyniki[i] = zaladujZdjecie("zdjecia/zaznaczone/1.png");
        }
        
        //cyfry dodatnie na planszy
        cyferki = new Image[18];
        for( int i = 0 ; i < 9 ; i++)
        {
        	cyferki[i]=zaladujZdjecie("zdjecia/cyferki/" +(i+1)+ ".png");
        }
        //cyfry ujemne na planszy
        for(int i = 9 ; i < 18; i++) {
        	cyferki[i]=zaladujZdjecie("zdjecia/cyferki/" +(i-18)+ ".png");
        }
        
        // wyniki do uzyskania (dodatnie)
        wyniki = new Image[37];
        for(int i = 0 ; i < 18; i++) {
        	wyniki[i]=zaladujZdjecie("zdjecia/wyniki/" +(i+1)+ ".png");
        }
        //wyniki do uzyskania (ujemne)
        for(int i = 18; i < 37; i++) {
        	wyniki[i]=zaladujZdjecie("zdjecia/wyniki/" +(i-36)+ ".png");
        }
        
    }//koniec zaladujZdjecie()
    
    /**
     * Wczytywanie zdj�� z plik�w
     * @param nazwaPliku nazwa wczytywanego pliku
     * @return zdj�cie
     */
    public static Image zaladujZdjecie(String nazwaPliku) {
        return new ImageIcon(nazwaPliku).getImage();
    }//koniec zaladujZdjecie()
}

