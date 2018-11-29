package projekt;

import java.awt.Dimension;
import javax.swing.JPanel;

public class Gra extends JPanel implements Runnable {

	
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 900;
	public static final int HEIGHT = 700;
	private Thread game;
	private boolean running;
	
	public Gra(){
		setFocusable(true);
		setPreferredSize(new Dimension(WIDTH,HEIGHT));	
		this.setBackground(null);
		this.setLayout(null);	
		Plansza plansza = new Plansza(this);//odkomentować do rysowania planszy
			
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
				//System.out.println("Minê³a sekunda");
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
		game = new Thread(this, "game");
		game.start();
	}
	
	public synchronized void stop(){
		if(!running) return;
		running = false;
		
		
		System.exit(0);
	}	
	
}