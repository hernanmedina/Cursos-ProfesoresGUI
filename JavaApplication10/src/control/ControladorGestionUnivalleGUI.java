package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.GestionUnivalle;
import vista.GestionUnivalleGUI;
import vista.CursosGUI;
import vista.ProfesoresGUI;
import vista.ProgramasGUI;

public class ControladorGestionUnivalleGUI implements ActionListener{
    private GestionUnivalle modelo; // modelo principal
    private GestionUnivalleGUI vistaPrincipal;
    private CursosGUI vistaCursos;
    private ProfesoresGUI vistaProfesores;
    private ProgramasGUI vistaPrograma;

    public ControladorGestionUnivalleGUI(GestionUnivalle modelo, GestionUnivalleGUI vistaPrincipal) {
        this.modelo = modelo;
        this.vistaPrincipal = vistaPrincipal;
        this.vistaCursos = new CursosGUI();
        this.vistaProfesores = new ProfesoresGUI();
        this.vistaPrograma = new ProgramasGUI();

        // Asigna controladores a cada vista
        new ControladorCursosGUI(modelo, vistaCursos);
        new ControladorProfesoresGUI(modelo, vistaProfesores);
        new ControladorProgramaGUI(modelo, vistaPrograma);

        // Agregar eventos a los botones
        this.vistaPrincipal.btn_gestionCursos.addActionListener(e -> 
        {vistaCursos.setVisible(true); vistaCursos.setLocationRelativeTo(null);});
        
        this.vistaPrincipal.btn_gestionProfesores.addActionListener(e -> 
        {vistaProfesores.setVisible(true); vistaProfesores.setLocationRelativeTo(null);});
        
        this.vistaPrincipal.btn_gestion_Programa.addActionListener(e -> 
        {vistaPrograma.setVisible(true); vistaPrograma.setLocationRelativeTo(null);});
        this.vistaPrincipal.setVisible(true);
        
        this.vistaPrincipal.btn_listar_cursos.addActionListener(this);
        this.vistaPrincipal.btn_listar_profesores.addActionListener(this);
        this.vistaPrincipal.btn_listar_programas.addActionListener(this);
         
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== vistaPrincipal.btn_listar_cursos) {
            vistaCursos.mostrarLista(modelo.listarCursos());
        }
        else if (e.getSource() == vistaPrincipal.btn_listar_profesores){
            vistaCursos.mostrarLista(modelo.listarProfesores());
        } 
        else if (e.getSource() == vistaPrincipal.btn_listar_programas){
            vistaCursos.mostrarLista(modelo.listarProgramas());
        }
        }
    }
