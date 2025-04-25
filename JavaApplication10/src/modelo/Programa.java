package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hernan Medina
 */
public class Programa {
    private int codigo;
    private String nombre;
    private List<Curso> cursosRegistrados = new ArrayList<>();
    
    public Programa(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getCodigo() {return codigo;}
    public void setCodigo(int codigo) {this.codigo = codigo;}
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public List<Curso> getCursosRegistrados(){return cursosRegistrados;}
    public void setCursosRegistrados(List<Curso> cursosRegistrados){this.cursosRegistrados = cursosRegistrados;}
    
    @Override
    public String toString() {return "Programa{" + "codigo=" + codigo + ", nombre=" + nombre + '}';}

    public Programa() {
    }


    
}
