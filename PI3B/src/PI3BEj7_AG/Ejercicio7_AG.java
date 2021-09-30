package PI3BEj7_AG;

import java.util.ArrayList;
import java.util.List;

import PI3BEj7_PLE.DatosObjetivo_PLE;
import us.lsi.ag.ValuesInRangeChromosome;
import us.lsi.ag.ValuesInRangeProblemAG;
import us.lsi.ag.agchromosomes.AlgoritmoAG;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;
import us.lsi.ag.agstopping.StoppingConditionFactory;
import us.lsi.ag.agstopping.StoppingConditionFactory.StoppingConditionType;
import us.lsi.common.Files2;

public class Ejercicio7_AG {

	public static void main(String[] args){

		AlgoritmoAG.ELITISM_RATE  = 0.30;
		AlgoritmoAG.CROSSOVER_RATE = 0.8;
		AlgoritmoAG.MUTATION_RATE = 0.7;
		AlgoritmoAG.POPULATION_SIZE = 200;

		StoppingConditionFactory.NUM_GENERATIONS = 100;
		StoppingConditionFactory.SOLUTIONS_NUMBER_MIN = 1;
		StoppingConditionFactory.FITNESS_MIN = 400;
		StoppingConditionFactory.stoppingConditionType = StoppingConditionType.SolutionsNumber;

		String fichero = "C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI3B\\ficheros\\PI3Ej7DatosEntrada.txt";
		List<String> f = Files2.getLines(fichero);
		for(int i=0; i<f.size(); i++) {

			List<Integer> ls = DatosObjetivo_PLE.leeConjunto(f, i);
			List<Integer> a = new ArrayList<Integer>();
			ValuesInRangeProblemAG<Integer,List<Integer>> p1 = DatosObjetivo_AG.iniDatos(f, i);

			AlgoritmoAG<ValuesInRangeChromosome<Integer>> ap1 = AlgoritmoAG.create(ChromosomeType.Range, p1);
			ap1.ejecuta();

			ValuesInRangeChromosome<Integer> cr1 = ap1.getBestChromosome();

			System.out.println("Conjunto de Entrada: " + ls);
			System.out.println("Suma objetivo = " + DatosObjetivo_AG.objetivo);
			if((int) cr1.fitness()>-1000) {
				System.out.print("Hay solucion exacta con " + elementos(p1.getSolucion(cr1)) + " elementos: ");
				for (int j = 0; j < p1.getSolucion(cr1).size(); j++) {
					if(p1.getSolucion(cr1).get(j)>0) {
						for(int e = 0; e<p1.getSolucion(cr1).get(j); e++) {
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
	
	public static Integer elementos(List<Integer> ls) {
		Integer res = 0;
		for(int i = 0; i<ls.size(); i++) {
			if(ls.get(i) >= 1) {
				for(int j = 0; j<ls.get(i); j++) {
					res++;
				}
			}
		}
		return res;
	}
}
