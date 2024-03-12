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
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author ygpra
 */
public class SearchOrder extends JFrame {

    private final JPanel labelPanel;
    private final JLabel label;
    private final JPanel body;
    private final JPanel searchArea;
    private final JPanel searchBox;
    private final JLabel searchLabel;
    private JTextField searchInput;
    private final JPanel search;
    private final JPanel searchValid;
    private final JLabel searchValidMessage;
    private final JPanel orderDetails;
    private final JPanel colLabel;
    private final JLabel custId;
    private final JLabel custName;
    private final JLabel burgerQty;
    private final JLabel totalValue;
    private final JLabel orderStatus;
    private final JPanel detailLabel;
    private JLabel custIdDetail;
    private JLabel custNameDetail;
    private JLabel burgerQtyDetail;
    private JLabel totalValueDetail;
    private JLabel orderStatusDetail;
    private final JPanel controllers;
    private JButton searchAnother;
    private JButton backTo;

    public SearchOrder() {
        setSize(1100, 640);
        setTitle("Burger Shop - Search Order");
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
        label = new JLabel("Search Order", SwingConstants.CENTER);
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
        searchBox.setBorder(BorderFactory.createMatteBorder(70, 120, 70, 0, OrderController.whiteBack));
        searchBox.setBackground(OrderController.whiteBack);

        // search label
        searchLabel = new JLabel("Enter Order ID :");
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

        searchValidMessage = new JLabel("");
        searchValidMessage.setForeground(Color.red);
        searchValid.add(searchValidMessage);
        searchBox.add(searchValid);

        // order details
        orderDetails = new JPanel();
        orderDetails.setLayout(new GridLayout(1, 3));

        // col label
        colLabel = new JPanel();
        colLabel.setLayout(new GridLayout(8, 1));
        colLabel.setBorder(BorderFactory.createMatteBorder(0, 200, 0, 0, OrderController.whiteBack));
        colLabel.setBackground(OrderController.whiteBack);

        // col names
        custId = new JLabel("Customer ID :");
        custId.setFont(new Font("", 1, 16));
        custId.setForeground(OrderController.typography);
        colLabel.add(custId);

        custName = new JLabel("Customer Name :");
        custName.setFont(new Font("", 1, 16));
        custName.setForeground(OrderController.typography);
        colLabel.add(custName);

        burgerQty = new JLabel("Burger Quantity :");
        burgerQty.setFont(new Font("", 1, 16));
        burgerQty.setForeground(OrderController.typography);
        colLabel.add(burgerQty);

        totalValue = new JLabel("Total Value :");
        totalValue.setFont(new Font("", 1, 16));
        totalValue.setForeground(OrderController.typography);
        colLabel.add(totalValue);

        orderStatus = new JLabel("Order Status :");
        orderStatus.setFont(new Font("", 1, 16));
        orderStatus.setForeground(OrderController.typography);
        colLabel.add(orderStatus);

        // detail label
        detailLabel = new JPanel();
        detailLabel.setLayout(new GridLayout(8, 1));
        detailLabel.setBackground(OrderController.whiteBack);

        // details 
        custIdDetail = new JLabel("");
        custIdDetail.setFont(new Font("", 1, 16));
        custIdDetail.setForeground(OrderController.typography);
        detailLabel.add(custIdDetail);

        custNameDetail = new JLabel("");
        custNameDetail.setFont(new Font("", 1, 16));
        custNameDetail.setForeground(OrderController.typography);
        detailLabel.add(custNameDetail);

        burgerQtyDetail = new JLabel("");
        burgerQtyDetail.setFont(new Font("", 1, 16));
        burgerQtyDetail.setForeground(OrderController.typography);
        detailLabel.add(burgerQtyDetail);

        totalValueDetail = new JLabel("");
        totalValueDetail.setFont(new Font("", 1, 16));
        totalValueDetail.setForeground(OrderController.typography);
        detailLabel.add(totalValueDetail);

        orderStatusDetail = new JLabel("");
        orderStatusDetail.setFont(new Font("", 1, 16));
        orderStatusDetail.setForeground(OrderController.typography);
        detailLabel.add(orderStatusDetail);

        // controllers
        controllers = new JPanel();
        controllers.setLayout(null);
        controllers.setBackground(OrderController.whiteBack);

        // search another order
        searchAnother = new JButton("Search Another Order");
        searchAnother.setBounds(0, 120, 250, 35);
        searchAnother.setFont(new Font("", 1, 16));
        searchAnother.setBackground(OrderController.MainColor);
        searchAnother.setForeground(Color.white);
        searchAnother.setBorderPainted(false);
        searchAnother.setFocusPainted(false);
        controllers.add(searchAnother);

        searchAnother.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                searchAnother.setBackground(OrderController.OverMain);
                searchAnother.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                searchAnother.setBackground(OrderController.MainColor);
            }

