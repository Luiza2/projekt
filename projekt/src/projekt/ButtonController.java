package projekt;

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
	
	public ButtonController() {
		
		this.kliknieteGuziki = new Vector(2);
		this.turnDownTimer = new Timer(this.turnDownDelay,(ActionListener) this);
		this.turnDownTimer.setRepeats(false);
		
	}
	
	public boolean zaznacz(Guzik guzik) {
		if(this.kliknieteGuziki.size()<2)
			{
			Plansza.returner();
			//System.out.println(sumy[2]);
			dzwiek(new File("klik.wav"));
			
			//System.out.println("zaznacz z buttoncontroller");
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
		
		
		String zawartosc = guzik.podajWartosc();
		
		if(zawartosc != " ") {
			this.kliknieteGuziki.add(guzik);
			int liczba = Integer.parseInt(zawartosc);
			//System.out.println(sumy[0]);
			System.out.println(zawartosc);
			System.out.println("jeden guzik");
			if(this.kliknieteGuziki.size()==2) {
				dzwiek(new File("pyk.wav"));
				System.out.println("kliknieto dwa guziki");
				Guzik drugiGuzik = (Guzik)this.kliknieteGuziki.get(0);
				
				String zawartosc2 = drugiGuzik.podajWartosc();
				int liczba2 = Integer.parseInt(zawartosc2);
				
//				if(liczba + liczba2 == sumy[0]) {
//					System.out.println("maj¹ t¹ sam¹ wartosc");
//				}
				
				
				System.out.println(liczba + liczba2);
				
	//			if(drugiGuzik.getNum()== guzik.getNum()) 
	//				this.kliknieteGuziki.clear();
					//else 
						this.turnDownTimer.start();
			}
				return true;
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
