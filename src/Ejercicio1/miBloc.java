package Ejercicio1;

public class miBloc
{

	public static void main(String[] args)
	{ 
		// creamos los objetos.
		VistaFichero vistaFichero = new VistaFichero(); // mayuscula clase objeto minuscula NEW para crear objetos
		ModeloFichero modeloFichero = new ModeloFichero();
		// y al controlador le pasamos la vista y el modelo.
		new ControladorFichero(vistaFichero, modeloFichero);
	}

}
