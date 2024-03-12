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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import static javax.swing.BorderFactory.createEmptyBorder;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ygpra
 */
public class SearchCustomer extends JFrame {

    private final JTable tblCustomerDetails;
    private DefaultTableModel dtm;
    private final JPanel labelPanel;
    private final JLabel label;
    private final JPanel body;
    private final JPanel searchArea;
    private final JPanel searchBox;
    private final JLabel searchLabel;
    private JTextField searchInput;
    private final JPanel searchValid;
    private final JPanel search;
    private JLabel searchErrorMessage;
    private final JPanel custNamePanel;
    private final JLabel custNameLabel;
    private JLabel custNameDisplay;
    private final JPanel searchAndName;
    private final JPanel searchAnother;
    private JButton searchAnotherBtn;
    private final JPanel customerDetails;
    private final JPanel header;
    private final JLabel headerLabel;
    private final JPanel tablePanel;
    private JButton backTo;
    private final JPanel backBtnPanel;

    public SearchCustomer() {
        setSize(1100, 640); 
        setTitle("Burger Shop - Search Customer");
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
        label = new JLabel("Search Customer", SwingConstants.CENTER);
        label.setBorder(BorderFactory.createMatteBorder(20, 10, 20, 10, OrderController.MainColor));
        label.setFont(new Font("", 1, 30));
        label.setForeground(Color.white);
        labelPanel.add(label, BorderLayout.CENTER);

        // body
        body = new JPanel();
        body.setLayout(new BorderLayout());

        // search area
        searchArea = new JPanel();
        searchArea.setLayout(new GridLayout(1, 2));

        // search box
        searchBox = new JPanel();
        searchBox.setLayout(new GridLayout(1, 3));
        searchBox.setBorder(BorderFactory.createMatteBorder(20, 70, 9, 0, OrderController.whiteBack));
        searchBox.setBackground(OrderController.whiteBack);

        // search label
        searchLabel = new JLabel("Enter Customer ID :");
        searchLabel.setFont(new Font("", 1, 16));
        searchLabel.setForeground(OrderController.typography);
        searchBox.add(searchLabel);

        // input search
        searchInput = new JTextField();
        searchInput.setFont(new Font("", 1, 16));
        searchInput.setForeground(OrderController.typography);
        searchInput.setBackground(OrderController.textBoxBackG);

        search = new JPanel();
        search.setLayout(new GridLayout(1, 1));
        search.add(searchInput);
        searchBox.add(search);

        // search validation 
        searchValid = new JPanel();
        searchValid.setLayout(new GridLayout(1, 1));
        searchValid.setBackground(OrderController.whiteBack);

        searchErrorMessage = new JLabel("");
        searchErrorMessage.setForeground(Color.red);
        searchValid.add(searchErrorMessage);
        searchBox.add(searchValid);

        // customer name
        custNamePanel = new JPanel();
        custNamePanel.setLayout(new BorderLayout());
        custNamePanel.setBackground(OrderController.whiteBack);

        custNameLabel = new JLabel("Name :");
        custNameLabel.setFont(new Font("", 1, 16));
        custNameLabel.setForeground(OrderController.typography);
        custNameLabel.setBorder(BorderFactory.createMatteBorder(10, 70, 30, 0, OrderController.whiteBack));
        custNamePanel.add(custNameLabel, BorderLayout.WEST);

        custNameDisplay = new JLabel("");
        custNameDisplay.setFont(new Font("", 1, 16));
        custNameDisplay.setForeground(OrderController.typography);
        custNameDisplay.setBorder(BorderFactory.createMatteBorder(10, 15, 30, 0, OrderController.whiteBack));
        custNamePanel.add(custNameDisplay, BorderLayout.CENTER);

        // search and name
        searchAndName = new JPanel();
        searchAndName.setLayout(new GridLayout(2, 1));
        searchAndName.add(searchBox);
        searchAndName.add(custNamePanel);

        // search another customer 
        searchAnother = new JPanel();
        searchAnother.setBackground(OrderController.whiteBack);
        searchAnother.setLayout(null);

        // search another button
        searchAnotherBtn = new JButton("Search Another Customer");
        searchAnotherBtn.setBounds(210, 45, 260, 35);
        searchAnotherBtn.setFont(new Font("", 1, 16));
        searchAnotherBtn.setBackground(OrderController.MainColor);
        searchAnotherBtn.setForeground(Color.white);
        searchAnotherBtn.setBorderPainted(false);
        searchAnotherBtn.setFocusPainted(false);

        searchAnotherBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                searchAnotherBtn.setBackground(OrderController.OverMain);
                searchAnotherBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                searchAnotherBtn.setBackground(OrderController.MainColor);
            }

