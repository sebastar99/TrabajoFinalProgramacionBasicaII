package ar.edu.unlam.pb2.criaturas;

public abstract class Criatura {

	private String nombre;
	protected Integer energia;
	private AfinidadElemental afinidad;
	protected EstadoEmocional estado;

	Criatura(String nombre, int energia, AfinidadElemental afinidad, EstadoEmocional estado)
			throws NivelDeEnergiaSuperadoException {

		if (energia <= 0 || energia >= 200) {
			throw new NivelDeEnergiaSuperadoException("Supero el limite de energia");
		}

		this.nombre = nombre;
		this.energia = energia;
		this.afinidad = afinidad;
		this.estado = estado;
	}

	protected String getNombre() {
		return this.nombre;
	}
	
	protected abstract void entrenar() throws EnergiaSuperadaException;
	
	protected abstract void pacificarCriatura();

	public Integer getEnergia() {
		return this.energia;
	}

	public EstadoEmocional getEstado() {
		return this.estado;
	}
}
