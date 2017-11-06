
public class PrimerHiloRunnable extends Thread{
	
	private int hilo;
	
	// Constructor
	public PrimerHiloRunnable (int x){
		this.hilo=x;
		System.out.println("Creado el hilo" + hilo);
	}


	public void run() {
		
		
		for(int i =0; i < hilo; i++) {
			System.out.println("En el hilo " +hilo +"I = "+i);
			
			
		}
	}
	
	public static void main (String[] args) {
		PrimerHiloRunnable h=null;
		
		h= new PrimerHiloRunnable(4);
		h.start();
		h= new PrimerHiloRunnable(2);
		h.start();
		h= new PrimerHiloRunnable(1);
		h.start();
		
	}
}
