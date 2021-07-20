
package utp.desarrollo.ModeloCliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ModeloCliente extends javax.swing.JFrame {

    /**
     * Creates new form Facturacion
     */
    public ModeloCliente() {
        initComponents();
        DefaultTableModel modelo = new DefaultTableModel ();
        modelo.addColumn("Id cliente");
        modelo.addColumn("Nombre");
        modelo.addColumn("Fecha de creacion");
       
        jtresultado.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtextFecha = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtresultado = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Id del cliente");

        jtextFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtextFechaActionPerformed(evt);
            }
        });

        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jtresultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(jtresultado);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(jLabel1)
                        .addGap(45, 45, 45)
                        .addComponent(jtextFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 854, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtextFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String sql;
        String id=jtextFecha.getText();
        if(!id.equals("")){
             DefaultTableModel modelo = new DefaultTableModel ();
             String titulos[]={"Id cliente","Nombre","Fecha de cracion"};
             modelo=new DefaultTableModel(null,titulos);
             ConectarBaseDeDatos Con = new ConectarBaseDeDatos();
            try {
                Con.conectarDB();
                String datos [] = new String [3];
                sql=" SELECT  * ";
                sql+=" from clientes ";
                sql+=" where  id_cliente=? ";
                sql+=" GROUP BY  Nombre ";
                PreparedStatement st;
                 try {
                     st = Con.conexion.prepareStatement(sql);
                     st.setString(1, id);
                     ResultSet resultado=st.executeQuery();
                     resultado.last();
                     int count=resultado.getRow();
                     if (count!=0){
                          resultado.beforeFirst();
                          while(resultado.next()){
                                datos [0]=resultado.getString("id_cliente");
                                datos [1]=resultado.getString("Nombre");
                                datos [2]=resultado.getString("FechaCreacion");
                           
                                modelo.addRow(datos);
                         }
                         resultado.close();
                         jtresultado.setModel(modelo);
                         Con.desconectarDB();
                }else {
                     JOptionPane.showMessageDialog(rootPane," No hay datos para ese id ","",JOptionPane.WARNING_MESSAGE);
                }
   
                 } catch (SQLException ex) {
                     Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
                 }
                
 
            } catch (SQLException ex) {
                Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
             
             
        }else{
               JOptionPane.showMessageDialog(rootPane," Ingrese el id a Consultar ","",JOptionPane.WARNING_MESSAGE);
        }
      
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtextFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtextFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtextFechaActionPerformed

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
            java.util.logging.Logger.getLogger(ModeloCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModeloCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModeloCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModeloCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModeloCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtextFecha;
    private javax.swing.JTable jtresultado;
    // End of variables declaration//GEN-END:variables
}
