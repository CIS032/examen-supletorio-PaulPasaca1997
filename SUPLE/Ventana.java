/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SUPLE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Ventana extends javax.swing.JFrame {

    public Ventana() {
        initComponents();
        INGRESAR();
    }
    Connection conexion = null;

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        presentar = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        presentar.setColumns(20);
        presentar.setRows(5);
        jScrollPane1.setViewportView(presentar);

        jButton1.setText("Nombre y Precio");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Entre 100 y 350");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Articulos con descuento");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Listado Completo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jButton4))))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CARGARBD();
        try {
        Statement sentencia = conexion.createStatement();
        ResultSet registros = sentencia.executeQuery("select *from articulos ");
        String lista = "";
        while (registros.next()) {
        String clave1 = registros.getString("CLAVE_ARTICULO");
        String nombre = registros.getString("NOMBRE");
        String precio = registros.getString("PRECIO");

        lista = lista + clave1 + " - " + nombre + " - " + precio  + "\n";
        }
        registros.close();
        conexion.close();
        presentar.setText(lista);
        } catch (SQLException sqlex) {
        System.out.println("error" + sqlex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        CARGARBD();
        try {
        Statement sentencia = conexion.createStatement();
        ResultSet registros = sentencia.executeQuery("select *from articulos where precio>100 and precio <350");
        String lista = "";
        while (registros.next()) {
        String clave1 = registros.getString("CLAVE_ARTICULO");
        String nombre = registros.getString("NOMBRE");
        String precio = registros.getString("PRECIO");
        String fabricante = registros.getString("CLAVE_FABRICANTE");
        System.out.printf("%s %-60s %4s %4s %n", clave1, nombre, precio, fabricante);

        lista = lista + clave1 + " - " + nombre + " - " + precio + " - " + fabricante + "\n";
        }
        registros.close();
        conexion.close();
        presentar.setText(lista);
        } catch (SQLException sqlex) {
        System.out.println("error" + sqlex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        CARGARBD();
        try {
        Statement sentencia = conexion.createStatement();
        ResultSet registros = sentencia.executeQuery("select *from articulos where precio>=450");
        String lista = "";
        while (registros.next()) {
        String clave1 = registros.getString("CLAVE_ARTICULO");
        String nombre = registros.getString("NOMBRE");
        int precio = registros.getInt("PRECIO");
        String fabricante = registros.getString("CLAVE_FABRICANTE");
        System.out.printf("%s %-60s %4s %4s %n", clave1, nombre, precio, fabricante);
        double p = precio - (precio * 0.1);
        lista = lista + clave1 + " - " + nombre + " - " + precio + " - " + "descuento: " + p + "\n";
        }
        registros.close();
        conexion.close();
        presentar.setText(lista);
        } catch (SQLException sqlex) {
        System.out.println("error" + sqlex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        CARGARBD();
        String[] list = new String[5];
        int i = 0;
        try {
        Statement sentencia = conexion.createStatement();
        ResultSet registros = sentencia.executeQuery("select *from FABRICANTES ");
        while (registros.next()) {
        list[i] = registros.getString("NOMBRE");
        i++;

        }
        registros.close();
        } catch (SQLException sqlex) {
        System.out.println("error" + sqlex);
        }
        try {
        Statement sentencia = conexion.createStatement();
        ResultSet registros = sentencia.executeQuery("select *from articulos ");
        String lista = "";
        int x = 0;
        while (registros.next()) {
        String clave1 = registros.getString("CLAVE_ARTICULO");
        String nombre = registros.getString("NOMBRE");
        int precio = registros.getInt("PRECIO");
        String fabricante = registros.getString("CLAVE_FABRICANTE");
        String v = "";
        try {
        Statement sen = conexion.createStatement();
        String m = "select *from FABRICANTES where CLAVE_FABRICANTE like " + fabricante;
        ResultSet reg = sen.executeQuery("select *from FABRICANTES where CLAVE_FABRICANTE like '" + fabricante+"%'");
        while (reg.next()) {
        v = reg.getString("NOMBRE");
        }
        reg.close();
        } catch (SQLException sqlex) {
        System.out.println("error" + sqlex);
        }

        System.out.println("daasas"+v);

        lista = lista + clave1 + " - " + nombre + " - " + precio + " - "+ fabricante + " - " + v + "\n";
        System.out.println(lista);
        x = 0;
        }
        registros.close();
        conexion.close();
        presentar.setText(lista);

        } catch (SQLException sqlex) {
        System.out.println("error" + sqlex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea presentar;
    // End of variables declaration//GEN-END:variables

    public void CARGARBD() {

        try {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        System.out.println("Driver cargado !!!");
        } catch (ClassNotFoundException cnfe) {
        System.out.println("Error al cargar Driver " + cnfe);
        }

        try {
        String urlbd = "jdbc:derby://localhost:1527/tienda";
        conexion = DriverManager.getConnection(urlbd, "tienda", "suple");
        System.out.println("Conexion satisfactoria !!!");
        } catch (SQLException sqlex) {
        System.out.println("Error al establecer conexion a la BD: " + sqlex);
        }
    }

    public void INGRESAR() {
        CARGARBD();
        try {
        System.out.println("ddewe");
        Statement sentencia = conexion.createStatement();
        ResultSet registros = sentencia.executeQuery("select *from articulos ");
        String sqlInsert = String.format("INSERT INTO articulos VALUES('%s', '%s', '%s', %d)",
        "1",
        "Teclado",
        "3",
        100);
        System.out.println(sqlInsert);
        int r = sentencia.executeUpdate(sqlInsert);
        System.out.println(sqlInsert);
        System.out.println("Se ha modificado 1");

        sqlInsert = String.format("INSERT INTO articulos VALUES('%s', '%s', '%s', %d)",
        "2",
        "Disco duro 300 Gb",
        "5",
        500);
        r = sentencia.executeUpdate(sqlInsert);

        System.out.println("Se ha modificado");

        sqlInsert = String.format("INSERT INTO articulos VALUES('%s', '%s', '%s', %d)",
        "3",
        "Mouse",
        "3",
        80);
        r = sentencia.executeUpdate(sqlInsert);

        System.out.println("Se ha modificado");

        sqlInsert = String.format("INSERT INTO articulos VALUES('%s', '%s', '%s', %d)",
        "4",
        "Memoria USB",
        "4",
        140);
        r = sentencia.executeUpdate(sqlInsert);

        System.out.println("Se ha modificado");

        sqlInsert = String.format("INSERT INTO articulos VALUES('%s', '%s', '%s', %d)",
        "5",
        "Memoria RAM",
        "1",
        290);
        r = sentencia.executeUpdate(sqlInsert);

        System.out.println("Se ha modificado");

        sqlInsert = String.format("INSERT INTO articulos VALUES('%s', '%s', '%s', %d)",
        "6",
        "Disco duro ext. 250 Gb",
        65,
        650);
        r = sentencia.executeUpdate(sqlInsert);

        System.out.println("Se ha modificado");

        sqlInsert = String.format("INSERT INTO articulos VALUES('%s', '%s', '%s', %d)",
        "7",
        "Memoria USB",
        "1",
        279);
        r = sentencia.executeUpdate(sqlInsert);

        System.out.println("Se ha modificado");

        sqlInsert = String.format("INSERT INTO articulos VALUES('%s', '%s', '%s', %d)",
        "8",
        "DVD Rom",
        "2",
        450);
        r = sentencia.executeUpdate(sqlInsert);

        System.out.println("Se ha modificado");

        sqlInsert = String.format("INSERT INTO articulos VALUES('%s', '%s', '%s', %d)",
        "9",
        "CD Rom",
        "2",
        200);
        r = sentencia.executeUpdate(sqlInsert);

        System.out.println("Se ha modificado");

        sqlInsert = String.format("INSERT INTO articulos VALUES('%s', '%s', '%s', %d)",
        "10",
        "Tarjeta de red",
        "3",
        180);
        r = sentencia.executeUpdate(sqlInsert);

        sqlInsert = String.format("INSERT INTO fabricantes VALUES('%s', '%s')",
        "1",
        "Kingston");
        r = sentencia.executeUpdate(sqlInsert);

        sqlInsert = String.format("INSERT INTO fabricantes VALUES('%s', '%s')",
        "2",
        "Adata");
        r = sentencia.executeUpdate(sqlInsert);
        sqlInsert = String.format("INSERT INTO fabricantes VALUES('%s', '%s')",
        "3",
        "Logitech");
        r = sentencia.executeUpdate(sqlInsert);
        sqlInsert = String.format("INSERT INTO fabricantes VALUES('%s', '%s')",
        "4",
        "Lexmark");
        r = sentencia.executeUpdate(sqlInsert);
        sqlInsert = String.format("INSERT INTO fabricantes VALUES('%s', '%s')",
        "5",
        "Seagate");
        r = sentencia.executeUpdate(sqlInsert);

        registros.close();
        conexion.close();

        } catch (SQLException sqlex) {
        System.out.println("error" + sqlex);
        }
    }
}
