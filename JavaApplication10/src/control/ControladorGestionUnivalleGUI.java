package control;

import modelo.GestionUnivalle;
import vista.GestionUnivalleGUI;
import vista.CursosGUI;
import vista.ProfesoresGUI;

public class ControladorGestionUnivalleGUI {
    private GestionUnivalle modelo; // modelo principal
    private GestionUnivalleGUI vistaPrincipal;
    private CursosGUI vistaCursos;
    private ProfesoresGUI vistaProfesores;

    public ControladorGestionUnivalleGUI(GestionUnivalle modelo, GestionUnivalleGUI vistaPrincipal) {
        this.modelo = modelo;
        this.vistaPrincipal = vistaPrincipal;
        this.vistaCursos = new CursosGUI();
        this.vistaProfesores = new ProfesoresGUI();

        // Asigna controladores a cada vista
        new ControladorCursosGUI(modelo, vistaCursos);
        new ControladorProfesoresGUI(modelo, vistaProfesores);

        // Agregar eventos a los botones
        this.vistaPrincipal.btn_gestionCursos.addActionListener(e -> vistaCursos.setVisible(true));
        this.vistaPrincipal.btn_gestionProfesores.addActionListener(e -> vistaProfesores.setVisible(true));
        this.vistaPrincipal.setVisible(true);
         
    }
    
}
