package CentroEducativo.controladores;

import java.util.Date;

import javax.persistence.EntityManager;
import CentroEducativo.entities.ValoracionMateria;

public class ControladorValoracion extends SuperControlador {
	private static ControladorValoracion instance = null;

	public ControladorValoracion() {
		super("valoracionmateria", ValoracionMateria.class);
	}

	public static ControladorValoracion getInstance() {
		if (instance == null)
			instance = new ControladorValoracion();
		return instance;
	}

	public ValoracionMateria filtraValoracion(int idEstudiante, int idProfesor, int idMateria) {
		try {
			return (ValoracionMateria) getEntityManager()
					.createNativeQuery(
							"SELECT * FROM valoracionmateria where " + "idEstudiante = " + idEstudiante
									+ " and  idProfesor = " + idProfesor + " and idMateria = " + idMateria,
							ValoracionMateria.class)
					.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 
	 * @param m
	 */
	
	public void update(ValoracionMateria e, int nota, Date fecha) {
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		e.setValoracion(nota);
		e.setFecha(fecha);
		em.merge(e);
		em.getTransaction().commit();
	}
	
	/**
	 * 
	 * @param e
	 */
	
	public void persist(int nota, int idEstudiante, int idProfesor, int idMateria, Date fecha) {
		ValoracionMateria vm = new ValoracionMateria();
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		vm.setValoracion(nota);
		vm.setIdEstudiante(idEstudiante);
		vm.setIdProfesor(idProfesor);
		vm.setIdMateria(idMateria);
		vm.setFecha(fecha);
		em.persist(vm);
		em.getTransaction().commit();
	}
}
