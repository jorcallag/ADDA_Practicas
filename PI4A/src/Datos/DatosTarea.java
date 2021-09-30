package Datos;

import java.util.List;

public class DatosTarea {

	private static List<Tarea> TareasDisponibles;

	public static DatosTarea iniDatos(String fichero) {
		TareasDisponibles = Tarea.leeTareas(fichero);
		return new DatosTarea();
	}

	public static List<Tarea> getTareas() {
		return DatosTarea.TareasDisponibles;
	}

	public static Tarea getTarea(int index){
		return DatosTarea.getTareas().get(index);
	}

}
