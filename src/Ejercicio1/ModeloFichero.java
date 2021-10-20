package Ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ModeloFichero
{
	public ModeloFichero() // constructor
	{

	}
	public void cargarFichero(VistaFichero vistaFichero)
	{
		//Como usaremos FileReader y puede lanzar una excepción
		//necesitaremos un bloque try – catch
		try
		{
			//Origen de los datos en el proyecto anterior
			FileReader fr = new FileReader(vistaFichero.txtNombreFichero.getText()); // sacar el texto del textfield de vista fichero
			//Buffer de lectura
			BufferedReader entrada = new BufferedReader(fr);
			String s;
			vistaFichero.txaTexto.selectAll(); // resetear para que no se pisen
			vistaFichero.txaTexto.setText("");
			//Bucle para sacar la información del archivo
			while((s=entrada.readLine())!=null)
			{
				vistaFichero.txaTexto.append(s); // cada vez que leeo una cadena lo meto en texto
				vistaFichero.txaTexto.append("\n"); // añadimos salto de linia
			}
			//Cerrar el objeto entrada
			entrada.close();
			fr.close();
			vistaFichero.lblMensaje.setText("Archivo leído");
		}
		catch(FileNotFoundException e)
		{
			vistaFichero.lblMensaje.setText("Archivo NO encontrado");
		}
		catch(IOException i)
		{
			vistaFichero.lblMensaje.setText("Se produjo un error de Archivo");
		}
		finally
		{
			vistaFichero.dlgMensajes.setVisible(true);
		}
	}
	public void guardarFichero(VistaFichero vistaFichero)
	{
		//FileWriter también puede lanzar una excepción
		try
		{
			// Destino de los datos
			FileWriter fw = new FileWriter(vistaFichero.txtNombreFichero.getText()); // sacamos el texto de vista fichero
			// Buffer de escritura
			BufferedWriter bw = new BufferedWriter(fw);
			// Objeto para la escritura
			PrintWriter salida = new PrintWriter(bw);
			//Guardamos la primera línea
			salida.println(vistaFichero.txaTexto.getText()); // imprimimos lo que sacamos por el textArea y lo metemos en el fichero
			//Cerrar el objeto salida, el objeto bw y el fw
			salida.close();
			bw.close();
			fw.close();
			vistaFichero.lblMensaje.setText("¡Archivo creado correctamente!");
		}
		catch(IOException i)
		{
			vistaFichero.lblMensaje.setText("Se produjo un error de Archivo");
		}
		finally
		{
			vistaFichero.dlgMensajes.setVisible(true);
		}
		
	}
}