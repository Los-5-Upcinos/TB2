package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

@Entity
@Table(name = "Material")
public class Material implements Serializable {

    private static final long serialVersionUID = 1L;

    static Logger logger = Logger.getLogger(Material.class.getName());

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "post", columnDefinition = "TEXT")
    private String post;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    public Material() {
        super();
    }

    @PrePersist
    public void logActionsInPrePersist() {
        logger.log(Level.INFO, String.format("@PrePersist: %s", this));
    }

    @PostPersist
    public void logActionsInPostPersist() {
        logger.log(Level.INFO, String.format("@PostPersist: %s", this));
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}