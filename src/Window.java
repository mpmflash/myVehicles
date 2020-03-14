import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
		// ** Métodos interesantes:
		//this.setLocation(810, 340); //Establecer posición inicial de la ventana
		//this.setBounds(320, 300, 810, 340); //SetBounds = SetSize + SetLocation
		//this.getContentPane().setBackground(Color.BLUE); //Establecer color a la ventana
		
		// ** Nuestra ventana:
		this.setTitle("App Gestión de Vehículos");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Cuando cerramos con la X, el programa sigue en ejecución, con esta línea lo paramos
		this.setSize(520,400); //Tamaño de la ventana
		this.setLocationRelativeTo(null); // Esto hace que se centre la ventana
		// Inicializamos la lista porque sino, no existe todavía y nos da error
		listaV = new ArrayList<Vehiculo>();
		vehEnBotones = new ArrayList<JButton>();
		// Creamos una moto para hacer pruebas --------------- deshabilitar cuando el programa funcione
		Moto m = new Moto("Yamaha","R1","0433JSB","01/08/2016","Gasolina",40000);
		listaV.add(m);
		m.setId(listaV.size());
		// Hasta aquí la declaración de vehículos de prueba
		initComponentes();
	}
	
	public Window(ArrayList<Vehiculo> listVeh) {
		listaV = new ArrayList<Vehiculo>();
		listaV = listVeh;
		// ** Nuestra ventana:
		this.setTitle("App Gestión de Vehículos");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Cuando cerramos con la X, el programa sigue en ejecución, con esta línea lo paramos
		this.setSize(520,400); //Tamaño de la ventana
		this.setLocationRelativeTo(null); // Esto hace que se centre la ventana
		//Mostramos el vehículo que acabamos de añadir
		//JOptionPane.showMessageDialog(null, listaV.get(listaV.size()-1).getMarca(), "Nuevo vehículo!", 1);
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
		panel.setLayout(null); // Desactivamos el diseño por defecto
		this.getContentPane().add(panel); // Agregamos a la ventana el panel que acabamos de crear
		
		// Creación del menú barra Archivo...
		JMenuBar menuBarra = new JMenuBar();
		JMenu menu = new JMenu("Archivo...");
		JMenuItem mIGuardar = new JMenuItem("Guardar datos");
		mIGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// Guardar fichero de archivo de datos de vehículos
				firstSaveToFile();
			}
		});
		JMenuItem mICargar = new JMenuItem("Cargar datos");
		mICargar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				// TO - DO Cargar fichero de datos de vehículos
				loadSelectedFile();
			}
		});
		this.setJMenuBar(menuBarra);
		JMenuItem mIAyuda = new JMenuItem("Ayuda");
		mIAyuda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				JOptionPane.showMessageDialog(null, "Si tienes cualquier duda o pregunta, ponte en contacto vía e-mail con: mpmflash@gmail.com (Miquel Pérez)");
			}
		});
		menuBarra.add(menu);
		menu.add(mIGuardar);
		menu.add(mICargar);
		menu.add(mIAyuda);
	}
	
	private void initEtiquetas() {
		// Etiqueta Mis Vehículos
		JLabel etiq1 = new JLabel("Mis vehículos", SwingConstants.CENTER);
		etiq1.setBounds(25, 10, 150, 20);
		//etiq1.setText();
		//etiq1.setHorizontalAllignment();
		//etiq1.setForeground(Color.RED); // Color de la letra
		//etiq1.setOpaque(true); // Damos permiso para pintar el fondo de la etiqueta
		//etiq1.setBackground(Color.WHITE); // Con esto podremos ver cuánto ocupa la etiqueta
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
		//vehEnBotones.clear();
		vehEnBotones = new ArrayList<JButton>();
		vehEnBotones.clear();
		// Botón para añadir vehiculos
		JButton bAnadir = new JButton("Añadir vehículo");
		bAnadir.setBounds(10, (1+listaV.size())*40, 180, 30);
		
		if(!listaV.isEmpty()) {
			for(int i=0; i<listaV.size(); i++) {
				// Creamos un botón por cada vehículo agregado en la ArrayList y lo guardamos en una ArrayList de botones
				JButton boton = new JButton( listaV.get(i).getTipo() + ": " + listaV.get(i).getMatricula() );
				// Con setName identificaré el botón con el vehículo que le haya agregado
				boton.setName( String.valueOf(listaV.get(i).getId()) );
				boton.setFont(txtNormal);
				boton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						for( JButton boton : vehEnBotones) {
							if( boton == e.getSource() ) {
								switch(searchVehiculoById( Integer.parseInt(boton.getName())).getTipo()) {
								case "Motocicleta":
									modificarMoto(Integer.parseInt(boton.getName()));
									break;
								case "Coche":
									//TO-DO
									System.out.println("Quieres modificar un coche");
									break;
								case "Camion":
									//TO-DO
									System.out.println("Quieres modificar un camión");
									break;
								default:
									System.out.println("Este tipo de vehículo no está implementado todavía, solicítalo escribiendo un email a mpmflash@gmail.com");
									break;
								}
								
							}
						}
					}
				});
				// Agregamos el botón en la ArrayList de botones
				vehEnBotones.add(boton);
				// Agregamos el botón al panel
				boton.setBounds(10, (1+i)*40, 180, 30);
				panel.add(boton);
			}
		} else {
			System.out.println("Todavía no hay ningún vehículo en la app");
		}
		
		bAnadir.setMnemonic('a'); // Al pulsar Alt + 'letra' clickearás el botón
		bAnadir.setFont(txtNormal);
		bAnadir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddVehicle nuevoVehiculo = new AddVehicle(listaV);
				nuevoVehiculo.setVisible(true);
			}
			
		});
		panel.add(bAnadir);
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
	 * @param Window (Ventana ppal), ArrayList de Vehiculo, ID del vehículo
	 * @return
	 */
	private void modificarMoto(int id) {
		ModMoto wModMoto = new ModMoto(this, searchVehiculoById(id), id);
		wModMoto.setVisible(true);
	}
	/*
	 * searchVehiculoById();
	 * Método que nos devuelve la posición del vehículo en la listaV con el ID que le pasamos
	 * @param int id - Le pasamos el ID del vehículo
	 * @return int - Posición en la lista
	 */
	private Vehiculo searchVehiculoById(int id) {
		Vehiculo veh = new Vehiculo();
		for (int i=0; i<listaV.size(); i++ ) {
			if (listaV.get(i).getId() == id) {
				veh = listaV.get(i);
			}
		}
		return veh;
	}
	
	/*
	 * firstSaveToFile();
	 * Método que se tiene que usar la primera vez que se guardan datos binarios en un fichero. Así que al crear la lista de Hnos, la guardaremos.
	 * Para siguientes actualizaciones del fichero, usaremos el método saveToFile();
	 * @param void
	 * @return void
	 */
	public void firstSaveToFile() {
		try {
			FileOutputStream file = new FileOutputStream("ListadoDeVehiculos.bin");
			ObjectOutputStream objectToFile = new ObjectOutputStream(file);
			for( Vehiculo v : listaV) {
				objectToFile.writeObject(v);
			}
			System.out.println("El archivo se ha guardado correctamente");
			file.close();
		} catch(FileNotFoundException fnfE) {
			System.err.println("Error: "+fnfE);
		} catch(IOException ioE) {
			System.err.println("Error: "+ioE);
		}
	}
	
	/*
	 * loadSelectedFile();
	 * Método que carga el fichero para trabajar con los datos deseados
	 * @param void
	 * @return void
	 */
	public void loadSelectedFile() {
		int resp;
		JFileChooser file = new JFileChooser();
		file.showOpenDialog(this);
		changeDataToWork( String.valueOf( file.getSelectedFile() ) );
	}
	
	public void changeDataToWork(String fileName) {
		boolean bucleWhile = true;
		try {
			FileInputStream file = new FileInputStream(fileName);
			ObjectInputStream objectToRead = new ObjectInputStream(file);
			listaV.clear();
			while(bucleWhile) {
				Vehiculo v = (Vehiculo) objectToRead.readObject();
				listaV.add(v);
			}
			//repartirPrivilegios();
		} catch(EOFException eOFE) {
				bucleWhile = false; // Cuando haya terminado de leer el fichero saldremos del while infinito
		} catch (FileNotFoundException fNFE) {
			System.err.println("Error al encontrar el archivo:"+fNFE);
		} catch (IOException iOE) {
			System.err.println("Error de entrada/salida de datos: "+iOE);
		} catch (ClassNotFoundException cNFE) {
			System.err.println("Error, no se encuentra la clase: "+cNFE);
		}
	}
}