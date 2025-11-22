package ar.edu.unlam.pb2.criaturas;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

public class ReportesConsejoTest {

	@Test
	public void queSePuedanListarTodasLasCriaturasDeTodosLosMaestros() {
		Maestro m1 = new Maestro("seba", 20, AfinidadElemental.AGUA);
		Maestro m2 = new Maestro("ori", 15, AfinidadElemental.FUEGO);
		Criatura c1 = new Domestica("pepe", 80, AfinidadElemental.AGUA);
		Criatura c2 = new Salvaje("juan", 120, AfinidadElemental.TIERRA);
		Criatura c3 = new Ancestral("lucho", 150, AfinidadElemental.FUEGO, EstadoEmocional.TRANQUILA);
		m1.agregarCriatura(c1);
		m1.agregarCriatura(c2);
		m2.agregarCriatura(c3);
		List<Maestro> maestros = new ArrayList<>();
		maestros.add(m1);
		maestros.add(m2);
		ReportesConsejo reportes = new ReportesConsejo(maestros);
		List<Criatura> criaturas = reportes.listarTodasLasCriaturas();
		assertEquals(3, criaturas.size());
		assertTrue(criaturas.contains(c1));
		assertTrue(criaturas.contains(c2));
		assertTrue(criaturas.contains(c3));
	}

	@Test
	public void queSePuedaObtenerLaCriaturaConMayorEnergiaTotal() {
		Maestro m = new Maestro("seba", 20, AfinidadElemental.AGUA);
		Criatura c1 = new Domestica("pepe", 80, AfinidadElemental.AGUA);
		Criatura c2 = new Salvaje("juan", 120, AfinidadElemental.TIERRA);
		Criatura c3 = new Ancestral("lucho", 150, AfinidadElemental.FUEGO, EstadoEmocional.TRANQUILA);
		m.agregarCriatura(c1);
		m.agregarCriatura(c2);
		m.agregarCriatura(c3);
		List<Maestro> maestros = new ArrayList<>();
		maestros.add(m);
		ReportesConsejo repo = new ReportesConsejo(maestros);
		Criatura mayor = repo.obtenerCriaturaConMayorEnergia();
		assertEquals(c3, mayor);
	}
	
	@Test
	public void queSePuedaObtenerLDeterminarQueMaestroTieneMasCriaturasTransformadas() {
		Maestro m = new Maestro("seba", 20, AfinidadElemental.AGUA);
		Maestro m2 = new Maestro("ori", 15, AfinidadElemental.FUEGO);
		Criatura c1 = new Domestica("pepe", 80, AfinidadElemental.AGUA);
		Criatura c2 = new Salvaje("juan", 120, AfinidadElemental.TIERRA);
		Criatura c3 = new Ancestral("lucho", 150, AfinidadElemental.FUEGO, EstadoEmocional.TRANQUILA);
		m.agregarCriatura(c1);
		m.agregarCriatura(c2);
		m2.agregarCriatura(c3);
	    Transformacion t1 = new VinculoTerrestre(c1);
	    Transformacion t2 = new VinculoTerrestre(c2);
	    m.transformarCriatura("pepe", t1);
	    m.transformarCriatura("juan", t1);
		List<Maestro> maestros = new ArrayList<>();
		maestros.add(m);
		ReportesConsejo repo = new ReportesConsejo(maestros);
		Maestro mayor = repo.maestroConMasCriaturasTransformadas();
	    assertEquals(m, mayor);
	}
	
	@Test
	public void queSeObtengaLaListaDeCriaturasPorAfinidad(){
	 
	    Maestro m = new Maestro("Seba", 25, AfinidadElemental.AGUA);
	 
	    m.agregarCriatura(new Domestica("pepe", 100, AfinidadElemental.AGUA));
	    m.agregarCriatura(new Salvaje("lucho", 90, AfinidadElemental.AGUA));
	    m.agregarCriatura(new Domestica("juan", 120, AfinidadElemental.FUEGO));
	    m.agregarCriatura(new Salvaje("marcos", 130, AfinidadElemental.TIERRA));
		List<Maestro> maestros = new ArrayList<>();
		maestros.add(m);
		ReportesConsejo repo = new ReportesConsejo(maestros);
	 
	    HashMap<AfinidadElemental, Integer> mapaPorAfinidad = repo.listarCriaturasPorAfinidad();
	 
	    assertEquals(Integer.valueOf(2), mapaPorAfinidad.get(AfinidadElemental.AGUA));
	    assertEquals(Integer.valueOf(1), mapaPorAfinidad.get(AfinidadElemental.FUEGO));
	    assertEquals(Integer.valueOf(1), mapaPorAfinidad.get(AfinidadElemental.TIERRA));
	}

}
