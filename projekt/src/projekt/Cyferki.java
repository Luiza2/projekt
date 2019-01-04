package projekt;

import java.awt.Image;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Klasa odpowiadaj�ca za cyferki pojawiaj�ce si� na planszy
 * @author Luiza B�aszczak
 */
public class Cyferki {

	/** Ikona obiektu cyferki*/
    public Image ikona;
	/** Wsp�rz�dna x obiektu */
    public int x;
    /** Wsp�rz�dna y obiektu */
    public int y;
    /** Szeroko�� obrazka cyferki  */
    public int szerokoscCyferki;
    /** Wysoko�� obrazka cyferki */
    public int wysokoscCyferki;
    /** Wartosc obrazka z cyferk� */
    public int wartosc;
    
    
    public Cyferki(int x, int y, Image[] zdjecie, int wartosc) {
        this.x = x;
        this.y = y;
        this.wartosc = wartosc;
    
        /*
          gdy wartosc cyfry jest ujemna to przyporz�dkowuje zdj�cie
          o odpowiednim indeksie
         */
        if(wartosc < 0) {
        	wartosc = wartosc + 19;
        }
        ikona = zdjecie[wartosc-1];
        //potrzebne do obliczania, czy klikni�ty punkt znajduje si� w obszarze obrazka cyfry
        szerokoscCyferki = ikona.getWidth(null);
        wysokoscCyferki = ikona.getHeight(null);
    }
	
    /**
     * Po klikni�ciu na obraz cyfry zwraca jej warto�� i uruchamia dzwi�k klikni�cia
     * @return wartosc
     */
    public int podajWartosc() {
    	dzwiek("dzwieki/klik.wav");
    	return wartosc;
    }//koniec podajWartosc()
    
    /**
     * Metoda sprawdzaj�ca czy punkt klikniety na planszy zawiera si� w obszarze obrazka kt�rej� z cyferek
     * @param a wsp�rz�dna x klini�cia
     * @param b wsp�rz�dna y klikni�cia
     * @return boolean
     */
    public boolean czyZawieraKlikniecie(int a, int b){
        if(a >= x && a < x + szerokoscCyferki){
            if(b >= y && b < y + wysokoscCyferki){
                return true;
            }
        } 
        return false;
    }//koniec czyZawieraKlikniecie()
    
    /**
     * Metoda s�u��ca do uruchamiania plik�w dzwi�kowych
     * @param nazwaPliku nazwa odczytywanego pliku
     */  
    public static void dzwiek(String nazwaPliku) {  try
    {
        Clip clip = AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(new File(nazwaPliku)));
        clip.start();
    }
    catch (Exception exc)
	    {
	        exc.printStackTrace(System.out);
	    }
    }//koniec dzwiek()	   
}
