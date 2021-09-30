package PI1BEj4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import us.lsi.geometria.Punto2D;
import us.lsi.geometria.Punto2D.*;
import us.lsi.common.Files2;

public class PI1BEj4 extends Files2{

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		list = getLines("C:\\Users\\jorge\\Desktop\\WorkSpace\\ADDA Java\\PI1B\\Ficheros\\PI1Ej4DatosEntrada..txt");
		List<Punto2D> ls = new ArrayList<Punto2D>();
		ls = leeFichero(list);

		//Metodo Iterativo
		System.out.println("Metodo Iterativo:");
		System.out.println("Datos de entrada: " + ls);
		System.out.println("Datos de salida (Puntos en primer cuadrante): " + puntoContenidoIterativo
				(ls, p -> p.getCuadrante().equals(Cuadrante.PRIMER_CUADRANTE)));
		System.out.println("Datos de salida (Puntos en segundo cuadrante): " + puntoContenidoIterativo
				(ls, p -> p.getCuadrante().equals(Cuadrante.SEGUNDO_CUADRANTE)));
		System.out.println("Datos de salida (Puntos en tercer cuadrante): " + puntoContenidoIterativo
				(ls, p -> p.getCuadrante().equals(Cuadrante.TERCER_CUADRANTE)));
		System.out.println("Datos de salida (Puntos en cuarto cuadrante): " + puntoContenidoIterativo
				(ls, p -> p.getCuadrante().equals(Cuadrante.CUARTO_CUADRANTE)));
		System.out.println("======================================================================");
		
		//Metodo Recursivo Final
		System.out.println("Metodo Recursivo Final:");
		System.out.println("Datos de entrada: " + ls);
		System.out.println("Datos de salida (Puntos en primer cuadrante): " + puntoContenidoRecursivoFinalLlamada
				(ls, p -> p.getCuadrante().equals(Cuadrante.PRIMER_CUADRANTE)));
		System.out.println("Datos de salida (Puntos en segundo cuadrante): " + puntoContenidoRecursivoFinalLlamada
				(ls, p -> p.getCuadrante().equals(Cuadrante.SEGUNDO_CUADRANTE)));
		System.out.println("Datos de salida (Puntos en tercer cuadrante): " + puntoContenidoRecursivoFinalLlamada
				(ls, p -> p.getCuadrante().equals(Cuadrante.TERCER_CUADRANTE)));
		System.out.println("Datos de salida (Puntos en cuarto cuadrante): " + puntoContenidoRecursivoFinalLlamada
				(ls, p -> p.getCuadrante().equals(Cuadrante.CUARTO_CUADRANTE)));
		System.out.println("======================================================================");

		//Metodo Recursivo No Final
		System.out.println("Metodo Recursivo Final:");
		System.out.println("Datos de entrada: " + ls);
		System.out.println("Datos de salida (Puntos en primer cuadrante): " + puntoContenidoRecursivoNoFinalLlamada
				(ls, p -> p.getCuadrante().equals(Cuadrante.PRIMER_CUADRANTE)));
		System.out.println("Datos de salida (Puntos en segundo cuadrante): " + puntoContenidoRecursivoNoFinalLlamada
				(ls, p -> p.getCuadrante().equals(Cuadrante.SEGUNDO_CUADRANTE)));
		System.out.println("Datos de salida (Puntos en tercer cuadrante): " + puntoContenidoRecursivoNoFinalLlamada
				(ls, p -> p.getCuadrante().equals(Cuadrante.TERCER_CUADRANTE)));
		System.out.println("Datos de salida (Puntos en cuarto cuadrante): " + puntoContenidoRecursivoNoFinalLlamada
				(ls, p -> p.getCuadrante().equals(Cuadrante.CUARTO_CUADRANTE)));
		System.out.println("======================================================================");
		
		//Metodo Funcional
		System.out.println("Metodo Funcional:");
		System.out.println("Datos de entrada: " + ls);
		System.out.println("Datos de salida (Puntos en primer cuadrante): " + puntoContenidoFuncional
				(ls, p -> p.getCuadrante().equals(Cuadrante.PRIMER_CUADRANTE)));
		System.out.println("Datos de salida (Puntos en segundo cuadrante): " + puntoContenidoFuncional
				(ls, p -> p.getCuadrante().equals(Cuadrante.SEGUNDO_CUADRANTE)));
		System.out.println("Datos de salida (Puntos en tercer cuadrante): " + puntoContenidoFuncional
				(ls, p -> p.getCuadrante().equals(Cuadrante.TERCER_CUADRANTE)));
		System.out.println("Datos de salida (Puntos en cuarto cuadrante): " + puntoContenidoFuncional
				(ls, p -> p.getCuadrante().equals(Cuadrante.CUARTO_CUADRANTE)));
		
	}

	//Metodo Iterativo
	public static List<Punto2D> puntoContenidoIterativo(List<Punto2D> p, Predicate<Punto2D> s){
		List<Punto2D> list = new ArrayList<Punto2D>();
		int i=0;
		while(i<p.size()) {
			if(s.test(p.get(i))) {
				list.add(p.get(i));
			}
			i++;
		}
		return list;
	}

	//Metodo Recursivo Final
	public static List<Punto2D> puntoContenidoRecursivoFinalLlamada(List<Punto2D> p, Predicate<Punto2D> s){
		int i = 0;
		List<Punto2D> ls = new ArrayList<Punto2D>();
		return puntoContenidoRecursivoFinal(p, s, ls, i);
	}
	
	public static List<Punto2D> puntoContenidoRecursivoFinal(List<Punto2D> p, Predicate<Punto2D> s, List<Punto2D> ls, int i){
		if(i<p.size()) {
			if(s.test(p.get(i))) {
				ls.add(p.get(i));
			}
			puntoContenidoRecursivoFinal(p, s, ls, i+1);
		}
		return ls;
	}

	//Metodo Recursivo No Final
	public static List<Punto2D> puntoContenidoRecursivoNoFinalLlamada(List<Punto2D> p, Predicate<Punto2D> s){
		int i = 0;
		return puntoContenidoRecursivoNoFinal(p, s, i);
	}
	
	public static List<Punto2D> puntoContenidoRecursivoNoFinal(List<Punto2D> p, Predicate<Punto2D> s, int i){
		List<Punto2D> ls = new ArrayList<Punto2D>();
		if(i==p.size()) {
			return ls;
		}else {
			ls = puntoContenidoRecursivoNoFinal(p, s, i+1);
			if(s.test(p.get(i))) {
				ls.add(p.get(i));
			}
		}
		return ls;
	}
	
	//Metodo Funcional
	public static List<Punto2D> puntoContenidoFuncional(List<Punto2D> p, Predicate<Punto2D> s){
		return p.stream().filter(s).collect(Collectors.toList());
	}

	//Funcion de lectura
	public static List<Punto2D> leeFichero(List<String> ls){
		List<Punto2D> listP = new ArrayList<Punto2D>();
		int i=0;
		while(i<ls.size()) {
			String t[] = ls.get(i).split(",");
			String r0 = t[0].replaceAll("[()]", "");
			Double valor0 = Double.parseDouble(r0);
			String r1 = t[1].replaceAll("[()]", "");
			Double valor1 = Double.parseDouble(r1);
			Punto2D p = Punto2D.create(valor0, valor1);
			listP.add(p);
			i++;
		}
		return listP;
	}
}
