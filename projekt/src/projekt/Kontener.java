package projekt;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * Klasa s³u¿¹ca jako kontener parametrów, s³u¿y do zapisu stanu gry (wejœcie do menu, pauza, restart) i do odczytywania zdjêæ z pliku
 * @author Luiza B³aszczak
 */
public class Kontener {
	/** Zmienna przechowuj¹ca czas do koñca gry */
	public static int czasGry;
	/** Obraz t³a gry   */
    public static Image tlo;
    /** Zmienna stanu okreœlaj¹ca czy jest przerwa w grze   */
    public static boolean pauza = false;
    /** Zmienna stanu okreœlaj¹ca czy znajdujemy siê w menu g³ównym gry   */
    public static boolean menu = true;
    /** Zmienna stanu okreœlaj¹ca czy w³¹czono instrukcjê gry   */
    public static boolean instrukcja = false;
    /** Tablica obiektów na planszy - cyferek   */
	public static Image[] cyferki;
	/** Tablica obiektow - wyników w bocznym panelu */
	public static Image[] wyniki;
	/** Iloœæ wyników do uzyskania = startowe / 2 */ 
	public static int startowe=4;
    /** Obraz przycisku menu   */
    public static Image menuObraz;
    /** Obraz strony startowej   */
    public static Image startowaObraz;
    /** Obraz strony z instrukcj¹   */
    public static Image instrukcjaObraz;
    /** Obraz strony koñcowej gry   */
    public static Image koniecObraz;
    /** Obraz przycisku pauza   */
    public static Image pauzaObraz;
    /** Obraz przycisku restartu */
    public static Image restartObraz;
    /** Obraz zas³onki planszy podczas pauzy */
    public static Image zaslonaObraz;
    /** Obraz przycisku wznowienia gry   */
    public static Image wznowObraz;
    /** Tablica obrazków wyników które zosta³y poprawnie obliczone*/
    public static Image[] obliczoneWyniki;
    /** Czy zmienic kolor sumy w panelu po lewej stronie po prawid³owym dodaniu/odjêciu cyferek*/
    public static boolean czyZmienic = false;
    
    /**
     * Metoda s³u¿¹ca do za³adowania obrazków z plików
     */
    public static void zaladujZdjecie() {
        
    	//obrazki guzików w menu podczas gry w pasku górnym
        menuObraz=zaladujZdjecie("zdjecia/guzikMenu.png");
        pauzaObraz=zaladujZdjecie("zdjecia/pauzaMenu.png");
        restartObraz=zaladujZdjecie("zdjecia/restartMenu.png");
        wznowObraz=zaladujZdjecie("zdjecia/wznowMenu.png");
        
        //obrazki pocz¹tku, koñca, instrukcja, plansza, zas³ona na planszê
        tlo = zaladujZdjecie("zdjecia/plansza.png");
        startowaObraz=zaladujZdjecie("zdjecia/startowa.png");
        instrukcjaObraz=zaladujZdjecie("zdjecia/instrukcja.png");
        koniecObraz = zaladujZdjecie("zdjecia/koniec.png");
        zaslonaObraz = zaladujZdjecie("zdjecia/zaslona.png");
        
        //obraz wyników po obliczeniu
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
     * Wczytywanie zdjêæ z plików
     * @param nazwaPliku nazwa wczytywanego pliku
     * @return zdjêcie
     */
    public static Image zaladujZdjecie(String nazwaPliku) {
        return new ImageIcon(nazwaPliku).getImage();
    }//koniec zaladujZdjecie()
}

