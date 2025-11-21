package ar.edu.unlam.pb2.criaturas;

public class AscensoDelViento extends Transformacion {

	public AscensoDelViento(Criatura criatura) {
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
		return criatura.getEnergia();
	}
	
	public AfinidadElemental getAfinidad() {
		return AfinidadElemental.AIRE;
	}


}
