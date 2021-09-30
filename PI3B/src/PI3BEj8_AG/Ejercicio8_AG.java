package PI3BEj8_AG;

import java.util.List;

import us.lsi.ag.SeqNomalChromosome;
import us.lsi.ag.SeqNormalProblemAG;
import us.lsi.ag.agchromosomes.AlgoritmoAG;
import us.lsi.ag.agchromosomes.ChromosomeFactory;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;
import us.lsi.ag.agchromosomes.ChromosomeFactory.CrossoverType;
import us.lsi.ag.agstopping.StoppingConditionFactory;
import us.lsi.ag.agstopping.StoppingConditionFactory.StoppingConditionType;
import us.lsi.reinas.datos.Reina;

public class Ejercicio8_AG {

	public static void main(String[] args){

		AlgoritmoAG.ELITISM_RATE  = 0.20;
		AlgoritmoAG.CROSSOVER_RATE = 0.8;
		AlgoritmoAG.MUTATION_RATE = 0.8;
		AlgoritmoAG.POPULATION_SIZE = 40;

		StoppingConditionFactory.NUM_GENERATIONS = 6000;
		StoppingConditionFactory.SOLUTIONS_NUMBER_MIN = 1;
		StoppingConditionFactory.FITNESS_MIN = 0.;
		StoppingConditionFactory.stoppingConditionType = StoppingConditionType.SolutionsNumber;

		ChromosomeFactory.crossoverType = CrossoverType.OnePoint;

		List<Integer> ls2 = DatosReinas_AG.listaDeReinas("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI3B\\ficheros\\PI3Ej8DatosEntrada.txt");
		for(int y=0; y<ls2.size(); y++) {
			DatosReinas_AG.numeroDeReinas = ls2.get(y);
			SeqNormalProblemAG<List<Reina>> p = DatosReinas_AG.create();
			AlgoritmoAG<SeqNomalChromosome> ap = AlgoritmoAG.<SeqNomalChromosome>create(ChromosomeType.SqnPermutation,p);
			ap.ejecuta();
			SeqNomalChromosome cr = ap.getBestChromosome();
			System.out.println("Numero de reinas: " + DatosReinas_AG.numeroDeReinas);
			System.out.print("Solucion: ");
			for(int i = 0; i<p.getSolucion(cr).size(); i++) {
				System.out.print("x_" + p.getSolucion(cr).get(i).getX() + "_" + p.getSolucion(cr).get(i).getY() + " ");
			}
			System.out.println("\n");
		}
		
	}

}
