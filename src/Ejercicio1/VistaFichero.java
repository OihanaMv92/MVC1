package Ejercicio1;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;

public class VistaFichero { // EN LA CLASE SE METE LO QUE QUEREMOS QUE TENGA LA VENTANA.
	Frame ventana = new Frame("MiBloc");
	Dialog dlgMensajes = new Dialog(ventana, "Mensaje", true);
	TextField txtNombreFichero = new TextField(20);
	Button btnCargar = new Button("Cargar");
	Button btnGuardar = new Button("Guardar");
	TextArea txaTexto = new TextArea(15,30);
	Label lblMensaje = new Label("Archivo no Encontrado");

	public VistaFichero() // CONSTRUCTOR AÑADIMOS TODO A LA VENTANA 
	{
		ventana.setLayout(new FlowLayout());

		ventana.add(txtNombreFichero);
		ventana.add(btnCargar);
		ventana.add(btnGuardar);
		ventana.add(txaTexto);
		ventana.setBackground(Color.pink);

		ventana.setSize(240,370);
		ventana.setResizable(false);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);

		// MONTAMOS EL DIALOGO UN QUE NO LO HACEMOS VISIBLE.
		dlgMensajes.setLayout(new FlowLayout());
		dlgMensajes.setSize(180,100);
		dlgMensajes.setResizable(false);
		dlgMensajes.setLocationRelativeTo(null);
		dlgMensajes.add(lblMensaje);

	}
}