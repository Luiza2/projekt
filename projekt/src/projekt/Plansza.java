package projekt;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Random;
import java.util.Vector;

import javax.swing.JPanel;


public class Plansza extends JPanel{
	/** Czas gry */
	public static int czas = 200;
	/** Tablica przechowujaca wylosowane cyfry*/
	public int [] wylosowane = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	/** Tablica do ktorej trafiaja wylosowane sumy*/
	public int [] sumy = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	/** Obiekt status gry*/
	public StatusGry statusGry;
	/** Szerokoœæ pola graficznego gry*/
	public int sSzerokosc;
	/** Wysokoœæ pola graficznego gry*/
	public int sWysokosc;
	/** Iloœæ rzêdów i kolumn planszy*/
	public static int RZEDY = 7, KOLUMNY = 7;
    /** Czcionka stosowana w pasku menu gry */
    public Font graFont;
	/** Tablica aby nie powtórzy³y sie lokalizacje cyferek na planszy */
	public int lokalizacje[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	/** Tablica obiektów pierwszego planu - cyferek*/
	private Cyferki [] cyferki;
	/** Tablica sum do narysowania */
	private Sumy [] sumki;
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
	/** Licznik do zliczania dodawanych sum*/
	int licznik = 0;
	/** Przechowuje numer ostatniej dobrze policzonej sumy w celu odznaczenia jej w panelu bocznym */
	int sumaPoliczona = 0;
	int [] wykorzystanei = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	
	Plansza(int szerokosc, int wysokosc) {
	
		statusGry = new StatusGry();
		statusGry.reset();
		
        graFont =new Font("Dialog",Font.BOLD,26);
        
        this.sSzerokosc = szerokosc;
		this.sWysokosc = wysokosc;
		
		
		sumki = new Sumy[30];
		startGame();
	
		addMouseListener(new MouseAdapter(){
            @Override
          public void mouseClicked(MouseEvent me){
            
         //rozpoczêto grê
         if(Kontener.menu == false && Kontener.instrukcja == false) {
             
              //Gdy klikniêto na pauzê w menu górnym
              if(me.getX()>(460) && me.getX()<(660)  && me.getY()>(50) && me.getY()<(110)){
                  Kontener.pauza=!Kontener.pauza;
                  repaint();
                  return;
              }
              
            //Gdy klikniêto na guzik menu w menu górnym
              if(me.getX()>(40) && me.getX()<(240)  && me.getY()>(50) && me.getY()<(110)){
                  Kontener.menu =!Kontener.menu;
                  Kontener.czasGry = czas;
              }
              
            //Gdy klikniêto na przycisk restart
              if(me.getX()>(40) && me.getX()<(240)  && me.getY()>(120) && me.getY()<(200)){
                  if(Kontener.pauza){
                	  Kontener.czasGry = czas;
                      Kontener.startowe = 4;
                      statusGry.reset();
                      Kontener.tlo = Kontener.zaladujZdjecie("zdjecia/plansza.png");
                      startGame();
                      repaint();
                  }
              }
              
              if(Kontener.pauza == false) {
              //sprawdz czy cyfra kliknieta
	              for(int i = 0; i < cyferki.length ; i++){
	                      if(cyferki[i].czyZawieraKlikniecie(me.getX(), me.getY())){
	                          
	                        	  //dodanie do wektora pierwszej kliknietej cyfry
	                        	  if(dodaneCyfry.size()<1) {
	                        		  int zawartosc = cyferki[i].podajWartosc();
	                        		  dodaneCyfry.add(cyferki[i]);
	                        		  sumaKlikniec = zawartosc;
	                        	  }
	                        	  //jesli pierwszy cyfra jest wpisana to dodaj 2 cyfrê do wektora
	                        	  else {
	                    			  int zawartosc2 = cyferki[i].podajWartosc();
	                    			  sumaKlikniec = sumaKlikniec + zawartosc2;
	                    			  
	                    			  for(int j = 1 ; j < Kontener.startowe; j+=2) {
	                  					  
	                    				  //gdy suma dwóch ostatnich klikniêæ jest równa jednej z sum do uzyskania to przerysuj j¹                   				  
	                    				  if(sumaKlikniec == sumki[j].wartosc) {
	                    					  
	                    					  if(wykorzystanei[j] != 0) {//gdy dana suma by³a ju¿ obliczona
	                    						  continue;
	                    					  }
	                    					  else {//jeœli danej sumy nie obliczono wczeœniej
	                    						  licznik++;
	                    						  wykorzystanei[j] = j;
	                    						  cyferki[j].dzwiek(new File("dzwieki/pyk.wav")); //dzwiek znikaj¹cej sumy
	                    						  
	                    						  Kontener.czasGry++;// dodane w celu zniwelowania czasu obs³ugi dodawania która zajmuje oko³o sekundy
	                    						  
	                    						  //wspó³rzêdna x dobrze obliczonej sumy 
	                    						  int x = 105;
	                    						  //wspó³rzêdna y dobrze obliczonej sumy 
	                    						  int y = 320;
	                    						  sumaPoliczona = j;
	                    						  //narysowanie obliczonej sumy
	                    						  sumki[j] = new Sumy(x , y + 30 * j,Kontener.obliczoneSumy, sumaKlikniec);
	                    						  Kontener.czyZmienic = true;
	                    						  //repaint();
	                    						  //gdy obliczono wszystkie sumy z danej rundy to w zale¿noœci od poziomu narysuj odpowiedni¹ iloœæ sum do obliczenia
	                    						  if(licznik == Kontener.startowe / 2) {
	                    							  if(statusGry.poziom < 4) {
	                    								  Kontener.startowe = 4;
	                    							  }
	                    							  else if(statusGry.poziom >= 4 && statusGry.poziom < 8) {
	                    								  Kontener.startowe = 6;
	                    							  }
	                    							  else if(statusGry.poziom >= 8 && statusGry.poziom < 12) {
	                    								  Kontener.startowe = 8;
	                    							  }
	                    							  else if(statusGry.poziom >= 12 && statusGry.poziom < 16) {
	                    								  Kontener.startowe = 10;
	                    							  }
	                    							  else {
	                    								  Kontener.startowe = 12;
	                    							  }
	                    							  
	                    							  statusGry.nastepnyPoziom();
	                    							  startGame();
	                    							  zerujWykorzystane();
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
                      statusGry.reset();
                      Kontener.czasGry = czas;
                      Kontener.startowe = 4;
                      startGame();
                  }
            	  
            	  // klikniete informacje o grze
            	  if(me.getX()>(268) && me.getX()<(492)  && me.getY()>(337) && me.getY()<(417)){
            		  //wyœwietlenie obrazka instrukcji
                      Kontener.instrukcja = true;
                  }
            	  
            	  //gdy w menu g³ównym klikniêto przycisk wyjœcie
            	  if(me.getX()>(268) && me.getX()<(492)  && me.getY()>(457) && me.getY()<(537)){
            		  //opuszczenie gry
                      System.exit(1);
                  }
            	  
              }else if(Kontener.menu == true && Kontener.instrukcja == true) {//gdy jest wyœwietlana instrukcja
            	  //i nast¹pi klikniêcie guzika menu to wróæ do menu g³ównego
            	  if(me.getX()>(500) && me.getX()<(690)  && me.getY()>(620) && me.getY()<(676)){
                	  Kontener.instrukcja = false;
                	  Kontener.menu = true;
                  }
            	  
              }
          }//mouseClicked()
      });
	}
	
	
	@Override
	protected void paintComponent(Graphics gs) {
		Graphics2D g=(Graphics2D)gs;
        //antyaliasing
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // gdy nie klikniêto pauzy to wyœwietlaj odliczany czas
	    if(Kontener.pauza == false) {
	        Kontener.czasGry--;
	        
        }
	    else { //klikniêto pauzê, zatrzymaj czas
	    	Kontener.czasGry = Kontener.czasGry;
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
        // jeœli kliknieto start to trwa gra
        else if(Kontener.menu == false && Kontener.instrukcja == false){
        	if(Kontener.czasGry < 1) { //gdy czas siê skoñczy
            	g.drawImage(Kontener.koniecObraz, 0, 0, null);
            	g.setFont(graFont);
            	g.drawString("Pokonane rundy: " +statusGry.poziom, 270, 400);
            	g.drawString("GRATULACJE", 290, 430);
            }else {       
            	g.drawImage(Kontener.tlo, 0, 0, null);
	        
		        //rysowanie cyferek na tle z plansz¹
		        for(int i = 0 ; i < cyferki.length; i++) {	        	
		        	g.drawImage(cyferki[i].icon, cyferki[i].x, cyferki[i].y,null);	        	
		        }
	        
		        //rysowanie sum
		        for(int i = 1 ; i < Kontener.startowe; i+=2) {	
		        	g.drawImage(sumki[i].icon, sumki[i].x, sumki[i].y,null);		        	
		        }
	        
		        //jak obliczono sumê to zmieñ jej wygl¹d (suma znika)
		        if(Kontener.czyZmienic) {
		        	g.drawImage(sumki[sumaPoliczona].icon, sumki[sumaPoliczona].x, sumki[sumaPoliczona].y,null);
		        	Kontener.czyZmienic = false;
		        	repaint();
		        }
	        
		        g.setFont(graFont);
		        //rysowanie czasu
		        g.drawString("Do koñca gry pozosta³o " +czas+ " sekund", 260, 160);
		        //rysowanie aktualnej rundy
		        g.drawString("Aktualna runda "+statusGry.poziom,500, 200);
		        //guzik menu
		        g.drawImage(Kontener.menuObraz, 40,50,null);
		        //guzik pauzy
		        g.drawImage(Kontener.pauzaObraz, 460,50,null);
	           
		        if(Kontener.pauza){
		        	//jak kliknieto pauze to wyswietl guzik wznowienia gry i restart
		        	g.drawImage(Kontener.restartObraz ,40,140,null);
		        	g.drawImage(Kontener.wznowObraz, 460,50,null);
		        	g.drawImage(Kontener.zaslonaObraz, 0 , 255 ,null);
		        }
            }
        }	
	}//paintComponent()
	
	public void zerujWykorzystane() {
		for(int i = 0 ; i < Kontener.startowe; i++) {
			wykorzystanei[i]= 0;
		}
	}
	
	
	private void startGame() {
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
    		for(int k=0;k<i;k++)	  {		
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
    		
    		if(statusGry.poziom < 10) {
    			 losowa = random.nextInt(9);	// gdy poziom jest niski to nie ma ujemnych cyferek
    		}else {
    			 losowa = random.nextInt(18); // od 10 rundy pojawiaj¹ siê ujemne cyfry
    		}
    		
    		String wartosc = Integer.toString(mozliweWartosci[losowa]);
    		int wartoscKwadratu = Integer.parseInt(wartosc);
    		wylosowane[i] = wartoscKwadratu;
    		cyferki[i] = new Cyferki(x, y, Kontener.cyferki, wartoscKwadratu);
        }
		sumator();
	}
	
	/**
	 * Obliczanie sum do uzyskania
	 */
	public void sumator() {
		int suma = 0;
		int x = 105;
		int y = 320;
		for(int j = 0 ; j < Kontener.startowe; j++) {
			suma = suma + wylosowane[j];
			if(j % 2 == 1) {
				sumki[j] = new Sumy(x , y + 30 * j,Kontener.sumki, suma);
				sumy[j] = suma;
				repaint();
				suma = 0;
			}
		}
	}//sumator()
	
}
