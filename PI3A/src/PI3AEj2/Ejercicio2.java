package PI3AEj2;

import java.util.Set;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.alg.color.GreedyColoring;
import org.jgrapht.alg.interfaces.VertexColoringAlgorithm;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import us.lsi.common.Files2;

public class Ejercicio2 extends Files2{
	
	public static void main(String[] args) {
		
		//Lectura del fichero
		Graph<Integer, DefaultEdge> grafo = new SimpleGraph<Integer, DefaultEdge>(DefaultEdge.class);
		java.util.List<String> ls = Files2.getLines("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI3A\\FicherosEntrada\\PI3Ej2DatosEntrada.txt");
		Integer n = Integer.parseInt(ls.get(0));
		for(int i = 1; i<n+1; i++) {
		grafo.addVertex(i);
		}
		for(int j = 1; j<ls.size(); j++) {
			String edge = ls.get(j);
			String[] s = edge.split(",");
			Integer a = Integer.parseInt(s[0]);
			Integer b = Integer.parseInt(s[1]);
			grafo.addEdge(a, b);
		}
		
		//Apartado a)
		
		VertexColoringAlgorithm<Integer> vcl = new GreedyColoring<Integer, DefaultEdge>(grafo);
		System.out.println("El numero de mesas necesarias es " + vcl.getColoring().getNumberColors());
		System.out.println("");
		
		//Apartado b)
		
		List<Set<Integer>> ls1 = vcl.getColoring().getColorClasses();
		for(int y = 1; y<ls1.size()+1; y++) {
			System.out.println("Mesa " + y + ": " + "tiene " + ls1.get(y-1).size() + " comensales: " + ls1.get(y-1));  
		}

	}

}
