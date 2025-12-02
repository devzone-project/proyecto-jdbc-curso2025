
package com.devzone.proyectodevzonejdbc.recursos;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author pablo
 */

//Clase que se maneja en conjunto con la clase ModificarTabla para poder crear JTable completamente Personalizados
public class CrearTableros {

    //Atributo que maneja la referencia del JTable
    private JTable tablero1;

    //Constructor para establecer el JTable sobre el que se creara el JTable Personalizado
    public CrearTableros(JTable tablero) {
        this.tablero1 = tablero;
    }

    //Metodo utilizado para reestablecer la referencia actual del tablero (Si se requiere compartir entre Frames)
    public void setTablero(JTable tablero) {
        this.tablero1 = tablero;
    }

    //Metodo que ayuda a generar tablas con titulos para reportes o lo que se requiera tener titulo (Headers)
    public void tableroConTitulo(String[] titulo, int filas, int columnas, boolean redimension) {

        //Se le desactiva el modo edicion 
        DefaultTableModel modeloTablero = new DefaultTableModel(filas, columnas);

        tablero1.setModel(modeloTablero);

        //Se desactiva la edicion para el Jtable
        for (int i = 0; i < columnas; i++) {

            tablero1.getColumnModel().getColumn(i).setCellEditor(null);
        }

        //Prohibe las ediciones y que el usuario pueda modificar celdas 
        tablero1.setRowSelectionAllowed(false);
        tablero1.setColumnSelectionAllowed(false);
        tablero1.setCellSelectionEnabled(false);
        tablero1.setFocusable(false);
        tablero1.setRequestFocusEnabled(false);

        //Ciclo que vacia a los header 
        for (int i = 0; i < columnas; i++) {
            tablero1.getColumnModel().getColumn(i).setHeaderValue(titulo[i]);
        }

        //Se etablece el tipo de fuente (Por defecto de linux)
        JTableHeader tableHeader = tablero1.getTableHeader();
        tableHeader.setFont(new Font("Liberation Sans", Font.BOLD, 16));

        //Redimensiona el tablero 
        tablero1.getTableHeader().repaint();

        if (redimension) {
            redimensionarTablero();
        }

    }


    //Metodo que permite generar el JTable sin ningun header
    public void generarTablero(int filas, int columnas, boolean redimension) {

        //Se le desactiva el modo edicion 
        TableroModel modeloTablero = new TableroModel(filas, columnas);

        tablero1.setModel(modeloTablero);

        //Se desactiva la edicion para el JTable
        for (int i = 0; i < columnas; i++) {

            tablero1.getColumnModel().getColumn(i).setCellEditor(null);
        }

        //Prohibe las ediciones y que el usuario pueda modificar celdas 
        tablero1.setRowSelectionAllowed(false);
        tablero1.setColumnSelectionAllowed(false);
        tablero1.setCellSelectionEnabled(false);
        tablero1.setFocusable(false);
        tablero1.setRequestFocusEnabled(false);

        //Ciclo que vacia a los headers 
        for (int i = 0; i < columnas; i++) {
            tablero1.getColumnModel().getColumn(i).setHeaderValue("");
        }

        //Redimensiona el tablero 
        tablero1.getTableHeader().repaint();

        if (redimension) {
            redimensionarTablero();
        }

    }

    //Metodo que redimensiona el tablero acorde al contenido recibido
    public void redimensionarTablero() {

        int alturadisponible = tablero1.getParent().getHeight();

        int cantidadFilas = tablero1.getRowCount();

        if (alturadisponible > 0 && cantidadFilas > 0) {

            int alturaIdeal = alturadisponible / cantidadFilas;

            //Propiedades predefinidas (Para no generar un JTable con celdas muy reducidas)
            int alturaMin = 25; 
            int alturaMax = 120;

            int AlturaFinal = Math.max(alturaMin, Math.min(alturaIdeal, alturaMax));

            //Se definen las dimensiones apropiadas
            tablero1.setRowHeight(AlturaFinal);
        }

    }

    //Metodo que permite vaciar por completo la referencia del JTable
    public void vaciarTablero() {
        TableroModel modeloTablero = new TableroModel(0, 0);
        tablero1.setModel(modeloTablero);
        tablero1.getTableHeader().repaint();
    }

}
