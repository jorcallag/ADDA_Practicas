package PI1AEj1;

import java.util.ArrayList;
import java.util.List;
import us.lsi.common.Files2;

public class Ejercicio1 extends Files2{

	public static void main(String[] args) {
		
		List<String> lineas = new ArrayList<String>();
		lineas = getLines("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI1A\\Ficheros\\PI1Ej1DatosEntrada.txt");
		for(int i=0;i<lineas.size();i++) {
			List<Integer> list = new ArrayList<Integer>();
			list = leeFichero("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI1A\\Ficheros\\PI1Ej1DatosEntrada.txt", i);
			System.out.println("Datos de entrada: " + list);
			System.out.println("Datos de salida: " + cuadradoPar(list));
			System.out.println("========================================");
		}

	}

	public static List<Integer> cuadradoPar(List<Integer> list){
		List<Integer> listaCuadrados = new ArrayList<Integer>();
		int i = 0;
		int aux = 0;
		while(i<list.size()) {
			if(list.get(i)%2==0) {
				aux = list.get(i) * list.get(i);
				listaCuadrados.add(aux);
			}
			i++;
		}
		return listaCuadrados;
	}
	
	public static List<Integer> leeFichero(String s, int n){
		int x = 0;
		List<Integer> listInteger = new ArrayList<Integer>();
		List<String> listString = new ArrayList<String>();
		listString = getLines(s);
		String t[] = listString.get(n).split(",");
		if(listString.get(n).isBlank()) { 
			return listInteger;
		}else {
			while(x<t.length) {
				Integer valor = Integer.parseInt(t[x]);
				listInteger.add(valor);
				x++;
			}
			return listInteger;
		}
	}

}
