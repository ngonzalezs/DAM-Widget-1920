package PedroLuis_Rodriguez_Perez;

import java.io.File;

import javax.swing.JFrame;
public class VentanaPrincipal {
	JFrame marco;
	Formulario form;	
	public VentanaPrincipal() {
		marco = new JFrame();	
		
		
		form = new Formulario(new File ("txt/empleados.txt"));
		marco.add(form);
		
		
		marco.setBounds(0, 0, 1000, 1000);
		marco.setVisible(true);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		System.out.println("https://docs.google.com/presentation/d/1Mq_5aJUaSHNBl4U-b3DhD9TrENNfdq1H6XejuAYAopw/edit?usp=sharing");
	}
}