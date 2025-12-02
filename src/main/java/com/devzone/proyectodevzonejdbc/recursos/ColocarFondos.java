
package com.devzone.proyectodevzonejdbc.recursos;

import java.awt.Component;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

/**
 *
 * @author pablo
 */
public class ColocarFondos {

    //Apartado de variables que permiten controlar los diversos tipos de frames que se manejan para poder repintar el panel
    private JFrame frame;

    private JPanel panelPintado;

    private JDialog modalDialog;
    
    private JInternalFrame internalFrame; 

    //Constructor para repintar paneles en Frames 
    public ColocarFondos(JFrame frame, JPanel panelPrincipal) {
        this.frame = frame;
        this.panelPintado = panelPrincipal;

    }

    //Constructor especifico para repintar paneles en Modales (JDialog)
    public ColocarFondos(JDialog frame, JPanel panelPrincipal) {
        this.modalDialog = frame;
        this.panelPintado = panelPrincipal;

    }
    
    //Constructor especifico para repintar paneles en Frames internos 
    public ColocarFondos(JInternalFrame frame, JPanel panelPrincipal) {
        internalFrame = frame;
        this.panelPintado = panelPrincipal;

    }

    //Metodo encargado de pintar los Frames internos 
    public void pintarFrameInterno(String path) {
        PintarPaneles fondo = new PintarPaneles(path);

        fondo.setLayout(null);
        fondo.setSize(this.panelPintado.getSize()); 
        
        for (Component c : this.panelPintado.getComponents()) {
            fondo.add(c);
        }

        //Se reemplaza al panel anterior con el panel Anterior sin formato por el panel con fondo personalizado
        this.internalFrame.getContentPane().remove(panelPintado);
        this.internalFrame.getContentPane().add(fondo);
        panelPintado = fondo;

        //Se revalida al panel que se pasa por parametro en el Frame indicado
        this.internalFrame.revalidate();
        this.internalFrame.repaint();
    }
    
    //Metodo encargado de pintar los Frames 
    public void pintarPaneles(String path) {
        PintarPaneles fondo = new PintarPaneles(path);

        fondo.setLayout(null);
        for (Component c : panelPintado.getComponents()) {
            fondo.add(c);
        }

       //Se reemplaza al panel anterior con el panel Anterior sin formato por el panel con fondo personalizado
        this.frame.getContentPane().remove(panelPintado);
        this.frame.getContentPane().add(fondo);
        panelPintado = fondo;

        //Se revalida al panel que se pasa por parametro en el Frame indicado
        this.frame.revalidate();
        this.frame.repaint();
    }

    //Metodo encargado de pintar los modales (JDialog)
    public void pintarDialog(String path) {
        PintarPaneles fondo = new PintarPaneles(path);

        fondo.setLayout(null);
        for (Component c : panelPintado.getComponents()) {
            fondo.add(c);
        }

      //Se reemplaza al panel anterior con el panel Anterior sin formato por el panel con fondo personalizado
        this.modalDialog.getContentPane().remove(panelPintado);
        this.modalDialog.getContentPane().add(fondo);
        panelPintado = fondo;

        //Se revalida al panel que se pasa por parametro en el Frame indicado
        this.modalDialog.revalidate();
        this.modalDialog.repaint();
    }

}
