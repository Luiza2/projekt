package projekt;

/**
 * Interaktywna gra "��czenie cyferek" stworzona 
 * na przedmiot J�zyki Programowania Wysokiego Poziomu
 * @author Luiza B�aszczak
 */


public class Start {

	/**
     * Metoda uruchamiaj�ca gr�. Tworzony jest panel gry o podanych wymiarach
     * SZEROKOSC, WYSOKOSC
     */
	
	public static void main(String[] args){
			
		/** szeroko�� pola gry*/
		int SZEROKOSC = 778;
		/** wysoko�� pola gry*/
		int WYSOKOSC = 778;
		//utworzenie obiektu klasy Gra
		Gra gra = new Gra(SZEROKOSC, WYSOKOSC);				
		
	}
	
}