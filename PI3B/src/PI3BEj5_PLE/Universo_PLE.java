package PI3BEj5_PLE;

import java.util.ArrayList;
import java.util.List;

public class Universo_PLE {

	public static Universo_PLE create(List<Integer> conjunto, Integer peso) {
		return new Universo_PLE(conjunto, peso);
	}

	public static Universo_PLE create(String s) {
		return new Universo_PLE(s);
	}

	private static Integer nCodigo = 0;

	private Integer codigo;
	private List<Integer> conjunto;
	private Integer peso;

	Universo_PLE(List<Integer> conjunto, Integer peso){
		this.codigo = nCodigo;
		nCodigo++;
		this.conjunto = conjunto;
		this.peso = peso;
	}	

	Universo_PLE(String r){		
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
		Universo_PLE other = (Universo_PLE) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
