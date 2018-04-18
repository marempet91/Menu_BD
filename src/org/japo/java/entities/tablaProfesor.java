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
public class tablaProfesor extends tablaBase {

    public tablaProfesor(DataAccessManager dam) {
        super(dam);
    }

    @Override
    public void realizarAlta() {
        try {
            dam.listarProfesores();
            System.out.println("---");
            dam.insertarProfeInteractivo();
            System.out.println("----");
            dam.listarProfesores();
        } catch (SQLException e) {
            System.out.println("ERROR: Acceso a Base de Datos CANCELADO");
        }
    }

    @Override
    public void realizarBaja() {
        try {
            dam.listarProfesores();
            System.out.println("---");
            dam.borrarProfesInteractivo();
            System.out.println("----");
            dam.listarProfesores();
        } catch (SQLException e) {
            System.out.println("ERROR: Acceso a Base de Datos CANCELADO");
        }
    }

    @Override
    public void realizarConsulta() {
        try {
            System.out.println("---");
            dam.listadoProfesInteractivo(LINEAS_PAGINA);
            System.out.println("----");
        } catch (SQLException e) {
            System.out.println("ERROR: Acceso a Base de Datos CANCELADO");
        }
    }

    @Override
    public void realizarModificacion() {
        try {
            dam.listarProfesores();
            System.out.println("---");
            dam.modificarProfesInteractivo();
            System.out.println("----");
            dam.listarProfesores();
        } catch (SQLException e) {
            System.out.println("ERROR: Acceso a Base de Datos CANCELADO");
        }

    }
}
