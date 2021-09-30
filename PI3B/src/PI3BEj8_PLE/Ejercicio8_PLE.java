package PI3BEj8_PLE;

import java.util.List;

import us.lsi.pli.AlgoritmoPLI;
import us.lsi.pli.SolutionPLI;

public class Ejercicio8_PLE {
	
	public static void main(String[] args) {
		List<Integer> ls = DatosReinas_PLE.listaDeReinas("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI3B\\ficheros\\PI3Ej8DatosEntrada.txt");
		for(int y=0; y<ls.size(); y++) {
			SolutionPLI s = AlgoritmoPLI.getSolution(DatosReinas_PLE.getConstraints(ls.get(y)));
			System.out.println("Numero de reinas: " + ls.get(y));
			System.out.print("Solucion: ");
			for(int i=0;i<s.getNumVar();i++){
				if(s.getSolution(i) == 1.0)
					System.out.print(s.getName(i) + " ");
			}
			System.out.println("\n");
		}
	}

}
