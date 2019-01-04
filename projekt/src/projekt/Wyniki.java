package projekt;

import java.awt.Image;


/**
 * Klasa odpowiadaj¹ca za wyniki rysowane w panelu bocznym
 * @author Luiza B³aszczak
 */
public class Wyniki {

	/** Wspó³rzêdna x wyniku z panelu bocznego */
    public int x;
    /** Wspó³rzêdna y wyniku z panelu bocznego*/
    public int y;
    /** Wartosc wyniku*/
    public int wartosc;
    /** Ikona wyniku do uzyskania i wyniku po poprawnym obliczeniu*/
    public Image ikona;
    
    
    public Wyniki(int x, int y, Image[] zdjecie, int wartosc) {
        this.x=x;
        this.y=y;
        this.wartosc = wartosc;
        /*jeœli wynik mia³ wartoœæ niedodatni¹ to ten fragment przyporz¹dkowuje 
         * odpowiednie obrazki. Ich indeksy zaczynaj¹ siê od 18 w tablicy
         * Images. 37 - 18 = 19, a zdjêcie wybierane dla wyniku ma indeks 
         * wartosc - 1, czyli mo¿liwe indeksy do wybrania znajduj¹ siê 
         * w przedziale <18, 36>
         */
        if(wartosc < 1) { //37 - 18 = 19
        	wartosc = wartosc + 37;
        }
        // wartosc cyfry na obrazku to nr zdjecia
        ikona = zdjecie[wartosc-1];
 	
    }    
}
