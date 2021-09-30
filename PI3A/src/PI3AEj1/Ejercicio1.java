package PI3AEj1;

import java.io.PrintWriter;

import org.jgrapht.Graph;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.io.DOTExporter;
import org.jgrapht.io.IntegerComponentNameProvider;

import us.lsi.common.Files2;
import us.lsi.grafos.datos.Carretera;
import us.lsi.grafos.datos.Ciudad;
import us.lsi.graphcolors.GraphColors;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.GraphsReader;
import us.lsi.graphs.views.CompleteGraphView;
import us.lsi.graphs.views.SubGraphView;

public class Ejercicio1 {

	public static void main(String[] args) {

		//Lectura del fichero
		SimpleWeightedGraph<Ciudad, Carretera> grafoAndalucia = GraphsReader.newGraph
				("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI3A\\FicherosEntrada\\PI3Ej1DatosEntrada_andalucia.txt", 
						Ciudad::ofFormat, Carretera::ofFormat, Graphs2::simpleWeightedGraph, Carretera::getKm);

		SimpleWeightedGraph<Ciudad, Carretera> grafoCastilla = GraphsReader.newGraph
				("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI3A\\FicherosEntrada\\PI3Ej1DatosEntrada_castillalamancha.txt", 
						Ciudad::ofFormat, Carretera::ofFormat, Graphs2::simpleWeightedGraph, Carretera::getKm);

		//Apartado a)
		
		//Predicado 1
		
		//Andalucia
		Graph<Ciudad, Carretera> grafoAndaluciaApartAPred1 = SubGraphView.of(grafoAndalucia, v->v.getNombre().contains("e"),
				e->e.getKm()<100);
		DOTExporter<Ciudad, Carretera> de1 = new DOTExporter<Ciudad, Carretera>(new IntegerComponentNameProvider<>(),
				x -> x.getNombre(), 
				x -> String.format("%.2f",x.getKm()),
				e -> GraphColors.getColorIf(1, e, x -> x.getNombre().contains("u")),
				null
				);	
		PrintWriter f1 = Files2.getWriter("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI3A\\FicherosSalidaEj1\\grafoAndaluciaApartAPred1.gv");
		de1.exportGraph(grafoAndaluciaApartAPred1, f1);

		//Castilla
		Graph<Ciudad, Carretera> grafoCastillaApartAPred1 = SubGraphView.of(grafoCastilla, v->v.getNombre().contains("e"),
				e->e.getKm()<100);
		DOTExporter<Ciudad, Carretera> de2 = new DOTExporter<Ciudad, Carretera>(new IntegerComponentNameProvider<>(),
				x -> x.getNombre(), 
				x -> String.format("%.2f",x.getKm()),
				e -> GraphColors.getColorIf(1, e, x -> x.getNombre().contains("u")),
				null
				);	
		PrintWriter f2 = Files2.getWriter("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI3A\\FicherosSalidaEj1\\grafoCastillaApartAPred1.gv");
		de2.exportGraph(grafoCastillaApartAPred1, f2);

		//Predicado 2
		
		//Andalucia
		Graph<Ciudad, Carretera> grafoAndaluciaApartAPred2 = SubGraphView.of(grafoAndalucia, v->v.getHabitantes()<500000, 
				e->e.getKm()>150 && (e.getSource().getNombre().length()>=8 || e.getSource().getNombre().length()>=8));
		DOTExporter<Ciudad, Carretera> de3 = new DOTExporter<Ciudad, Carretera>(new IntegerComponentNameProvider<>(),
				x -> x.getNombre(), 
				x -> String.format("%.2f",x.getKm()),
				e -> GraphColors.getFilledColorIf(9, e, x -> x.getHabitantes() < 500000),
				e -> GraphColors.getStyleIf("bold", e, x -> x.getKm() < 200)
				);	
		PrintWriter f3 = Files2.getWriter("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI3A\\FicherosSalidaEj1\\grafoAndaluciaApartAPred2.gv");
		de3.exportGraph(grafoAndaluciaApartAPred2, f3);

		//Castilla
		Graph<Ciudad, Carretera> grafoCastillaApartAPred2 = SubGraphView.of(grafoCastilla, v->v.getHabitantes()<500000, 
				e->e.getKm()>150 && (e.getSource().getNombre().length()>=8 || e.getSource().getNombre().length()>=8));
		DOTExporter<Ciudad, Carretera> de4 = new DOTExporter<Ciudad, Carretera>(new IntegerComponentNameProvider<>(),
				x -> x.getNombre(), 
				x -> String.format("%.2f",x.getKm()),
				e -> GraphColors.getFilledColorIf(9, e, x -> x.getHabitantes() < 500000),
				e -> GraphColors.getStyleIf("bold", e, x -> x.getKm() < 200)
				);	
		PrintWriter f4 = Files2.getWriter("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI3A\\FicherosSalidaEj1\\grafoCastillaApartAPred2.gv");
		de4.exportGraph(grafoCastillaApartAPred2, f4);

		//Apartado b)
		
		//Andalucia
		Graph<Ciudad, Carretera> grafoAndaluciaApartB = CompleteGraphView.of(grafoAndalucia,
				Carretera::ofWeight,
				Double.valueOf(1000.),
				Carretera::getKm,
				Carretera::getSource,
				Carretera::getTarget);
		DOTExporter<Ciudad, Carretera> de5 = new DOTExporter<Ciudad, Carretera>(new IntegerComponentNameProvider<>(),
				x -> x.getNombre(), 
				x -> String.format("%.2f",x.getKm()) + "kms", 
				null,
				e -> GraphColors.getColorIf(6, e, x -> x.getKm() < 1000)
				);	
		PrintWriter f5 = Files2.getWriter("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI3A\\FicherosSalidaEj1\\grafoAndaluciaApartB.gv");
		de5.exportGraph(grafoAndaluciaApartB, f5);

		//Castilla
		Graph<Ciudad, Carretera> grafoCastillaApartB = CompleteGraphView.of(grafoCastilla,
				Carretera::ofWeight,
				Double.valueOf(1000.),
				Carretera::getKm,
				Carretera::getSource,
				Carretera::getTarget);
		DOTExporter<Ciudad, Carretera> de6 = new DOTExporter<Ciudad, Carretera>(new IntegerComponentNameProvider<>(),
				x -> x.getNombre(), 
				x -> String.format("%.2f",x.getKm()),
				null,
				e -> GraphColors.getColorIf(6, e, x -> x.getKm() < 1000)
				);	
		PrintWriter f6 = Files2.getWriter("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI3A\\FicherosSalidaEj1\\grafoCastillaApartB.gv");
		de6.exportGraph(grafoCastillaApartB, f6);

		//Apartado c)
		
		//Andalucia
		Graph<Ciudad, Carretera> grafoAndaluciaApartC = Graphs2.toDirectedWeightedGraph(grafoAndalucia,Carretera::reverse);
		DOTExporter<Ciudad, Carretera> de7 = new DOTExporter<Ciudad, Carretera>(new IntegerComponentNameProvider<>(),
				x -> x.getNombre(),
				(x -> x.getNombre() + "--" + String.format("%.2f",x.getKm()) + "kms"),
				e -> GraphColors.getFilledColor(4),
				null
				);	
		PrintWriter f7 = Files2.getWriter("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI3A\\FicherosSalidaEj1\\grafoAndaluciaApartC.gv");
		de7.exportGraph(grafoAndaluciaApartC, f7);

		//Castilla
		Graph<Ciudad, Carretera> grafoCastillaApartC = Graphs2.toDirectedWeightedGraph(grafoCastilla,Carretera::reverse);
		DOTExporter<Ciudad, Carretera> de8 = new DOTExporter<Ciudad, Carretera>(new IntegerComponentNameProvider<>(),
				x -> x.getNombre(), 
				(x -> x.getNombre() + "--" + String.format("%.2f",x.getKm()) + "kms"),
				e -> GraphColors.getFilledColor(4),
				null
				);	
		PrintWriter f8 = Files2.getWriter("C:\\Users\\Jorlu\\Desktop\\WS\\ADDA\\PI3A\\FicherosSalidaEj1\\grafoCastillaApartC.gv");
		de8.exportGraph(grafoCastillaApartC, f8);

	}

}
