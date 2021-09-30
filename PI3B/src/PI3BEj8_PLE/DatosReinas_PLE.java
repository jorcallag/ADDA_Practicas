package PI3BEj8_PLE;

import java.util.ArrayList;
import java.util.List;

import us.lsi.common.Files2;

public class DatosReinas_PLE {
	
	public static String getConstraints(Integer numeroDeReinas){
		Integer n = numeroDeReinas;
		String r = "min: ;\n\n";
		boolean first = true;
		for (int i = 0; i < n; i++) {
			first = true;
			for (int j = 0; j < n; j++) {
				if (first) first = false; else r = r + "+";
				r = r + String.format("x_%d_%d", i, j);
			}
			r = r +"=";
			r = r +1;
			r = r+";\n";
		}
		for (int i = 0; i < n; i++) {
			first = true;
			for (int j = 0; j < n; j++) {
				if (first) first = false; else r = r + "+";
				r = r + String.format("x_%d_%d", j, i);
			}
			r = r +"=";
			r = r +1;
			r = r+";\n";
		}
		r = r+"\n";
		int m;
		for (int d = -n+1; d < n; d++) {
			first = true;
			m=0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {					
					if (d==j-i) {
						if (first) first = false; else r = r + "+";
						r = r + String.format("x_%d_%d",i, j);	
						m++;
					}
				}				
			}
			if (m>0) {
				r = r + "<=";
				r = r + 1;
				r = r + ";\n";
			}
		}
		for (int d = 0; d < 2*n-2; d++) {
			first = true;
			m=0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {					
					if (d==j+i) {
						if (first) first = false; else r = r + "+";
						r = r + String.format("x_%d_%d",i, j);
						m++;
					}
				}				
			}
			if (m>0) {
				r = r + "<=";
				r = r + 1;
				r = r + ";\n";
			}
		}
		r = r+"\n";
		r = r + "bin ";
		first = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (first) first = false; else r = r + ",";
				r = r + String.format("x_%d_%d",i, j);
			}

		}
		r = r+";\n\n";
		return r;
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
