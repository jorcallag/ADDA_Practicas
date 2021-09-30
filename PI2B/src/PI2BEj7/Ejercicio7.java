package PI2BEj7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import us.lsi.common.Files2;
import us.lsi.tiposrecursivos.Tree;

public class Ejercicio7 extends Files2{

	public static <E> void main(String[] args){
		
		int i = 0;
		List<String> listString = new ArrayList<String>();
		listString = getLines("C:\\Users\\jorge\\Desktop\\WorkSpace\\ADDA Java\\PI2B\\Ficheros\\PI2Ej7DatosEntrada.txt");
		
		while(i<listString.size()) {
			Tree<E> t = leeNario(listString, i);
			System.out.println("Arbol: " + t);
			List<E> lista = listaEtiquetas(t);
			System.out.println("Lista de hojas: " + lista);
			System.out.println("=============================================================");
			i++;
		}
	}
	
	public static <E> List<E> listaEtiquetas(Tree<E> t){
		List<E> res = new ArrayList<E>();
		if(t.isEmpty()) {
			return res;
		}else if (t.isLeaf()) {
			res.add(t.getLabel());
			return res;
		}else {
			Iterator<Tree<E>> it = t.getChildren().iterator();
			while(it.hasNext()) {
				res.addAll((Collection<? extends E>) listaEtiquetas(it.next()));
			}
		}
		return res;
	}
	
	//Funciones de lectura
	public static <E> Tree<E> leeNario(List<String> lista, int e){
		Tree<E> t = (Tree<E>) Tree.parse(lista.get(e));
		return t;
	}
}
