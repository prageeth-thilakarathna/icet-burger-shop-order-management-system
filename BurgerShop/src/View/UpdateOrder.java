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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author ygpra
 */
public class UpdateOrder extends JFrame {

    private final JPanel labelPanel;
    private final JLabel label;
    private final JPanel body;
    private final JPanel orderDetails;
    private final JPanel colNames;
    private final JLabel orderStatusLabel;
    private final JLabel orderIDLabel;
    private final JLabel customerIDLabel;
    private final JLabel nameLabel;
    private final JLabel qtyLabel;
    private final JLabel totalLabel;
    private final JPanel inputDetails;
    private final JPanel selectOrderStatusPanel;
    private JTextField inputOrderID;
    private final JPanel inputOrderIDPanel;
    private JTextField inputCustomerID;
    private final JPanel inputCustomerIDPanel;
    private JTextField inputName;
    private final JPanel inputNamePanel;
    private JTextField inputQty;
    private final JPanel inputQtyPanel;
    private JLabel totalValueOfOrder;
    private final JPanel errorMessage;
    private JLabel errorStatus;
    private JLabel errorQty;
    private final JPanel controllers;
    private JButton updateBtn;
    private final JPanel updateBtnPanel;
    private JButton backToBtn;
    private final JPanel backBtnPanel;
    private JButton btnOk;
    private JButton btnYESanother;
    private JButton btnNOanother;
    private JLabel orderIdError;

    public UpdateOrder() {
        setSize(1100, 640); 
        setTitle("Burger Shop - Update Order");
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
        label = new JLabel("Update Order", SwingConstants.CENTER);
        label.setBorder(BorderFactory.createMatteBorder(20, 10, 20, 10, OrderController.MainColor));
        label.setFont(new Font("", 1, 30));
        label.setForeground(Color.white);
        labelPanel.add(label, BorderLayout.CENTER);

        // body
        body = new JPanel();
        body.setLayout(new BorderLayout());
        body.setBorder(BorderFactory.createMatteBorder(40, 20, 50, 50, OrderController.whiteBack));

        // order details
        orderDetails = new JPanel();
        orderDetails.setLayout(new GridLayout(1, 3));
        orderDetails.setBorder(BorderFactory.createMatteBorder(40, 20, 20, 100, OrderController.whiteBack));

        // col names
        colNames = new JPanel();
        colNames.setLayout(new GridLayout(6, 1));
        colNames.setBackground(OrderController.whiteBack);
        orderDetails.add(colNames);

        // col labels
        orderStatusLabel = new JLabel("Order Status");
        orderStatusLabel.setFont(new Font("", 1, 16));
        orderStatusLabel.setForeground(OrderController.typography);
        orderStatusLabel.setBorder(BorderFactory.createMatteBorder(0, 100, 0, 0, OrderController.whiteBack));
        colNames.add(orderStatusLabel);

        orderIDLabel = new JLabel("Order ID");
        orderIDLabel.setFont(new Font("", 1, 16));
        orderIDLabel.setForeground(OrderController.typography);
        orderIDLabel.setBorder(BorderFactory.createMatteBorder(0, 100, 0, 0, OrderController.whiteBack));
        colNames.add(orderIDLabel);

        customerIDLabel = new JLabel("Customer ID");
        customerIDLabel.setFont(new Font("", 1, 16));
        customerIDLabel.setForeground(OrderController.typography);
        customerIDLabel.setBorder(BorderFactory.createMatteBorder(0, 100, 0, 0, OrderController.whiteBack));
        colNames.add(customerIDLabel);

        nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font("", 1, 16));
        nameLabel.setForeground(OrderController.typography);
        nameLabel.setBorder(BorderFactory.createMatteBorder(0, 100, 0, 0, OrderController.whiteBack));
        colNames.add(nameLabel);

        qtyLabel = new JLabel("Quantity");
        qtyLabel.setFont(new Font("", 1, 16));
        qtyLabel.setForeground(OrderController.typography);
        qtyLabel.setBorder(BorderFactory.createMatteBorder(0, 100, 0, 0, OrderController.whiteBack));
        colNames.add(qtyLabel);

