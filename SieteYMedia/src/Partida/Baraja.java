package Partida;
import java.util.Arrays;
import java.util.Random;

public class Baraja {
	
	public static final int NUM_PALOS = 4;
	public static final String [] cartas = new String [] {"1", "2", "3", "4", "5", "6", "7", "J", "Q", "K"};
	
	private String[][] mazo;

	public Baraja() {
		
		mazo = new String[4][10];
		crearBaraja();
		//Funciona
		//mazo.toString();
		
	}
	
	//METODO PARA OBTENER CARTA
	public String obtenerCarta() {
		
		int fila = 0, columna = 0;
		String carta = "";
		
		fila = (int) Math.floor(Math.random()*3);
		columna = (int) Math.floor(Math.random()*9);
		
		carta = mazo[fila][columna];
		
		//Mientras la carta no sea nula
		while(carta.equals("")) {
			
			fila = (int) Math.floor(Math.random()*3);
			columna = (int) Math.floor(Math.random()*9);
						
			//System.out.println(mazo[fila][columna]);
			
			//Devuelve una carta del mazo y la pone a null en el mazo, para que no se pueda volver a coger
			carta = mazo[fila][columna];
			
			
			//System.out.println("la fila "+ fila + " y la columna " + columna + " nos dan la carta " + carta);
			
			
			
		}
		mazo[fila][columna] = "";
		System.out.println("la fila "+ fila + " y la columna " + columna + " nos dan la carta " + carta);
		return carta;
		
		
	}

	//CREA BARAJA
	private void crearBaraja() {
		
		for(int f = 0; f < NUM_PALOS; f++) {
			
			for(int c = 0; c < cartas.length; c++) {
				
				this.mazo[f][c] = cartas[c].toString();
				//System.out.println(mazo[f][c].toString());
				
			}
			
		}
		
	}


	public String[][] getMazo() {
		return mazo;
	}

	
	

}
