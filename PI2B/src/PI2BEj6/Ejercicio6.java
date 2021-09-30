package PI2BEj6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import us.lsi.common.Files2;
import us.lsi.tiposrecursivos.BinaryTree; 
import us.lsi.tiposrecursivos.Tree;

public class Ejercicio6 extends Files2{

	public static <E> void main(String[] args) {
		
		int i = 0, j = 0;
		List<String> listString1 = new ArrayList<String>();
		List<String> listString2 = new ArrayList<String>();
		listString1 = getLines("C:\\Users\\jorge\\Desktop\\WorkSpace\\ADDA Java\\PI2B\\Ficheros\\PI2Ej6DatosEntradaArbolBinario.txt");
		listString2 = getLines("C:\\Users\\jorge\\Desktop\\WorkSpace\\ADDA Java\\PI2B\\Ficheros\\PI2Ej6DatosEntradaArbolNario.txt");
		
		System.out.println("Solucion para arboles binarios:\n");
		while(i<listString1.size()) {
			BinaryTree<String> t = leeBinario(listString1, i);
			System.out.println("Entrada: " + t);
			BinaryTree<Integer> t1 = funcionBinario(t, x -> Integer.parseInt((String) x));
			System.out.println("Funcion 1: " + t1);
			BinaryTree<Integer> t2 = funcionBinario(t, x -> funcion2(x));
			System.out.println("Funcion 2: " + t2);
			BinaryTree<Integer> t3 = funcionBinario(t, x -> funcion3(x));
			System.out.println("Funcion 3: " + t3);
			System.out.println("=============================================================");
			i++;
		}
		
		System.out.println("Solucion para arboles n-arios:\n");
		while(j<listString2.size()) {
			Tree<E> t = leeNario(listString2, j);
			System.out.println("Entrada: " + t);
			Tree<Integer> t1 = funcionNario(t, x -> Integer.parseInt((String) x));
			System.out.println("Funcion 1: " + t1);
			Tree<Integer> t2 = funcionNario(t, x -> funcion2(x));
			System.out.println("Funcion 2: " + t2);
			Tree<Integer> t3 = funcionNario(t, x -> funcion3(x));
			System.out.println("Funcion 3: " + t3);
			System.out.println("=============================================================");
			j++;
		}
	}
	
	//Arbol Binario
	public static <E,R> BinaryTree<R> funcionBinario(BinaryTree<E> t, Function<E, R> f){
		BinaryTree<R> tRes = null;
		switch(t.getType()) {	
			case Empty: 
				tRes = BinaryTree.empty(); break;
			case Leaf: 
				tRes = BinaryTree.leaf(f.apply(t.getLabel())); break;
			case Binary: 
				tRes = BinaryTree.binary(f.apply(t.getLabel()), funcionBinario(t.getLeft(), f), funcionBinario(t.getRight(), f)); 
				break;
		}
		return tRes;
	}
	
	//Arbol n-ario
	public static <E,R> Tree<R> funcionNario(Tree<E> t, Function<E, R> f){
		List<Tree<R>> lista = new ArrayList<Tree<R>>();				
		Tree<R> tRes = null;
		switch(t.getType()) {	
			case Empty: tRes = Tree.empty(); break;
			case Leaf: tRes = Tree.leaf(f.apply(t.getLabel())); break;
			case Nary: tRes = Tree.nary(f.apply(t.getLabel()), funcionNarioV2(t.getChildren().iterator(), lista, f)); break;
		}
		return tRes;
	}
	
	public static <E, R> List<Tree<R>> funcionNarioV2(Iterator<Tree<E>> t, List<Tree<R>> lista, Function<E, R> f){
		if(t.hasNext()) {
			lista.add(0, funcionNario(t.next(), f));
			funcionNarioV2(t, lista, f);
		}
		return lista;
	}
	
	//Funciones	
	public static <E> Integer funcion2(E x) {
		String r = ((String) x).replace("-", "");
		Integer a = r.length();
		return a;
	}
	
	public static <E> Integer funcion3(E x) {
		int i = 0;
		Integer b = 0;
		String u = ((String) x).replace("-", "");
		String[] t = u.split("");
		while(i<t.length) {
			Integer a = Integer.parseInt(t[i]);
			if(a>b) {
				b = a;
			}
			i++;
		}
		Integer r = (int) Math.pow(2, b);
		return r;
	}
	
	//Funcion de lectura
	public static <E> BinaryTree<E> leeBinario(List<String> lista, int e){
		BinaryTree<E> t = (BinaryTree<E>) BinaryTree.parse(lista.get(e));
		return t;
	}
	
	public static <E> Tree<E> leeNario(List<String> lista, int e){
		Tree<E> t = (Tree<E>) Tree.parse(lista.get(e));
		return t;
	}
	
}
