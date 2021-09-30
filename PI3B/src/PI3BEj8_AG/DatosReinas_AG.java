package PI3BEj8_AG;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import us.lsi.ag.HelpFitnessAg;
import us.lsi.ag.SeqNomalChromosome;
import us.lsi.ag.SeqNormalProblemAG;
import us.lsi.common.Files2;
import us.lsi.common.Lists2;
import us.lsi.common.Sets2;
import us.lsi.reinas.datos.Reina;

public class DatosReinas_AG implements SeqNormalProblemAG<List<Reina>>{
	public static int numeroDeReinas = 8;

	public static DatosReinas_AG create() {
		return new DatosReinas_AG();
	}

	private DatosReinas_AG() {
	}

	public List<Reina> getSolucion(SeqNomalChromosome chromosome) {
		List<Integer> ls = chromosome.decode();
		List<Reina> r = Lists2.empty();
		for (int i = 0; i < ls.size(); i++) {
			r.add(Reina.create(i, ls.get(i)));
		}
		return r;
	}

	public Double fitnessFunction(SeqNomalChromosome chromosome) {
		List<Integer> ls = chromosome.decode();
		Set<Integer> dp = Sets2.newHashSet();
		Set<Integer> ds = Sets2.newHashSet();
		for (int i = 0; i < ls.size(); i++) {
			dp.add(ls.get(i)-i);
			ds.add(ls.get(i)+i);
		}
		return -HelpFitnessAg.distanceToEqZero(2.*DatosReinas_AG.numeroDeReinas-dp.size()-ds.size());
	}

	public Integer getObjectsNumber() {
		return numeroDeReinas;
	}	

	public static List<Integer> listaDeReinas(String fichero){
		List<Integer> ls = new ArrayList<Integer>();
		List<String> f = Files2.getLines(fichero);
		for(int i=0; i<f.size(); i++) {
			String[] e = f.get(i).split(":");
			ls.add(Integer.parseInt(e[1]));
		}
		return ls;		
	}

}
