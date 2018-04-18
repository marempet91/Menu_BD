/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.entities;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.japo.java.libraries.UtilesEntrada;

/**
 *
 * @author Martin Emilov Petkov
 */
public class DataAccessManager {

    // Sentencias SQL
    public static final String DEF_SQL_MOD = "SELECT * FROM modulo";
    public static final String DEF_SQL_CIC = "SELECT * FROM ciclo";
    public static final String DEF_SQL_ALU = "SELECT * FROM alumno";
    public static final String DEF_SQL_PRO = "SELECT * FROM profesor";
    public static final String DEF_MOD_SQL2 = "DELETE FROM modulo WHERE acronimo='SJ'";
    public static final String DEF_MOD_SQL3 = "INSERT INTO modulo values ('4','SI','Sistemas','MP0486','150','1');";
    public static final String DEF_MOD_SQL4 = "UPDATE modulo SET curso=2 WHERE horasCurso<2;";
    public static final String DEF_MOD_SQL5 = "SELECT * FROM modulo WHERE id=%s";
    public static final String DEF_MOD_SQL6 = "SELECT * FROM ciclo WHERE id=%s";
    public static final String DEF_MOD_SQL7 = "INSERT INTO modulo" + "(id,acronimo,nombre,codigo,horasCurso,curso)" + "values" + "(?,?,?,?,?,?);";
    public static final String DEF_MOD_SQL14 = "INSERT INTO MODULO" + "(id,acronimo,nombre,codigo,horasCurso,curso)" + "values" + "(14,'PS','Programacion Servidor','MP0494',700,2)";
    public static final String DEF_MOD_SQL15 = "INSERT INTO MODULO" + "(id,acronimo,nombre,codigo,horasCurso,curso)" + "values" + "(15,'EMP','Empresa','MP0498',400,2)";
    public static final String DEF_MOD_SQL16 = "INSERT INTO MODULO" + "(id,acronimo,nombre,codigo,horasCurso,curso)" + "values" + "(16,'ING','Ingles Tecnico','MP0499',400,2)";

    public static final String CAB_LIST_MOD1 = "#    Id   Acrónimo   Nombre Modulo              Código   Horas   Curso";
    public static final String CAB_LIST_MOD2 = "=== ==== ========== =========================  ======== ======= ======= ";

    public static final String CAB_LIST_CIC1 = "#      Id    Acrónimo    Nombre Ciclo                                      Código       Grado             Familia";
    public static final String CAB_LIST_CIC2 = "============================================================================================================================";

    public static final String CAB_LIST_PRO1 = "#      Id         Nombre                Apellidos           Departamento     Especialidad               Tipo";
    public static final String CAB_LIST_PRO2 = "============================================================================================================================";

    public static final String CAB_LIST_ALU1 = "";
    public static final String CAB_LIST_ALU2 = "";
    public static final String CAB_LIST_PROF = "";
    public static final String CAB_LIST_PROF2 = "";

    public static final String CAB_REG_MOD1 = "Proceso de borrado - Registro %02d";
    public static final String CAB_REG_MOD2 = "==================================";
    public static final int LINEAS_PAGINA = 3;

    private Connection con;
    private Statement stmt;

    public DataAccessManager(Connection con) {
        this.con = con;
    }

