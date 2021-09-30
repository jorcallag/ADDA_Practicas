package PI4AEj2;

import Datos.DatosTarea;
import us.lsi.bt.AlgoritmoBT;

public class Ejercicio2_Test_BT {

	public static void main(String[] args) {

		//Parametros del algoritmo
		AlgoritmoBT.conFiltro = false;
		AlgoritmoBT.metricasOK = true;

		//Datos del problema 1
		DatosTarea.iniDatos("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI4A\\ficheros\\PI4AEj2DatosEntrada1.txt");

		System.out.println(DatosTarea.getTareas());
		
		Ejercicio2_BT e1 = Ejercicio2_BT.createInitial();
		
		System.out.println("Problema Inicial 1: " + e1);
		
		AlgoritmoBT a1 = AlgoritmoBT.create(e1);
		
		a1.ejecuta();
		
		System.out.println("Solucion 1: " + a1.getSolucion());

		//Datos del problema 2

	}

}
