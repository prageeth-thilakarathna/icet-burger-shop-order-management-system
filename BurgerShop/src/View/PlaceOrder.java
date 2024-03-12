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
import java.awt.FlowLayout;
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
public class PlaceOrder extends JFrame {

    private String GenOrderId;
    private String custName;
    private boolean isExit = true;
    private double totalValue = 0.00;
    private final JPanel labelPanel;
    private final JLabel label;
    private final JPanel body;
    private final JPanel inputLabel;
    private final JLabel orderId;
    private final JLabel customerId;
    private final JLabel customerName;
    private final JLabel burgerQuantity;
    private final JLabel orderStatus;
    private final JPanel textBox;
    private final JPanel DOIdPanel;
    private final JLabel displayOrderId;
    private final JPanel inputCustIdPanel;
    private JLabel errorMessageCustId;
    private final JPanel inputCustNamePanel;
    private JTextField inputCustId;
    private JTextField inputCustName;
    private final JPanel inputQtyPanel;
    private JTextField inputBurgerQty;
    private JLabel errorMessageQty;
    private JLabel total;
    private final JPanel orderStatusPanel;
    private final JLabel orderStatusPREPARING;
    private final JPanel controllers;
    private JButton btnPlaceOrder;
    private JButton btnBack;
    private JButton btnCancel;
    private final JPanel totalPanel;
    private final JLabel totalLabel;
    private JButton btnOk;
    private JButton btnYESanother;
    private JButton btnNOanother;
    private JButton btnYES;
    private JButton btnNO;

