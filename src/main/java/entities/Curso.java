package pe.edu.upc.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Curso")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_curso;
	
	@Column(name = "fecha_inicio", length = 45, nullable = false)
	private Date fecha_inicio;

	@Column(name = "fecha_fin", length = 45, nullable = false)
	private Date fecha_fin;

	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Curso(int id_curso, Date fecha_inicio, Date fecha_fin) {
		super();
		this.id_curso = id_curso;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
	}

	public int getId_curso() {
		return id_curso;
	}

	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	

}
