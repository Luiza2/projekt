package projekt;

/**
 * Odpowiada za poziom gry
 * @author Luiza B�aszczak
 */
public class Poziom {
	
    /** Numer poziomu */
    public int poziom;
    
    /**
     * Ustawienie pocz�tkowego poziomu
     */
    public void reset(){       
    	poziom = 1;
    }//koniec reset()
      
    /**
     * Zwi�kszenie poziomu
     */
    public void nastepnyPoziom(){
    	poziom++;
    }//koniec nastepnyPoziom()	
}
