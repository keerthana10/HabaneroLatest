//    Openbravo POS is a point of sales application designed for touch screens.
//    Copyright (C) 2008-2009 Openbravo, S.L.
//    http://www.openbravo.com/product/pos
//
//    This file is part of Openbravo POS.
//
//    Openbravo POS is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    Openbravo POS is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with Openbravo POS.  If not, see <http://www.gnu.org/licenses/>.
package com.openbravo.pos.sales;

import com.openbravo.pos.customers.DataLogicCustomers;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.forms.DataLogicSales;
import com.openbravo.pos.sales.restaurant.JRetailTicketsBagRestaurantMap;
import com.openbravo.pos.ticket.RetailTicketInfo;
import com.openbravo.pos.ticket.TicketInfo;
import com.openbravo.pos.ticket.RetailTicketLineInfo;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Window;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author  adrianromero
 */
public class RetailReceiptSplit extends javax.swing.JDialog {

    private boolean accepted;
    static String window = null;
    RetailSimpleReceipt receiptone;
    RetailSimpleReceipt receipttwo;
    RetailTicketInfo retail1;
    Object ticketext;
    private static JRetailTicketsBagRestaurantMap m_restaurant;

    /** Creates new form RetailReceiptSplit */
    protected RetailReceiptSplit(java.awt.Frame parent) {
        super(parent, true);
    }

    /** Creates new form RetailReceiptSplit */
    protected RetailReceiptSplit(java.awt.Dialog parent) {
        super(parent, true);
    }

    private void init(String ticketline, DataLogicSales dlSales, DataLogicCustomers dlCustomers, RetailTaxesLogic taxeslogic) {

        initComponents();
        getRootPane().setDefaultButton(m_jButtonOK);

        receiptone = new RetailSimpleReceipt(ticketline, dlSales, dlCustomers, taxeslogic);
        receiptone.setCustomerEnabled(false);
        jPanel5.add(receiptone, BorderLayout.CENTER);

        receipttwo = new RetailSimpleReceipt(ticketline, dlSales, dlCustomers, taxeslogic);
        jPanel3.add(receipttwo, BorderLayout.CENTER);
    }

    public static RetailReceiptSplit getDialog(Component parent, String ticketline, DataLogicSales dlSales, DataLogicCustomers dlCustomers, RetailTaxesLogic taxeslogic) {

        Window window = getWindow(parent);

        RetailReceiptSplit myreceiptsplit;

        if (window instanceof Frame) {
            myreceiptsplit = new RetailReceiptSplit((Frame) window);
        } else {
            myreceiptsplit = new RetailReceiptSplit((Dialog) window);
        }

        myreceiptsplit.init(ticketline, dlSales, dlCustomers, taxeslogic);

        return myreceiptsplit;
    }

    protected static Window getWindow(Component parent) {
        if (parent == null) {
            return new JFrame();
        } else if (parent instanceof Frame || parent instanceof Dialog) {
            return (Window) parent;
        } else {
            return getWindow(parent.getParent());
        }
    }

