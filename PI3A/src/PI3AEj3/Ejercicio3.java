package PI3AEj3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.jgrapht.Graph;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.SimpleGraph;

import Datos.Relacion;
import Datos.Usuario;
import us.lsi.common.Files2;
import us.lsi.graphs.GraphsReader;

public class Ejercicio3 {

	public static void main(String[] args) {

		//Lectura de fichero
		Graph<Usuario, Relacion> grafo = GraphsReader.newGraph("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI3A\\FicherosEntrada\\PI3Ej3DatosEntradaGrafo.txt",
				Usuario::ofFormat, Relacion::ofFormat, () -> new SimpleGraph<Usuario, Relacion>((u1, u2) -> Relacion.ofVertex(u1, u2)));

		//Apartado a)
		List<Set<Usuario>> cc1 = apartadoA(grafo);
		System.out.println("Existen " + cc1.size() + " grupos. Su composicion es: ");
		for(int i = 1; i<cc1.size()+1; i++) {
			System.out.println("Grupo " + i + " (" + cc1.get(i-1).size() + " usuarios):");
			System.out.println(cc1.get(i-1));
		}
		System.out.println("");
		
		//Apartado b) 
		List<String> fichero1 = Files2.getLines("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI3A\\FicherosEntrada\\PI3Ej3DatosEntradaB.txt");
		for(int i = 0; i<fichero1.size(); i++) {
			String[] u = fichero1.get(i).split(",");
			Usuario e1 = Usuario.ofName(u[0]);
			Usuario e2 = Usuario.ofName(u[1]);
			Usuario u1 = grafo.vertexSet().stream().filter(x -> x.equals(e1)).findAny().get();
			Usuario u2 = grafo.vertexSet().stream().filter(x -> x.equals(e2)).findAny().get();
			Integer d2 = apartadoB(grafo, u1, u2, cc1);
			System.out.println("El grado de distanciamiento entre " + u1 + " y " + u2 + " es: " + d2);
		}
		System.out.println("");
		
		//Apartado c)
		List<String> fichero2 = Files2.getLines("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI3A\\FicherosEntrada\\PI3Ej3DatosEntradaC.txt");
		for(int i = 0; i<fichero2.size(); i++) {
			Usuario e1 = Usuario.ofName(fichero2.get(i));
			Usuario u1 = grafo.vertexSet().stream().filter(x -> x.equals(e1)).findAny().get();
			Set<Usuario> c = apartadoC(grafo, u1, cc1);
			System.out.println("Los usuarios compatibles con " + u1 + " son: " + c);
		}
		
	}
	
	//Apartado a)
	public static List<Set<Usuario>> apartadoA(Graph<Usuario, Relacion> grafo){
		ConnectivityInspector<Usuario, Relacion> c1 = new ConnectivityInspector<Usuario, Relacion>(grafo);
		List<Set<Usuario>> cc1 = c1.connectedSets();
		return cc1;
	}
	
	//Apartado b) 
	public static Integer apartadoB(Graph<Usuario, Relacion> grafo, Usuario u1, Usuario u2, List<Set<Usuario>> cc1) {
		Integer d2;
		boolean b = false;
		for(int j = 0; j<cc1.size();j++) {
			if(cc1.get(j).contains(u1) && cc1.get(j).contains(u2)){
				b = true;
			}
		}
		if(b) {
			DijkstraShortestPath<Usuario, Relacion> d1 = new DijkstraShortestPath<Usuario, Relacion>(grafo);
			d2 = d1.getPath(u1, u2).getLength()-1;
		}else {
			d2 = -1;
		}
		return d2;
	}
	
	//Apartado c)
	public static Set<Usuario> apartadoC(Graph<Usuario, Relacion> grafo, Usuario u1, List<Set<Usuario>> cc1){
		HashSet<Usuario> c = new HashSet<Usuario>();
		Integer d2;
		List<Usuario> ls = grafo.vertexSet().stream().collect(Collectors.toList());
		for(int i = 0; i<ls.size();i++) {
			Usuario u2 = ls.get(i);
			if(!u1.equals(u2)) {
				d2 = apartadoB(grafo, u1, u2, cc1);
				if(d2<=2 && d2>0 || u1.getGrupo().equals(u2.getGrupo())) {
					c.add(u2);
				}
			}
		}
		return c;
	}
	
	
}

