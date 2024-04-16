package CentroEducativo.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import CentroEducativo.entities.Profesor;
import CentroEducativo.entities.SuperEntidad;

public class SuperControlador {
	
	private static EntityManager em = null;
	private String nombreTabla = "";
	private Class tipoEntidad;
	
	public SuperControlador(String nombreTabla, Class tipoEntidad) {
		this.nombreTabla = nombreTabla;
		this.tipoEntidad = tipoEntidad;
	}
	
	/**
	 * 
	 * @return
	 */
	
	protected EntityManager getEntityManager() {
		if(em == null) em =  Persistence.createEntityManagerFactory("centroeducativo").createEntityManager();
		return em;
	}
	
	/**
	 * 
	 */
	
	public List<? extends SuperEntidad> findAll () {
		return (List<SuperEntidad>) 
		getEntityManager()
		.createNativeQuery("SELECT * FROM " + this.nombreTabla, this.tipoEntidad)
		.getResultList();
	}
	
	/**
	 * 
	 */
	public void remove(SuperEntidad e) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
	}
	
}