    public PlaceOrder() {
        // generate order id
        GenOrderId = OrderController.generateId();

        // make window
        setSize(1100, 640);
        setTitle("Burger Shop - Place Order");
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
        label = new JLabel("Place Order", SwingConstants.CENTER);
        label.setBorder(BorderFactory.createMatteBorder(20, 10, 20, 10, OrderController.MainColor));
        label.setFont(new Font("", 1, 30));
        label.setForeground(Color.white);
        labelPanel.add(label, BorderLayout.CENTER);

        // body
        // body panel
        body = new JPanel();
        body.setLayout(new GridLayout(1, 3));

        // input label
        inputLabel = new JPanel();
        inputLabel.setLayout(new GridLayout(10, 1));
        inputLabel.setBackground(OrderController.whiteBack);

        JLabel empty1 = new JLabel("");
        inputLabel.add(empty1);
        JLabel empty2 = new JLabel("");
        inputLabel.add(empty2);

        orderId = new JLabel("ORDER ID :");
        orderId.setBorder(BorderFactory.createMatteBorder(0, 90, 0, 0, OrderController.whiteBack));
        orderId.setFont(new Font("", 1, 16));
        orderId.setForeground(OrderController.typography);
        inputLabel.add(orderId);

        customerId = new JLabel("Customer ID (phone no.) :");
        customerId.setBorder(BorderFactory.createMatteBorder(0, 90, 0, 0, OrderController.whiteBack));
        customerId.setFont(new Font("", 1, 16));
        customerId.setForeground(OrderController.typography);
        inputLabel.add(customerId);

        customerName = new JLabel("Customer Name :");
        customerName.setBorder(BorderFactory.createMatteBorder(0, 90, 0, 0, OrderController.whiteBack));
        customerName.setFont(new Font("", 1, 16));
        customerName.setForeground(OrderController.typography);
        inputLabel.add(customerName);

        burgerQuantity = new JLabel("Burger Quantity :");
        burgerQuantity.setBorder(BorderFactory.createMatteBorder(0, 90, 0, 0, OrderController.whiteBack));
        burgerQuantity.setFont(new Font("", 1, 16));
        burgerQuantity.setForeground(OrderController.typography);
        inputLabel.add(burgerQuantity);

        orderStatus = new JLabel("Order Status :");
        orderStatus.setBorder(BorderFactory.createMatteBorder(0, 90, 0, 0, OrderController.whiteBack));
        orderStatus.setFont(new Font("", 1, 16));
        orderStatus.setForeground(OrderController.typography);
        inputLabel.add(orderStatus);

        // text box
        textBox = new JPanel();
        textBox.setLayout(new GridLayout(10, 1, 0, 20));
        textBox.setBackground(OrderController.whiteBack);

        JLabel empty3 = new JLabel("");
        textBox.add(empty3);
        JLabel empty4 = new JLabel("");
        textBox.add(empty4);

        // display order id
        DOIdPanel = new JPanel();
        DOIdPanel.setLayout(new GridLayout(1, 1));
        DOIdPanel.setBackground(OrderController.whiteBack);
        DOIdPanel.setBorder(BorderFactory.createMatteBorder(10, 0, 0, 0, OrderController.whiteBack));

        displayOrderId = new JLabel(GenOrderId);
        displayOrderId.setFont(new Font("", 1, 16));
        displayOrderId.setForeground(OrderController.typography);

        DOIdPanel.add(displayOrderId);
        textBox.add(DOIdPanel);

        // input cust id
        inputCustIdPanel = new JPanel();
        inputCustIdPanel.setLayout(new GridLayout(1, 2));
        inputCustIdPanel.setBackground(OrderController.whiteBack);
        inputCustIdPanel.setBorder(BorderFactory.createMatteBorder(10, 0, 0, 100, OrderController.whiteBack));

        inputCustId = new JTextField(10);
        inputCustId.setFont(new Font("", 1, 16));
        inputCustId.setForeground(OrderController.typography);
        inputCustId.setText("");
        inputCustId.setBackground(OrderController.textBoxBackG);
        inputCustIdPanel.add(inputCustId);

        // cust id only numbers
        errorMessageCustId = new JLabel("");
        errorMessageCustId.setFont(new Font("", 1, 12));
        errorMessageCustId.setForeground(Color.red);

        inputCustIdPanel.add(errorMessageCustId);

        textBox.add(inputCustIdPanel);

        // input cust name
        inputCustNamePanel = new JPanel();
        inputCustNamePanel.setLayout(new GridLayout(1, 1));
        inputCustNamePanel.setBackground(OrderController.whiteBack);
        inputCustNamePanel.setBorder(BorderFactory.createMatteBorder(6, 0, 4, 150, OrderController.whiteBack));

        inputCustName = new JTextField(20);
        inputCustName.setFont(new Font("", 1, 16));
        inputCustName.setForeground(OrderController.typography);
        inputCustName.setText("");
        inputCustName.setBackground(OrderController.textBoxBackG);

        inputCustName.setEditable(false);

        inputCustNamePanel.add(inputCustName);
        textBox.add(inputCustNamePanel);

        // input qty
        inputQtyPanel = new JPanel();
        inputQtyPanel.setLayout(new GridLayout(1, 2));
        inputQtyPanel.setBackground(OrderController.whiteBack);
        inputQtyPanel.setBorder(BorderFactory.createMatteBorder(6, 0, 4, 100, OrderController.whiteBack));

        inputBurgerQty = new JTextField(2);
        inputBurgerQty.setFont(new Font("", 1, 16));
        inputBurgerQty.setForeground(OrderController.typography);
        inputBurgerQty.setText("");
        inputBurgerQty.setBackground(OrderController.textBoxBackG);
        inputQtyPanel.add(inputBurgerQty);

        inputBurgerQty.setEditable(false);

        errorMessageQty = new JLabel("");
        errorMessageQty.setFont(new Font("", 1, 12));
        errorMessageQty.setForeground(Color.red);

        inputQtyPanel.add(errorMessageQty);
        textBox.add(inputQtyPanel);

        // input validation
        // customer id
        inputCustId.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                String value = inputCustId.getText();
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
                    inputCustId.setEditable(true);
                    errorMessageCustId.setText("");

                } else {
                    inputCustId.setEditable(false);
                    if (l == 10) {
                        errorMessageCustId.setText("  * input 10 digits");
                    } else if (condition == false) {
                        errorMessageCustId.setText("  * Not a first digit==0");
                    } else {
                        errorMessageCustId.setText("  * only digits(0-9)");
                    }
                }

