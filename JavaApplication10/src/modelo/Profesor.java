package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hernan Medina
 */
public class Profesor {
    
    private int numCedula;
    private String nombre;
    private String apellido;
    private String profesion;
    private List<Curso> cursosRegistrados = new ArrayList<>();
    
    public Profesor (int numCedula, String nombre, String apellido, String profecion){
        this.numCedula = numCedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.profesion = profecion;
    };
    
    public int getNumCedula (){return numCedula;}
    public String getNombre(){return nombre;}
    public String getApellido(){return apellido;}
    public String getProfesion(){return profesion;}
    public List<Curso> getCursosRegistrados(){return cursosRegistrados;}
    
    public void setNumCedula(int numCedula){this.numCedula = numCedula;}
    public void setNombre(String nombre){this.nombre = nombre;}
    public void setApellido(String apellido){this.apellido = apellido;}
    public void setProfesion(String profecion){this.profesion = profecion;}
    public void setCursosRegistrados(List<Curso> cursosRegistrados){this.cursosRegistrados = cursosRegistrados;}

    @Override
    public String toString() {
        return "Profesor{" + "numCedula=" + numCedula + ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' + ", profesion='" + profesion + '\'' + '}';
    }
}

