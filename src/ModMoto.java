import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.jgoodies.forms.layout.Sizes;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;

public class ModMoto extends JFrame {
	// Fuentes para la clase
	public Font txtNormal = new Font("Calibri", Font.PLAIN, 15);
	public Font txtNegrita = new Font("Calibri", Font.BOLD, 15);
	
	//Atributos de la clase
	private JTabbedPane tabPane;
	
	// Objetos del panel info
	private JPanel infoPane;
	private JLabel lblMarca;
	private JTextField tFMarca;
	private JLabel lblModelo;
	private JTextField tFModelo;
	private JLabel lblMatricula;
	private JTextField tFMatricula;
	private JLabel lblFoto;
	private JLabel lblFechaMat;
	private JTextField tFFechaMat;
	private JLabel lblKilometros;
	private JTextField tFKms;
	private JButton btnModificarGen;
	private JButton btnVolver;
	
	// Objetos del panel ruedas
	private JPanel ruedasPane;
	private JLabel lFMarca;
	private ImageIcon icnMarca;
	//Rueda delantera
	private JLabel lblMarcaFrontWheel;
	private JTextField tFMarcaFrontWheel;
	private JLabel lblModeloFrontWheel;
	private JTextField tFModelFrontWheel;
	private JLabel lblPrecioFW;
	private JTextField tFPrecioFW;
	//Rueda trasera
	private JLabel lblMarcaRearWheel;
	private JTextField tFMarcaRearWheel;
	private JLabel lblModeloRearWheel;
	private JTextField tFModelRearWheel;
	private JLabel lblPrecioRW;
	private JTextField tFPrecioRW;
	
