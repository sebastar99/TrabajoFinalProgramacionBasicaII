package ar.edu.unlam.pb2.criaturas;

public abstract class Criatura {

	private String nombre;
	protected Integer energia;
	private AfinidadElemental afinidad;
	private EstadoEmocional estado;

	Criatura(String nombre, int energia, AfinidadElemental afinidad, EstadoEmocional estado)
			throws NivelDeEnergiaSuperadoException {

		if (energia < 0 || energia >200) {
			throw new NivelDeEnergiaSuperadoException("Supero el limite de energia");
		}

		this.nombre = nombre;
		this.energia = energia;
		this.afinidad = afinidad;
		this.estado = estado;
	}

	
	protected abstract void entrenar() throws EnergiaSuperadaException;
	
	protected abstract void pacificarCriatura();
	public String getNombre() {
		return this.nombre;
	}

	public abstract Integer getEnergia();

	public EstadoEmocional getEstado() {
		return this.estado;
	}
	

	public void setAfinidad(AfinidadElemental afinidad) {
		this.afinidad = afinidad;
	}


	public void setEstado(EstadoEmocional estado) {
		this.estado = estado;
	}


	public AfinidadElemental getAfinidad() {
		return this.afinidad;
	}
}
