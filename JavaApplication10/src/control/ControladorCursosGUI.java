package control;

import modelo.Curso;
import modelo.GestionUnivalle;
import modelo.Profesor;
import vista.CursosGUI;
/**
 *
 * @author Hernan Medina
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorCursosGUI implements ActionListener {
    private GestionUnivalle modelo;
    private CursosGUI vistaCursos;

    public ControladorCursosGUI(GestionUnivalle modelo, CursosGUI vistaCursos) {
        this.modelo = modelo;
        this.vistaCursos = vistaCursos;
        

        // Agregar eventos a los botones
        this.vistaCursos.btn_registrarCurso.addActionListener(this);
        this.vistaCursos.btn_buscarCurso.addActionListener(this);
        this.vistaCursos.btn_actualizarCurso.addActionListener(this);
        this.vistaCursos.btn_eliminarCurso.addActionListener(this);
        this.vistaCursos.btn_listarC.addActionListener(this);
        this.vistaCursos.btn_listaPro.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaCursos.btn_registrarCurso) {
            int codigo = Integer.parseInt(vistaCursos.jtf_codigoCurso.getText());
            String nombre = vistaCursos.jtf_nombreCurso.getText();
            int cedulaProfesor = Integer.parseInt(vistaCursos.jtf_profesorCurso.getText());

            Profesor profesor = modelo.buscarProfesor(cedulaProfesor);
            if (profesor != null) {
                Curso curso = new Curso(codigo, nombre, profesor);
                modelo.registrarCurso(curso);
                vistaCursos.mostrarMensaje("Curso registrado con exito.");
                limpiarCampos();
            } else {
                vistaCursos.mostrarMensaje("Profesor no encontrado.");
            }
        } 
        else if (e.getSource() == vistaCursos.btn_buscarCurso) {
            int codigo = Integer.parseInt(vistaCursos.jtf_codigoCurso.getText());
            Curso curso = modelo.buscarCurso(codigo);
            if (curso != null) {
                vistaCursos.jtf_nombreCurso.setText(curso.getNombre());
                vistaCursos.jtf_profesorCurso.setText(String.valueOf(curso.getProfesor().getNumCedula()));
            } else {
                vistaCursos.mostrarMensaje("Curso no encontrado.");
            }
        } 
        else if (e.getSource() == vistaCursos.btn_actualizarCurso) {
            int codigo = Integer.parseInt(vistaCursos.jtf_codigoCurso.getText());
            Curso curso = modelo.buscarCurso(codigo);
            if (curso != null) {
                curso.setNombre(vistaCursos.jtf_nombreCurso.getText());
                int cedulaProfesor = Integer.parseInt(vistaCursos.jtf_profesorCurso.getText());
                Profesor profesor = modelo.buscarProfesor(cedulaProfesor);
                if (profesor != null) {
                    curso.setProfesor(profesor);
                    vistaCursos.mostrarMensaje("Curso actualizado con exito.");
                    limpiarCampos();
                } else {
                    vistaCursos.mostrarMensaje("Profesor no encontrado.");
                }
            } else {
                vistaCursos.mostrarMensaje("Curso no encontrado.");
            }
        } 
        else if (e.getSource() == vistaCursos.btn_eliminarCurso) {
            int codigo = Integer.parseInt(vistaCursos.jtf_codigoCurso.getText());
            boolean eliminado = modelo.eliminarCurso(codigo);
            vistaCursos.mostrarMensaje(eliminado ? "Curso eliminado." : "Curso no encontrado.");
            limpiarCampos();
        }
        else if (e.getSource() == vistaCursos.btn_listarC){
            vistaCursos.mostrarLista(modelo.listarCursos());
        }
        else if (e.getSource() == vistaCursos.btn_listaPro){
            vistaCursos.mostrarLista(modelo.listarProfesores());
        }
    }
    
    private void limpiarCampos() {
        //vistaProfesor.jtf_cedulaP.setText("");
        vistaCursos.jtf_nombreCurso.setText("");
        vistaCursos.jtf_profesorCurso.setText("");
    }
}

