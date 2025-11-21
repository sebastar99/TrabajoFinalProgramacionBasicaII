package ar.edu.unlam.pb2.criaturas;

public class VinculoTerrestre extends Transformacion{

	public VinculoTerrestre(Criatura criatura) {
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
		Integer energiaTransformada=criatura.getEnergia();
	   if(energiaTransformada<50) {
		   energiaTransformada=50;
		   
	   }
		return energiaTransformada;
	}

}
