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

package com.openbravo.pos.ticket;

import com.openbravo.data.loader.SerializerWrite;

import com.openbravo.pos.forms.AppView;
import java.awt.Component;
import java.util.List;
import com.openbravo.data.loader.QBFCompareEnum;
import com.openbravo.format.Formats;
import com.openbravo.basic.BasicException;
import com.openbravo.data.gui.ListQBFModelNumber;
import com.openbravo.data.gui.ComboBoxValModel;
import com.openbravo.data.loader.Datas;
import com.openbravo.data.loader.SentenceList;
import com.openbravo.data.loader.SerializerWriteBasic;
import com.openbravo.pos.forms.DataLogicSales;
import com.openbravo.pos.reports.ReportEditorCreator;
import java.util.ArrayList;

public class StatusFilter extends javax.swing.JPanel implements ReportEditorCreator {
    
   // private SentenceList m_sentcat;
    private ComboBoxValModel m_CategoryModel;
     private String selectedval=null;
    /** Creates new form JQBFProduct */
    public StatusFilter() {

        initComponents();
    }
    
    public void init(AppView app) {
         
        DataLogicSales dlSales = (DataLogicSales) app.getBean("com.openbravo.pos.forms.DataLogicSales");
       
        // El modelo de categorias
    //    m_sentcat = dlSales.getCategoriesList();
        m_CategoryModel = new ComboBoxValModel(); 
        
         
        //m_jCboName.setModel(new ListQBFModelNumber());
        //m_jCboPriceBuy.setModel(new ListQBFModelNumber());
        //m_jCboPriceSell.setModel(new ListQBFModelNumber());
    }
    
    public void activate() throws BasicException {

        List catlist = new ArrayList();
        catlist.add("active");
        catlist.add("inactive");
//        catlist.add(0, null);
     m_CategoryModel = new ComboBoxValModel(catlist);
        m_jstatus.setModel(m_CategoryModel);
        
       // m_jstatus.addItem("active");
     //m_jstatus.addItem("inactive");
    }
    
    public SerializerWrite getSerializerWrite() {
        return new SerializerWriteBasic(
                new Datas[] {Datas.OBJECT, Datas.STRING});
    }

    public Component getComponent() {
        return this;
    }
   
  //  public Object createValue() throws BasicException {
//        
//        if (m_jBarcode.getText() == null || m_jBarcode.getText().equals("")) {
//            // Filtro por formulario
//            return new Object[] {
//                 m_CategoryModel.getSelectedKey() == null ? QBFCompareEnum.COMP_NONE : QBFCompareEnum.COMP_EQUALS, m_CategoryModel.getSelectedKey(),
//                QBFCompareEnum.COMP_NONE, null         
//            };
//        } else {            
//            // Filtro por codigo de barras.
//            return new Object[] {
//              
//                QBFCompareEnum.COMP_RE, "%" + m_jBarcode.getText() + "%"
//            };
//        }
  //  } 
// 
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        m_jstatus = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(514, 32));

        m_jstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jstatusActionPerformed(evt);
            }
        });

        jLabel1.setText("Status");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(m_jstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m_jstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void m_jstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jstatusActionPerformed
        // TODO add your handling code here:
         selectedval=m_jstatus.getSelectedItem().toString();
        if(selectedval.equals("active"))
        {
           selectedval="Y"; 
        }
        else
        {
            selectedval="N";
        }
          
      
        
    }//GEN-LAST:event_m_jstatusActionPerformed
   
    
////    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox m_jstatus;
    // End of variables declaration//GEN-END:variables

    @Override
    public Object createValue() throws BasicException {
     // if (m_jBarcode.getText() == null || m_jBarcode.getText().equals("")) {
            // Filtro por formulario
            return new Object[] {
            //    m_jCboName.getSelectedItem(), m_jName.getText(),
            //    m_jCboPriceBuy.getSelectedItem(), Formats.CURRENCY.parseValue(m_jPriceBuy.getText()),           
           //     m_jCboPriceSell.getSelectedItem(), Formats.CURRENCY.parseValue(m_jPriceSell.getText()),
                m_CategoryModel.getSelectedText() == null ? QBFCompareEnum.COMP_NONE : QBFCompareEnum.COMP_EQUALS, selectedval,
                QBFCompareEnum.COMP_NONE, null         
            };
     //   } else {            
            // Filtro por codigo de barras.
        //    return new Object[] {
           //     QBFCompareEnum.COMP_NONE, null,
           //     QBFCompareEnum.COMP_NONE, null,
          //      QBFCompareEnum.COMP_NONE, null,
          //      QBFCompareEnum.COMP_NONE, null,
           //     QBFCompareEnum.COMP_RE, "%" + m_jBarcode.getText() + "%"
         //   };
      //  }
    //} 
    }
    
}

