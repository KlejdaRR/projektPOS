/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedWriter;
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
 * @author EMSH
 */
public class sales extends javax.swing.JFrame {

    public static String barcode_c = "0";
    public static String cus_id = "0";
    public static Double stock_qty = 0.0;
    
    public sales() {
        initComponents();
        data_load();
    }

        public void data_load(){
        
        try{
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM customer");
            Vector v = new Vector();
            while(rs.next()){
                v.add(rs.getString("customer_name"));
                
                DefaultComboBoxModel com = new DefaultComboBoxModel(v);
                
                comb_cus.setModel(com);
            }
                    
        }
        catch(Exception e){ 
            System.out.println(e);
        }
        
         try{
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM product");
            Vector v = new Vector();
            while(rs.next()){
                v.add(rs.getString("product_name"));
                
                DefaultComboBoxModel com = new DefaultComboBoxModel(v);
                
                comb_pro.setModel(com);
            }
                    
        }
        catch(Exception e){ 
            System.out.println(e);
        }
         
         //gjenerojme numrin e fundit te invoice
         try{
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM extra WHERE extid = 1");
            
            if(rs.next()){
                inid.setText(rs.getString("val"));
            }
         }
         catch(Exception e){
             System.out.println(e);
         }
         //invoice i ri
         int i = Integer.valueOf(inid.getText());
         i++;
         inid.setText(String.valueOf(i));
    }
        //gjejme shumen per sasine e produkteve te therritur ne combobox
        public void pro_tot_cal(){
           
            Double qt = Double.valueOf(p_qty.getText());
            Double price = Double.valueOf(u_price.getText());
            Double tot;
            
            tot = qt * price;
            
            tot_price.setText(String.valueOf(tot));
            
        }
        //mbledhim rreshtat e tabeles me shumat per cdo produkt
        public void cart_total(){
            
            int numofrow = jTable1.getRowCount();
            double total = 0;
            for(int i = 0; i < numofrow; i++){
                double value = Double.valueOf(jTable1.getValueAt(i,5).toString());
                total = total + value;
                
            }
            bill_tot.setText(Double.toString(total));
            
            //mbledhim sasite e cdo produkti
            int numofrows = jTable1.getRowCount();
            double totals = 0;
            for(int i = 0; i < numofrows; i++){
                double values = Double.valueOf(jTable1.getValueAt(i,3).toString());
                totals = totals + values;
                
            }
            tot_qty.setText(Double.toString(totals));
        }
        //llogarisim totalin pasi kemi hequr shumen e paguar
        public void tot(){
        Double paid = Double.valueOf(paid_amt.getText());
        Double tot = Double.valueOf(bill_tot.getText());
        Double due;
        
        due = tot - paid;
        
        balance.setText(String.valueOf(due));
            
        }
        //rregullojme sasine ne stock pasi kemi regjistruar faturen
   public void stcup(){
    DefaultTableModel dt = (DefaultTableModel)jTable1.getModel();
    int rc = dt.getRowCount();
    
    for(int i = 0; i<rc; i++){
        String bcode = dt.getValueAt(i,2).toString();
        String sell_qty = dt.getValueAt(i,3).toString();
        
        System.out.println(bcode);
        System.out.println(sell_qty);
        
        try{
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT qty FROM product WHERE bar_code = '"+bcode+"' ");
            
            if(rs.next()){
                stock_qty = Double.valueOf(rs.getString("qty"));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        Double st_qty = stock_qty;
        Double sel_qty = Double.valueOf(sell_qty);
        
        Double new_qty = st_qty - sel_qty;
        
        String nqty = String.valueOf(new_qty);
        
        try{
            Statement ss = db.mycon().createStatement();
            ss.executeUpdate("UPDATE product SET qty = '"+nqty+"' WHERE bar_code = '"+bcode+"'");
            //update new qty in product table
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        inid = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        comb_cus = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        comb_pro = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        p_qty = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        u_price = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tot_price = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        br_code = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        l_stqty = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        paid_amt = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        bill_tot = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        balance = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tot_qty = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
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

        jPanel2.setBackground(new java.awt.Color(0, 204, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Faturë nr:");

        inid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        inid.setText("01");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inid)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(inid))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Klienti:");

        comb_cus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "kle", "test" }));
        comb_cus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comb_cusActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Produkti:");

        comb_pro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ll", "klj" }));
        comb_pro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comb_proActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Sasia:");

        p_qty.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        p_qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p_qtyActionPerformed(evt);
            }
        });
        p_qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                p_qtyKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                p_qtyKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Çmim shitje:");

        u_price.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        u_price.setText("00");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Totali:");

        tot_price.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tot_price.setText("00");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Bar kodi:");

        br_code.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        br_code.setText("00");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Sasia në stok:");

        l_stqty.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        l_stqty.setText("0.00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(comb_cus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(comb_pro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel5))
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(l_stqty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p_qty))
                .addGap(27, 27, 27)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(u_price)
                .addGap(56, 56, 56)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(tot_price)
                .addGap(26, 26, 26)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(br_code)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comb_cus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(comb_pro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p_qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(u_price)
                    .addComponent(jLabel8)
                    .addComponent(tot_price)
                    .addComponent(jLabel12)
                    .addComponent(br_code))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(l_stqty))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(0, 204, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setBackground(new java.awt.Color(0, 204, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Shto në faturë");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 204, 153));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Fshi rresht");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 204, 153));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("Fshi të gjitha");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id fature", "Emër produkti", "Bar kodi", "Sasia", "Çmim shitje", "Totali"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(204, 255, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Vlera e paguar:");

        paid_amt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                paid_amtKeyReleased(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(0, 204, 153));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Vlera totale:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Vlera e mbetur:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bill_tot, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(balance))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(bill_tot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(balance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Sasia totale:");

        tot_qty.setText("00");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(paid_amt, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(tot_qty)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(paid_amt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tot_qty)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jButton4.setBackground(new java.awt.Color(0, 204, 153));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("REGJISTRO FATURË");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jMenuBar2.setBackground(new java.awt.Color(204, 255, 204));

        jMenu4.setText("Shitjet");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
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

        jMenu9.setText("Klientët");
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

        jMenu11.setText("Furnitorët");
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

        jMenu12.setText("Punëtorët");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(320, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void comb_proActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comb_proActionPerformed
        // TODO add your handling code here:
        String name = comb_pro.getSelectedItem().toString();
        
        try{ 
             Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT bar_code, price, qty FROM product WHERE product_name = '"+name+"'");
            
            if(rs.next()){
                u_price.setText(rs.getString("price"));
                br_code.setText(rs.getString("bar_code"));
                l_stqty.setText(rs.getString("qty"));
            }
            
           }
        catch(Exception e){ 
            System.out.println(e);
        }
    
    }//GEN-LAST:event_comb_proActionPerformed

    private void p_qtyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_p_qtyKeyPressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_p_qtyKeyPressed

    private void p_qtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_p_qtyKeyReleased
        // TODO add your handling code here:
        pro_tot_cal();
    }//GEN-LAST:event_p_qtyKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Double sell_qty = Double.valueOf(p_qty.getText());
        Double stk_qty = Double.valueOf(l_stqty.getText());
        
        if(sell_qty < stk_qty){
            
                DefaultTableModel dt = (DefaultTableModel)jTable1.getModel();
        Vector v = new Vector();
        
        v.add(inid.getText());
        v.add(comb_pro.getSelectedItem().toString());
        v.add(br_code.getText());
        v.add(p_qty.getText());
        v.add(u_price.getText());
        v.add(tot_price.getText());
        
        dt.addRow(v);
                
        cart_total();
        }
        else{
            JOptionPane.showMessageDialog(balance, "Sasia në gjendje e produktit është: "+stk_qty);
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        try{ 
            DefaultTableModel dt = (DefaultTableModel)jTable1.getModel();
            int rw = jTable1.getSelectedRow();
            
            dt.removeRow(rw);
        }
        catch(Exception e){ 
            System.out.println(e);
        }
          cart_total();
          tot();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dt = (DefaultTableModel)jTable1.getModel();
        dt.setRowCount(0); 
        
          
    }//GEN-LAST:event_jButton3ActionPerformed

    private void paid_amtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paid_amtKeyReleased
        // TODO add your handling code here:
        tot();
    }//GEN-LAST:event_paid_amtKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try{
             DefaultTableModel dt = (DefaultTableModel)jTable1.getModel();
             int rc = dt.getRowCount();
             
             for(int i = 0; i < rc; i++){ 
                 
                 String Inid = dt.getValueAt(i, 0).toString();
                 String p_name = dt.getValueAt(i, 1).toString();
                 String br_code = dt.getValueAt(i, 2).toString();
                 String qty = dt.getValueAt(i, 3).toString();
                 String un_price = dt.getValueAt(i, 4).toString();
                 String tot_price = dt.getValueAt(i, 5).toString();
                 
                 //cart db
                  Statement s = db.mycon().createStatement();
                  s.executeUpdate("INSERT INTO cart (inid, product_name, bar_code, qty, unit_price, total_price) VALUES('"+Inid+"','"+p_name+"','"+br_code+"','"+qty+"','"+un_price+"','"+tot_price+"')");
           
             }
             
             JOptionPane.showMessageDialog(null, "Fatura u regjistrua");
        }
        catch(Exception e){ 
            System.out.println(e);
        }
        
        try{  //insertimi ne databazen e sales 
            
            String iniv_id = inid.getText();
            String cname = comb_cus.getSelectedItem().toString();
            String totqty = tot_qty.getText();
            String tot_bil = tot_price.getText();
            String blnc = balance.getText();
            
            //kontrolli i pagimit
            Double tot = Double.valueOf(bill_tot.getText());
            Double pid = Double.valueOf(paid_amt.getText());
            
               String status = null;
               
               if(pid.equals(0.0)){
                   status = "Pa paguar";
               }
               
               else if(tot > pid){
                   status = "Pa paguar";
               }
               else if (tot == pid){
                   status = "Paguar";
                   
               }
               else if(tot < pid){
                  status = "Paguar";
               }
               
             Statement ss = db.mycon().createStatement();
             ss.executeUpdate("INSERT INTO sales (inid, cid, customer_name, total_qty, total_bill, status, balance) VALUES('"+iniv_id+"','"+cus_id+"','"+cname+"','"+totqty+"','"+tot_bil+"','"+status+"','"+blnc+"')");
        }
        catch(Exception e){ 
            System.out.println(e);
            
        }
        //ne momentin e regjistrimit te fatures ruajme edhe numrin e fundit te id te fatures
        try{
            String id = inid.getText();
             Statement s = db.mycon().createStatement();
             s.executeUpdate("UPDATE extra SET val ='"+id+"' WHERE extid = 1");
             
        }
        catch(Exception e){
            System.out.println(e);
        }
        stcup();
        
        //fatura 
        //area.setText("**************************************\n");
        //area.setText("*         FATURE TOTALE                *\n");
        //area.setText("**************************************\n");
        //area.setText("ID fature  Emer produkti  Bar kodi  Sasia  Cmim shitje  Totali\n");
        
         /*for(int i = 0; i<jTable1.getRowCount(); i++){
                for(int j = 0; j<jTable1.getColumnCount(); j++){
                    area.setText(jTable1.getValueAt(i,j).toString()+ " ");
                }
                area.setText("\n");
            }*/
       // area.setText("**************************************\n");
        //area.setText("Vlera per tu paguar: " + bill_tot.getText()+"\n");
        //area.setText("Vlera e paguar: " + paid_amt.getText()+"\n");
        //area.setText("Vlera e mbetur: " + balance.getText()+"\n");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void comb_cusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comb_cusActionPerformed
        // TODO add your handling code here:
        String cname = comb_cus.getSelectedItem().toString();
        
        try{ 
             Statement s = db.mycon().createStatement();
             ResultSet rs = s.executeQuery("SELECT cid, customer_name FROM customer WHERE customer_name = '"+cname+"'");
            
            if(rs.next()){
                cus_id = rs.getString("cid");
            }
            
           }
        catch(Exception e){ 
            System.out.println(e);
        }
    }//GEN-LAST:event_comb_cusActionPerformed

    private void p_qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p_qtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_p_qtyActionPerformed

    private void jMenu4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu4KeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu4KeyReleased

    private void jMenu5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu5KeyReleased
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jMenu5KeyReleased

    private void jMenu6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu6KeyReleased
        // TODO add your handling code here:
      
    }//GEN-LAST:event_jMenu6KeyReleased

    private void jMenu7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu7KeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenu7KeyReleased

    private void jMenu8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu8KeyReleased
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jMenu8KeyReleased

    private void jMenu9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu9KeyReleased
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jMenu9KeyReleased

    private void jMenu10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu10KeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenu10KeyReleased

    private void jMenu11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu11KeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenu11KeyReleased

    private void jMenu12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu12KeyReleased
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jMenu12KeyReleased

    private void jMenu4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu4KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu4KeyPressed

    private void jMenu5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu5KeyPressed
        // TODO add your handling code here:
          
    }//GEN-LAST:event_jMenu5KeyPressed

    private void jMenu6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu6KeyPressed
        // TODO add your handling code here:
         
    }//GEN-LAST:event_jMenu6KeyPressed

    private void jMenu7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu7KeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenu7KeyPressed

    private void jMenu8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu8KeyPressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jMenu8KeyPressed

    private void jMenu9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu9KeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenu9KeyPressed

    private void jMenu10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu10KeyPressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jMenu10KeyPressed

    private void jMenu11KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu11KeyPressed
        // TODO add your handling code here:
            
    }//GEN-LAST:event_jMenu11KeyPressed

    private void jMenu12KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu12KeyPressed
        // TODO add your handling code here:
    
    }//GEN-LAST:event_jMenu12KeyPressed

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu4ActionPerformed

    private void jMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5ActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jMenu5ActionPerformed

    private void jMenu5MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu5MenuSelected
        // TODO add your handling code here:
        grn gr = new grn();
        gr.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenu5MenuSelected

    private void jMenu6MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu6MenuSelected
        // TODO add your handling code here:
        invoice inv = new invoice();
        inv.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenu6MenuSelected

    private void jMenu7MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu7MenuSelected
        // TODO add your handling code here:
         reports rep = new reports();
        rep.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_jMenu7MenuSelected

    private void jMenu8MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu8MenuSelected
        // TODO add your handling code here:
        stock st = new stock();
        st.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenu8MenuSelected

    private void jMenu9MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu9MenuSelected
        // TODO add your handling code here:
                 customer cus = new customer();
        cus.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenu9MenuSelected

    private void jMenu10MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu10MenuSelected
        // TODO add your handling code here:
        product pro = new product();
        pro.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenu10MenuSelected

    private void jMenu11MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu11MenuSelected
        // TODO add your handling code here:
        supplier sup = new supplier();
        sup.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenu11MenuSelected

    private void jMenu12MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu12MenuSelected
        // TODO add your handling code here:
        employee emp = new employee();
        emp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenu12MenuSelected

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
            java.util.logging.Logger.getLogger(sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField balance;
    private javax.swing.JTextField bill_tot;
    private javax.swing.JLabel br_code;
    private javax.swing.JComboBox<String> comb_cus;
    private javax.swing.JComboBox<String> comb_pro;
    private javax.swing.JLabel inid;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel l_stqty;
    private javax.swing.JTextField p_qty;
    private javax.swing.JTextField paid_amt;
    private javax.swing.JLabel tot_price;
    private javax.swing.JLabel tot_qty;
    private javax.swing.JLabel u_price;
    // End of variables declaration//GEN-END:variables
}