            @Override
            public void mousePressed(MouseEvent me) {
                searchAnotherBtn.setForeground(Color.black);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                searchAnotherBtn.setForeground(Color.white);
            }
        });
        searchAnother.add(searchAnotherBtn);

        // customer details
        customerDetails = new JPanel();
        customerDetails.setLayout(new BorderLayout());

        // header
        header = new JPanel();
        header.setLayout(new BorderLayout());
        header.setBackground(OrderController.MainColor);

        headerLabel = new JLabel("Order Details", SwingConstants.CENTER);
        headerLabel.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, OrderController.MainColor));
        headerLabel.setFont(new Font("", 1, 20));
        headerLabel.setForeground(Color.white);
        header.add(headerLabel, BorderLayout.CENTER);
        customerDetails.add(header, BorderLayout.NORTH);

        // Tabel		
        // JTabel
        String[] columnName = {"Order ID", "Order Quantity", "Total Value"};
        dtm = new DefaultTableModel(columnName, 0);
        tblCustomerDetails = new JTable(dtm);
        tblCustomerDetails.setFont(new Font("", 1, 16));
        tblCustomerDetails.setForeground(OrderController.typography);
        tblCustomerDetails.setRowHeight(32);
        tblCustomerDetails.setBackground(OrderController.whiteBack);
        tblCustomerDetails.getTableHeader().setBackground(OrderController.headerColor);
        tblCustomerDetails.getTableHeader().setForeground(OrderController.typography);
        tblCustomerDetails.getTableHeader().setFont(new Font("", 1, 16));
        tblCustomerDetails.getTableHeader().setPreferredSize(new Dimension(50, 50));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        tblCustomerDetails.getColumnModel().getColumn(0).setCellRenderer(centerRenderer); // cell value center
        tblCustomerDetails.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tblCustomerDetails.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

        // scroll 
        JScrollPane sp = new JScrollPane(tblCustomerDetails);
        sp.getVerticalScrollBar().setBackground(OrderController.textBoxBackG);
        sp.getViewport().setBackground(OrderController.whiteBack);
        sp.setBorder(createEmptyBorder());

        // table panel
        tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createMatteBorder(30, 70, 30, 70, OrderController.whiteBack));
        tablePanel.add(sp, BorderLayout.CENTER);

        customerDetails.add(tablePanel, BorderLayout.CENTER);

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

        customerDetails.add(backBtnPanel, BorderLayout.SOUTH);

        // input validation
        // search customer id
        searchInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                String value = searchInput.getText();
                int l = value.length();

                char first;
                boolean condition = true;
                if (l > 0) {
                    first = value.charAt(0);
                    if (first == '0') {
                        condition = true;
                    } else {
                        condition = false;
                    }
                }

                if (l >= 0 && l < 10 & (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') & condition || (int) ke.getKeyChar() == 8) {
                    searchInput.setEditable(true);
                    searchErrorMessage.setText("");

                } else {
                    searchInput.setEditable(false);
                    if (l == 10) {
                        searchErrorMessage.setText("  * input 10 digits");
                    } else if (condition == false) {
                        searchErrorMessage.setText("  * Not a first digit==0");
                    } else {
                        searchErrorMessage.setText("  * only digits(0-9)");
                    }
                }

                if (l == 10) {
                    searchInput.setEditable(false);
                }
            }
        });

        // search customer details
        searchInput.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String value = searchInput.getText();
                int l = value.length();
                if (l == 10) {
                    if (OrderController.checkCustomerId(value)) {
                        int index = OrderController.findCustomerIdIndex(value);
                        String name = OrderController.orList.getName(index);
                        custNameDisplay.setText(name);

                        for (int i = 0; i < OrderController.orList.size(); i++) {
                            String id = OrderController.orList.getCustomerId(i);
                            boolean find = id.equals(value);

                            if (find) {
                                int qty = OrderController.orList.getQtys(i);
                                double total = qty * OrderDetails.BURGERPRICE;
                                String totalForamt = OrderController.df.format(total);
                                String orderId = OrderController.orList.getOrderId(i);

                                Object[] rowData = {orderId, qty, totalForamt};
                                dtm.addRow(rowData);
                            }
                        }

                    } else {
                        searchErrorMessage.setText("<html>&nbsp* This customer ID is not<br> &nbsp&nbsp&nbsp added yet...<html>");
                        searchInput.setEditable(false);
                    }
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {}

            @Override
            public void changedUpdate(DocumentEvent e) {}

        });

        // back to home
        backTo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new HomePage().setVisible(true);
                setVisible(false);
            }
        });

        // search another customer
        searchAnotherBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                dtm.setRowCount(0);
                searchInput.setText("");
                searchInput.setEditable(true);
                custNameDisplay.setText("");
            }
        });

        searchArea.add(searchAndName);
        searchArea.add(searchAnother);
        body.add(searchArea, BorderLayout.NORTH);
        body.add(customerDetails, BorderLayout.CENTER);
        add(labelPanel, BorderLayout.NORTH);
        add(body, BorderLayout.CENTER);
    }
}
