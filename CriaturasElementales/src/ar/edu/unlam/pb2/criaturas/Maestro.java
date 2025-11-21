package ar.edu.unlam.pb2.criaturas;

import java.util.HashMap;

public class Maestro {

	private String nombre;
	private Integer nivelMaestria;
	private AfinidadElemental afinidadPrincipal;
	private HashMap<String, Criatura> criaturas = new HashMap<>();

	public Maestro(String nombre, int nivelMaestria, AfinidadElemental afinidadPrincipal)
	        throws NivelDeMaestriaSuperadoException {

	    if (nivelMaestria < 1 || nivelMaestria > 50) {
	        throw new NivelDeMaestriaSuperadoException("Superó el límite de maestría");
	    }

	    this.nombre = nombre;
	    this.nivelMaestria = nivelMaestria;
	    this.afinidadPrincipal = afinidadPrincipal;
	}

	public void agregarCriatura(Criatura criatura) {
		criaturas.put(criatura.getNombre(), criatura);
	}

	public Integer cantCriaturas() {
		return criaturas.size();
	}

	public void entrenarCriatura(String nombre) throws EnergiaSuperadaException {
	    Criatura criatura = criaturas.get(nombre);
	    if (criatura != null) {
	    	criatura.entrenar(); 
	    }
	}

	public void pacificarCriatura(String nombre){
	    Criatura criatura = criaturas.get(nombre);
	    if (criatura != null) {
	    	criatura.pacificarCriatura(); 
	    }
	}
	public void transformarCriatura(String nombre, Transformacion transformacion) {
	    if (!criaturas.containsKey(nombre)) {
	        throw new IllegalArgumentException("No existe una criatura con ese nombre: " + nombre);
	    }

	    criaturas.put(nombre, transformacion);
	}
	
}
