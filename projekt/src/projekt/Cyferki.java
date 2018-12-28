package projekt;

import java.awt.Image;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Klasa odpowiadaj�ca za cyferki
 * @author Luiza B�aszczak
 */
public class Cyferki {

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
    /** Ikona obiektu cyferki*/
    public Image icon;
    
    public Cyferki(int x, int y, Image[] images, int wartosc) {
        this.x=x;
        this.y=y;
        this.wartosc = wartosc;
    
        /*
         * gdy wartosc cyfry jest ujemna to przyporz�dkowuje zdj�cie
         * o odpowiednim indeksie
         */
        if(wartosc < 0) {
        	wartosc = wartosc + 19;
        }
        icon=images[wartosc-1];
        
        //potrzebne do obliczania, czy klikni�ty punkt znajduje si� w obszarze obrazka cyfry
        szerokoscCyferki=icon.getWidth(null);
        wysokoscCyferki=icon.getHeight(null);
 
    }
	
    /**
     * Po klikni�ciu na obraz cyfry zwraca jej warto�� i uruchamia dzwi�k klikni�cia
     * 
     */
    public int podajWartosc() {
    	dzwiek(new File("dzwieki/klik.wav"));
    	return wartosc;
    }//podajWartosc()
    
    
  
   
    /**
     * Metoda sprawdzaj�ca czy punkt klikniety na planszy zawiera si� w obszarze obrazka kt�rej� z cyferek
     * @param a wsp�rz�dna x klini�cia
     * @param b wsp�rz�dna y klikni�cia
     */
    public boolean czyZawieraKlikniecie(int a, int b){
        if(a >= x && a < x + szerokoscCyferki){
            if(b >= y && b < y + wysokoscCyferki){
                return true;
            }
        } 
        return false;
    }//czyZawieraKlikniecie()
    
    
    
    //metoda s�u��ca do uruchamiania plik�w dzwi�kowych
    public static synchronized void dzwiek(final File f) {
        new Thread(new Runnable() {
          public void run() {
            try {
              Clip clip = AudioSystem.getClip();
              AudioInputStream inputStream = AudioSystem.getAudioInputStream(f);
              clip.open(inputStream);
              clip.start(); 
            } catch (Exception e) {
              System.err.println(e.getMessage());
            }
          }
        }).start();
    }//dzwiek()	
    	
    
}
