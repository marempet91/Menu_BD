/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.entities;

import java.sql.SQLException;
import org.japo.java.libraries.UtilesEntrada;

/**
 *
 * @author Martin Emilov Petkov
 */
public class MenuDatabase {

    public static final int LINEAS_PAGINA = 3;

    private DataAccessManager dam;

    public MenuDatabase(DataAccessManager dam) {
        this.dam = dam;
    }

    public DataAccessManager getDam() {
        return dam;
    }

    public void setDam(DataAccessManager dam) {
        this.dam = dam;
    }

    public final boolean menuPrincipal() throws SQLException {
        boolean menuOK = true;
        System.out.println("MENU PRINCIPAL");
        System.out.println("=============");
        System.out.println("[M] Modulo");
        System.out.println("[C] Ciclo");
        System.out.println("[P] Profesores");
        System.out.println("--------------------");
        System.out.println("[S] Salir");
        System.out.println("--------------------");
        char opcion = UtilesEntrada.leerOpcion("MmCcPpSs", "Opcion elegida...:", "Entrada Incorecta");
        switch (opcion) {
            case 'm':
            case 'M':
                subMenu('M');
                break;
            case 'c':
            case 'C':
                subMenu('C');
                break;
            case 'p':
            case 'P':
                subMenu('P');
                break;
            case 's':
            case 'S':
                menuOK = false;
                break;
        }
        return menuOK;
    }

    public final void subMenu(char menu) throws SQLException {
        String nombre_menu = "";
        tablaBase tb = null;
        switch (menu) {
            case 'M':
                nombre_menu = "MODULO";
                tb = new tablaModulo(dam);
                break;
            case 'C':
                nombre_menu = "CICLO";
                tb = new tablaCiclo(dam);
                break;
            case 'P':
                nombre_menu = "PROFESOR";
                tb = new tablaProfesor(dam);
                break;
        }
        subMenuSelector(tb, nombre_menu);
    }

    public final void subMenuSelector(tablaBase tb, String tabla) throws SQLException {
        System.out.printf("MENU %s%n", tabla);
        System.out.println("=============");
        System.out.println("[A] Altas");
        System.out.println("[B] Bajas");
        System.out.println("[C] Consultas");
        System.out.println("[M] Modificaciones");
        System.out.println("--------------------");
        System.out.println("[X] Atras");
        System.out.println("--------------------");
        char opcion = UtilesEntrada.leerOpcion("AaBbCcMmXx", "Opcion Elegida...:", "Entrada Incorrecta");
        switch (opcion) {
            case 'a':
            case 'A':
                tb.realizarAlta();
                break;
            case 'b':
            case 'B':
                tb.realizarBaja();
                break;
            case 'c':
            case 'C':
                tb.realizarConsulta();
                break;
            case 'm':
            case 'M':
                tb.realizarModificacion();
                break;
            case 'x':
            case 'X':
                break;
        }
    }
}
