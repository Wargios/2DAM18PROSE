package Partida;

//Clase partida, el objeto a compratir entre los hilos
public class Partida7Media {
	
	private Baraja baraja;	//Objeto baraja
	
	private int turnoActual;	//Turno Actual
	
	private boolean hiloJuega;	//Si el hilo juega o solo incrementa turno(Provisional)
	
	private boolean terminada;	//Si la partida ha terminado
	
	String carta;	//Valor de la carta
	
	double puntos =0; //Puntos provisionales
	
	int contador = 0;

	public Partida7Media(Baraja baraja) {
		
		this.baraja = baraja;
		//Funciona
		//System.out.println(baraja.getMazo()[0][9].toString());
		turnoActual = 1;
		terminada = false;
		
		
	}
	
	//EL METODO QUE LLAMARAN TODOS LOS HILOS
	public synchronized Double comenzar(int turnoHilo, boolean hiloVivo, String nombre, double puntitos) {
		
		//Si el turnoActual es diferente espera
		while (turnoActual != turnoHilo) {
			try {
				wait();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		
		//HiloProvisional = hiloVivo
		hiloJuega = hiloVivo;
		
		if (hiloJuega) {
			//Si esta vivo(Es decir si puede coger carta) obtiene la carta, y suma los puntos
			System.out.println("Turno del Jugador: " + nombre);
			String carta = baraja.obtenerCarta();
			System.out.println(carta);
			this.puntos = puntitos;
			System.out.println(puntos);
			this.puntos += obtenerPuntosCarta(carta);

			//Si los puntos son mas de 7.5 ya no puede jugar carta asi que ponemos la variable hiloVivo a false.
			//Para que solo incremente el turno, ya que si lo matamos nadie incrementara este turno
			if (puntos > 7.5) {
				System.out.println("jugador " + nombre + " termina partida con " + this.puntos);
				hiloVivo = false;
				contador++;
	
			} else {
				//Si es menos de 7.5 comprobamos si son 7.5 por si ha ganado y seguimos...
				System.out.println("jugador " + nombre + " termina turno con " + this.puntos);
				comprobarPuntos(this.puntos);
			}
		
		}
		
		//System.out.println(this.isAlive());
		if(contador == 4) {terminada = true;}
		incrementarTurno();
		notifyAll();	
		return puntos;

	}
	
	
	//METODO OBTENER PUNTOS
	public Double obtenerPuntosCarta(String carta) {
		
		System.out.println(carta);
		double valor;
		
		try {
			
			valor = Double.parseDouble(carta);
			
		} catch (NumberFormatException e) {
			valor = 0.5;
		}
		
		
		return valor;
	}
	
	
	//METODO INCREMENTAR TURNO
	public void incrementarTurno() {
		
		if (this.turnoActual == 4) {
			this.turnoActual = 1;
		}else {
			
			this.turnoActual ++;
			
		}
		System.out.println("Se incrementa turno a " + this.turnoActual);
		

	}
	
	public void comprobarPuntos(double puntos) {
		
		if(puntos == 7.5) {
			
			this.setTerminada(true); 
			
		}
		
	}
	
	
	public Baraja getBaraja() {
		return this.baraja;
	}
	
	public synchronized int getTurnoActual() {
		return this.turnoActual;
	}


	public boolean getTerminada() {
		return terminada;
	}


	public void setTerminada(boolean terminada) {
		this.terminada = terminada;
	}
	
	
	

}
