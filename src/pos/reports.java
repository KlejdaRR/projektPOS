/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author TR3BIT
 */
public class reports extends javax.swing.JFrame {

    /**
     * Creates new form reports
     */
    public reports() {
        initComponents();
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
        id_blerje = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        id_fature = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        jMenu12 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("NR BLERJE:");

        id_blerje.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 204, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Shiko t?? gjitha blerjet");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 204, 153));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Shiko blerje");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(282, 282, 282)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(id_blerje, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(133, 133, 133))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(id_blerje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Em??r produkti", "Bar kodi", "Sasia", "??mim shitje", "Totali"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.setBackground(new java.awt.Color(0, 204, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("NR FATURE:");

        id_fature.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton3.setBackground(new java.awt.Color(0, 204, 153));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("Shiko t?? gjitha faturat");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 204, 153));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("Shiko fatur??");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(282, 282, 282)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(id_fature, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(273, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(133, 133, 133))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(id_fature, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID furnitori", "Bar kodi", "Em??r produkti", "Sasia", "??mim blerje", "Totali"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jMenu4.setText("Shitjet");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenu4.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu4MenuSelected(evt);
            }
        });
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });
        jMenu4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenu4KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jMenu4KeyReleased(evt);
            }
        });
        jMenuBar2.add(jMenu4);

        jMenu5.setText("Blerjet");
        jMenu5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenu5.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu5MenuSelected(evt);
            }
        });
        jMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5ActionPerformed(evt);
            }
        });
        jMenu5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenu5KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jMenu5KeyReleased(evt);
            }
        });
        jMenuBar2.add(jMenu5);

        jMenu6.setText("Invoice");
        jMenu6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenu6.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu6MenuSelected(evt);
            }
        });
        jMenu6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenu6KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jMenu6KeyReleased(evt);
            }
        });
        jMenuBar2.add(jMenu6);

        jMenu7.setText("Raporte");
        jMenu7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenu7.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu7MenuSelected(evt);
            }
        });
        jMenu7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenu7KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jMenu7KeyReleased(evt);
            }
        });
        jMenuBar2.add(jMenu7);

        jMenu8.setText("Stoku");
        jMenu8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenu8.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu8MenuSelected(evt);
            }
        });
        jMenu8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenu8KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jMenu8KeyReleased(evt);
            }
        });
        jMenuBar2.add(jMenu8);

        jMenu9.setText("Klient??t");
        jMenu9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenu9.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu9MenuSelected(evt);
            }
        });
        jMenu9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenu9KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jMenu9KeyReleased(evt);
            }
        });
        jMenuBar2.add(jMenu9);

        jMenu10.setText("Produktet");
        jMenu10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenu10.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu10MenuSelected(evt);
            }
        });
        jMenu10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenu10KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jMenu10KeyReleased(evt);
            }
        });
        jMenuBar2.add(jMenu10);

        jMenu11.setText("Furnitor??t");
        jMenu11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenu11.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu11MenuSelected(evt);
            }
        });
        jMenu11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenu11KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jMenu11KeyReleased(evt);
            }
        });
        jMenuBar2.add(jMenu11);

        jMenu12.setText("Pun??tor??t");
        jMenu12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenu12.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu12MenuSelected(evt);
            }
        });
        jMenu12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenu12KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jMenu12KeyReleased(evt);
            }
        });
        jMenuBar2.add(jMenu12);

        jMenu1.setText("DIL");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenu1.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu1MenuSelected(evt);
            }
        });
        jMenuBar2.add(jMenu1);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu4ActionPerformed

    private void jMenu4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu4KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu4KeyPressed

    private void jMenu4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu4KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu4KeyReleased

    private void jMenu5MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu5MenuSelected
        // TODO add your handling code here:
        grn gr = new grn();
        gr.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenu5MenuSelected

    private void jMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu5ActionPerformed

    private void jMenu5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu5KeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu5KeyPressed

    private void jMenu5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu5KeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu5KeyReleased

    private void jMenu6MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu6MenuSelected
        // TODO add your handling code here:
        invoice inv = new invoice();
        inv.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenu6MenuSelected

    private void jMenu6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu6KeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu6KeyPressed

    private void jMenu6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu6KeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu6KeyReleased

    private void jMenu7MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu7MenuSelected
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu7MenuSelected

    private void jMenu7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu7KeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu7KeyPressed

    private void jMenu7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu7KeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu7KeyReleased

    private void jMenu8MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu8MenuSelected
        // TODO add your handling code here:
        stock st = new stock();
        st.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenu8MenuSelected

    private void jMenu8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu8KeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu8KeyPressed

    private void jMenu8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu8KeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu8KeyReleased

    private void jMenu9MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu9MenuSelected
        // TODO add your handling code here:
        customer cus = new customer();
        cus.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenu9MenuSelected

    private void jMenu9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu9KeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu9KeyPressed

    private void jMenu9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu9KeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu9KeyReleased

    private void jMenu10MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu10MenuSelected
        // TODO add your handling code here:
        product pro = new product();
        pro.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenu10MenuSelected

    private void jMenu10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu10KeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu10KeyPressed

    private void jMenu10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu10KeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu10KeyReleased

    private void jMenu11MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu11MenuSelected
        // TODO add your handling code here:
        supplier sup = new supplier();
        sup.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenu11MenuSelected

    private void jMenu11KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu11KeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu11KeyPressed

    private void jMenu11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu11KeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu11KeyReleased

    private void jMenu12MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu12MenuSelected
        // TODO add your handling code here:
        employee emp = new employee();
        emp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenu12MenuSelected

    private void jMenu12KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu12KeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu12KeyPressed

    private void jMenu12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu12KeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu12KeyReleased

    private void jMenu4MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu4MenuSelected
        // TODO add your handling code here:
        sales sal = new sales();
        sal.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenu4MenuSelected

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
            //table search
            String idb = id_blerje.getText();
           
            
            try{
                DefaultTableModel dt = (DefaultTableModel)jTable2.getModel();
                dt.setRowCount(0);
                Statement s = db.mycon().createStatement();
                ResultSet rs = s.executeQuery("SELECT * FROM grn WHERE grn_no = '"+idb+"' ");
                
                 while(rs.next()){
                Vector v = new Vector();

                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                v.add(rs.getString(7));
                v.add(rs.getString(12));
             
                dt.addRow(v);
            }
            }
            catch(Exception e){
                System.out.println(e);
            }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
            
            try{
                DefaultTableModel dt = (DefaultTableModel)jTable2.getModel();
                dt.setRowCount(0);
                Statement s = db.mycon().createStatement();
                ResultSet rs = s.executeQuery("SELECT * FROM grn ");
                
                 while(rs.next()){
                Vector v = new Vector();

                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                v.add(rs.getString(7));
                v.add(rs.getString(12));
             
                dt.addRow(v);
            }
            }
            catch(Exception e){
                System.out.println(e);
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
      
           
            
            try{
                DefaultTableModel dt = (DefaultTableModel)jTable1.getModel();
                dt.setRowCount(0);
                Statement s = db.mycon().createStatement();
                ResultSet rs = s.executeQuery("SELECT * FROM cart ");
                
                 while(rs.next()){
                Vector v = new Vector();

                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                v.add(rs.getString(7));
           
             
                dt.addRow(v);
            }
            }
            catch(Exception e){
                System.out.println(e);
            }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         String idf = id_fature.getText();
           
            
            try{
                DefaultTableModel dt = (DefaultTableModel)jTable1.getModel();
                dt.setRowCount(0);
                Statement s = db.mycon().createStatement();
                ResultSet rs = s.executeQuery("SELECT * FROM cart WHERE inid = '"+idf+"' ");
                
                 while(rs.next()){
                Vector v = new Vector();

                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                v.add(rs.getString(7));
           
             
                dt.addRow(v);
            }
            }
            catch(Exception e){
                System.out.println(e);
            }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenu1MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu1MenuSelected
        // TODO add your handling code here:
         home ho = new home();
        ho.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenu1MenuSelected

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
            java.util.logging.Logger.getLogger(reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reports().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField id_blerje;
    private javax.swing.JTextField id_fature;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
