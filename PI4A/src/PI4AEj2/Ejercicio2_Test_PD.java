package PI4AEj2;

import Datos.DatosTarea;
import us.lsi.pd.AlgoritmoPD;

public class Ejercicio2_Test_PD {

	public static void main(String[] args){

		//Parametros del algoritmo
		AlgoritmoPD.isRandomize = false;
		AlgoritmoPD.conFiltro = false;
		AlgoritmoPD.metricasOK = true;

		//Datos del problema 1
		DatosTarea.iniDatos("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI4A\\ficheros\\PI4AEj2DatosEntrada1.txt");
		
		System.out.println(DatosTarea.getTareas());

		Ejercicio2_PD p1 = Ejercicio2_PD.createInitial();

		System.out.println("Problema Inicial 1: " + p1);

		AlgoritmoPD<DatosTarea, Integer, Ejercicio2_PD> a1 = AlgoritmoPD.createPDR(p1); 

		a1.ejecuta();

		a1.showAllGraph("ficheros/Ejercicio2_1_PD.gv", "Ejercicio2_1_PD");

		System.out.println("Solucion 1: " + a1.getSolucion());

		//Datos del problema 2

	}

}
