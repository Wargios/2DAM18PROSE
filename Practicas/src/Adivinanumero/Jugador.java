package Adivinanumero;

public class Jugador extends Thread {
	
	//Atributos
	private Juego miJuego;
	private int numJugador;
	private static final int TIEMPO_ESPERA=1000; // en milisegundos
	
	//Constructor
	public Jugador(Juego nuevo, int numJugador){
		this.miJuego = nuevo;
		this.numJugador = numJugador;
	}
	
	public void run(){
		int num;
		while(!miJuego.finPartida()){ 
			
				num=miJuego.generarAleatorio();
				miJuego.jugar(num, numJugador);
			
				try {
					sleep(TIEMPO_ESPERA);
				} catch (InterruptedException e) {			
				e.printStackTrace();
				}
		}
	}
}