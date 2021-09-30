package PI3BEj7_PLE;

import java.util.ArrayList;
import java.util.List;

import us.lsi.common.Files2;
import us.lsi.pli.AlgoritmoPLI;
import us.lsi.pli.SolutionPLI;

public class Ejercicio7_PLE {

	public static void main(String[] args) {

		String fichero = "C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI3B\\ficheros\\PI3Ej7DatosEntrada.txt";
		List<String> f = Files2.getLines(fichero);
		for(int i=0; i<f.size(); i++) {
			Integer n = DatosObjetivo_PLE.leeObjetivo(f, i);
			List<Integer> ls = DatosObjetivo_PLE.leeConjunto(f, i);
			List<Integer> a = new ArrayList<Integer>();
			SolutionPLI a1 = AlgoritmoPLI.getSolution(DatosObjetivo_PLE.getConstraints(ls, n));
			System.out.println("Conjunto de Entrada: " + ls);
			System.out.println("Suma objetivo = " + n);
			if((int) a1.getGoal()>0 && (int) a1.getGoal()<100) {
				System.out.print("Hay solucion exacta con " + (int) a1.getGoal() + " elementos: ");
				for (int j = 0; j < a1.getNumVar(); j++) {
					if(a1.getSolution()[j]>0) {
						for(int e = 0; e<a1.getSolution()[j]; e++) {
							a.add(ls.get(j));
						}
						
					}
				}
				for(int y = 0; y<a.size();y++) {
					if (y!=0) System.out.print(" + ");;
					System.out.print(a.get(y));
				}
				System.out.println();
			}else {
				System.out.println("No hay solucion exacta");
			}
			System.out.println();
		}

	}

}
