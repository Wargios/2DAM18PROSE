package Adivinanumero;
import java.util.Scanner;


public class Principal {

	
	
	static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		int numJugadores=pedirNumJug();
		int numMaximo=pedirNumMaximo();
		
		Juego juegoNuevo = new Juego(numMaximo, numJugadores);
		juegoNuevo.empezarJuego();
		
	}
	
	public static int pedirNumJug(){
		int numJug;
		String cadena;
		do
		{
			System.out.println("Cuantos jugadores van a jugar?");
			cadena = teclado.nextLine();
			numJug = Integer.parseInt(cadena);
		}while (numJug < 2);
		return numJug;
	}
	
	
	
	public static int pedirNumMaximo(){
		int num;
		String cadena;
		do
		{
			System.out.println("Numero maximo con el que vamos a jugar: ");
			cadena = teclado.nextLine();
			num = Integer.parseInt(cadena);
		}while (num <=1);
		return num;
	}
}
