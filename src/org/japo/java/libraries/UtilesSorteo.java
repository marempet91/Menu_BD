/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.libraries;

import java.util.Random;

/**
 *
 * @author Martin Emilov Petkov
 */
public class UtilesSorteo {
    public static final int LONGITUD_APUESTA_PRIMITIVA = 6;
    public static final int LONGITUD_BOMBO_PRIMITIVA = 49;
    public static final Random RND = new Random();
    public static final int [] generarApuestaPrimitiva(){
        int apuesta[] = new int [LONGITUD_APUESTA_PRIMITIVA];
        int bombo[]=generarBomboPrimitiva();
        for (int i = 0; i < apuesta.length; i++) {
            int posicion = RND.nextInt(LONGITUD_BOMBO_PRIMITIVA-i);
            apuesta[i] = bombo[posicion];
            bombo[posicion] = bombo[LONGITUD_BOMBO_PRIMITIVA - i - 1];
        }
        return apuesta;
    }
    public static final int [] generarBomboPrimitiva(){
        int bombo[] = new int [LONGITUD_BOMBO_PRIMITIVA];
        for (int i = 0; i < bombo.length; i++) {
            bombo[i] = i + 1;            
        }
        return bombo;
    }
}
