package PI3BEj5_AG;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import us.lsi.ag.ValuesInRangeChromosome;
import us.lsi.ag.ValuesInRangeProblemAG;

public class DatosUniverso_AG implements ValuesInRangeProblemAG<Integer, List<Integer>>{
	
	public static List<Universo_AG> universosDisponibles;

	public static DatosUniverso_AG iniDatos(String fichero) {
		universosDisponibles = Universo_AG.leeUniverso(fichero);
		return new DatosUniverso_AG();
	}

	public List<Integer> getSolucion(ValuesInRangeChromosome<Integer> chromosome) {
		return chromosome.decode();
	}

	public Integer getVariableNumber(){
		return universosDisponibles.size();
	}

	public Double fitnessFunction(ValuesInRangeChromosome<Integer> chromosome) {
		List<Integer> ls = chromosome.decode();
		Set<Integer> conjunto = conjuntos(ls);
		Integer pesos = pesos(ls);
		Integer penalizacion = - Math.abs((conjunto.size()-getUniversoPadre().size())*1000);
		
		return (double) -pesos + penalizacion;
	}
	
	public static Integer pesos(List<Integer> ls) {
		Integer pesos = 0;
		for(int i=0; i<ls.size(); i++) {
			if(ls.get(i) == 1) {
				pesos = pesos + universosDisponibles.get(i).getPeso();
			}
		}
		return pesos;
	}
	
	public static Set<Integer> conjuntos(List<Integer> ls){
		Set<Integer> conjunto = new HashSet<Integer>();
		for(int i=0; i<ls.size(); i++) {
			if(ls.get(i) == 1) {
				conjunto.addAll(universosDisponibles.get(i).getConjunto());
			}
		}
		return conjunto;
	}

	@Override
	public Integer getMax(Integer i) {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public Integer getMin(Integer i) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static Set<Integer> getUniversoPadre(){
		TreeSet<Integer> t = new TreeSet<>();
		List<List<Integer>> r = DatosUniverso_AG.universosDisponibles.stream().map(x->x.getConjunto()).collect(Collectors.toList());
		for(int i=0;i<r.size();i++) {
			for(int j=0; j<r.get(i).size();j++) {
				if(!t.contains(r.get(i).get(j))){
					t.add(r.get(i).get(j));
				}
			}
		}
		return t;
	}

}
