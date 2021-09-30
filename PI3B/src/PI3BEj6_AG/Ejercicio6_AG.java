package PI3BEj6_AG;

import java.util.List;

import us.lsi.ag.ValuesInRangeChromosome;
import us.lsi.ag.ValuesInRangeProblemAG;
import us.lsi.ag.agchromosomes.AlgoritmoAG;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;
import us.lsi.ag.agstopping.StoppingConditionFactory;
import us.lsi.ag.agstopping.StoppingConditionFactory.StoppingConditionType;

public class Ejercicio6_AG {

	public static void main(String[] args){

		AlgoritmoAG.ELITISM_RATE  = 0.30;
		AlgoritmoAG.CROSSOVER_RATE = 0.8;
		AlgoritmoAG.MUTATION_RATE = 0.7;
		AlgoritmoAG.POPULATION_SIZE = 200;

		StoppingConditionFactory.NUM_GENERATIONS = 100;
		StoppingConditionFactory.SOLUTIONS_NUMBER_MIN = 1;
		StoppingConditionFactory.FITNESS_MIN = 400;
		StoppingConditionFactory.stoppingConditionType = StoppingConditionType.SolutionsNumber;

		//Datos de entrada 1
		System.out.println("Datos de entrada 1:");
		ValuesInRangeProblemAG<Integer,List<Integer>> p1 = DatosTarea_AG
				.iniDatos("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI3B\\ficheros\\PI3Ej6DatosEntrada");

		AlgoritmoAG<ValuesInRangeChromosome<Integer>> ap1 = AlgoritmoAG.create(ChromosomeType.Binary, p1);
		ap1.ejecuta();

		ValuesInRangeChromosome<Integer> cr1 = ap1.getBestChromosome();

		System.out.println("Ganancia de la solucion = " + Math.abs(cr1.fitness()));
		System.out.println("Tareas seleccionadas: ");
		for(int i = 0; i<p1.getSolucion(cr1).size(); i++) {
			if(p1.getSolucion(cr1).get(i) == 1) {
				System.out.println(DatosTarea_AG.getTareas().get(i));
			}
		}
		System.out.println();

		//Datos de entrada 2
		System.out.println("Datos de entrada 2:");
		ValuesInRangeProblemAG<Integer,List<Integer>> p2 = DatosTarea_AG
				.iniDatos("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI3B\\ficheros\\PI3Ej6DatosEntrada2");

		AlgoritmoAG<ValuesInRangeChromosome<Integer>> ap2 = AlgoritmoAG.create(ChromosomeType.Binary, p1);
		ap2.ejecuta();

		ValuesInRangeChromosome<Integer> cr2 = ap2.getBestChromosome();

		System.out.println("Ganancia de la solucion = " + Math.abs(cr2.fitness()));
		System.out.println("Tareas seleccionadas: ");
		for(int i = 0; i<p2.getSolucion(cr2).size(); i++) {
			if(p2.getSolucion(cr2).get(i) == 1) {
				System.out.println(DatosTarea_AG.getTareas().get(i));
			}
		}

	}

}
