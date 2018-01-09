package fumadores;

/**
 * Esta clase representa al estanquero, que es el que pone los ingredientes para que
 * fumen los fumadores
 * @author orlando
 */
public class Estanquero implements Runnable
{
    /*
        Mesa común al estanquero y los fumadores
        Aquí se pondrán los ingredientes
    */
    private final Mesa mesa;
	
    /**
     * Constructor de la clase Estanquero
     * @param mesa Mesa común al estanquero y los fumadores
     */
    public Estanquero (Mesa mesa)
    {
        this.mesa = mesa;
    }
	
    @Override
    /**
     * Implementación de la hebra
     */
    public void run () 
    {
        while(Boolean.TRUE)
        {
            mesa.ponerLaMesa();
        }
    }
    
}