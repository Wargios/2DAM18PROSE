
public class UsaHiloEjemplo2 {
	public static void main (String[] args) {
		HilosEjemplo2 h=null;
		
		h= new HilosEjemplo2(4);
		h.start();
		h= new HilosEjemplo2(2);
		h.start();
		h= new HilosEjemplo2(1);
		h.start();
		
	}

}
