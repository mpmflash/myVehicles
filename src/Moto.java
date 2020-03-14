import java.io.Serializable;

public class Moto extends Vehiculo implements Serializable{
	//Atributos de la clase moto
	private String marFrontWheel;
	private String modFrontWheel;
	private String tamanyoFrontWheel;
	private int ultPrecioFrontWheel;
	private String marRearWheel;
	private String modRearWheel;
	private String tamanyoRearWheel;
	private int ultPrecioRearWheel;
	private String modTuboEscape;
	private String rutaImg;
	private String taller;
	//Constructores
	public Moto() {
		super.tipo = "Motocicleta";
	}
	public Moto(int newId, String mar, String mod) {
		super.id = newId;
		super.tipo = "Motocicleta";
		super.marca = mar;
		super.modelo = mod;
	}
	// Constructor al que se le pasan todos los datos de la super-clase -- Este constructor es el que ejecuta el programa por defecto
	public Moto(String mar, String mod, String mat, String fechaMat, String tipoMot, int kms) {
		//super.id = 1;
		super.tipo = "Motocicleta";
		super.marca = mar;
		super.modelo = mod;
		super.matricula = mat;
		super.fechaMatriculacion = fechaMat;
		super.tipoMotor = tipoMot;
		super.kilometros = kms;
		//Datos para una moto de prueba
		this.marFrontWheel = "Pirelli";
		this.modFrontWheel = "Diablo BSB";
		this.tamanyoFrontWheel = "120/55";
		this.marRearWheel = "Pirelli";
		this.modRearWheel = "Diablo BSB";
		this.tamanyoRearWheel = "190/55";
		this.describe();
	}
	//Este constructor tan solo servirá para pruebas, ya que jamás se podrá crear una moto con todos los datos de inicio
	public Moto(String mar, String mod, String mat, String fechaMat, String tipoMot, int kms, String frontWheel, String rearWheel, String tubo, String img) {
		super.tipo = "Motocicleta";
		super.marca = mar;
		super.modelo = mod;
		super.matricula = mat;
		super.fechaMatriculacion = fechaMat;
		super.tipoMotor = tipoMot;
		super.kilometros = kms;
		this.modFrontWheel = frontWheel;
		this.modRearWheel = rearWheel;
		this.modTuboEscape = tubo;
		this.rutaImg = img;
	}
	
	//Getters y Setters
	public String getMarFrontWheel() {
		return marFrontWheel;
	}
	public void setMarFrontWheel(String marca) {
		this.marFrontWheel = marca;
	}
	
	public String getModFrontWheel() {
		return modFrontWheel;
	}
	public void setModFrontWheel(String modFrontWheel) {
		this.modFrontWheel = modFrontWheel;
	}
	
	public String getTamanyoFrontWheel() {
		return tamanyoFrontWheel;
	}
	public void setTamanyoFrontWheel(String medidas) {
		this.tamanyoFrontWheel = medidas;
	}
	
	public int getPrecioFrontWheel() {
		return this.ultPrecioFrontWheel;
	}
	public void setPrecioFrontWheel(int precio) {
		this.ultPrecioFrontWheel = precio;
	}
	
	public String getMarRearWheel() {
		return marRearWheel;
	}
	public void setMarRearWheel(String marca) {
		this.marRearWheel = marca;
	}
	
	public String getModRearWheel() {
		return modRearWheel;
	}
	public void setModRearWheel(String modRearWheel) {
		this.modRearWheel = modRearWheel;
	}
	
	public String getTamanyoRearWheel() {
		return tamanyoRearWheel;
	}
	public void setTamanyoRearWheel(String medidas) {
		this.tamanyoRearWheel = medidas;
	}
	
	public int getPrecioRearWheel() {
		return this.ultPrecioRearWheel;
	}
	public void setPrecioRearWheel(int precio) {
		this.ultPrecioRearWheel = precio;
	}
	
	public String getModTuboEscape() {
		return modTuboEscape;
	}
	public void setModTuboEscape(String modTuboEscape) {
		this.modTuboEscape = modTuboEscape;
	}
	
	public String getRutaImg() {
		return rutaImg;
	}
	public void setRutaImg(String rutaImg) {
		this.rutaImg = rutaImg;
	}
	// Métodos de la clase:
	/* Describe ()
	 * Método que te muestra por consola los valores de los atributos de la clase Moto
	 * @param void
	 * @return void
	 */
	@Override
	public void describe() {
		System.out.println("La motocicleta es de la marca: "+ super.getMarca());
		System.out.println("Modelo: "+ super.getModelo());
		System.out.println("Matrícula: "+ super.getMatricula());
		System.out.println("Fecha de matriculación: "+ super.getFechaMatriculacion());
		System.out.println("Tipo de motor: "+ super.getTipoMotor());
		System.out.println("Con : "+ super.getKilometros() + " Kms");
	}
}
