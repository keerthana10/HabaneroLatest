/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openbravo.pos.sales;

import com.openbravo.basic.BasicException;
import com.openbravo.pos.forms.DataLogicSales;
import static com.openbravo.pos.sales.JRetailReprintReason.ticketno;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author shilpa
 */
public class JRetailSecondprintReason extends javax.swing.JDialog {
    int x = 500;
    int y = 300;
    int width = 350;
    int height = 280;
    static int ticketno=0;
    static Component parentLocal = null;
    private static DataLogicSales localDlSales = null;
    public static boolean status=false;
    /**
     * Creates new form JRetailReprintReason
     */
    
    
     public static boolean showMessage(Component parent, DataLogicSales dlSales, int ticketnum, String type) {
        localDlSales = dlSales;
        parentLocal = parent;
        ticketno=ticketnum;
        return showMessage(parent, dlSales, 1);
    }
     
      private static boolean showMessage(Component parent, DataLogicSales dlSales, int x) {

        Window window = getWindow(parent);
        JRetailSecondprintReason myMsg;
        if (window instanceof Frame) {
            myMsg = new JRetailSecondprintReason((Frame) window, true);
        } else {
            myMsg = new JRetailSecondprintReason((Dialog) window, true);
        }
         return  myMsg.init(dlSales);
    }
      
      
 private JRetailSecondprintReason(Frame frame, boolean b) {
        super(frame, true);
        setBounds(x, y, width, height);

    }

    private JRetailSecondprintReason(Dialog dialog, boolean b) {
        super(dialog, true);
        setBounds(x, y, width, height);

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        m_jreasonOk = new javax.swing.JButton();
        m_jCancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        m_jTxtReason = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Reason");

        m_jreasonOk.setBackground(new java.awt.Color(255, 255, 255));
        m_jreasonOk.setMnemonic(KeyEvent.VK_ENTER);
        m_jreasonOk.setText("Ok");
        m_jreasonOk.setMaximumSize(new java.awt.Dimension(83, 25));
        m_jreasonOk.setMinimumSize(new java.awt.Dimension(83, 25));
        m_jreasonOk.setPreferredSize(new java.awt.Dimension(83, 25));
        m_jreasonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jreasonOkActionPerformed(evt);
            }
        });

        m_jCancel.setBackground(new java.awt.Color(255, 255, 255));
        m_jCancel.setMnemonic(KeyEvent.VK_ENTER);
        m_jCancel.setText("Cancel");
        m_jCancel.setMaximumSize(new java.awt.Dimension(83, 25));
        m_jCancel.setMinimumSize(new java.awt.Dimension(83, 25));
        m_jCancel.setPreferredSize(new java.awt.Dimension(83, 25));
        m_jCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jCancelActionPerformed(evt);
            }
        });

        m_jTxtReason.setColumns(20);
        m_jTxtReason.setRows(5);
        m_jTxtReason.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ReasonMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(m_jTxtReason);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(m_jreasonOk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(m_jCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(m_jreasonOk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m_jCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void m_jreasonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jreasonOkActionPerformed
      String reason= m_jTxtReason.getText();
      System.out.println("action is"+"m_jreasonOkActionPerformed");
      if(reason.equals("")){
        JOptionPane.showMessageDialog(null, "Please give the reason");
      }else{
            try {  
                 localDlSales.disableInvoiceTickets(reason,ticketno);
            } catch (BasicException ex) {
                Logger.getLogger(JRetailReprintReason.class.getName()).log(Level.SEVERE, null, ex);
            }
        status=true;
        this.dispose();
      }
    }//GEN-LAST:event_m_jreasonOkActionPerformed

    private void m_jCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jCancelActionPerformed
         System.out.println("action is"+"m_jCancelActionPerformed"); 
        status=false;
        this.dispose();
       
    }//GEN-LAST:event_m_jCancelActionPerformed

    private void ReasonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReasonMousePressed
       if( System.getProperty("os.name").equalsIgnoreCase("Linux"))
            return;
        else
            try {
            Runtime.getRuntime().exec("cmd /c C:\\Windows\\System32\\osk.exe");
        } catch (IOException ex) {
            Logger.getLogger(JRetailReprintReason.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ReasonMousePressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        status=false;
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

   private static Window getWindow(Component parent) {
        if (parent == null) {
            return new JFrame();
        } else if (parent instanceof Frame || parent instanceof Dialog) {
            return (Window) parent;
        } else {
            return getWindow(parent.getParent());
        }
    }
   
       public boolean init(DataLogicSales dlSales) {
          initComponents();
          m_jTxtReason.setText("");
          setTitle("Reprint Reason");
          if( !System.getProperty("os.name").equalsIgnoreCase("Linux")){
            try {
            Runtime.getRuntime().exec("cmd /c C:\\Windows\\System32\\osk.exe");
            } catch (IOException ex) {
            Logger.getLogger(JRetailReprintReason.class.getName()).log(Level.SEVERE, null, ex);
          }
          }  
          setVisible(true);
          return status;
          }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton m_jCancel;
    private javax.swing.JTextArea m_jTxtReason;
    private javax.swing.JButton m_jreasonOk;
    // End of variables declaration//GEN-END:variables
}
