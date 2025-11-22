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
	
	public void setEstado(EstadoEmocional estado) {
		this.estado = estado;
	}

	public AfinidadElemental getAfinidad() {
		return this.afinidad;
	}

	private Boolean sonOpuestas(Criatura criatura2) {
		Boolean resultado = false;
		if(this.afinidad==AfinidadElemental.AGUA && criatura2.afinidad==AfinidadElemental.FUEGO
		|| this.afinidad==AfinidadElemental.FUEGO && criatura2.afinidad==AfinidadElemental.AGUA
		|| this.afinidad==AfinidadElemental.TIERRA && criatura2.afinidad==AfinidadElemental.AIRE
		|| this.afinidad==AfinidadElemental.AIRE && criatura2.afinidad==AfinidadElemental.TIERRA){
			resultado = true;
			return resultado;
		}
		
		return resultado;
	}

	public void interactuar(Criatura criatura2) {
	    if (this instanceof Ancestral) {
	        ((Ancestral)this).dominarInteraccion(criatura2);
	        return;
	    }
	    
	    if (criatura2 instanceof Ancestral) {
	        ((Ancestral)criatura2).dominarInteraccion(this);
	        return;
	    }
	    
		 if (this.afinidad == criatura2.afinidad) {
		        this.energia += 10;
		        criatura2.energia += 10;
		        return;
		    }
		 
		if(sonOpuestas(criatura2)) {
			this.estado=EstadoEmocional.INESTABLE;
			criatura2.estado=EstadoEmocional.INESTABLE;
		}

	}
}
