/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.GuiTienDAO;
import DAO.StockDAO;
import DAO.TraGopDAO;
import DAO.VayTienDAO;
import Model.GuiTienModel;
import Model.GuiTienTableModel;
import Model.GuiTienTransModel;
import Model.MyStockBuyModel;
import Model.MyStockBuyTableModel;
import Model.TraGopModel;
import Model.TraGopTableModel;
import Model.TraGopTransModel;
import Model.UserModel;
import Model.VayTienModel;
import Model.VayTienTableModel;
import Model.VayTienTransModel;
import View.GuiTienView;
import View.MasterTeleMoneyView;
import View.MuaStockView;
import View.ShowGuiTienView;
import View.ShowTraGopView;
import View.ShowVayTienView;
import View.ThanhToanView;
import View.TraGopView;
import View.VayTienView;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import lib.ButtonColumn;
import yahoofinance.YahooFinance;

public class VayNoController {

    DecimalFormat df = new DecimalFormat("0");
    private GuiTienDAO guiTienDAO = null;
    private VayTienDAO vayTienDAO = null;
    private TraGopDAO traGopDAO = null;
    private MasterTeleMoneyView master;
    private UserModel acc;
    private Integer tableSelect;
    GuiTienTableModel guiTienTableModel = new GuiTienTableModel();
    VayTienTableModel vayTienTableModel = new VayTienTableModel();
    TraGopTableModel traGopTableModel = new TraGopTableModel();
    Vector guiTienTableData, vayTienTableData, traGopTableData;

    public VayNoController(MasterTeleMoneyView master, UserModel acc) throws IOException {
        this.master = master;
        this.acc = acc;
        master.setVisible(true);
        guiTienDAO = new GuiTienDAO();
        vayTienDAO = new VayTienDAO();
        traGopDAO = new TraGopDAO();
        this.master.tableGuiTien.setModel(guiTienTableModel);
        this.master.tableVayTien.setModel(vayTienTableModel);
        this.master.tableTraGop.setModel(traGopTableModel);
        setDataTable();
        setEventGuiTien();
        //setTableButton();
    }

    public void enable() {
        setEventGuiTien();
        //setTableButton();
        //setTableButton();

    }

    public void setDataTable() throws IOException {
        GuiTienTableModel tableModel = (GuiTienTableModel) master.tableGuiTien.getModel();
        ArrayList<GuiTienModel> guiTienModels = new ArrayList<>();
        guiTienModels = guiTienDAO.getAll(acc);
        tableModel.setRowCount(0);
        for (int i = 0; i < guiTienModels.size(); i++) {
            tableModel.addRow(new Object[]{
                guiTienModels.get(i).getId(),
                guiTienModels.get(i).getTen(),
                guiTienModels.get(i).getBank(),
                df.format(guiTienModels.get(i).getTiengoc()),
                guiTienModels.get(i).getLaisuat(),
                guiTienModels.get(i).getKyhan(),
                guiTienModels.get(i).getNgaygui()
            });
        }
        guiTienTableData = (Vector) ((DefaultTableModel) master.tableGuiTien.getModel()).getDataVector().clone();
        VayTienTableModel tableModel1 = (VayTienTableModel) master.tableVayTien.getModel();
        ArrayList<VayTienModel> vayTienModels = new ArrayList<>();
        vayTienModels = vayTienDAO.getAll(acc);
        tableModel1.setRowCount(0);
        for (int i = 0; i < vayTienModels.size(); i++) {
            tableModel1.addRow(new Object[]{
                vayTienModels.get(i).getId(),
                vayTienModels.get(i).getTen(),
                vayTienModels.get(i).getBank(),
                df.format(vayTienModels.get(i).getTiengoc()),
                vayTienModels.get(i).getLaisuat(),
                vayTienModels.get(i).getKyhan(),
                vayTienModels.get(i).getNgayvay()
            });
        }
        vayTienTableData = (Vector) ((DefaultTableModel) master.tableVayTien.getModel()).getDataVector().clone();

        TraGopTableModel tableModel2 = (TraGopTableModel) master.tableTraGop.getModel();
        ArrayList<TraGopModel> traGopModels = new ArrayList<>();
        traGopModels = traGopDAO.getAll(acc);
        tableModel2.setRowCount(0);

        for (int i = 0; i < traGopModels.size(); i++) {
            tableModel2.addRow(new Object[]{
                traGopModels.get(i).getId(),
                traGopModels.get(i).getTen(),
                traGopModels.get(i).getBank(),
                df.format(traGopModels.get(i).getTratruoc()),
                df.format(traGopModels.get(i).getTongtien()),
                traGopModels.get(i).getSothang(),
                df.format(traGopModels.get(i).getTienhangthang()),
                traGopModels.get(i).getTime()
            });
            //"Tên", "Công ty", "Trả trước", "Tổng tiền (VNĐ)","Số tháng", "Tiền hàng tháng", "Ngày"
        }
        traGopTableData = (Vector) ((DefaultTableModel) master.tableTraGop.getModel()).getDataVector().clone();
    }
//    public void setButton(){
//   

