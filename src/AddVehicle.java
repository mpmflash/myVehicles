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
	// Objetos para trabajar con diferentes m�todos
	public JPanel pAddVehicle;
	public ArrayList<JTextField> listaTextFields;
	
	//Constructores de la clase AddVehicle
	public AddVehicle( ArrayList<Vehiculo> listaV ) {
		//Inicializamos la lista de JTextFields
		listaTextFields = new ArrayList<JTextField>();
		// Ventana para a�adir veh�culo
		this.setTitle("A�adir un veh�culo");
		this.setSize(450,200); //Tama�o de la ventana
		//this.pack(); // Se amolda al tama�o de objetos que tiene que mostrar
		this.setLocationRelativeTo(null); // Esto hace que se centre la ventana
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				
		//initComponentes();
		//Panel principal de para la ventana a�adir veh�culo
		pAddVehicle = new JPanel();
		pAddVehicle.setLayout(null); // Desactivamos el dise�o por defecto
		this.getContentPane().add(pAddVehicle); // Agregamos a la ventana el panel que acabamos de crear
		
		// Crearemos los radio botones de selecci�n de tipo de veh�culo
		//Crear un grupo de botones:
		ButtonGroup gBVehiculos = new ButtonGroup();
		
		// C�digo para inicializar las diferentes partes de la ventana
		//Tipo de veh�culo:
		//Etiqueta:
		JLabel lTVehiculo = new JLabel("Tipo de veh�culo:");
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
		
		// Para el cami�n:
		JRadioButton rBCamion = new JRadioButton("Cami�n", false);
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
		//A�adimos el JTextField a una lista para poderlos resetear f�cilmente
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
		//A�adimos el JTextField a una lista para poderlos resetear f�cilmente
		listaTextFields.add(tFModelo);
		
		//Matr�cula:
		//Etiqueta
		JLabel lMatricula = new JLabel("Matr�cula");
		lMatricula.setBounds(170, 50, 70, 20);
		lMatricula.setFont(txtNegrita);
		pAddVehicle.add(lMatricula);
		//TextField
		JTextField tFMatricula = new JTextField();
		tFMatricula.setBounds(175, 70, 90, 20);
		pAddVehicle.add(tFMatricula);
		//A�adimos el JTextField a una lista para poderlos resetear f�cilmente
		listaTextFields.add(tFMatricula);
		
		//Fecha Matriculaci�n:
		//Etiqueta
		JLabel lFechaM = new JLabel("Fecha de matriculaci�n");
		lFechaM.setBounds(275, 50, 150, 20);
		lFechaM.setFont(txtNegrita);
		pAddVehicle.add(lFechaM);
		//TextField
		JTextField tFFechaM = new JTextField();
		tFFechaM.setBounds(280, 70, 90, 20);
		pAddVehicle.add(tFFechaM);
		//A�adimos el JTextField a una lista para poderlos resetear f�cilmente
		listaTextFields.add(tFFechaM);
		
		//Tipo de motor:
		JLabel lTipoMotor = new JLabel("Tipo de motor");
		lTipoMotor.setBounds(170, 95, 100, 20);
		lTipoMotor.setFont(txtNegrita);
		pAddVehicle.add(lTipoMotor);
		//Lista de tipo de motores con JComboBox
		String [] tipoMotor = {"Gasolina","Di�sel","H�brido","Gas","El�ctrico"};
		JComboBox cBTipoM = new JComboBox(tipoMotor);
		cBTipoM.setBounds(175, 115, 90, 20);
		//cBTipoM.setSelectedItem("");
		pAddVehicle.add(cBTipoM);
		
		//Kil�metros:
		//Etiqueta
		JLabel lKms = new JLabel("Kil�metros");
		lKms.setBounds(20, 95, 80, 20);
		lKms.setFont(txtNegrita);
		pAddVehicle.add(lKms);
		// TextFields:
		JTextField tFKms = new JTextField();
		tFKms.setBounds(25, 115, 90, 20);
		pAddVehicle.add(tFKms);
		//A�adimos el JTextField a una lista para poderlos resetear f�cilmente
		listaTextFields.add(tFKms);
		
		//Bot�n para a�adir veh�culo
		JButton bA�adir = new JButton("A�adir");
		bA�adir.setBounds(280, 115, 90, 20);
		bA�adir.setFont(txtNormal);
		pAddVehicle.add(bA�adir);
		// Action Listener para realizar la acci�n al pulsar el bot�n
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
				// A�adimos la nueva moto con los datos del usuario a la lista de veh�culos
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
				// A�adimos la nueva moto con los datos del usuario a la lista de veh�culos
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
				// A�adimos la nueva moto con los datos del usuario a la lista de veh�culos
				listaV.add(newCamion);
			}
			
			//Despu�s de a�adir el Veh�culo, cerramos la ventana
			closeWindow(listaV);
			
			/* Prueba de la ArrayList
			System.out.println("El tama�ano de la lista de veh�culos es: "+listaV.size());
			Vehiculo v = new Vehiculo();
			v = listaV.get(0);
			System.out.println("Mostrando el veh�culo V");
			v.describe();
			*/
		}
	};
		bA�adir.addActionListener(accionAnadir);
	}
	
	//M�todos de la clase: todos los m�todo init... Inician los componentes visuales de la clase
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
