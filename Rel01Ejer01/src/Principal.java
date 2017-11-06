import java.util.Random;

public class Principal {

	public static void main(String[] args) {
		int[] vector = new int[100];
		Random rnd = new Random();
		
		for (int i = 0; i < vector.length; i++) {
			vector[i] = rnd.nextInt(1000) + 1;
		}
		
		HiloElementoMaximo hilo1 = new HiloElementoMaximo(vector);
		HiloElementoMinimo hilo2 = new HiloElementoMinimo(vector);
		Thread hilo3 = new Thread(new HiloMediaElementos(vector));
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
	}

}
