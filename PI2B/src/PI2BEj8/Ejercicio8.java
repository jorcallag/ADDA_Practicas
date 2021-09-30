package PI2BEj8;

import java.util.ArrayList;
import java.util.List;

import PI2BEj6.Ejercicio6;
import us.lsi.common.Files2;
import us.lsi.tiposrecursivos.BinaryTree;

public class Ejercicio8 extends Files2{

	public static <E> void main(String[] args){

		int i = 0;
		List<String> listString = new ArrayList<String>();
		listString = getLines("C:\\Users\\jorge\\Desktop\\WorkSpace\\ADDA Java\\PI2B\\Ficheros\\PI2Ej8DatosEntrada.txt");
		
		while(i<listString.size()) {
			BinaryTree<E> t0 = leeBinario(listString, i);
			BinaryTree<Integer> t = Ejercicio6.funcionBinario(t0, x -> Integer.parseInt((String) x));
			System.out.println("Entrada: " + t);
			Integer u = leeElemento(listString, i);
			Integer e = posicionElemento(t, u, 0);
			System.out.println("Salida: El nivel del elemento " + u + " es: " + e);
			System.out.println("=============================================================");
			i++;
		}
		
	}
	
	public static Integer posicionElemento(BinaryTree<Integer> t, Integer i, Integer res) {
		switch(t.getType()) {
			case Empty: 
				res = -1; 
				break;
			case Leaf: 
				if(t.getLabel()==i) {
					res = 0;
				}else {
					res = -2;
				}
				break;
			case Binary: 
				if(t.isBinary() && t.getLabel()==i) {
					res = 0;
				}else if(t.isBinary() && (t.getLabel()<i)) {
					res = posicionElemento(t.getRight(), i, res) + 1;
				}else if(t.isBinary() && (t.getLabel()>i)){
					res = posicionElemento(t.getLeft(), i, res) + 1;
				}				
				break;
		}
		return res;
	}

	//Funcion de lectura
	public static <E> BinaryTree<E> leeBinario(List<String> lista, int e){
		String s[] = lista.get(e).split(";");
		BinaryTree<E> t = (BinaryTree<E>) BinaryTree.parse(s[0]);
		return t;
	}
	
	public static Integer leeElemento(List<String> lista, int e){
		String s[] = lista.get(e).split(";");
		Integer t = Integer.parseInt(s[1]);
		return t;
	}

}
