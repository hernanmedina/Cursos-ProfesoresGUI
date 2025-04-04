package control;

import modelo.GestionUnivalle; // modelo principal 
import modelo.Profesor;
import vista.ProfesoresGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author Hernan Medina
 */
public class ControladorProfesoresGUI implements ActionListener {
    private GestionUnivalle modelo;
    private ProfesoresGUI vistaProfesor;
    
    public ControladorProfesoresGUI(GestionUnivalle modelo, ProfesoresGUI vistaProfesor ) {
        this.modelo = modelo;
        this.vistaProfesor = vistaProfesor;
        
        // Agregar eventos a los botones
        this.vistaProfesor.btn_registrarProfesor.addActionListener(this);
        this.vistaProfesor.btn_buscarProfesor.addActionListener(this);
        this.vistaProfesor.btn_actualizarProfesor.addActionListener(this);
        this.vistaProfesor.btn_eliminarProfesor.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaProfesor.btn_registrarProfesor) {
            int cedula = Integer.parseInt(vistaProfesor.jtf_cedulaP.getText());
            String nombre = vistaProfesor.jtf_NombreP.getText();
            String apellido = vistaProfesor.jtf_apellidoP.getText();
            String profesion = vistaProfesor.jtf_profesionP.getText();

            Profesor profesor = new Profesor(cedula, nombre, apellido, profesion);
            modelo.registrarProfesor(profesor);
            vistaProfesor.mostrarMensaje("Profesor registrado con exito.");
            
            limpiarCampos();
        } 
        else if (e.getSource() == vistaProfesor.btn_buscarProfesor) {
            int cedula = Integer.parseInt(vistaProfesor.jtf_cedulaP.getText());
            Profesor profesor = modelo.buscarProfesor(cedula);
            if (profesor != null) {
                vistaProfesor.jtf_NombreP.setText(profesor.getNombre());
                vistaProfesor.jtf_apellidoP.setText(profesor.getApellido());
                vistaProfesor.jtf_profesionP.setText(profesor.getProfesion());
            } else {
                vistaProfesor.mostrarMensaje("Profesor no encontrado.");
            }
        } 
        else if (e.getSource() == vistaProfesor.btn_actualizarProfesor) {
            int cedula = Integer.parseInt(vistaProfesor.jtf_cedulaP.getText());
            Profesor profesor = modelo.buscarProfesor(cedula);
            if (profesor != null) {
                profesor.setNombre(vistaProfesor.jtf_NombreP.getText());
                profesor.setApellido(vistaProfesor.jtf_apellidoP.getText());
                profesor.setProfesion(vistaProfesor.jtf_profesionP.getText());
                vistaProfesor.mostrarMensaje("Profesor actualizado con exito.");
                limpiarCampos();
            } else {
                vistaProfesor.mostrarMensaje("Profesor no encontrado.");
            }
            
        } 
        else if (e.getSource() == vistaProfesor.btn_eliminarProfesor) {
            int cedula = Integer.parseInt(vistaProfesor.jtf_cedulaP.getText());
            boolean eliminado = modelo.eliminarProfesor(cedula);
            vistaProfesor.mostrarMensaje(eliminado ? "Profesor eliminado." : "Profesor no encontrado.");
            limpiarCampos();
        }
        
    }
    private void limpiarCampos() {
        //vistaProfesor.jtf_cedulaP.setText("");
        vistaProfesor.jtf_NombreP.setText("");
        vistaProfesor.jtf_apellidoP.setText("");
        vistaProfesor.jtf_profesionP.setText("");
    }
}

