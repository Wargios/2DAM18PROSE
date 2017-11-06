
public class HiloElementoMinimo extends Thread{
	
	private int[] vector;
	
	// Constructor
	public HiloElementoMinimo (int[] vector){
		this.vector = vector;
		System.out.println("Creado el hilo HiloMediaElementos");
	}

	public void run() {
		int min = vector[0];

		for (int i = 0; i < vector.length; i++) {
			if (vector[i] < min)
				min = vector[i];

		}

		System.out.println("El numero minimo: " + min);
	}
}
