/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.japo.java.entities.DataAccessManager;
import org.japo.java.entities.MenuDatabase;
import org.japo.java.libraries.UtilesDB;

/**
 *
 * @author Martin Emilov Petkov
 */
public class App {
    // Hacer cosas    

    public static final int LINEAS_PAGINA = 3;

    public void launchApp() {
        System.out.println("Inicialización acceso a la Base de Datos...");
        System.out.println("---");
        try (Connection con = UtilesDB.obtenerConexion();
                Statement stmt = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
            System.out.println("Acceso a Base de Datos INICIADO");
            System.out.println("---");
            DataAccessManager dam = new DataAccessManager(con, stmt);
            MenuDatabase md = new MenuDatabase(dam); 
            boolean menuOK = true;
            do {
                //Logica de Negocio
                menuOK = md.menuPrincipal();

            } while (menuOK);
//dam.listarModulos();
//dam.insercionModulosPreparadosPacheco();
//dam.insertarModulosLotes();
            System.out.println("Acceso a Base de datos FINALIZADO");
        } catch (SQLException e) {
            System.out.println("ERROR: Acceso a Base de Datos CANCELADO");
        }

    }
}
