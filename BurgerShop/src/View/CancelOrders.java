/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.OrderController;
import Model.OrderDetails;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import static javax.swing.BorderFactory.createEmptyBorder;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ygpra
 */
public class CancelOrders extends JFrame {

    private final JPanel labelPanel;
    private final JLabel label;
    private final JTable tblCancelOrders;
    private final DefaultTableModel dtm;
    private final JPanel body;
    private final JPanel tablePanel;
    private JButton GoToHome;
    private final JPanel goHomeBtnPanel;
    private final JPanel controllers;
    private JButton backTo;
    private final JPanel backBtnPanel;

    public CancelOrders() {
        setSize(1100, 640); 
        setTitle("Burger Shop - Cancel Orders");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setResizable(false);
        setLayout(new BorderLayout());
        
        // set image icon
        setIconImage(OrderController.favicon);

        // add label
        // panel
        labelPanel = new JPanel();
        labelPanel.setLayout(new BorderLayout());
        labelPanel.setBackground(OrderController.MainColor);

        // label
        label = new JLabel("Cancel Orders", SwingConstants.CENTER);
        label.setBorder(BorderFactory.createMatteBorder(20, 10, 20, 10, OrderController.MainColor));
        label.setFont(new Font("", 1, 30));
        label.setForeground(Color.white);
        labelPanel.add(label, BorderLayout.CENTER);

        // body
        body = new JPanel();
        body.setLayout(new BorderLayout());

        // Tabel		
        // JTabel
        String[] columnName = {"Order ID", "Customer ID", "Name", "Quantity", "Order Value"};
        dtm = new DefaultTableModel(columnName, 0);
        tblCancelOrders = new JTable(dtm);
        tblCancelOrders.setFont(new Font("", 1, 16));
        tblCancelOrders.setForeground(OrderController.typography);
        tblCancelOrders.setRowHeight(32);
        tblCancelOrders.setBackground(OrderController.whiteBack);
        tblCancelOrders.getTableHeader().setBackground(OrderController.headerColor);
        tblCancelOrders.getTableHeader().setForeground(OrderController.typography);
        tblCancelOrders.getTableHeader().setFont(new Font("", 1, 16));
        tblCancelOrders.getTableHeader().setPreferredSize(new Dimension(50, 50));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        tblCancelOrders.getColumnModel().getColumn(0).setCellRenderer(centerRenderer); // cell value center
        tblCancelOrders.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tblCancelOrders.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tblCancelOrders.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tblCancelOrders.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

        // scroll 
        JScrollPane sp = new JScrollPane(tblCancelOrders);
        sp.getVerticalScrollBar().setBackground(OrderController.textBoxBackG);
        sp.getViewport().setBackground(OrderController.whiteBack);
        sp.setBorder(createEmptyBorder());

        // table panel
        tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createMatteBorder(30, 70, 30, 70, OrderController.whiteBack));
        tablePanel.add(sp, BorderLayout.CENTER);

        // add details to tabel
        for (int i = 0; i < OrderController.orList.size(); i++) {
            int sta = OrderController.orList.getStatus(i);
            boolean find = sta == 2;

            if (find) {
                int qty = OrderController.orList.getQtys(i);
                double total = qty * OrderDetails.BURGERPRICE;

                String orderId = OrderController.orList.getOrderId(i);
                String custId = OrderController.orList.getCustomerId(i);
                String name = OrderController.orList.getName(i);

                Object[] rowData = {orderId, custId, name, qty, OrderController.df.format(total)};
                dtm.addRow(rowData);
            }
        }

        // controllers
        controllers = new JPanel();
        controllers.setLayout(new BorderLayout());

        // go home button
        GoToHome = new JButton("Go to Home");
        GoToHome.setFont(new Font("", 1, 16));
        GoToHome.setBackground(OrderController.MainColor);
        GoToHome.setForeground(Color.white);
        GoToHome.setBorderPainted(false);
        GoToHome.setFocusPainted(false);

        GoToHome.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                GoToHome.setBackground(OrderController.OverMain);
                GoToHome.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                GoToHome.setBackground(OrderController.MainColor);
            }

            @Override
            public void mousePressed(MouseEvent me) {
                GoToHome.setForeground(Color.black);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                GoToHome.setForeground(Color.white);
            }
        });

        // go home btn panel
        goHomeBtnPanel = new JPanel();
        goHomeBtnPanel.setLayout(new GridLayout(1, 1));
        goHomeBtnPanel.setBorder(BorderFactory.createMatteBorder(0, 700, 30, 30, OrderController.whiteBack));
        goHomeBtnPanel.setBackground(OrderController.whiteBack);
        goHomeBtnPanel.add(GoToHome);
        controllers.add(goHomeBtnPanel, BorderLayout.CENTER);

        // back to view button
        backTo = new JButton("Back to View");
        backTo.setFont(new Font("", 1, 16));
        backTo.setBackground(OrderController.MainColor);
        backTo.setForeground(Color.white);
        backTo.setBorderPainted(false);
        backTo.setFocusPainted(false);

        backTo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                backTo.setBackground(OrderController.OverMain);
                backTo.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                backTo.setBackground(OrderController.MainColor);
            }

            @Override
            public void mousePressed(MouseEvent me) {
                backTo.setForeground(Color.black);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                backTo.setForeground(Color.white);
            }
        });

        backBtnPanel = new JPanel();
        backBtnPanel.setLayout(new GridLayout(1, 1));
        backBtnPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 30, 70, OrderController.whiteBack));
        backBtnPanel.add(backTo);
        controllers.add(backBtnPanel, BorderLayout.EAST);

        // go to home
        GoToHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new HomePage().setVisible(true);
                setVisible(false);
            }
        });

        // back to view
        backTo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new ViewOrders().setVisible(true);
                setVisible(false);
            }
        });

        body.add(tablePanel, BorderLayout.CENTER);
        body.add(controllers, BorderLayout.SOUTH);
        add(labelPanel, BorderLayout.NORTH);
        add(body, BorderLayout.CENTER);
    }
}
