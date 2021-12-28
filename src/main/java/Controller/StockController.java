/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.StockDAO;
import Model.MyStockBuyModel;
import Model.MyStockBuyTableModel;
import Model.UserModel;
import View.MasterTeleMoneyView;
import View.MuaStockView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import View.NhanvienView;
import View.ViewThem;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import lib.ButtonColumn;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class StockController {

    private MasterTeleMoneyView master;
    private UserModel acc;
    private StockDAO stockDAO = null;
    Stock stock;
    BigDecimal usd = YahooFinance.get("USDVND=X").getQuote().getPrice();

    public StockController(MasterTeleMoneyView master, UserModel acc) throws IOException {
        this.master = master;
        this.acc = acc;

        //setEventNhanvien();
        setTableButton();
        master.setVisible(true);
        stockDAO = new StockDAO();
        MyStockBuyTableModel tableModel = (MyStockBuyTableModel) master.tableDanhMuc.getModel();
        setDataTable();
    }

    public void enable() {
        setTableButton();

    }

    public void setDataTable() throws IOException {
        MyStockBuyTableModel tableModel = (MyStockBuyTableModel) master.tableDanhMuc.getModel();
        ArrayList<MyStockBuyModel> myStockList = new ArrayList<>();
        myStockList = stockDAO.getAll();
        tableModel.setRowCount(0);
        for (int i = 0; i < myStockList.size(); i++) {
            stock = YahooFinance.get(myStockList.get(i).getSymbol());
            tableModel.addRow(new Object[]{
                myStockList.get(i).getSymbol(),
                myStockList.get(i).getSoLuong(),
                myStockList.get(i).getGiaBanDau(),
                (Math.round(stock.getQuote().getPrice().floatValue()*100.0))/100.0,
                myStockList.get(i).get24hchange(),
                (Math.round(stock.getQuote().getPrice().floatValue() * myStockList.get(i).getSoLuong()*100.0))/100.0,
                "Mua thêm",
                "Bán"

            });

        }

    }
//    public void setButton(){
//    Action delete = new AbstractAction() {
//        public void actionPerformed(ActionEvent e) {
//            JTable table = (JTable) e.getSource();
//            int modelRow = Integer.valueOf(e.getActionCommand());
//            ((DefaultTableModel) table.getModel()).removeRow(modelRow);
//        }
//    };
//    ButtonColumn buttonColumn = new ButtonColumn(nhanvienView, delete, 2);
//
//    buttonColumn.setMnemonic (KeyEvent.VK_D);
//    
//    
//    }

//    public void setEventNhanvien() {
//
//        master.addThemListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    ThemNhanvienController add = new ThemNhanvienController(master);
//
//                } catch (Exception ex) {
//                }
//            }
//        });
//        master.addRefreshListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    // TODO add your handling code here:
//
//                    nhanvienDAO.refresh(master.nvmodel);
//                    master.invalidate();
//                    master.validate();
//                    master.repaint();
//                    // NhanvienView clone = new NhanvienView();
//                    //clone.setVisible(true);
//                    System.out.println("refresh");
//
//                } catch (Exception ex) {
//                }
//            }
//        });
//    }
    public void setTableButton() throws NumberFormatException {
        master.tableDanhMuc.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                if (e.getClickCount() == 1) {
                    final JTable target = (JTable) e.getSource();
                    final int row = target.getSelectedRow();
                    final int column = target.getSelectedColumn();
                    // Cast to ur Object type
                    // final UrObjctInCell urObjctInCell = (UrObjctInCell) target.getValueAt(row, column);
                    // TODO WHAT U WANT!
                    Float SoUSD = Float.valueOf(String.valueOf(target.getValueAt(row, column)));
                    master.labelUSD.setText(SoUSD.toString());
                    master.labelVND.setText(String.valueOf((usd.multiply(BigDecimal.valueOf(SoUSD)).setScale(0, RoundingMode.HALF_UP))));
                }
            }
        });
        //Action delete 1 hang
        MasterTeleMoneyView thisview = master;
        Action muaThem = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
//                int opt = JOptionPane.showConfirmDialog(master, "Bạn có muốn xoá nhân viên này không", "Delete", JOptionPane.YES_NO_CANCEL_OPTION);
//                if (opt == 0) {}
                JTable table = (JTable) e.getSource();
                int modelRow = Integer.valueOf(e.getActionCommand());

                MyStockBuyModel stockBuy = new MyStockBuyModel();
                stockBuy.setSymbol((String) table.getValueAt(modelRow, 0));
                stockBuy.setSoLuong((int) table.getValueAt(modelRow, 1));
                stockBuy.setGiaBanDau((float) table.getValueAt(modelRow, 2));
                MuaStockView muaStockView = new MuaStockView(master, stockBuy);
                muaStockView.setVisible(true);
                //stockDAO.delete(stockBuy);
                //((DefaultTableModel) table.getModel()).removeRow(modelRow);

            }
        };
        //Action sua 1 hang
        Action banStock;
        banStock = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTable table = (JTable) e.getSource();
                int modelRow = Integer.valueOf(e.getActionCommand());
                //((DefaultTableModel) table.getModel()).removeRow(modelRow);
                MyStockBuyModel stockBuy = new MyStockBuyModel();
                stockBuy.setSymbol((String) table.getValueAt(modelRow, 0));
                stockBuy.setSoLuong((int) table.getValueAt(modelRow, 1));
                stockBuy.setGiaBanDau((float) table.getValueAt(modelRow, 2));
                MuaStockView muaStockView = new MuaStockView(master, stockBuy);
            }
        };

        ButtonColumn btnMua = new ButtonColumn(thisview.tableDanhMuc, muaThem, 6);

        btnMua.setMnemonic(KeyEvent.VK_D);

        btnMua.setToolTipText(
                "Mua thêm cổ phiếu");
        ButtonColumn btnBan = new ButtonColumn(thisview.tableDanhMuc, banStock, 7);

        btnBan.setMnemonic(KeyEvent.VK_D);
    }
}