package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.GestionUnivalle;
import modelo.Programa;
import vista.ProgramasGUI;

/**
 *
 * @author Hernan Medina
 */
public class ControladorProgramaGUI implements ActionListener{
    private GestionUnivalle logica;
    private ProgramasGUI vistaPrograma;

    public ControladorProgramaGUI(GestionUnivalle logica, ProgramasGUI vistaPrograma) {
        this.logica = logica;
        this.vistaPrograma = vistaPrograma;
        
        this.vistaPrograma.jbtn_agregar_programa.addActionListener(this);
        this.vistaPrograma.jbtn_consultar_programa.addActionListener(this);
        this.vistaPrograma.jbtn_actualizar_programa.addActionListener(this);
        this.vistaPrograma.jbtn_eliminar_programa.addActionListener(this);
    }
    
    private void limpiarCampos() {
        //vistaPrograma.jtf_codigo_programa.setText("");
        vistaPrograma.jtf_nombre_programa.setText("");
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //Agregar Programa
        if (e.getSource()== vistaPrograma.jbtn_agregar_programa) {
            int codigo = Integer.parseInt(vistaPrograma.jtf_codigo_programa.getText());
            String nombre = vistaPrograma.jtf_nombre_programa.getText();
            
            Programa pr = logica.consultarPrograma(codigo);
              if (pr == null) {
                Programa programas = new Programa(codigo, nombre);
                logica.agregarPrograma(programas);
                vistaPrograma.mostrarMensaje("Programa registrado con exito.");
                limpiarCampos();
            } else {
                vistaPrograma.mostrarMensaje("El programa ya existe, valide la informacion.");
            }
        }
        
        //Consultar programa
        else if (e.getSource()== vistaPrograma.jbtn_consultar_programa) {
            int codigo = Integer.parseInt(vistaPrograma.jtf_codigo_programa.getText());
            Programa pr = logica.consultarPrograma(codigo);
            if (pr != null) {
                vistaPrograma.jtf_nombre_programa.setText(pr.getNombre());
            } else {
                vistaPrograma.mostrarMensaje("Programa no encontrado, valide la informacion.");
            }  
        }
        
        //Actualizar programa
        else if (e.getSource() == vistaPrograma.jbtn_actualizar_programa) {
            int codigo = Integer.parseInt(vistaPrograma.jtf_codigo_programa.getText());
            Programa pr = logica.consultarPrograma(codigo);
            if (pr != null) {
                pr.setNombre(vistaPrograma.jtf_nombre_programa.getText());
                vistaPrograma.mostrarMensaje("Programa actualizado con exito.");
                limpiarCampos();
            } else {
                vistaPrograma.mostrarMensaje("Programa no encontrado, valide la informacion.");
            } 
        }
        
        //Eliminar programa
        else if (e.getSource()== vistaPrograma.jbtn_eliminar_programa) {
            int codigo = Integer.parseInt(vistaPrograma.jtf_codigo_programa.getText());
            boolean eliminado = logica.eliminarPrograma(codigo);
            vistaPrograma.mostrarMensaje(eliminado ? "Programa eliminado." : "Programa no encontrado.");
            limpiarCampos();
        }
    }
    
}
