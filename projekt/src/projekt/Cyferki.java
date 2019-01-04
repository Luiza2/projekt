package projekt;

import java.awt.Image;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Klasa odpowiadaj¹ca za cyferki pojawiaj¹ce siê na planszy
 * @author Luiza B³aszczak
 */
public class Cyferki {

	/** Ikona obiektu cyferki*/
    public Image ikona;
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
    
    
    public Cyferki(int x, int y, Image[] zdjecie, int wartosc) {
        this.x = x;
        this.y = y;
        this.wartosc = wartosc;
    
        /*
          gdy wartosc cyfry jest ujemna to przyporz¹dkowuje zdjêcie
          o odpowiednim indeksie
         */
        if(wartosc < 0) {
        	wartosc = wartosc + 19;
        }
        ikona = zdjecie[wartosc-1];
        //potrzebne do obliczania, czy klikniêty punkt znajduje siê w obszarze obrazka cyfry
        szerokoscCyferki = ikona.getWidth(null);
        wysokoscCyferki = ikona.getHeight(null);
    }
	
    /**
     * Po klikniêciu na obraz cyfry zwraca jej wartoœæ i uruchamia dzwiêk klikniêcia
     * @return wartosc
     */
    public int podajWartosc() {
    	dzwiek("dzwieki/klik.wav");
    	return wartosc;
    }//koniec podajWartosc()
    
    /**
     * Metoda sprawdzaj¹ca czy punkt klikniety na planszy zawiera siê w obszarze obrazka którejœ z cyferek
     * @param a wspó³rzêdna x kliniêcia
     * @param b wspó³rzêdna y klikniêcia
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
     * Metoda s³u¿¹ca do uruchamiania plików dzwiêkowych
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
