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

package com.sysfore.pos.hotelmanagement;

import com.openbravo.pos.forms.JPanelView;
import com.openbravo.pos.forms.AppView;
import com.openbravo.pos.forms.AppLocal;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.util.Date;
import java.util.UUID;
import com.openbravo.data.loader.StaticSentence;
import com.openbravo.data.loader.SerializerWriteBasic;
import com.openbravo.format.Formats;
import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.Datas;
import com.openbravo.data.gui.MessageInf;
import com.openbravo.pos.customers.DataLogicCustomers;
import com.openbravo.pos.forms.AppConfig;
import com.openbravo.pos.forms.BeanFactoryApp;
import com.openbravo.pos.forms.BeanFactoryException;
import com.openbravo.pos.scripting.ScriptEngine;
import com.openbravo.pos.scripting.ScriptException;
import com.openbravo.pos.scripting.ScriptFactory;
import com.openbravo.pos.forms.DataLogicSystem;
import com.openbravo.pos.printer.TicketParser;
import com.openbravo.pos.printer.TicketPrinterException;
import com.openbravo.pos.sales.DiscountRateinfo;

import com.openbravo.pos.sales.shared.JTicketsBagShared;
import com.sysfore.pos.purchaseorder.PurchaseOrderReceipts;
import java.io.File;

/**
 *
 * @author adrianromero
 */
public class JUom extends JPanel implements JPanelView,BeanFactoryApp{
    private AppView m_App;
    private DataLogicSystem m_dlSystem;
   
    private TicketParser m_TTP;
     protected DataLogicSystem dlSystem;
     static PurchaseOrderReceipts PurchaseOrder = null;
    protected DataLogicCustomers dlCustomers;
    public javax.swing.JDialog dEdior = null;
    public DataLogicCustomers dlCustomers2 = null;
    public String[] strings = {""};
    public DefaultListModel model = null;
    public java.util.List<UOMInfo> list = null;
    public boolean updateMode = false;
   // static int x = 400;
  //  static int y = 200;
    /** Creates new form JPanelCloseMoney */
    public JUom() {
        
        initComponents();                   
    }
    
    public void init(AppView app) throws BeanFactoryException{
        
        m_App = app;        
        
         PurchaseOrder = (PurchaseOrderReceipts) m_App.getBean("com.sysfore.pos.purchaseorder.PurchaseOrderReceipts");
        m_dlSystem = (DataLogicSystem) m_App.getBean("com.openbravo.pos.forms.DataLogicSystem");
        dlCustomers = (DataLogicCustomers) m_App.getBean("com.openbravo.pos.customers.DataLogicCustomers");
     //   m_dlPurchase = (DataLogicSystem) m_App.getBean("com.openbravo.pos.forms.DataLogicSystem");
        m_TTP = new TicketParser(m_App.getDeviceTicket(), m_dlSystem);
   // JOptionPane.showMessageDialog(this, "The user has to close all pending bills before doing the close shift", AppLocal.getIntString("message.header"), JOptionPane.INFORMATION_MESSAGE);
         initComponents();
        try {
            populateList();
        } catch (BasicException ex) {
            Logger.getLogger(JBusinessTypePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        //m_jDiscountPercentage.setText(dlCustomers.getMaxPercentage() + "%");
        m_jUomcode.setText("");
       m_jUomname.setText("");

        setVisible(true);
        //add(m_jDiscountList);
        File file = new File(System.getProperty("user.home") + "/openbravopos.properties");
        AppConfig ap = new AppConfig(file);
        ap.load();
    }
    
    

    public Object getBean() {
         return this;
    }

    public JComponent getComponent() {
        return this;
    }

    public String getTitle() {
        return AppLocal.getIntString("Menu.Uom");
    }

    public void activate() throws BasicException {
        
    }

    public boolean deactivate() {
        // se me debe permitir cancelar el deactivate
        return true;
    }


   

    private class FormatsPayment extends Formats {
        protected String formatValueInt(Object value) {
            return AppLocal.getIntString("transpayment." + (String) value);
        }   
        protected Object parseValueInt(String value) throws ParseException {
            return value;
        }
        public int getAlignment() {
            return javax.swing.SwingConstants.LEFT;
        }         
    }    
   
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        m_jUomcodeList = new javax.swing.JList();
        m_jlblBusinessType = new javax.swing.JLabel();
        m_jUomcode = new javax.swing.JTextField();
        jSaver = new javax.swing.JPanel();
        jbtnNew = new javax.swing.JButton();
        jbtnDelete = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jbtnSave = new javax.swing.JButton();
        m_jlblBusinessType1 = new javax.swing.JLabel();
        m_jUomname = new javax.swing.JTextField();

        m_jUomcodeList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                m_jUomcodeListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(m_jUomcodeList);

        m_jlblBusinessType.setText("Code*");

        m_jUomcode.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.darkShadow")), null), null));
        m_jUomcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jUomcodeActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jSaverLayout = new javax.swing.GroupLayout(jSaver);
        jSaver.setLayout(jSaverLayout);
        jSaverLayout.setHorizontalGroup(
            jSaverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jSaverLayout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(330, 330, 330)
                .addComponent(jbtnNew)
                .addGap(4, 4, 4)
                .addComponent(jbtnDelete)
                .addGap(4, 4, 4)
                .addComponent(jbtnSave))
        );
        jSaverLayout.setVerticalGroup(
            jSaverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jSaverLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jbtnNew)
            .addComponent(jbtnDelete)
            .addComponent(jbtnSave)
        );

