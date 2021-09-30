package PI3BEj7_AG;

import java.util.ArrayList;
import java.util.List;

import us.lsi.ag.ValuesInRangeChromosome;
import us.lsi.ag.ValuesInRangeProblemAG;

public class DatosObjetivo_AG implements ValuesInRangeProblemAG<Integer, List<Integer>>{

	public static List<Integer> conjunto;
	public static Integer objetivo;

	public static DatosObjetivo_AG iniDatos(List<String> f, int i) {
		List<Integer> ls = new ArrayList<Integer>();
		String[] e1 = f.get(i).split(":");
		String[] e2 = e1[0].split(",");
		for(int y=0; y<e2.length; y++) {
			ls.add(Integer.parseInt(e2[y]));
		}
		Integer n = Integer.parseInt(e1[1]);
		objetivo = n;
		conjunto = ls;
		return new DatosObjetivo_AG();
	}

	public List<Integer> getSolucion(ValuesInRangeChromosome<Integer> chromosome) {
		return chromosome.decode();
	}

	public Integer getVariableNumber(){
		return conjunto.size();
	}

	public Double fitnessFunction(ValuesInRangeChromosome<Integer> chromosome) {
		List<Integer> ls = chromosome.decode();
		Integer sumaOb = sumaObjetivo(ls);
		Integer sumaPen = (sumaPenalizacion(ls)-objetivo)*1000;
		
		return (double) -sumaOb - Math.abs(sumaPen);
	}
	
	public static Integer sumaPenalizacion(List<Integer> ls) {
		Integer suma = 0;
		for(int i=0; i<ls.size(); i++) {
			if(ls.get(i) >= 1) {
				suma = suma + (ls.get(i)*conjunto.get(i));
			}
		}
		return suma;
	}
	
	public static Integer sumaObjetivo(List<Integer> ls) {
		Integer suma = 0;
		for(int i=0; i<ls.size(); i++) {
			if(ls.get(i) >= 1) {
				suma = suma + ls.get(i);
			}
		}
		return suma;
	}

	public Integer getMax(Integer i) {
		Integer valor = objetivo/conjunto.get(i);
		return valor;
	}

	public Integer getMin(Integer i) {
		return 0;
	}
	
}
