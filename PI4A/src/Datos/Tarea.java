package Datos;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import us.lsi.common.Streams2;

public class Tarea {
	
	public static List<Tarea> leeTareas(String fichero){
        nCodigo =0;
        tareas = Streams2.fromFile(fichero).map(s ->Tarea.create(s)).collect(Collectors.toList());
        return tareas;
    }
	
	public static Tarea create(LocalTime horaInicio, LocalTime duracion, Integer ganancia) {
		return new Tarea(horaInicio, duracion, ganancia);
	}

	public static Tarea create(String s) {
		return new Tarea(s);
	}

	private static Integer nCodigo = 0;

	private Integer codigo;
	private LocalTime horaInicio;
	private LocalTime duracion;
	private Integer ganancia;
	
	static List<Tarea> tareas;

	Tarea(LocalTime horaInicio, LocalTime duracion, Integer ganancia){
		this.codigo = nCodigo;
		nCodigo++;
		this.horaInicio = horaInicio;
		this.duracion = duracion;
		this.ganancia = ganancia;
	}	

	Tarea(String r){		
		String[] s = r.split(",");
		horaInicio = LocalTime.parse(s[0]);
		duracion = LocalTime.parse(s[1]);
		ganancia = Integer.parseInt(s[2]);
		this.codigo = nCodigo;
		nCodigo++;	
	}	

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public LocalTime getDuracion() {
		return duracion;
	}

	public Integer getGanancia() {
		return ganancia;
	}

	@Override
	public String toString() {
		return "(" + horaInicio + ", " + duracion + ", " + ganancia + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((duracion == null) ? 0 : duracion.hashCode());
		result = prime * result + ((ganancia == null) ? 0 : ganancia.hashCode());
		result = prime * result + ((horaInicio == null) ? 0 : horaInicio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarea other = (Tarea) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (duracion == null) {
			if (other.duracion != null)
				return false;
		} else if (!duracion.equals(other.duracion))
			return false;
		if (ganancia == null) {
			if (other.ganancia != null)
				return false;
		} else if (!ganancia.equals(other.ganancia))
			return false;
		if (horaInicio == null) {
			if (other.horaInicio != null)
				return false;
		} else if (!horaInicio.equals(other.horaInicio))
			return false;
		return true;
	}

}
