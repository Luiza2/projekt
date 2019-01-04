package projekt;

import java.awt.Image;


/**
 * Klasa odpowiadaj�ca za wyniki rysowane w panelu bocznym
 * @author Luiza B�aszczak
 */
public class Wyniki {

	/** Wsp�rz�dna x wyniku z panelu bocznego */
    public int x;
    /** Wsp�rz�dna y wyniku z panelu bocznego*/
    public int y;
    /** Wartosc wyniku*/
    public int wartosc;
    /** Ikona wyniku do uzyskania i wyniku po poprawnym obliczeniu*/
    public Image ikona;
    
    
    public Wyniki(int x, int y, Image[] zdjecie, int wartosc) {
        this.x=x;
        this.y=y;
        this.wartosc = wartosc;
        /*je�li wynik mia� warto�� niedodatni� to ten fragment przyporz�dkowuje 
         * odpowiednie obrazki. Ich indeksy zaczynaj� si� od 18 w tablicy
         * Images. 37 - 18 = 19, a zdj�cie wybierane dla wyniku ma indeks 
         * wartosc - 1, czyli mo�liwe indeksy do wybrania znajduj� si� 
         * w przedziale <18, 36>
         */
        if(wartosc < 1) { //37 - 18 = 19
        	wartosc = wartosc + 37;
        }
        // wartosc cyfry na obrazku to nr zdjecia
        ikona = zdjecie[wartosc-1];
 	
    }    
}