    public boolean showDialog(RetailTicketInfo ticket, RetailTicketInfo ticket2, Object ticketext) {
        retail1 = ticket;
        this.ticketext = ticketext;
        receiptone.setTicket(ticket, ticketext);
        receipttwo.setTicket(ticket2, ticketext);

        setVisible(true);
        return accepted;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        m_jButtonOK = new javax.swing.JButton();
        m_jButtonCancel = new javax.swing.JButton();
        m_jButtonPrintBill = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jBtnToRightOne = new javax.swing.JButton();
        jBtnToLeftOne = new javax.swing.JButton();
        jBtnByFood = new javax.swing.JButton();
        jBtnByAlcohol = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(AppLocal.getIntString("caption.split")); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                WindowClosing(evt);
            }
        });

        m_jButtonOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/button_ok.png"))); // NOI18N
        m_jButtonOK.setText("Ok");
        m_jButtonOK.setFocusPainted(false);
        m_jButtonOK.setFocusable(false);
        m_jButtonOK.setMargin(new java.awt.Insets(8, 16, 8, 16));
        m_jButtonOK.setRequestFocusEnabled(false);
        m_jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jButtonOKActionPerformed(evt);
            }
        });
        jPanel2.add(m_jButtonOK);

        m_jButtonCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/button_cancel.png"))); // NOI18N
        m_jButtonCancel.setText(AppLocal.getIntString("Button.Cancel")); // NOI18N
        m_jButtonCancel.setFocusPainted(false);
        m_jButtonCancel.setFocusable(false);
        m_jButtonCancel.setMargin(new java.awt.Insets(8, 16, 8, 16));
        m_jButtonCancel.setRequestFocusEnabled(false);
        m_jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jButtonCancelActionPerformed(evt);
            }
        });
        jPanel2.add(m_jButtonCancel);

        m_jButtonPrintBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/button_ok.png"))); // NOI18N
        m_jButtonPrintBill.setText("Print");
        m_jButtonPrintBill.setFocusPainted(false);
        m_jButtonPrintBill.setFocusable(false);
        m_jButtonPrintBill.setMargin(new java.awt.Insets(8, 16, 8, 16));
        m_jButtonPrintBill.setRequestFocusEnabled(false);
        m_jButtonPrintBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jButtonPrintBillActionPerformed(evt);
            }
        });
        jPanel2.add(m_jButtonPrintBill);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jPanel5.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jPanel5);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jBtnToRightOne.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/split12.png"))); // NOI18N
        jBtnToRightOne.setFocusPainted(false);
        jBtnToRightOne.setFocusable(false);
        jBtnToRightOne.setPreferredSize(new java.awt.Dimension(51, 42));
        jBtnToRightOne.setRequestFocusEnabled(false);
        jBtnToRightOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnToRightOneActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel4.add(jBtnToRightOne, gridBagConstraints);

        jBtnToLeftOne.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/split13.png"))); // NOI18N
        jBtnToLeftOne.setFocusPainted(false);
        jBtnToLeftOne.setFocusable(false);
        jBtnToLeftOne.setPreferredSize(new java.awt.Dimension(51, 42));
        jBtnToLeftOne.setRequestFocusEnabled(false);
        jBtnToLeftOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnToLeftOneActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel4.add(jBtnToLeftOne, gridBagConstraints);

        jBtnByFood.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/split15.png"))); // NOI18N
        jBtnByFood.setFocusPainted(false);
        jBtnByFood.setFocusable(false);
        jBtnByFood.setMaximumSize(new java.awt.Dimension(71, 36));
        jBtnByFood.setMinimumSize(new java.awt.Dimension(71, 36));
        jBtnByFood.setPreferredSize(new java.awt.Dimension(51, 42));
        jBtnByFood.setRequestFocusEnabled(false);
        jBtnByFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnByFoodActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel4.add(jBtnByFood, gridBagConstraints);

        jBtnByAlcohol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/split16.png"))); // NOI18N
        jBtnByAlcohol.setFocusPainted(false);
        jBtnByAlcohol.setFocusable(false);
        jBtnByAlcohol.setMaximumSize(new java.awt.Dimension(71, 36));
        jBtnByAlcohol.setMinimumSize(new java.awt.Dimension(71, 36));
        jBtnByAlcohol.setPreferredSize(new java.awt.Dimension(51, 42));
        jBtnByAlcohol.setRequestFocusEnabled(false);
        jBtnByAlcohol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnByAlcoholActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel4.add(jBtnByAlcohol, gridBagConstraints);

        jPanel1.add(jPanel4);

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        jPanel3.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jPanel3);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-730)/2, (screenSize.height-470)/2, 730, 470);
    }// </editor-fold>//GEN-END:initComponents

    private void m_jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jButtonOKActionPerformed

        if (receipttwo.getTicket().getLinesCount() > 0) {
            window = "OK";
            accepted = true;
            dispose();
        }

    }//GEN-LAST:event_m_jButtonOKActionPerformed

    private void m_jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jButtonCancelActionPerformed
        dispose();

    }//GEN-LAST:event_m_jButtonCancelActionPerformed
    //Action performed is called when click on right arrow button for moving the selected item from left panel to right panel
    private void jBtnToRightOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnToRightOneActionPerformed

        RetailTicketLineInfo[] lines = receiptone.getSelectedLinesUnit();
        if (lines != null) {
             //move  to right panel
            receipttwo.addSelectedLines(lines);
        }

}//GEN-LAST:event_jBtnToRightOneActionPerformed
    //Action performed is called when click on left arrow button for moving the selected item from right panel to left panel
    private void jBtnToLeftOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnToLeftOneActionPerformed

        RetailTicketLineInfo[] lines = receipttwo.getSelectedLinesUnit();
        if (lines != null) {
             //move  to left panel
            receiptone.addSelectedLines(lines);
        }

}//GEN-LAST:event_jBtnToLeftOneActionPerformed
    //Action performed is called when click on food button for moving all the food items from left to right panel
    private void jBtnByFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnByFoodActionPerformed

        receiptone.setTicket(retail1, ticketext);
        ArrayList<String> productId = receipttwo.getFoodSelectedLinesData(retail1, "FOOD");

        for (int j = 0; j < productId.size(); j++) {
            int index = retail1.getSplitProductIndex(productId.get(j));
            receiptone.removeTicket(index);
            receiptone.removeTicketLine(index);


        }

        receiptone.printTotals();
    }//GEN-LAST:event_jBtnByFoodActionPerformed
    //Action performed is called when click on alcohol button for moving all the alcohol items from left to right panel
    private void jBtnByAlcoholActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnByAlcoholActionPerformed
        ArrayList<String> productId = receipttwo.getFoodSelectedLinesData(retail1, "ALCOHOL");
 
        for (int j = 0; j < productId.size(); j++) {
            int index = retail1.getSplitProductIndex(productId.get(j));
            receiptone.removeTicket(index);
            receiptone.removeTicketLine(index);

        } // TODO add your handling code here:
        receiptone.printTotals();
    }//GEN-LAST:event_jBtnByAlcoholActionPerformed

    private void WindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_WindowClosing
        dispose();
    }//GEN-LAST:event_WindowClosing

    private void m_jButtonPrintBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jButtonPrintBillActionPerformed
        if (receipttwo.getTicket().getLinesCount() > 0) {
            window = "Print";
            accepted = true;
            dispose();
        }
    }//GEN-LAST:event_m_jButtonPrintBillActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnByAlcohol;
    private javax.swing.JButton jBtnByFood;
    private javax.swing.JButton jBtnToLeftOne;
    private javax.swing.JButton jBtnToRightOne;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton m_jButtonCancel;
    private javax.swing.JButton m_jButtonOK;
    private javax.swing.JButton m_jButtonPrintBill;
    // End of variables declaration//GEN-END:variables
}