	// Objetos del panel taller
	private JPanel tallerPane;
	private JLabel lblHistorialDelTaller;
	private JTextField tFAddComment;
	
	
	//Constructores
	public ModMoto(Window w, Vehiculo v) {
		// Creamos la moto nueva con el vehículo que viene del programa en ejecución
		Moto m = new Moto();
		m = (Moto) v;
		// Creación de la ventana
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		// Crearemos una ventana con pestañas, cada pestaña tendrá su panel
		JTabbedPane tabPane = new JTabbedPane();
		tabPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		this.setTitle("Modificar vehículo: "+ m.getMarca() + " " + m.getModelo() + " " + m.getMatricula() );
		this.setLocationRelativeTo(null); // Esto hace que se centre la ventana
		this.setContentPane(tabPane);
		// Creación de paneles para las pestañas
		// InfoPane (Panel principal)
		infoPane = new JPanel();
		tabPane.addTab("General", infoPane);
		infoPane.setLayout(null);
		
		lblMarca = new JLabel("Marca:");
		lblMarca.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarca.setFont(txtNormal);
		lblMarca.setBounds(10,10, 80, 20);
		infoPane.add(lblMarca);
		
		tFMarca = new JTextField();
		tFMarca.setBounds(95, 10, 100, 20);
		tFMarca.setText(m.getMarca());
		tFMarca.setEnabled(false);
		infoPane.add(tFMarca);
		
		lblFoto = new JLabel("Fotografia");
		lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto.setBounds(224, 10, 176, 140);
		infoPane.add(lblFoto);
		
		lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(10, 40, 80, 20);
		lblModelo.setFont(txtNormal);
		lblModelo.setHorizontalAlignment(SwingConstants.CENTER);
		infoPane.add(lblModelo);
		
		JTextField tFModelo = new JTextField();
		tFModelo.setBounds(95, 40, 100, 20);		
		tFModelo.setText(m.getModelo());
		tFModelo.setEnabled(false);
		infoPane.add(tFModelo);
		
		lblMatricula = new JLabel("Matrícula:");
		lblMatricula.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatricula.setFont(txtNormal);
		lblMatricula.setBounds(10, 70, 80, 20);
		infoPane.add(lblMatricula);
		
		tFMatricula = new JTextField();
		tFMatricula.setBounds(95, 70, 100, 20);
		tFMatricula.setText(m.getMatricula());
		tFMatricula.setEnabled(false);
		infoPane.add(tFMatricula);
		
		lblFechaMat = new JLabel("Fecha mat.:");
		lblFechaMat.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaMat.setFont(txtNormal);
		lblFechaMat.setBounds(10, 100, 80, 20);
		infoPane.add(lblFechaMat);
		
		tFFechaMat = new JTextField();
		tFFechaMat.setBounds(95, 100, 100, 20);
		tFFechaMat.setText(m.getFechaMatriculacion());
		tFFechaMat.setEnabled(false);
		infoPane.add(tFFechaMat);
		
		lblKilometros = new JLabel("Kil\u00F3metros:");
		lblKilometros.setFont(txtNormal);
		lblKilometros.setHorizontalAlignment(SwingConstants.CENTER);
		lblKilometros.setBounds(10, 130, 80, 20);
		infoPane.add(lblKilometros);
		
		tFKms = new JTextField();
		tFKms.setBounds(95, 130, 100, 20);
		// Coger los kms que son int
		String kms = String.valueOf(m.getKilometros());
		tFKms.setText(kms);
		tFKms.setEnabled(false);
		infoPane.add(tFKms);
		// -------- Botón para habilitar los campos para modificar -------------------
		JToggleButton tBHabC = new JToggleButton("Habilitar campos");
		tBHabC.setBounds(10, 161, 186, 23);
		infoPane.add(tBHabC);
		// Le agregamos acción al botón
		ActionListener changeEnabledButtons = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(getTFMarca().isEnabled()) {
					changeButtons(true);
				}else {
					changeButtons(false);
				}	
			}
		};
		tBHabC.addActionListener(changeEnabledButtons);
		// -------- Botón para modificar el vehículo --------------------------------
		btnModificarGen = new JButton("Modificar");
		btnModificarGen.setBounds(10, 189, 185, 23);
		btnModificarGen.setEnabled(false);
		infoPane.add(btnModificarGen);
		// Le agregamos acción al botón
		ActionListener modificarGeneral = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg1) {
				//TO-DO
			}
		};
		btnModificarGen.addActionListener(modificarGeneral);
		// -------- Botón para cambiar la imagen del vehículo -----------------------
		JButton btnChangeImg = new JButton("A\u00F1adir/Cambiar foto");
		btnChangeImg.setBounds(224, 161, 176, 23);
		infoPane.add(btnChangeImg);
		
		// Le agregamos acción al botón
		ActionListener changeImg = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg1) {
				//TO-DO
			}
		};
		btnChangeImg.addActionListener(changeImg);
		// -------- Botón para volver a la ventana principal de la app --------------
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(275, 189, 80, 23);
		infoPane.add(btnVolver);
		// Le agregamos acción al botón
		ActionListener returnToWindow = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg1) {
				w.hideWindow(false);
				closeWindow();
			}
		};
		btnVolver.addActionListener(returnToWindow);
		
		// RuedasPane (Panel donde veremos información referente a las ruedas)
		ruedasPane = new JPanel();
		tabPane.addTab("Ruedas", ruedasPane);
		ruedasPane.setLayout(null);
		
		//icnMarca = new ImageIcon("pirelli.jpg");
		lFMarca = new JLabel();
		lFMarca.setBounds(292, 34, 117, 81);
		if(m.getMarFrontWheel().equalsIgnoreCase("0")) { //Peta el programa
			lFMarca.setText("Icn Marca");
			lFMarca.setHorizontalAlignment(SwingConstants.CENTER);
		} else {
			icnMarca = new ImageIcon(m.getMarFrontWheel().toLowerCase()+".jpg");
			lFMarca.setIcon(new ImageIcon(icnMarca.getImage().getScaledInstance(lFMarca.getWidth(), lFMarca.getHeight(), Image.SCALE_SMOOTH)));
		}
		
		ruedasPane.add(lFMarca);
		
		//Panel para organizar las diferentes ruedas (este para la delantera) y crearle un borde divisorio
		JPanel pFrontWheel = new JPanel();
		pFrontWheel.setBounds(10, 11, 123, 201);
		pFrontWheel.setBorder(BorderFactory.createTitledBorder("Rueda delantera"));
		ruedasPane.add(pFrontWheel);
		
		lblMarcaFrontWheel = new JLabel("Marca");
		pFrontWheel.add(lblMarcaFrontWheel);
		
		JTextField tFMarcaFrontWheel = new JTextField();
		pFrontWheel.add(tFMarcaFrontWheel);
		tFMarcaFrontWheel.setColumns(10);
		
		lblModeloFrontWheel = new JLabel("Modelo");
		pFrontWheel.add(lblModeloFrontWheel);
		
		JTextField tFModeloFrontWheel= new JTextField();
		pFrontWheel.add(tFModeloFrontWheel);
		tFModeloFrontWheel.setColumns(10);
		
		lblPrecioFW = new JLabel("Precio");
		pFrontWheel.add(lblPrecioFW);
		
		tFPrecioFW = new JTextField();
		pFrontWheel.add(tFPrecioFW);
		tFPrecioFW.setColumns(10);
		
		//Panel para organizar las diferentes ruedas (este para la trasera) y crearle el borde divisorio
		JPanel pRearWheel = new JPanel();
		pRearWheel.setBounds(159, 11, 123, 201);
		pRearWheel.setBorder(BorderFactory.createTitledBorder("Rueda trasera"));
		ruedasPane.add(pRearWheel);
		
		lblMarcaRearWheel = new JLabel("Marca");
		pRearWheel.add(lblMarcaRearWheel);
		
		JTextField tFMarcaRearWheel = new JTextField();
		pRearWheel.add(tFMarcaRearWheel);
		tFMarcaRearWheel.setColumns(10);
		
		lblModeloRearWheel = new JLabel("Modelo");
		pRearWheel.add(lblModeloRearWheel);
		
		JTextField tFModeloRearWheel= new JTextField();
		pRearWheel.add(tFModeloRearWheel);
		tFModeloRearWheel.setColumns(10);
		
		lblPrecioRW = new JLabel("Precio");
		pRearWheel.add(lblPrecioRW);
		
		tFPrecioRW = new JTextField();
		pRearWheel.add(tFPrecioRW);
		tFPrecioRW.setColumns(10);
		
		JButton btnChangeWheel = new JButton("Modificar");
		btnChangeWheel.setBounds(302, 155, 92, 23);
		ruedasPane.add(btnChangeWheel);
		//Agregamos acción al botón
		
		JButton btnVolverWheel = new JButton("Volver");
		btnVolverWheel.setBounds(302, 189, 92, 23);
		ruedasPane.add(btnVolverWheel);
		// Le agregamos acción al botón
		btnVolverWheel.addActionListener(returnToWindow);
		
		//TallerPane (Panel donde veremos información referente a cosas extras a guardar)
		tallerPane = new JPanel();
		tabPane.addTab("Taller", tallerPane);
		tallerPane.setLayout(null);
		
		lblHistorialDelTaller = new JLabel("Historial del taller:");
		lblHistorialDelTaller.setBounds(10, 11, 89, 14);
		tallerPane.add(lblHistorialDelTaller);
		
		JLabel lblFechaVisita = new JLabel("Fecha visita:");
		lblFechaVisita.setBounds(134, 11, 80, 14);
		tallerPane.add(lblFechaVisita);
		
		JFormattedTextField tFFechaVisita = new JFormattedTextField();
		tFFechaVisita.setBounds(224, 8, 95, 20);
		tallerPane.add(tFFechaVisita);
		
		tFAddComment = new JTextField();
		tFAddComment.setBounds(10, 36, 399, 20);
		tallerPane.add(tFAddComment);
		tFAddComment.setColumns(10);
		
		JButton btnAddComment = new JButton("Comentar");
		btnAddComment.setBounds(329, 7, 80, 23);
		tallerPane.add(btnAddComment);
		
		JTextPane tPHistorial = new JTextPane();
		tPHistorial.setBounds(10, 66, 399, 146);
		tallerPane.add(tPHistorial);
	}
	// Getters y Setters
	public JTextField getTFMarca() {
		return this.tFMarca;
	}
	public JTextField getTFModelo() {
		return this.tFModelo;
	}
	public JTextField getTFMatricula() {
		return this.tFMatricula;
	}
	public JTextField getTFFechaMat() {
		return this.tFFechaMat;
	}
	public JTextField getTFKms() {
		return this.tFKms;
	}
	public JButton getButtonModificarGen() {
		return this.btnModificarGen;
	}
	
	// Métodos de la clase ModMoto
	/*
	 * changeButtons(boolean)
	 * Método que le pasamos true or false y nos cambia el parámetro enabled de los JTextFields de la clase
	 * @param boolean
	 * @return void
	 */
	public void changeButtons(boolean tof) {
		if(tof) {
			getTFMarca().setEnabled(false);
			//getTFModelo().setEnabled(false);
			getTFMatricula().setEnabled(false);
			getTFFechaMat().setEnabled(false);
			getTFKms().setEnabled(false);
			getButtonModificarGen().setEnabled(false);
		}else {
			getTFMarca().setEnabled(true);
			//getTFModelo().setEnabled(true);
			getTFMatricula().setEnabled(true);
			getTFFechaMat().setEnabled(true);
			getTFKms().setEnabled(true);
			getButtonModificarGen().setEnabled(true);
		}
	}
	
	/*
	 * closeWindow();
	 * Método que permite cerrar la ventana de modificación de moto
	 * @param void
	 * @return void
	 */
	private void closeWindow() {
		this.dispose();
	}
}
