package PI3BEj7_PLE;

import java.util.ArrayList;
import java.util.List;

public class DatosObjetivo_PLE {

	public static String getConstraints(List<Integer> ls, Integer n){
		String r = "";
		r = r + "min: ";
		for(int i = 0; i<ls.size(); i++){
			if (i!=0) r = r + "+";
			r = r + String.format("x%d", i);
		}		
		r = r+";\n\n";
		for(int y = 0; y<ls.size();y++){
			if (y!=0) r = r + "+";
			r = r + String.format("%dx%d", ls.get(y), y);
		}
		r = r + "="+ n +";\n";
		r = r+"\n";
		r = r +"int ";
		for(int i =0;i<ls.size();i++){
			if (i!=0) r = r+",";
			r = r + String.format("x%d",i);
		}
		r = r+";\n";		
		return r;
	}

	public static Integer leeObjetivo(List<String> f, int i) {
		String[] e = f.get(i).split(":");
		Integer n = Integer.parseInt(e[1]);
		return n;
	}

	public static List<Integer> leeConjunto(List<String> f, int i) {
		List<Integer> ls = new ArrayList<Integer>();
		String[] e1 = f.get(i).split(":");
		String[] e2 = e1[0].split(",");
		for(int y=0; y<e2.length; y++) {
			ls.add(Integer.parseInt(e2[y]));
		}
		return ls;
	}

}