        m_jlblBusinessType1.setText("Name*");

        m_jUomname.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.darkShadow")), null), null));
        m_jUomname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jUomnameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jSaver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(m_jlblBusinessType, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(m_jlblBusinessType1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(m_jUomcode, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(m_jUomname, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSaver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(m_jlblBusinessType, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(m_jUomcode, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(m_jlblBusinessType1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(m_jUomname, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(242, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void m_jUomcodeListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_m_jUomcodeListValueChanged
        // TODO add your handling code here:
        if (evt.getValueIsAdjusting()) {
            System.out.println("inside value changed -- list selection event fired");
            updateMode = true;
            String uomName = null;
            String uomCode=null;
            try {
                uomName = m_jUomcodeList.getSelectedValue().toString();
                uomCode=dlCustomers.getPerticularUom(uomName);
                
               
            } catch (Exception ex) {
                System.out.println("unknown exception");
            }
            m_jUomname.setText(uomName);
            m_jUomcode.setText(uomCode); //check
           
        }
    }//GEN-LAST:event_m_jUomcodeListValueChanged

    private void m_jUomcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jUomcodeActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_m_jUomcodeActionPerformed

    private void jbtnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNewActionPerformed

     
        m_jUomcode.setText("");
        m_jUomname.setText("");
        m_jUomcodeList.clearSelection();
        updateMode = false;
}//GEN-LAST:event_jbtnNewActionPerformed

    private void jbtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDeleteActionPerformed

        int index = m_jUomcodeList.getSelectedIndex();
        System.out.println("index is " + index);

        if (index == -1) {
            JOptionPane.showMessageDialog(JUom.this, "Please select the UOM ");
        } else {
            try {
                String val = m_jUomcodeList.getSelectedValue().toString();
                dlCustomers.deleteUOM(val);
                m_jUomcode.setText("");
                m_jUomname.setText("");
           
            } catch (BasicException ex) {
                Logger.getLogger(JBusinessTypePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                populateList();
            } catch (BasicException ex) {
                Logger.getLogger(JBusinessTypePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            updateMode = false;
        }
}//GEN-LAST:event_jbtnDeleteActionPerformed

    private void jbtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveActionPerformed

        if (m_jUomcode.getText().equals("") || m_jUomname.getText().equals("")) {
            JOptionPane.showMessageDialog(JUom.this, "Please enter the mandatory fields");
        } else {
            try {
                saveButtonAction();
            } catch (BasicException ex) {
                Logger.getLogger(JBusinessTypePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}//GEN-LAST:event_jbtnSaveActionPerformed

    private void m_jUomnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jUomnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_m_jUomnameActionPerformed
 public void populateList() throws BasicException {

        model = new DefaultListModel();
        m_jUomcodeList.setModel(model);
        list = dlCustomers.getUOMList();
        String[] dListId = null;
    
        for (int i = 0; i < list.size(); i++) {
             String listid = list.get(i).getName();
             model.add(i, listid);
        }
    }

private void saveButtonAction() throws BasicException {

        String code =m_jUomcode.getText();
        String name= m_jUomname.getText();
     
        if (name!=null) {

            boolean avl = checkUnameAvl(name);
            try {
                list = dlCustomers.getUOMList();
           
                if (updateMode == false) {
                    if (avl == false) {
                        dlCustomers.insertUom(UUID.randomUUID().toString(),name,code);
                    } else {
                        JOptionPane.showMessageDialog(this, "Entered Uom is already exists");
                    }
                } else {
                    String id = list.get(m_jUomcodeList.getSelectedIndex()).getId();
                    dlCustomers.updateUom(id, name,code);
                    updateMode = false;
                }
                populateList();
                m_jUomcode.setText("");
                m_jUomname.setText("");
             } catch (NumberFormatException npe) {
                JOptionPane.showMessageDialog(this, "Enter valid name");
                m_jUomcode.setText("");
                m_jUomname.setText("");
             }
        } else {
            JOptionPane.showMessageDialog(this, "Your msg.");
        }
    }


    private boolean checkUnameAvl(String uname) throws BasicException {
        String name = dlCustomers.getUOMname(uname);
        if ("NONAME".equalsIgnoreCase(name)) {
            return false;
        } else {
            return true;
        }
    } 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jSaver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbtnDelete;
    private javax.swing.JButton jbtnNew;
    private javax.swing.JButton jbtnSave;
    private javax.swing.JTextField m_jUomcode;
    private javax.swing.JList m_jUomcodeList;
    private javax.swing.JTextField m_jUomname;
    private javax.swing.JLabel m_jlblBusinessType;
    private javax.swing.JLabel m_jlblBusinessType1;
    // End of variables declaration//GEN-END:variables
    
}
