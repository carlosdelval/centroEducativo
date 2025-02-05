package CentroEducativo.controladores;

import javax.persistence.EntityManager;

import CentroEducativo.entities.Materia;

public class ControladorMateria extends SuperControlador{
	
	private static ControladorMateria instance = null;
	
	public ControladorMateria() {
		super("materia", Materia.class);
	}
	
	/**
	 * 
	 */
	
	public static ControladorMateria getInstance() {
		if(instance == null) instance = new ControladorMateria();
		return instance;
	}
}
