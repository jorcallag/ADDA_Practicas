package PI3BEj5_PLE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import us.lsi.common.Streams2;

public class DatosUniverso_PLE {

	public static List<Universo_PLE> universosDisponibles;

	public static void iniDatos(String fichero) {
		universosDisponibles = Streams2.fromFile(fichero)
				.<Universo_PLE> map((String s) -> Universo_PLE.create(s))
				.collect(Collectors.<Universo_PLE> toList());
	}

	public static List<Universo_PLE> getUniversos() {
		return universosDisponibles;
	}

	public static Universo_PLE getUniverso(int index){
		return DatosUniverso_PLE.getUniversos().get(index);
	}

	public static List<Integer> getValor(int index){
		return DatosUniverso_PLE.getUniversos().get(index).getConjunto();
	}

	public static Integer getPeso(int index){
		return DatosUniverso_PLE.getUniversos().get(index).getPeso();
	}

	public static Boolean restricciones(Integer c) {
		return c >=0;
	}

	public static String getConstraints(String fichero){
		
		DatosUniverso_PLE.iniDatos(fichero);
		Map<Integer, List<String>> MapaL = getMap();
		int num = DatosUniverso_PLE.universosDisponibles.size();
		String r = "";
		r = r + "min: ";
		for(int i = 0; i<num; i++){
			if (i!=0) r = r + "+";
			r = r + String.format("%d*x%d ", DatosUniverso_PLE.getPeso(i), i);
		}		
		r = r+";\n\n";
		for(List<String> m : MapaL.values()){
			for(int i = 0; i<m.size(); i++) {
				if (i!=0) r = r + " + ";
				r = r + m.get(i);
			}
			r = r + " >= "+ 1 +";\n";
		}
		r = r+"\n";
		r = r +"bin ";
		for(int i =0;i<num;i++){
			if (i!=0) r = r+",";
			r = r + String.format("x%d",i);
		}
		r = r+";\n";		
		return r;
	}

	public static Set<Integer> getUniversoPadre(){
		TreeSet<Integer> t = new TreeSet<>();
		List<List<Integer>> r = DatosUniverso_PLE.universosDisponibles.stream().map(x->x.getConjunto()).collect(Collectors.toList());
		for(int i=0;i<r.size();i++) {
			for(int j=0; j<r.get(i).size();j++) {
				if(!t.contains(r.get(i).get(j))){
					t.add(r.get(i).get(j));
				}
			}
		}
		return t;
	}

	public static Map<Integer, List<String>> getMap(){
		List<Integer> elementos = DatosUniverso_PLE.getUniversoPadre().stream().collect(Collectors.toList());
		Map<Integer, List<String>> MapaL = new HashMap<Integer, List<String>>();
		String s = "";
		for(int i = 0;i<elementos.size(); i++) {
			List<String> lss = new ArrayList<String>();
			int aux = elementos.get(i);
			for(int y = 0; y<universosDisponibles.size(); y++) {
				if(!MapaL.containsKey(aux)) {
					if(DatosUniverso_PLE.getUniverso(y).getConjunto().contains(aux)) {
						s = String.format("x%d", y);
						lss.add(s);
						MapaL.put(aux, lss); 
					}
				}else {
					if(DatosUniverso_PLE.getUniverso(y).getConjunto().contains(aux)) {
						s = String.format("x%d", y);
						MapaL.get(aux).add(s);
					}
				}
			}
		}
		return MapaL;
	}

}
