
public class HiloElementoMaximo extends Thread {
	private int[] vector;

	// Constructor
	public HiloElementoMaximo(int[] vector) {
		this.vector = vector;
		System.out.println("Creado el hilo HiloElementoMaximo");
	}

	public void run() {
		int maximo = 0;

		for (int i = 0; i < vector.length; i++) {
			if (vector[i] > maximo)
				maximo = vector[i];

		}

		System.out.println("El numero maximo: " + maximo);
	}

}
