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
public class tablaModulo extends tablaBase {

    public tablaModulo(DataAccessManager dam) {
        super(dam);
    }

    @Override
    public void realizarAlta() {
        try {
            dam.listarModulos();
            System.out.println("---");
            dam.insertarModulosInteractivo();
            System.out.println("----");
            dam.listarModulos();
        } catch (SQLException e) {
            System.out.println("ERROR: Acceso a Base de Datos CANCELADO");
        }
    }

    @Override
    public void realizarBaja() {
        try {
            dam.listarModulos();
            System.out.println("---");
            dam.borrarModulosInteractivo();
            System.out.println("----");
            dam.listarModulos();
        } catch (SQLException e) {
            System.out.println("ERROR: Acceso a Base de Datos CANCELADO");
        }
    }

    @Override
    public void realizarConsulta() {
        try {
            System.out.println("---");
            dam.listadoModulosInteractivo(LINEAS_PAGINA);
            System.out.println("----");
        } catch (SQLException e) {
            System.out.println("ERROR: Acceso a Base de Datos CANCELADO");
        }
    }

    @Override
    public void realizarModificacion() {
        try {
            dam.listarModulos();
            System.out.println("---");
            dam.modificarModulosInteractivo();
            System.out.println("----");
            dam.listarModulos();
        } catch (SQLException e) {
            System.out.println("ERROR: Acceso a Base de Datos CANCELADO");
        }

    }
}
