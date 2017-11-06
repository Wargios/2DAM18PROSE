import java.awt.Graphics;
import java.util.*;
import java.text.DateFormat;
import java.applet.Applet;

@SuppressWarnings("serial")
public class Reloj extends Applet implements Runnable {
    private Thread clockThread = null;
    public void start() {
        if (clockThread == null) {
            clockThread = new Thread(this, "Reloj");
            clockThread.start();
        }
    }
    public void run() {
        Thread myThread = Thread.currentThread();
        while (clockThread == myThread) {
            repaint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
            }
        }
    }
    public void paint(Graphics g) {
        // get the time and convert it to a date
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        // format it and display it
        DateFormat dateFormatter = DateFormat.getTimeInstance();
        g.drawString(dateFormatter.format(date), 5, 10);
    }
    // Para el applet no el hilo
    public void stop() {
        clockThread = null;
    }
}

/*
 * Codigo a poner en fichero html 
 * <html>
 * <applet code="Reloj.class" width="200" height="100" > </applet>
 * </html>
 * */
