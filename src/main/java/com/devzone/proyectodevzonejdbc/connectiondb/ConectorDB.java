/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devzone.proyectodevzonejdbc.connectiondb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pablo03
 */
//Clase encargada para poder acceder a la base de datos de sql 
public class ConectorDB {
    
    
     private static final String IP = "localhost";
    private static final int PUERTO = 3306;
    private static final String SCHEMA = "comercializadoradb";
    private static final String USER_NAME = "developzone";
    private static final String PASSWORD = "D3v3l0pZ#";

    //Protocolo que va a conectarse con la base de datos 
    private static final String URL = "jdbc:mysql://" + IP + ":" + PUERTO + "/" + SCHEMA;

    //Atributo que mantiene a la conexion viva
    private Connection conexionActiva;

    //Metodo que se encarga de abrir la conexion a sql 
    public void conectar() {

        System.out.println("Url de conexion: " + URL);

        //Al usar el try-catch con recursos cierra automaticamente la conexion u operacion que hace
        try {

            this.conexionActiva = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

            System.out.println("Esquema:  " + this.conexionActiva.getSchema());
            System.out.println("Catalogo:  " + this.conexionActiva.getCatalog());

        } catch (SQLException ex) {
            System.out.println("Error al conectarse " + ex.getMessage());

        }

    }

    //Metodo muy importante que siempre retornara la conexion para poder usarla en sus diversos usos
    public Connection getConexionbd() {
        return this.conexionActiva;
    }

    //Metodo 100% necesario para mantener integridad de la base de datos y cerrarla
    public void cerrarConexion() {

        if (conexionActiva != null) {

            try {

                if (!this.conexionActiva.isClosed()) {
                    this.conexionActiva.close();            
                }

            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexion " + ex.getMessage());
            }

        }

    }
    
}
