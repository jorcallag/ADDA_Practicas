package PI3AEj4;

import java.util.Set;
import java.io.PrintWriter;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.alg.interfaces.SpanningTreeAlgorithm;
import org.jgrapht.alg.interfaces.SpanningTreeAlgorithm.SpanningTree;
import org.jgrapht.alg.spanning.KruskalMinimumSpanningTree;
import org.jgrapht.alg.vertexcover.GreedyVCImpl;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.io.DOTExporter;
import org.jgrapht.io.IntegerComponentNameProvider;

import Datos.Cable;
import Datos.Camara;
import us.lsi.common.Files2;
import us.lsi.graphcolors.GraphColors;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.GraphsReader;
import us.lsi.graphs.views.SubGraphView;

public class Ejercicio4 {

	public static void main(String[] args) {

		//Datos Entrada 1
		System.out.println("Datos de entrada 1:");

		//Lectura fichero
		SimpleWeightedGraph<Camara, Cable> grafo1 = GraphsReader.newGraph
				("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI3A\\FicherosEntrada\\PI3Ej4DatosEntrada1.txt", 
						Camara::ofFormat, Cable::ofFormat, Graphs2::simpleWeightedGraph, Cable::getM);

		//Apartado a)
		GreedyVCImpl<Camara, Cable> vCover1 = new GreedyVCImpl<>(grafo1);
		Set<Camara> vSet1 = vCover1.getVertexCover();
		System.out.println("Las camaras deben colocarse en los cruces: " + vCover1.getVertexCover());

		//Apartado b) 
		Graph<Camara, Cable> subGrafo1 = Graphs2.subGraph(grafo1, v -> vSet1.contains(v) , e -> vSet1.contains(e.getSource()) && vSet1.contains(e.getTarget()),
				Graphs2::simpleWeightedGraph);
		subGrafo1.edgeSet().stream().forEach(x -> subGrafo1.setEdgeWeight(x, grafo1.getEdgeWeight(x)));
		SpanningTreeAlgorithm<Cable> ast1 = new KruskalMinimumSpanningTree<>(subGrafo1);
		Set<Cable> r1 = ast1.getSpanningTree().getEdges();
		ConnectivityInspector<Camara, Cable> c1 = new ConnectivityInspector<Camara, Cable>(subGrafo1);
		List<Set<Camara>> cc1 = c1.connectedSets();
		System.out.println("El numero de equipos necesarios es: " + cc1.size());
		Double s1 = 0.;
		for (Cable c : r1) {
			s1 = s1 + c.getM();
		}
		System.out.println("Los metros de cables necesarios son: " + String.format("%.1f",s1));

		//Apartado c) 
		DOTExporter<Camara, Cable> de1 = new DOTExporter<Camara, Cable>(new IntegerComponentNameProvider<>(),
				x -> x.getNombre(), 
				x -> String.format("%.2f",x.getM()),
				e -> GraphColors.getColorIf(7, e, x -> vSet1.contains(x)),
				x -> GraphColors.getColorIf(7, x, e -> r1.contains(e))
				);	
		PrintWriter f1 = Files2.getWriter("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI3A\\FicherosSalidaEj4\\grafo1.gv");
		de1.exportGraph(grafo1, f1);


		//Datos Entrada 2
		System.out.println("\nDatos de entrada 2:");

		//Lectura fichero
		SimpleWeightedGraph<Camara, Cable> grafo2 = GraphsReader.newGraph
				("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI3A\\FicherosEntrada\\PI3Ej4DatosEntrada2.txt", 
						Camara::ofFormat, Cable::ofFormat, Graphs2::simpleWeightedGraph, Cable::getM);
		//Apartado a)		
		GreedyVCImpl<Camara, Cable> vCover2 = new GreedyVCImpl<>(grafo2);
		Set<Camara> vSet2 = vCover2.getVertexCover();
		System.out.println("Las camaras deben colocarse en los cruces: " + vCover2.getVertexCover());

		//Apartado b)
		Graph<Camara, Cable> subGrafo2 = Graphs2.subGraph(grafo2, v -> vSet2.contains(v) , e -> vSet2.contains(e.getSource()) && vSet2.contains(e.getTarget()),
				Graphs2::simpleWeightedGraph);
		subGrafo2.edgeSet().stream().forEach(x -> subGrafo2.setEdgeWeight(x, grafo2.getEdgeWeight(x)));
		SpanningTreeAlgorithm<Cable> ast2 = new KruskalMinimumSpanningTree<>(subGrafo2);
		Set<Cable> r2 = ast2.getSpanningTree().getEdges();
		ConnectivityInspector<Camara, Cable> c2 = new ConnectivityInspector<Camara, Cable>(subGrafo2);
		List<Set<Camara>> cc2 = c2.connectedSets();
		System.out.println("El numero de equipos necesarios es: " + cc2.size());
		Double s2 = 0.;
		for (Cable c : r2) {
			s2 = s2 + c.getM();
		}
		System.out.println("Los metros de cables necesarios son: " + String.format("%.1f",s2));

		//Apartado c)
		DOTExporter<Camara, Cable> de2 = new DOTExporter<Camara, Cable>(new IntegerComponentNameProvider<>(),
				x -> x.getNombre(), 
				x -> String.format("%.2f",x.getM()),
				e -> GraphColors.getColorIf(7, e, x -> vSet2.contains(x)),
				x -> GraphColors.getColorIf(7, x, e -> r2.contains(e))
				);	
		PrintWriter f2 = Files2.getWriter("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI3A\\FicherosSalidaEj4\\grafo2.gv");
		de2.exportGraph(grafo2, f2);

		//Datos Entrada 3
		System.out.println("\nDatos de entrada 3:");

		//Lectura fichero
		SimpleWeightedGraph<Camara, Cable> grafo3 = GraphsReader.newGraph
				("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI3A\\FicherosEntrada\\PI3Ej4DatosEntrada3.txt", 
						Camara::ofFormat, Cable::ofFormat, Graphs2::simpleWeightedGraph, Cable::getM);

		//Apartado a)		
		GreedyVCImpl<Camara, Cable> vCover3 = new GreedyVCImpl<>(grafo3);
		Set<Camara> vSet3 = vCover3.getVertexCover();
		System.out.println("Las camaras deben colocarse en los cruces: " + vCover3.getVertexCover());

		//Apartado b)	
		Graph<Camara, Cable> subGrafo3 = Graphs2.subGraph(grafo3, v -> vSet3.contains(v) , e -> vSet3.contains(e.getSource()) && vSet3.contains(e.getTarget()),
				Graphs2::simpleWeightedGraph);
		subGrafo3.edgeSet().stream().forEach(x -> subGrafo3.setEdgeWeight(x, grafo3.getEdgeWeight(x)));
		SpanningTreeAlgorithm<Cable> ast3 = new KruskalMinimumSpanningTree<>(subGrafo3);
		Set<Cable> r3 = ast3.getSpanningTree().getEdges();
		ConnectivityInspector<Camara, Cable> c3 = new ConnectivityInspector<Camara, Cable>(subGrafo3);
		List<Set<Camara>> cc3 = c3.connectedSets();
		System.out.println("El numero de equipos necesarios es: " + cc3.size());
		Double s3 = 0.;
		for (Cable c : r3) {
			s3 = s3 + c.getM();
		}
		System.out.println("Los metros de cables necesarios son: " + String.format("%.1f",s3));

		//Apartado c)
		DOTExporter<Camara, Cable> de3 = new DOTExporter<Camara, Cable>(new IntegerComponentNameProvider<>(),
				x -> x.getNombre(), 
				x -> String.format("%.2f",x.getM()),
				e -> GraphColors.getColorIf(7, e, x -> vSet3.contains(x)),
				x -> GraphColors.getColorIf(7, x, e -> r3.contains(e))
				);	
		PrintWriter f3 = Files2.getWriter("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI3A\\FicherosSalidaEj4\\grafo3.gv");
		de3.exportGraph(grafo3, f3);
		
	}

}
