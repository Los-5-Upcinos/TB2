package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Estudiante")
public class Estudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_estudiante;
	
	@Column(name = "nameEstudiante", length = 45, nullable = false)
	private String nameEstudiante;

	@Column(name = "adressEstudiante", nullable = false, length = 60)
	private String adressEstudiante;
	
	@Column(name = "emailEstudiante", nullable = false, length = 60)
	private String emailEstudiante;
	
	private Date birthDateEstudiante;

	public Estudiante() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Estudiante(int id_estudiante, String nameEstudiante, String adressEstudiante, String emailEstudiante,
			Date birthDateEstudiante) {
		super();
		this.id_estudiante = id_estudiante;
		this.nameEstudiante = nameEstudiante;
		this.adressEstudiante = adressEstudiante;
		this.emailEstudiante = emailEstudiante;
		this.birthDateEstudiante = birthDateEstudiante;
	}

	public int getId_estudiante() {
		return id_estudiante;
	}

	public void setId_estudiante(int id_estudiante) {
		this.id_estudiante = id_estudiante;
	}

	public String getNameEstudiante() {
		return nameEstudiante;
	}

	public void setNameEstudiante(String nameEstudiante) {
		this.nameEstudiante = nameEstudiante;
	}

	public String getAdressEstudiante() {
		return adressEstudiante;
	}

	public void setAdressEstudiante(String adressEstudiante) {
		this.adressEstudiante = adressEstudiante;
	}

	public String getEmailEstudiante() {
		return emailEstudiante;
	}

	public void setEmailEstudiante(String emailEstudiante) {
		this.emailEstudiante = emailEstudiante;
	}

	public Date getBirthDateEstudiante() {
		return birthDateEstudiante;
	}

	public void setBirthDateEstudiante(Date birthDateEstudiante) {
		this.birthDateEstudiante = birthDateEstudiante;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_estudiante;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudiante other = (Estudiante) obj;
		if (id_estudiante != other.id_estudiante)
			return false;
		return true;
	}
}
