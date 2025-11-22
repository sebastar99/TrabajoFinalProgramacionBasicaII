package ar.edu.unlam.pb2.criaturas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReportesConsejo {

	private final List<Maestro> maestros;

	public ReportesConsejo(List<Maestro> maestros) {
		this.maestros = maestros;
	}

	public List<Criatura> listarTodasLasCriaturas() {
		List<Criatura> listaCompleta = new ArrayList<>();
		for (Maestro m : maestros) {
			listaCompleta.addAll(m.getCriaturas().values());
		}

		return listaCompleta;
	}

	public Criatura obtenerCriaturaConMayorEnergia() {
		Criatura cMayorEnergia = null;

		for (Maestro m : maestros) {
			for (Criatura c : m.getCriaturas().values()) {
				if (cMayorEnergia == null || c.getEnergia() > cMayorEnergia.getEnergia()) {
					cMayorEnergia = c;
				}
			}
		}
		return cMayorEnergia;
	}

	private boolean estaTransformada(Criatura c) {
		return c instanceof Transformacion;
	}

	public Maestro maestroConMasCriaturasTransformadas() {
		Maestro mejor = null;
		int maxCant = 0;

		for (Maestro m : maestros) {
			int cant = 0;
			for (Criatura c : m.getCriaturas().values()) {
				if (estaTransformada(c)) {
					cant++;
				}
			}
			if (cant > maxCant) {
				maxCant = cant;
				mejor = m;
			}
		}
		return mejor;
	}

	public HashMap<AfinidadElemental, Integer> listarCriaturasPorAfinidad() {
		HashMap<AfinidadElemental, Integer> mapa = new HashMap<>();

		for (Criatura c : listarTodasLasCriaturas()) {
			AfinidadElemental afinidad = c.getAfinidad();

			if (mapa.containsKey(afinidad)) {
				mapa.put(afinidad, mapa.get(afinidad) + 1);
			} else {
				mapa.put(afinidad, 1);
			}
		}

		return mapa;
	}

}
