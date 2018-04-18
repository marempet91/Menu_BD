/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.entities;

import java.sql.SQLException;
import static org.japo.java.entities.MenuDatabase.LINEAS_PAGINA;

/**
 *
 * @author Martin Emilov Petkov
 */
public class tablaCiclo extends tablaBase {

    public tablaCiclo(DataAccessManager dam) {
        super(dam);
    }

    @Override
    public void realizarAlta() {
        try {
            dam.listarCiclos();
            System.out.println("---");
            dam.insertarCiclosInteractivo();
            System.out.println("----");
            dam.listarCiclos();
        } catch (SQLException e) {
            System.out.println("ERROR: Acceso a Base de Datos CANCELADO");
        }
    }

    @Override
    public void realizarBaja() {
        try {
            dam.listarCiclos();
            System.out.println("---");
            dam.borrarCiclosInteractivo();
            System.out.println("----");
            dam.listarCiclos();
        } catch (SQLException e) {
            System.out.println("ERROR: Acceso a Base de Datos CANCELADO");
        }
    }

    @Override
    public void realizarConsulta() {
        try {
            System.out.println("---");
            dam.listadoCiclosInteractivo(LINEAS_PAGINA);
            System.out.println("----");
        } catch (SQLException e) {
            System.out.println("ERROR: Acceso a Base de Datos CANCELADO");
        }
    }

    @Override
    public void realizarModificacion() {
        try {
            dam.listarCiclos();
            System.out.println("---");
            dam.modificarCiclosInteractivo();
            System.out.println("----");
            dam.listarCiclos();
        } catch (SQLException e) {
            System.out.println("ERROR: Acceso a Base de Datos CANCELADO");
        }

    }
}
