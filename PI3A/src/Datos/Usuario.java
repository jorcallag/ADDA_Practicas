package Datos;

public class Usuario {
	
	public static Usuario of() {
		return new Usuario("");
	}

	public static Usuario ofFormat(String[] formato) {
		return new Usuario(formato);
	}

	public static Usuario ofName(String nombre) {
		return new Usuario(nombre);
	}
	
	private String nombre;
	private String grupo;

	private Usuario(String nombre) {
		super();
		this.nombre = nombre;
		this.grupo = null;
	}

	private Usuario(String[] formato){
		super();
		this.nombre = formato[0];
		this.grupo = formato[1];
	}
	
	public String getGrupo() {
		return grupo;
	}
	public String getNombre() {
		return nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Usuario other = (Usuario) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.nombre;
	}

}
