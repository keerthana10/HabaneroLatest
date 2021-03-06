//    Openbravo POS is a point of sales application designed for touch screens.
//    Copyright (C) 2007-2009 Openbravo, S.L.
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
package com.sysfore.pos.cashmanagement;

import com.openbravo.basic.BasicException;
import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import com.openbravo.pos.forms.AppView;
import com.openbravo.pos.customers.DataLogicCustomers;
import com.openbravo.pos.forms.AppConfig;
import com.openbravo.pos.sales.DiscountRateinfo;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Window;
import java.io.File;
import java.util.UUID;
import java.util.regex.Pattern;


public class DiscountsEditor extends JDialog {

    public javax.swing.JDialog dEdior = null;
    static DataLogicCustomers dlCustomers2 = null;
    public String[] strings = {""};
    public DefaultListModel model = null;
    public java.util.List<DiscountRateinfo> list = null;
    public boolean updateMode = false;
    static int x = 400;
    static int y = 200;

    public DiscountsEditor(AppView m_app, JPanel parent) throws BasicException {
        //super(new JFrame(),true);
        //dlReceipts = (DataLogicReceipts) m_app.getBean("com.openbravo.pos.sales.DataLogicReceipts");
        // dlCustomers = (DataLogicCustomers) m_app.getBean("com.openbravo.pos.customers.DataLogicCustomers");
        //init(dlReceipts, m_app, parent);
    }

    private DiscountsEditor(Frame frame, boolean b) {
        super(frame, b);
        setBounds(x, y, 662, 562);
    }

    private DiscountsEditor(Dialog dialog, boolean b) {
        super(dialog, b);
        setBounds(x, y, 662, 562);
    }

    public static void showMessage(Component parent, DataLogicCustomers dlCustomers, AppView m_App) throws BasicException {
        dlCustomers2 = (DataLogicCustomers) m_App.getBean("com.openbravo.pos.customers.DataLogicCustomers");
        showMessage(parent, dlCustomers2);
    }

    private static void showMessage(Component parent, DataLogicCustomers dlCustomers) throws BasicException {

        Window window = getWindow(parent);
        DiscountsEditor myMsg;
        if (window instanceof Frame) {
            myMsg = new DiscountsEditor((Frame) window, true);
        } else {
            myMsg = new DiscountsEditor((Dialog) window, true);
        }
        myMsg.init(dlCustomers2);
    }