                if (l == 10) {
                    inputCustId.setEditable(false);
                }
            }
        });

        inputCustId.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String value = inputCustId.getText();
                int l = value.length();
                if (l == 10) {
                    if (OrderController.orList.size() > 0) {
                        for (int i = 0; i < OrderController.orList.size(); i++) {
                            String customerId = OrderController.orList.getCustomerId(i);
                            if (customerId.equals(value)) {
                                custName = OrderController.orList.getName(i);
                                isExit = false;
                                inputCustName.setEditable(false);
                                inputBurgerQty.setEditable(true);
                            }
                        }
                    }
                    inputCustName.setText(custName);
                    if (isExit) {
                        inputCustName.setEditable(true);
                        inputBurgerQty.setEditable(true);
                    }
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {}

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });

        // customer name
        inputCustName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                String value = inputCustName.getText();
                int l = value.length();
                if (l >= 0 && l < 16 || (int) ke.getKeyChar() == 8) {
                    inputCustName.setEditable(true);
                } else {
                    inputCustName.setEditable(false);
                }
            }
        });

        // burger qty
        inputBurgerQty.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                String value = inputBurgerQty.getText();
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
                    inputBurgerQty.setEditable(true);
                    errorMessageQty.setText("");
                } else {
                    inputBurgerQty.setEditable(false);

                    if (condition == false) {
                        errorMessageQty.setText("  * Not a Q==0");
                    } else if (l == 2) {
                        errorMessageQty.setText("  * only 2 digits");
                    } else {
                        errorMessageQty.setText("  * only digits(0-9)");
                    }
                }
            }
        });

        // total label
        total = new JLabel(OrderController.df.format(totalValue));
        inputBurgerQty.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String value = inputBurgerQty.getText();
                int l = value.length();

                if (l > 0) {
                    int qtyValue = Integer.parseInt(value);

                    totalValue = qtyValue * OrderDetails.BURGERPRICE;
                    total.setText(OrderController.df.format(totalValue));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String value = inputBurgerQty.getText();
                int l = value.length();

                if (l > 0) {
                    int qtyValue = Integer.parseInt(value);
                    totalValue = qtyValue * OrderDetails.BURGERPRICE;
                    total.setText(OrderController.df.format(totalValue));
                } else {
                    totalValue = 0 * OrderDetails.BURGERPRICE;
                    total.setText(OrderController.df.format(totalValue));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {}

        });

        // order status-Preparing
        orderStatusPanel = new JPanel();
        orderStatusPanel.setLayout(new GridLayout(1, 2));
        orderStatusPanel.setBackground(OrderController.whiteBack);
        orderStatusPanel.setBorder(BorderFactory.createMatteBorder(5, 0, 5, 0, OrderController.whiteBack));

        orderStatusPREPARING = new JLabel("Preparing...");
        orderStatusPREPARING.setFont(new Font("", 1, 16));
        orderStatusPREPARING.setForeground(OrderController.typography);

        orderStatusPanel.add(orderStatusPREPARING);

        JLabel empty10 = new JLabel("");
        orderStatusPanel.add(empty10);

        textBox.add(orderStatusPanel);

        // controllers
        controllers = new JPanel();
        controllers.setBackground(OrderController.whiteBack);
        controllers.setLayout(null);

        btnPlaceOrder = new JButton("Place Order");
        btnPlaceOrder.setBounds(50, 150, 210, 35);
        btnPlaceOrder.setFont(new Font("", 1, 16));
        btnPlaceOrder.setBackground(OrderController.SecondColor);
        btnPlaceOrder.setForeground(Color.white);
        btnPlaceOrder.setBorderPainted(false);
        btnPlaceOrder.setFocusPainted(false);
        controllers.add(btnPlaceOrder);

        btnPlaceOrder.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                btnPlaceOrder.setBackground(OrderController.OverSecond);
                btnPlaceOrder.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btnPlaceOrder.setBackground(OrderController.SecondColor);
            }

            @Override
            public void mousePressed(MouseEvent me) {
                btnPlaceOrder.setForeground(Color.black);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                btnPlaceOrder.setForeground(Color.white);
            }
        });

        btnBack = new JButton("Back to Home");
        btnBack.setBounds(50, 200, 210, 35);
        btnBack.setFont(new Font("", 1, 16));
        btnBack.setBackground(OrderController.MainColor);
        btnBack.setForeground(Color.white);
        btnBack.setBorderPainted(false);
        btnBack.setFocusPainted(false);
        controllers.add(btnBack);

        btnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                btnBack.setBackground(OrderController.OverMain);
                btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btnBack.setBackground(OrderController.MainColor);
            }

            @Override
            public void mousePressed(MouseEvent me) {
                btnBack.setForeground(Color.black);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                btnBack.setForeground(Color.white);
            }
        });

        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(50, 250, 210, 35);
        btnCancel.setFont(new Font("", 1, 16));
        btnCancel.setBackground(OrderController.MainColor);
        btnCancel.setForeground(Color.white);
        btnCancel.setBorderPainted(false);
        btnCancel.setFocusPainted(false);
        controllers.add(btnCancel);

        btnCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                btnCancel.setBackground(OrderController.OverMain);
                btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                btnCancel.setBackground(OrderController.MainColor);
            }

            @Override
            public void mousePressed(MouseEvent me) {
                btnCancel.setForeground(Color.black);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                btnCancel.setForeground(Color.white);
            }
        });

        // total panel
        totalPanel = new JPanel();
        totalPanel.setLayout(new FlowLayout());
        totalPanel.setBounds(50, 350, 210, 35);
        totalPanel.setBackground(OrderController.whiteBack);

        // total label name
        totalLabel = new JLabel("NET Total : ");
        totalLabel.setForeground(OrderController.typography);
        totalLabel.setFont(new Font("", 1, 16));

        // total label value styles
        total.setForeground(Color.red);
        total.setFont(new Font("", 1, 16));

        totalPanel.add(totalLabel);
        totalPanel.add(total);
        controllers.add(totalPanel);

        body.add(inputLabel);
        body.add(textBox);
        body.add(controllers);
        add(labelPanel, BorderLayout.NORTH);
        add(body, BorderLayout.CENTER);

        // btn action events
        // place order
        btnPlaceOrder.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                String custId = inputCustId.getText();
                int custIdLength = custId.length();
                String name1 = inputCustName.getText();
                int nameLength = name1.length();
                String qty = inputBurgerQty.getText();
                int qtyLength = qty.length();
                int sta = OrderDetails.PREPARING;
                
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
                        new PlaceOrder().setVisible(true);
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

                // yes/no buttons
                // yes
                btnYES = new JButton("YES");
                btnYES.setFont(new Font("", 1, 16));
                btnYES.setBackground(OrderController.SecondColor);
                btnYES.setForeground(Color.white);
                btnYES.setBorderPainted(false);
                btnYES.setFocusPainted(false);
                btnYES.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent me) {
                        btnYES.setBackground(OrderController.OverSecond);
                        btnYES.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    }

                    @Override
                    public void mouseExited(MouseEvent me) {
                        btnYES.setBackground(OrderController.SecondColor);
                    }

                    @Override
                    public void mousePressed(MouseEvent me) {
                        btnYES.setForeground(Color.black);
                    }

                    @Override
                    public void mouseReleased(MouseEvent me) {
                        btnYES.setForeground(Color.white);
                    }
                });
                btnYES.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        int qtyINT = Integer.parseInt(qty);
                        OrderController.orList.add(new OrderDetails(GenOrderId, custId, name1, qtyINT, sta));
                        JOptionPane.showOptionDialog(null, "Your " + GenOrderId + " order is enter to the system successfully...", "Success Message", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, OrderController.successIcon, btnOkCustom, btnOkCustom[0]);
                        JOptionPane.showOptionDialog(null, "Do you want to place another order?", "Another Option", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, OrderController.questionIcon, btnYESorNOanotherCustom, btnYESorNOanotherCustom[0]);
                        JOptionPane.getRootFrame().dispose();
                    }
                });
                // no
                btnNO = new JButton("NO");
                btnNO.setFont(new Font("", 1, 16));
                btnNO.setBackground(OrderController.MainColor);
                btnNO.setForeground(Color.white);
                btnNO.setBorderPainted(false);
                btnNO.setFocusPainted(false);
                btnNO.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent me) {
                        btnNO.setBackground(OrderController.OverMain);
                        btnNO.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    }

                    @Override
                    public void mouseExited(MouseEvent me) {
                        btnNO.setBackground(OrderController.MainColor);
                    }

                    @Override
                    public void mousePressed(MouseEvent me) {
                        btnNO.setForeground(Color.black);
                    }

                    @Override
                    public void mouseReleased(MouseEvent me) {
                        btnNO.setForeground(Color.white);
                    }
                });
                btnNO.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        JOptionPane.showOptionDialog(null, "Do you want to place another order?", "Another Option", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, OrderController.questionIcon, btnYESorNOanotherCustom, btnYESorNOanotherCustom[0]);
                        JOptionPane.getRootFrame().dispose();
                    }
                });
                JButton[] btnYESorNOCustom = {btnYES, btnNO};
                if (custIdLength == 10 & nameLength > 0 & qtyLength > 0) {
                    JOptionPane.showOptionDialog(null, "Are you confirm order?", "Order Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, OrderController.questionIcon, btnYESorNOCustom, btnYESorNOCustom[0]);
                } else {
                    JOptionPane.showOptionDialog(null, "Please input order details!", "Place Order", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, OrderController.errorIcon, btnOkCustom, btnOkCustom[0]);
                }
            }
        });

        // back to home
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new HomePage().setVisible(true);
                setVisible(false);
            }
        });

        // cancel
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                inputCustId.setText("");
                inputCustName.setText("");
                inputBurgerQty.setText("");
                inputCustId.setEditable(true);
                inputCustName.setEditable(false);
                inputBurgerQty.setEditable(false);
            }
        });
    }
}
