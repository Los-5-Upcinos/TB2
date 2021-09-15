package pe.edu.upc.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Seccion")
public class Seccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_seccion;

	@ManyToOne
	@JoinColumn(name = "id_curso", nullable = false)
	private Curso curso;

	@ManyToOne
	@JoinColumn(name = "id_docente", nullable = false)
	private Profesor profesor;

	public Seccion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Seccion(int id_seccion, Curso curso, Profesor profesor) {
		super();
		this.id_seccion = id_seccion;
		this.curso = curso;
		this.profesor = profesor;
	}

	public int getId_seccion() {
		return id_seccion;
	}

	public void setId_seccion(int id_seccion) {
		this.id_seccion = id_seccion;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	
	
}