    public void setEventGuiTien() {
        System.out.println("Tao event tab vayno");
        master.btnThemTK.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiTienView guiTienView = new GuiTienView(master, acc);
                guiTienView.setVisible(true);
            }
        }
        );
        master.btnThemVay.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VayTienView vayTienView = new VayTienView(master, acc);
                vayTienView.setVisible(true);
            }
        }
        );
        master.btnThemTG.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TraGopView traGopView = new TraGopView(master, acc);
                traGopView.setVisible(true);
            }
        }
        );
        System.out.println("tao xong event vayno");
        master.txtLocVay.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent documentEvent) {
                search();
            }

            public void insertUpdate(DocumentEvent documentEvent) {
                search();
            }

            public void removeUpdate(DocumentEvent documentEvent) {
                search();
            }

            private void search() {
                searchTableContents(master.txtLocVay.getText(), master.tableVayTien, vayTienTableData);
            }
        });
        master.txtLocTK.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent documentEvent) {
                search();
            }

            public void insertUpdate(DocumentEvent documentEvent) {
                search();
            }

            public void removeUpdate(DocumentEvent documentEvent) {
                search();
            }

            private void search() {
                searchTableContents(master.txtLocTK.getText(), master.tableGuiTien, guiTienTableData);
            }
        });
        master.txtLocTG.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent documentEvent) {
                search();
            }

            public void insertUpdate(DocumentEvent documentEvent) {
                search();
            }

            public void removeUpdate(DocumentEvent documentEvent) {
                search();
            }

            private void search() {
                searchTableContents(master.txtLocTG.getText(), master.tableTraGop, traGopTableData);
            }
        });

        master.tableGuiTien.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_UP:
                        tableSelect = master.tableGuiTien.getSelectedRow();
                        if (tableSelect != -1) {
                            master.btnXoaChi.setEnabled(true);
                            master.btnSuaChi.setEnabled(true);

                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        tableSelect = master.tableGuiTien.getSelectedRow();
                        if (tableSelect != -1) {
                            master.btnXoaChi.setEnabled(true);
                            master.btnSuaChi.setEnabled(true);

                        }
                        break;

                }
            }
        });

        master.tableVayTien.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_UP:
                        tableSelect = master.tableVayTien.getSelectedRow();
                        if (tableSelect != -1) {
                            master.btnXoaChi.setEnabled(true);
                            master.btnSuaChi.setEnabled(true);

                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        tableSelect = master.tableVayTien.getSelectedRow();
                        if (tableSelect != -1) {
                            master.btnXoaChi.setEnabled(true);
                            master.btnSuaChi.setEnabled(true);

                        }
                        break;

                }
            }
        });
        master.tableTraGop.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_UP:
                        tableSelect = master.tableTraGop.getSelectedRow();
                        if (tableSelect != -1) {
                            master.btnXoaChi.setEnabled(true);
                            master.btnSuaChi.setEnabled(true);

                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        tableSelect = master.tableTraGop.getSelectedRow();
                        if (tableSelect != -1) {
                            master.btnXoaChi.setEnabled(true);
                            master.btnSuaChi.setEnabled(true);

                        }
                        break;

                }
            }
        });
        master.tableGuiTien.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tableSelect = master.tableGuiTien.getSelectedRow();
                System.out.println("dang chon dong  " + tableSelect);
                if (tableSelect != -1) {
                    master.btnXemChiTietGuiTien.setEnabled(true);

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        master.tableTraGop.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tableSelect = master.tableTraGop.getSelectedRow();
                System.out.println("dang chon dong tra gop " + tableSelect);
                if (tableSelect != -1) {
                    master.btnXemChiTietTraGop.setEnabled(true);

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        master.tableVayTien.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tableSelect = master.tableVayTien.getSelectedRow();
                System.out.println("dang chon dong vay tien " + tableSelect);
                if (tableSelect != -1) {
                    master.btnXemChiTietVayTien.setEnabled(true);

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        master.btnShowVay.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowVayTienView showVayTienView = new ShowVayTienView(master, acc);
                showVayTienView.setVisible(true);
            }
        }
        );
        master.btnShowTK.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowGuiTienView showGuiTienView = new ShowGuiTienView(master, acc);
                showGuiTienView.setVisible(true);
            }
        }
        );
        master.btnShowTG.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowTraGopView showTraGopView = new ShowTraGopView(master, acc);
                showTraGopView.setVisible(true);
            }
        }
        );
        master.btnXemChiTietTraGop.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int xemTraGopID = (int) master.tableTraGop.getValueAt(tableSelect, 0);
                ShowTraGopView showTraGopView = new ShowTraGopView(master, acc, xemTraGopID);
                showTraGopView.setVisible(true);
            }
        }
        );
        master.btnXemChiTietGuiTien.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int xemTraGopID = (int) master.tableGuiTien.getValueAt(tableSelect, 0);
                ShowGuiTienView showGuiTienView = new ShowGuiTienView(master, acc, xemTraGopID);
                showGuiTienView.setVisible(true);
            }
        }
        );
        master.btnXemChiTietVayTien.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int xemTraGopID = (int) master.tableVayTien.getValueAt(tableSelect, 0);
                ShowVayTienView showVayTienView = new ShowVayTienView(master, acc, xemTraGopID);
                showVayTienView.setVisible(true);
            }
        }
        );
        master.btnCheckThanhToan.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkThanhToan();
            }
        }
        );

    }

    public void searchTableContents(String searchString, JTable table, Vector OGVector) {
        DefaultTableModel currtableModel = (DefaultTableModel) table.getModel();
        //To empty the table before search
        currtableModel.setRowCount(0);
        //To search for contents from original table content
        for (Object rows : OGVector) {
            Vector rowVector = (Vector) rows;
            for (Object column : rowVector) {
                if (column.toString().contains(searchString)) {
                    //content found so adding to table
                    currtableModel.addRow(rowVector);
                    break;
                }
            }

        }
    }

    public void checkThanhToan() {
        int check = 0;
        ArrayList<TraGopTransModel> traGopTranList = new ArrayList<>();
        traGopTranList = traGopDAO.getAllTrans(acc);
        for (int i = 0; i < traGopTranList.size(); i++) {
            TraGopTransModel traGop = traGopTranList.get(i);

            if (traGop.getTime().toLocalDateTime().toLocalDate().isBefore(LocalDate.now())
                    || traGop.getTime().toLocalDateTime().toLocalDate().isEqual(LocalDate.now())) {
                if (traGop.getStatus().equalsIgnoreCase("chưa thanh toán")) {
                    ThanhToanView thanhToanView = new ThanhToanView(master, traGop);
                    check += 1;
                }
            }
        }

        ArrayList<VayTienTransModel> vayTienTranList = new ArrayList<>();
        vayTienTranList = vayTienDAO.getAllTrans(acc);
        for (int i = 0; i < vayTienTranList.size(); i++) {
            VayTienTransModel vayTien = vayTienTranList.get(i);

            if (vayTien.getTime().toLocalDateTime().toLocalDate().isBefore(LocalDate.now())
                    || vayTien.getTime().toLocalDateTime().toLocalDate().isEqual(LocalDate.now())) {
                if (vayTien.getStatus().equalsIgnoreCase("chưa thanh toán")) {
                    ThanhToanView thanhToanView = new ThanhToanView(master, vayTien);
                    check += 1;
                }
            }
        }
        ArrayList<GuiTienTransModel> guiTienTranList = new ArrayList<>();
        guiTienTranList = guiTienDAO.getAllTrans(acc);
        for (int i = 0; i < guiTienTranList.size(); i++) {
            GuiTienTransModel guiTien = guiTienTranList.get(i);

            if (guiTien.getTime().toLocalDateTime().toLocalDate().isBefore(LocalDate.now())
                    || guiTien.getTime().toLocalDateTime().toLocalDate().isEqual(LocalDate.now())) {
                if (guiTien.getStatus().equalsIgnoreCase("chưa thanh toán")) {
                    ThanhToanView thanhToanView = new ThanhToanView(master, guiTien);
                    check += 1;
                }
            }
        }
        if (check == 0) {
            JOptionPane.showMessageDialog(master, "Không có giao dịch nào đến hạn thanh toán.");
        }
    }
}
