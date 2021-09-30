package PI3BEj10_RF;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jgrapht.graph.SimpleDirectedGraph;
import org.jgrapht.graph.SimpleWeightedGraph;

import us.lsi.common.Files2;
import us.lsi.flowgraph.FlowGraph;
import us.lsi.flowgraph.FlowGraphSolution;
import us.lsi.flowgraph.FlowGraph.TipoDeOptimizacion;
import us.lsi.grafos.datos.Carretera;
import us.lsi.grafos.datos.Ciudad;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.GraphsReader;
import us.lsi.pli.AlgoritmoPLI;
import us.lsi.pli.SolutionPLI;


public class Ejercicio10_RF {

	public static void main(String[] args) {

		System.out.println("Grafo Andalucia: ");
		
		SimpleWeightedGraph<Ciudad, Carretera> grafoAndalucia = GraphsReader.newGraph
				("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI3B\\ficheros\\PI3Ej10DatosEntrada_andalucia.txt", 
						Ciudad::ofFormat, Carretera::ofFormat, Graphs2::simpleWeightedGraph, Carretera::getKm);

		SimpleDirectedGraph<Ciudad, Carretera> grafoAndaluciaDirigido = 
				Graphs2.toDirectedWeightedGraph(grafoAndalucia, Carretera::reverse);
	
		FlowGraph.allInteger = true;
		creaFichero("ficheros/redFlujoGrafoAndalucia.txt", grafoAndaluciaDirigido);
		
		FlowGraph fgAndalucia = FlowGraph
				.newGraph("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI3B\\ficheros\\redFlujoGrafoAndalucia.txt", TipoDeOptimizacion.Max);

		String constraintsAndalucia = fgAndalucia.getConstraints();

		Files2.toFile(constraintsAndalucia, "ficheros/redFlujoGrafoAndaluciaConstraints.txt");

		SolutionPLI sAndalucia = AlgoritmoPLI.getSolution(fgAndalucia.getConstraints());
		FlowGraphSolution fsAndalucia = FlowGraphSolution.create(fgAndalucia, sAndalucia);
		fsAndalucia.exportToDot("ficheros/redFlujoGrafoAndaluciaConstraints.gv");

		FlowGraphSolution fs2Andalucia = FlowGraphSolution.createOnlySaturated(fsAndalucia);
		fsAndalucia.getGraph().exportToDot("ficheros/redFlujoGrafoAndaluciaGrafo.gv");
		fs2Andalucia.exportToDot("ficheros/redFlujoGrafoAndaluciaSoluciones.gv");

		System.out.println("Caminos disjuntos: " + fsAndalucia.getGoal());
		System.out.println(fsAndalucia.getFlowVertices());
		System.out.println(fsAndalucia.getFlowEdges());
		
		System.out.println();
		
		System.out.println("Grafo Castilla La Mancha: ");
		
		SimpleWeightedGraph<Ciudad, Carretera> grafoCastillaLaMancha = GraphsReader.newGraph
				("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI3B\\ficheros\\PI3Ej10DatosEntrada_castillalamancha.txt", 
						Ciudad::ofFormat, Carretera::ofFormat, Graphs2::simpleWeightedGraph, Carretera::getKm);

		SimpleDirectedGraph<Ciudad, Carretera> grafoCastillaLaManchaDirigido = 
				Graphs2.toDirectedWeightedGraph(grafoCastillaLaMancha, Carretera::reverse);
	
		FlowGraph.allInteger = true;
		creaFichero("ficheros/redFlujoGrafoCastillaLaMancha.txt", grafoCastillaLaManchaDirigido);
		
		FlowGraph fgCastillaLaMancha = FlowGraph
				.newGraph("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI3B\\ficheros\\redFlujoGrafoCastillaLaMancha.txt", 
						TipoDeOptimizacion.Max);

		String constraintsCastillaLaMancha = fgCastillaLaMancha.getConstraints();

		Files2.toFile(constraintsCastillaLaMancha, "ficheros/redFlujoGrafoCastillaLaManchaConstraints.txt");

		SolutionPLI sCastillaLaMancha = AlgoritmoPLI.getSolution(fgCastillaLaMancha.getConstraints());
		FlowGraphSolution fsCastillaLaMancha = FlowGraphSolution.create(fgCastillaLaMancha, sCastillaLaMancha);
		fsCastillaLaMancha.exportToDot("ficheros/redFlujoGrafoCastillaLaManchaConstraints.gv");

		FlowGraphSolution fs2CastillaLaMancha = FlowGraphSolution.createOnlySaturated(fsCastillaLaMancha);
		fsCastillaLaMancha.getGraph().exportToDot("ficheros/redFlujoGrafoCastillaLaManchaGrafo.gv");
		fs2CastillaLaMancha.exportToDot("ficheros/redFlujoGrafoCastillaLaManchaSoluciones.gv");

		System.out.println("Caminos disjuntos: " + fsCastillaLaMancha.getGoal());
		System.out.println(fsCastillaLaMancha.getFlowVertices());
		System.out.println(fsCastillaLaMancha.getFlowEdges());

	}

	public static void creaFichero(String file, SimpleDirectedGraph<Ciudad, Carretera> grafo) {

		PrintWriter f = Files2.getWriter(file);
		List<Ciudad> lsV = listaVertices(grafo);
		List<Carretera> lsA = listaAristas(grafo);
		
		f.println("#VERTEX#");
		
		f.println(lsV.get(0) + ",Source,0.0,inf,0.0");
		for(int i = 2; i<lsV.size(); i++) {
			f.println(lsV.get(i) + ",Intermediate,0.0,inf,0.0");
		}
		f.println(lsV.get(1) + ",Sink,0.0,inf,1.0");
		
		f.println("#EDGE#");
		for (int i = 0; i < lsA.size(); i++) {
			if(!(lsA.get(i).getTarget() == lsV.get(0)) && !(lsA.get(i).getSource() == lsV.get(1))) {
				f.println(lsA.get(i).getSource() + "," + lsA.get(i).getTarget() + ",0.0,1.0,0.0");
			}
		}
		f.close();
	}
	
	public static List<Ciudad> listaVertices(SimpleDirectedGraph<Ciudad, Carretera> grafo){
		Set<Ciudad> conjuntoVertices = grafo.vertexSet();
		List<Ciudad> listaVertices = new ArrayList<Ciudad>();
		listaVertices.addAll(conjuntoVertices);
		return listaVertices;
	}

	public static List<Carretera> listaAristas(SimpleDirectedGraph<Ciudad, Carretera> grafo){
		Set<Carretera> conjuntoAristas = grafo.edgeSet();
		List<Carretera> listaArista = new ArrayList<Carretera>();
		listaArista.addAll(conjuntoAristas);
		return listaArista;
	}
}

