package ar.edu.unlam.pb2.criaturas;

public class LlamaInterna extends Transformacion {

	public LlamaInterna(Criatura criatura) {
		super(criatura);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void entrenar() throws EnergiaSuperadaException {
		criatura.entrenar();

	}

	@Override
	protected void pacificarCriatura() {
		criatura.pacificarCriatura();

	}

	@Override
	public Integer getEnergia() {
		
		if(criatura.getAfinidad()==AfinidadElemental.FUEGO) {
			return criatura.getEnergia()+30;
		}
		criatura.setEstado(EstadoEmocional.INESTABLE);
		return criatura.getEnergia();
	}



	

}