    public DataAccessManager(Connection con, Statement stmt) {
        this.con = con;
        this.stmt = stmt;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    public final void mostrarMetadatos() throws SQLException {
        DatabaseMetaData dmd = con.getMetaData();
        System.out.println("Información BASE DE DATOS");
        System.out.println("==========================");
        System.out.printf("Usuario ...: %s%n", dmd.getUserName());
        System.out.printf("Base de datos ...: %s%n", dmd.getDatabaseProductName());
        System.out.printf("Version SGBD ...: %s%n", dmd.getDatabaseProductVersion());
        System.out.printf("Driver JDBC ...: %s%n", dmd.getDriverName());
        System.out.printf("Versión JDBC ...: %2d.%d%n", dmd.getJDBCMajorVersion(), dmd.getJDBCMinorVersion());
    }

    public final void listarModulos() throws SQLException {

        System.out.println("Listado de modulos...: ");
        System.out.println("---");
        try (ResultSet rs = stmt.executeQuery(DEF_SQL_MOD)) {
            if (rs.next()) {
                System.out.println(CAB_LIST_MOD1);
                System.out.println(CAB_LIST_MOD2);
                do {
                    int fila = rs.getRow();
                    int id = rs.getInt("id");
                    String acro = rs.getString("acronimo");
                    String nombre = rs.getString("nombre");
                    String cod = rs.getString("codigo");
                    int hor = rs.getInt("horasCurso");
                    int cur = rs.getInt("curso");
                    System.out.printf("%02d %5d %10s %25s %9s %7d %7d %n", fila, id, acro, nombre, cod, hor, cur);
                } while (rs.next());
            } else {
                System.out.println("No hay datos que mostrar");
            }
        }
    }

    public final void borrarModulos() throws SQLException {
        System.out.println("Borrado de modulos...");
        System.out.println("---");
        int filas = stmt.executeUpdate(DEF_MOD_SQL2);
        System.out.printf("Se han borrado %d modulos %n", filas);
    }

    public final void insercionModulos() throws SQLException {
        System.out.println("Insercion de modulos...");
        System.out.println("---");
        int filas = stmt.executeUpdate(DEF_MOD_SQL3);
        System.out.printf("Se han insertado %d modulos %n", filas);
    }

    public final void modificarModulos() throws SQLException {
        System.out.println("Modificacion de modulos...");
        System.out.println("---");
        int filas = stmt.executeUpdate(DEF_MOD_SQL4);
        System.out.printf("Se han modificado %d modulos %n", filas);
    }

    public final void insercionModulosPreparados() throws SQLException {

        String sql = "INSERT INTO modulo values (?,?,?,?,?,?);";

        PreparedStatement sentencia = getCon().prepareStatement(sql);

        sentencia.setInt(1, 7);
        sentencia.setString(2, "SIS");
        sentencia.setString(3, "Sistemas");
        sentencia.setString(4, "MP5005");
        sentencia.setInt(5, 150);
        sentencia.setInt(6, 1);

        System.out.println("Modificacion de modulos preparados...");
        System.out.println("---");
        sentencia.executeUpdate();

    }

    public final void insercionModulosPreparadosPacheco() throws SQLException {

        System.out.println("Insercion de modulos...:");
        System.out.println("---");
        int id = UtilesEntrada.leerEntero("Id...:", "ERROR Entrada erronea");
        System.out.println("---");
        try (ResultSet rs = stmt.executeQuery(String.format(DEF_MOD_SQL5, id))) {
            if (rs.next()) {
                System.out.println("ERROR:Ya existe el modulo a insertar");
            } else {
                try (PreparedStatement pstmt = con.prepareCall(DEF_MOD_SQL7)) {
                    int numReg = 0;
                    pstmt.setInt(1, id);
                    pstmt.setString(2, UtilesEntrada.leerTexto("Acronimo...:"));
                    pstmt.setString(3, UtilesEntrada.leerTexto("Nombre...:"));
                    pstmt.setString(4, UtilesEntrada.leerTexto("Codigo...:"));
                    pstmt.setInt(5, UtilesEntrada.leerEntero("Horas curso...:", "ERROR:Entrada incorrecta"));
                    pstmt.setInt(6, UtilesEntrada.leerEntero("Curso...:", "ERROR:Entrada incorrecta"));
                    char respuesta = UtilesEntrada.leerOpcion("SsNn", "Insertar modulo (S/N)...:", "ERROR:Entrada incorrecta");
                    if (respuesta == 'S' || respuesta == 's') {
                        numReg = pstmt.executeUpdate();
                        System.out.println("Insercion REALIZADA");
                    } else {
                        System.out.println("Insercion CANCELADA");
                    }
                    System.out.println(numReg + " registros insertados");
                }
            }
        }
    }

    public final void insertarModulosLotes() throws SQLException {
        System.out.println("Insertar modulos por lotes");
        System.out.println("---");
        try {
            con.setAutoCommit(false);
            stmt.addBatch(DEF_MOD_SQL14);
            stmt.addBatch(DEF_MOD_SQL15);
            stmt.addBatch(DEF_MOD_SQL16);
            int[] filas = stmt.executeBatch();
            con.commit();
            System.out.println(filas.length + " operaciones realizadas");
        } finally {
            con.setAutoCommit(true);
        }
    }

    public final void insercionModulosPreparadosObject(Modulo modulo) throws SQLException {

        String sql = "INSERT INTO modulo values (?,?,?,?,?,?);";

        PreparedStatement sentencia = getCon().prepareStatement(sql);

        sentencia.setInt(1, modulo.getId());
        sentencia.setString(2, modulo.getAcronimo());
        sentencia.setString(3, modulo.getNombre());
        sentencia.setString(4, modulo.getCodigo());
        sentencia.setInt(5, modulo.getHorasCurso());
        sentencia.setInt(6, modulo.getCurso());

        System.out.println("Modificacion de modulos preparados...");
        System.out.println("---");
        sentencia.executeUpdate();

    }

    public final void listadoModulosInteractivo(int lineasPagina) throws SQLException {
        if (lineasPagina <= 0) {
            listarModulos();
        } else {
            System.out.println("Listado de modulos...");
            System.out.println("---");
            try (ResultSet rs = stmt.executeQuery(DEF_SQL_MOD)) {
                if (rs.next()) {
                    boolean nuevaLineaOK;
                    int lineaAct = 1;
                    int paginaAct = 1;
                    do {
                        System.out.printf("Pagina...:%02d%n", paginaAct);
                        System.out.println("=============");
                        System.out.println(CAB_LIST_MOD1);
                        System.out.println(CAB_LIST_MOD2);
                        do {
                            int fila = rs.getRow();
                            int id = rs.getInt("id");
                            String acronimo = rs.getString("acronimo");
                            String nombre = rs.getString("nombre");
                            String codigo = rs.getString("codigo");
                            int horasCurso = rs.getInt("horasCurso");
                            int curso = rs.getInt("curso");
                            System.out.printf("%02d %5d %10s %25s %9s %7d %7d %n", fila, id, acronimo, nombre, codigo, horasCurso, curso);
                            lineaAct++;
                            nuevaLineaOK = rs.next();
                        } while (lineaAct <= lineasPagina && nuevaLineaOK);
                        if (nuevaLineaOK) {
                            System.out.println("---");
                            char respuesta = UtilesEntrada.leerOpcion("sSnN", "Siguente pagina (S/N)...:", "ERROR,Entrada incorrecta");
                            if (respuesta == 's' || respuesta == 'S') {
                                paginaAct++;
                                lineaAct = 1;
                                System.out.println("---");
                            } else {
                                nuevaLineaOK = false;
                            }
                        }
                    } while (nuevaLineaOK);
                } else {
                    System.out.println("No hay modulos que mostrar");
                }
            }
        }
    }

    public final void listadoCiclosInteractivo(int lineasPagina) throws SQLException {
        if (lineasPagina <= 0) {
            listarModulos();
        } else {
            System.out.println("Listado de ciclos...");
            System.out.println("---");
            try (ResultSet rs = stmt.executeQuery(DEF_SQL_CIC)) {
                if (rs.next()) {
                    boolean nuevaLineaOK;
                    int lineaAct = 1;
                    int paginaAct = 1;
                    do {
                        System.out.printf("Pagina...:%02d%n", paginaAct);
                        System.out.println("=============");
                        System.out.println(CAB_LIST_CIC1);
                        System.out.println(CAB_LIST_CIC2);
                        do {
                            int fila = rs.getRow();
                            int id = rs.getInt("id");
                            String acro = rs.getString("acronimo");
                            String nombre = rs.getString("nombre");
                            String cod = rs.getString("codigo");
                            String grado = rs.getString("grado");
                            String familia = rs.getString("familia");
                            System.out.printf("%02d %5d %10s %50s %9s %15s %20s %n", fila, id, acro, nombre, cod, grado, familia);
                            lineaAct++;
                            nuevaLineaOK = rs.next();
                        } while (lineaAct <= lineasPagina && nuevaLineaOK);
                        if (nuevaLineaOK) {
                            System.out.println("---");
                            char respuesta = UtilesEntrada.leerOpcion("sSnN", "Siguente pagina (S/N)...:", "ERROR,Entrada incorrecta");
                            if (respuesta == 's' || respuesta == 'S') {
                                paginaAct++;
                                lineaAct = 1;
                                System.out.println("---");
                            } else {
                                nuevaLineaOK = false;
                            }
                        }
                    } while (nuevaLineaOK);
                } else {
                    System.out.println("No hay ciclos que mostrar");
                }
            }
        }
    }

    public final void listadoProfesInteractivo(int lineasPagina) throws SQLException {
        if (lineasPagina <= 0) {
            listarModulos();
        } else {
            System.out.println("Listado de ciclos...");
            System.out.println("---");
            try (ResultSet rs = stmt.executeQuery(DEF_SQL_PRO)) {
                if (rs.next()) {
                    boolean nuevaLineaOK;
                    int lineaAct = 1;
                    int paginaAct = 1;
                    do {
                        System.out.printf("Pagina...:%02d%n", paginaAct);
                        System.out.println("=============");
                        System.out.println(CAB_LIST_PRO1);
                        System.out.println(CAB_LIST_PRO2);
                        do {
                            int fila = rs.getRow();
                            int id = rs.getInt("id");
                            String nombre = rs.getString("nombre");
                            String ape = rs.getString("apellidos");
                            String dept = rs.getString("departamento");
                            String espe = rs.getString("especialidad");
                            String tipo = rs.getString("tipo");
                            System.out.printf("%02d %5d %20s %20s %20s %15s %20s %n", fila, id, nombre, ape, dept, espe, tipo);
                            lineaAct++;
                            nuevaLineaOK = rs.next();
                        } while (lineaAct <= lineasPagina && nuevaLineaOK);
                        if (nuevaLineaOK) {
                            System.out.println("---");
                            char respuesta = UtilesEntrada.leerOpcion("sSnN", "Siguente pagina (S/N)...:", "ERROR,Entrada incorrecta");
                            if (respuesta == 's' || respuesta == 'S') {
                                paginaAct++;
                                lineaAct = 1;
                                System.out.println("---");
                            } else {
                                nuevaLineaOK = false;
                            }
                        }
                    } while (nuevaLineaOK);
                } else {
                    System.out.println("No hay profesores que mostrar");
                }
            }
        }
    }

    public final void borrarModulosInteractivo() throws SQLException {
        System.out.println("Borrado de modulos...");
        System.out.println("---");
        try (ResultSet rs = stmt.executeQuery(DEF_SQL_MOD)) {
            int regBorrados = 0;
            while (rs.next()) {
                System.out.printf(CAB_REG_MOD1 + "%n", rs.getRow());
                System.out.println(CAB_REG_MOD2);
                System.out.printf("Id.........: %d%n", rs.getInt(1));
                System.out.printf("Acronimo...: %s%n", rs.getString(2));
                System.out.printf("Nombre.....: %s%n", rs.getString(3));
                char respuesta = UtilesEntrada.leerOpcion("SsNn", "Borrar Modulo (S/N)", "ERROR:Entrada incorrecta");
                if (respuesta == 'S' || respuesta == 's') {
                    rs.deleteRow();
                    regBorrados++;
                    System.out.println("---");
                    System.out.println("Modulo actual borrado");
                }
                System.out.println("---");
            }
            System.out.printf("Se han borrado %d modulos %n", regBorrados);
        }
    }

    public final void borrarCiclosInteractivo() throws SQLException {
        System.out.println("Borrado de ciclos...");
        System.out.println("---");
        try (ResultSet rs = stmt.executeQuery(DEF_SQL_CIC)) {
            int regBorrados = 0;
            while (rs.next()) {
                System.out.printf(CAB_REG_MOD1 + "%n", rs.getRow());
                System.out.println(CAB_REG_MOD2);
                System.out.printf("Id.........: %d%n", rs.getInt(1));
                System.out.printf("Acronimo...: %s%n", rs.getString(2));
                System.out.printf("Nombre.....: %s%n", rs.getString(3));
                char respuesta = UtilesEntrada.leerOpcion("SsNn", "Borrar Ciclo (S/N)", "ERROR:Entrada incorrecta");
                if (respuesta == 'S' || respuesta == 's') {
                    rs.deleteRow();
                    regBorrados++;
                    System.out.println("---");
                    System.out.println("Ciclo actual borrado");
                }
                System.out.println("---");
            }
            System.out.printf("Se han borrado %d ciclos %n", regBorrados);
        }
    }

    public final void borrarProfesInteractivo() throws SQLException {
        System.out.println("Borrado de profesores...");
        System.out.println("---");
        try (ResultSet rs = stmt.executeQuery(DEF_SQL_PRO)) {
            int regBorrados = 0;
            while (rs.next()) {
                System.out.printf(CAB_REG_MOD1 + "%n", rs.getRow());
                System.out.println(CAB_REG_MOD2);
                System.out.printf("Id.........: %d%n", rs.getInt(1));
                System.out.printf("Nombre...: %s%n", rs.getString(2));
                System.out.printf("Apellidos.....: %s%n", rs.getString(3));
                char respuesta = UtilesEntrada.leerOpcion("SsNn", "Borrar Profesor (S/N)", "ERROR:Entrada incorrecta");
                if (respuesta == 'S' || respuesta == 's') {
                    rs.deleteRow();
                    regBorrados++;
                    System.out.println("---");
                    System.out.println("Profesor actual borrado");
                }
                System.out.println("---");
            }
            System.out.printf("Se han borrado %d profesores %n", regBorrados);
        }
    }

    public final void insertarModulosInteractivo() throws SQLException {
        System.out.println("Insercion de modulos...");
        System.out.println("---");
        try (ResultSet rs = stmt.executeQuery(DEF_SQL_MOD)) {
            rs.moveToInsertRow();
            rs.updateInt(1, UtilesEntrada.leerEntero("ID........:", "ERROR:Entrada Incorrecta"));
            rs.updateString(2, UtilesEntrada.leerTexto("Acronimo...:"));
            rs.updateString(3, UtilesEntrada.leerTexto("Nombre.....:"));
            rs.updateString(4, UtilesEntrada.leerTexto("Codigo.....:"));
            rs.updateInt(5, UtilesEntrada.leerEntero("Horas......:", "ERROR:Entrada Incorrecta"));
            rs.updateInt(6, UtilesEntrada.leerEntero("Curso......:", "ERROR:Entrada Incorrecta"));
            System.out.println("---");
            char respuesta = UtilesEntrada.leerOpcion("SsNn", "Insertar Modulo (S/N)...:", "ERROR: Entrada incorrecta");
            if (respuesta == 's' || respuesta == 'S') {
                rs.insertRow();
                System.out.println("---");
                System.out.println("Insercion de datos COMPLETADA");
            } else {
                System.out.println("---");
                System.out.println("Insercion de datos CANCELADA");
            }
            rs.moveToCurrentRow();
        }
    }

    public final void insertarCiclosInteractivo() throws SQLException {
        System.out.println("Insercion de ciclos...");
        System.out.println("---");
        try (ResultSet rs = stmt.executeQuery(DEF_SQL_CIC)) {
            rs.moveToInsertRow();
            rs.updateInt(1, UtilesEntrada.leerEntero("ID........:", "ERROR:Entrada Incorrecta"));
            rs.updateString(2, UtilesEntrada.leerTexto("Acronimo...:"));
            rs.updateString(3, UtilesEntrada.leerTexto("Nombre.....:"));
            rs.updateString(4, UtilesEntrada.leerTexto("Codigo.....:"));
            rs.updateString(5, UtilesEntrada.leerTexto("Grado......:"));
            rs.updateString(6, UtilesEntrada.leerTexto("Familia....:"));
            System.out.println("---");
            char respuesta = UtilesEntrada.leerOpcion("SsNn", "Insertar Ciclo (S/N)...:", "ERROR: Entrada incorrecta");
            if (respuesta == 's' || respuesta == 'S') {
                rs.insertRow();
                System.out.println("---");
                System.out.println("Insercion de datos COMPLETADA");
            } else {
                System.out.println("---");
                System.out.println("Insercion de datos CANCELADA");
            }
            rs.moveToCurrentRow();
        }
    }

    public final void insertarProfeInteractivo() throws SQLException {
        System.out.println("Insercion de profesores...");
        System.out.println("---");
        try (ResultSet rs = stmt.executeQuery(DEF_SQL_PRO)) {
            rs.moveToInsertRow();
            rs.updateInt(1, UtilesEntrada.leerEntero("ID........:", "ERROR:Entrada Incorrecta"));
            rs.updateString(2, UtilesEntrada.leerTexto("Nombre........:"));
            rs.updateString(3, UtilesEntrada.leerTexto("Apellidos.....:"));
            rs.updateString(4, UtilesEntrada.leerTexto("Departamento..:"));
            rs.updateString(5, UtilesEntrada.leerTexto("Especialidad..:"));
            rs.updateString(6, UtilesEntrada.leerTexto("Tipo..........:"));
            System.out.println("---");
            char respuesta = UtilesEntrada.leerOpcion("SsNn", "Insertar Profesor (S/N)...:", "ERROR: Entrada incorrecta");
            if (respuesta == 's' || respuesta == 'S') {
                rs.insertRow();
                System.out.println("---");
                System.out.println("Insercion de datos COMPLETADA");
            } else {
                System.out.println("---");
                System.out.println("Insercion de datos CANCELADA");
            }
            rs.moveToCurrentRow();
        }
    }

    public final void listarCiclos() throws SQLException {

        System.out.println("Listado de ciclos...: ");
        System.out.println("---");
        try (ResultSet rs = stmt.executeQuery(DEF_SQL_CIC)) {
            if (rs.next()) {
                System.out.println(CAB_LIST_CIC1);
                System.out.println(CAB_LIST_CIC2);
                do {
                    int fila = rs.getRow();
                    int id = rs.getInt("id");
                    String acro = rs.getString("acronimo");
                    String nombre = rs.getString("nombre");
                    String cod = rs.getString("codigo");
                    String grado = rs.getString("grado");
                    String familia = rs.getString("familia");
                    System.out.printf("%02d %5d %10s %50s %9s %15s %20s %n", fila, id, acro, nombre, cod, grado, familia);
                } while (rs.next());
            } else {
                System.out.println("No hay datos que mostrar");
            }
        }
    }

    public final void listarProfesores() throws SQLException {

        System.out.println("Listado de ciclos...: ");
        System.out.println("---");
        try (ResultSet rs = stmt.executeQuery(DEF_SQL_PRO)) {
            if (rs.next()) {
                System.out.println(CAB_LIST_PRO1);
                System.out.println(CAB_LIST_PRO2);
                do {
                    int fila = rs.getRow();
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String ape = rs.getString("apellidos");
                    String dept = rs.getString("departamento");
                    String espe = rs.getString("especialidad");
                    String tipo = rs.getString("tipo");
                    System.out.printf("%02d %5d %20s %20s %20s %15s %20s %n", fila, id, nombre, ape, dept, espe, tipo);
                } while (rs.next());
            } else {
                System.out.println("No hay datos que mostrar");
            }
        }
    }

    public final void modificarModulosInteractivo() throws SQLException {
        System.out.println("Actualizacion de módulos...");
        System.out.println("---");
        int id = UtilesEntrada.leerEntero("Id busqueda...:", "ERROR:Entrada incorrecta");
        try (ResultSet rs = stmt.executeQuery(String.format(DEF_MOD_SQL5, id + ""))) {
            if (rs.next()) {
                System.out.println("Registro actual - Estado INICIAL");
                System.out.println("================================");
                System.out.printf("Acronimo...: %s%n", rs.getString("acronimo"));
                System.out.printf("Nombre.....: %s%n", rs.getString("nombre"));
                System.out.printf("Codigo.....: %s%n", rs.getString("codigo"));
                System.out.printf("Horas......: %s%n", rs.getInt("horasCurso"));
                System.out.printf("Curso......: %s%n", rs.getInt("curso"));
                System.out.println("Registro actual - Estado FINAL");
                System.out.println("==============================");
                rs.updateString(2, UtilesEntrada.leerTexto("Acronimo...:"));
                rs.updateString(3, UtilesEntrada.leerTexto("Nombre.....:"));
                rs.updateString(4, UtilesEntrada.leerTexto("Codigo.....:"));
                rs.updateInt(5, UtilesEntrada.leerEntero("Horas......:", "ERROR:Lectura Incorrecta"));
                rs.updateInt(6, UtilesEntrada.leerEntero("Curso......:", "ERROR:Lectura Incorrecta"));
                System.out.println("---");
                char respuesta = UtilesEntrada.leerOpcion("SsNn", "Actualizar MODULO (S/N)....:", "ERROR: Lectura Incorrecta");
                System.out.println("---");
                if (respuesta == 's' || respuesta == 'S') {
                    rs.updateRow();
                    System.out.println("Actualizacion COMPLETADA");
                } else {
                    System.out.println("Actualizacion CANCELADA");
                }
            } else {
                System.out.println("ERROR: No hay datos asociados");
            }
        }
    }

    public final void modificarCiclosInteractivo() throws SQLException {
        System.out.println("Actualizacion de ciclos...");
        System.out.println("---");
        int id = UtilesEntrada.leerEntero("Id busqueda...:", "ERROR:Entrada incorrecta");
        try (ResultSet rs = stmt.executeQuery(String.format(DEF_MOD_SQL6, id + ""))) {
            if (rs.next()) {
                System.out.println("Registro actual - Estado INICIAL");
                System.out.println("================================");
                System.out.printf("Acronimo...: %s%n", rs.getString("acronimo"));
                System.out.printf("Nombre.....: %s%n", rs.getString("nombre"));
                System.out.printf("Codigo.....: %s%n", rs.getString("codigo"));
                System.out.printf("Grado......: %s%n", rs.getString("grado"));
                System.out.printf("Familia....: %s%n", rs.getString("familia"));
                System.out.println("Registro actual - Estado FINAL");
                System.out.println("==============================");
                rs.updateString(2, UtilesEntrada.leerTexto("Acronimo....:"));
                rs.updateString(3, UtilesEntrada.leerTexto("Nombre......:"));
                rs.updateString(4, UtilesEntrada.leerTexto("Codigo......:"));
                rs.updateString(5, UtilesEntrada.leerTexto("Grado.......:"));
                rs.updateString(6, UtilesEntrada.leerTexto("Familia.....:"));
                System.out.println("---");
                char respuesta = UtilesEntrada.leerOpcion("SsNn", "Actualizar CICLO (S/N)....:", "ERROR: Lectura Incorrecta");
                System.out.println("---");
                if (respuesta == 's' || respuesta == 'S') {
                    rs.updateRow();
                    System.out.println("Actualizacion COMPLETADA");
                } else {
                    System.out.println("Actualizacion CANCELADA");
                }
            } else {
                System.out.println("ERROR: No hay datos asociados");
            }
        }
    }

    public final void modificarProfesInteractivo() throws SQLException {
        System.out.println("Actualizacion de profesores...");
        System.out.println("---");
        int id = UtilesEntrada.leerEntero("Id busqueda...:", "ERROR:Entrada incorrecta");
        try (ResultSet rs = stmt.executeQuery(String.format(DEF_MOD_SQL6, id + ""))) {
            if (rs.next()) {
                System.out.println("Registro actual - Estado INICIAL");
                System.out.println("================================");
                System.out.printf("Nombre.......: %s%n", rs.getString("nombre"));
                System.out.printf("Apellidos....: %s%n", rs.getString("apellidos"));
                System.out.printf("Departamento.: %s%n", rs.getString("departamento"));
                System.out.printf("Especialidad.: %s%n", rs.getString("especialidad"));
                System.out.printf("Tipo.........: %s%n", rs.getString("tipo"));
                System.out.println("Registro actual - Estado FINAL");
                System.out.println("==============================");
                rs.updateString(2, UtilesEntrada.leerTexto("Nombre.......:"));
                rs.updateString(3, UtilesEntrada.leerTexto("Apellidos....:"));
                rs.updateString(4, UtilesEntrada.leerTexto("Departamento.:"));
                rs.updateString(5, UtilesEntrada.leerTexto("Especialidad.:"));
                rs.updateString(6, UtilesEntrada.leerTexto("Tipo.........:"));
                System.out.println("---");
                char respuesta = UtilesEntrada.leerOpcion("SsNn", "Actualizar CICLO (S/N)....:", "ERROR: Lectura Incorrecta");
                System.out.println("---");
                if (respuesta == 's' || respuesta == 'S') {
                    rs.updateRow();
                    System.out.println("Actualizacion COMPLETADA");
                } else {
                    System.out.println("Actualizacion CANCELADA");
                }
            } else {
                System.out.println("ERROR: No hay datos asociados");
            }
        }
    }
}
