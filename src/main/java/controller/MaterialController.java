package controller;

import entities.Curso;
import entities.Material;
import service.ICursoService;
import service.IMaterialService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
@RequestScoped
public class MaterialController implements Serializable {

    private static final long serialVersionUID = 1L;

    static Logger logger = Logger.getLogger(MaterialController.class.getName());

    @Inject
    private IMaterialService materialService;
    @Inject
    private ICursoService cursoService;

    private String mensaje = "Error";
    private Material material;
    private List<Material> materiales;

    private Curso curso;
    private Integer idCurso;
    private List<Curso> listaCursos;
    private String operationStatusMessage = null;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @PostConstruct
    public void init() {
        this.materiales = new ArrayList<>();
        this.material = new Material();
        this.listaCursos = new ArrayList<>();
        this.curso = new Curso();
        this.listar();
        this.listarCursos();
    }

    public String newMaterial() {
        this.material = new Material();
        return "material";
    }
    public String PestanaMaterial(Material material)
    {
        this.material = material;
        return "materialMOD.xhtml";
    }
    public String insertar() {
        try {
            this.curso = this.cursoService.detalle(idCurso);
            material.setCurso(curso);
            boolean operationStatus = materialService.insertar(material);
            if (operationStatus) {
                operationStatusMessage = "¡Se ha registrado el material con éxito!";
            } else {
                operationStatusMessage = "¡Algo fallo al registrar el material!";
            }
            return "listarMaterial.xhtml";
        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage(), e.getCause());
            return "material";
        }
    }

    public void eliminar(Material material) {
        try {
            materialService.eliminar(material.getId());
            this.listar();
        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage(), e.getCause());
        }
    }

    public void listar() {
        try {
            this.materiales = materialService.listar();
        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage(), e.getCause());
        }
    }

    public void listarCursos() {
        try {
            listaCursos = cursoService.listar();
        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage(), e.getCause());
        }
    }

    public void modificar() {
        try {
            this.curso = this.cursoService.detalle(idCurso);
            material.setCurso(curso);
            materialService.modificar(this.material);
        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage(), e.getCause());
        }
    }


    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public String getOperationStatusMessage() {
        return operationStatusMessage;
    }

    public void setOperationStatusMessage(String operationStatusMessage) {
        this.operationStatusMessage = operationStatusMessage;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Material> getMateriales() {
        return materiales;
    }

    public void setMateriales(List<Material> materiales) {
        this.materiales = materiales;
    }

    public List<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }
}
