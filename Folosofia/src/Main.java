
public class Main {

	public static void main(String[] args) {
		
		int comensales = 5;
		
		Mesa mesa = new Mesa(comensales);
		Filosofo[] filosofos = new Filosofo[comensales];
		
		// Creamos filósofos
		for (int i = 0; i < comensales; i++) {
			filosofos[i] = new Filosofo(i, mesa);
		}
		
		// Los iniciamos
		for (int i = 0; i < filosofos.length; i++) {
			filosofos[i].start();
		}
	}

}
