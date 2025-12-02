
package com.devzone.proyectodevzonejdbc.recursos;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author pablo
 */
public class PintarPaneles extends JPanel {
    
    
    //Variable que establece la imagen que se pinta en el panel
    private Image imagen;

    //Constructor para pasar por parametro el path de donde se extraera la imagen
    public PintarPaneles(String path) {
        imagen = new ImageIcon(getClass().getResource(path)).getImage();
     }

    //Metodo que pinta los componentes 
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }
    
}
