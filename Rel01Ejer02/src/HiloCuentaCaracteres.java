import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HiloCuentaCaracteres extends Thread {

	private String nombreHilo;
	private String nombreArchivo;

	public HiloCuentaCaracteres(String nombreHilo, String nombreArchivo) {
		this.nombreHilo = nombreHilo;
		this.nombreArchivo = nombreArchivo;

		System.out.println("Hilo " + this.nombreHilo + " creado.");

	}

	@Override
	public void run() {
		String linea = null;
		int numeroCaracteres = 0;

		try {

			FileReader flujoLectura = new FileReader(nombreArchivo);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);

			linea = filtroLectura.readLine();

			while (linea != null) {

				numeroCaracteres += linea.length();
				linea = filtroLectura.readLine();
			}

			System.out.println("El hilo " + nombreHilo + " tiene " + numeroCaracteres + " carácteres.");

			filtroLectura.close();
			flujoLectura.close();

		} catch (FileNotFoundException e) {
			System.out.println("Fichero " + nombreArchivo + " no encontrado.");
		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
