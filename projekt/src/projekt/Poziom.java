package projekt;

/**
 * Odpowiada za poziom gry
 * @author Luiza B³aszczak
 */
public class Poziom {
	
    /** Numer poziomu */
    public int poziom;
    
    /**
     * Ustawienie pocz¹tkowego poziomu
     */
    public void reset(){       
    	poziom = 1;
    }//koniec reset()
      
    /**
     * Zwiêkszenie poziomu
     */
    public void nastepnyPoziom(){
    	poziom++;
    }//koniec nastepnyPoziom()	
}
