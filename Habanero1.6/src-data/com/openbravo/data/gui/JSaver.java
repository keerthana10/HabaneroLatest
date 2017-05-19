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

package com.openbravo.data.gui;

import java.util.*;
import javax.swing.*;
import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.LocalRes;
import com.openbravo.data.user.BrowsableEditableData;
import com.openbravo.data.user.StateListener;

public class JSaver extends JPanel implements StateListener {
    
    protected BrowsableEditableData m_bd;
        
    /** Creates new form JSaver */
    public JSaver(BrowsableEditableData bd) {

        initComponents();
        
        m_bd = bd;
        
        // m_bd.addBrowseListener(this);
        m_bd.addStateListener(this);
    }

    public void updateState(int iState) {
        switch  (iState) {
        case BrowsableEditableData.ST_INSERT:
            jbtnNew.setEnabled(m_bd.canInsertData());
            jbtnDelete.setEnabled(false);
            jbtnSave.setEnabled(m_bd.canInsertData());
            break;
        case BrowsableEditableData.ST_DELETE:
            jbtnNew.setEnabled(m_bd.canInsertData());
            jbtnDelete.setEnabled(false);
            jbtnSave.setEnabled(m_bd.canDeleteData());
            break;
        case BrowsableEditableData.ST_NORECORD:
            jbtnNew.setEnabled(m_bd.canInsertData());
            jbtnDelete.setEnabled(false);
            jbtnSave.setEnabled(false);
            break;
        case BrowsableEditableData.ST_UPDATE:
            jbtnNew.setEnabled(m_bd.canInsertData());
            jbtnDelete.setEnabled(m_bd.canDeleteData());
            jbtnSave.setEnabled(m_bd.canUpdateData());
            break;
        }
   }   
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jbtnNew = new javax.swing.JButton();
        jbtnDelete = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jbtnSave = new javax.swing.JButton();

        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jbtnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/editnew.png")));
        jbtnNew.setFocusPainted(false);
        jbtnNew.setFocusable(false);
        jbtnNew.setMargin(new java.awt.Insets(2, 8, 2, 8));
        jbtnNew.setRequestFocusEnabled(false);
        jbtnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNewActionPerformed(evt);
            }
        });

        add(jbtnNew);

        jbtnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/editdelete.png")));
        jbtnDelete.setFocusPainted(false);
        jbtnDelete.setFocusable(false);
        jbtnDelete.setMargin(new java.awt.Insets(2, 8, 2, 8));
        jbtnDelete.setRequestFocusEnabled(false);
        jbtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDeleteActionPerformed(evt);
            }
        });

        add(jbtnDelete);

        add(jSeparator1);

        jbtnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openbravo/images/filesave.png")));
        jbtnSave.setFocusPainted(false);
        jbtnSave.setFocusable(false);
        jbtnSave.setMargin(new java.awt.Insets(2, 8, 2, 8));
        jbtnSave.setRequestFocusEnabled(false);
        jbtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveActionPerformed(evt);
            }
        });

        add(jbtnSave);

    }// </editor-fold>//GEN-END:initComponents

    private void jbtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveActionPerformed
        // Add your handling code here:
        try {
            m_bd.saveData();
        } catch (BasicException eD) {
            MessageInf msg = new MessageInf(MessageInf.SGN_NOTICE, LocalRes.getIntString("message.nosave"), eD);
            msg.show(this);
           // showMsg("enter");
        }          
    }//GEN-LAST:event_jbtnSaveActionPerformed
 private void showMsg(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }
    private void jbtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDeleteActionPerformed
        // Add your handling code here:
        try {
           
            m_bd.actionDelete();
            //m_bd.refreshData();
            //m_bd.actionReload(this);

        } catch (BasicException eD) {
            //System.out.println("exceion--deletept");
            MessageInf msg = new MessageInf(MessageInf.SGN_NOTICE, LocalRes.getIntString("message.nodelete"), eD);
            msg.show(this);
        }        
    }//GEN-LAST:event_jbtnDeleteActionPerformed

    private void jbtnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNewActionPerformed
        // Add your handling code here:
        try {
            m_bd.actionInsert();
        } catch (BasicException eD) {
            MessageInf msg = new MessageInf(MessageInf.SGN_NOTICE, LocalRes.getIntString("message.nonew"), eD);
            msg.show(this);
        }
    }//GEN-LAST:event_jbtnNewActionPerformed
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbtnDelete;
    private javax.swing.JButton jbtnNew;
    private javax.swing.JButton jbtnSave;
    // End of variables declaration//GEN-END:variables
    
}
