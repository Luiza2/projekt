package projekt;

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
     * Zwi�kszenie poziomu
     */
    public void nastepnyPoziom(){
    	poziom++;
    }//nextLevel()
	
}

