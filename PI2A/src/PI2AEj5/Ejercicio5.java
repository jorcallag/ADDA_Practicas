package PI2AEj5;

import java.util.ArrayList;
import java.util.List;

import us.lsi.common.Files2;
import us.lsi.common.Tuple;
import us.lsi.common.Tuple2;

public class Ejercicio5 extends Files2{

	public static void main(String[] args) {

		int i = 0;
		List<String> listString = new ArrayList<String>();
		listString = getLines("C:\\Users\\jorge\\Desktop\\WorkSpace\\ADDA Java\\PI2A\\Ficheros\\PI2Ej5DatosEntrada.txt");

		while(i<listString.size()) {
			List<Integer> ls = listaLinea(listString, i);
			System.out.println("Histograma: " + ls);
			Integer res = mayorAreaLlamada(ls);
			System.out.println("Area Maxima: " + res);
			i++;			
		}

	}

	public static Integer mayorAreaLlamada(List<Integer> lista) {
		int i = 0;
		int j = lista.size()-1;
		Integer area = 0;
		return mayorArea(lista, i, j, area);
	}
	
	public static Integer mayorArea(List<Integer> lista, int i, int j, Integer area) {
		Tuple2<Integer, Integer> t = menorArea(lista, i, j);
		Integer a = t.getV1();
		Integer b = t.getV2();
		if(j-i <= 0) {
			return mayorDeDos(area, lista.get(i));
		}else {
			Integer n = a*(j-i+1);
			area = mayorDeDos(area, n);
			if(b > 0) {
				Integer res1 = mayorArea(lista, i, b-1, area);
				area = mayorDeDos(area, res1);
			}
			if(b < lista.size()-1) {
				Integer res2 = mayorArea(lista, b+1, j, area);
				area = mayorDeDos(area, res2);
			}
		}
		return area;
	}
	
	public static Integer mayorDeDos(Integer a, Integer b) {
		Integer res = b;
		if(a > b) {
			res = a;
		}
		return res;
	}
	
	public static Tuple2<Integer,Integer> menorArea(List<Integer> lista, Integer a, Integer b){
		Tuple2<Integer, Integer> t = Tuple.create(lista.get(a), a);
		int i = a;
		while(i <= b){
			if(t.getV1() > lista.get(i)){
				t = Tuple.create(lista.get(i), i);
			}
			i++;
		}
		return t;
	}	

	//Funcion de lectura
	public static List<Integer> listaLinea(List<String> lista, int i){
		List<Integer> ls = new ArrayList<Integer>();
		int j = 0;
		Integer n;
		String t[] = lista.get(i).split(",");
		while(j<t.length) {
			n = Integer.parseInt(t[j]);
			ls.add(n);
			j++;
		}
		return ls;		
	}

}


