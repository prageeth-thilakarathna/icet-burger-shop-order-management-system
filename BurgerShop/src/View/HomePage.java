/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.OrderController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author ygpra
 */
public class HomePage extends JFrame {

    private Image img;
    private JButton BtnPlaceOrder;
    private JButton BtnSearchBestCustomer;
    private JButton BtnSearchOrder;
    private JButton BtnSearchCustomer;
    private JButton BtnViewOrders;
    private JButton BtnUpdateOrderDetails;
    private JButton BtnExit;
    private final JPanel banner;
    private final JLabel label;

    public HomePage() {
        setSize(1100, 640);
        setTitle("Burger Shop - Home");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setResizable(false);
        setLayout(new GridLayout(1, 2));
        
        // set image icon
        setIconImage(OrderController.favicon);

        // banner
        banner = new JPanel();
        banner.setLayout(new BorderLayout());
        banner.setBackground(Color.white);

        // add label
        label = new JLabel("Welcome to iHungry Burger Shop", SwingConstants.CENTER);
        label.setBorder(BorderFactory.createMatteBorder(50, 10, 10, 10, Color.white));
        label.setFont(new Font("", 1, 30));
        Color myLabelColor = new Color(229, 86, 4);
        label.setForeground(myLabelColor);
        banner.add(label, BorderLayout.NORTH);

        // add image
        MyCanvas img = new MyCanvas();
        banner.add(img, BorderLayout.CENTER);

        // nav links
        JPanel navLink = new JPanel();
        navLink.setLayout(null);
        navLink.setBackground(OrderController.headerColor);

        BtnPlaceOrder = new JButton("Place Order");
        BtnPlaceOrder.setBounds(125, 120, 300, 35);
        BtnPlaceOrder.setFont(new Font("", 1, 16));
        BtnPlaceOrder.setBackground(OrderController.MainColor);
        BtnPlaceOrder.setForeground(Color.white);
        BtnPlaceOrder.setBorderPainted(false);
        BtnPlaceOrder.setFocusPainted(false);
        navLink.add(BtnPlaceOrder);

        BtnPlaceOrder.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                BtnPlaceOrder.setBackground(OrderController.OverMain);
                BtnPlaceOrder.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                BtnPlaceOrder.setBackground(OrderController.MainColor);
            }

