package com.devzone.proyectodevzonejdbc.recursos;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author pablo
 */
//Clase que permite crear un modelo de Jtable personalizado especificando las dimensiones
public class TableroModel extends AbstractTableModel {

    //Atributo que maneja la referencia interna del JTable
    private Object[][] data;

    public TableroModel(int filas, int columnas) {
        data = new Object[filas][columnas];
    }

    //Metodo que permite obtener la cantidad de filas del JTable
    @Override
    public int getRowCount() {
        return data.length;

    }

    //Metodo que permite obtener la cantidad de Columnas del JTable
    @Override
    public int getColumnCount() {
        if (data.length > 0) {
            return data[0].length;
        } else {
            return 0;
        }
    }

    //Metodo que permite obtener el valor de una celda del JTable
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex >= 0 && rowIndex < getRowCount()
                && columnIndex >= 0 && columnIndex < getColumnCount()) {
            return data[rowIndex][columnIndex];
        }
        return null;
    }

    //Metodo que permite establecer el valor de una celda del JTable
    @Override
    public void setValueAt(Object value, int row, int column) {
        if (row >= 0 && row < getRowCount() && column >= 0 && column < getColumnCount()) {
            data[row][column] = value;
            fireTableCellUpdated(row, column);
        }
    }

}
