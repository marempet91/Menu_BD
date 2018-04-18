/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.entities;

/**
 *
 * @author Martin Emilov Petkov
 */
public class Modulo {
    // CONSTANTES - VARIABLES POR DEFECTO

    public final int DEF_ID = 0;
    public final String DEF_ACRONIMO = "XXX";
    public final String DEF_NOMBRE = "xxxxxxxx";
    public final String DEF_CODIGO = "MPXXX";
    public final int DEF_HORASCURSO = 0;
    public final int DEF_CURSO = 1;

    // VARIABLES DE ENTORNO
    private int id;
    private String acronimo;
    private String nombre;
    private String codigo;
    private int horasCurso;
    private int curso;

    //CONSTRUCTOR PREDETERMINADO
    public Modulo() {
        id = DEF_ID;
        acronimo = DEF_ACRONIMO;
        nombre = DEF_NOMBRE;
        codigo = DEF_CODIGO;
        horasCurso = DEF_HORASCURSO;
        curso = DEF_CURSO;
    }

    //constructor parametrizado
    public Modulo(int id, String acronimo, String nombre, String codigo, int horasCurso, int curso) {
        this.id = id;
        this.acronimo = acronimo;
        this.nombre = nombre;
        this.codigo = codigo;
        this.horasCurso = horasCurso;
        if (curso == 1 || curso == 2) {
            this.curso = curso;
        } else {
            this.curso = DEF_CURSO;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAcronimo() {
        return acronimo;
    }

    public void setAcronimo(String acronimo) {
        this.acronimo = acronimo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getHorasCurso() {
        return horasCurso;
    }

    public void setHorasCurso(int horasCurso) {
        this.horasCurso = horasCurso;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

}
