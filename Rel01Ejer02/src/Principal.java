import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Principal {

	public static void main(String[] args) {

		String nombreArchivo = "ficheros.txt";
		String linea = "";
		int contador = 0;

		try {

			FileReader flujoLectura = new FileReader(nombreArchivo);
			BufferedReader filtroLectura = new BufferedReader(flujoLectura);

			linea = filtroLectura.readLine();

			while (linea != null) {
				contador++;
				if (!linea.equals(""))
					new HiloCuentaCaracteres("Hilo" + contador, linea).run();
				linea = filtroLectura.readLine();

			}

			filtroLectura.close();
			flujoLectura.close();

		} catch (FileNotFoundException e) {
			System.out.println("Fichero " + nombreArchivo + " no encontrado.");
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
