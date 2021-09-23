package Ejercicio1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ControladorFichero implements ActionListener, WindowListener
{
	// Crear dos objetos de vista y fichero (INSTANCIAMOS EL OBJETO NO ES CREADO NUEVO.. PUESTO QUE EL NEW ESTA EN PRINCIPAL.)
	VistaFichero vistaFichero; // aqui reservamos pero el objeto solo se crea en la principal
	ModeloFichero modeloFichero;

	public ControladorFichero(VistaFichero vf, ModeloFichero mf) // en el constructor llamamos los objetos creados en la principal.
	{
		// Los que vienen de fuera se convierten en los que estan dentro del controlador.
		// llamamos a los de fuera de principal con el nombre del constructor.
		vistaFichero = vf;
		modeloFichero = mf;

		vistaFichero.ventana.addWindowListener(this); // en vista fichero nos dirigimos a la ventana y le añadimos. los listener
		vistaFichero.btnCargar.addActionListener(this); // añadimos los botones a la vista para que tengan funcionalidad
		vistaFichero.btnGuardar.addActionListener(this);
		vistaFichero.dlgMensajes.addWindowListener(this);
	}

	@Override
	public void windowActivated(WindowEvent arg0){}

	@Override
	public void windowClosed(WindowEvent arg0){}

	@Override
	public void windowClosing(WindowEvent arg0) // si pinacha el dialogo o la vista
	{
		if(vistaFichero.dlgMensajes.isActive()) // Oye el fichero y el dialogo esta activo?
		{
			vistaFichero.dlgMensajes.setVisible(false); // pues hago invisible el dialogo
		}
		else
		{
			System.exit(0); // si esta la vista activa y el dialogo no me salgo
		}
	}

	@Override
	public void windowDeactivated(WindowEvent arg0){}
	@Override
	public void windowDeiconified(WindowEvent arg0){}
	@Override
	public void windowIconified(WindowEvent arg0){}
	@Override
	public void windowOpened(WindowEvent arg0){}
	@Override
	public void actionPerformed(ActionEvent evento)
	{
		if(evento.getSource().equals(vistaFichero.btnCargar)) //si pulsamos el boton guardar que esta en la vista
		{
			modeloFichero.cargarFichero(vistaFichero); // llamamos al modelo que carge el fichero que esta creado en el controlador y lo metemos en la vista
		}
		else if(evento.getSource().equals(vistaFichero.btnGuardar))  
		{
			modeloFichero.guardarFichero(vistaFichero); // le pasamos el parametro de la vistaFichero
		}
	}
}