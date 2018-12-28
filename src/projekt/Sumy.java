package projekt;

import java.awt.Image;
import java.awt.Point;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sumy {

	/** Wsp�rz�dna x sumy */
    public int x;
    /** Wsp�rz�dna y sumy */
    public int y;
    /** Wartosc sumy*/
    public int wartosc;
    /** Ikona sumy do uzyskania i sumy po poprawnym obliczeniu*/
    public Image icon;
    
    
    public Sumy(int x, int y, Image[] images, int wartosc) {
        this.x=x;
        this.y=y;
        this.wartosc = wartosc;
        /*je�li suma mia�a warto�� niedodatni� to ten fragment przyporz�dkowuje 
         * odpowiednie obrazki. Ich indeksy zaczynaj� si� od 18 w tablicy
         * Images. 37 - 18 = 19, a zdj�cie wybierane dla sumy ma indeks 
         * wartosc - 1, czyli mo�liwe indeksy do wybrania znajduj� si� 
         * w przedziale <18, 36>
         */
        if(wartosc < 1) { //37 - 18 = 19
        	wartosc = wartosc + 37;
        }
        // wartosc cyfry na ograzku to nr foty
        icon=images[wartosc-1];
 
    	
    }
	
     
}
