// place this file the path such ends with: ChatServer/client/Client.java

package cliente;

import java.io.IOException;
import java.net.Socket;

import javax.swing.JFrame;

public class Cliente {

	private static final String HOST = "localhost";
	private static final int PUERTO = 4444;

	private String nombreUsuario;
	private String servidor;
	private int puertoServidor;
	Thread hilo;

	public static void main(String[] args) {

		JFrame ventana = new JFrame();

		VistaCliente vistaCliente = new VistaCliente();
		Cliente cliente = new Cliente(vistaCliente.getjFieldNick().toString(), HOST, PUERTO);
		ControladorCliente controladorCliente = new ControladorCliente(cliente, vistaCliente);

		vistaCliente.controlador(controladorCliente);

		ventana.setContentPane(vistaCliente);
		ventana.pack();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);

	}

	public Cliente(String userName, String host, int portNumber) {
		this.nombreUsuario = userName;
		this.servidor = host;
		this.puertoServidor = portNumber;
	}

	public boolean startClient(VistaCliente vistaCliente) {
		try {
			Socket socket;

			socket = new Socket(servidor, puertoServidor);

			Thread.sleep(1000); // waiting for network communicating.
			System.out.println("meconetao");

			ServerThread hiloServidor = new ServerThread(socket, nombreUsuario);
			hilo = new Thread(hiloServidor);

			hilo.start();

			return true;

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();

			return false;
		}

	}

	public boolean stopClient() {
		if (hilo.isAlive()) {
			hilo.stop();
			return true;
		} else
			return false;
	}
}
