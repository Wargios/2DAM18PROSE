
public class Hilo extends Thread{
	
	private int hilo;
	
	// Constructor
	public Hilo (int x){
		this.hilo=x;
		System.out.println("Creado el hilo" + hilo);
	}


	public void run() {
		
		
		for(int i =0; i < hilo; i++) {
			System.out.println("En el hilo " +hilo +"I = "+i);
			
			
		}
	}
}
