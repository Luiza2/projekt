package projekt;

/**
 * Odpowiada za status gry
 * @author Luiza B³aszczak
 */
public class StatusGry {

	
    /** Numer poziomu */
    public int poziom;
    
    /**
     * Zerowanie poziomu
     */
    public void reset(){       
    	poziom=1;
    }
    
   
    /**
     * Zwiêkszenie poziomu
     */
    public void nastepnyPoziom(){
    	poziom++;
    }//nastepnyPoziom()
	
}

