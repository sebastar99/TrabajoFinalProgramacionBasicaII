package ar.edu.unlam.pb2.criaturas;

public abstract class Transformacion extends Criatura{
	

    protected Criatura criatura;

    public Transformacion (Criatura criatura) {
        super(criatura.getNombre(), criatura.getEnergia(), criatura.getAfinidad(), criatura.getEstado()); 
        this.criatura = criatura;
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
	


	
	

}
