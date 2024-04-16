package CentroEducativo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="materia")
public class Materia extends SuperEntidad{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@JoinColumn(name="curso_id")
	private int cursoId;
	@Column(name="nombre")
	private String nombre;	
	@Column(name="acronimo")
	private String acronimo;
	
	
	public Materia() {
		super();
	}
	
	


	@Override
	public String toString() {
		return nombre;
	}




	public Materia(int id, int cursoId, String nombre, String acronimo) {
		super();
		this.id = id;
		this.cursoId = cursoId;
		this.nombre = nombre;
		this.acronimo = acronimo;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getCursoId() {
		return cursoId;
	}


	public void setCursoId(int cursoId) {
		this.cursoId = cursoId;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getAcronimo() {
		return acronimo;
	}


	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}
	
	
	
	
	
}
