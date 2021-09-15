package pe.edu.upc.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Profesor")
public class Profesor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_docente;
	
	@ManyToOne
	@JoinColumn(name = "Id_Usuario", nullable = false)
	private Usuario id_Usuario;

	public Profesor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profesor(int id_docente, Usuario id_Usuario) {
		super();
		this.id_docente = id_docente;
		this.id_Usuario = id_Usuario;
	}

	public int getId_docente() {
		return id_docente;
	}

	public void setId_docente(int id_docente) {
		this.id_docente = id_docente;
	}

	public Usuario getId_Usuario() {
		return id_Usuario;
	}

	public void setId_Usuario(Usuario id_Usuario) {
		this.id_Usuario = id_Usuario;
	}
	
}
