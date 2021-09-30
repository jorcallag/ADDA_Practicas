package PI3BEj6_AG;

import java.time.LocalTime;
import java.util.List;

import us.lsi.ag.ValuesInRangeChromosome;
import us.lsi.ag.ValuesInRangeProblemAG;

public class DatosTarea_AG implements ValuesInRangeProblemAG<Integer, List<Integer>>{

	private static List<Tarea_AG> TareasDisponibles;

	public static DatosTarea_AG iniDatos(String fichero) {
		TareasDisponibles = Tarea_AG.leeTareas(fichero);
		return new DatosTarea_AG();
	}

	public static List<Tarea_AG> getTareas() {
		return DatosTarea_AG.TareasDisponibles;
	}

	public static Tarea_AG getTarea(int index){
		return DatosTarea_AG.getTareas().get(index);
	}

	public List<Integer> getSolucion(ValuesInRangeChromosome<Integer> chromosome) {
		return chromosome.decode();
	}

	public Integer getVariableNumber(){
		return TareasDisponibles.size();
	}

	public Double fitnessFunction(ValuesInRangeChromosome<Integer> chromosome) {
		List<Integer> ls = chromosome.decode();
		Integer compatibilidad = compatibilidad(ls);
		Integer ganancias = ganancias(ls);

		return (double) ganancias - compatibilidad*1000;
	}

	public static Integer ganancias(List<Integer> ls) {
		Integer ganancias = 0;
		for(int i=0; i<ls.size(); i++) {
			if(ls.get(i) == 1) {
				ganancias = ganancias + TareasDisponibles.get(i).getGanancia();
			}
		}
		return ganancias;
	}

	public static Integer compatibilidad(List<Integer> ls) {
		Integer cont = 0;
		for(int i = 0; i<ls.size(); i++) {
			if(ls.get(i) == 1) {
				Tarea_AG x = DatosTarea_AG.getTarea(i);
				LocalTime horaInicio1 = x.getHoraInicio();
				LocalTime horaFin1 = horaInicio1.plusHours((x.getDuracion().getHour())).plusMinutes(x.getDuracion().getMinute());
				for(int y = i + 1; y<ls.size(); y++) {
					if(ls.get(y) == 1) {
						Tarea_AG a = DatosTarea_AG.getTarea(y);
						LocalTime horaInicio2 = a.getHoraInicio();
						if(horaFin1.compareTo(horaInicio2) > 0) {
							cont = cont + 1;
						}
					}
				}
			}
		}
		return cont;
	}

	public Integer getMax(Integer i) {
		return 2;
	}

	public Integer getMin(Integer i) {
		return 0;
	}

}
