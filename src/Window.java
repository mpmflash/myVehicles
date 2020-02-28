import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.List;
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
	public ArrayList<JButton> vehEnBotones;
	
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
		vehEnBotones = new ArrayList<JButton>();
		// Creamos una moto para hacer pruebas --------------- deshabilitar cuando el programa funcione
		Moto m = new Moto("Yamaha","R1","0433JSB","01/08/2016","Gasolina",40000);
		listaV.add(m);
		m.setId(listaV.size());
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
		/**/
		if(!listaV.isEmpty()) {
			for(int i=0; i<listaV.size(); i++) {
				// Creamos un bot�n por cada veh�culo agregado en la ArrayList y lo guardamos en una ArrayList de botones
				JButton boton = new JButton( listaV.get(i).getTipo() + ": " + listaV.get(i).getMatricula() );
				// Con setName identificar� el bot�n con el veh�culo que le haya agregado
				boton.setName( String.valueOf(listaV.get(i).getId()) );
				boton.setFont(txtNormal);
				boton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TO - DO Abrir nueva ventana (clase) para modificar el veh�culo seleccionado
						for( JButton boton : vehEnBotones) {
							if( boton == e.getSource() ) {
								modificarMoto(Integer.parseInt(boton.getName()));
							}
						}
					}
				});
				// Agregamos el bot�n en la ArrayList de botones
				vehEnBotones.add(boton);
				// Agregamos el bot�n al panel
				panel.add(boton);
			}
		} else {
			System.out.println("Todav�a no hay ning�n veh�culo en la app");
		}
		/**/
		/*
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
		*/
		
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
	 * @param Window (Ventana ppal), ArrayList de Vehiculo, ID del veh�culo
	 * @return
	 */
	private void modificarMoto(int id) {
		ModMoto wModMoto = new ModMoto(this, listaV.get(id), id);
		wModMoto.setVisible(true);
	}
	/*
	 * searchVehiculoById();
	 * M�todo que nos devuelve la posici�n del veh�culo en la listaV con el ID que le pasamos
	 * @param int id - Le pasamos el ID del veh�culo
	 * @return int - Posici�n en la lista
	 */
	private int searchVehiculoById(int id) {
		int pos = 0;
		for (int i=0; i<listaV.size(); i++ ) {
			if (listaV.get(i).getId() == id) {
				pos = i;
			}
		}
		return pos;
	}
}