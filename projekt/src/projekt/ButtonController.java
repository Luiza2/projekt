package projekt;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Timer;

public class ButtonController implements ActionListener {

	private Vector kliknieteGuziki;
	private Timer turnDownTimer;
	private final int turnDownDelay = 500;
	public int sumki[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	//public int sumy[];
	int [] wykorzystanei = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	
	int licznik = 0;
	
	public ButtonController() {
		
		this.kliknieteGuziki = new Vector(2);
		this.turnDownTimer = new Timer(this.turnDownDelay,(ActionListener) this);
		this.turnDownTimer.setRepeats(false);
		
	}
	
	public boolean zaznacz(Guzik guzik) {
		if(this.kliknieteGuziki.size()<2)
			{			
				dzwiek(new File("klik.wav"));
				return dodajDoWektora(guzik);
			}
			
		return false;
	}
	
	public static synchronized void dzwiek(final File f) {
        new Thread(new Runnable() {
          public void run() {
            try {
              Clip clip = AudioSystem.getClip();
              AudioInputStream inputStream = AudioSystem.getAudioInputStream(f);
              clip.open(inputStream);
              clip.start(); 
            } catch (Exception e) {
              System.err.println(e.getMessage());
            }
          }
        }).start();
    }
	
	public boolean dodajDoWektora(Guzik guzik) {
		// TODO Auto-generated method stub
		
		//Plansza.returner();
		String zawartosc = guzik.podajWartosc();
		
		if(zawartosc != " ") {
			this.kliknieteGuziki.add(guzik);
			int liczba = Integer.parseInt(zawartosc);
			
			System.out.println(zawartosc);
			System.out.println("jeden guzik");
			if(this.kliknieteGuziki.size()==2) {
				
				dzwiek(new File("pyk.wav"));
				//System.out.println("kliknieto dwa guziki");
				Guzik drugiGuzik = (Guzik)this.kliknieteGuziki.get(0);				
				String zawartosc2 = drugiGuzik.podajWartosc();
				int liczba2 = Integer.parseInt(zawartosc2);			
				przyrownanie(liczba, liczba2);			
				System.out.println(liczba + liczba2);
				 
				this.turnDownTimer.start();
			}
				return true;
		}
		return false;
	}

	public boolean przyrownanie(int liczba, int liczba2) {
		final int sumy[] = Plansza.getSumy().clone();
		
	    //final   Sumy[] su = Plansza.getPanele().clone();
		 final int startoweKwadraty = Plansza.ileStartowych();
		
		for(int i = 1; i < 8; i += 2) {
			
			
			
			System.out.println(wykorzystanei[i]);
			if(liczba + liczba2 == sumy[i]) {
				
					if(wykorzystanei[i] != 0) {
						
						continue;
					}
					else {
							licznik++;
							wykorzystanei[i] = i;
							System.out.println("poprawnie dodano sume numer " +i);
							Plansza.getPanele(i);
							if(licznik == startoweKwadraty / 2 ) {
								System.out.println("nowy level");
								//Plansza.start();
								licznik = 0;
							}
							return true;
					}
						
				}
			
			}
			
		return false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		for(int i = 0 ; i < this.kliknieteGuziki.size(); i++) {
			Guzik guzik = (Guzik)this.kliknieteGuziki.get(i);
			guzik.odznaczKlikniecie();
		}
		this.kliknieteGuziki.clear();
	}
	
}
