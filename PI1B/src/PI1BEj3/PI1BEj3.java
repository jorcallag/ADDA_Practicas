package PI1BEj3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import us.lsi.common.Files2;

public class PI1BEj3 extends Files2{

	public static void main(String[] args) {

		List<String> listString = new ArrayList<String>();
		listString = getLines("C:\\Users\\jorge\\Desktop\\WorkSpace\\ADDA Java\\PI1B\\Ficheros\\PI1Ej3DatosEntrada.txt");

		//Metodo Iterativo 
		int i=0, n=0; 

		System.out.println("Metodo Iterativo:");
		while(i<listString.size()) {
			System.out.println("¿Es " + listString.get(i) + " un palindromo? " + esPalindromoIterativo(listString.get(i)));
			if(esPalindromoIterativo(listString.get(i))==true) {
				n = n+1;
			}
			i++;
		}
		System.out.println("Hay " + n + " palindromos de " + listString.size() + " palabras");
		System.out.println("======================================================================");

		//Metodo Recusivo Final
		int y=0, b=0; 

		System.out.println("Metodo Recursivo Final:");
		while(y<listString.size()) {
			System.out.println("¿Es " + listString.get(y) + " un palindromo? " + esPalindromoRecursivoFinalLlamada(listString.get(y)));
			if(esPalindromoRecursivoFinalLlamada(listString.get(y))==true) {
				b = b+1;
			}
			y++;
		}
		System.out.println("Hay " + b + " palindromos de " + listString.size() + " palabras");
		System.out.println("======================================================================");

		//Metodo Recusivo No Final
		int z=0, a=0; 

		System.out.println("Metodo Recursivo No Final:");
		while(z<listString.size()) {
			System.out.println("¿Es " + listString.get(z) + " un palindromo? " + esPalindromoRecursivoNoFinalLlamada(listString.get(z)));
			if(esPalindromoRecursivoNoFinalLlamada(listString.get(z))==true) {
				a = a+1;
			}
			z++;
		}
		System.out.println("Hay " + a + " palindromos de " + listString.size() + " palabras");
		System.out.println("======================================================================");

		//Metodo Funcional
		int j=0, m=0;

		System.out.println("Metodo Funcional:");
		while(j<listString.size()) {
			System.out.println("¿Es " + listString.get(j) + " un palindromo? " + esPalindromoFuncional(listString.get(j)));
			if(esPalindromoFuncional(listString.get(j))==true) {
				m = m+1;
			}
			j++;
		}
		System.out.println("Hay " + m + " palindromos de " + listString.size() + " palabras");
	}

	//Metodo iterativo 
	public static boolean esPalindromoIterativo(String p) {
		boolean b = true;
		int i=0;
		int j= p.length()-1;
		while(j-i>=0 && b) {
			b = p.charAt(i) == p.charAt(j);
			i++;
			j--;
		}
		return b;
	}

	//Metodo Recursivo Final
	public static boolean esPalindromoRecursivoFinalLlamada(String p) {
		int i = 0;
		int j= p.length()-1;
		boolean b = true;
		return esPalindromoRecursivoFinal(p, i, j, b);
	}

	public static boolean esPalindromoRecursivoFinal(String p, int i, int j, boolean b) {	
		if(j-i>=0 && b) {
			b = esPalindromoRecursivoFinal(p, i+1, j-1, p.charAt(i) == p.charAt(j));
		}
		return b;
	}

	//Metodo Recursivo No Final
	public static boolean esPalindromoRecursivoNoFinalLlamada(String p) {
		int i = 0;
		int j= p.length()-1;
		return esPalindromoRecursivoNoFinal(p, i, j);
	}

	public static boolean esPalindromoRecursivoNoFinal(String p, int i, int j) {
		boolean b = true;
		if(j-i>=0) {
			b = esPalindromoRecursivoNoFinal(p, i+1, j-1);
			if(b) {
				b = p.charAt(i) == p.charAt(j);
			}
		}
		return b;
	}

	//Metodo Funcional
	public static boolean esPalindromoFuncional(String p) {
		return IntStream.range(0, p.length()/2).allMatch(i-> p.charAt(i) == p.charAt(p.length()-i-1));
	}

}
