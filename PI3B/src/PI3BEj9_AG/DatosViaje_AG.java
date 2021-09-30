package PI3BEj9_AG;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;

import us.lsi.ag.HelpFitnessAg;
import us.lsi.ag.SeqNomalChromosome;
import us.lsi.ag.SeqNormalProblemAG;
import us.lsi.grafos.datos.Ciudad;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.GraphsReader;
import us.lsi.grafos.datos.Carretera;

public class DatosViaje_AG implements SeqNormalProblemAG<List<Integer>>{

	public static Graph<Ciudad, Carretera> GrafoDato;
	public static Ciudad Source;
	public static Ciudad Target;
	public static List<Ciudad> listaCiudades;
	
	public DatosViaje_AG (String file, String file2) {
		GrafoDato = GraphsReader.newGraph(file, Ciudad::ofFormat, Carretera::ofFormat, Graphs2::simpleWeightedGraph, Carretera::getKm);
		String[] a = file2.split(",");
		Source = Ciudad.ofName(a[0]);
		Target = Ciudad.ofName(a[1]);
		listaCiudades = listaVertices(GrafoDato);
		listaCiudades.remove(Source);
		listaCiudades.remove(Target);
	}
	
	public static List<Ciudad> listaVertices(Graph<Ciudad, Carretera> grafoDato2){
		Set<Ciudad> conjuntoVertices = grafoDato2.vertexSet();
		List<Ciudad> listaVertices = new ArrayList<Ciudad>();
		listaVertices.addAll(conjuntoVertices);
		return listaVertices;
	}
	
	public static List<Ciudad> listaCiudadesCromosoma(List<Integer> ls){
		Ciudad x;
		List<Ciudad> lsCiudadesCromosoma = new ArrayList<Ciudad>();
		for(int i = 0; i<ls.size(); i++) {
			x = listaCiudades.get(ls.get(i));
			lsCiudadesCromosoma.add(x);
		}
		return lsCiudadesCromosoma;
	}
	
	public static List<Ciudad> listaCiudadesCromosomaConOD(List<Ciudad> ls){
		List<Ciudad> lsCiudades = new ArrayList<Ciudad>();
		listaCiudades.add(Source);
		listaCiudades.addAll(ls);
		listaCiudades.add(Target);
		return lsCiudades;
	}
	
	public static Integer restriccionesOrigenDestino(List<Ciudad> ls) {
		Integer res = 0;
		for(int i = 0; i<ls.size()-1; i++) {
			for(int y = i+1; y<i+2; y++) {
				if(!GrafoDato.containsEdge(ls.get(i), ls.get(y))){
					res++;
				}
			}
		}
		return res;
	}
	
	public static Integer restriccionesPoblacion(List<Ciudad> ls) {
		Integer res = 0;
		if(ls.stream().anyMatch(r1 -> r1.getHabitantes() < 50000) == false) {
			res = res + 1;
		}
		if(ls.stream().anyMatch(r2 -> r2.getHabitantes() > 50000 && r2.getHabitantes() < 100000) == false) {
			res = res + 1;
		}
		if(ls.stream().anyMatch(r3 -> r3.getHabitantes() > 100000) == false) {
			res = res + 1;
		}
		return res;
	}

	@Override
	public Integer getObjectsNumber() {
		return listaCiudades.size();
	}

	@Override
	public Double fitnessFunction(SeqNomalChromosome cr) {
		Double distancia = 0.0;
		Integer res = 0;
		List<Integer> ls = cr.decode();
		List<Ciudad> lsCiudadesCromosoma = listaCiudadesCromosoma(ls);
		List<Ciudad> lsCiudadesCromosomaConOD = listaCiudadesCromosomaConOD(lsCiudadesCromosoma);
		res = res + restriccionesOrigenDestino(lsCiudadesCromosomaConOD);
		res = res + restriccionesPoblacion(lsCiudadesCromosoma);
		distancia = HelpFitnessAg.distanceToSimpleClosedPathVertices(GrafoDato, lsCiudadesCromosomaConOD);
		Integer penalizacion = - Math.abs((res)*1000);
		
		return (double) -distancia + penalizacion;
	}

	@Override
	public List<Integer> getSolucion(SeqNomalChromosome cr) {
		return cr.decode();
	}
	
	public static Double distanciaOD (List<Ciudad> ls) {
		Double res = 0.0;
		for(int i = 0; i<ls.size()-1; i++) {
			Ciudad x1 = ls.get(i);
			Ciudad x2 = ls.get(i+1);
			Double distancia = GrafoDato.getEdge(x1, x2).getKm();
			res = res + distancia;
		}
		return res;
	}
	
}
