package com.devzone.proyectodevzonejdbc.recursos;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author pablo
 */
//Clase que se encarga de personalizar los Labels y darle el valor de imagenes
public class IlustrarLabels {

    //Ancho y alto de la imagen que se requiera
    private int alto;
    private int ancho;

    //Referencia del label al que se le colocara la imagen
    private JLabel referenciaLabel;

    //Constructor que permite ilustrar Labels Cuando estos estan colocados en un Componente con LAYOUT NULL
    public IlustrarLabels(int alto, int ancho, String texto, JLabel label) {
        this.alto = alto;
        this.ancho = ancho;
        referenciaLabel = label;
    }

    //Metodo que permite establecer la imagen dentro del Label
    public void cambiarLabel(ImageIcon imagen) {
        Image imagenEscalada = imagen.getImage().getScaledInstance(this.ancho, this.alto, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imagenEscalada);

        this.referenciaLabel.setIcon(iconoRedimensionado);
        this.referenciaLabel.repaint();
    }

}
