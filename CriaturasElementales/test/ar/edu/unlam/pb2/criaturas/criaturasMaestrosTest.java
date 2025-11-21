package ar.edu.unlam.pb2.criaturas;

import static org.junit.Assert.*;

import org.junit.Test;

public class criaturasMaestrosTest {

	@Test
	public void queSePuedaCrearUnMaestro() throws NivelDeMaestriaSuperadoException {
		Maestro maestro = new Maestro("Seba", 25, AfinidadElemental.AGUA);
		assertNotNull(maestro);
	}

	@Test
	public void queSePuedanAsignarCriaturasAlMaestro()
			throws NivelDeMaestriaSuperadoException, NivelDeEnergiaSuperadoException {
		Maestro maestro = new Maestro("Seba", 25, AfinidadElemental.AGUA);
		Criatura criatura = new Salvaje("pepe", 150, AfinidadElemental.FUEGO);
		Criatura criatura2 = new Domestica("juan", 150, AfinidadElemental.FUEGO);
		Criatura criatura3 = new Ancestral("lucho", 150, AfinidadElemental.FUEGO, EstadoEmocional.TRANQUILA);
		maestro.agregarCriatura(criatura);
		maestro.agregarCriatura(criatura2);
		maestro.agregarCriatura(criatura3);
		assertEquals(Integer.valueOf(3), maestro.cantCriaturas());
	}

	@Test
	public void queSePuedanEntrenarLasCriaturas()
			throws NivelDeMaestriaSuperadoException, NivelDeEnergiaSuperadoException, EnergiaSuperadaException {
		Maestro maestro = new Maestro("Seba", 25, AfinidadElemental.AGUA);
		Criatura criatura = new Salvaje("pepe", 150, AfinidadElemental.FUEGO);
		Criatura criatura2 = new Domestica("juan", 150, AfinidadElemental.FUEGO);
		Criatura criatura3 = new Ancestral("lucho", 150, AfinidadElemental.FUEGO, EstadoEmocional.TRANQUILA);
		maestro.agregarCriatura(criatura);
		maestro.agregarCriatura(criatura2);
		maestro.agregarCriatura(criatura3);
		Integer energiaInicialSalvaje = criatura.getEnergia();
		Integer energiaInicialDomestica = criatura2.getEnergia();
		Integer energiaInicialAncestral = criatura3.getEnergia();

		maestro.entrenarCriatura("pepe");
		maestro.entrenarCriatura("juan");
		maestro.entrenarCriatura("lucho");

		assertTrue(criatura.getEnergia() > energiaInicialSalvaje);
		assertTrue(criatura.getEnergia() <= 200);

		assertEquals(Integer.valueOf(energiaInicialDomestica + 1), criatura2.getEnergia());
		assertEquals(EstadoEmocional.TRANQUILA, criatura2.getEstado());

		assertTrue(criatura3.getEnergia() >= energiaInicialAncestral);
		assertTrue(criatura3.getEnergia() >= 100);
	}

	@Test
	public void queSePuedanPacificarLasCriaturasInestables()
			throws NivelDeMaestriaSuperadoException, NivelDeEnergiaSuperadoException, EnergiaSuperadaException {
		Maestro maestro = new Maestro("Seba", 25, AfinidadElemental.AGUA);
		Criatura criatura = new Salvaje("pepe", 150, AfinidadElemental.FUEGO);
		Criatura criatura2 = new Domestica("juan", 150, AfinidadElemental.FUEGO);
		Criatura criatura3 = new Ancestral("lucho", 150, AfinidadElemental.FUEGO, EstadoEmocional.TRANQUILA);
		maestro.agregarCriatura(criatura);
		maestro.agregarCriatura(criatura2);
		maestro.agregarCriatura(criatura3);
		maestro.pacificarCriatura("pepe");
		maestro.pacificarCriatura("juan");
		maestro.pacificarCriatura("lucho");
		EstadoEmocional estadoActual = criatura.getEstado();
		EstadoEmocional estadoActual2 = criatura2.getEstado();
		EstadoEmocional estadoActual3 = criatura3.getEstado();
		
		
		assertEquals(EstadoEmocional.TRANQUILA, estadoActual);
		assertEquals(EstadoEmocional.TRANQUILA, estadoActual2);
		assertEquals(EstadoEmocional.TRANQUILA, estadoActual3);

	}

}
