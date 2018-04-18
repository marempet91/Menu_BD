/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.libraries;

import java.util.Scanner;

/**
 *
 * @author Martin Emilov Petkov
 */
public class UtilesEntrada {

    public static final Scanner SCN = new Scanner(System.in, "ISO-8859-1");

    public static int leerEntero(String msgUsr, String msgErr) {
        int numero = 0;

        boolean testOK = true;
        do {
            try {
                System.out.print(msgUsr);
                numero = SCN.nextInt();
                testOK = false;
            } catch (Exception e) {
                System.out.printf(msgErr);
            } finally {
                SCN.nextLine();
            }
        } while (testOK);

        return numero;
    }

    public static int leerEnteroLista(String msgUsr, String msgErr, int[] lista) {
        int dato;
        boolean datoOk;
        do {
            dato = UtilesEntrada.leerEntero(msgUsr, msgErr);
            datoOk = UtilesArrays.buscar(lista, dato) > -1;
            if (!datoOk) {
                System.out.println(msgErr);
            }
        } while (!datoOk);
        return dato;
    }

    public static int leerEnteroRango(String msgUsr, String msgErr, String msgErrRango, int lim_inf, int lim_sup) {
        int numero = 0;
        boolean entradaOK = true;
        do {
            numero = leerEntero(msgUsr, msgErr);
            if (numero >= lim_inf && numero <= lim_sup) {
                entradaOK = false;
            } else {
                System.out.printf("%s%n", msgErrRango);
            }
        } while (entradaOK);
        return numero;
    }

    public static int leerEnteroPar(String msgUsr, String msgErr, String msgErrParidad, int lim_inf, int lim_sup) {
        int numero = 0;
        boolean entradaOK = true;
        do {
            numero = leerEntero(msgUsr, msgErr);
            if (UtilesPrimitivos.validarParidad(numero)) {
                entradaOK = false;
            } else {
                System.out.printf("%s%n", msgErrParidad);
            }
        } while (entradaOK);
        return numero;
    }

    public static int leerEnteroImpar(String msgUsr, String msgErr, String msgErrParidad, int lim_inf, int lim_sup) {
        int numero = 0;
        boolean entradaOK = true;
        do {
            numero = leerEntero(msgUsr, msgErr);
            if (!(UtilesPrimitivos.validarParidad(numero))) {
                entradaOK = false;
            } else {
                System.out.printf("%s%n", msgErrParidad);
            }
        } while (entradaOK);
        return numero;
    }

    public static int leerEnteroRangoPar(String msgUsr, String msgErr, String msgErrRango, String msgErrParidad, int lim_inf, int lim_sup) {
        int numero = 0;
        boolean entradaOK = true;
        do {
            numero = leerEnteroRango(msgUsr, msgErr, msgErrRango, lim_inf, lim_sup);
            if (UtilesPrimitivos.validarParidad(numero)) {
                entradaOK = false;
            } else {
                System.out.printf("%s%n", msgErrParidad);
            }
        } while (entradaOK);
        return numero;
    }

    public static int leerEnteroRangoImpar(String msgUsr, String msgErr, String msgErrRango, String msgErrParidad, int lim_inf, int lim_sup) {
        int numero = 0;
        boolean entradaOK = true;
        do {
            numero = leerEnteroRango(msgUsr, msgErr, msgErrRango, lim_inf, lim_sup);
            if (!(UtilesPrimitivos.validarParidad(numero))) {
                entradaOK = false;
            } else {
                System.out.printf("%s%n", msgErrParidad);
            }
        } while (entradaOK);
        return numero;
    }

    public static double leerDouble(String msgUsr, String msgErr) {
        double numero = 0;
        boolean testOK = true;
        do {
            try {
                System.out.printf("%s%n", msgUsr);
                numero = SCN.nextDouble();
                testOK = false;
            } catch (Exception e) {
                System.out.printf("%s%n", msgErr);
            } finally {
                SCN.nextLine();
            }
        } while (testOK);

        return numero;
    }

    public static double leerDoubleRango(String msgUsr, String msgErr, String msgErrRango, double lim_inf, double lim_sup) {
        double numero = 0;
        boolean entradaOK = true;
        do {
            numero = leerDouble(msgUsr, msgErr);
            if (numero >= lim_inf && numero <= lim_sup) {
                entradaOK = false;
            } else {
                System.out.printf("%s%n", msgErrRango);
            }
        } while (entradaOK);
        return numero;
    }

    public static final char leerCaracter(String msgUsr, String msgErr) {
        char character = 'a';
        boolean testOK = true;
        do {
            try {
                System.out.printf("%s%n", msgUsr);
                character = SCN.next().charAt(0);
                testOK = false;
            } catch (Exception e) {
                System.out.printf("%s%n", msgErr);
            } finally {
                SCN.nextLine();
            }
        } while (testOK);

        return character;
    }

    public static String leerString(String msgUsr, String msgErr) {
        String string = "";
        boolean testOK = true;
        do {
            try {
                System.out.printf("%s%n", msgUsr);
                string = SCN.nextLine();
                testOK = false;
            } catch (Exception e) {
                System.out.printf("%s%n", msgErr);
            }
        } while (testOK);

        return string;
    }

    public static char leerOpcion(String opciones, String msgUsr, String msgErr) {
        char dato = ' ';
        boolean lecturaOK = true;
        do {
            try {
                System.out.print(msgUsr);
                dato = SCN.nextLine().charAt(0);
                if (opciones.contains(dato + "")) {
                    lecturaOK = false;
                } else {
                    System.out.println(msgErr);
                }
            } catch (Exception e) {
                System.out.println(msgErr);
            }
        } while (lecturaOK);
        return dato;
    }

    public static String leerTexto(String msgUsr) {
        System.out.print(msgUsr);
        return SCN.nextLine();
    }
}
