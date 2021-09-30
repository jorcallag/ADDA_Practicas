package PI3BEj5_AG;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import us.lsi.common.Streams2;

public class Universo_AG {
	
	public static List<Universo_AG> leeUniverso(String fichero){
        nCodigo =0;
        universo = Streams2.fromFile(fichero).map(s ->Universo_AG.create(s)).collect(Collectors.toList());
        return universo;
    }
	
	public static Universo_AG create(List<Integer> conjunto, Integer peso) {
		return new Universo_AG(conjunto, peso);
	}

	public static Universo_AG create(String s) {
		return new Universo_AG(s);
	}

	private static Integer nCodigo = 0;

	private Integer codigo;
	private List<Integer> conjunto;
	private Integer peso;
	
	public static List<Universo_AG> universo;
	
	Universo_AG(List<Integer> conjunto, Integer peso){
		this.codigo = nCodigo;
		nCodigo++;
		this.conjunto = conjunto;
		this.peso = peso;
	}	

	Universo_AG(String r){		
		ArrayList<Integer> ls = new ArrayList<Integer>();
		String l = r.substring(1,r.length());
		String s = l.replace("},", ";");
		String[] v = s.split(";");
		String[] t = v[0].split(",");
		for(int i = 0; i<t.length; i++) {
			ls.add(Integer.valueOf(t[i]));
		}
		conjunto = ls;
		peso = Integer.parseInt(v[1].trim());
		this.codigo = nCodigo;
		nCodigo++;	
	}	

	public List<Integer> getConjunto(){
		return conjunto;
	}

	public Integer getPeso() {
		return peso;
	}

	public Integer getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		return "(" + conjunto + ", " + peso + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Universo_AG other = (Universo_AG) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
