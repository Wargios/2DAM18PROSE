package Partida;

import java.util.Arrays;

public class Jugador extends Thread {
	
	//Atributos nombre(Irrelevante), puntos, turno, hiloVivo("No significa que este muerto, solo que no coge carta")
	private String nombre;
	private Double puntos;
	private final int turno;
	private boolean hiloVivo;
	
	private Partida7Media partida;
	
	public Jugador(String nombre, int turno, Partida7Media partida) {
		
		
		this.nombre = nombre;
		this.puntos = 0.0;
		this.turno = turno;
		this.hiloVivo = true;
		this.partida = partida;
		

	}
	
	public void run() {
		
		//Comprobamos si la partida ha terminado
		while(!partida.getTerminada()) {
			
			puntos = partida.comenzar(turno, hiloVivo, nombre, puntos);

			
		}
		
	}


	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPuntos() {
		return puntos;
	}

	public void setPuntos(Double puntos) {
		this.puntos = puntos;
	}

	public int getTurno() {
		return turno;
	}

	public boolean isHiloVivo() {
		return hiloVivo;
	}

	public void setHiloVivo(boolean hiloVivo) {
		this.hiloVivo = hiloVivo;
	}
	
	
	
}
