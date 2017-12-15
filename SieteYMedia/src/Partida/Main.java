package Partida;
public class Main {

	public static void main(String[] args) {
		
		//Creamos el objeto baraja
		Baraja baraja = new Baraja();
		//Y el Partida
		Partida7Media partida = new Partida7Media(baraja);
		//Los jugadores
		Jugador jugador1, jugador2, jugador3, jugador4;
		
		//Creamos los jugadores
		jugador1 = new Jugador("1", 1, partida);
		jugador2 = new Jugador("2", 2, partida);
		jugador3 = new Jugador("3", 3, partida);
		jugador4 = new Jugador("4", 4, partida);
		
		//Y .start
		new Thread(jugador1).start();
		new Thread(jugador2).start();
		new Thread(jugador3).start();
		new Thread(jugador4).start();
		
		
		
	}
	
	/*
	 En resumen, el main tiene como atributos, los jugadores, la baraja y la partida
	 A partida se le pasa como parametro baraja y a los jugadores se les pasa Partida
	 En la clase jugadores, tenemos que controlar(RUN) que se siga ejecutando hasta que pase algo, en este caso que termine la partida
	 En principio el unico metodo que hace falta sincronizar es el del objeto que comparten los jugadores(partida.comenzar())
	 
	 
	*/
	
	
}
