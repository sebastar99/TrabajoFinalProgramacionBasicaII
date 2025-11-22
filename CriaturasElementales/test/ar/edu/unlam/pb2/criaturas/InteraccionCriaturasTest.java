package ar.edu.unlam.pb2.criaturas;

import static org.junit.Assert.*;

import org.junit.Test;

public class InteraccionCriaturasTest {

	@Test
	public void quePuedanInteractuarDosCriaturasQueCompartanAfinidadGanandoDiezDeEnergia()
			throws NivelDeEnergiaSuperadoException {
		Criatura criatura = new Salvaje("pepe", 140, AfinidadElemental.FUEGO);
		Criatura criatura2 = new Domestica("lucho", 130, AfinidadElemental.FUEGO);
		criatura.interactuar(criatura2);
		assertEquals(Integer.valueOf(150), criatura.getEnergia());
		assertEquals(Integer.valueOf(140), criatura2.getEnergia());
	}

	@Test
	public void quePuedanInteractuarDosCriaturasConAfinidadOpuestaVolviendoseInestables()
			throws NivelDeEnergiaSuperadoException {
		Criatura criatura = new Salvaje("pepe", 140, AfinidadElemental.FUEGO);
		Criatura criatura2 = new Domestica("lucho", 130, AfinidadElemental.AGUA);
		criatura.interactuar(criatura2);
		assertEquals(EstadoEmocional.INESTABLE, criatura.getEstado());
		assertEquals(EstadoEmocional.INESTABLE, criatura2.getEstado());
	}

	@Test
	public void quePuedanInteractuarDosCriaturasConDistintaAfinidadOpuestaVolviendoseInestables()
			throws NivelDeEnergiaSuperadoException {
		Criatura criatura = new Salvaje("pepe", 140, AfinidadElemental.TIERRA);
		Criatura criatura2 = new Domestica("lucho", 130, AfinidadElemental.AIRE);
		criatura.interactuar(criatura2);
		assertEquals(EstadoEmocional.INESTABLE, criatura.getEstado());
		assertEquals(EstadoEmocional.INESTABLE, criatura2.getEstado());
	}

	@Test
	public void quePuedanInteractuarDosCriaturasPeroLaAncestralDomineLaInteraccion()
			throws NivelDeEnergiaSuperadoException {
		Criatura criatura = new Ancestral("lucho", 120, AfinidadElemental.AGUA, EstadoEmocional.TRANQUILA);
		Criatura criatura2 = new Salvaje("pepe", 80, AfinidadElemental.FUEGO);
		criatura.interactuar(criatura2);
		assertEquals(Integer.valueOf(140), criatura.getEnergia());
		assertEquals(Integer.valueOf(65), criatura2.getEnergia());
	}
	
	@Test
	public void quePuedanInteractuarDosCriaturasPeroLaAncestralPorParametroDomineLaInteraccion()
			throws NivelDeEnergiaSuperadoException {
		Criatura criatura1 = new Ancestral("lucho", 120, AfinidadElemental.AGUA, EstadoEmocional.TRANQUILA);
		Criatura criatura2 = new Salvaje("pepe", 80, AfinidadElemental.FUEGO);
		criatura2.interactuar(criatura1);
		assertEquals(Integer.valueOf(140), criatura1.getEnergia());
		assertEquals(Integer.valueOf(65), criatura2.getEnergia());
	}
}
