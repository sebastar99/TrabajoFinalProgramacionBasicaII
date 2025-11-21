package ar.edu.unlam.pb2.criaturas;

public class Salvaje extends Criatura {

	Salvaje(String nombre, Integer energia, AfinidadElemental afinidad) throws NivelDeEnergiaSuperadoException {
	    super(nombre, energia, afinidad, EstadoEmocional.INESTABLE);
	}

	@Override
	public void entrenar() throws EnergiaSuperadaException {
		Integer incremento = (int) (Math.random()*100) + 1;

	    this.energia += incremento;
	    if (this.energia > 200) {
	        throw new EnergiaSuperadaException("La criatura salvaje supero el limite de energia");
	    }
		
	}

	@Override
	public void pacificarCriatura() {
	    if (this.estado == EstadoEmocional.INESTABLE) {
	        this.estado = EstadoEmocional.TRANQUILA;
	    }
	}



}
