public class UsaPrimerHiloRunnable {

	
	public static void main (String[] args) {
		PrimerHiloRunnable h=null;
		
		h= new PrimerHiloRunnable(4);
		new Thread(h).start();
		h= new PrimerHiloRunnable(2);
		new Thread(h).start();
		h= new PrimerHiloRunnable(1);
		new Thread(h).start();
		
	}
}
