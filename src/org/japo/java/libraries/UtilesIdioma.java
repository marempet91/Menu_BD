/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.libraries;

/**
 *
 * @author Martin Emilov Petkov
 */
public class UtilesIdioma {

    //Codigos Idioma
    public static final int CODIGO_ESP = 34;
    public static final int CODIGO_ING = 44;
    public static final int CODIGO_ALE = 49;

    //Nombres Idioma
    public static final String NOMBRE_ESP = "Español";
    public static final String NOMBRE_ING = "Ingles";
    public static final String NOMBRE_ALE = "Aleman";

    //Dias de la semana
    public static final int LUNES = 1;
    public static final int MARTES = 2;
    public static final int MIERCOLES = 3;
    public static final int JUEVES = 4;
    public static final int VIERNES = 5;
    public static final int SABADO = 6;
    public static final int DOMINGO = 7;

    //Dias Español
    public static final String[] DIAS_ESP = {
        "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"
    };

    //Dias Ingles
    public static final String[] DIAS_ING = {
        "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
    };

    //Dias Aleman
    public static final String[] DIAS_ALE = {
        "Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag", "Sonntag"
    };

    //Generar el nombre del dia
    public static String generarNombreDia(int dia, int idioma) {
        String nombre;

        switch (idioma) {
            case CODIGO_ESP:
                nombre = String.format("%s - (%s)", DIAS_ESP[dia - 1], NOMBRE_ESP);
                break;
            case CODIGO_ING:
                nombre = String.format("%s - (%s)", DIAS_ING[dia - 1], NOMBRE_ING);
                break;
            case CODIGO_ALE:
                nombre = String.format("%s - (%s)", DIAS_ALE[dia - 1], NOMBRE_ALE);
                break;
            default:
                nombre = "Desconocido";
        }
        return nombre;
    }
}
