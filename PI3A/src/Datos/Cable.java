package Datos;

public class Cable {

	public static Cable of() {
		return new Cable();
	}

	public static Cable ofVertex(Camara c1, Camara c2) {
		return new Cable(c1,c2);
	}

	public static Cable ofFormat(Camara c1, Camara c2, String[] formato) {
		return new Cable(c1,c2,formato);
	}

	public static Cable ofWeight(Camara c1, Camara c2, Double m) {
		return new Cable(c1, c2, m);
	}
	
	public static Cable reverse(Cable c) {
		return new Cable(c.target, c.source, c.m);
	}

	private static int num =0;
	private Camara source;
	private Camara target;
	private Double m;
	private int id;

	private Cable(Camara c1, Camara c2) {
		this.source = c1;
		this.target = c2;
		this.m = 0.;
		this.id = num;
		num++;
	}
	
	private Cable() {
		this.source = null;
		this.target = null;
		this.m = 0.;
		num++;
	} 
	
	private Cable(Camara source, Camara target, Double m, String nombre) {
		super();
		this.source = source;
		this.target = target;
		this.m = m;
		this.id = num;
		num++;
	}

	private Cable(Camara c1, Camara c2, String[] nombre) {
		this.source = c1;
		this.target = c2;
		this.m = Double.parseDouble(nombre[2]);	
		this.id = num;
		num++;
	}
	
	private Cable(Camara c1, Camara c2, Double m) {
		this.source = c1;
		this.target = c2;
		this.m = m;
		this.id = num;
		num++;
	}

	public double getM() {
		return this.m;
	}

	
	public Camara getSource(){
		return source;
	}
	
	public Camara getTarget(){
		return target;
	}

	@Override
	public String toString() {
		return "Cable [source=" + source + ", target=" + target + ", m=" + m + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Cable))
			return false;
		Cable other = (Cable) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
