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
public class BestCustomer extends JFrame {

    private final JPanel labelPanel;
    private final JLabel label;
    private final JTable tblBestCustomer;
    private final DefaultTableModel dtm;
    private final JPanel body;
    private final JPanel tablePanel;
    private JButton backTo;
    private final JPanel backBtnPanel;

    public BestCustomer() {
        setSize(1100, 640);
        setTitle("Burger Shop - Search Best Customer");
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
        label = new JLabel("Search Best Customer", SwingConstants.CENTER);
        label.setBorder(BorderFactory.createMatteBorder(20, 10, 20, 10, OrderController.MainColor));
        label.setFont(new Font("", 1, 30));
        label.setForeground(Color.white);
        labelPanel.add(label, BorderLayout.CENTER);

        // body
        body = new JPanel();
        body.setLayout(new BorderLayout());

        // Tabel		
        // JTabel
        String[] columnName = {"Customer ID", "Name", "Total"};
        dtm = new DefaultTableModel(columnName, 0);
        tblBestCustomer = new JTable(dtm);
        tblBestCustomer.setFont(new Font("", 1, 16));
        tblBestCustomer.setForeground(OrderController.typography);
        tblBestCustomer.setRowHeight(32);
        tblBestCustomer.setBackground(OrderController.whiteBack);
        tblBestCustomer.getTableHeader().setBackground(OrderController.headerColor);
        tblBestCustomer.getTableHeader().setForeground(OrderController.typography);
        tblBestCustomer.getTableHeader().setFont(new Font("", 1, 16));
        tblBestCustomer.getTableHeader().setPreferredSize(new Dimension(50, 50));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        tblBestCustomer.getColumnModel().getColumn(0).setCellRenderer(centerRenderer); // cell value center
        tblBestCustomer.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tblBestCustomer.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

        // scroll 
        JScrollPane sp = new JScrollPane(tblBestCustomer);
        sp.getVerticalScrollBar().setBackground(OrderController.textBoxBackG);
        sp.getViewport().setBackground(OrderController.whiteBack);
        sp.setBorder(createEmptyBorder());

        // table panel
        tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createMatteBorder(30, 70, 30, 70, OrderController.whiteBack));
        tablePanel.add(sp, BorderLayout.CENTER);

        // add details to tabel
        OrderController.createBestCust();
        OrderController.shortBestCust();

        for (int i = 0; i < OrderController.bestCust.bestSize(); i++) {
            int qty = OrderController.bestCust.getBestQtys(i);
            String name = OrderController.bestCust.getBestCustNames(i);
            String id = OrderController.bestCust.getBestCustIds(i);

            Object[] rowData = {id, name, OrderController.df.format(qty * OrderDetails.BURGERPRICE)};
            dtm.addRow(rowData);
        }

        // controller
        // back button
        backTo = new JButton("Back to Home");
        //backTo.setBounds(0,0,300,35);
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

        // back btn panel
        backBtnPanel = new JPanel();
        backBtnPanel.setLayout(new BorderLayout());
        backBtnPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 30, 70, OrderController.whiteBack));
        backBtnPanel.setBackground(OrderController.whiteBack);
        backBtnPanel.add(backTo, BorderLayout.EAST);

        // back to home
        backTo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                OrderController.clearBestCust();
                new HomePage().setVisible(true);
                setVisible(false);
            }
        });

        body.add(tablePanel, BorderLayout.CENTER);
        body.add(backBtnPanel, BorderLayout.SOUTH);
        add(labelPanel, BorderLayout.NORTH);
        add(body, BorderLayout.CENTER);
    }
}
