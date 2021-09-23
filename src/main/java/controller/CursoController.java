package controller;

import entities.Curso;
import service.ICursoService;

import java.io.Serializable;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class CursoController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ICursoService cursoService;
    private String mensaje = "Error";
    private Curso curso;
    List<Curso> cursoList;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @PostConstruct
    public void init() {
        this.cursoList = new ArrayList<Curso>();
        this.curso = new Curso();
        this.listar();
    }

    public String newCurso() {
        this.setCurso(new Curso());
        return "Curso.xhtml";
    }

    public void insertar() {
        try {

            cursoService.insertar(curso);
            this.listar();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void eliminar(Curso curso) {
        try {
            cursoService.eliminar(curso.getId());
            listar();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void listar() {
        try {
            cursoList = cursoService.listar();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void modificar() {
        try {
            cursoService.modificar(this.curso);
            this.listar();

        } catch (Exception e) {
            e.getMessage();
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

}
