package PI1AEj2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import us.lsi.common.Files2;

public class Ejercicio2 extends Files2{

	public static void main(String[] args) {
		
		List<String> listString = new ArrayList<String>();
		listString = getLines("C:\\Users\\jorge\\Desktop\\WorkSpace\\ADDA Java\\PI1A\\Ficheros\\PI1Ej2DatosEntrada.txt");
		System.out.println("Datos de entrada: "+listString);
		System.out.println("Datos de salida: "+mapeaLista(listString));

	}
	
	public static Map<Integer,List<String>> mapeaLista(List<String> cadenas){
		Map<Integer, List<String>> MapaL = new HashMap<Integer, List<String>>();
		int i = 0;
		while(i<cadenas.size()) {
			int aux = cadenas.get(i).length();
			if(!MapaL.containsKey(aux)) {
				List<String> list = new ArrayList<String>();
				list.add(cadenas.get(i));
				MapaL.put(aux, list); 
			}else {
				MapaL.get(aux).add(cadenas.get(i));
			}
			i++;
		}
		return MapaL;
	}

}
