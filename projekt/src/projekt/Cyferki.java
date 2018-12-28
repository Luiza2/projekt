package projekt;

import java.awt.Image;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Klasa odpowiadaj¹ca za cyferki
 * @author Luiza B³aszczak
 */
public class Cyferki {

	/** Wspó³rzêdna x obiektu */
    public int x;
    /** Wspó³rzêdna y obiektu */
    public int y;
    /** Szerokoœæ obrazka cyferki  */
    public int szerokoscCyferki;
    /** Wysokoœæ obrazka cyferki */
    public int wysokoscCyferki;
    /** Wartosc obrazka z cyferk¹ */
    public int wartosc;
    /** Ikona obiektu cyferki*/
    public Image icon;
    
    public Cyferki(int x, int y, Image[] images, int wartosc) {
        this.x=x;
        this.y=y;
        this.wartosc = wartosc;
    
        /*
         * gdy wartosc cyfry jest ujemna to przyporz¹dkowuje zdjêcie
         * o odpowiednim indeksie
         */
        if(wartosc < 0) {
        	wartosc = wartosc + 19;
        }
        icon=images[wartosc-1];
        
        //potrzebne do obliczania, czy klikniêty punkt znajduje siê w obszarze obrazka cyfry
        szerokoscCyferki=icon.getWidth(null);
        wysokoscCyferki=icon.getHeight(null);
 
    }
	
    /**
     * Po klikniêciu na obraz cyfry zwraca jej wartoœæ i uruchamia dzwiêk klikniêcia
     * 
     */
    public int podajWartosc() {
    	dzwiek(new File("dzwieki/klik.wav"));
    	return wartosc;
    }//podajWartosc()
    
    
  
   
    /**
     * Metoda sprawdzaj¹ca czy punkt klikniety na planszy zawiera siê w obszarze obrazka którejœ z cyferek
     * @param a wspó³rzêdna x kliniêcia
     * @param b wspó³rzêdna y klikniêcia
     */
    public boolean czyZawieraKlikniecie(int a, int b){
        if(a >= x && a < x + szerokoscCyferki){
            if(b >= y && b < y + wysokoscCyferki){
                return true;
            }
        } 
        return false;
    }//czyZawieraKlikniecie()
    
    
    
    //metoda s³u¿¹ca do uruchamiania plików dzwiêkowych
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
