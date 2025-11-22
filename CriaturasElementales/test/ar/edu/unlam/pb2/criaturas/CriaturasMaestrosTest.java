package ar.edu.unlam.pb2.criaturas;

import static org.junit.Assert.*;

import org.junit.Test;

public class CriaturasMaestrosTest {

	@Test
	public void queSePuedaCrearUnMaestro() throws NivelDeMaestriaSuperadoException {
		Maestro maestro = new Maestro("Seba", 25, AfinidadElemental.AGUA);
		assertNotNull(maestro);
	}

	@Test(expected = NivelDeMaestriaSuperadoException.class)
	public void queNoSePuedaCrearUnMaestroQueSuperaElNivelDeMaestria()
			throws Exception {
		Maestro maestro = new Maestro("Seba", 60, AfinidadElemental.AGUA);
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

	@Test(expected = NivelDeEnergiaSuperadoException.class)
	public void queNoSePuedanAsignarCriaturasAlMaestro() {
		Maestro maestro = new Maestro("Seba", 25, AfinidadElemental.AGUA);
		Criatura criatura = new Salvaje("pepe", 230, AfinidadElemental.FUEGO);
	}

	@Test
	public void queSePuedanEntrenarLasCriaturas()
			throws NivelDeMaestriaSuperadoException, NivelDeEnergiaSuperadoException, EnergiaSuperadaException {
		Maestro maestro = new Maestro("Seba", 25, AfinidadElemental.AGUA);
		Criatura criatura = new Salvaje("pepe", 10, AfinidadElemental.FUEGO);
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

	@Test(expected = EnergiaSuperadaException.class)
	public void queSePuedanEntrenarLasCriaturasLanzandoExceptionEnergiaSuperada()
			throws NivelDeMaestriaSuperadoException, NivelDeEnergiaSuperadoException, EnergiaSuperadaException {
		Maestro maestro = new Maestro("Seba", 25, AfinidadElemental.AGUA);
		Criatura criatura = new Salvaje("pepe", 199, AfinidadElemental.FUEGO);
		Criatura criatura2 = new Domestica("juan", 150, AfinidadElemental.FUEGO);
		Criatura criatura3 = new Ancestral("lucho", 150, AfinidadElemental.FUEGO, EstadoEmocional.TRANQUILA);
		maestro.agregarCriatura(criatura);
		Integer energiaInicialSalvaje = criatura.getEnergia();
		maestro.entrenarCriatura("pepe");
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
