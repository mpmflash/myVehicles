import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddVehicle extends JFrame{

	private static final long serialVersionUID = 1L;
	// Tipos de letras definidos
	public Font txtNormal = new Font("Calibri", Font.PLAIN, 15);
	public Font txtNegrita = new Font("Calibri", Font.BOLD, 15);
	// Objetos para trabajar con diferentes métodos
	public JPanel pAddVehicle;
	public ArrayList<JTextField> listaTextFields;
	
	//Constructores de la clase AddVehicle
	public AddVehicle( ArrayList<Vehiculo> listaV ) {
		//Inicializamos la lista de JTextFields
		listaTextFields = new ArrayList<JTextField>();
		// Ventana para añadir vehículo
		this.setTitle("Añadir un vehículo");
		this.setSize(450,200); //Tamaño de la ventana
		//this.pack(); // Se amolda al tamaño de objetos que tiene que mostrar
		this.setLocationRelativeTo(null); // Esto hace que se centre la ventana
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				
		//initComponentes();
		//Panel principal de para la ventana añadir vehículo
		pAddVehicle = new JPanel();
		pAddVehicle.setLayout(null); // Desactivamos el diseño por defecto
		this.getContentPane().add(pAddVehicle); // Agregamos a la ventana el panel que acabamos de crear
		
		// Crearemos los radio botones de selección de tipo de vehículo
		//Crear un grupo de botones:
		ButtonGroup gBVehiculos = new ButtonGroup();
		
		// Código para inicializar las diferentes partes de la ventana
		//Tipo de vehículo:
		//Etiqueta:
		JLabel lTVehiculo = new JLabel("Tipo de vehículo:");
		lTVehiculo.setBounds(20, 7, 120, 20);
		lTVehiculo.setFont(txtNegrita);
		pAddVehicle.add(lTVehiculo);
		
		// Radio Buttons
		// Para el coche:
		JRadioButton rBCoche = new JRadioButton("Coche", true);
		rBCoche.setBounds(20, 30, 100, 25);
		rBCoche.setFont(txtNormal);
		gBVehiculos.add(rBCoche);
		pAddVehicle.add(rBCoche);
		
		// Para la motocicleta:
		JRadioButton rBMoto = new JRadioButton("Motocicleta", false);
		rBMoto.setBounds(20, 50, 100, 25);
		rBMoto.setFont(txtNormal);
		gBVehiculos.add(rBMoto);
		pAddVehicle.add(rBMoto);
		
		// Para el camión:
		JRadioButton rBCamion = new JRadioButton("Camión", false);
		rBCamion.setBounds(20, 70, 100, 25);
		rBCamion.setFont(txtNormal);
		gBVehiculos.add(rBCamion);
		pAddVehicle.add(rBCamion);
		
		//Marca:
		//Etiqueta
		JLabel lMarca = new JLabel("Marca");
		lMarca.setBounds(170, 7, 100, 20);
		lMarca.setFont(txtNegrita);
		pAddVehicle.add(lMarca);
		//TextField
		JTextField tFMarca = new JTextField();
		tFMarca.setBounds(175, 27, 90, 20);
		pAddVehicle.add(tFMarca);
		//Añadimos el JTextField a una lista para poderlos resetear fácilmente
		listaTextFields.add(tFMarca);
		
		//Modelo:
		//Etiqueta
		JLabel lModelo = new JLabel("Modelo");
		lModelo.setBounds(275, 7, 80, 20);
		lModelo.setFont(txtNegrita);
		pAddVehicle.add(lModelo);
		//TextField
		JTextField tFModelo = new JTextField();
		tFModelo.setBounds(280, 27, 90, 20);
		pAddVehicle.add(tFModelo);
		//Añadimos el JTextField a una lista para poderlos resetear fácilmente
		listaTextFields.add(tFModelo);
		
		//Matrícula:
		//Etiqueta
		JLabel lMatricula = new JLabel("Matrícula");
		lMatricula.setBounds(170, 50, 70, 20);
		lMatricula.setFont(txtNegrita);
		pAddVehicle.add(lMatricula);
		//TextField
		JTextField tFMatricula = new JTextField();
		tFMatricula.setBounds(175, 70, 90, 20);
		pAddVehicle.add(tFMatricula);
		//Añadimos el JTextField a una lista para poderlos resetear fácilmente
		listaTextFields.add(tFMatricula);
		
		//Fecha Matriculación:
		//Etiqueta
		JLabel lFechaM = new JLabel("Fecha de matriculación");
		lFechaM.setBounds(275, 50, 150, 20);
		lFechaM.setFont(txtNegrita);
		pAddVehicle.add(lFechaM);
		//TextField
		JTextField tFFechaM = new JTextField();
		tFFechaM.setBounds(280, 70, 90, 20);
		pAddVehicle.add(tFFechaM);
		//Añadimos el JTextField a una lista para poderlos resetear fácilmente
		listaTextFields.add(tFFechaM);
		
		//Tipo de motor:
		JLabel lTipoMotor = new JLabel("Tipo de motor");
		lTipoMotor.setBounds(170, 95, 100, 20);
		lTipoMotor.setFont(txtNegrita);
		pAddVehicle.add(lTipoMotor);
		//Lista de tipo de motores con JComboBox
		String [] tipoMotor = {"Gasolina","Diésel","Híbrido","Gas","Eléctrico"};
		JComboBox cBTipoM = new JComboBox(tipoMotor);
		cBTipoM.setBounds(175, 115, 90, 20);
		//cBTipoM.setSelectedItem("");
		pAddVehicle.add(cBTipoM);
		
		//Kilómetros:
		//Etiqueta
		JLabel lKms = new JLabel("Kilómetros");
		lKms.setBounds(20, 95, 80, 20);
		lKms.setFont(txtNegrita);
		pAddVehicle.add(lKms);
		// TextFields:
		JTextField tFKms = new JTextField();
		tFKms.setBounds(25, 115, 90, 20);
		pAddVehicle.add(tFKms);
		//Añadimos el JTextField a una lista para poderlos resetear fácilmente
		listaTextFields.add(tFKms);
		
		//Botón para añadir vehículo
		JButton bAñadir = new JButton("Añadir");
		bAñadir.setBounds(280, 115, 90, 20);
		bAñadir.setFont(txtNormal);
		pAddVehicle.add(bAñadir);
		// Action Listener para realizar la acción al pulsar el botón
		ActionListener accionAnadir = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent ae) {
			
			if(rBCoche.isSelected()) {
				Coche newCoche = new Coche();
				newCoche.setMarca(tFMarca.getText());
				newCoche.setModelo(tFModelo.getText());
				newCoche.setMatricula(tFMatricula.getText());
				newCoche.setFechaMatriculacion(tFFechaM.getText());
				newCoche.setKilometros(Integer.parseInt(tFKms.getText()));
				newCoche.setTipoMotor((String) cBTipoM.getSelectedItem());
				newCoche.describe();
				// Añadimos la nueva moto con los datos del usuario a la lista de vehículos
				listaV.add(newCoche);
				
			} else if(rBMoto.isSelected()) {
				Moto newMoto = new Moto();
				newMoto.setMarca(tFMarca.getText());
				newMoto.setModelo(tFModelo.getText());
				newMoto.setMatricula(tFMatricula.getText());
				newMoto.setFechaMatriculacion(tFFechaM.getText());
				newMoto.setKilometros(Integer.parseInt(tFKms.getText()));
				newMoto.setTipoMotor((String) cBTipoM.getSelectedItem());
				newMoto.describe();
				// Añadimos la nueva moto con los datos del usuario a la lista de vehículos
				listaV.add(newMoto);
				
			} else {
				Camion newCamion = new Camion();
				newCamion.setMarca(tFMarca.getText());
				newCamion.setModelo(tFModelo.getText());
				newCamion.setMatricula(tFMatricula.getText());
				newCamion.setFechaMatriculacion(tFFechaM.getText());
				newCamion.setKilometros(Integer.parseInt(tFKms.getText()));
				newCamion.setTipoMotor((String) cBTipoM.getSelectedItem());
				newCamion.describe();
				// Añadimos la nueva moto con los datos del usuario a la lista de vehículos
				listaV.add(newCamion);
			}
			
			//Después de añadir el Vehículo, cerramos la ventana
			closeWindow(listaV);
			
			/* Prueba de la ArrayList
			System.out.println("El tamañano de la lista de vehículos es: "+listaV.size());
			Vehiculo v = new Vehiculo();
			v = listaV.get(0);
			System.out.println("Mostrando el vehículo V");
			v.describe();
			*/
		}
	};
		bAñadir.addActionListener(accionAnadir);
	}
	
	//Métodos de la clase: todos los método init... Inician los componentes visuales de la clase
	/*
	 * closeWindow()
	 * Cierra el JFrame AddVehicle
	 */
	public void closeWindow( ArrayList<Vehiculo> listaV) {
		Window w = new Window(listaV);
		this.dispose();
		w.setVisible(true);		
	}
}
