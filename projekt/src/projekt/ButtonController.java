package projekt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.Timer;

public class ButtonController implements ActionListener {

	private Vector kliknieteGuziki;
	private Timer turnDownTimer;
	private final int turnDownDelay = 500;
	public int sumki[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	
	public ButtonController() {
		
		this.kliknieteGuziki = new Vector(2);
		this.turnDownTimer = new Timer(this.turnDownDelay,(ActionListener) this);
		this.turnDownTimer.setRepeats(false);
		
	}
	
	public boolean turnUp(Guzik guzik) {
		if(this.kliknieteGuziki.size()<2)
			{
			//System.out.println("wywolano odwracacz z buttonkontrolera");
			
			return doAddCard(guzik);
			}
			
		return false;
	}
	
	private boolean doAddCard(Guzik guzik) {
		// TODO Auto-generated method stub
		this.kliknieteGuziki.add(guzik);
		
		String zawartosc = guzik.getValue();
		int liczba = Integer.parseInt(zawartosc);
		//System.out.println(sumy[0]);
		System.out.println(zawartosc);
		System.out.println("jeden guzik");
		if(this.kliknieteGuziki.size()==2) {
			System.out.println("kliknieto dwa guziki");
			Guzik drugiGuzik = (Guzik)this.kliknieteGuziki.get(0);
			
			String zawartosc2 = drugiGuzik.getValue();
			int liczba2 = Integer.parseInt(zawartosc2);
//			if(liczba + liczba2 == sumy[0]) {
//				System.out.println("maj¹ t¹ sam¹ wartosc");
//			}
			
			System.out.println(liczba + liczba2);
			
			if(drugiGuzik.getNum()== guzik.getNum()) 
				this.kliknieteGuziki.clear();
				else this.turnDownTimer.start();
		}
			return true;
		
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
