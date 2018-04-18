/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.libraries;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Martin Emilov Petkov
 */
public class UtilesDNI {
    public static final String LETRA = "TRWAGMYFPDXBNJZSQVHLCKE";
    public static final Scanner SCN = new Scanner(System.in, "ISO-8859-1");

    public static final int obtenerDNI(String msgUsr, String msgErr) {
        SCN.useLocale(Locale.ENGLISH);
        int numero = 0;
        boolean testOk = true;
        do {
            try {
                System.out.print("Introduce tu DNI sin letra: ");
                numero = SCN.nextInt();
                testOk = false;
            } catch (Exception e) {
                System.out.println("Error de Entrada");
            } finally {
                SCN.nextLine();
            }

        } while (testOk);
        return numero;
    }
    
    public static final char letraDNI(int dni) {
        char letra = LETRA.charAt(dni % 23);
        return letra;
    }
}
