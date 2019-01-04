package projekt;

/**
 * Odpowiada za poziom gry
 * @author Luiza Błaszczak
 */
public class Poziom {
	
    /** Numer poziomu */
    public int poziom;
    
    /**
     * Ustawienie początkowego poziomu
     */
    public void reset(){       
    	poziom = 1;
    }//koniec reset()
      
    /**
     * Zwiększenie poziomu
     */
    public void nastepnyPoziom(){
    	poziom++;
    }//koniec nastepnyPoziom()	
}
