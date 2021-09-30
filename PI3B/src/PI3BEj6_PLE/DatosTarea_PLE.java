package PI3BEj6_PLE;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import us.lsi.common.Streams2;

public class DatosTarea_PLE {

	private static List<Tarea_PLE> TareasDisponibles;

	public static void iniDatos(String fichero) {
		TareasDisponibles = Streams2.fromFile(fichero)
				.<Tarea_PLE> map((String s) -> Tarea_PLE.create(s))
				.collect(Collectors.<Tarea_PLE> toList());
	}

	public static List<Tarea_PLE> getTareas() {
		return TareasDisponibles;
	}

	public static Tarea_PLE getTarea(int index){
		return DatosTarea_PLE.getTareas().get(index);
	}

	public static Boolean restricciones(Integer c) {
		return c >=0;
	}

	public static String getConstraints(String fichero){

		DatosTarea_PLE.iniDatos(fichero);
		int num = DatosTarea_PLE.TareasDisponibles.size();
		String r = "";
		r = r + "max: ";
		for(int i = 0; i<num; i++){
			if (i!=0) r = r + "+";
			r = r + String.format("%d*x%d ", DatosTarea_PLE.getTarea(i).getGanancia(), i);
		}		
		r = r+";\n\n";

		for(int i = 0; i<num; i++){
			Tarea_PLE x = DatosTarea_PLE.getTarea(i);
			List<Integer> incompatibles = compatibilidad(x, num, i);
			if(incompatibles.size()>=2) {
				for(int y = 1; y<incompatibles.size(); y++) {
					r = r + String.format("x%d", incompatibles.get(0));
					if (y!=0) r = r + " +";
					r = r + String.format("x%d", incompatibles.get(y));
					r = r + " <= "+ 1 +";\n";
				}
				
			}
		}
		r = r+"\n";
		
		r = r +"bin ";
		for(int i =0;i<num;i++){
			if (i!=0) r = r+", ";
			r = r + String.format("x%d",i);
		}
		r = r+";\n";		
		return r;
	}

	public static List<Integer> compatibilidad(Tarea_PLE x, int num, int i) {
		List<Integer> incompatibles = new ArrayList<Integer>();
		LocalTime horaInicio1 = x.getHoraInicio();
		LocalTime horaFin1 = horaInicio1.plusHours((x.getDuracion().getHour())).plusMinutes(x.getDuracion().getMinute());
		for(int y = i; y<num; y++) {
			Tarea_PLE a = DatosTarea_PLE.getTarea(y);
			LocalTime horaInicio2 = a.getHoraInicio();
			LocalTime horaFin2 = horaInicio2.plusHours((a.getDuracion().getHour())).plusMinutes(a.getDuracion().getMinute());
			if(!((horaInicio2.isBefore(horaInicio1.plusMinutes(1)) && horaInicio2.isBefore(horaFin1.minusMinutes(1)) &&
					horaFin2.isBefore(horaInicio1.plusMinutes(1)) && horaFin2.isBefore(horaFin1.minusMinutes(1))) || 
					horaInicio2.isAfter(horaInicio1.plusMinutes(1)) && horaInicio2.isAfter(horaFin1.minusMinutes(1)) && 
					horaFin2.isAfter(horaInicio1.plusMinutes(1)) && horaFin2.isAfter(horaFin1.minusMinutes(1)))) {
				incompatibles.add(y);
			}
		}
		return incompatibles;
	}

}
