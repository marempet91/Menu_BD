/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.entities;

import org.japo.java.interfaces.tabla;

/**
 *
 * @author Martin Emilov Petkov
 */
public abstract class tablaBase implements tabla {

    protected DataAccessManager dam;

    public tablaBase(DataAccessManager dam) {
        this.dam = dam;

    }

    public DataAccessManager getDam() {
        return dam;
    }

    public void setDam(DataAccessManager dam) {
        this.dam = dam;
    }
}
