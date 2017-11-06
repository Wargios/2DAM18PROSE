package contador;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Contador extends Applet implements Runnable, ActionListener{	
	private Thread hilo;
	long  contador = 0;
        // indicador de si el contador esta parado o corriendo
        // indica a su vez si el hilo debe continuar o no
	private boolean parar=true; 
	private Font fuente;
	private Button b1, b2; // botones del Applet
	
        @Override
	public void init(){
		setBackground(Color.LIGHT_GRAY);
		b1=new Button("Iniciar contador");
		add(b1); // annade el boton al panel
		b1.addActionListener(this);//Para detectar si se pulsa		
		b2=new Button ("Parar contador");
		add(b2);
		b2.addActionListener(this);//Para detectar si se pulsa	
		fuente=new Font("Courier New", Font.BOLD, 80);
	}
        
        @Override
        public void start(){}
        
        @Override
	public void paint(Graphics g){
		//Borra una zona con forma de rectángulo rellenandolo con fondo
                g.clearRect(0, 0, 200, 150);
		g.setFont(fuente);
                //pinta el texto en pos x,y
		g.drawString(Long.toString((long) contador), 125, 100);
	}	
        @Override
	public void run() {
            parar = false;
            Thread hiloActual = Thread.currentThread();
            //Tarea repetitiva: pintar el nuevo contador
            while (hilo == hiloActual && parar == false){
                try{
                    Thread.sleep(200);//Velocidad del contador
                } catch (InterruptedException e) {e.printStackTrace();}
                repaint();
                contador++;
            }
	}
	/* Metodo que se invoca al bulsar un boton*/	
    
        /* 
        * Cierre del applet: cuando el applet necesita matar el hilo le asigna
        * el valor null. Es más una forma más "suave" de detener el hilo que el
        * método stop() del hilo (hilo.stop()) que esta en desuso y es peligroso
        */ 
        @Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			b1.setLabel("Continuar");
			// Si es el primer boton:
			if (e.getSource()== b1){  //Comienzo
	                        //Si el hijo se está ejecutando, no hago nada
				if( hilo != null && hilo.isAlive()){} 
	                        //Sino, lo creo y se incia
	                        else{//lo creo
	                            hilo = new Thread(this);
	                            hilo.start();
	                        }                        
			}
	                // Si es el boton de parar:
			else if (e.getSource()== b2) parar=true;
		}
        @Override
	public void stop(){ hilo = null; } //Detener un hilo

		
}//FIN CONTADOR