        totalLabel = new JLabel("Total");
        totalLabel.setFont(new Font("", 1, 16));
        totalLabel.setForeground(OrderController.typography);
        totalLabel.setBorder(BorderFactory.createMatteBorder(0, 100, 0, 0, OrderController.whiteBack));
        colNames.add(totalLabel);

        // input details
        inputDetails = new JPanel();
        inputDetails.setLayout(new GridLayout(6, 1));
        inputDetails.setBackground(OrderController.whiteBack);
        orderDetails.add(inputDetails);

        // inputs
        String[] statusList = {"Preparing", "Delivered", "Cancel"};
        JComboBox<String> selectOrderStatus = new JComboBox<>(statusList);
        selectOrderStatus.setFont(new Font("", 1, 16));
        selectOrderStatus.setForeground(OrderController.typography);
        selectOrderStatus.setBackground(OrderController.textBoxBackG);

        selectOrderStatusPanel = new JPanel();
        selectOrderStatusPanel.setLayout(new GridLayout(1, 1));
        selectOrderStatusPanel.setBorder(BorderFactory.createMatteBorder(15, 0, 15, 0, OrderController.whiteBack));
        selectOrderStatusPanel.add(selectOrderStatus);
        inputDetails.add(selectOrderStatusPanel);

        // order id
        inputOrderID = new JTextField();
        inputOrderID.setFont(new Font("", 1, 16));
        inputOrderID.setForeground(OrderController.typography);
        inputOrderID.setBackground(OrderController.textBoxBackG);

        inputOrderIDPanel = new JPanel();
        inputOrderIDPanel.setLayout(new GridLayout(1, 1));
        inputOrderIDPanel.setBorder(BorderFactory.createMatteBorder(15, 0, 15, 0, OrderController.whiteBack));
        inputOrderIDPanel.add(inputOrderID);
        inputDetails.add(inputOrderIDPanel);

        // customer id
        inputCustomerID = new JTextField();
        inputCustomerID.setFont(new Font("", 1, 16));
        inputCustomerID.setForeground(OrderController.typography);
        inputCustomerID.setBackground(OrderController.headerColor);
        inputCustomerID.setEditable(false);

        inputCustomerIDPanel = new JPanel();
        inputCustomerIDPanel.setLayout(new GridLayout(1, 1));
        inputCustomerIDPanel.setBorder(BorderFactory.createMatteBorder(15, 0, 15, 0, OrderController.whiteBack));
        inputCustomerIDPanel.add(inputCustomerID);
        inputDetails.add(inputCustomerIDPanel);

        // name
        inputName = new JTextField();
        inputName.setFont(new Font("", 1, 16));
        inputName.setForeground(OrderController.typography);
        inputName.setBackground(OrderController.headerColor);
        inputName.setEditable(false);

        inputNamePanel = new JPanel();
        inputNamePanel.setLayout(new GridLayout(1, 1));
        inputNamePanel.setBorder(BorderFactory.createMatteBorder(15, 0, 15, 0, OrderController.whiteBack));
        inputNamePanel.add(inputName);
        inputDetails.add(inputNamePanel);

        // qty
        inputQty = new JTextField();
        inputQty.setFont(new Font("", 1, 16));
        inputQty.setForeground(OrderController.typography);
        inputQty.setBackground(OrderController.textBoxBackG);

        inputQtyPanel = new JPanel();
        inputQtyPanel.setLayout(new GridLayout(1, 1));
        inputQtyPanel.setBorder(BorderFactory.createMatteBorder(15, 0, 15, 0, OrderController.whiteBack));
        inputQtyPanel.add(inputQty);
        inputDetails.add(inputQtyPanel);

        // total
        totalValueOfOrder = new JLabel("0.00");
        totalValueOfOrder.setFont(new Font("", 1, 16));
        totalValueOfOrder.setForeground(OrderController.typography);
        inputDetails.add(totalValueOfOrder);

