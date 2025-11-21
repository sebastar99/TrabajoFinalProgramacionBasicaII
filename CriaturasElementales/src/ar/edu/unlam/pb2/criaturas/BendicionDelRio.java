package ar.edu.unlam.pb2.criaturas;

public class BendicionDelRio extends Transformacion{

	public BendicionDelRio(Criatura criatura) {
		super(criatura);
		
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
		Integer energiaTransformada=criatura.getEnergia()*2;
		
		if(energiaTransformada>180) {
			energiaTransformada=180;
		}
		return energiaTransformada;
	}


}
