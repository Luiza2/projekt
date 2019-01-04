package projekt;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.Vector;

import javax.swing.JPanel;


/**
 * Odpowiada za operacje wykonywane na planszy, przechodzenie pomiêdzy poziomami menu, wyœwietlanie wyniku, obs³ugê myszki
 * @author Luiza B³aszczak
 */
public class Plansza extends JPanel{
	
	private static final long serialVersionUID = 1L;
	/** Czas gry */
	public static int czas = 200;
	/** Tablica przechowujaca wylosowane cyfry*/
	public int [] wylosowane = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	/** Obiekt poziomu gry*/
	public Poziom Poziom;
	/** Szerokoœæ pola graficznego gry*/
	public int sSzerokosc;
	/** Wysokoœæ pola graficznego gry*/
	public int sWysokosc;
	/** Iloœæ rzêdów */
	public static int RZEDY = 7;
	/** Iloœæ kolumn planszy */
	public static int KOLUMNY = 7;
    /** Czcionka stosowana w pasku menu gry */
    public Font graFont = new Font("Dialog", Font.BOLD , 26);
	/** Tablica obiektów cyferek*/
	private Cyferki [] cyferki;
	/** Tablica wyników do narysowania */
	private Wyniki [] wyniki;
	/** Przechowuje miejsca na których wyskoczy³y cyferki, aby nie mog³y siê powtórzyæ i wzajemnie zakrywac */
	int lokacje[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	/** S³u¿y do sumowania dwóch ostatnich klikniêc*/
	int sumaKlikniec = 0;
	/** Wartoœæ 1 klikniêtej cyfry*/
	int pierwsza = 0;
	/** Wartoœæ 2 klikniêtej cyfry*/
	int druga = 0;
	/** Wektor do wpisywania klikniêtych cyfr*/
	private Vector<Cyferki> dodaneCyfry = new Vector<Cyferki>(2);
	/** Licznik do zliczania obliczonych wyników na konkretnym poziomie */
	int licznik = 0;
	/** Przechowuje numer ostatniego dobrze policzonego wyniku w celu odznaczenia go w panelu bocznym */
	int wynikObliczenie = 0;
	/** Wyniki wykorzystane w danej rundzie */
	int wynikiWykorzystane [] = {0,0,0,0,0,0,0,0,0,0,0,0};
	
	Plansza(int szerokosc, int wysokosc) {
	
		wyniki = new Wyniki[30];
		Poziom = new Poziom();
		Poziom.reset();	      
        this.sSzerokosc = szerokosc;
		this.sWysokosc = wysokosc;		
		startGry();
	
		addMouseListener(new MouseAdapter(){
            @Override
          public void mouseClicked(MouseEvent me){
            
	         //rozpoczêto grê
	         if(Kontener.menu == false && Kontener.instrukcja == false) {
	             
	              //Gdy klikniêto na pauzê w menu górnym
	              if(me.getX()>(460) && me.getX()<(660)  && me.getY()>(50) && me.getY()<(110)){
	                  Kontener.pauza=!Kontener.pauza;
	                  repaint();
	              }
	              
	            //Gdy klikniêto na guzik menu w menu górnym
	              if(me.getX()>(40) && me.getX()<(240)  && me.getY()>(50) && me.getY()<(110)){
	                  Kontener.menu =!Kontener.menu;
	                  Kontener.czasGry = czas;
	                  zerujWykorzystane();
	                  licznik = 0;
	              }
	              
	            //Gdy klikniêto na przycisk restart
	              if(me.getX()>(40) && me.getX()<(240)  && me.getY()>(120) && me.getY()<(200)){
	                  if(Kontener.pauza){
	                	  Kontener.czasGry = czas;
	                      Kontener.startowe = 4;
	                      licznik = 0;
	                      zerujWykorzystane();
	                      Poziom.reset();
	                      startGry();
	                      repaint();
	                  }
	              }
	              
	              if(Kontener.pauza == false) {
	              //sprawdz czy cyfra klikniêta
		              for(int i = 0; i < cyferki.length ; i++){
		            	  
		                      if(cyferki[i].czyZawieraKlikniecie(me.getX(), me.getY())){
		                          
		                        	  //dodanie do wektora pierwszej kliknietej cyfry
		                        	  if(dodaneCyfry.size() < 1) {
		                        		  int zawartosc = cyferki[i].podajWartosc();
		                        		  dodaneCyfry.add(cyferki[i]);
		                        		  Kontener.czasGry++;
		                        		  sumaKlikniec = zawartosc;
		                        		  
		                        	  }
		                        	  //jesli pierwsza cyfra jest wpisana to dodaj 2 cyfrê do wektora
		                        	  else {
		                    			  int zawartosc2 = cyferki[i].podajWartosc();
		                    			  sumaKlikniec = sumaKlikniec + zawartosc2;
		                    			  
		                    			  for(int j = 1 ; j < Kontener.startowe; j+=2) {
		                  					  
		                    				  if(wynikiWykorzystane[j] != 0) { //zabezpieczenie przed powtórnym obliczeniem tego samego wyniku w celu przejœcia poziomu
		                    					  continue;
		                    				  }
		                    				  else {
			                    				  //gdy suma dwóch ostatnich klikniêæ jest równa jednemu z wyników do uzyskania to przerysuj j¹                   				  
			                    				  if(sumaKlikniec == wyniki[j].wartosc) {
			                    					       
			                    					  	  wynikiWykorzystane[j] = 1;
			                    					  	  
			                    						  licznik++;
			                    						  cyferki[j].dzwiek("dzwieki/pyk.wav"); //dzwiek znikaj¹cej Wyniki
			                    						  
			                    						  Kontener.czasGry++;// dodane w celu zniwelowania czasu obs³ugi dodawania
			                    						  
			                    						  //wspó³rzêdna x dobrze obliczonego wyniku 
			                    						  int x = 105;
			                    						  //wspó³rzêdna y dobrze obliczonego wyniku 
			                    						  int y = 320;
			                    						  wynikObliczenie = j;
			                    						  //narysowanie obliczonej Wyniki
			                    						  wyniki[j] = new Wyniki(x , y + 30 * j, Kontener.obliczoneWyniki , sumaKlikniec);
			                    						  Kontener.czyZmienic = true;	                    						  
			                    						  //gdy obliczono wszystkie wyniki z danej rundy to w zale¿noœci od poziomu narysuj odpowiedni¹ iloœæ wyników do obliczenia
			                    						  if(licznik == Kontener.startowe / 2) {
			                    							  if(Poziom.poziom < 4) {
			                    								  Kontener.startowe = 4;
			                    							  }
			                    							  else if(Poziom.poziom >= 4 && Poziom.poziom < 8) {
			                    								  Kontener.startowe = 6;
			                    							  }
			                    							  else if(Poziom.poziom >= 8 && Poziom.poziom < 12) {
			                    								  Kontener.startowe = 8;
			                    							  }
			                    							  else if(Poziom.poziom >= 12 && Poziom.poziom < 16) {
			                    								  Kontener.startowe = 10;
			                    							  }
			                    							  else {
			                    								  Kontener.startowe = 12;
			                    							  }
			                    							  zerujWykorzystane();
			                    							  Poziom.nastepnyPoziom();
			                    							  startGry();
			                    							  repaint();
			                    							  licznik = 0;
			                    						        
			                    						  }	                    					  
			                    				  }
		                    				  }
		                    			  }
		                    			  //wyczyœæ wektor
		                    			  dodaneCyfry.clear();
		                    			  sumaKlikniec = 0;
		                    			  repaint();
		                    		  }
		                      }	                      
		              }
	              }
	              }else if(Kontener.menu == true && Kontener.instrukcja == false){//gdy gra siê nie zaczê³a to wyœwietl menu g³ówne
	            	  
	            	  //klikniety przycisk startu gry
	            	  if(me.getX()>(268) && me.getX()<(492)  && me.getY()>(217) && me.getY()<(297)){
	            		  //ustaw parametry startowe
	                      Kontener.menu =!Kontener.menu;
	                      Poziom.reset();
	                      Kontener.czasGry = czas;
	                      Kontener.startowe = 4;
	                      startGry();
	                  }
	            	  
	            	  // klikniete informacje o grze
	            	  if(me.getX()>(268) && me.getX()<(492)  && me.getY()>(337) && me.getY()<(417)){
	            		  //wyœwietlenie obrazka instrukcji
	                      Kontener.instrukcja = true;
	                  }
	            	  
	            	  //gdy w menu g³ównym klikniêto przycisk wyjœcie
	            	  if(me.getX()>(268) && me.getX()<(492)  && me.getY()>(457) && me.getY()<(537)){
	                      System.exit(1);
	                  }
	            	  
	              }else if(Kontener.menu == true && Kontener.instrukcja == true) {//gdy jest wyœwietlana instrukcja
	            	  //i nast¹pi klikniêcie guzika menu to wróæ do menu g³ównego
	            	  if(me.getX()>(500) && me.getX()<(690)  && me.getY()>(620) && me.getY()<(676)){
	                	  Kontener.instrukcja = false;
	                	  Kontener.menu = true;
	                  }
	            	  
	              }
          }//koniec mouseClicked()
      });
	}
	
	
	@Override
	protected void paintComponent(Graphics gs) {
		Graphics2D g=(Graphics2D)gs;
		
        // gdy nie klikniêto pauzy to wyœwietlaj odliczany czas
	    if(Kontener.pauza == false) {
	        Kontener.czasGry--;
	        
        }
	    
	    String czas = Integer.toString(Kontener.czasGry); //String który jest wyœwietlany jako czas
        
        //jeœli kliknieto menu
        if(Kontener.menu == true && Kontener.instrukcja == false) {
        	g.drawImage(Kontener.startowaObraz, 0, 0, null);
        }
        // jeœli w menu kliknieto instrukcje
        else if(Kontener.menu == true && Kontener.instrukcja == true) {
        	g.drawImage(Kontener.instrukcjaObraz, 0, 0, null);
        }
        // jeœli kliknieto start
        else if(Kontener.menu == false && Kontener.instrukcja == false){
        	if(Kontener.czasGry < 1) { //gdy czas siê skoñczy
            	g.drawImage(Kontener.koniecObraz, 0, 0, null);
            	g.setFont(graFont);
            	g.drawString("Pokonane rundy: " +Poziom.poziom, 270, 400);
            	g.drawString("GRATULACJE", 290, 430);
            }
        	else {       
            	g.drawImage(Kontener.tlo, 0, 0, null);
	        
		        //rysowanie cyferek na planszy
		        for(int i = 0 ; i < cyferki.length; i++) {	        	
		        	g.drawImage(cyferki[i].ikona, cyferki[i].x , cyferki[i].y,null);	        	
		        }
	        
		        //rysowanie wyników
		        for(int i = 1 ; i < Kontener.startowe; i+=2) {	
		        	g.drawImage(wyniki[i].ikona , wyniki[i].x , wyniki[i].y,null);		        	
		        }
	        
		        //jak obliczono wynik to zmieñ jego wygl¹d (wynik znika)
		        if(Kontener.czyZmienic) {
		        	g.drawImage(wyniki[wynikObliczenie].ikona , wyniki[wynikObliczenie].x , wyniki[wynikObliczenie].y , null);
		        	Kontener.czyZmienic = false;
		        	repaint();
		        }
	        
		        g.setFont(graFont);
		        //rysowanie czasu
		        g.drawString("Do koñca gry pozosta³o " +czas+ " sekund", 260 , 160);
		        //rysowanie aktualnej rundy
		        g.drawString("Aktualna runda "+Poziom.poziom , 500 , 200);
		        //guzik menu
		        g.drawImage(Kontener.menuObraz, 40 , 50 , null);
		        //guzik pauzy
		        g.drawImage(Kontener.pauzaObraz, 460 , 50 , null);
	           
		        if(Kontener.pauza){
		        	//jak kliknieto pauze to wyswietl guzik wznowienia gry i restart
		        	g.drawImage(Kontener.restartObraz , 40 , 140 , null);
		        	g.drawImage(Kontener.wznowObraz, 460 , 50 , null);
		        	g.drawImage(Kontener.zaslonaObraz, 0 , 255 , null);
		        }
            }
        }	
	}//koniec paintComponent()
	
	
	private void startGry() {
		cyferki = new Cyferki[20];
		int tablicaLokacja []= {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		
		for(int i = 0 ; i < 10 ; i++) {
			tablicaLokacja[i] = 0;
		}
		Random random = new Random();
		Kontener.pauza = false;
		int lokacja;
		int mozliweWartosci[] = {1,2,3,4,5,6,7,8,9,-9,-8,-7,-6,-5,-4,-3,-2,-1};
		for(int i = 0 ; i < 20 ; i++) {
        	
    		lokacja = random.nextInt(RZEDY * KOLUMNY);//mozliwe wyskoczenie cyferek
    		tablicaLokacja[i] = lokacja;
    		//wyeliminowanie mozliwosci wyskoczenia cyferek na tych samych polach planszy
    		for(int k = 0; k < i ; k++)	  {		
				if(lokacja == tablicaLokacja[k]){		
					i--;		  
					}	  
				} 
			}
    		
    	for(int i = 0 ; i < 20 ; i++) {
    		int rzad = tablicaLokacja[i] / RZEDY;
    		int kolumna = tablicaLokacja[i] % KOLUMNY;
    		int x = kolumna * 61 + 283;
    		int y = rzad * 61 + 283;
    		int losowa;
    		
    		if(Poziom.poziom < 10) {
    			 losowa = random.nextInt(9);	// gdy poziom jest niski to nie ma ujemnych cyferek
    		}else {
    			 losowa = random.nextInt(18); // od 10 rundy pojawiaj¹ siê ujemne cyfry
    		}
    		
    		String wartosc = Integer.toString(mozliweWartosci[losowa]);
    		int wartoscKwadratu = Integer.parseInt(wartosc);
    		wylosowane[i] = wartoscKwadratu;
    		cyferki[i] = new Cyferki(x, y, Kontener.cyferki, wartoscKwadratu);
        }
		obliczanie();
	}//koniec startGry()
	
	/**
	 * Zeruje tablicê wyników wykorzystanych
	 */
	public void zerujWykorzystane() {
		for(int j = 1 ; j < Kontener.startowe; j+=2) {
			wynikiWykorzystane[j] = 0;
		}
	}
	
	/**
	 * Obliczanie wyników do wpisania w panel po lewej stronie ekranu
	 */
	public void obliczanie() {
		int wynik = 0;
		int x = 105;
		int y = 320;
		for(int j = 0 ; j < Kontener.startowe; j++) {
			wynik = wynik + wylosowane[j];
			if(j % 2 == 1) {
				wyniki[j] = new Wyniki(x , y + 30 * j, Kontener.wyniki , wynik);
				repaint();
				wynik = 0;
			}
		}
	}//koniec obliczanie()	
}
