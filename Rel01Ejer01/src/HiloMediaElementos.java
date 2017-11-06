
public class HiloMediaElementos implements Runnable {

	private int[] vector;
	
	// Constructor
	public HiloMediaElementos (int[] vector){
		this.vector = vector;
		System.out.println("Creado el hilo HiloMediaElementos");
	}

	public void run() {
		int sumanumeros = 0, media;
		
		for (int i = 0; i < vector.length; i++) {
			sumanumeros += vector[i];
		}
		
		media = sumanumeros/vector.length;

		System.out.println("La media es: " + media);
	}
}
