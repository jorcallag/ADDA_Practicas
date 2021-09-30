package PI3BEj9_AG;

import java.util.ArrayList;
import java.util.List;

import us.lsi.ag.SeqNomalChromosome;
import us.lsi.ag.SeqNormalProblemAG;
import us.lsi.ag.agchromosomes.AlgoritmoAG;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;
import us.lsi.ag.agstopping.StoppingConditionFactory;
import us.lsi.ag.agstopping.StoppingConditionFactory.StoppingConditionType;
import us.lsi.common.Files2;
import us.lsi.grafos.datos.Ciudad;

public class Ejercicio9_AG {

	public static void main(String[] args){

		AlgoritmoAG.ELITISM_RATE  = 0.30;
		AlgoritmoAG.CROSSOVER_RATE = 0.8;
		AlgoritmoAG.MUTATION_RATE = 0.7;
		AlgoritmoAG.POPULATION_SIZE = 200;

		StoppingConditionFactory.NUM_GENERATIONS = 100;
		StoppingConditionFactory.SOLUTIONS_NUMBER_MIN = 1;
		StoppingConditionFactory.FITNESS_MIN = 400;
		StoppingConditionFactory.stoppingConditionType = StoppingConditionType.SolutionsNumber;

		List<String> ls = Files2.getLines("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI3B\\ficheros\\PI3Ej9DatosEntrada.txt");
		for(int i = 0; i<ls.size(); i++) {
			System.out.println("Datos de entrada " + i + ":");
			SeqNormalProblemAG<List<Integer>> p1 = new DatosViaje_AG("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI3B\\ficheros\\PI3Ej9DatosEntradaGrafo.txt", ls.get(i));

			AlgoritmoAG<SeqNomalChromosome> ap1 = AlgoritmoAG.create(ChromosomeType.SqnPermutationSubList, p1);
			ap1.ejecuta();

			SeqNomalChromosome cr1 = ap1.getBestChromosome();
			
			System.out.println("Ciudad inicial: " + DatosViaje_AG.Source);
			System.out.println("Ciudad final: " + DatosViaje_AG.Target);
			List<Ciudad> lsCiudadesConOD = new ArrayList<Ciudad>();
			lsCiudadesConOD.add(DatosViaje_AG.Source);
			List<Ciudad> lsCiudades = DatosViaje_AG.listaCiudadesCromosoma(cr1.decode());
			lsCiudadesConOD.addAll(lsCiudades);
			lsCiudadesConOD.add(DatosViaje_AG.Target);
			System.out.println("Mejor solucion encontrada: ");
			System.out.print("    Ruta = ");
			for(int j = 0; j<lsCiudadesConOD.size(); j++) {
				if(!(j == 0)) System.out.print(" -> ");
				System.out.print(lsCiudadesConOD.get(j));
			}
			System.out.println("\n");
		}
	}

}
