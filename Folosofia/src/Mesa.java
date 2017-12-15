
public class Mesa {

	private int comensales;
	private boolean[] palillos;
	
	public Mesa(int comensales) {
		this.comensales = comensales;
		this.palillos = new boolean[comensales];
		
		for (int i = 0; i < palillos.length; i++) {	palillos[i] = false; }
	}
	
	/**
	 * 	Método por el cuál un filósofo intentara coger palillos para comer
	 * @param filosofo
	 */
	public synchronized void cogerPalillos(int filosofo) {
		int palilloDerecho = calculaPalilloDerecho(filosofo);
		
		// Mientras alguno de los palillos esté cogido, esperamos. Si lo pasamos cogemos el palillo.
		while(palillos[filosofo] || palillos[palilloDerecho]) {
			try {
				wait();
			} catch (InterruptedException e) { e.printStackTrace();	}
		}
		
		palillos[filosofo] = true;
		palillos[palilloDerecho] = true;
		
		notifyAll(); // Para que los otros salgan del wait
	}
	
	/**
	 * 	Método por el cuál un filósofo soltará sus palillos.
	 * @param filosofo
	 */
	public synchronized void soltarPalillos(int filosofo) {
		int palilloDerecho = calculaPalilloDerecho(filosofo);
		
		palillos[filosofo] = false;
		palillos[palilloDerecho] = false;

		notifyAll();	// Importante para que otros cojan palillos
	}
	
	/**
	 * 	Calcula el palillo derecho del filosofo. Obligatorio porque el palillo derecho del ultimo es el 0.
	 * @param filosofo
	 * @return
	 */
	private int calculaPalilloDerecho(int filosofo) {
		int palilloDerecho;
		
		if(filosofo == comensales-1)	// Si es el ultimo filosofo que coja el palillo 0
			palilloDerecho = 0;
		else
			palilloDerecho = filosofo + 1;
		
		return palilloDerecho;
	}
}
