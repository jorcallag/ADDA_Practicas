package PI4AEj2;

import java.util.List;

import Datos.DatosTarea;
import us.lsi.pd.AlgoritmoPD.Sp;
import us.lsi.pd.AlgoritmoPD.Tipo;
import us.lsi.pd.ProblemaPDR;
import us.lsi.tareasyprocesadores.datos.Tarea;

public class Ejercicio2_PD implements ProblemaPDR<List<Tarea>, Integer, Ejercicio2_PD>{
	
	//Propiedades individuales basicas
	private int index;
	private List<Tarea> tareasAcumuladas;
	//Propiedades individuales derivadas
	
	public static Ejercicio2_PD createInitial() {
		return new Ejercicio2_PD(0, );
	}
	
	private Ejercicio2_PD(int index, Integer capacidadRestante, List<Tarea> tareasAcumuladas) {
		super();
		this.index = index;
		this.tareasAcumuladas = tareasAcumuladas;
	}

	private public Ejercicio2_PD(Ejercicio2_PD p, Integer a) {
		super();
		// lo utilizaremos para ek getSubproblema
	}

	@Override
	public Tipo getTipo() {
		// TODO Auto-generated method stub
		return Tipo.Min;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return DatosTarea.getTareas().size() - index;
	}

	@Override
	public boolean esCasoBase() {
		// TODO Auto-generated method stub
		return this.index == DatosTarea.getTareas().size();
	}

	@Override
	public Sp<Integer> getSolucionParcialCasoBase() {
		// TODO Auto-generated method stub
		return Sp.create(0, 0.0);
	}

	@Override
	public ProblemaPDR<S, A, P> getSubProblema(A a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sp<A> getSolucionParcialPorAlternativa(A a, Sp<A> s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> getAlternativas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public S getSolucionReconstruidaCasoBase(Sp<A> sp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public S getSolucionReconstruidaCasoRecursivo(Sp<A> sp, S s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ejercicio2_PD getSubProblema(Integer a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sp<Integer> getSolucionParcialPorAlternativa(Integer a, Sp<Integer> s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DatosTarea getSolucionReconstruidaCasoBase(Sp<Integer> sp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DatosTarea getSolucionReconstruidaCasoRecursivo(Sp<Integer> sp, DatosTarea s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DatosTarea getSolucionReconstruidaCasoBase(Sp<Integer> sp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DatosTarea getSolucionReconstruidaCasoBase(Sp<Integer> sp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DatosTarea getSolucionReconstruidaCasoBase(Sp<Integer> sp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capacidadRestante == null) ? 0 : capacidadRestante.hashCode());
		result = prime * result + index;
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
		Ejercicio2_PD other = (Ejercicio2_PD) obj;
		if (capacidadRestante == null) {
			if (other.capacidadRestante != null)
				return false;
		} else if (!capacidadRestante.equals(other.capacidadRestante))
			return false;
		if (index != other.index)
			return false;
		return true;
	}

	
}
