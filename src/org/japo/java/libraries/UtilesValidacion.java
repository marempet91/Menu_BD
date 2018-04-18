/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.libraries;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 *
 * @author Martin Emilov Petkov
 */
public class UtilesValidacion {
    public static boolean validarDato(String dato, String er){
        boolean testOk = false;
        try{
            Pattern patron = Pattern.compile(er);
            Matcher detector = patron.matcher(dato);
            testOk = detector.matches();
        } catch (PatternSyntaxException e){
            System.out.println(e);
        }
        return testOk;
    }
}
