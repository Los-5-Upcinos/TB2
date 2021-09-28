package controller;

import java.io.Serializable;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entities.Curso;
import service.ICursoService;

@Named
@RequestScoped
public class CursoController implements Serializable {

    private static final long serialVersionUID = 1L;

    static Logger logger = Logger.getLogger(CursoController.class.getName());

    @Inject
    private ICursoService cursoService;
    private String mensaje = "Error";
    private Curso curso;
    private List<Curso> cursoList;
    private Date fechaInicioDate;
    private Date fechaFinDate;
    private String operationStatusMessage = null;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @PostConstruct
    public void init() {
        this.cursoList = new ArrayList<>();
        this.curso = new Curso();
        this.setCurso(new Curso());
        this.listar();
    }

    public String newCurso() {
        this.setCurso(new Curso());
        return "curso.xhtml";
    }

    public String PestañaCurso(Curso curso)
    {
        this.curso = curso;
        return "cursoMOD.xhtml";
    }

    public String insertar() {
        try {
            curso.setFechaInicio(fechaInicioDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
            curso.setFechaFin(fechaFinDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
            boolean operationStatus = cursoService.insertar(curso);
            if (operationStatus) {
                operationStatusMessage = "¡Se ha registrado el curso con éxito!";
            } else {
                operationStatusMessage = "¡Algo fallo al registrar el curso!";
            }
            this.listar();
            return "listarCursos";
        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage(), e.getCause());
            return "curso";
        }
    }

    public void eliminar(Curso curso) {
        try {
            cursoService.eliminar(curso.getId());
            listar();
        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage(), e.getCause());
        }
    }

    public void listar() {
        try {
            cursoList = cursoService.listar();
        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage(), e.getCause());
        }
    }

    public String modificar() {
        try {
            curso.setFechaInicio(fechaInicioDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
            curso.setFechaFin(fechaFinDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
            boolean operationStatus =  cursoService.modificar(curso);
            if (operationStatus)
            {
                operationStatusMessage = "¡Se ha modificado el curso con éxito!";
            }
            else
            {
                operationStatusMessage = "¡Hay problemas en la modificacion!";
            }
            this.listar();
            return "listarCursos";

        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage(), e.getCause());
            return "curso";

        }
    }

    public void detalle(int idCurso) {
        try {
            curso = this.cursoService.detalle(idCurso);
        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage(), e.getCause());
        }
    }



    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Curso> getCursoList() {
        return cursoList;
    }

    public void setCursoList(List<Curso> cursoList) {
        this.cursoList = cursoList;
    }

    public String getOperationStatusMessage() {
        return operationStatusMessage;
    }

    public void setOperationStatusMessage(String operationStatusMessage) {
        this.operationStatusMessage = operationStatusMessage;
    }

    public Date getFechaFinDate() {
        return fechaFinDate;
    }

    public void setFechaFinDate(Date fechaFinDate) {
        this.fechaFinDate = fechaFinDate;
    }

    public Date getFechaInicioDate() {
        return fechaInicioDate;
    }

    public void setFechaInicioDate(Date fechaInicioDate) {
        this.fechaInicioDate = fechaInicioDate;
    }
}
