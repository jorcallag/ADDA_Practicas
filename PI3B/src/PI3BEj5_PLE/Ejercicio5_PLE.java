package PI3BEj5_PLE;

import us.lsi.pli.AlgoritmoPLI;
import us.lsi.pli.SolutionPLI;

public class Ejercicio5_PLE {
	
	public static void main(String[] args) {
		
		//Datos de entrada 1
		System.out.println("Datos de entrada 1: ");
		SolutionPLI a1 = AlgoritmoPLI.getSolution(DatosUniverso_PLE.
				getConstraints("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI3B\\ficheros\\PI3Ej5DatosEntrada"));
		System.out.println("Coste (suma de pesos de la solucion) = " + a1.getGoal());
		System.out.println("Subconjuntos escogidos y peso asociado:");
		for(int i = 0; i<a1.getNumVar(); i++) {
			if(a1.getSolution()[i]>0) {
				System.out.println(DatosUniverso_PLE.universosDisponibles.get(i));
			}
		}
		System.out.println();
		
		//Datos de entrada 2
		System.out.println("Datos de entrada 2: ");
		SolutionPLI a2 = AlgoritmoPLI.getSolution(DatosUniverso_PLE
				.getConstraints("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI3B\\ficheros\\PI3Ej5DatosEntrada2"));
		System.out.println("Coste (suma de pesos de la solucion) = " + a2.getGoal());
		System.out.println("Subconjuntos escogidos y peso asociado:");
		for (int j = 0; j < a2.getNumVar(); j++) {
			if(a2.getSolution()[j]>0) {
				System.out.println(DatosUniverso_PLE.universosDisponibles.get(j));
			}
		}
		
	}
	
}
