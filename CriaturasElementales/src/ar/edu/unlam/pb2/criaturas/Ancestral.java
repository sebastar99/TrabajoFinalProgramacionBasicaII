package ar.edu.unlam.pb2.criaturas;

public class Ancestral extends Criatura {

	Ancestral(String nombre, int energia, AfinidadElemental afinidad, EstadoEmocional estado)
			throws NivelDeEnergiaSuperadoException {
		super(nombre, energia, afinidad, estado);

	}

	@Override
	protected void entrenar() throws EnergiaSuperadaException {
		this.energia += 20;
		if (this.energia < 100) {
			this.energia = 100;
		}
	}

	@Override
	protected void pacificarCriatura() {
		if (this.getEstado() == EstadoEmocional.INESTABLE) {
			this.setEstado(EstadoEmocional.TRANQUILA);
		}
	}

	@Override
	public Integer getEnergia() {
		return this.energia;
	}



}
