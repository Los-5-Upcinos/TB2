package pe.edu.upc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Material")
public class Material {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_material;
	
	@Column(name = "post", nullable = false, length = 150)
	private String post;

	@ManyToOne
	@JoinColumn(name = "id_curso", nullable = false)
	private Curso curso;

	public Material() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Material(int id_material, String post, Curso curso) {
		super();
		this.id_material = id_material;
		this.post = post;
		this.curso = curso;
	}

	public int getId_material() {
		return id_material;
	}

	public void setId_material(int id_material) {
		this.id_material = id_material;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
}
