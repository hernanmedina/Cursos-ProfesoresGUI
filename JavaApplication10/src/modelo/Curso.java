package modelo;

/**
 *
 * @author Hernan Medina
 */
public class Curso {
    
    private int codigo;
    private String nombre;
    private Profesor profesor;
    private Programa programa;
    
    public Curso(int codigo, String nombre, Profesor profesor, Programa programa){
        this.codigo = codigo;
        this.nombre = nombre;
        this.profesor = profesor;
        this.programa = programa;
    };
    
    public int getCodigo(){return codigo;}
    public String getNombre(){return nombre;}
    public Profesor getProfesor() {return profesor;}
    public Programa getPrograma() {return programa;}
    

    public void setCodigo(int codigo) {this.codigo = codigo;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setProfesor(Profesor profesor) {this.profesor = profesor;}
    public void setPrograma(Programa programa) {this.programa = programa;}

    @Override
    public String toString(){
        return "Curso{" + "codigo=" + codigo + ", nombre= '" + nombre +'\'' + ", profesor=" 
                + profesor + '\'' + ", programa=" + programa + '}';
    }
}
