package Sanchez_Hernandez_Alvaro;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;


public class PanelNotas extends JDialog implements KeyListener{

	private static final long serialVersionUID = 5266212298815899686L;
	private GridBagLayout layout;
	private JButton guardar;
	private JButton cerrar;
	private JTextArea texto;
	private GridBagConstraints settings;
	private JDialog miDialog = this;
	
	
	public PanelNotas() {
		super();
		this.setBounds(0, 0, 500, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.addKeyListener(this);
		inicializarComponentes();
		inicializarListeners();
	}
	
	public void inicializarComponentes() {
		
		//Inicializamos el layout
		layout = new GridBagLayout();
		this.setLayout(layout);
		
		//Inicializamos JTextArea con sus settings.
		settings = new GridBagConstraints();
		settings.gridy=0;
		settings.gridwidth=2;
		settings.weighty=8;
		settings.fill = GridBagConstraints.BOTH;
		texto = new JTextArea();
		texto.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(texto, settings);
		
		//Inicializamos boton guardar.
		settings = new GridBagConstraints();
		settings.gridy=1;
		settings.gridx=0;
		settings.weighty=1;
		settings.weightx=1;
		settings.fill=GridBagConstraints.BOTH;
		
		guardar = new JButton("Guardar");
		guardar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(guardar, settings);
		
		//Inicializamos Boton cerrar
		settings = new GridBagConstraints();
		settings.gridy=1;
		settings.gridx=1;
		settings.weighty=1;
		settings.weightx=1;
		settings.fill=GridBagConstraints.BOTH;
		
		cerrar = new JButton("Cerrar");
		cerrar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.add(cerrar, settings);
	}
	//Cierra el panel
	public void cerrarVentana() {
		this.dispose();
	}
	/**
	 * 
	 * @param pw Objeto PrintWriter para escribir en el fichero.
	 * Obtiene el texto del JTextField pasandolo a una variable y el printWriter lo escribe en el fichero.
	 */
	public void escribirFichero(PrintWriter pw) {
		String text = texto.getText();
		pw.write(text);
	}
	public void guardarFichero() {
		//Pedimos nombre del fichero.
		String nombre  = JOptionPane.showInputDialog("Introduce el nombre del fichero")+".txt";
		//Declaramos el lugar donde se va a guardar
		File directorio = new File("Notas");
		File archivo = new File(directorio,nombre);
		if(!directorio.exists()) {
			directorio.mkdir();
		}
		
		try {
			//Declaramos los writer.
			FileWriter fw = new FileWriter(archivo);
			PrintWriter pw = new PrintWriter(fw);
			
			escribirFichero(pw);
			pw.close(); //Cerramos flujo.
		}catch(IOException ioe) {
			System.out.println(ioe.getMessage());
			ioe.printStackTrace();
		}
		
	}
	//Inicializa los listeners  para el boton guardar y cerrar.
	public void inicializarListeners() {
		cerrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cerrarVentana();
			}
		});
		guardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				guardarFichero();	
			}
		});
		
	}
	
	//Abre el panel si se pincha la tecla ALT.
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_ALT) {
			miDialog.setVisible(true);
		}	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