        // error message
        errorMessage = new JPanel();
        errorMessage.setLayout(new GridLayout(6, 1));
        errorMessage.setBackground(OrderController.whiteBack);
        orderDetails.add(errorMessage);

        errorStatus = new JLabel("");
        errorStatus.setForeground(Color.red);
        errorStatus.setFont(new Font("", 1, 12));
        errorMessage.add(errorStatus);

        orderIdError = new JLabel("");
        orderIdError.setForeground(Color.red);
        orderIdError.setFont(new Font("", 1, 12));
        errorMessage.add(orderIdError);

        JLabel empty2 = new JLabel("");
        errorMessage.add(empty2);

        JLabel empty3 = new JLabel("");
        errorMessage.add(empty3);

        errorQty = new JLabel("");
        errorQty.setForeground(Color.red);
        errorQty.setFont(new Font("", 1, 12));
        errorMessage.add(errorQty);

        // controllers
        controllers = new JPanel();
        controllers.setLayout(new BorderLayout());

        // update button
        updateBtn = new JButton("Update Order");
        updateBtn.setFont(new Font("", 1, 16));
        updateBtn.setBackground(OrderController.SecondColor);
        updateBtn.setForeground(Color.white);
        updateBtn.setBorderPainted(false);
        updateBtn.setFocusPainted(false);

        updateBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                updateBtn.setBackground(OrderController.OverSecond);
                updateBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                updateBtn.setBackground(OrderController.SecondColor);
            }

            @Override
            public void mousePressed(MouseEvent me) {
                updateBtn.setForeground(Color.black);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                updateBtn.setForeground(Color.white);
            }
        });

        updateBtnPanel = new JPanel();
        updateBtnPanel.setLayout(new GridLayout(1, 1));
        updateBtnPanel.setBorder(BorderFactory.createMatteBorder(0, 700, 0, 30, OrderController.whiteBack));
        updateBtnPanel.add(updateBtn);
        controllers.add(updateBtnPanel, BorderLayout.CENTER);

        // back to home button
        backToBtn = new JButton("Back to Home");
        backToBtn.setFont(new Font("", 1, 16));
        backToBtn.setBackground(OrderController.MainColor);
        backToBtn.setForeground(Color.white);
        backToBtn.setBorderPainted(false);
        backToBtn.setFocusPainted(false);

        backToBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                backToBtn.setBackground(OrderController.OverMain);
                backToBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                backToBtn.setBackground(OrderController.MainColor);
            }

            @Override
            public void mousePressed(MouseEvent me) {
                backToBtn.setForeground(Color.black);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                backToBtn.setForeground(Color.white);
            }
        });

        backBtnPanel = new JPanel();
        backBtnPanel.setLayout(new GridLayout(1, 1));
        backBtnPanel.add(backToBtn);
        controllers.add(backBtnPanel, BorderLayout.EAST);

        // search key listener
        inputOrderID.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                String value = inputOrderID.getText();
                int l = value.length();
                if (l >= 0 && l < 4 || (int) ke.getKeyChar() == 8) {
                    inputOrderID.setEditable(true);
                } else {
                    inputOrderID.setEditable(false);
                }

                if (l == 4) {
                    inputOrderID.setEditable(false);
                }
            }
        });

        // check burger qty
        inputQty.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                String value = inputQty.getText();
                int l = value.length();

                boolean condition = true;
                int count = 0;
                if (l > 0) {
                    count++;
                } else {
                    count = 0;
                }

                if (count == 0 & ke.getKeyChar() == '0') {
                    condition = false;
                }

                if ((l >= 0 && l < 2) & condition & (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || (int) ke.getKeyChar() == 8) {
                    inputQty.setEditable(true);
                    errorQty.setText("");
                } else {
                    inputQty.setEditable(false);

                    if (condition == false) {
                        errorQty.setText("  * Not a Q==0");
                    } else if (l == 2) {
                        errorQty.setText("  * only 2 digits");
                    } else {
                        errorQty.setText("  * only digits(0-9)");
                    }
                }
            }
        });

        // pop up message box
        // ok button
        btnOk = new JButton("OK");
        btnOk.setFont(new Font("", 1, 16));
        btnOk.setBackground(OrderController.SecondColor);
        btnOk.setForeground(Color.white);
        btnOk.setBorderPainted(false);
        btnOk.setFocusPainted(false);

        btnOk.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                btnOk.setBackground(OrderController.OverSecond);
                btnOk.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btnOk.setBackground(OrderController.SecondColor);
            }

            @Override
            public void mousePressed(MouseEvent me) {
                btnOk.setForeground(Color.black);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                btnOk.setForeground(Color.white);
            }
        });
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                JOptionPane.getRootFrame().dispose();
            }
        });
        JButton[] btnOkCustom = {btnOk};

        // yes/no another buttons
        // yes another
        btnYESanother = new JButton("YES");
        btnYESanother.setFont(new Font("", 1, 16));
        btnYESanother.setBackground(OrderController.SecondColor);
        btnYESanother.setForeground(Color.white);
        btnYESanother.setBorderPainted(false);
        btnYESanother.setFocusPainted(false);

        btnYESanother.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                btnYESanother.setBackground(OrderController.OverSecond);
                btnYESanother.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btnYESanother.setBackground(OrderController.SecondColor);
            }

            @Override
            public void mousePressed(MouseEvent me) {
                btnYESanother.setForeground(Color.black);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                btnYESanother.setForeground(Color.white);
            }
        });
        btnYESanother.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new UpdateOrder().setVisible(true);
                setVisible(false);
                JOptionPane.getRootFrame().dispose();
            }
        });

        // no another
        btnNOanother = new JButton("NO");
        btnNOanother.setFont(new Font("", 1, 16));
        btnNOanother.setBackground(OrderController.MainColor);
        btnNOanother.setForeground(Color.white);
        btnNOanother.setBorderPainted(false);
        btnNOanother.setFocusPainted(false);

        btnNOanother.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                btnNOanother.setBackground(OrderController.OverMain);
                btnNOanother.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btnNOanother.setBackground(OrderController.MainColor);
            }

            @Override
            public void mousePressed(MouseEvent me) {
                btnNOanother.setForeground(Color.black);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                btnNOanother.setForeground(Color.white);
            }
        });
        btnNOanother.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new HomePage().setVisible(true);
                setVisible(false);
                JOptionPane.getRootFrame().dispose();
            }
        });
        JButton[] btnYESorNOanotherCustom = {btnYESanother, btnNOanother};

        // search details display
        inputOrderID.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String value = inputOrderID.getText();
                int l = value.length();
                if (l == 4) {
                    if (OrderController.checkOrderId(value)) {
                        int index = OrderController.findOrderIdIndex(value);

                        int qty = OrderController.orList.getQtys(index);
                        double total = qty * OrderDetails.BURGERPRICE;

                        int sta = OrderController.orList.getStatus(index);

                        String custId = OrderController.orList.getCustomerId(index);
                        String name = OrderController.orList.getName(index);
                        String qtyString = String.valueOf(qty);

                        // set details
                        inputCustomerID.setText(custId);
                        inputName.setText(name);
                        inputQty.setText(qtyString);
                        totalValueOfOrder.setText(OrderController.df.format(total));

                        if (sta == 0) {
                            selectOrderStatus.setSelectedIndex(0);
                        } else if (sta == 1) {
                            selectOrderStatus.setSelectedIndex(1);
                            selectOrderStatus.setEnabled(false);
                            inputQty.setEditable(false);
                            inputQty.setBackground(OrderController.headerColor);
                            errorStatus.setText("<html>&nbsp&nbsp* This Order is already delivered.<br> &nbsp&nbsp&nbsp Sorry, you can not update this order.<html>");
                        } else {
                            selectOrderStatus.setSelectedIndex(2);
                            selectOrderStatus.setEnabled(false);
                            inputQty.setEditable(false);
                            inputQty.setBackground(OrderController.headerColor);
                            errorStatus.setText("<html>&nbsp&nbsp* This Order is already cancelled.<br> &nbsp&nbsp&nbsp Sorry, you can not update this order.<html>");
                        }

                    } else {
                        orderIdError.setText(" * Invalid Order ID!");
                        inputOrderID.setEditable(false);
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

        // back to home
        backToBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new HomePage().setVisible(true);
                setVisible(false);
            }
        });

        // update order
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String id = inputOrderID.getText();
                int index = OrderController.findOrderIdIndex(id);
                int orderStatus = OrderController.findOrderStatus(index);

                if (OrderController.checkOrderId(id)) {
                    if (orderStatus == 0) {
                        int orderSta = selectOrderStatus.getSelectedIndex();
                        String value = inputQty.getText();
                        int newQty = Integer.parseInt(value);
                        
                        int qty = OrderController.orList.getQtys(index);
                        if (orderSta!=0 & qty!=newQty) {
                            // quantity update
                            OrderController.orList.updateQtys(index, newQty);

                            // status update
                            OrderController.orList.updateStatus(index, orderSta);

                            JOptionPane.showOptionDialog(null, "Update order status and quantity successfully...", "Success Message", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, OrderController.successIcon, btnOkCustom, btnOkCustom[0]);
                            JOptionPane.showOptionDialog(null, "Do you want to update another order details?", "Another Option", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, OrderController.questionIcon, btnYESorNOanotherCustom, btnYESorNOanotherCustom[0]);
                        } else if (orderSta!=0 & qty==newQty){
                            // status update
                            OrderController.orList.updateStatus(index, orderSta);
                            
                            JOptionPane.showOptionDialog(null, "Update order status successfully...", "Success Message", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, OrderController.successIcon, btnOkCustom, btnOkCustom[0]);
                            JOptionPane.showOptionDialog(null, "Do you want to update another order details?", "Another Option", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, OrderController.questionIcon, btnYESorNOanotherCustom, btnYESorNOanotherCustom[0]);
                        } else if (orderSta==0 & qty!=newQty){
                            // quantity update
                            OrderController.orList.updateQtys(index, newQty);
                            
                            JOptionPane.showOptionDialog(null, "Update order quantity successfully...", "Success Message", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, OrderController.successIcon, btnOkCustom, btnOkCustom[0]);
                            JOptionPane.showOptionDialog(null, "Do you want to update another order details?", "Another Option", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, OrderController.questionIcon, btnYESorNOanotherCustom, btnYESorNOanotherCustom[0]);
                        } else {
                            JOptionPane.showOptionDialog(null, "Please enter details to update!", "Error Message", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, OrderController.errorIcon, btnOkCustom, btnOkCustom[0]);
                        }

                    } else if (orderStatus == 1) {
                        JOptionPane.showOptionDialog(null, "<html>This Order is already delivered.<br>Sorry, you can not update this order.<html>", "Error Message", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, OrderController.errorIcon, btnOkCustom, btnOkCustom[0]);
                    } else {
                        JOptionPane.showOptionDialog(null, "<html>This Order is already cancelled.<br>Sorry, you can not update this order.<html>", "Error Message", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, OrderController.errorIcon, btnOkCustom, btnOkCustom[0]);
                    }

                } else {
                    JOptionPane.showOptionDialog(null, "Invalid Order ID!", "Check Order ID", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, OrderController.errorIcon, btnOkCustom, btnOkCustom[0]);
                    JOptionPane.showOptionDialog(null, "Do you want to update another order details?", "Another Option", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, OrderController.questionIcon, btnYESorNOanotherCustom, btnYESorNOanotherCustom[0]);
                }
            }
        });

        body.add(orderDetails, BorderLayout.CENTER);
        body.add(controllers, BorderLayout.SOUTH);
        add(labelPanel, BorderLayout.NORTH);
        add(body, BorderLayout.CENTER);
    }
}
