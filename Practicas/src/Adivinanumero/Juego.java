package Adivinanumero;
import java.util.Random;

/**
 * Clase que permite crear un juego de números aleatorios para acertar un
 * número. Es necesario una clase común compartida por todos los hilos puesto
 * que hay acceso a datos compartidos y habrá que sincronizar algunas tareas.
 *
 */
public class Juego {

	// Atributo
	private int numeroSecreto; 
	private int numMax;// Número máximo para adivinar
	private boolean terminadoJuego;// Variable que dice si se ha acabado el juego o no
	private int numJugadores;// Número de jugadores para participar
	private int turno;

	/**
	 * Constructor del juego. El número para acertar se genera aleatoriamente
	 * 
	 * @param numMax
	 *            el n�mero maximo con el que se va a jugar
	 * @param numJug
	 *            el el numero de jugadores
	 */
	public Juego(int numMax, int numJug) {
		this.numMax = numMax;
		this.numJugadores = numJug;
		Random serie = new Random();
		numeroSecreto = serie.nextInt(this.numMax) + 1;
		terminadoJuego = false;
		turno = 1;
	}

	/**
	 * Metodo para arrancar los hilos de los jugadores. Se hace sincronizado
	 * para que nadie pueda empezar a jugar hasta que todos los hilos jugadores
	 * est�n listos
	 */
	public synchronized void empezarJuego() {
		for (int i = 1; i <= numJugadores; i++) {
			new Jugador(this, i).start();
		}
	}

	/**
	 * Método para jugar, debe estar sincronizado puesto que será compartido por
	 * X hilos
	 * 
	 * @param numJug
	 *            el número del jugador
	 */
	public synchronized void jugar(int numero, int numJug) {
		
			while (!terminadoJuego && numJug != turno) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (!terminadoJuego) // OJO: este if es importante
			// Si no lo pones, podrían aparecer mensajes de hilos
			// que siguen
			// intentando jugar aunque el juego ya ha acabado
			{
				System.out.println("Jugador " + numJug + " intenta con el numero " + numero);
				if (numero == this.numeroSecreto) { // termina el juego
					terminadoJuego = true;
					System.out.println("Jugador " + numJug + " Ganaste!!!");
					System.out.println("El numero era: " + this.numeroSecreto);
				} else { // incremento el turno
					if (numJug == numJugadores)
						turno = 1;
					else
						turno++;

				}
				this.notifyAll();
			}
		

		
	}

	/**
	 * Método para saber si se ha acabado la partida
	 * 
	 * @return si se acertado o no
	 */
	public boolean finPartida() {
		return terminadoJuego;
	}

	public int generarAleatorio() {
		// TODO Auto-generated method stub
		Random serie = new Random();
		int num;
		num = serie.nextInt(this.numMax) + 1;
		return num;

	}
}
