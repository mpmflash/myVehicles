
public class Vehiculo {
	//Atributos
	protected int id; // Ir sumando números para identificar los vehículos
	protected String tipo; // Coche, Moto, Camion
	protected String marca;
	protected String modelo;
	protected String matricula;
	protected String fechaMatriculacion;
	protected String tipoMotor;
	protected int kilometros;
	
	//Getters y Setters
	public int getId() {
		return id;
	}
	public void setId() {
		
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String t) {
		this.tipo = t;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getFechaMatriculacion() {
		return fechaMatriculacion;
	}
	public void setFechaMatriculacion(String fechaMatriculacion) {
		this.fechaMatriculacion = fechaMatriculacion;
	}
	
	public String getTipoMotor() {
		return tipoMotor;
	}
	public void setTipoMotor(String tipoMotor) {
		this.tipoMotor = tipoMotor;
	}

	public int getKilometros() {
		return kilometros;
	}
	public void setKilometros(int kilometros) {
		this.kilometros = kilometros;
	}
	
	// Métodos de la clase
	public void describe() {
		System.out.println("Es de la marca: "+ this.getMarca());
		System.out.println("Modelo: "+ this.getModelo());
		System.out.println("Matrícula: "+ this.getMatricula());
		System.out.println("Fecha de matriculación: "+ this.getFechaMatriculacion());
		System.out.println("Tipo de motor: "+ this.getTipoMotor());
		System.out.println("Con : "+ this.getKilometros() + " Kms");
	}
}
