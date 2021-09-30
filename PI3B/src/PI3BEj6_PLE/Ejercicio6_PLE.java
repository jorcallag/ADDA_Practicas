package PI3BEj6_PLE;

import us.lsi.pli.AlgoritmoPLI;
import us.lsi.pli.SolutionPLI;

public class Ejercicio6_PLE {

	public static void main(String[] args) {

		//Datos de entrada 1
		System.out.println("Datos de entrada 1:");
		SolutionPLI a1 = AlgoritmoPLI.getSolution(DatosTarea_PLE
				.getConstraints("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI3B\\ficheros\\PI3Ej6DatosEntrada"));
		System.out.println("Ganancia de la solucion = " + a1.getGoal());
		System.out.println("Tareas seleccionadas:");
		for (int j = 0; j < a1.getNumVar(); j++) {
			if(a1.getSolution()[j]>0) {
				System.out.println(DatosTarea_PLE.getTareas().get(j));
			}
		}
		System.out.println();

		//Datos de entrada 2
		System.out.println("Datos de entrada 2:");
		SolutionPLI a2 = AlgoritmoPLI.getSolution(DatosTarea_PLE
				.getConstraints("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI3B\\ficheros\\PI3Ej6DatosEntrada2"));
		System.out.println("Ganancia de la solucion = " + a2.getGoal());
		System.out.println("Tareas seleccionadas:");
		for (int j = 0; j < a2.getNumVar(); j++) {
			if(a2.getSolution()[j]>0) {
				System.out.println(DatosTarea_PLE.getTareas().get(j));
			}
		}

	}

}
