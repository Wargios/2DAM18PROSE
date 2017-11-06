package Contador;

public class UsaContador {
	
	
	static public void main(String[] args) {
		// al declararlas NO comienzan
		Contador hebraA = new Contador(1, 10, "HebraA");
		Contador hebraB = new Contador(20, 30, "HebraB");
		System.out.println("Vamos a iniciar las dos hebras");
		// ahora comienzan
		hebraA.start();
		hebraB.start();
		System.out.println("Hebras inicializadas");
		// hacemos un poco de tiempo antes de despedirnos
		for (int i=0; i<50000000; i++) ;
		System.out.println("Programa principal terminado");
		}

}
