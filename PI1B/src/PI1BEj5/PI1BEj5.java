package PI1BEj5;

import java.util.ArrayList;
import java.util.List;

import us.lsi.common.Files2;
import us.lsi.common.Tuple;
import us.lsi.common.Tuple2;

public class PI1BEj5 extends Files2{

	public static void main(String[] args) {

		List<String> lineas = new ArrayList<String>();
		lineas = getLines("C:\\Users\\jorge\\Desktop\\WorkSpace\\ADDA Java\\PI1B\\Ficheros\\PI1Ej5DatosEntrada..txt");

		//Metodo Iterativo 
		int i = 0;

		System.out.println("Metodo Iterativo:");
		while(i<lineas.size()) {
			Tuple2<Integer, Integer> t1 = leeDiv(lineas, i);
			Tuple2<Integer, Integer> t11 = divisionRecursivoFinalLlamada(t1);
			System.out.println("Entrada: " + t1);
			System.out.println("Salida: " + t11);
			i++;
		}
		System.out.println("======================================================================");

		//Metodo Recusivo Final 
		int j = 0;

		System.out.println("Metodo Recusivo Final:");
		while(j<lineas.size()) {
			Tuple2<Integer, Integer> t2 = leeDiv(lineas, j);
			Tuple2<Integer, Integer> t22 = divisionRecursivoFinalLlamada(t2);
			System.out.println("Entrada: " + t2);
			System.out.println("Salida: " + t22);
			j++;
		}
		System.out.println("======================================================================");

		//Metodo Recusivo No Final
		int y = 0;

		System.out.println("Metodo Recusivo No Final:");
		while(y<lineas.size()) {
			Tuple2<Integer, Integer> t3 = leeDiv(lineas, y);
			Tuple2<Integer, Integer> t33 = divisionRecursivoNoFinalLlamada(t3);
			System.out.println("Entrada: " + t3);
			System.out.println("Salida: " + t33);
			y++;
		}
		System.out.println("======================================================================");

		//Metodo Funcional
		int z = 0;

		System.out.println("Metodo Funcional:");
		while(z<lineas.size()) {
			Tuple2<Integer, Integer> t4 = leeDiv(lineas, z);
			Tuple2<Integer, Integer> t44 = divisionFuncional(t4);
			System.out.println("Entrada: " + t4);
			System.out.println("Salida: " + t44);
			z++;
		}

	}

	//Metodo Iterativo 
	public static Tuple2<Integer, Integer> divisionIterativo(Tuple2<Integer, Integer> t){
		Tuple2<Integer, Integer> t1 = null;
		Integer a = t.v1;
		Integer b = t.v2;
		Integer c = 0;
		if(a<b) {
			t1 = Tuple.create(0, a);
		}else {
			while(a>=b) {
				c++;
				a = a-b;
			}
			t1 = Tuple.create(c, a);
		}
		return t1;
	}

	//Metodo Recusivo Final
	public static Tuple2<Integer, Integer> divisionRecursivoFinalLlamada(Tuple2<Integer, Integer> t) {
		Tuple2<Integer, Integer> t1 = null;
		Integer a = t.v1;
		Integer b = t.v2;
		Integer c = 0;
		return divisionRecursivoFinal(a, b, c, t1);
	}

	public static Tuple2<Integer, Integer> divisionRecursivoFinal(Integer a, Integer b, Integer c, Tuple2<Integer, Integer> t1){
		if(a<b) {
			t1 = Tuple.create(c, a);
		}else {
			t1 = divisionRecursivoFinal(a-b, b, c+1, t1);
		}
		return t1;
	}

	//Metodo Recusivo No Final
	public static Tuple2<Integer, Integer> divisionRecursivoNoFinalLlamada(Tuple2<Integer, Integer> t) {
		Integer a = t.v1;
		Integer b = t.v2;
		return divisionRecursivoNoFinal(a, b);
	}

	public static Tuple2<Integer, Integer> divisionRecursivoNoFinal(Integer a, Integer b){
		Tuple2<Integer, Integer> t1 = null;
		Integer c = 0;
		if(a<b) {
			t1 = Tuple.create(0, a);
		}else {
			t1 = divisionRecursivoNoFinal(a-b, b);	
			c = t1.v1+1;
			t1 = Tuple.create(c, t1.v2);
		}
		return t1;
	}

	//Metodo Funcional
	public static Tuple2<Integer, Integer> divisionFuncional(Tuple2<Integer, Integer> t){	
		Tuple2<Integer, Integer> t1 = Tuple.create(t.v1/t.v2, t.v1%t.v2);
		return t1;
	}

	//Funcion de lectura
	public static Tuple2<Integer, Integer> leeDiv(List<String> p, int i) {
		Tuple2<Integer, Integer> t = Tuple.create(0, 0);
		String k[] = p.get(i).split(",");
		Integer a = Integer.parseInt(k[0]);
		Integer b = Integer.parseInt(k[1]);
		t = Tuple.create(a, b);
		return t;
	}

}
