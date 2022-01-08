/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.AddStockController;
import Controller.MuaStockController;
import DAO.StockDAO;
import Model.MyStockBuyModel;
import Model.UserModel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.JComboBox;
import lib.AutoCompletion;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

/**
 *
 * @author dat26
 */
public class MuaStockView extends javax.swing.JFrame {

    /**
     * Creates new form ViewSua
     */
    public MasterTeleMoneyView owner;
    MyStockBuyModel myStock;
    StockDAO stockDAO;
    float giaNow;
    UserModel acc;

    MuaStockController muaStockController;

    public MuaStockView() {
        stockDAO = new StockDAO();

        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    public MuaStockView(MasterTeleMoneyView master, MyStockBuyModel stockBuy, UserModel acc) {
        this.acc = acc;
        this.myStock = stockBuy;
        this.owner = master;
        initComponents();
        setLocationRelativeTo(null);
        muaStockController = new MuaStockController(this, myStock, acc);
        stockDAO = new StockDAO();
        this.setTitle("Mua thêm " + stockBuy.getSymbol());
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    /**
     * `
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        btnThemStock = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        textGiaNow = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textGiaMuaTB = new javax.swing.JTextField();
        textSoLuong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTongMuaUSD = new javax.swing.JTextField();
        txtUSD = new javax.swing.JLabel();
        txtVND = new javax.swing.JLabel();
        txtTongMuaVND = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtSymbol = new javax.swing.JTextField();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jLabel1.setText("Mã cổ phiếu:");

        btnThemStock.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        btnThemStock.setText("OK");
        btnThemStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemStockActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jLabel2.setText("Giá hiện tại ($):");

        textGiaNow.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel4.setText("Mua thêm tài sản đầu tư");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jLabel5.setText("Giá mua TB ($):");

        textGiaMuaTB.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        textGiaMuaTB.setText("1");

        textSoLuong.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        textSoLuong.setText("1");
        textSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSoLuongActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jLabel6.setText("Số lượng :");

        jLabel7.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jLabel7.setText("Số dư khả dụng: ");

        jLabel8.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jLabel8.setText("Tổng giá trị mua thêm:");

        txtTongMuaUSD.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        txtTongMuaUSD.setText("0");
        txtTongMuaUSD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongMuaUSDActionPerformed(evt);
            }
        });

        txtUSD.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        txtUSD.setText("USD");

        txtVND.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        txtVND.setText("VND");

        txtTongMuaVND.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        txtTongMuaVND.setText("0");
        txtTongMuaVND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongMuaVNDActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jLabel9.setText("USD");

        jLabel10.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jLabel10.setText("VND");

        txtSymbol.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(txtUSD, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(txtVND, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textGiaNow, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                            .addComponent(textGiaMuaTB, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                            .addComponent(textSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                            .addComponent(txtTongMuaUSD)
                            .addComponent(txtTongMuaVND)
                            .addComponent(txtSymbol)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(btnThemStock, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtUSD)
                    .addComponent(txtVND))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSymbol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textGiaNow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textGiaMuaTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTongMuaUSD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTongMuaVND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnThemStock))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemStockActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void textSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSoLuongActionPerformed

    private void txtTongMuaUSDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongMuaUSDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongMuaUSDActionPerformed

    private void txtTongMuaVNDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongMuaVNDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongMuaVNDActionPerformed

//    public void setText() throws IOException{
//        textSymbol.setText(myStock.getSymbol());
//        textName.setText(myStock.getName());
//        //textGiaMuaTB.setText(String.valueOf(myStock.getGiaBanDau()));
//        
//        Stock st = YahooFinance.get(myStock.getSymbol());
//        BigDecimal price = st.getQuote().getPrice();
//        textGiaNow.setText(String.valueOf(price));
//        textGiaMuaTB.setText(String.valueOf(price));
//        textName.setEditable(false);
//        textSymbol.setEditable(false);
//        textGiaNow.setEditable(false);
//        
//    
//    
//    
//    
//    
//    
//    }
    /**
     * @param args the command line arguments
     */
    public void addThemListener(ActionListener log) {
        btnThemStock.addActionListener(log);
    }

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
            java.util.logging.Logger.getLogger(MuaStockView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MuaStockView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MuaStockView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MuaStockView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MuaStockView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancel;
    public javax.swing.JButton btnThemStock;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JTextField textGiaMuaTB;
    public javax.swing.JTextField textGiaNow;
    public javax.swing.JTextField textSoLuong;
    public javax.swing.JTextField txtSymbol;
    public javax.swing.JTextField txtTongMuaUSD;
    public javax.swing.JTextField txtTongMuaVND;
    public javax.swing.JLabel txtUSD;
    public javax.swing.JLabel txtVND;
    // End of variables declaration//GEN-END:variables

    public void addSuaListiner(ActionListener actionListener) {

    }

}
