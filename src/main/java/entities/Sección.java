package Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Seccion")
public class Sección {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSeccion;

	private int curso_id_curso;

	@ManyToOne
	@JoinColumn(name = "idProfesor", nullable = false)
	private Profesor profesor_id_profesor;

	public Sección() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sección(int idSeccion, int curso_id_curso, Profesor profesor_id_profesor) {
		super();
		this.idSeccion = idSeccion;
		this.curso_id_curso = curso_id_curso;
		this.profesor_id_profesor = profesor_id_profesor;
	}

	public int getIdSeccion() {
		return idSeccion;
	}

	public void setIdSeccion(int idSeccion) {
		this.idSeccion = idSeccion;
	}

	public int getCurso_id_curso() {
		return curso_id_curso;
	}

	public void setCurso_id_curso(int curso_id_curso) {
		this.curso_id_curso = curso_id_curso;
	}

	public Profesor getProfesor_id_profesor() {
		return profesor_id_profesor;
	}

	public void setDniPerson(Profesor profesor_id_profesor) {
		this.profesor_id_profesor = profesor_id_profesor;
	}

