package Contador;

public class Contador extends Thread {
		private int inicio,fin; // valor inicial y final del contador
		private String nombre; // nombre de la hebra
		// 
		
		
		//constructor con los valores iniciales y final y el nombre
		
		
		public Contador(int desde, int hasta, String id) {
		inicio = desde; fin = hasta; nombre = id;
		}
		
		
		
		// función principal
		
		
		public void run() {
		System.out.println(nombre+ " empieza...");
		for (int i = inicio; i <= fin; i++) {
		System.out.println (nombre+" dice: "+i + ". ");
			try{ sleep(10); // paramos una centesima de segundo
			} catch (InterruptedException e) 
			{ e.printStackTrace(); }
			}
		System.out.println(nombre + " acaba.");
		}
}
