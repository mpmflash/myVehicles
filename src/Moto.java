
public class Moto extends Vehiculo{
	//Atributos de la clase moto
	private String marFrontWheel;
	private String modFrontWheel;
	private int ultPrecioFrontWheel;
	private String marRearWheel;
	private String modRearWheel;
	private int ultPrecioRearWheel;
	private String modTuboEscape;
	private String rutaImg;
	//Constructores
	public Moto() {
		super.tipo = "Motocicleta";
	}
	public Moto(String mar, String mod) {
		super.tipo = "Motocicleta";
		super.marca = mar;
		super.modelo = mod;
		this.marFrontWheel = "0";
	}
	// Constructor al que se le pasan todos los datos de la super-clase
	public Moto(String mar, String mod, String mat, String fechaMat, String tipoMot, int kms) {
		super.tipo = "Motocicleta";
		super.marca = mar;
		super.modelo = mod;
		super.matricula = mat;
		super.fechaMatriculacion = fechaMat;
		super.tipoMotor = tipoMot;
		super.kilometros = kms;
		this.marFrontWheel = "Pirelli";
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
