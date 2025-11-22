package ar.edu.unlam.pb2.criaturas;

public class Domestica extends Criatura {

	Domestica(String nombre, int energia, AfinidadElemental afinidad) throws NivelDeEnergiaSuperadoException {
		super(nombre, energia, afinidad, EstadoEmocional.TRANQUILA);

	}

	@Override
	protected void entrenar() throws EnergiaSuperadaException {
		this.energia ++;
	}

	@Override
	protected void pacificarCriatura() {
		//this.pacificarCriatura();
				
	}

	@Override
	public Integer getEnergia() {
		return this.energia;
	}

}
