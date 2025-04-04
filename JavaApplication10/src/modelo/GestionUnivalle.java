package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Hernan Medina
 */
public class GestionUnivalle {
    
    private List<Profesor> profesores = new ArrayList<>();
    private List<Curso> cursos = new ArrayList<>();
    
    public void registrarProfesor(Profesor profesor){
        profesores.add(profesor);
    }
    public Profesor buscarProfesor(int Cedula){
         for (Profesor profesor : profesores) {
            if (profesor.getNumCedula() == Cedula) {
                return profesor;
            }
        }
        return null;
    }
    
    public void atualizarProfesor(int cedula, String nombre, String apellido, String profecion){
        Profesor p = buscarProfesor(cedula);
        if (p != null){
            p.setNombre(nombre);
            p.setApellido(apellido);
            p.setProfesion(profecion);
        }
    }
     
    public boolean eliminarProfesor(int cedula) {
        return profesores.removeIf(profesor -> profesor.getNumCedula() == cedula);
    }

    
   public String listarCursos() {
        StringBuilder sb = new StringBuilder();
        for (Curso c : cursos) {
            sb.append("Codigo: ").append(c.getCodigo())
              .append(", Nombre: ").append(c.getNombre())
              .append(", Profesor: ").append(c.getProfesor().getNombre())
              .append(", Profesor: ").append(c.getProfesor().getNumCedula())
              .append("\n");
        }
        return sb.toString().isEmpty() ? "No hay cursos registrados." : sb.toString();
    }
   
   public String listarProfesores() {
        StringBuilder sb = new StringBuilder();
        for (Profesor p : profesores) {
            sb.append("Cedula: ").append(p.getNumCedula())
              .append(", Nombre: ").append(p.getNombre())
              .append(", Apellido: ").append(p.getApellido())     
              .append(", Profesion: ").append(p.getProfesion())
              .append("\n");
        }
        return sb.toString().isEmpty() ? "No hay profesores registrados." : sb.toString();
    }

    
    public void registrarCurso(Curso curso){
        cursos.add(curso);
    }
    
    public Curso buscarCurso(int codigo){
        //return cursos.stream().filter(c -> c.getCodigo() == codigo).findFirst().orElse(null);
        for (Curso curso : cursos) {
            if (curso.getCodigo() == codigo) {
                return curso;
            }
        }
        return null;
    }
    
    public void atualizarCurso(int codigo, String nombre, String apellido, Profesor profesor){
        Curso c = buscarCurso(codigo);
        if (c != null){
            c.setNombre(nombre);
            c.setProfesor(profesor); 
        }
    }
    
    public boolean eliminarCurso(int codigo) {
        for (Curso c : cursos) {
            if (c.getCodigo() == codigo) {
                cursos.remove(c);
                return true;
            }
        }
        return false;
    }

    
    public List<Curso> getCursos() {
        return cursos;
    }
}
