package entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.*;

@Entity
@Table(name = "Curso")
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;

    static Logger logger = Logger.getLogger(Curso.class.getName());

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fecha_inicio")
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDateTime fechaFin;

    @OneToMany(mappedBy = "curso", orphanRemoval = false, fetch = FetchType.EAGER)
    private List<Material> materials;

    public Curso() {
    }

    @PrePersist
    public void logActionsInPrePersist() {
        logger.log(Level.INFO, String.format("@PrePersist: %s", this));
    }

    @PostPersist
    public void logActionsInPostPersist() {
        logger.log(Level.INFO, String.format("@PostPersist: %s", this));
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    public void addMaterial(Material material) {
        List<Material> materialList = this.getMaterials();
        materialList.add(material);
        this.materials = materialList;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
