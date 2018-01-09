package fumadores;

/**
 *
 * @author orlando
 */
public class Fumadores 
{
    private static final int CANTIDADFUMADORES = 3;
    private static Mesa mesa;
    private static Thread estanquero;
    private static Thread fumadores[];
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        mesa = new Mesa(CANTIDADFUMADORES);
        fumadores = new Thread[CANTIDADFUMADORES];

        // Creo los fumadores
        for(int i = 0; i < CANTIDADFUMADORES; i++) 
        {
            String nombrefumador = "Fumador " + i;
            fumadores[i] = new Thread(new Fumador(nombrefumador, i, mesa));
        }
        
        // Inicio los fumadores
        for(int i = 0; i < CANTIDADFUMADORES; i++) 
        {
            fumadores[i].start();
        }
        
        // Creo e inicio al estanquero
        estanquero = new Thread (new Estanquero(mesa));
        estanquero.start();
    }
    
}