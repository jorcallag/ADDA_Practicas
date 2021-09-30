package PI2BEj9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import PI2BEj6.Ejercicio6;
import us.lsi.common.Files2;
import us.lsi.common.Tuple;
import us.lsi.common.Tuple2;
import us.lsi.tiposrecursivos.Tree;

public class Ejercicio9 extends Files2{

	public static <E> void main(String[] args){

		int i = 0;
		List<String> listString = new ArrayList<String>();
		listString = getLines("C:\\Users\\jorge\\Desktop\\WorkSpace\\ADDA Java\\PI2B\\Ficheros\\PI2Ej9DatosEntrada.txt");

		while(i<listString.size()) {
			Tree<E> t0 = leeNario(listString, i);
			Tree<Integer> t = Ejercicio6.funcionNario(t0, x -> Integer.parseInt((String) x));
			System.out.println("Entrada: " + t);
			Tuple2<Integer, Integer> a = maxMin(t, Comparator.naturalOrder());
			System.out.println("Min: " + a.v1 + " Max: " + a.v2);
			System.out.println("=============================================================");
			i++;
		}
	}

	public static Tuple2<Integer, Integer> maxMin(Tree<Integer> t, Comparator<Integer> cmp) {
		Tuple2<Integer, Integer> a = Tuple.create(null,null);
		switch(t.getType()) {	
		case Empty: 
			a.v1 = null;
			a.v2 = null;
			break;
		case Leaf:  
			a.v1 = t.getLabel();
			a.v2 = t.getLabel();
			if(t.getLabel() <= a.v1 ) {
				a.v1 = t.getLabel();
			} else if(t.getLabel() >= a.v2) {
				a.v2 = t.getLabel();
			}
			break;
		case Nary:	
			a.v1 = min1(t.getChildren().iterator(), cmp, null);
			a.v2 = max1(t.getChildren().iterator(), cmp, null);
			if(t.getLabel() <= a.v1 ) {
				a.v1 = t.getLabel();
			} else if(t.getLabel() >= a.v2) {
				a.v2 = t.getLabel();
			}
			break;
		}
		return a;
	}
	
	public static Integer min1(Iterator<Tree<Integer>> it, Comparator<Integer> cmp, Integer a) {
		if(it.hasNext()) {
			a = min2(cmp, maxMin(it.next(), cmp).getV1(), min1(it, cmp, a));
		}
		return a;
	}
	
	public static Integer max1(Iterator<Tree<Integer>> it, Comparator<Integer> cmp, Integer a) {
		if(it.hasNext()) {
			a = max2(cmp, maxMin(it.next(), cmp).getV1(), max1(it, cmp, a));
		}
		return a;
	}

	public static Integer min2(Comparator<Integer> cmp, Integer e1, Integer e2) {
		if(e1==null) {
			return e2;
		} else if(e2==null) {
			return e1;
		} else {			
			return cmp.compare(e1, e2)<0? e1: e2;
		}
	}
	
	public static Integer max2(Comparator<Integer> cmp, Integer e1, Integer e2) {
		if(e1==null) {
			return e2;
		} else if(e2==null) {
			return e1;
		} else {			
			return cmp.compare(e1, e2)>=0? e1: e2;
		}
	}

	//Funciones de lectura
	public static <E> Tree<E> leeNario(List<String> lista, int e){
		Tree<E> t = (Tree<E>) Tree.parse(lista.get(e));
		return t;
	}

}
