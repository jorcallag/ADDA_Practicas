package PI2BEj10;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import us.lsi.common.Files2;
import us.lsi.tiposrecursivos.BinaryTree;

public class Ejercicio10 extends Files2{

	public static <E> void main(String[] args){

		int i = 0;
		List<String> listString = new ArrayList<String>();
		listString = getLines("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI2B\\Ficheros\\PI2Ej10DatosEntrada.txt");

		while(i<listString.size()) {
			BinaryTree<String> t = leeBinario(listString, i);
			System.out.println("Entrada: " + t);
			String u = leeElemento(listString, i);
			HashSet<String> e = conjuntoMayorLlamada(t, u);
			Integer a = e.size();
			System.out.println("Los elementos mayores o iguales que " + u + " son " + a + ": " + e);
			System.out.println("============================================================================================");
			i++;
		}

	}
	
	private static HashSet<String> conjuntoMayorLlamada(BinaryTree<String> t, String u){
		HashSet<String> h = new HashSet<String>();
		return conjuntoMayor(t, u, h);
	}

	private static HashSet<String> conjuntoMayor(BinaryTree<String> t, String u, HashSet<String> h) {
		switch(t.getType()) {
		case Empty: 
			h.clear();
			break;
		case Leaf: 
			if(t.getLabel().compareTo(u) > 0) {
				h.add(t.getLabel());
			}
			break;
		case Binary: 
			if(t.isBinary() && t.getLabel().compareTo(u) > 0) {
				h.add(t.getLabel());
			}	
			h = conjuntoMayor(t.getRight(), u, h);
			h = conjuntoMayor(t.getLeft(), u, h);
			break;
		}
		return h;
	}

	//Funcion de lectura
	public static <E> BinaryTree<E> leeBinario(List<String> lista, int e){
		String s[] = lista.get(e).split(";");
		BinaryTree<E> t = (BinaryTree<E>) BinaryTree.parse(s[0]);
		return t;
	}

	public static String leeElemento(List<String> lista, int e){
		String s[] = lista.get(e).split(";");
		return s[1];
	}

}