            @Override
            public void mousePressed(MouseEvent me) {
                BtnPlaceOrder.setForeground(Color.black);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                BtnPlaceOrder.setForeground(Color.white);
            }
        });

        BtnSearchBestCustomer = new JButton("Search Best Customer");
        BtnSearchBestCustomer.setBounds(125, 180, 300, 35);
        BtnSearchBestCustomer.setFont(new Font("", 1, 16));
        BtnSearchBestCustomer.setBackground(OrderController.MainColor);
        BtnSearchBestCustomer.setForeground(Color.white);
        BtnSearchBestCustomer.setBorderPainted(false);
        BtnSearchBestCustomer.setFocusPainted(false);
        navLink.add(BtnSearchBestCustomer);

        BtnSearchBestCustomer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                BtnSearchBestCustomer.setBackground(OrderController.OverMain);
                BtnSearchBestCustomer.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                BtnSearchBestCustomer.setBackground(OrderController.MainColor);
            }

            @Override
            public void mousePressed(MouseEvent me) {
                BtnSearchBestCustomer.setForeground(Color.black);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                BtnSearchBestCustomer.setForeground(Color.white);
            }
        });

        BtnSearchOrder = new JButton("Search Order");
        BtnSearchOrder.setBounds(125, 240, 300, 35);
        BtnSearchOrder.setFont(new Font("", 1, 16));
        BtnSearchOrder.setBackground(OrderController.MainColor);
        BtnSearchOrder.setForeground(Color.white);
        BtnSearchOrder.setBorderPainted(false);
        BtnSearchOrder.setFocusPainted(false);
        navLink.add(BtnSearchOrder);

        BtnSearchOrder.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                BtnSearchOrder.setBackground(OrderController.OverMain);
                BtnSearchOrder.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                BtnSearchOrder.setBackground(OrderController.MainColor);
            }

            @Override
            public void mousePressed(MouseEvent me) {
                BtnSearchOrder.setForeground(Color.black);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                BtnSearchOrder.setForeground(Color.white);
            }
        });

        BtnSearchCustomer = new JButton("Search Customer");
        BtnSearchCustomer.setBounds(125, 300, 300, 35);
        BtnSearchCustomer.setFont(new Font("", 1, 16));
        BtnSearchCustomer.setBackground(OrderController.MainColor);
        BtnSearchCustomer.setForeground(Color.white);
        BtnSearchCustomer.setBorderPainted(false);
        BtnSearchCustomer.setFocusPainted(false);
        navLink.add(BtnSearchCustomer);

        BtnSearchCustomer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                BtnSearchCustomer.setBackground(OrderController.OverMain);
                BtnSearchCustomer.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                BtnSearchCustomer.setBackground(OrderController.MainColor);
            }

            @Override
            public void mousePressed(MouseEvent me) {
                BtnSearchCustomer.setForeground(Color.black);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                BtnSearchCustomer.setForeground(Color.white);
            }
        });

        BtnViewOrders = new JButton("View Orders");
        BtnViewOrders.setBounds(125, 360, 300, 35);
        BtnViewOrders.setFont(new Font("", 1, 16));
        BtnViewOrders.setBackground(OrderController.MainColor);
        BtnViewOrders.setForeground(Color.white);
        BtnViewOrders.setBorderPainted(false);
        BtnViewOrders.setFocusPainted(false);
        navLink.add(BtnViewOrders);

        BtnViewOrders.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                BtnViewOrders.setBackground(OrderController.OverMain);
                BtnViewOrders.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                BtnViewOrders.setBackground(OrderController.MainColor);
            }

            @Override
            public void mousePressed(MouseEvent me) {
                BtnViewOrders.setForeground(Color.black);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                BtnViewOrders.setForeground(Color.white);
            }
        });

        BtnUpdateOrderDetails = new JButton("Update Order Details");
        BtnUpdateOrderDetails.setBounds(125, 420, 300, 35);
        BtnUpdateOrderDetails.setFont(new Font("", 1, 16));
        BtnUpdateOrderDetails.setBackground(OrderController.MainColor);
        BtnUpdateOrderDetails.setForeground(Color.white);
        BtnUpdateOrderDetails.setBorderPainted(false);
        BtnUpdateOrderDetails.setFocusPainted(false);
        navLink.add(BtnUpdateOrderDetails);

        BtnUpdateOrderDetails.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                BtnUpdateOrderDetails.setBackground(OrderController.OverMain);
                BtnUpdateOrderDetails.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                BtnUpdateOrderDetails.setBackground(OrderController.MainColor);
            }

            @Override
            public void mousePressed(MouseEvent me) {
                BtnUpdateOrderDetails.setForeground(Color.black);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                BtnUpdateOrderDetails.setForeground(Color.white);
            }
        });

        BtnExit = new JButton("Exit");
        BtnExit.setBounds(430, 540, 80, 35);
        BtnExit.setFont(new Font("", 1, 16));
        BtnExit.setBackground(OrderController.MainColor);
        BtnExit.setForeground(Color.white);
        BtnExit.setBorderPainted(false);
        BtnExit.setFocusPainted(false);
        navLink.add(BtnExit);

        BtnExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                BtnExit.setBackground(OrderController.OverMain);
                BtnExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                BtnExit.setBackground(OrderController.MainColor);
            }

            @Override
            public void mousePressed(MouseEvent me) {
                BtnExit.setForeground(Color.black);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                BtnExit.setForeground(Color.white);
            }
        });

        // button action events
        BtnExit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });

        BtnPlaceOrder.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                new PlaceOrder().setVisible(true);
                setVisible(false);
            }
        });

        BtnSearchOrder.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                new SearchOrder().setVisible(true);
                setVisible(false);
            }
        });

        BtnSearchCustomer.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                new SearchCustomer().setVisible(true);
                setVisible(false);
            }
        });

        BtnUpdateOrderDetails.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                new UpdateOrder().setVisible(true);
                setVisible(false);
            }
        });
        
        BtnSearchBestCustomer.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                new BestCustomer().setVisible(true);
                setVisible(false);
            }
        });
        
        BtnViewOrders.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                new ViewOrders().setVisible(true);
                setVisible(false);
            }
        });

        add("West", banner);
        add("East", navLink);
    }
}
