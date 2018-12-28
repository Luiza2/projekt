package projekt;

import java.awt.Dimension;
import javax.swing.JPanel;

public class Gra extends JPanel implements Runnable {

	
	private static final long serialVersionUID = 1L;
	public static final int SZEROKOSC = 750;
	public static final int WYSOKOSC = 700;
	private Thread gra;
	private boolean running;
	public int calkowityCzas = 600;
	
	public Gra(){
		setFocusable(true);
		setPreferredSize(new Dimension(SZEROKOSC,WYSOKOSC));	
		this.setBackground(null);
		this.setLayout(null);	
		Plansza plansza = new Plansza(this);
			
	}
	
	@Override
	public void run() {
		
		int fps = 0, updates = 0;
		long fpsTimer = System.currentTimeMillis();
		double nsPerUpdate = 1000000000.0 / 60.0;
		double then = System.nanoTime();
		double unprocessed = 0;
				
		while(running){
			
			boolean shouldRender = false;
			double now = System.nanoTime();
			unprocessed +=(now - then)/nsPerUpdate;
			then = now;
					
			while(unprocessed >= 1){
				updates++;
				unprocessed--;
				shouldRender = true;
			}
						
			if(System.currentTimeMillis()- fpsTimer > 1000){
				//System.out.printf("%d fps %d updates" , fps, updates);	
				calkowityCzas -= 1;
				//System.out.println(calkowityCzas);
				fps = 0;
				updates = 0;
				fpsTimer += 1000;
			}
			
			
			if(shouldRender){
				fps++;
				shouldRender = false;
			} else{
				try{
					Thread.sleep(1);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public synchronized void start(){
		if(running)return;
		running = true;
		gra = new Thread(this, "game");
		gra.start();
	}
	
	public synchronized void stop(){
		if(!running) return;
		running = false;
		
		
		System.exit(0);
	}	
	
}