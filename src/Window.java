import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class Window extends JFrame{
	public JPanel panel;
	public Font txtNormal = new Font("Calibri", Font.PLAIN, 15);
	public Font txtNegrita = new Font("Calibri", Font.BOLD, 15);
	//public ArrayList<Vehiculo> listaV;
	public ArrayList<Vehiculo> listaV;
	
	public Window() {
		// ** M�todos interesantes:
		//this.setLocation(810, 340); //Establecer posici�n inicial de la ventana
		//this.setBounds(320, 300, 810, 340); //SetBounds = SetSize + SetLocation
		//this.getContentPane().setBackground(Color.BLUE); //Establecer color a la ventana
		
		// ** Nuestra ventana:
		this.setTitle("App Gesti�n de Veh�culos");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Cuando cerramos con la X, el programa sigue en ejecuci�n, con esta l�nea lo paramos
		this.setSize(520,400); //Tama�o de la ventana
		this.setLocationRelativeTo(null); // Esto hace que se centre la ventana
		// Inicializamos la lista porque sino, no existe todav�a y nos da error
		listaV = new ArrayList<Vehiculo>();
		// Creamos una moto para hacer pruebas --------------- deshabilitar cuando el programa funcione
		Moto m = new Moto("Yamaha","R1","0433JSB","01/08/2016","Gasolina",40000);
		listaV.add(m);
		// Hasta aqu� la declaraci�n de veh�culos de prueba
		initComponentes();
	}
	
	public Window(ArrayList<Vehiculo> listVeh) {
		listaV = new ArrayList<Vehiculo>();
		listaV = listVeh;
		// ** Nuestra ventana:
		this.setTitle("App Gesti�n de Veh�culos");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Cuando cerramos con la X, el programa sigue en ejecuci�n, con esta l�nea lo paramos
		this.setSize(520,400); //Tama�o de la ventana
		this.setLocationRelativeTo(null); // Esto hace que se centre la ventana
		//Mostramos el veh�culo que acabamos de a�adir
		//JOptionPane.showMessageDialog(null, listaV.get(listaV.size()-1).getMarca(), "Nuevo veh�culo!", 1);
		initComponentes();
	}
	
	private void initComponentes() {		
		initPaneles();
		initEtiquetas();
		initBotones();
	}
	
	private void initPaneles() {
		// Panel donde agregaremos etiquetas y botones
		panel = new JPanel();
		//panel.setBackground(Color.GREEN); // Le ponemos color al panel
		panel.setLayout(null); // Desactivamos el dise�o por defecto
		this.getContentPane().add(panel); // Agregamos a la ventana el panel que acabamos de crear
	}
	
	private void initEtiquetas() {
		// Etiqueta Mis Veh�culos
		JLabel etiq1 = new JLabel("Mis veh�culos", SwingConstants.CENTER);
		etiq1.setBounds(25, 10, 150, 20);
		//etiq1.setText();
		//etiq1.setHorizontalAllignment();
		//etiq1.setForeground(Color.RED); // Color de la letra
		//etiq1.setOpaque(true); // Damos permiso para pintar el fondo de la etiqueta
		//etiq1.setBackground(Color.WHITE); // Con esto podremos ver cu�nto ocupa la etiqueta
		etiq1.setFont(txtNegrita); // Establecemos la fuente del texto
		panel.add(etiq1);
		
		// Etiqueta tipo imagen
		//JLabel etiqIconPpal = new JLabel(new ImageIcon("iconVehiclesM.jpg") ); // Constructor directo 
		ImageIcon icnVehicles = new ImageIcon("iconVehiclesG.jpg");
		JLabel lIcono = new JLabel();
		lIcono.setBounds(200, 10, 300, 224);
		lIcono.setIcon(new ImageIcon(icnVehicles.getImage().getScaledInstance(lIcono.getWidth(), lIcono.getHeight(), Image.SCALE_SMOOTH)));
		panel.add(lIcono);
		}
	
	private void initBotones() {
		// Bot�n para a�adir vehiculos
		JButton bA�adir = new JButton("A�adir veh�culo");
		JButton b1Veh = new JButton();
		JButton b2Veh = new JButton();
		JButton b3Veh = new JButton();
		JButton b4Veh = new JButton();
		JButton b5Veh = new JButton();
		JButton b6Veh = new JButton();
		JButton b7Veh = new JButton();
		JButton b8Veh = new JButton();
		if(!listaV.isEmpty()) {
			//for(int i=0; i<=listaV.size(); i++) {
				
			//}
			switch(listaV.size()) {
			case 1:
				b1Veh.setBounds(10, 40, 180, 30);
				b1Veh.setText(listaV.get(0).getTipo() + ": " + listaV.get(0).getMatricula());
				b1Veh.setFont(txtNormal);
				panel.add(b1Veh);
				bA�adir.setBounds(10, 80, 180, 30);
				break;
			case 2: 
				b1Veh.setBounds(10, 40, 180, 30);
				b1Veh.setText(listaV.get(0).getTipo() + ": " + listaV.get(0).getMatricula());
				b1Veh.setFont(txtNormal);
				panel.add(b1Veh);
				b2Veh.setBounds(10, 80, 180, 30);
				b2Veh.setText(listaV.get(1).getTipo() + ": " + listaV.get(1).getMatricula());
				b2Veh.setFont(txtNormal);
				panel.add(b2Veh);
				bA�adir.setBounds(10, 120, 180, 30);
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			default:
				System.err.println("Esta opci�n no se ha contemplado todav�a. Disculpe las molestias");
				break;
			}
		} else {
			bA�adir.setBounds(10, 50, 180, 30);
		}
		bA�adir.setMnemonic('a'); // Al pulsar Alt + 'letra' clickear�s el bot�n
		bA�adir.setFont(txtNormal);
		panel.add(bA�adir);
		
		// Agregamos acci�n al bot�n A�ADIR
		ActionListener abrirVentana = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				AddVehicle wA�adir = new AddVehicle(listaV);
				wA�adir.setVisible(true);
				closeWindow();
			}
		};
		bA�adir.addActionListener(abrirVentana);
		
		//Agregamos acci�n al bot�n modificar veh�culo
		ActionListener modVehicle = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae){
				if(listaV.get(0).getTipo().equals("Motocicleta")) {
					modificarMoto();
				}else if(listaV.get(0).getTipo().equals("Coche")) {
					// TO-DO con las clases Coche y Camion
				}else if(listaV.get(0).getTipo().equals("Camion")) {
					
				}else {
					JOptionPane.showMessageDialog(null, "Esta opci�n parece que no est� contemplada todav�a, ponte en contacto con la siguiente direcci�n de correo y solic�tala: mpmflash@gmail.com","Alert",JOptionPane.WARNING_MESSAGE);
				}
				hideWindow(true);
			}
		};
		b1Veh.addActionListener(modVehicle);
		//Fin de la acci�n
		
	}

	/*
	 * closeWindow()
	 * Cerramos la ventana
	 * @param void
	 * @return void
	 */
	private void closeWindow() {
		this.dispose();
	}
	/*
	 * hideWindow()
	 * Escondemos la ventana para cuando no nos interesa cerrarla
	 * @param void
	 * @return void
	 */
	public void hideWindow(boolean tof) {
		if(tof) {
			this.setVisible(false);
		}else {
			this.setVisible(true);
		}
	}
	/*
	 * modificarMoto();
	 * Nos abre la ventana ModMoto para modificar la moto que ha seleccionado el usuario
	 * @param Window (Ventana ppal), ArrayList de Vehiculo
	 * @return
	 */
	private void modificarMoto() {
		ModMoto wModMoto = new ModMoto(this, listaV.get(0), 0); // Get(0) porque no tengo m�s datos, revisar para veh�culos variables
		wModMoto.setVisible(true);
	}
}