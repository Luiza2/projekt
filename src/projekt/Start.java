package projekt;

/**
 * Interaktywna gra "£¹czenie cyferek" stworzona 
 * na przedmiot Jêzyki Programowania Wysokiego Poziomu
 * @author Luiza B³aszczak
 */


public class Start {

	/**
     * Metoda uruchamiaj¹ca grê. Tworzony jest panel gry o podanych wymiarach
     * SZEROKOSC, WYSOKOSC
     */
	
	public static void main(String[] args){
			
		/** szerokoœæ pola gry*/
		int SZEROKOSC = 778;
		/** wysokoœæ pola gry*/
		int WYSOKOSC = 778;
		//utworzenie obiektu klasy Gra
		Gra gra = new Gra(SZEROKOSC, WYSOKOSC);				
		
	}
	
}