package Datos;

public class Relacion {
	
	public static Relacion of() {
		return new Relacion();
	}

	public static Relacion ofVertex(Usuario c1, Usuario c2) {
		return new Relacion(c1,c2);
	}

	public static Relacion ofFormat(Usuario c1, Usuario c2, String[] formato) {
		return new Relacion(c1,c2,formato);
	}
	
	public static Relacion reverse(Relacion c) {
		return new Relacion();
	}

	private static int num =0;
	private Usuario source;
	private Usuario target;
	private int id;

	private Relacion(Usuario c1, Usuario c2) {
		this.source = c1;
		this.target = c2;
		this.id = num;
		num++;
	}
	
	private Relacion() {
		this.source = null;
		this.target = null;
		this.id = num;
		num++;
	} 

	private Relacion(Usuario c1, Usuario c2, String[] nombre) {
		this.source = c1;
		this.target = c2;	
		this.id = num;
		num++;
	}
	
	public Usuario getSource(){
		return source;
	}
	
	public Usuario getTarget(){
		return target;
	}
	
	

	@Override
	public String toString() {
		return "Relacion [source=" + source + ", target=" + target + ", id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((target == null) ? 0 : target.hashCode());
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
		Relacion other = (Relacion) obj;
		if (id != other.id)
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (target == null) {
			if (other.target != null)
				return false;
		} else if (!target.equals(other.target))
			return false;
		return true;
	}



}
