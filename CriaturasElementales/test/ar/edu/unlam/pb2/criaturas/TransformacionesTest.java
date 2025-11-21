package ar.edu.unlam.pb2.criaturas;

import static org.junit.Assert.*;

import org.junit.Test;

public class TransformacionesTest {

    @Test
    public void queSePuedaAplicarLaTransformacionBendicionDelRio() 
            throws NivelDeEnergiaSuperadoException, EnergiaSuperadaException {
    	Maestro maestro = new Maestro("Seba", 20, AfinidadElemental.AGUA);

    	Criatura c = new Domestica("Juan", 80, AfinidadElemental.AGUA);
    	maestro.agregarCriatura(c);
    	Transformacion t= new BendicionDelRio(c);

    	maestro.transformarCriatura("Juan", t);
    	assertEquals(Integer.valueOf(160), t.getEnergia());
    }

    @Test
    public void queLaTransformacionDeBendicionDelRioEsteLimitadaA180DeEnergia() 
            throws NivelDeEnergiaSuperadoException, EnergiaSuperadaException {
    	Maestro maestro = new Maestro("Seba", 20, AfinidadElemental.AGUA);

    	Criatura c = new Domestica("Luc", 100, AfinidadElemental.AGUA);
    	maestro.agregarCriatura(c);
    	Transformacion t= new BendicionDelRio(c);

    	maestro.transformarCriatura("Luc", t);
    	assertEquals(Integer.valueOf(180), t.getEnergia());
    }
    @Test
    public void queSePuedaAplicarLaTransformacionAscensoDelViento() 
            throws NivelDeEnergiaSuperadoException, EnergiaSuperadaException {
    	Maestro maestro = new Maestro("Seba", 20, AfinidadElemental.AGUA);

    	Criatura c = new Domestica("Juan", 80, AfinidadElemental.AGUA);
    	maestro.agregarCriatura(c);
    	Transformacion t= new AscensoDelViento(c);

    	maestro.transformarCriatura("Juan", t);
    	assertEquals(AfinidadElemental.AIRE, t.getAfinidad());
    }
    @Test
    public void queSePuedaAplicarLaTransformacionLlamaInternaCuandoLaAfinidadEsFuego() 
            throws NivelDeEnergiaSuperadoException, EnergiaSuperadaException {
    	Maestro maestro = new Maestro("Seba", 20, AfinidadElemental.AGUA);

    	Criatura criatura = new Salvaje("pepe", 150, AfinidadElemental.FUEGO);
    	maestro.agregarCriatura(criatura);
    	Transformacion t= new LlamaInterna(criatura);
    	maestro.transformarCriatura("pepe", t);
    	assertEquals(Integer.valueOf(180), t.getEnergia());
    }
    @Test
    public void queSePuedaAplicarLaTransformacionLlamaInternaCuandoLaAfinidadNoEsFuego() 
            throws NivelDeEnergiaSuperadoException, EnergiaSuperadaException {
    	Maestro maestro = new Maestro("Seba", 20, AfinidadElemental.AGUA);

    	Criatura criatura = new Salvaje("pepe", 130, AfinidadElemental.TIERRA);
    	maestro.agregarCriatura(criatura);
    	Transformacion t= new LlamaInterna(criatura);
    	maestro.transformarCriatura("pepe", t);
    	assertEquals(EstadoEmocional.INESTABLE, t.getEstado());
    }
    @Test
    public void queSePuedaAplicarLaTransformacionVinculoTerrestreConEnergiaMenorA50() 
            throws NivelDeEnergiaSuperadoException, EnergiaSuperadaException {
    	Maestro maestro = new Maestro("Seba", 20, AfinidadElemental.AGUA);

    	Criatura criatura = new Ancestral("Odin", 10, AfinidadElemental.TIERRA, EstadoEmocional.TRANQUILA);
    	maestro.agregarCriatura(criatura);
    	Transformacion t= new VinculoTerrestre(criatura);
    	maestro.transformarCriatura("Odin", t);
    	assertEquals(Integer.valueOf(50), t.getEnergia());
    }
    @Test
    public void queSePuedaAplicarLaTransformacionVinculoTerrestreConEnergiaMayorA50() 
            throws NivelDeEnergiaSuperadoException, EnergiaSuperadaException {
    	Maestro maestro = new Maestro("Seba", 20, AfinidadElemental.AGUA);

    	Criatura criatura = new Ancestral("Odin", 100, AfinidadElemental.TIERRA, EstadoEmocional.TRANQUILA);
    	maestro.agregarCriatura(criatura);
    	Transformacion t= new VinculoTerrestre(criatura);
    	maestro.transformarCriatura("Odin", t);
    	assertEquals(Integer.valueOf(100), t.getEnergia());
    }
    
    



}