            @Override
            public void mousePressed(MouseEvent me) {
                searchAnother.setForeground(Color.black);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                searchAnother.setForeground(Color.white);
            }
        });

        // back to home
        backTo = new JButton("Back to Home");
        backTo.setBounds(0, 180, 250, 35);
        backTo.setFont(new Font("", 1, 16));
        backTo.setBackground(OrderController.MainColor);
        backTo.setForeground(Color.white);
        backTo.setBorderPainted(false);
        backTo.setFocusPainted(false);
        controllers.add(backTo);

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

        // search key listener
        searchInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                String value = searchInput.getText();
                int l = value.length();
                if (l >= 0 && l < 4 || (int) ke.getKeyChar() == 8) {
                    searchInput.setEditable(true);
                } else {
                    searchInput.setEditable(false);
                }

                if (l == 4) {
                    searchInput.setEditable(false);
                }
            }
        });

        // button action listener
        // search another order
        searchAnother.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                searchInput.setText("");
                custIdDetail.setText("");
                custNameDetail.setText("");
                burgerQtyDetail.setText("");
                totalValueDetail.setText("");
                orderStatusDetail.setText("");
                searchInput.setEditable(true);
                searchValidMessage.setText("");
            }
        });

        // back to home
        backTo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new HomePage().setVisible(true);
                setVisible(false);
            }
        });

        // search details display
        searchInput.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String value = searchInput.getText();
                int l = value.length();
                if (l == 4) {
                    if (OrderController.checkOrderId(value)) {
                        int index = OrderController.findOrderIdIndex(value);

                        int qty = OrderController.orList.getQtys(index);
                        double total = qty * OrderDetails.BURGERPRICE;

                        String orderStatus;
                        int sta = OrderController.orList.getStatus(index);

                        if (sta == 0) {
                            orderStatus = "Preparing...";
                        } else if (sta == 1) {
                            orderStatus = "Delivered";
                        } else {
                            orderStatus = "Cancel";
                        }

                        String custId = OrderController.orList.getCustomerId(index);
                        String name = OrderController.orList.getName(index);
                        String qtyString = String.valueOf(qty);
                        String totalString = String.valueOf(total);

                        // set details
                        custIdDetail.setText(custId);
                        custNameDetail.setText(name);
                        burgerQtyDetail.setText(qtyString);
                        totalValueDetail.setText(totalString);
                        orderStatusDetail.setText(orderStatus);
                    } else {
                        searchValidMessage.setText(" * Invalid Order ID!");
                    }
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });

        JLabel empty1 = new JLabel("");
        JPanel emptyPanel = new JPanel();
        emptyPanel.setLayout(new GridLayout(1, 1));
        emptyPanel.add(empty1);
        emptyPanel.setBackground(OrderController.whiteBack);

        orderDetails.add(colLabel);
        orderDetails.add(detailLabel);
        orderDetails.add(controllers);
        searchArea.add(searchBox);
        searchArea.add(emptyPanel);
        body.add(searchArea, BorderLayout.NORTH);
        body.add(orderDetails, BorderLayout.CENTER);
        add(labelPanel, BorderLayout.NORTH);
        add(body, BorderLayout.CENTER);
    }
}
