package PI2AEj3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import us.lsi.common.Files2;

public class Ejercicio3<E> extends Files2{

	public static void main(String[] args) {

		int i = 0;
		List<String> listString = new ArrayList<String>();
		listString = getLines("C:\\Users\\jorge\\Desktop\\WorkSpace\\ADDA Java\\PI2A\\Ficheros\\PI2Ej3DatosEntrada.txt");

		while(i<listString.size()) {
			List<Integer> ls = lineaLista(listString, i);
			Integer c1 = lineaComp1(listString, i);
			Integer c2 = lineaComp2(listString, i);
			System.out.println("Lista: " + ls);
			System.out.println("Rango: [" + c1 + ", " + c2 + ")");
			Set<Integer> t = listaOrdenadaLlamada(ls, c1, c2, Comparator.naturalOrder());
			System.out.println("Conjunto: " + t);
			System.out.println("");
			i++;
		}

	}

	public static <E extends Comparable<? super E>> Set<E> listaOrdenadaLlamada(List<E> lista, E c1, E c2, Comparator<E> cmp) {
		TreeSet<E> t = new TreeSet<E>();
		Integer primero = 0;
		Integer ultimo = lista.size()-1;
		return listaOrdenada(lista, c1, c2, cmp, primero, ultimo, (primero+ultimo)/2, t); 	
	}


	public static <E> Set<E> listaOrdenada(List<E> lista, E c1, E c2, Comparator<E> cmp, Integer primero, Integer ultimo, Integer mitad, TreeSet<E> t) {
		E elem = lista.get(mitad);
		if(primero == ultimo) {
			return t;
		}else if(cmp.compare(elem, c1) >= 0 && cmp.compare(elem , c2) < 0) {
			t.add(elem);
			listaOrdenada(lista, c1, c2, cmp, primero, mitad, (primero+mitad)/2, t);
			listaOrdenada(lista, c1, c2, cmp, mitad+1, ultimo, ((mitad+1)+ultimo)/2, t);
			return t;
		}else if(cmp.compare(elem, c1) < 0){
			return listaOrdenada(lista, c1, c2, cmp, mitad+1, ultimo, ((mitad+1)+ultimo)/2, t);
		}else if(cmp.compare(elem, c2) >= 0){
			return listaOrdenada(lista, c1, c2, cmp , primero, mitad, (primero+mitad)/2, t);
		}				
		return t;
	}

	//Funcion de lectura
	public static List<Integer> lineaLista(List<String> lista, int i){
		int j = 0;
		List<Integer> ls = new ArrayList<Integer>();
		String t[] = lista.get(i).split(";");
		String f[] = t[0].split(",");
		while(j<f.length) {
			Integer e = Integer.parseInt(f[j]);
			ls.add(e);
			j++;
		}
		return ls;		
	}

	public static Integer lineaComp1(List<String> lista, int i){
		String t[] = lista.get(i).split(";");
		String f[] = t[1].split(" ");
		Integer e = Integer.parseInt(f[0]);
		return e;		
	}

	public static Integer lineaComp2(List<String> lista, int i){
		String t[] = lista.get(i).split(";");
		String f[] = t[1].split(" ");
		Integer e = Integer.parseInt(f[1]);
		return e;		
	}

}
