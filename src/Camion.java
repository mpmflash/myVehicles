
public class Camion extends Vehiculo{
	//Atributos de la clase Coche
	
	//Constructores
	public Camion() {
		super.tipo = "Camion";
	}
	public Camion(String mar, String mod) {
		super.tipo = "Camion";
		super.marca = mar;
		super.modelo = mod;
	}
	// Constructor al que se le pasan todos los datos
	public Camion(String mar, String mod, String mat, String fechaMat, String tipoMot, int kms) {
		super.tipo = "Camion";
		super.marca = mar;
		super.modelo = mod;
		super.matricula = mat;
		super.fechaMatriculacion = fechaMat;
		super.tipoMotor = tipoMot;
		super.kilometros = kms;
		this.describe();
	}
	// M�todos de la clase:
	/* Describe ()
	 * M�todo que te muestra por consola los valores de los atributos de la clase Camion
	 * @param void
	 * @return void
	 */
	public void describe() {
		System.out.println("El cami�n es de la marca: "+ super.getMarca());
		System.out.println("Modelo: "+ super.getModelo());
		System.out.println("Matr�cula: "+ super.getMatricula());
		System.out.println("Fecha de matriculaci�n: "+ super.getFechaMatriculacion());
		System.out.println("Tipo de motor: "+ super.getTipoMotor());
		System.out.println("Con : "+ super.getKilometros() + " Kms");
	}
}
