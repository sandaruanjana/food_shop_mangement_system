/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controller.OrderController;
import dto.OrderDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sandaru
 */
public class QueueForm extends javax.swing.JFrame {

    int orderID;

    /**
     * Creates new form QueueForm
     */
    public QueueForm() {
        initComponents();
        loadOrders();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblQueue = new javax.swing.JTable();
        btnCancelOrder = new javax.swing.JButton();
        btnPayOrder = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblQueue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Customer ID", "Order Type", "Status", "Payment"
            }
        ));
        tblQueue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQueueMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblQueue);

        btnCancelOrder.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCancelOrder.setText("Cancel Order");
        btnCancelOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelOrderActionPerformed(evt);
            }
        });

        btnPayOrder.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPayOrder.setText("Pay Order");
        btnPayOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayOrderActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Order Queue");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelOrder)
                        .addGap(18, 18, 18)
                        .addComponent(btnPayOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPayOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPayOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayOrderActionPerformed

        OrderDTO orderDTO = new OrderDTO(orderID);

        try {
            boolean payOrder = new OrderController().payOrder(orderDTO);
            if (payOrder) {
                JOptionPane.showMessageDialog(this, "Paid");
                loadOrders();
            } else {
                JOptionPane.showMessageDialog(this, "Paid Fail");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QueueForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QueueForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPayOrderActionPerformed

    private void tblQueueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQueueMouseClicked
        int row = tblQueue.getSelectedRow();

        orderID = Integer.parseInt(tblQueue.getValueAt(row, 0).toString());


    }//GEN-LAST:event_tblQueueMouseClicked

    private void btnCancelOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelOrderActionPerformed
            OrderDTO orderDTO = new OrderDTO(orderID);
            
        try {
                boolean cancelOrder = new OrderController().cancelOrder(orderDTO);
                if (cancelOrder) {
                    loadOrders();
                JOptionPane.showMessageDialog(this, "Order Canceled");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QueueForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QueueForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCancelOrderActionPerformed

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
            java.util.logging.Logger.getLogger(QueueForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QueueForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QueueForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QueueForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QueueForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelOrder;
    private javax.swing.JButton btnPayOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblQueue;
    // End of variables declaration//GEN-END:variables

    private void loadOrders() {
        DefaultTableModel dtm = (DefaultTableModel) tblQueue.getModel();
        dtm.setRowCount(0);

        try {
            ArrayList<OrderDTO> allOrders = new OrderController().getAllOrders();

            for (OrderDTO od : allOrders) {

                Object[] row = {od.getOrder_id(), od.getCid(), od.getOrder_type(), od.getStatus(), od.getPayment()};
                dtm.addRow(row);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QueueForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QueueForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
