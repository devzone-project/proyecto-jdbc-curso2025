
package com.devzone.proyectodevzonejdbc.recursos;

import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author pablo
 */

//Clase que se encarga de procesar las imagenes para reenderizarlas al formato que se desee
public class ImageRenderer extends DefaultTableCellRenderer{
    
    //Metodo ue permite Obtener la celda reenderizada
     @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        if (value instanceof JLabel) {
            JLabel label = (JLabel) value;

            if (label.getIcon() instanceof ImageIcon) {
                
                ImageIcon originalIcon = (ImageIcon) label.getIcon();
                
                int ancho = table.getColumnModel().getColumn(column).getWidth();
                int alto = table.getRowHeight(row);

                // Redimensiona SOLO si cambia el tamaño para no hacerlo innecesariamente
                Image imagenEscalada = originalIcon.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
                label.setIcon(new ImageIcon(imagenEscalada));
                label.setHorizontalAlignment(JLabel.CENTER); 
            }

            return label;
        }

        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
    
    
}
