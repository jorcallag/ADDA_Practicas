package PI2AEj1;

import java.util.ArrayList;
import java.util.List;

import us.lsi.common.Files2;

public class Ejercicio1 extends Files2{

	public static void main(String[] args) {

		int u = 0;
		int i = 0;
		int j = 0;
		List<String> listString = new ArrayList<String>();
		listString = getLines("C:\\Users\\jorge\\Desktop\\WorkSpace\\ADDA Java\\PI2A\\Ficheros\\PI2Ej1DatosEntrada.txt");

		while(u<listString.size()) {
			int res[][] = leeArrayFichero(listString, u);
			System.out.println("La matriz:");
			for (i = 0; i < res.length; i++) { 
				for (j = 0; j < res.length; j++) {
					System.out.print(res[i][j] + " ");
				}
				System.out.println();
			}
			boolean b = cumplePropiedadLlamada(res);
			if(b == true) {
				System.out.println("Cumple la propiedad");
			}else {
				System.out.println("No cumple la propiedad");
			}
			u++;
		}

	}

	//Recursivo
	public static boolean cumplePropiedadLlamada(int[][] matriz) {
		boolean res = true;
		int a = matriz.length-1;
		int b = matriz.length-1;
		int c = 0;
		int d = 0;
		return cumplePropiedad(matriz, res, a, b, c, d);
	}

	public static boolean cumplePropiedad(int[][] matriz, boolean res, int a, int b, int c, int d) {
		if(a<=c && b<=d || res == false) {
			return res;
		}else {
			if(matriz[c][d] > matriz[a][b]) {
				res = false;
			}else {
				res = cumplePropiedad(matriz, res, a-2, b-2, c, d);
				res = cumplePropiedad(matriz, res, a-2, b, c, d+2);
				res = cumplePropiedad(matriz, res, a, b-2, c+2, d);
				res = cumplePropiedad(matriz, res, a, b, c+2, d+2);
			}
		}
		return res;
	}

	//Funcion de lectura
	public static int[][] leeArrayFichero(List<String> lista, int e){
		int i = 0;
		int j = 0;;
		String[] t1 = lista.get(e).split(",");
		int[][] res = new int[t1.length][t1.length];
		while(i<t1.length){
			String[] t2 = t1[i].split(" ");
			j = 0;
			while(j<t2.length){
				String n0 = t2[j].replaceAll("[^0-9]", "");
				int n = Integer.parseInt(n0);
				res[i][j] = n;
				j++;
			}
			i++;
		}
		return res;
	}

}


