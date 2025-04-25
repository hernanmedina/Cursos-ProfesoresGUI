package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hernan Medina
 */
public class GestionUnivalle {
    
    private List<Profesor> profesores = new ArrayList<>();
    private List<Curso> cursos = new ArrayList<>();
    private List<Programa> programas = new ArrayList<>();
    
    public void agregarPrograma(Programa pr){
        programas.add(pr);
    }
    
    public Programa consultarPrograma(int codigo){
        for (Programa pr: programas) {
            if (pr.getCodigo()== codigo) {
                return pr;
            }
        }
        return null;
    }
    
    public boolean actualizarPrograma(Programa programaActualizado){
        for (int i = 0; i < programas.size(); i++) {
            if (programas.get(i).getCodigo()== programaActualizado.getCodigo()) {
                programas.set(i, programaActualizado);
                return true;
            }
        }
        return false;
    }
    
    public boolean eliminarPrograma(int codigo){
        for (int i = 0; i < programas.size(); i++) {
            if (programas.get(i).getCodigo()== codigo) {
                programas.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public String listarProgramas() {
        StringBuilder sb = new StringBuilder();
        for (Programa pr : programas) {
            sb.append("Codigo: ").append(pr.getCodigo())
              .append(", Nombre: ").append(pr.getNombre())
              .append("\n");
        }
        return sb.toString().isEmpty() ? "No hay programas registrados." : sb.toString();
    }
    
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
              .append(", Cedula: ").append(c.getProfesor().getNumCedula())
              .append(", Programa: ").append(c.getPrograma().getNombre())
              .append(", Codigo: ").append(c.getPrograma().getCodigo())
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
