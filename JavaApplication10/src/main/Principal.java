package main;

import control.ControladorGestionUnivalleGUI;
import modelo.GestionUnivalle;
import vista.GestionUnivalleGUI;

/**
 *
 * @author Hernan Medina
 */
public class Principal {
    public static void main(String[] args) {
        GestionUnivalle modelo = new GestionUnivalle();
        GestionUnivalleGUI vistaPrincipal = new GestionUnivalleGUI();
        new ControladorGestionUnivalleGUI(modelo, vistaPrincipal);
        vistaPrincipal.setVisible(true);
    }
}