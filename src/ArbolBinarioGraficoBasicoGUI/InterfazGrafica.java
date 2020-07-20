/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArbolBinarioGraficoBasicoGUI;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Maquina
 */
public class InterfazGrafica extends javax.swing.JFrame {
    
    private ArbolBinarioGraficoBasicoGUI arbol = new ArbolBinarioGraficoBasicoGUI();
    Interfaz intf = new Interfaz();
    JFrame ventana = new JFrame();

    /**
     * Creates new form InterfazGrafica
     */
    public InterfazGrafica() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jtxtdato = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jbtnInsertarDato = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 102)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("ARBOL BINARIO GUI");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 330, 50));
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtxtdato.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jPanel3.add(jtxtdato, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 220, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 330, 50));

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel2.setText("INGRESE UN DATO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        jbtnInsertarDato.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jbtnInsertarDato.setText("INSERTAR DATO AL ARBOL");
        jbtnInsertarDato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnInsertarDatoActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnInsertarDato, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 270, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnInsertarDatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnInsertarDatoActionPerformed
        // TODO add your handling code here:
        try {
            int dato = Integer.parseInt(jtxtdato.getText());
            this.arbol.insertar(dato);
            Ejecutor ej = new Ejecutor(intf, arbol);
            ej.inicio();
            JOptionPane.showMessageDialog(null, "Dato ingresado correctamente", "Informacion", 1);
            ventana.getContentPane().add(intf);
            ventana.setDefaultCloseOperation(3);
            ventana.setSize(500, 500);
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo insertar el dato", "Error", 0);
        }
    }//GEN-LAST:event_jbtnInsertarDatoActionPerformed

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
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazGrafica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jbtnInsertarDato;
    private javax.swing.JTextField jtxtdato;
    // End of variables declaration//GEN-END:variables
}