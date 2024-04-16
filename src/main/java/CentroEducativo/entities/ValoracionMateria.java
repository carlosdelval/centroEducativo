package CentroEducativo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="valoracionmateria")
public class ValoracionMateria extends SuperEntidad{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="idProfesor")
	private int idProfesor;
	@Column (name="idEstudiante")
	private int idEstudiante;
	@Column(name="idMateria")
	private int idMateria;
	@Column(name="valoracion")
	private int valoracion;

	public ValoracionMateria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValoracionMateria(int id, int idProfesor, int idEstudiante, int idMateria, int valoracion) {
		super();
		this.id = id;
		this.idProfesor = idProfesor;
		this.idEstudiante = idEstudiante;
		this.idMateria = idMateria;
		this.valoracion = valoracion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
	}

	public int getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public int getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}
	
}