    public void init(final DataLogicCustomers dlCustomers) throws BasicException {

        initComponents();
        populateList(dlCustomers);
        //m_jDiscountPercentage.setText(dlCustomers.getMaxPercentage() + "%");
        m_jDiscountPercentage.setText("");
        setTitle("Discounts Editor ");
        setVisible(true);
        add(m_jDiscountList);
        File file = new File(System.getProperty("user.home") + "/openbravopos.properties");
        AppConfig ap = new AppConfig(file);
        ap.load();

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        m_jDiscountItem = new javax.swing.JTextField();
        m_jDiscountLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        m_jDiscountList = new javax.swing.JList();
        jSaver = new javax.swing.JPanel();
        jbtnNew = new javax.swing.JButton();
        jbtnDelete = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jbtnSave = new javax.swing.JButton();
        m_jDiscountLabel1 = new javax.swing.JLabel();
        m_jDiscountPercentage = new javax.swing.JTextField();

        getContentPane().setLayout(null);

        m_jDiscountItem.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.darkShadow")), null), null));
        getContentPane().add(m_jDiscountItem);
        m_jDiscountItem.setBounds(349, 142, 200, 24);

        m_jDiscountLabel.setText("Rate");
        getContentPane().add(m_jDiscountLabel);
        m_jDiscountLabel.setBounds(255, 145, 70, 19);

        m_jDiscountList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                m_jDiscountListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(m_jDiscountList);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(67, 74, 154, 284);

        jbtnNew.setBackground(new java.awt.Color(255, 255, 255));
        jbtnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/editnew.png"))); // NOI18N
        jbtnNew.setFocusPainted(false);
        jbtnNew.setFocusable(false);
        jbtnNew.setMargin(new java.awt.Insets(2, 8, 2, 8));
        jbtnNew.setRequestFocusEnabled(false);
        jbtnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNewActionPerformed(evt);
            }
        });

        jbtnDelete.setBackground(new java.awt.Color(255, 255, 255));
        jbtnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/editdelete.png"))); // NOI18N
        jbtnDelete.setFocusPainted(false);
        jbtnDelete.setFocusable(false);
        jbtnDelete.setMargin(new java.awt.Insets(2, 8, 2, 8));
        jbtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDeleteActionPerformed(evt);
            }
        });

        jbtnSave.setBackground(new java.awt.Color(255, 255, 255));
        jbtnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/filesave.png"))); // NOI18N
        jbtnSave.setFocusPainted(false);
        jbtnSave.setFocusable(false);
        jbtnSave.setMargin(new java.awt.Insets(2, 8, 2, 8));
        jbtnSave.setRequestFocusEnabled(false);
        jbtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jSaverLayout = new org.jdesktop.layout.GroupLayout(jSaver);
        jSaver.setLayout(jSaverLayout);
        jSaverLayout.setHorizontalGroup(
            jSaverLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jSaverLayout.createSequentialGroup()
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(330, 330, 330)
                .add(jbtnNew)
                .add(4, 4, 4)
                .add(jbtnDelete)
                .add(4, 4, 4)
                .add(jbtnSave))
        );
        jSaverLayout.setVerticalGroup(
            jSaverLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jSaverLayout.createSequentialGroup()
                .add(2, 2, 2)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(jbtnNew)
            .add(jbtnDelete)
            .add(jbtnSave)
        );

        getContentPane().add(jSaver);
        jSaver.setBounds(39, 32, 536, 40);

        m_jDiscountLabel1.setText("Name");
        getContentPane().add(m_jDiscountLabel1);
        m_jDiscountLabel1.setBounds(255, 95, 76, 19);

        m_jDiscountPercentage.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.darkShadow")), null), null));
        m_jDiscountPercentage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jDiscountPercentageActionPerformed(evt);
            }
        });
        getContentPane().add(m_jDiscountPercentage);
        m_jDiscountPercentage.setBounds(349, 92, 200, 24);

        getAccessibleContext().setAccessibleParent(this);
    }// </editor-fold>//GEN-END:initComponents

    private void m_jDiscountListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_m_jDiscountListValueChanged
        // TODO add your handling code here:
        if (evt.getValueIsAdjusting()) {
            System.out.println("inside value changed -- list selection event fired");
            updateMode = true;
            String percentage = null;
            try {
                percentage = m_jDiscountList.getSelectedValue().toString();
            } catch (Exception ex) {
                System.out.println("unknown exception");
            }
            String rate = null;
            try {
                rate = dlCustomers2.getDiscountLine(percentage);
            } catch (BasicException ex) {
                Logger.getLogger(DiscountsEditor.class.getName()).log(Level.SEVERE, null, ex);
            }
            m_jDiscountPercentage.setText(percentage);
            double rated = Double.parseDouble(rate);
            rated *= 100;
            m_jDiscountItem.setText(rated + "%");
        }

    }//GEN-LAST:event_m_jDiscountListValueChanged

    private void jbtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveActionPerformed

        if (m_jDiscountItem.getText().equals("")) {
            JOptionPane.showMessageDialog(DiscountsEditor.this, "Please enter values");
        } else {
            try {
                saveButtonAction();
            } catch (BasicException ex) {
                Logger.getLogger(DiscountsEditor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}//GEN-LAST:event_jbtnSaveActionPerformed

    private void jbtnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNewActionPerformed

        //String maxPercent = null;
        //try {
        //    String maxId = "" + dlCustomers2.getMaxPercentage();
        //    maxPercent = maxId + "%";
        //} catch (BasicException ex) {
        //    Logger.getLogger(DiscountsEditor.class.getName()).log(Level.SEVERE, null, ex);
        //}
        //m_jDiscountPercentage.setText(maxPercent);
        m_jDiscountPercentage.setText("");
        m_jDiscountItem.setText(null);
        m_jDiscountList.clearSelection();
        updateMode = false;
}//GEN-LAST:event_jbtnNewActionPerformed

    private void jbtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDeleteActionPerformed

        int index = m_jDiscountList.getSelectedIndex();
        System.out.println("index is " + index);

        if (index == -1) {
            JOptionPane.showMessageDialog(DiscountsEditor.this, "Please select discounts in list");
        } else {
            try {
                String val = m_jDiscountList.getSelectedValue().toString();
                dlCustomers2.deleteDiscountLine(val);
                m_jDiscountPercentage.setText("");
                m_jDiscountItem.setText("");

            } catch (BasicException ex) {
                Logger.getLogger(DiscountsEditor.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                populateList(dlCustomers2);
            } catch (BasicException ex) {
                Logger.getLogger(DiscountsEditor.class.getName()).log(Level.SEVERE, null, ex);
            }
            updateMode = false;
        }
}//GEN-LAST:event_jbtnDeleteActionPerformed

    private void m_jDiscountPercentageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jDiscountPercentageActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_m_jDiscountPercentageActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jSaver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbtnDelete;
    private javax.swing.JButton jbtnNew;
    private javax.swing.JButton jbtnSave;
    private javax.swing.JTextField m_jDiscountItem;
    private javax.swing.JLabel m_jDiscountLabel;
    private javax.swing.JLabel m_jDiscountLabel1;
    private javax.swing.JList m_jDiscountList;
    private javax.swing.JTextField m_jDiscountPercentage;
    // End of variables declaration//GEN-END:variables

    public void populateList(DataLogicCustomers dlCustomers) throws BasicException {

        model = new DefaultListModel();
        m_jDiscountList.setModel(model);
        list = dlCustomers.getDiscountList();
        String[] dListId = null;
        String[] dListRate = null;
        for (int i = 0; i < list.size(); i++) {
            System.out.println("getPercentage " + list.get(i).getName());
            String listid = list.get(i).getName();
            model.add(i, listid);
        }
    }

private void saveButtonAction() throws BasicException {

        String name = m_jDiscountPercentage.getText();
        String discount = m_jDiscountItem.getText();
        double rate = Double.parseDouble(discount);
        if (name != null && discount != null && rate > 0 ) {

            boolean avl = checkDiscountNameAvl(name);
            try {
                list = dlCustomers2.getDiscountList();
                Double ddiscount = rate / 100;
                if (updateMode == false) {
                    if (avl == false) {
                        dlCustomers2.insertDiscounts(UUID.randomUUID().toString(), name, ddiscount);
                    } else {
                        JOptionPane.showMessageDialog(this, "Entered discount name already exists");
                    }
                } else {
                    String id = list.get(m_jDiscountList.getSelectedIndex()).getId();
                    dlCustomers2.updateDiscountLine(id, name, ddiscount);
                    updateMode = false;
                }
                populateList(dlCustomers2);
                m_jDiscountPercentage.setText("");
                m_jDiscountItem.setText("");
            } catch (NumberFormatException npe) {
                JOptionPane.showMessageDialog(this, "Enter valid name and rate");
                m_jDiscountPercentage.setText("");
                m_jDiscountItem.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Your msg.");
        }
    }

    private static Window getWindow(Component parent) {

        if (parent == null) {
            return new JFrame();
        } else if (parent instanceof Frame || parent instanceof Dialog) {
            return (Window) parent;
        } else {
            return getWindow(parent.getParent());
        }
    }

    private boolean checkDiscountNameAvl(String percentage) throws BasicException {
        String name = dlCustomers2.getDiscountName(percentage);
        if ("NONAME".equalsIgnoreCase(name)) {
            return false;
        } else {
            return true;
        }
    }
}
