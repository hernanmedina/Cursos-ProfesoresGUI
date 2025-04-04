package modelo;

/**
 *
 * @author Hernan Medina
 */
public class Curso {
    
    private int codigo;
    private String nombre;
    private Profesor profesor;
    
    public Curso(int codigo, String nombre, Profesor profesor){
        this.codigo = codigo;
        this.nombre = nombre;
        this.profesor = profesor;
    };
    
    public int getCodigo(){return codigo;}
    public String getNombre(){return nombre;}
    public Profesor getProfesor() {return profesor;}

    public void setCodigo(int codigo) {this.codigo = codigo;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setProfesor(Profesor profesor) {this.profesor = profesor;}

    @Override
    public String toString(){
        return "Curso{" + "codigo=" + codigo + ", nombre= '" + nombre +'\'' + ", profesor=" + profesor + '}';
    }
}
