import java.util.Random;

public class Filosofo extends Thread {
	
	private Mesa mesa;
	private Random flujo;
	private int numeroFilosofo;
	
	public Filosofo(int numeroFilosofo, Mesa mesa) {
		this.mesa = mesa;
		flujo = new Random();
		this.numeroFilosofo = numeroFilosofo;
	}

	@Override
	public void run() {
		
		while(true) {
			int tiempo = flujo.nextInt(500)+1;
			
			// Pensamos
			System.out.println("Filosofo " + numeroFilosofo + " (?)");
			try { sleep(tiempo); } catch (InterruptedException e) {	e.printStackTrace(); }
			
			// Intentamos comer
			System.out.println("Filosofo " + numeroFilosofo + " tener hambre.");
			mesa.cogerPalillos(numeroFilosofo);
			
			// Conseguimos palillos y comemos
			System.out.println("Filosofo " + numeroFilosofo + " como, luego existo.");
			tiempo = flujo.nextInt(100)+1;
			try { sleep(tiempo); } catch (InterruptedException e) { e.printStackTrace(); }
			
			// Ha comido y suelta los palillos
			System.out.println("Filosofo " + numeroFilosofo + " suelto palillos.");
			mesa.soltarPalillos(numeroFilosofo);
		}
	}
}
